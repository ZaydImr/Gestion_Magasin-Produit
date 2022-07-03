CREATE Table category (
    id_category int AUTO_INCREMENT PRIMARY KEY, 
    nom_category VARCHAR(50)
);

CREATE Table produit (
    id_produit int AUTO_INCREMENT PRIMARY KEY, 
    titre VARCHAR(50),
    description VARCHAR(255),
    prix FLOAT,
    id_category int,
    CONSTRAINT FOREIGN KEY (id_category) REFERENCES category(id_category)
);

CREATE Table magasin (
    id_magasin int AUTO_INCREMENT PRIMARY KEY, 
    nom VARCHAR(50),
    adresse VARCHAR(150)
);

CREATE TABLE produit_magasin (
    id_produit int NOT NULL, 
    id_magasin int NOT NULL, 
    CONSTRAINT PRIMARY KEY (id_produit, id_magasin),
    CONSTRAINT FOREIGN KEY (id_produit) REFERENCES produit(id_produit),
    CONSTRAINT FOREIGN KEY (id_magasin) REFERENCES magasin(id_magasin)
);
