/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Samuel
 * Created: 25 de ago. de 2026
 */

CREATE TABLE filmes (
id SERIAL PRIMARY KEY,
titulo VARCHAR(255) NOT NULL,
genero VARCHAR(100) NOT NULL,
ano_lancamento INTEGER NOT NULL,
diretor VARCHAR(255) NOT NULL,
duracao INTEGER NOT NULL, --Duração em minutos // facilitar validações--
classificacao VARCHAR(20) NOT NULL
);

CREATE TABLE series (
id SERIAL PRIMARY KEY,
titulo VARCHAR(255) NOT NULL,
genero VARCHAR(100) NOT NULL,
ano_lancamento INTEGER NOT NULL,
temporadas INTEGER NOT NULL,
episodios INTEGER NOT NULL,
produtora VARCHAR (255) NOT NULL
);

CREATE TABLE animes (
id SERIAL PRIMARY KEY,
titulo VARCHAR(255) NOT NULL,
genero VARCHAR(100) NOT NULL,
ano_lancamento INTEGER NOT NULL,
estudio VARCHAR(255) NOT NULL,
tem_manga BOOLEAN NOT NULL,
dublado BOOLEAN NOT NULL
);

CREATE TABLE elenco (
id SERIAL PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
nacionalidade VARCHAR(100),
dt_nascimento DATE
);

CREATE TABLE filme_elenco ( --tabela N para N--
filme_id INTEGER NOT NULL,
elenco_id INTEGER NOT NULL,

PRIMARY KEY (filme_id, elenco_id), -- faz com que a mesma assoc. não possa ser cadastrada 2 vezes --

FOREIGN KEY (filme_id) REFERENCES filmes(id) ON DELETE CASCADE, -- evitar problemas com deletes de registros  dependentes--
FOREIGN KEY (elenco_id) REFERENCES elenco (id) ON DELETE CASCADE

);

CREATE TABLE serie_elenco ( --tabela N para N--
serie_id INTEGER NOT NULL,
elenco_id INTEGER NOT NULL,

PRIMARY KEY (serie_id, elenco_id), -- faz com que a mesma assoc. não possa ser cadastrada 2 vezes --

FOREIGN KEY (serie_id) REFERENCES series(id) ON DELETE CASCADE, -- evitar problemas com deletes de registros  dependentes--
FOREIGN KEY (elenco_id) REFERENCES elenco (id) ON DELETE CASCADE

);

CREATE TABLE anime_elenco ( --tabela N para N--
anime_id INTEGER NOT NULL,
elenco_id INTEGER NOT NULL,

PRIMARY KEY (anime_id, elenco_id), -- faz com que a mesma assoc. não possa ser cadastrada 2 vezes --

FOREIGN KEY (anime_id) REFERENCES animes(id) ON DELETE CASCADE, -- evitar problemas com deletes de registros  dependentes--
FOREIGN KEY (elenco_id) REFERENCES elenco (id) ON DELETE CASCADE

);

