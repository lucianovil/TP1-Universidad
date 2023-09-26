package src;

import java.util.ArrayList;

public class Aula {

	private Integer numeroAula;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Docente> docentes;
	private static Integer CANTIDAD_MAXIMA_ALUMNOS=50;
	private Boolean disponible;

	public Aula(Integer numeroAula) {
		this.numeroAula= numeroAula;
		this.alumnos = new ArrayList<Alumno>(CANTIDAD_MAXIMA_ALUMNOS);
		this.docentes = new ArrayList<Docente>();
		this.disponible=true;
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

	public static Integer getCANTIDAD_MAXIMA_ALUMNOS() {
		return CANTIDAD_MAXIMA_ALUMNOS;
	}

	public static void setCANTIDAD_MAXIMA_ALUMNOS(Integer cANTIDAD_MAXIMA_ALUMNOS) {
		CANTIDAD_MAXIMA_ALUMNOS = cANTIDAD_MAXIMA_ALUMNOS;
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

	
}
