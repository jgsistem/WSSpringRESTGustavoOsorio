package pe.edu.galaxy.training.ws.rest.bean;

public class AutoBean {

    private long codigo;	
	private String placa;		
	private int ano;	
	private String modelo;	
	private String marca;
	private String estado;
	
		
	public AutoBean() {
		
	}
	
	@Override
	public String toString() {
		return "AutoBean [codigo=" + codigo + ", placa=" + placa + ", ano=" + ano + ", modelo=" + modelo + ", marca="
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
	
	
	
	
	
}
