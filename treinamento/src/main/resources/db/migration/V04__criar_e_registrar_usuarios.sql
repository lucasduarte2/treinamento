CREATE TABLE usuario(
	codigo BIGINT(20) PRIMARY KEY,
	nome VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (codigo, nome, email, senha) 
VALUES (1, "Juan", "admin@admin.com", "$2a$10$fwSispBLsg6.4sr6v.4y0.5o4PzZCVw78sYpAWAZs.jC4gFL9TDQG");