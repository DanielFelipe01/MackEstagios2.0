CREATE TABLE usuario(
    idUsuario INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    email VARCHAR(80) NOT NULL,
    senha VARCHAR(15) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    PRIMARY KEY (idUsuario)
);

CREATE TABLE formacao(
    idFormacao INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    curso VARCHAR(20) NOT NULL,
    semestre INTEGER NOT NULL,
    faculdade VARCHAR(40) NOT NULL,
    unidade VARCHAR(50) NOT NULL,
    PRIMARY KEY (idFormacao)
);

CREATE TABLE endereco(
    idEndereco INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
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
    idAluno INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    idUsuario INTEGER NOT NULL,
    nome VARCHAR(80) NOT NULL,
    rg VARCHAR(15) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    idEndereco INTEGER NOT NULL,
    idFormacao INTEGER NOT NULL,
    dataNascimento DATE NOT NULL,
    tia VARCHAR(15) NOT NULL,
    PRIMARY KEY (idAluno),
    CONSTRAINT idEnderecoAluno FOREIGN KEY (idEndereco) REFERENCES endereco,
    CONSTRAINT idFormacaoAluno FOREIGN KEY (idFormacao) REFERENCES formacao,
    CONSTRAINT idUsuarioAluno FOREIGN KEY (idUsuario) REFERENCES usuario
);

CREATE TABLE empresa(
    idEmpresa INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
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
    idAdm INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(80) NOT NULL,
    idUsuario INTEGER NOT NULL,
    nivel INTEGER NOT NULL,
    PRIMARY KEY (idAdm),
    FOREIGN KEY (idUsuario) REFERENCES usuario
);


CREATE TABLE vaga(
    idVaga INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    curso VARCHAR(20) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    semestre INTEGER NOT NULL,
    valorBolsa FLOAT(5) NOT NULL,
    valeRefeicao FLOAT(5),
    valeTransporte FLOAT(5),
    descricao VARCHAR(1500) NOT NULL,
    atividades VARCHAR(1500) NOT NULL,
    adicionais VARCHAR(1000) NOT NULL,
    ataValiadde DATE NOT NULL,
    horario VARCHAR(10),
    idEmpresa INTEGER NOT NULL,
    PRIMARY KEY (idVaga),
    FOREIGN KEY (idEmpresa) REFERENCES empresa
);


INSERT INTO usuario (email, senha, tipo) VALUES('danielfelipe982008@hotmail.com','abc01020304','1');
INSERT INTO usuario (email, senha, tipo) VALUES('danielfelipe982012@hotmail.com','abc01020304','2');
INSERT INTO usuario (email, senha, tipo) VALUES('danielfelipealmeida98@gmail.com','helloword','3');

INSERT INTO administrador (nome, idUsuario, nivel) VALUES('Daniel Felipe',1 ,1);

insert into formacao (curso, semestre, faculdade, unidade) values('Sistemas ', 6, 'FCI', 'Mackenzie consolacao');
insert into endereco (rua, bairro, cidade, estado, numero, complemento, cep) values('Rua aracitaba', 'Bonsucesso', 'Guarulhos', 'Sao paulo', 205, 'Viela', '07176-371');
insert into aluno (idUsuario, nome, rg, cpf, telefone, idEndereco, idFormacao, dataNascimento, tia)
values(2, 'Daniel', '37.557.102-4', '475.488.288-10', '2438-1731', 1, 2, '1998-06-26', '41584945');

insert into endereco (rua, bairro, cidade, estado, numero, complemento, cep) values('Avenida Paulista', 'Centro', 'São Paulo', 'Sao paulo', 1148, 'Prédio', '07178-311');
INSERT INTO empresa (idUsuario, nome, cnpj, site, telefone, idEndereco, situacao) VALUES(3, 'Empresa X','46489498498','www.empresaX.com.br', '94952-4381', 2, False);


INSERT INTO usuario (email, senha, tipo) VALUES('ramoncardoso@gmail.com','abc123456','2');

insert into formacao (curso, semestre, faculdade, unidade) values('Sistemas ', 3, 'FCI', 'Mackenzie consolacao');
insert into endereco (rua, bairro, cidade, estado, numero, complemento, cep) values('Av armando bei', 'Capão redondo', 'Santo Andre', 'Sao paulo', 1024, 'Apartamento', '04739-874');
insert into aluno (idUsuario, nome, rg, cpf, telefone, idEndereco, idFormacao, dataNascimento, tia)
values(4, 'Ramon Cardoso', '80.800.808-8', '778.788.788-77', '949518125', 3, 2, '1978-01-10', '41582802');


