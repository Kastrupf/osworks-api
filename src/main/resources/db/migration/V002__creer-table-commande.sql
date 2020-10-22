CREATE TABLE commande (
id bigint not null auto_increment,
client_id bigint not null,
description text not null,
prix decimal(10,2) not null,
status varchar(20) not null,
date_ouverture datetime not null,
date_fermeture datetime,
primary key (id)
);

ALTER TABLE commande ADD CONSTRAINT fk_commande_client
foreign key (client_id) references client (id);