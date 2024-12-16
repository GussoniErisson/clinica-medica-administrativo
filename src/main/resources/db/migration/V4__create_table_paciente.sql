CREATE TABLE pacientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    sexo CHAR(1) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(255),
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    contato VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL
);