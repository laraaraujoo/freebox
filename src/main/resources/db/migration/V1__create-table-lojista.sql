
create table lojistas (
    id bigint not null auto_increment,
    email varchar(155) not null unique,
    nome varchar(155) not null,
    telefone varchar(15)  not null,
    cnpj varchar(15) not null unique,
    ativo tinyint not null,

    primary key(id)
);

create table clientes (
     id bigint not null auto_increment,
    email varchar(155) not null unique,
    nome varchar(155) not null,
    telefone varchar(15)  not null,
    cpf varchar(15) not null unique,
    ativo tinyint not null,
     
     primary key(id)
)