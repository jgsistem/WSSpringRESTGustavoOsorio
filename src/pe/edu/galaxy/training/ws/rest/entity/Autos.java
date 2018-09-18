package pe.edu.galaxy.training.ws.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="auto.listar", 
					procedureName="PKG_AUTOS.SP_LISTAR",
					resultClasses= Cliente.class,
				
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
						}					
				),
				/*
				@NamedStoredProcedureQuery(
						name="cliente.findByLikeRZ", 
						procedureName="PKG_CLIENTE.SP_LISTAR_X_RZ",
						resultClasses= Cliente.class,
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RAZON_SOCIAL", type=String.class )
							}					
				),
				*/
				@NamedStoredProcedureQuery(
						name="auto.insert", 
						procedureName="PKG_AUTOS.SP_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT,name="P_CODIGO", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_PLACA", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_ANO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_MODELO", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_MARCA", type=String.class )
									
							}					
				),
				@NamedStoredProcedureQuery(
						name="auto.update", 
						procedureName="PKG_AUTOS.SP_ACTUALIZAR",
						parameters={
								@StoredProcedureParameter(mode=ParameterMode.IN,name="P_CODIGO", type=Integer.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,name="P_PLACA", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,name="P_ANO", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,name="P_MODELO", type=String.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,name="P_MARCA", type=String.class )
									
							}					
				),
				@NamedStoredProcedureQuery(
						name="auto.delete", 
						procedureName="PKG_AUTOS.SP_ELIMINAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_CODIGO", type=Integer.class )
									
							}					
				)

		}
		)
@Entity (name="AUTOS")
public class Autos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO")	
	private long codigo;
	
	@Column(name="PLACA")	
	private String placa;
	
	@Column(name="ANO")	
	private int ano;

	@Column(name="MDELO")	
	private String modelo;
	
	@Column(name="MARCA")	
	private String marca;
	
	@Column(name="ESTADO")	
	private String estado;
	
	
	public Autos() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Autos [codigo=" + codigo + ", placa=" + placa + ", ano=" + ano + ", modelo=" + modelo + ", marca="
				+ marca + ", estado=" + estado + "]";
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
