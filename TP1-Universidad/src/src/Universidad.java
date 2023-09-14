package src;

import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList <Materia> materias;
	private ArrayList <Alumno> alumnos;

	public Universidad(String nombreUni) {
		this.nombre = nombreUni;
		this.materias= new ArrayList <Materia>();
		this.alumnos = new ArrayList <Alumno>();
	}

	public Boolean agregarMateria(Materia materiaAAgregar) {
		return materias.add(materiaAAgregar);
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
		
		return alumnos.add(alumnoARegistrar);
	
		
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	
}
