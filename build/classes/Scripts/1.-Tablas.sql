
CREATE TABLE AUTOS(
  codigo NUMERIC(10,0) NOT NULL PRIMARY KEY,
  placa VARCHAR2(240) NOT NULL UNIQUE,
  ano  NUMERIC(10,0) NOT NULL UNIQUE,
  modelo VARCHAR2(280) NOT NULL,
  marca VARCHAR2(280) NOT NULL,
  estado CHAR(1) DEFAULT '1'
);



INSERT INTO AUTOS (codigo,placa,ano,modelo,marca,estado) VALUES (1,'ALV169',2018,'ELANTRA','HYUNDAI',1);
INSERT INTO AUTOS (codigo,placa,ano,modelo,marca,estado) VALUES (2,'JLV168',2016,'TUCSON','HYUNDAI',1);
INSERT INTO AUTOS (codigo,placa,ano,modelo,marca,estado) VALUES (3,'HLV167',2015,'SANTA FE','HYUNDAI',1);
INSERT INTO AUTOS (codigo,placa,ano,modelo,marca,estado) VALUES (4,'GLV166',2014,'COROLA','TOYOA',1);
COMMIT;

