create or replace
PACKAGE BODY PKG_CLIENTE AS
  PROCEDURE SP_VALIDAR_RAZON_SOCIAL(
    P_RET           OUT NUMERIC,
    P_ID_CLIENTE    IN  CLIENTE.ID_CLIENTE%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE  
 )AS
 BEGIN
    IF P_ID_CLIENTE>0 THEN
        SELECT 
            COUNT(*)
        INTO 
            P_RET
        FROM
            CLIENTE
        WHERE 
                RAZON_SOCIAL  =   P_RAZON_SOCIAL
            AND ID_CLIENTE    <>  P_ID_CLIENTE
            AND ESTADO        =   '1';
    ELSE
        SELECT 
            COUNT(*)
        INTO 
            P_RET
        FROM
            CLIENTE
        WHERE 
                RAZON_SOCIAL  =   P_RAZON_SOCIAL
            AND ESTADO        =   '1';
    END IF;
  NULL;
 END SP_VALIDAR_RAZON_SOCIAL;
 
 PROCEDURE SP_VALIDAR_RUC(
    P_RET           OUT NUMERIC,
    P_ID_CLIENTE    IN  CLIENTE.ID_CLIENTE%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE  
 )AS
 BEGIN
  IF P_ID_CLIENTE>0 THEN
        SELECT 
            COUNT(*)
        INTO 
            P_RET
        FROM
            CLIENTE
        WHERE 
                RUC           =   P_RUC
            AND ID_CLIENTE    <>  P_ID_CLIENTE
            AND ESTADO        =   '1';
    ELSE
        SELECT 
            COUNT(*)
        INTO 
            P_RET
        FROM
            CLIENTE
        WHERE 
                RUC           =   P_RUC
            AND ESTADO        =   '1';
    END IF;
 END SP_VALIDAR_RUC;
 
  PROCEDURE SP_LISTAR(
    P_C_CURSOR OUT C_CURSOR
  ) AS
  BEGIN
  OPEN 
      P_C_CURSOR
      FOR
        SELECT
            ID_CLIENTE,
            RAZON_SOCIAL,
            RUC,
            DIRECCION,
            ESTADO
        FROM 
            CLIENTE
        WHERE
            ESTADO='1';
  END SP_LISTAR;
  
  PROCEDURE SP_INSERTAR(
    P_ID_CLIENTE    OUT CLIENTE.ID_CLIENTE%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE,
    P_DIRECCION     IN  CLIENTE.DIRECCION%TYPE
  )AS
  BEGIN
    SELECT
      SEQ_CLIENTE.NEXTVAL
    INTO
      P_ID_CLIENTE
    FROM
      DUAL;
    INSERT INTO CLIENTE
    (
      ID_CLIENTE,
      RAZON_SOCIAL,
      RUC,
      DIRECCION
    )
    VALUES
    (
      P_ID_CLIENTE,
      P_RAZON_SOCIAL,
      P_RUC,
      P_DIRECCION
    );
    
  END SP_INSERTAR;
  
  PROCEDURE SP_ACTUALIZAR(
     P_ID_CLIENTE    IN CLIENTE.ID_CLIENTE%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE,
    P_DIRECCION     IN  CLIENTE.DIRECCION%TYPE
  )AS
  BEGIN
    UPDATE CLIENTE
      SET
        RAZON_SOCIAL    =   P_RAZON_SOCIAL,
        RUC             =   P_RUC,
        DIRECCION       =   P_DIRECCION
      WHERE
        ID_CLIENTE      =   P_ID_CLIENTE;
  END SP_ACTUALIZAR;
  
    PROCEDURE SP_ELIMINAR(
    P_ID_CLIENTE    IN CLIENTE.ID_CLIENTE%TYPE
  )AS
  BEGIN
   UPDATE CLIENTE
      SET
        ESTADO          =   '0'
      WHERE
        ID_CLIENTE      =   P_ID_CLIENTE;
  END SP_ELIMINAR;

END PKG_CLIENTE;