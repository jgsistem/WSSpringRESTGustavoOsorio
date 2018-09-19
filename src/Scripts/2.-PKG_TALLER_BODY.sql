create or replace
PACKAGE BODY PKG_TALLER AS

  PROCEDURE SP_LISTAR(
    P_C_CURSOR OUT C_CURSOR,
    P_NOMBRE IN TALLER.NOMBRE%TYPE
  ) AS
  BEGIN
  OPEN 
      P_C_CURSOR
      FOR
        SELECT
            ID_TALLER,
            NOMBRE,
            DESCRIPCION,
            ESTADO
        FROM 
            TALLER
        WHERE
                UPPER(NOMBRE) LIKE '%'||UPPER(P_NOMBRE)||'%'
            AND ESTADO='1';
  END SP_LISTAR;
  
  PROCEDURE SP_INSERTAR(
    P_ID_TALLER     OUT TALLER.ID_TALLER%TYPE,
    P_NOMBRE        IN  TALLER.NOMBRE%TYPE,
    P_DESCRIPCION   IN  TALLER.DESCRIPCION%TYPE
  )AS
  BEGIN
    SELECT
        SEQ_TALLER.NEXTVAL
      INTO
        P_ID_TALLER
      FROM
        DUAL;
      INSERT INTO TALLER
      (
        ID_TALLER,
        NOMBRE,
        DESCRIPCION
      )
      VALUES
      (
        P_ID_TALLER,
        P_NOMBRE,
        P_DESCRIPCION
      );
  
  END SP_INSERTAR;

END PKG_TALLER;