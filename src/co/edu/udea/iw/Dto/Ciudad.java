package co.edu.udea.iw.Dto;
/**
 * @author Leon Dario Arango Amaya 
 * leon.arango@udea.edu.co
 *  Data Transfer Object
 *  Object
 *  */


public class Ciudad {
	
	private int codigo;
	private String nombre;
	private String CodigoArea;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return CodigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		CodigoArea = codigoArea;
	}
	
	
}
