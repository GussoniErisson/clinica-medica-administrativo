CREATE TABLE Funcionario
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL,
    senha INT NOT NULL,
    idPaciente INT,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    sexo VARCHAR(10),
    cpf VARCHAR(14) UNIQUE NOT NULL,
    rua VARCHAR(100),
    numero INT,
    complemento VARCHAR(100),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    estado  VARCHAR(2),
    contato VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    dataNascimento DATE
);
