package src;

import java.util.ArrayList;

public class Alumno {

	private Integer dni;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String fechaIngreso;
	private ArrayList<Materia> materiasAprobadas;
	private ArrayList<Nota> notas;
	private Materia materiaParcial;
	private Nota notaParcial;
	private Integer recuperatoriosRendidos;

	public Alumno(Integer dni, String nombreAlumno, String apellidoAlumno, String fechaNacimiento,
			String fechaIngreso) {

		this.dni = dni;
		this.nombre = nombreAlumno;
		this.apellido = apellidoAlumno;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.notas = new ArrayList<Nota>();
		this.materiasAprobadas = new ArrayList<Materia>();
		this.recuperatoriosRendidos = 0;
		this.notaParcial = null;
		this.materiaParcial = null;

	}

	public Materia getMateriaParcial() {
		return materiaParcial;
	}

	public void setMateriaParcial(Materia materiaParcial) {
		this.materiaParcial = materiaParcial;
	}

	public Nota getNotaParcial() {
		return notaParcial;
	}

	public void setNotaParcial(Nota notaParcial) {
		this.notaParcial = notaParcial;
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

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public void agregarMateriaAprobada(Materia materia) {
		materiasAprobadas.add(materia);
	}

	public void agregarNota(Nota nota) {
		notas.add(nota);
	}

	public boolean tieneMateriaAprobada(Materia materia) {
		return materiasAprobadas.contains(materia);
	}

	public int getRecuperatoriosRendidos() {
		return recuperatoriosRendidos;
	}

	public void setRecuperatoriosRendidos(int recuperatoriosRendidos) {
		this.recuperatoriosRendidos = recuperatoriosRendidos;
	}

	public boolean tieneParcialAprobado(Materia materia, TipoNota tipoParcial) {
		boolean estaAprobado = false;
		for (Nota nota : notas) {
			if (nota.getTipo() == tipoParcial && nota.getMateria().equals(materia) && nota.getValor() >= 4) {
				estaAprobado = true;
			}
		}
		return estaAprobado;
	}

	public int calcularPromedioDeNotas() {
		int sumaNotas = 0;
		int cantidadNotas = 0;

		for (Nota nota : notas) {
			if (nota.getTipo() == TipoNota.PRIMER_PARCIAL || nota.getTipo() == TipoNota.SEGUNDO_PARCIAL) {
				sumaNotas += nota.getValor();
				cantidadNotas++;
			}
		}

		if (cantidadNotas > 0) {
			return sumaNotas / cantidadNotas;
		} else {
			return 0;
		}

	}

	public int materiasQueFaltanCursar(ArrayList<Materia> materiasDeLaUniversidad) {
		int materiasFaltantes = 0;

		for (Materia materia : materiasDeLaUniversidad) {
			if (!materiasAprobadas.contains(materia)) {
				materiasFaltantes++;
			}
		}

		return materiasFaltantes;

	}
}
