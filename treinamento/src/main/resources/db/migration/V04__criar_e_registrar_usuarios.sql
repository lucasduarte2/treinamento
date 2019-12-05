CREATE TABLE usuario(
	codigo BIGINT(20) PRIMARY KEY,
	nome VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (codigo, nome, email, senha) 
VALUES (2, "lucas", "lucas@gmail.com", "$2a$10$/dXnVWAq.dDv2N05gGXlJeGpJ5jaxc2IMgz7fwvhwlezJp7CZA.zu");