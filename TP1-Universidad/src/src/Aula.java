package src;

import java.util.ArrayList;

public class Aula {

	private Integer numeroAula;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Docente> docentes;
	private Integer capacidadMaxima;
	private Integer capacidadActual;
	private Boolean disponible;

	public Aula(Integer numeroAula, Integer capacidadMaxima) {
		this.numeroAula = numeroAula;
		this.alumnos = new ArrayList<Alumno>();
		this.docentes = new ArrayList<Docente>();
		this.disponible = true;
		this.capacidadMaxima = capacidadMaxima;
		this.capacidadActual = 0;
	}

	public Integer getNumeroAula() {
		return numeroAula;
	}

	public void setNumeroAula(Integer numeroAula) {
		this.numeroAula = numeroAula;
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

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public void ocuparAula() {
		disponible = false;
	}

	public void liberarAula() {
		disponible = true;
	}

	public Integer getCapacidadActual() {
		return capacidadActual;
	}

	public void setCapacidadActual(Integer capacidadActual) {
		this.capacidadActual = capacidadActual;
	}

	public void aumentarCapacidad() {
		if (capacidadActual < capacidadMaxima) {
			capacidadActual++;
		}
	}

}