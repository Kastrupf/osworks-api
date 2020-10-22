create table commentaire (
	id bigint not null auto_increment,
    commande_id bigint not null,
    description text not null,
    date datetime not null,
        
    primary key (id)
);

ALTER TABLE commentaire ADD CONSTRAINT fk_commentaire_commande
foreign key (commande_id) references commande (id);