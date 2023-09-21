package src;

import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Docente> docentes;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Comision> comisiones;

	public Universidad(String nombreUni) {
		this.nombre = nombreUni;
		this.materias = new ArrayList<Materia>();
		this.alumnos = new ArrayList<Alumno>();
		this.docentes = new ArrayList<Docente>();
		this.ciclosLectivos = new ArrayList<CicloLectivo>();
		this.comisiones = new ArrayList<Comision>();
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

	public boolean registrarDocente(Docente docenteARegistrar) {
		if (buscarDocentePorDni(docenteARegistrar.getdNIDocente()) == null) {
			return docentes.add(docenteARegistrar);
		}
		return false;
	}

	public Docente buscarDocentePorDni(Integer dNIDocente) {
		for (int i = 0; i < docentes.size(); i++) {
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
		if (buscarComisionPorID(comisionAAgregar.getId()) == null
				&& buscarComisionPorCaracteristicas(comisionAAgregar.getMateria(), comisionAAgregar.getCicloLectivo(),
						comisionAAgregar.getTipoDeTurno()) == null) {
			return comisiones.add(comisionAAgregar);
		}
		return false;
	}

	public Comision buscarComisionPorID(Integer iDComision) {
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getId().equals(iDComision)) {
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

}