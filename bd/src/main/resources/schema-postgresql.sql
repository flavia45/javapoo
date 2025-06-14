CREATE TABLE IF NOT EXISTS cliente (
     id_cliente serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11)
);

CREATE TABLE IF NOT EXISTS professor (
     id_professor serial PRIMARY KEY,
     nome  varchar(50),
     cpf   varchar(11)
);

CREATE TABLE IF NOT EXISTS curso (
     id_curso serial PRIMARY KEY,
     nome  varchar(50),
     id_cliente INT REFERENCES cliente(id_cliente),
     id_professor INT REFERENCES cliente(id_professor),
);
