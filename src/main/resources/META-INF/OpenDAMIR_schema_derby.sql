DROP TABLE Executant;
DROP TABLE Beneficiaire;
DROP TABLE Indicateurs;
DROP TABLE Date_traitement;
DROP TABLE Prestation;

CREATE TABLE Executant (
  idExecutant INT NOT NULL PRIMARY KEY,
  PSE_SPE_SNDS INT default NULL);

CREATE TABLE Beneficiaire (
  idBeneficiaire INT NOT NULL PRIMARY KEY,
  AGE_BEN_SNDS INT default NULL,
  BEN_RES_REG INT default NULL);

CREATE TABLE Date_traitement (
  idDate INT NOT NULL PRIMARY KEY,
  FLX_ANN_MOI INT default NULL);

CREATE TABLE Indicateurs (
  idIndicateurs INT NOT NULL PRIMARY KEY,
  PRS_PAI_MNT FLOAT default NULL,
  PRS_REM_MNT FLOAT default NULL);

CREATE TABLE Prestation (
  idPrestation INT NOT NULL PRIMARY KEY,
  PRS_PPU_SEC INT default NULL,
  PRS_NAT INT default NULL,
  Executant_idExecutant1 INT NOT NULL PRIMARY KEY,
  Beneficiaire_idBeneficiaire INT NOT NULL PRIMARY KEY,
  Date_traitement_idDate INT NOT NULL PRIMARY KEY,
  Indicateurs_idIndicateurs INT NOT NULL PRIMARY KEY,
  INDEX fk_Prestation_Executant1_idx (Executant_idExecutant1 ASC),
  INDEX fk_Prestation_Beneficiaire1_idx (Beneficiaire_idBeneficiaire ASC),
  INDEX fk_Prestation_Date1_idx (Date_traitement_idDate ASC),
  INDEX fk_Prestation_Indicateurs1_idx (Indicateurs_idIndicateurs ASC),
  CONSTRAINT fk_Prestation_Executant1
    FOREIGN KEY (Executant_idExecutant1)
    REFERENCES Executant (idExecutant)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Prestation_Beneficiaire1
    FOREIGN KEY (Beneficiaire_idBeneficiaire)
    REFERENCES Beneficiaire (idBeneficiaire)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Prestation_Date1
    FOREIGN KEY (Date_traitement_idDate)
    REFERENCES Date_traitement (idDate)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Prestation_Indicateurs1
    FOREIGN KEY (Indicateurs_idIndicateurs)
    REFERENCES Indicateurs (idIndicateurs)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
