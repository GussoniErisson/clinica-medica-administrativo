package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.dtos.Convenio.ConvenioCreateDto;
import br.edu.imepac.administrativo.dtos.Convenio.ConvenioDto;
import br.edu.imepac.administrativo.service.ConvenioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Configuration
@Slf4j
@RestController
@RequestMapping("/api/convenios")

public class ConvenioResource {
    private final ConvenioService convenioService;


    private static final Logger logger = LoggerFactory.getLogger(ConvenioResource.class);

    @Autowired
    public ConvenioResource(ConvenioService convenioService) {
        this.convenioService = convenioService;
    }

    @Operation(summary = "Listar todos os convênios", description = "Obtém todos os convênios disponíveis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de convênios retornada com sucesso")
    })
    @GetMapping
    public List<ConvenioDto> listarTodos() {
        logger.info("Listando todos os convênios.");
        List<ConvenioDto> convenios = convenioService.listarTodos();
        logger.info("Total de convênios encontrados: {}", convenios.size());
        return convenios;
    }

    @Operation(summary = "Buscar convênio por ID", description = "Obtém um convênio específico pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Convênio encontrado"),
            @ApiResponse(responseCode = "404", description = "Convênio não encontrado")
    })
    @GetMapping("/{id}")
    public ConvenioDto buscarPorId(@Parameter(description = "ID do convênio", required = true) @PathVariable Long id) {
        logger.info("Buscando convênio com ID: {}", id);
        try {
            ConvenioDto convenio = convenioService.buscarPorId(id);
            logger.info("Convênio encontrado: {}", convenio.getNome());
            return convenio;
        } catch (ResponseStatusException e) {
            logger.error("Convênio não encontrado com ID: {}", id, e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado com o ID " + id, e);
        }
    }

    @Operation(summary = "Salvar um novo convênio", description = "Cria um novo convênio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Convênio criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConvenioDto salvar(@RequestBody @Parameter(description = "Dados do convênio a ser criado") ConvenioCreateDto convenioCreateDto) {
        logger.info("Tentando salvar um novo convênio: {}", convenioCreateDto.getNome());

        if (convenioCreateDto.getNome() == null || convenioCreateDto.getNome().isEmpty()) {
            logger.warn("Nome do convênio não fornecido!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome do convênio é obrigatório");
        }

        ConvenioDto convenioDto = convenioService.salvar(convenioCreateDto);
        logger.info("Convênio salvo com sucesso: {}", convenioDto.getNome());
        return convenioDto;
    }

    @Operation(summary = "Atualizar um convênio existente", description = "Atualiza os dados de um convênio existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Convênio atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Convênio não encontrado")
    })
    @PutMapping("/{id}")
    public ConvenioDto atualizar(@Parameter(description = "ID do convênio", required = true) @PathVariable Long id,
                                 @RequestBody @Parameter(description = "Dados do convênio a ser atualizado") ConvenioCreateDto convenioCreateDto) {
        logger.info("Atualizando convênio com ID: {}", id);

        if (convenioCreateDto.getNome() == null || convenioCreateDto.getNome().isEmpty()) {
            logger.warn("Nome do convênio não fornecido para atualização.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome do convênio é obrigatório");
        }

        ConvenioDto convenioDto = convenioService.atualizar(id, convenioCreateDto);
        logger.info("Convênio atualizado com sucesso: {}", convenioDto.getNome());
        return convenioDto;
    }

    @Operation(summary = "Remover um convênio por ID", description = "Deleta um convênio com base no seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Convênio removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Convênio não encontrado")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@Parameter(description = "ID do convênio", required = true) @PathVariable Long id) {
        logger.info("Removendo convênio com ID: {}", id);
        try {
            convenioService.remover(id);
            logger.info("Convênio removido com sucesso: {}", id);
        } catch (ResponseStatusException e) {
            logger.error("Erro ao tentar remover convênio com ID: {}", id, e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado com o ID " + id, e);
        }
    }
}