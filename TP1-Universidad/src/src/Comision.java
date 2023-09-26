package src;

import java.util.ArrayList;

public class Comision {

	private Integer id;
	private CicloLectivo cicloLectivo;
	private Materia materia;
	private Turno tipoDeTurno;
	private Aula aulaAsignada;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Docente> docentes;

	public Comision(Integer id, Materia materia, CicloLectivo cicloLectivo, Turno tipoDeTurno) {
		this.id = id;
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
		this.tipoDeTurno = tipoDeTurno;
		this.aulaAsignada=null;
		this.alumnos = new ArrayList<Alumno>();
		this.docentes = new ArrayList<Docente>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Turno getTipoDeTurno() {
		return tipoDeTurno;
	}

	public void setTipoDeTurno(Turno tipoDeTurno) {
		this.tipoDeTurno = tipoDeTurno;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}

	public Aula getAulaAsignada() {
		return aulaAsignada;
	}

	public void setAulaAsignada(Aula aulaAsignada) {
		this.aulaAsignada = aulaAsignada;
	}

	
	
}
