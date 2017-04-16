-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-03-10 11:41:07.814

-- tables
-- Table: Famille
CREATE TABLE Famille (
    fam_code varchar(255) NOT NULL CONSTRAINT Famille_pk PRIMARY KEY,
    fam_libelle varchar(255)
);

-- Table: Medicament
CREATE TABLE Medicament (
    med_depotlegal varchar(255) NOT NULL CONSTRAINT Medicament_pk PRIMARY KEY,
    med_nomcom varchar(255),
    med_compo varchar(255),
    med_effets varchar(255) NOT NULL,
    med_contreind varchar(255) NOT NULL,
    Famille_fam_code varchar(255) NOT NULL,
    CONSTRAINT Medicament_Famille FOREIGN KEY (Famille_fam_code)
    REFERENCES Famille (fam_code)
);

-- Table: Offrir
CREATE TABLE Offrir (
    off_qte integer NOT NULL,
    Medicament_med_depotlegal varchar(255) NOT NULL,
    Rapport_Visite_rap_num integer NOT NULL,
    CONSTRAINT Offrir_Medicament FOREIGN KEY (Medicament_med_depotlegal)
    REFERENCES Medicament (med_depotlegal),
    CONSTRAINT Offrir_Rapport_Visite FOREIGN KEY (Rapport_Visite_rap_num)
    REFERENCES Rapport_Visite (rap_num)
);

-- Table: Praticien
CREATE TABLE Praticien (
    pra_num integer NOT NULL CONSTRAINT Praticien_pk PRIMARY KEY,
    pra_nom varchar(255),
    pra_prenom varchar(255),
    pra_adresse varchar(255),
    pra_cp integer,
    pra_ville varchar(255),
    pra_coef float NOT NULL
);

-- Table: Rapport_Visite
CREATE TABLE Rapport_Visite (
    rap_num integer NOT NULL CONSTRAINT Rapport_Visite_pk PRIMARY KEY,
    rap_date varchar(255) NOT NULL,
    rap_motif varchar(255) NOT NULL,
    rap_bilan varchar(255) NOT NULL,
    Visiteur_vis_mat varchar(255) NOT NULL,
    Praticien_pra_num integer NOT NULL,
    CONSTRAINT Rapport_Visite_Visiteur FOREIGN KEY (Visiteur_vis_mat)
    REFERENCES Visiteur (vis_mat),
    CONSTRAINT Rapport_Visite_Praticien FOREIGN KEY (Praticien_pra_num)
    REFERENCES Praticien (pra_num)
);

-- Table: Visiteur
CREATE TABLE Visiteur (
    vis_mat varchar(255) NOT NULL CONSTRAINT Visiteur_pk PRIMARY KEY,
    vis_nom varchar(255),
    vis_prenom varchar(255),
    vis_adresse varchar(255),
    vis_cp integer,
    vis_ville varchar(255),
    vis_dateemb varchar(255)
);

-- End of file.

