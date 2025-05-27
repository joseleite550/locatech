CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    ano INT,
    cor VARCHAR(255),
    valor_diaria DECIMAL(10,2)
);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria) VALUES
('Chevrolet', 'Celta', 'ABC-1234', 2010, 'preta', 100.00);

CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO pessoas (nome, cpf, telefone, email) VALUES
('José', '12345612302', '19999999999','jose.franklin550@gmail.com');