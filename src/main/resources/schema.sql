CREATE TABLE endereco(
    id SERIAL PRIMARY KEY,
    logradouro VARCHAR (150),
    numero VARCHAR (120),
    bairro VARCHAR (100),
    cidade VARCHAR (100),
    estado VARCHAR (2),
    cep VARCHAR (20)
);

INSERT INTO endereco(logradouro, numero, bairro, cidade, estado, cep)
VALUES ('Rua das Flores' , '123','centro', 'Recife','PE', '50000.000')
('Avenida Boa Viagem', '456', 'boa Viagem', 'Recife', 'PE','51000.000');

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    tipo_pessoa VARCHAR(20) CHECK ( tipo_pessoa IN ('Fisica','Juridica')),
    cpf_cnpj VARCHAR(14) UNIQUE,
    nome_razao_social VARCHAR (150) NOT NULL,
    endereco_id INT REFERENCES endereo (id) ON DELETE SET NULL
);

INSERT INTO cliente (tipo_pessoa, cpf_cnpj, nome_razao_social, endereco_id)
VALUES ('Fisica', '12345678901', 'Maria Gabriela', 1),
       ('juridica', '9876543210001', 'Empresa XYZ', 2);

CREATE TABLE produto(
    id SERIAL PRIMARY KEY ,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    peso DOUBLE PRECISION NOT NULL CHECK (peso>=0),
    volume DOUBLE PRECISION NULL CHECK (volume>=0),
    valor DOUBLE PRECISION NOT NULL CHECK ( valor>=0 )
);

INSERT INTO produto(nome, descricao, peso, volume, valor)
VALUES ('celular', 'smartphone Samsung', '0.300,0.0005,1500.00')
('Notebook', 'Notebook Dell', 2.500,0.003,4000.00);

CREATE TABLE entrega(
    is SERIAL PRIMARY KEY,
    cliente_id INT REFERENCES cliente(id) ON DELETE SET NULL ,
    remetente_id INT REFERENCES cliente(id) ON DELETE SET NULL,
    status VARCHAR(30),
    data_entrega DATE,
    data_criacao DATE DEFAULT CURRENT_DATE,
    observacoes TEXT,
    valor_frete DOUBLE PRECISION NOT NULL CHECK (valor_frete >=0)
);

INSERT INTO item_entrega (entrega_id, produto_id, quantidade)
VALUES (1,1,2), (1,2,1), (2,1,1);

SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';

SELECT * FROM endereco;
SELECT * FROM cliente;
SELECT * FROM produto;
SELECT * FROM entrega;
SELECT * FROM item_entrega;
SELECT * FROM endereco, cliente, produto, entrega,item_entrega;

SELECT * FROM endereco WHERE id = 1;
SELECT * FROM endereco WHERE numero = '123';

SELECT numero FROM endereco;
SELECT numero, bairro FROM endereco;

SELECT bairro AS endereco FROM endereco;

SELECT e.id, e.status, e.data_entrega, c.nome_razao_social AS cliente FROM entrega e JOIN cliente c ON e.cliente_id = c.id WHERE c.id = 1;

SELECT p.nome, p.descricao, ie.quantidade FROM item_entrega ie JOIN produto p ON e.produto_id = p.id WHERE ie.entrega_id = 1;
