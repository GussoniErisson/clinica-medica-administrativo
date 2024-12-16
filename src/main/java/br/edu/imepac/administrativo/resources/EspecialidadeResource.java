package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeCreateDto;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeDto;
import br.edu.imepac.administrativo.service.EspecialidadeService;
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
@RequestMapping("/api/especialidades")
public class EspecialidadeResource {

    private final EspecialidadeService especialidadeService;

    private static final Logger logger = LoggerFactory.getLogger(EspecialidadeResource.class);

    @Autowired
    public EspecialidadeResource(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @Operation(summary = "Listar todas as especialidades", description = "Obtém uma lista de todas as especialidades disponíveis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de especialidades retornada com sucesso")
    })
    @GetMapping
    public List<EspecialidadeDto> listarTodas() {
        logger.info("Listando todas as especialidades");
        List<EspecialidadeDto> especialidades = especialidadeService.listarTodas();
        logger.info("Total de especialidades encontradas: {}", especialidades.size());
        return especialidades;
    }

    @Operation(summary = "Buscar especialidade por ID", description = "Obtém os dados de uma especialidade específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidade encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidade não encontrada")
    })
    @GetMapping("/{id}")
    public EspecialidadeDto buscarPorId(
            @Parameter(description = "ID da especialidade a ser buscada", required = true) @PathVariable Long id) {
        logger.info("Buscando especialidade com ID: {}", id);
        try {
            EspecialidadeDto especialidade = especialidadeService.buscarPorId(id);
            logger.info("Especialidade encontrada: {}", especialidade.getNome());
            return especialidade;
        } catch (ResponseStatusException e) {
            logger.error("Especialidade não encontrada com ID: {}", id, e);
            throw e;
        }
    }

    @Operation(summary = "Salvar uma nova especialidade", description = "Cria e salva uma nova especialidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Especialidade criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EspecialidadeDto salvar(
            @Parameter(description = "Dados da especialidade a ser criada", required = true) @RequestBody EspecialidadeCreateDto especialidadeCreateDto
    ) {
        logger.info("Salvando nova especialidade: {}", especialidadeCreateDto.getNome());
        if (especialidadeCreateDto.getNome() == null || especialidadeCreateDto.getNome().isEmpty()) {
            logger.warn("Nome da especialidade não fornecido");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome da especialidade é obrigatório");
        }
        EspecialidadeDto especialidadeDto = especialidadeService.salvar(especialidadeCreateDto);
        logger.info("Especialidade salva com sucesso: {}", especialidadeDto.getNome());
        return especialidadeDto;
    }

    @Operation(summary = "Atualizar uma especialidade existente", description = "Atualiza os dados de uma especialidade com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidade atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Especialidade não encontrada")
    })
    @PutMapping("/{id}")
    public EspecialidadeDto atualizar(
            @Parameter(description = "ID da especialidade a ser atualizada", required = true) @PathVariable Long id,
            @Parameter(description = "Novos dados da especialidade", required = true) @RequestBody EspecialidadeCreateDto especialidadeCreateDto) {
        logger.info("Atualizando especialidade com ID: {}", id);
        if (especialidadeCreateDto.getNome() == null || especialidadeCreateDto.getNome().isEmpty()) {
            logger.warn("Nome da especialidade não fornecido");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome da especialidade é obrigatório");
        }
        EspecialidadeDto especialidadeDto = especialidadeService.atualizar(id, especialidadeCreateDto);
        logger.info("Especialidade atualizada com sucesso: {}", especialidadeDto.getNome());
        return especialidadeDto;
    }

    @Operation(summary = "Remover uma especialidade por ID", description = "Remove uma especialidade com base no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Especialidade removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidade não encontrada")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(
            @Parameter(description = "ID da especialidade a ser removida", required = true) @PathVariable Long id) {
        logger.info("Removendo especialidade com ID: {}", id);
        try {
            especialidadeService.remover(id);
            logger.info("Especialidade removida com sucesso: {}", id);
        } catch (ResponseStatusException e) {
            logger.error("Erro ao remover especialidade com ID: {}", id, e);
            throw e;
        }
    }
}