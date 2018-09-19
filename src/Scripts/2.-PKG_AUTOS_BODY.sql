create or replace PACKAGE BODY PKG_AUTOS AS
 
  PROCEDURE SP_LISTAR(
    P_C_CURSOR OUT C_CURSOR
  ) AS
  BEGIN
  OPEN 
      P_C_CURSOR
      FOR

      SELECT    codigo, placa, ano, modelo, marca, estado
FROM
    autos
        WHERE
            estado='1';
  END SP_LISTAR;

  PROCEDURE SP_INSERTAR(
    P_CODIGO    OUT autos.codigo%TYPE,
    P_PLACA     IN  autos.placa%TYPE,
    P_ANO           IN  autos.ano%TYPE,
    P_MODELO        IN  autos.modelo%TYPE,
    P_MARCA         IN  autos.marca%TYPE
  )AS
  BEGIN
    SELECT
      SEQ_AUTOS.NEXTVAL
    INTO
      P_CODIGO
    FROM
      DUAL;
    INSERT INTO autos
    (
     placa, ano, modelo, marca
    )
    VALUES
    (
      P_PLACA, P_ANO , P_MODELO, P_MARCA
    );

  END SP_INSERTAR;

  PROCEDURE SP_ACTUALIZAR(
     P_CODIGO    OUT autos.codigo%TYPE,
    P_PLACA     IN  autos.placa%TYPE,
    P_ANO           IN  autos.ano%TYPE,
    P_MODELO        IN  autos.modelo%TYPE,
    P_MARCA         IN  autos.marca%TYPE
  )AS
  BEGIN
    UPDATE autos
      SET
        PLACA    =   P_PLACA,
        ANO        =   P_ANO,
        MODELO      =   P_MODELO,
        MARCA       =   P_MARCA
      WHERE
        CODIGO      =   P_CODIGO;
  END SP_ACTUALIZAR;

    PROCEDURE SP_ELIMINAR(
   P_CODIGO    OUT autos.codigo%TYPE
  )AS
  BEGIN
   UPDATE autos
      SET
        ESTADO          =   '0'
      WHERE
        CODIGO      =   P_CODIGO;
  END SP_ELIMINAR;

END PKG_AUTOS;