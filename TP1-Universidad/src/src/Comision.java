package src;

public class Comision {

	private Integer id;
	private CicloLectivo cicloLectivo;
	private Materia materia;
	private Turno tipoDeTurno;

	public Comision(Integer id, Materia materia, CicloLectivo cicloLectivo, Turno tipoDeTurno) {
		this.id =id;
		this.materia= materia;
		this.cicloLectivo =cicloLectivo;
		this.tipoDeTurno =tipoDeTurno;
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
	
	

}
