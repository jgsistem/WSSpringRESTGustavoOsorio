create or replace
PACKAGE PKG_AUTOS AS 
  TYPE C_CURSOR IS REF CURSOR;
  

  PROCEDURE SP_LISTAR(
    P_C_CURSOR OUT C_CURSOR
  );
  
   PROCEDURE SP_INSERTAR(
    P_CODIGO    OUT auto.codigo%TYPE,
    P_PLACA     IN  auto.placa%TYPE,
    P_ANO           IN  auto.ano%TYPE,
    P_MODELO        IN  auto.modelo%TYPE,
    P_MARCA         IN  auto.marca%TYPE
  );
  
  PROCEDURE SP_ACTUALIZAR(
   P_CODIGO    OUT auto.codigo%TYPE,
    P_PLACA     IN  auto.placa%TYPE,
    P_ANO           IN  auto.ano%TYPE,
    P_MODELO        IN  auto.modelo%TYPE,
    P_MARCA         IN  auto.marca%TYPE
  );
  
  PROCEDURE SP_ELIMINAR(
    P_CODIGO    IN auto.codigo%TYPE
  );
END PKG_AUTOS;