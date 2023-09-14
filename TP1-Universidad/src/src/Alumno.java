package src;

public class Alumno {

	private Integer id;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String fechaIngreso;

	public Alumno(Integer idAlumno, String nombreAlumno, String apellidoAlumno, String fechaNacimiento,
			String fechaIngreso) {
		
		this.id = idAlumno;
		this.nombre = nombreAlumno;
		this.apellido = apellidoAlumno;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
