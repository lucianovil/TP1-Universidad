package src;

import java.util.ArrayList;

public class CicloLectivo {

	private Integer id;
	private String fechaInicio;
	private String fechaFinalizacion;
	private String fechaInscripcion;
	private ArrayList<Comision> comisiones;

	public CicloLectivo(Integer id, String fechaInicio, String fechaFinalizacion, String fechaInscripcion) {

		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.fechaInscripcion = fechaInscripcion;
		this.comisiones = new ArrayList<Comision>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

}