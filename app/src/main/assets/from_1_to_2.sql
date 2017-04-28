-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-04-20 18:45:54.688

-- tables
-- Table: Formation
CREATE TABLE Formation (
    for_num integer NOT NULL CONSTRAINT Formation_pk PRIMARY KEY,
    for_libelle varchar(255) NOT NULL
);

-- Table: Participer
CREATE TABLE Participer (
    Visiteur_vis_mat varchar(255) NOT NULL,
    Formation_for_num integer NOT NULL,
    CONSTRAINT Participer_Visiteur FOREIGN KEY (Visiteur_vis_mat)
    REFERENCES Visiteur (vis_mat),
    CONSTRAINT Participer_Formation FOREIGN KEY (Formation_for_num)
    REFERENCES Formation (for_num)
);

-- End of file.

