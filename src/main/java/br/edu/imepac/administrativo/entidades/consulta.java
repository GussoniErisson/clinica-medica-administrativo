package br.edu.imepac.administrativo.entidades;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class consulta {


    private long id;

    private LocalDateTime dataHorario;

    private String sintomas;

    private boolean eRetorno;

    private boolean estaAtiva;
}
