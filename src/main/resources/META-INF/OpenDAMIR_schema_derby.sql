CREATE TABLE PRS_PPU_SEC_CLAIR (SEC_NUM INT NOT NULL PRIMARY KEY,  SEC_CLAIR VARCHAR(200) default NULL)

CREATE TABLE PRS_NAT_CLAIR (  NAT_NUM INT NOT NULL PRIMARY KEY,  NAT_CLAIR VARCHAR(200) default NULL)

CREATE TABLE PSE_SPE_SNDS_CLAIR (  SPE_NUM INT NOT NULL PRIMARY KEY,  SPE_CLAIR VARCHAR(200) default NULL)

CREATE TABLE AGE_BEN_SNDS_CLAIR (  AGE_NUM INT NOT NULL PRIMARY KEY,  AGE_CLAIR VARCHAR(200) default NULL)

CREATE TABLE BEN_RES_REG_CLAIR (  REG_NUM INT NOT NULL PRIMARY KEY,  REG_CLAIR VARCHAR(200) default NULL)

CREATE TABLE FichiersDamir (  cleFichier VARCHAR(200) NOT NULL PRIMARY KEY,  urlFichier VARCHAR(200) default NULL)

CREATE TABLE Prestation (  idPrestation INT NOT NULL PRIMARY KEY,  PRS_PPU_SEC INT NOT NULL,  PRS_NAT INT NOT NULL,  CONSTRAINT fk_Prestation_PRS_PPU_SEC_CLAIR1   FOREIGN KEY (PRS_PPU_SEC)    REFERENCES PRS_PPU_SEC_CLAIR (SEC_NUM),  CONSTRAINT fk_Prestation_PRS_NAT_CLAIR1    FOREIGN KEY (PRS_NAT)    REFERENCES PRS_NAT_CLAIR (NAT_NUM))

CREATE TABLE Indicateurs (  idIndicateurs INT NOT NULL PRIMARY KEY,  PRS_PAI_MNT FLOAT default NULL,  PRS_REM_MNT FLOAT default NULL,  CONSTRAINT fk_Indicateurs_Prestation1    FOREIGN KEY (idIndicateurs)    REFERENCES Prestation (idPrestation))

CREATE TABLE Executant (  idExecutant INT NOT NULL PRIMARY KEY,  PSE_SPE_SNDS INT NOT NULL,  CONSTRAINT fk_Executant_PSE_SPE_SNDS_CLAIR1    FOREIGN KEY (PSE_SPE_SNDS)    REFERENCES PSE_SPE_SNDS_CLAIR (SPE_NUM),  CONSTRAINT fk_Executant_Prestation1    FOREIGN KEY (idExecutant)    REFERENCES Prestation (idPrestation))

CREATE TABLE Beneficiaire (  idBeneficiaire INT NOT NULL PRIMARY KEY,  AGE_BEN_SNDS INT NOT NULL,  BEN_RES_REG INT NOT NULL,  CONSTRAINT fk_Beneficiaire_AGE_BEN_SNDS_CLAIR1    FOREIGN KEY (AGE_BEN_SNDS)    REFERENCES AGE_BEN_SNDS_CLAIR (AGE_NUM),  CONSTRAINT fk_Beneficiaire_BEN_RES_REG_CLAIR1    FOREIGN KEY (BEN_RES_REG)    REFERENCES BEN_RES_REG_CLAIR (REG_NUM),  CONSTRAINT fk_Beneficiaire_Prestation1    FOREIGN KEY (idBeneficiaire)    REFERENCES Prestation (idPrestation))

CREATE TABLE Date_traitement (  idDate INT NOT NULL PRIMARY KEY,  FLX_ANN_MOI INT default NULL,  CONSTRAINT fk_Date_traitement_Prestation1    FOREIGN KEY (idDate)    REFERENCES Prestation (idPrestation))
