CREATE TABLE prontuarios
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    receituario VARCHAR(255) NOT NULL,
    exames      VARCHAR(255),
    observacoes VARCHAR(255)
);