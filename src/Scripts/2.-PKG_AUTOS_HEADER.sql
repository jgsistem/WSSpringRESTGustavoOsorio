create or replace
PACKAGE PKG_AUTOS AS 
  TYPE C_CURSOR IS REF CURSOR;
  

  PROCEDURE SP_LISTAR(
    P_C_CURSOR OUT C_CURSOR
  );
  
   PROCEDURE SP_INSERTAR(
    P_CODIGO    OUT autos.codigo%TYPE,
    P_PLACA     IN  autos.placa%TYPE,
    P_ANO           IN  autos.ano%TYPE,
    P_MODELO        IN  autos.modelo%TYPE,
    P_MARCA         IN  autos.marca%TYPE
  );
  
  PROCEDURE SP_ACTUALIZAR(
   P_CODIGO    OUT autos.codigo%TYPE,
    P_PLACA     IN  autos.placa%TYPE,
    P_ANO           IN  autos.ano%TYPE,
    P_MODELO        IN  autos.modelo%TYPE,
    P_MARCA         IN  autos.marca%TYPE
  );
  
  PROCEDURE SP_ELIMINAR(
    P_CODIGO    IN autos.codigo%TYPE
  );
END PKG_AUTOS;