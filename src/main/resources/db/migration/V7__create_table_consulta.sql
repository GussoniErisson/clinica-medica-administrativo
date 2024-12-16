CREATE TABLE IF NOT EXISTS consultas
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_horario  TIMESTAMP,
    sintomas      VARCHAR(255),
    e_retorno     BOOLEAN,
    esta_ativa    BOOLEAN,
    medico_id     BIGINT,
    atendente_id  BIGINT,
    paciente_id   BIGINT,
    prontuario_id INT,
    convenio_id   BIGINT,
    FOREIGN KEY (medico_id) REFERENCES funcionarios (id),
    FOREIGN KEY (atendente_id) REFERENCES funcionarios (id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes (id),
    FOREIGN KEY (prontuario_id) REFERENCES prontuarios (id),
    FOREIGN KEY (convenio_id) REFERENCES convenios (id)
);