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
    auto 
        WHERE
            estado='1';
  END SP_LISTAR;

  PROCEDURE SP_INSERTAR(
    P_CODIGO    OUT auto.codigo%TYPE,
    P_PLACA     IN  auto.placa%TYPE,
    P_ANO           IN  auto.ano%TYPE,
    P_MODELO        IN  auto.modelo%TYPE,
    P_MARCA         IN  auto.marca%TYPE
  )AS
  BEGIN
    SELECT
      SEQ_AUTOS.NEXTVAL
    INTO
      P_CODIGO
    FROM
      DUAL;
    INSERT INTO AUTO
    (
     placa, ano, modelo, marca
    )
    VALUES
    (
      P_PLACA, P_ANO , P_MODELO, P_MARCA
    );

  END SP_INSERTAR;

  PROCEDURE SP_ACTUALIZAR(
     P_CODIGO    OUT auto.codigo%TYPE,
    P_PLACA     IN  auto.placa%TYPE,
    P_ANO           IN  auto.ano%TYPE,
    P_MODELO        IN  auto.modelo%TYPE,
    P_MARCA         IN  auto.marca%TYPE
  )AS
  BEGIN
    UPDATE AUTO
      SET
        PLACA    =   P_PLACA,
        ANO        =   P_ANO,
        MODELO      =   P_MODELO,
        MARCA       =   P_MARCA
      WHERE
        CODIGO      =   P_CODIGO;
  END SP_ACTUALIZAR;

    PROCEDURE SP_ELIMINAR(
   P_CODIGO    OUT auto.codigo%TYPE
  )AS
  BEGIN
   UPDATE AUTO
      SET
        ESTADO          =   '0'
      WHERE
        CODIGO      =   P_CODIGO;
  END SP_ELIMINAR;

END PKG_AUTOS;