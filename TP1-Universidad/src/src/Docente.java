package src;

public class Docente {

	private Integer dNIDocente;
	private String nombreDocente;
	private String apellidoDocente;
	private String fechaNacimiento;
	private String fechaIngreso;

	public Docente(Integer dNIDocente, String nombreDocente, String apellidoDocente, String fechaNacimiento,
			String fechaIngreso) {
		this.dNIDocente = dNIDocente;
		this.nombreDocente = nombreDocente;
		this.apellidoDocente = apellidoDocente;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getdNIDocente() {
		return dNIDocente;
	}

	public void setdNIDocente(Integer dNIDocente) {
		this.dNIDocente = dNIDocente;
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public String getApellidoDocente() {
		return apellidoDocente;
	}

	public void setApellidoDocente(String apellidoDocente) {
		this.apellidoDocente = apellidoDocente;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
