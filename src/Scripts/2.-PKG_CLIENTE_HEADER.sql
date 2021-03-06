create or replace
PACKAGE PKG_CLIENTE AS 
  TYPE C_CURSOR IS REF CURSOR;
  
   PROCEDURE SP_VALIDAR_RAZON_SOCIAL(
    P_RET           OUT NUMERIC,
    P_ID_CLIENTE    IN  CLIENTE.ID_CLIENTE%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE  
 );
 
 PROCEDURE SP_VALIDAR_RUC(
    P_RET           OUT NUMERIC,
    P_ID_CLIENTE    IN  CLIENTE.ID_CLIENTE%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE  
 );

  PROCEDURE SP_LISTAR(
    P_C_CURSOR OUT C_CURSOR
  );
  
   PROCEDURE SP_INSERTAR(
    P_ID_CLIENTE    OUT CLIENTE.ID_CLIENTE%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE,
    P_DIRECCION     IN  CLIENTE.DIRECCION%TYPE
  );
  
  PROCEDURE SP_ACTUALIZAR(
    P_ID_CLIENTE    IN CLIENTE.ID_CLIENTE%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE,
    P_DIRECCION     IN  CLIENTE.DIRECCION%TYPE
  );
  
  PROCEDURE SP_ELIMINAR(
    P_ID_CLIENTE    IN CLIENTE.ID_CLIENTE%TYPE
  );
END PKG_CLIENTE;