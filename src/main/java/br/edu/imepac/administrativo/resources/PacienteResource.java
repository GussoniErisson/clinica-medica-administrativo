package br.edu.imepac.administrativo.resources;

import br.edu.imepac.administrativo.dtos.Paciente.PacienteCreateDTO;
import br.edu.imepac.administrativo.dtos.Paciente.PacienteDTO;
import br.edu.imepac.administrativo.dtos.Paciente.PacienteUpdateDTO;
import br.edu.imepac.administrativo.service.PacienteService;
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
@RequestMapping("/api/pacientes")
public class PacienteResource {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteResource(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Listar todos os pacientes", description = "Obtém todos os pacientes disponíveis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pacientes retornada com sucesso")
    })
    @GetMapping
    @ResponseStatus(OK)
    public List<PacienteDTO> listarTodos() {
        log.info("Listando todos os pacientes.");
        return pacienteService.findAll();
    }

    @Operation(summary = "Buscar paciente por ID", description = "Obtém um paciente específico pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente encontrado"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado")
    })
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PacienteDTO buscarPorId(@Parameter(description = "ID do paciente", required = true) @PathVariable Long id) {
        log.info("Buscando paciente com ID: {}", id);
        return pacienteService.findById(id);
    }

    @Operation(summary = "Salvar um novo paciente", description = "Cria um novo paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @ResponseStatus(CREATED)
    public PacienteDTO salvar(@RequestBody @Parameter(description = "Dados do paciente a ser criado") PacienteCreateDTO pacienteCreateDto) {
        log.info("Tentando salvar um novo paciente: {}", pacienteCreateDto.getNome());
        return pacienteService.save(pacienteCreateDto);
    }

    @Operation(summary = "Atualizar um paciente existente", description = "Atualiza os dados de um paciente existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado")
    })
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public PacienteDTO atualizar(@Parameter(description = "ID do paciente", required = true) @PathVariable Long id,
                                 @RequestBody @Parameter(description = "Dados do paciente a ser atualizado") PacienteUpdateDTO pacienteUpdateDto) {
        log.info("Atualizando paciente com ID: {}", id);
        return pacienteService.update(id, pacienteUpdateDto);
    }

    @Operation(summary = "Remover um paciente por ID", description = "Deleta um paciente com base no seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Paciente removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void remover(@Parameter(description = "ID do paciente", required = true) @PathVariable Long id) {
        log.info("Removendo paciente com ID: {}", id);
        pacienteService.delete(id);
    }
}