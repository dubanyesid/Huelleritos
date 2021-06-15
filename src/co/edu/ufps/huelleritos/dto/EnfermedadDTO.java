package co.edu.ufps.huelleritos.dto;

import lombok.Data;

@Data
public class EnfermedadDTO {

	
	private String tratamiento;
	private String fechaInicio;
	private String fechaFin;
	
	public EnfermedadDTO() {
	}
	
	public EnfermedadDTO(String tratamiento, String fechaInicio, String fechaFin) {
		super();
		this.tratamiento = tratamiento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
}
