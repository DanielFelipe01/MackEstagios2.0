CREATE TABLE usuario(
    idUsuario INTEGER NOT NULL,
    email VARCHAR(80) NOT NULL,
    senha VARCHAR(15) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    PRIMARY KEY (idUsuario)
);

CREATE TABLE formacao(
    idFormacao INTEGER NOT NULL,
    curso VARCHAR(20) NOT NULL,
    semestre INTEGER NOT NULL,
    faculdade VARCHAR(40) NOT NULL,
    unidade VARCHAR(50) NOT NULL,
    PRIMARY KEY (idFormacao)
);

CREATE TABLE endereco(
    idEndereco INTEGER NOT NULL,
    rua VARCHAR(50) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    numero INTEGER NOT NULL,
    complemento VARCHAR(80) NOT NULL,
    cep VARCHAR(12) NOT NULL,
    PRIMARY KEY (idEndereco)
);

CREATE TABLE aluno(
    idAluno INTEGER NOT NULL,
    idUsuario INTEGER NOT NULL,
    nome VARCHAR(80) NOT NULL,
    rg VARCHAR(15) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    idEndereco INTEGER NOT NULL,
    idFormacao INTEGER NOT NULL,
    dataNascimento VARCHAR(10) NOT NULL,
    tia VARCHAR(15) NOT NULL,
    PRIMARY KEY (idAluno),
    CONSTRAINT idEnderecoAluno FOREIGN KEY (idEndereco) REFERENCES endereco,
    CONSTRAINT idFormacaoAluno FOREIGN KEY (idFormacao) REFERENCES formacao,
    CONSTRAINT idUsuarioAluno FOREIGN KEY (idUsuario) REFERENCES usuario
);

CREATE TABLE empresa(
    idEmpresa INTEGER NOT NULL,
    idUsuario INTEGER NOT NULL,
    nome VARCHAR(80) NOT NULL,
    cnpj VARCHAR(30) NOT NULL,
    site VARCHAR(60) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    idEndereco INTEGER NOT NULL,
    situacao BOOLEAN NOT NULL,
    PRIMARY KEY (idEmpresa),
    CONSTRAINT idEnderecoEmpresa FOREIGN KEY (idEndereco) REFERENCES endereco,
    CONSTRAINT idUsuarioEmpresa FOREIGN KEY (idUsuario) REFERENCES usuario

);

CREATE TABLE administrador(
    idAdm INTEGER NOT NULL,
    nome VARCHAR(80) NOT NULL,
    idUsuario INTEGER NOT NULL,
    nivel INTEGER NOT NULL,
    PRIMARY KEY (idAdm),
    FOREIGN KEY (idUsuario) REFERENCES usuario
);


CREATE TABLE vaga(
    idVaga INTEGER NOT NULL,
    curso VARCHAR(70) NOT NULL,
    nome VARCHAR(80) NOT NULL,
    semestre INTEGER NOT NULL,
    valorBolsa FLOAT(5) NOT NULL,
    valeRefeicao FLOAT(5),
    valeTransporte FLOAT(5),
    descricao VARCHAR(1500) NOT NULL,
    atividades VARCHAR(1500) NOT NULL,
    adicionais VARCHAR(1000) NOT NULL,
    validade Date NOT NULL,
    horario VARCHAR(15),
    idEmpresa INTEGER NOT NULL,
    PRIMARY KEY (idVaga),
    FOREIGN KEY (idEmpresa) REFERENCES empresa
);


INSERT INTO usuario (idUsuario, email, senha, tipo) VALUES(10, 'danielfelipe982008@hotmail.com','abc01020304','1');
INSERT INTO usuario (idUsuario, email, senha, tipo) VALUES(20, 'danielfelipe982012@hotmail.com','abc01020304','2');
INSERT INTO usuario (idUsuario, email, senha, tipo) VALUES(30, 'danielfelipealmeida98@gmail.com','helloword','3');

INSERT INTO administrador (idAdm, nome, idUsuario, nivel) VALUES(10, 'Daniel Felipe',10 ,1);

insert into formacao (idFormacao, curso, semestre, faculdade, unidade) values(10, 'Sistemas ', 6, 'FCI', 'Mackenzie consolacao');
insert into endereco (idEndereco, rua, bairro, cidade, estado, numero, complemento, cep) values(10, 'Rua aracitaba', 'Bonsucesso', 'Guarulhos', 'Sao paulo', 205, 'Viela', '07176-371');

insert into aluno (idAluno, idUsuario, nome, rg, cpf, telefone, idEndereco, idFormacao, dataNascimento, tia)
values(10, 20, 'Daniel', '37.557.102-4', '475.488.288-10', '2438-1731', 10, 10, '1998-06-26', '41584945');

insert into endereco (idEndereco, rua, bairro, cidade, estado, numero, complemento, cep) values(20, 'Avenida Paulista', 'Centro', 'São Paulo', 'Sao paulo', 1148, 'Prédio', '07178-311');

INSERT INTO empresa (idEmpresa, idUsuario, nome, cnpj, site, telefone, idEndereco, situacao) VALUES(10, 30, 'Empresa X','46489498498','www.empresaX.com.br', '94952-4381', 20, False);


INSERT INTO usuario (idUsuario, email, senha, tipo) VALUES(40, 'ramoncardoso@gmail.com','abc123456','2');

insert into formacao (idFormacao, curso, semestre, faculdade, unidade) values(20, 'Sistemas ', 3, 'FCI', 'Mackenzie consolacao');
insert into endereco (idEndereco, rua, bairro, cidade, estado, numero, complemento, cep) values(30,'Av armando bei', 'Capão redondo', 'Santo Andre', 'Sao paulo', 1024, 'Apartamento', '04739-874');

insert into aluno (idAluno, idUsuario, nome, rg, cpf, telefone, idEndereco, idFormacao, dataNascimento, tia)
values(20, 40, 'Ramon Cardoso', '80.800.808-8', '778.788.788-77', '949518125', 30, 20, '1978-01-10', '41582802');

INSERT INTO vaga (idVaga, idEmpresa, curso, nome, semestre, valorBolsa, valeRefeicao, valeTransporte, descricao, atividades, adicionais, validade, horario)
VALUES(10, 'Sistemas', 10, 'Programador', 6, 2000, 25, 10, 'Trabalhar programando', 'Programar com sql,e afins', 'possivel efetivação', '1998-06-26', '9:00' );