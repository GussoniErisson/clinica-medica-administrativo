package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.dtos.Convenio.ConvenioCreateDTO;
import br.edu.imepac.administrativo.dtos.Convenio.ConvenioDTO;
import br.edu.imepac.administrativo.dtos.Convenio.ConvenioUpdateDTO;
import br.edu.imepac.administrativo.service.ConvenioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping("/api/convenios")
public class ConvenioResource {

    private final ConvenioService convenioService;

    @Autowired
    public ConvenioResource(ConvenioService convenioService) {
        this.convenioService = convenioService;
    }

    @Operation(summary = "Listar todos os convênios", description = "Obtém todos os convênios disponíveis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de convênios retornada com sucesso")
    })
    @GetMapping
    @ResponseStatus(OK)
    public List<ConvenioDTO> listarTodos() {
        log.info("Listando todos os convênios.");
        return convenioService.listarTodos();
    }

    @Operation(summary = "Buscar convênio por ID", description = "Obtém um convênio específico pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Convênio encontrado"),
            @ApiResponse(responseCode = "404", description = "Convênio não encontrado")
    })
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ConvenioDTO buscarPorId(@Parameter(description = "ID do convênio", required = true) @PathVariable Long id) {
        log.info("Buscando convênio com ID: {}", id);
        return convenioService.buscarPorId(id);
    }

    @Operation(summary = "Salvar um novo convênio", description = "Cria um novo convênio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Convênio criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @ResponseStatus(CREATED)
    public ConvenioDTO salvar(@RequestBody @Parameter(description = "Dados do convênio a ser criado") ConvenioCreateDTO convenioCreateDto) {
        log.info("Tentando salvar um novo convênio: {}", convenioCreateDto.getNome());
        return convenioService.salvar(convenioCreateDto);
    }

    @Operation(summary = "Atualizar um convênio existente", description = "Atualiza os dados de um convênio existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Convênio atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Convênio não encontrado")
    })
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public ConvenioDTO atualizar(@Parameter(description = "ID do convênio", required = true) @PathVariable Long id,
                                 @RequestBody @Parameter(description = "Dados do convênio a ser atualizado") ConvenioUpdateDTO convenioUpdateDto) {
        log.info("Atualizando convênio com ID: {}", id);
        return convenioService.atualizar(id, convenioUpdateDto);
    }

    @Operation(summary = "Remover um convênio por ID", description = "Deleta um convênio com base no seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Convênio removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Convênio não encontrado")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void remover(@Parameter(description = "ID do convênio", required = true) @PathVariable Long id) {
        log.info("Removendo convênio com ID: {}", id);
        convenioService.remover(id);
    }
}