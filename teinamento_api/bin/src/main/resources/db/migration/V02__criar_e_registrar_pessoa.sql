CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL,
    logradouro VARCHAR(50),
	numero VARCHAR(50),
	complemento VARCHAR(50),
	bairro VARCHAR(50),
	cep VARCHAR(50),
	cidade VARCHAR(50),
	estado VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Lucas', true, "null", 10, "null", "sao sebastiao", "58125000", "alagoa nova", "paraiba");

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Maiara', true, "null", 10, "null", "sao sebastiao", "58125000", "alagoa nova", "paraiba");

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Michelle', true, "null", 10, "null", "sao sebastiao", "58125000", "alagoa nova", "paraiba");

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Andre', true, "null", 10, "null", "sao sebastiao", "58125000", "alagoa nova", "paraiba");

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('outro lucas', true, "null", 10, "null", "sao sebastiao", "58125000", "alagoa nova", "paraiba");