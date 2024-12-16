CREATE TABLE funcionarios
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario          VARCHAR(50)        NOT NULL,
    senha            INT                NOT NULL,
    nome             VARCHAR(100)       NOT NULL,
    tipo_funcionario VARCHAR(50)        NOT NULL,
    idade            INT                NOT NULL,
    sexo             VARCHAR(10),
    cpf              VARCHAR(14) UNIQUE NOT NULL,
    rua              VARCHAR(100),
    numero           INT,
    complemento      VARCHAR(100),
    bairro           VARCHAR(50),
    cidade           VARCHAR(50),
    estado           VARCHAR(2),
    contato          VARCHAR(15),
    email            VARCHAR(100) UNIQUE,
    data_nascimento  DATE,
    perfil_id        BIGINT,
    especialidade_id BIGINT,

    CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES perfis (id),
    CONSTRAINT fk_especialidade FOREIGN KEY (especialidade_id) REFERENCES especialidades (id)
);