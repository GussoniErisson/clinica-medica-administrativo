CREATE TABLE Paciente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    sexo CHAR(1) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    rua VARCHAR(255),
    numero VARCHAR(20),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(2),
    contato VARCHAR(20),
    email VARCHAR(255),
    dataNascimento DATE
);