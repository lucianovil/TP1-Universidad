package src;

public class Alumno {

	private Integer dni;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String fechaIngreso;
	

	public Alumno(Integer dni, String nombreAlumno, String apellidoAlumno, String fechaNacimiento,
			String fechaIngreso) {
		
		this.dni = dni;
		this.nombre = nombreAlumno;
		this.apellido = apellidoAlumno;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		
		
	}



	public Integer getDni() {
		return dni;
	}



	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
