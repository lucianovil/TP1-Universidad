package src;

import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList <Materia> materias;
	private ArrayList <Alumno> alumnos;
	private ArrayList <Docente> docentes;

	public Universidad(String nombreUni) {
		this.nombre = nombreUni;
		this.materias= new ArrayList <Materia>();
		this.alumnos = new ArrayList <Alumno>();
		this.docentes = new ArrayList <Docente>();
	}

	public Boolean agregarMateria(Materia materiaAAgregar) {
		if(buscarMateriaPorID(materiaAAgregar.getId()) == null) {
		return materias.add(materiaAAgregar);
		}
		return false;
	}
	
	public Materia buscarMateriaPorID(Integer iDMateria) {
		for (int i=0; i<materias.size(); i++) {
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
		
		return alumnos.add(alumnoARegistrar);
	
		
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public boolean registrarDocente(Docente docenteARegistrar) {
		if(buscarDocentePorDni(docenteARegistrar.getdNIDocente()) == null) {
		return docentes.add(docenteARegistrar);
		}
		return false;
	}
	
	public Docente buscarDocentePorDni(Integer dNIDocente) {
		for (int i=0; i<docentes.size(); i++) {
			if (this.docentes.get(i).getdNIDocente().equals(dNIDocente)) {
				return this.docentes.get(i);
			}
		}
		return null;
		
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}

	
	
}
