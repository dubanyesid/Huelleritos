package co.edu.ufps.huelleritos.dto;

import java.util.Date;

import lombok.Data;

@Data
public class VacunaDTO {

	private String descripcion;
	private String fecha;
	
	public VacunaDTO() {
		
	}
	
	public VacunaDTO(String descripcion, String fecha) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
