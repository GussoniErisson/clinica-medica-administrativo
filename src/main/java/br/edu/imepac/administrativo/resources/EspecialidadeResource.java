package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeCreateDTO;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeDTO;
import br.edu.imepac.administrativo.dtos.Especialidade.EspecialidadeUptadeDTO;
import br.edu.imepac.administrativo.service.EspecialidadeService;
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
@RequestMapping("/api/especialidades")
public class EspecialidadeResource {

    private final EspecialidadeService especialidadeService;

    @Autowired
    public EspecialidadeResource(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @Operation(summary = "Listar todas as especialidades", description = "Obtém uma lista de todas as especialidades disponíveis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de especialidades retornada com sucesso")
    })
    @GetMapping
    @ResponseStatus(OK)
    public List<EspecialidadeDTO> listarTodas() {
        log.info("Listando todas as especialidades.");
        return especialidadeService.listarTodas();
    }

    @Operation(summary = "Buscar especialidade por ID", description = "Obtém os dados de uma especialidade específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidade encontrada"),
            @ApiResponse(responseCode = "404", description = "Especialidade não encontrada")
    })
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public EspecialidadeDTO buscarPorId(@Parameter(description = "ID da especialidade", required = true) @PathVariable Long id) {
        log.info("Buscando especialidade com ID: {}", id);
        return especialidadeService.buscarPorId(id);
    }

    @Operation(summary = "Salvar uma nova especialidade", description = "Cria uma nova especialidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Especialidade criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @ResponseStatus(CREATED)
    public EspecialidadeDTO salvar(@RequestBody @Parameter(description = "Dados da especialidade a ser criada") EspecialidadeCreateDTO especialidadeCreateDto) {
        log.info("Tentando salvar uma nova especialidade: {}", especialidadeCreateDto.getNome());
        return especialidadeService.salvar(especialidadeCreateDto);
    }

    @Operation(summary = "Atualizar uma especialidade existente", description = "Atualiza os dados de uma especialidade existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidade atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidade não encontrada")
    })
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public EspecialidadeDTO atualizar(@Parameter(description = "ID da especialidade", required = true) @PathVariable Long id,
                                      @RequestBody @Parameter(description = "Dados da especialidade a ser atualizada") EspecialidadeUptadeDTO especialidadeUpdateDto) {
        log.info("Atualizando especialidade com ID: {}", id);
        return especialidadeService.atualizar(id, especialidadeUpdateDto);
    }

    @Operation(summary = "Remover uma especialidade por ID", description = "Deleta uma especialidade com base no seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Especialidade removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidade não encontrada")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void remover(@Parameter(description = "ID da especialidade", required = true) @PathVariable Long id) {
        log.info("Removendo especialidade com ID: {}", id);
        especialidadeService.remover(id);
    }
}