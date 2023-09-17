package src;

import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;

	public Universidad(String nombreUni) {
		this.nombre = nombreUni;
		this.materias = new ArrayList<Materia>();
		this.alumnos = new ArrayList<Alumno>();
	}

	public Boolean agregarMateria(Materia materiaAAgregar) {
		if (buscarMateriaPorID(materiaAAgregar.getId()) == null) {
			return materias.add(materiaAAgregar);
		}
		return false;
	}

	public Materia buscarMateriaPorID(Integer iDMateria) {
		for (int i = 0; i < materias.size(); i++) {
			if (this.materias.get(i).getId().equals(iDMateria)) {
				return this.materias.get(i);
			}
		}
		return null;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	public Boolean registrarAlumno(Alumno alumnoARegistrar) {
		boolean sePudoAgregarAlumno = false;

		if (!existeAlumno(alumnoARegistrar)) {

			alumnos.add(alumnoARegistrar);
			sePudoAgregarAlumno = true;
		}

		return sePudoAgregarAlumno;

	}

	public Boolean existeAlumno(Alumno alumnoIngresado) {
		boolean existe = false;
		int indice = 0;
		while (indice < alumnos.size() && !existe) {
			if (alumnos.get(indice).getDni().equals(alumnoIngresado.getDni())) {
				existe = true;
			}
			indice++;
		}
		return existe;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
