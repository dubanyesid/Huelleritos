package co.edu.ufps.huelleritos.dto;

import lombok.Data;

@Data
public class OperacionDTO {


	private String observacion;
	private String fechaOperacion;
	private String fechaRecuperacion;
	
	public OperacionDTO() {
		
	}
	
	public OperacionDTO(String observacion, String fechaOperacion, String fechaRecuperacion) {
		super();
		this.observacion = observacion;
		this.fechaOperacion = fechaOperacion;
		this.fechaRecuperacion = fechaRecuperacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	public String getFechaRecuperacion() {
		return fechaRecuperacion;
	}
	public void setFechaRecuperacion(String fechaRecuperacion) {
		this.fechaRecuperacion = fechaRecuperacion;
	}
	
	
	
}
