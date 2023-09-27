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

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
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

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}

	public ArrayList<Materia> getMateriasCorrelativas() {
		return materiasCorrelativas;
	}

	public void setMateriasCorrelativas(ArrayList<Materia> materiasCorrelativas) {
		this.materiasCorrelativas = materiasCorrelativas;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
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

	public Alumno buscarAlumnoPorID(Alumno alumnoBuscado) {
		for (Alumno alumno : alumnos) {
			if (alumno.equals(alumnoBuscado)) {
				return alumno;
			}
		}
		return null;
	}

	public Materia BuscarMateria(Materia materiaBuscada) {
		for (Materia materia : materias) {
			if (materia.equals(materiaBuscada)) {
				return materia;
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
		if (buscarAulaPorID(aula.getNumeroAula()) == null) {
			return aulas.add(aula);
		}
		return false;
	}

	public Aula buscarAulaPorID(Integer aulaAIngresar) {
		for (int i = 0; i < aulas.size(); i++) {
			if (this.aulas.get(i).getNumeroAula().equals(aulaAIngresar)) {
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

	public Boolean asignarAlumnoALacomision(Comision comision, Alumno alumnoPrueba) {

		if (comisiones.contains(comision) && alumnos.contains(alumnoPrueba)) {
			if (!comision.existeAlumno(alumnoPrueba) && !superaLaCapacidadMaximaDelAula(comision)) {
				comision.getAlumnos().add(alumnoPrueba);
				comision.getAulaAsignada().aumentarCapacidad();
				return true;
			}

		}
		return false;
	}

	private Boolean superaLaCapacidadMaximaDelAula(Comision comision) {
		Boolean seSuperaCapacidadMaxima = false;
		if (comision.getAulaAsignada().getCapacidadActual() >= comision.getAulaAsignada().getCapacidadMaxima()) {
			seSuperaCapacidadMaxima = true;
		}
		return seSuperaCapacidadMaxima;
	}

	public Boolean asignarDocenteAComision(Docente docente, Comision comision) {
		boolean sePudoAsignar = false;

		if (comisiones.contains(comision) && docentes.contains(docente)) {

			if (!comision.existeDocente(docente)) {
				comision.getDocentes().add(docente);
				sePudoAsignar = true;
			}

		}
		return sePudoAsignar;
	}

	public boolean registrarNota(Comision comision, Alumno alumno, Nota nota) {
		if (laNotaEstaEnRangoEntreUnoYDiez(nota)) {

			alumno.agregarNota(nota);
			return true;
		}
		return false;
	}

	private boolean laNotaEstaEnRangoEntreUnoYDiez(Nota nota) {
		return nota.getValor() >= 1 && nota.getValor() <= 10;
	}

	public boolean rendirRecuperatorio(Alumno alumno) {
		boolean puedeRecuperar = false;
		if (alumno.getRecuperatoriosRendidos() >= 1) {
			return puedeRecuperar;
		} else {

			alumno.setRecuperatoriosRendidos(alumno.getRecuperatoriosRendidos() + 1);
			puedeRecuperar = true;
		}
		return puedeRecuperar;
	}

	public boolean cargarNotaFinal(Comision comision, Alumno alumno, Nota notaFinal) {
		boolean sePuedeCargar = false;
		if (notaFinal.getTipo() != TipoNota.FINAL) {
			return sePuedeCargar;
		}

		boolean tienePrimerParcialAprobado = alumno.tieneParcialAprobado(comision.getMateria(),
				TipoNota.PRIMER_PARCIAL);
		boolean tieneSegundoParcialAprobado = alumno.tieneParcialAprobado(comision.getMateria(),
				TipoNota.SEGUNDO_PARCIAL);

		if (tienePrimerParcialAprobado && tieneSegundoParcialAprobado) {

			alumno.agregarNota(notaFinal);
			alumno.agregarMateriaAprobada(comision.getMateria());
			sePuedeCargar = true;
		}

		return sePuedeCargar;
	}

	public Nota obtenerNota(Alumno alumnoPrueba, Materia materia) {
		Alumno alumno = buscarAlumnoPorID(alumnoPrueba);

		for (Nota nota : alumno.getNotas()) {
			if (nota.getMateria().equals(materia)) {
				return nota;
			}
		}
		return null;

	}

	public ArrayList<Materia> obtenerMateriasAprobadasParaUnAlumno(Alumno alumnoPrueba) {

		ArrayList<Materia> materiasAprobadas = new ArrayList<>();

		for (Materia materia : alumnoPrueba.getMateriasAprobadas()) {

			if (alumnoPrueba.tieneMateriaAprobada(materia)) {

				materiasAprobadas.add(materia);
			}
		}

		return materiasAprobadas;
	}
}
