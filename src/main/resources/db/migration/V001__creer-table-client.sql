create table client (
	id bigint not null auto_increment,
    nom varchar(100) not null,
    prenom varchar(100) not null,
    email varchar(255) not null,
    telephone varchar(20) not null,
    
    primary key (id)
);