package src;

import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Docente> docentes;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Materia> materiasCorrelativas;
	private ArrayList<Aula> aulas;

	public Universidad(String nombreUni) {
		this.nombre = nombreUni;
		this.materias = new ArrayList<Materia>();
		this.alumnos = new ArrayList<Alumno>();
		this.docentes = new ArrayList<Docente>();
		this.ciclosLectivos = new ArrayList<CicloLectivo>();
		this.comisiones = new ArrayList<Comision>();
		this.materiasCorrelativas = new ArrayList<Materia>();
		this.aulas = new ArrayList<Aula>();
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

	public ArrayList<CicloLectivo> getCiclosLectivos() {
		return ciclosLectivos;
	}

	public void setCiclosLectivos(ArrayList<CicloLectivo> ciclosLectivos) {
		this.ciclosLectivos = ciclosLectivos;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
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

	public boolean registrarDocente(Docente docenteARegistrar) {
		if (buscarDocentePorDni(docenteARegistrar) != null) {
			return false;
		}
		return docentes.add(docenteARegistrar);
	}

	public Docente buscarDocentePorDni(Docente docenteARegistrar) {
		for (int i = 0; i < docentes.size(); i++) {
			if (this.docentes.get(i).getdNIDocente().equals(docenteARegistrar.getdNIDocente())) {
				return this.docentes.get(i);
			}
		}
		return null;

	}

	public Docente buscarDocente(Docente DocenteAIngresar) {
		for (int i = 0; i < docentes.size(); i++) {
			if (this.docentes.contains(DocenteAIngresar)) {
				return this.docentes.get(i);
			}
		}
		return null;

	}

	public Boolean agregarCicloLectivo(CicloLectivo CicloLectivoAAgregar) {

		boolean sePudoAgregarCicloLectivo = false;

		if (!existeCicloLectivo(CicloLectivoAAgregar) && !estaSuperPuestoDeFecha(CicloLectivoAAgregar)) {

			ciclosLectivos.add(CicloLectivoAAgregar);
			sePudoAgregarCicloLectivo = true;
		}

		return sePudoAgregarCicloLectivo;

	}

//no se pueden superponer los rangos de fechas entre 2 ciclos distintos 

	private boolean estaSuperPuestoDeFecha(CicloLectivo cicloLectivoAAgregar) {
		boolean estaSuperpuesto = false;
		int indice = 0;

		while (indice < ciclosLectivos.size() && !estaSuperpuesto) {
			if (ciclosLectivos.get(indice).getFechaFinalizacion().compareTo(cicloLectivoAAgregar.getFechaInicio()) > 0
					&& ciclosLectivos.get(indice).getFechaInicio()
							.compareTo(cicloLectivoAAgregar.getFechaFinalizacion()) < 0)
				estaSuperpuesto = true;
		}

		return estaSuperpuesto;
	}

	public Boolean existeCicloLectivo(CicloLectivo CicloLectivoIngresado) {
		boolean existe = false;
		int indice = 0;
		while (indice < ciclosLectivos.size() && !existe) {
			if (ciclosLectivos.get(indice).getId().equals(CicloLectivoIngresado.getId())) {
				existe = true;
			}
			indice++;
		}
		return existe;
	}

	public Boolean agregarComision(Comision comisionAAgregar) {
		if (buscarComisionPorID(comisionAAgregar) == null
				&& buscarComisionPorCaracteristicas(comisionAAgregar.getMateria(), comisionAAgregar.getCicloLectivo(),
						comisionAAgregar.getTipoDeTurno()) == null) {
			return comisiones.add(comisionAAgregar);
		}
		return false;
	}

	public Comision buscarComisionPorID(Comision iDComision) {
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getId().equals(iDComision.getId())) {
				return this.comisiones.get(i);
			}
		}
		return null;

	}

	public Comision buscarComisionPorCaracteristicas(Materia materia, CicloLectivo cicloLectivo, Turno turno) {
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getMateria().getId().equals(materia.getId())
					&& this.comisiones.get(i).getCicloLectivo().getId().equals(cicloLectivo.getId())
					&& this.comisiones.get(i).getTipoDeTurno().equals(turno)) {
				return this.comisiones.get(i);
			}
		}
		return null;

	}

	public Boolean asignarDocenteAComision(Docente docenteDNI, Comision iDcomision) {
		boolean NosePuedeAsignar = false;
		if (buscarDocente(docenteDNI) != null && buscarComisionPorID(iDcomision) != null) {
			for (int i = 0; i < iDcomision.getDocentes().size(); i++) {
				if (iDcomision.getDocentes().get(i).getdNIDocente().equals(docenteDNI.getdNIDocente())) {
					return NosePuedeAsignar;
				}
				iDcomision.getDocentes().add(docenteDNI);
				NosePuedeAsignar = true;
			}

		}
		return NosePuedeAsignar;
	}
	
	public boolean agregarCorrelativa(Materia materiaCorrelativa, Materia materia) {
		boolean sePudoAgregar = false;

		if (materias.contains(materia) && materias.contains(materiaCorrelativa)) {
			materiasCorrelativas.add(materiaCorrelativa);
			sePudoAgregar = true;
		}
		return sePudoAgregar;

	}

	public boolean eliminarCorrelativa(Materia materiaCorrelativa, Materia materia) {
		boolean sePudoEliminar = false;

		if (materias.contains(materia) && materias.contains(materiaCorrelativa)
				&& materiasCorrelativas.contains(materiaCorrelativa)) {
			materiasCorrelativas.remove(materiaCorrelativa);
			sePudoEliminar = true;
		}
		return sePudoEliminar;

	}

	public Boolean registrarAula(Aula aula) {
		if (buscarAulaPorID(aula) == null) {
			return aulas.add(aula);
		}
		return false;
	}

	public Aula buscarAulaPorID(Aula aulaAIngresar) {
		for (int i = 0; i < aulas.size(); i++) {
			if (this.aulas.contains(aulaAIngresar)) {
				return this.aulas.get(i);
			}
		}
		return null;

	}

	public Boolean asignarAulaAlaComision(Comision comisionAAgregar, Docente docenteDesignado) {
		Aula aulaDisponible = buscarAulaDisponible();
		if (comisiones.contains(comisionAAgregar) && docentes.contains(docenteDesignado)) {
			if (aulaDisponible != null) {
				comisionAAgregar.setAulaAsignada(aulaDisponible);
				aulaDisponible.setDisponible(false);
				return true;
			}

		}
		return false;
	}

	public Aula buscarAulaDisponible() {
		for (Aula aula : aulas) {
			if (aula.getDisponible()) {
				return aula;
			}
		}
		return null;
	}

}