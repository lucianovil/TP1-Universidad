package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Alumno;
import src.CicloLectivo;
import src.Comision;
import src.Docente;
import src.Materia;
import src.Turno;
import src.Universidad;

public class TestUniversidad {

	@Test
	public void queSePuedaAgregarUnaMateriaAUnaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer idMateria = 1;
		String nombreMateria = "PB1";
		Materia pb1 = new Materia(idMateria, nombreMateria);

		assertTrue(unlam.agregarMateria(pb1));

	}

	@Test
	public void queNoSePuedaAgregarUnaMateriaAUnaUniversidadConMismoID() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer idMateria = 1;
		String nombreMateria = "PB1";
		Materia pb1 = new Materia(idMateria, nombreMateria);
		Integer idMateria2 = 1;
		String nombreMateria2 = "PB2";
		Materia pb2 = new Materia(idMateria2, nombreMateria2);

		unlam.agregarMateria(pb1);
		assertFalse(unlam.agregarMateria(pb2));

	}

	@Test
	public void queSePuedaAgregarUnAlumnoEnLaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer dni = 39415111;
		String nombreAlumno = "Lucho";
		String apellidoAlumno = "Vilan";
		String fechaNacimiento = "22/03/1995";
		String fechaIngreso = "01/04/2022";

		Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);

		assertTrue(unlam.registrarAlumno(alumnoPrueba));

	}

	@Test
	public void queNoSePuedaAgregarUnAlumnoEnLaUniversidadConMismoDni() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		String nombreAlumno = "Lucho";
		String apellidoAlumno = "Vilan";
		String fechaNacimiento = "22/03/1995";
		String fechaIngreso = "01/04/2022";
		Integer dni = 39415111;

		String nombreAlumnoDos = "Jose";
		String apellidoAlumnoDos = "Velez";
		String fechaNacimientoDos = "22/03/1994";
		String fechaIngresoDos = "05/04/2022";
		Integer dniDos = 39415111;

		Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
		Alumno alumnoPruebaDos = new Alumno(dniDos, nombreAlumnoDos, apellidoAlumnoDos, fechaNacimientoDos,
				fechaIngresoDos);

		unlam.registrarAlumno(alumnoPrueba);
		assertFalse(unlam.registrarAlumno(alumnoPruebaDos));

	}

	@Test
	public void queSePuedaAgregarUnDocenteEnLaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer dNIDocente = 1;
		String nombreDocente = "Juan";
		String apellidoDocente = "Monteagudo";
		String fechaNacimiento = "04/10/1983";
		String fechaIngreso = "01/04/2019";

		Docente docentePrueba = new Docente(dNIDocente, nombreDocente, apellidoDocente, fechaNacimiento, fechaIngreso);

		assertTrue(unlam.registrarDocente(docentePrueba));

	}

	@Test
	public void queNoSePuedaAgregarUnDocenteAUnaUniversidadConMismoDNI() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer dNIDocente = 1;
		String nombreDocente = "Juan";
		String apellidoDocente = "Monteagudo";
		String fechaNacimiento = "04/10/1983";
		String fechaIngreso = "01/04/2019";

		Integer dNIDocente2 = 1;
		String nombreDocente2 = "Andy";
		String apellidoDocente2 = "Borgeat";
		String fechaNacimiento2 = "15/07/1985";
		String fechaIngreso2 = "01/04/2019";
		Docente docentePrueba = new Docente(dNIDocente, nombreDocente, apellidoDocente, fechaNacimiento, fechaIngreso);
		Docente docentePrueba2 = new Docente(dNIDocente2, nombreDocente2, apellidoDocente2, fechaNacimiento2,
				fechaIngreso2);

		unlam.registrarDocente(docentePrueba);
		assertFalse(unlam.registrarDocente(docentePrueba2));

	}

	@Test
	public void queSePuedaCrearUnCicloLectivo() {

		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		String fechaInicio = "04/04/2023";
		String fechaFinalizacion = "25/07/2023";
		String fechaInscripcion = "03/03/2023";

		CicloLectivo UnoC2023 = new CicloLectivo(id, fechaInicio, fechaFinalizacion, fechaInscripcion);

		assertTrue(unlam.agregarCicloLectivo(UnoC2023));

	}

	@Test
	public void queNoSePuedaCrearUnCicloLectivoConMismoId() {

		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		String fechaInicio = "04/04/2023";
		String fechaFinalizacion = "25/07/2023";
		String fechaInscripcion = "03/03/2023";

		CicloLectivo UnoC2023 = new CicloLectivo(id, fechaInicio, fechaFinalizacion, fechaInscripcion);

		Integer id2 = 1;
		String fechaInicio2 = "04/08/2023";
		String fechaFinalizacion2 = "25/12/2023";
		String fechaInscripcion2 = "03/03/2023";

		CicloLectivo DosC2023 = new CicloLectivo(id2, fechaInicio2, fechaFinalizacion2, fechaInscripcion2);

		unlam.agregarCicloLectivo(UnoC2023);
		assertFalse(unlam.agregarCicloLectivo(DosC2023));

	}

	@Test
	public void queNoSePuedaCrearUnCicloLectivoSuperpuestoDeFecha() {

		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		String fechaInicio = "2023-03-04";
		String fechaFinalizacion = "2023-07-06";
		String fechaInscripcion = "2023-03-03";

		CicloLectivo UnoC2023 = new CicloLectivo(id, fechaInicio, fechaFinalizacion, fechaInscripcion);

		Integer id2 = 2;
		String fechaInicio2 = "2023-05-04";
		String fechaFinalizacion2 = "2023-09-06";
		String fechaInscripcion2 = "2023-08-02";

		CicloLectivo DosC2023 = new CicloLectivo(id2, fechaInicio2, fechaFinalizacion2, fechaInscripcion2);

		unlam.agregarCicloLectivo(UnoC2023);
		assertFalse(unlam.agregarCicloLectivo(DosC2023));

	}
	
	@Test
	public void queSePuedaAgregarUnaComisionAUnaUniversidad() {

		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		String fechaInicio = "2023-03-04";
		String fechaFinalizacion = "2023-07-06";
		String fechaInscripcion = "2023-03-03";
		CicloLectivo UnoC2023 = new CicloLectivo(id, fechaInicio, fechaFinalizacion, fechaInscripcion);
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision Comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);

		unlam.agregarComision(Comision1);
		assertNotNull(Comision1);

	}
	
	@Test
	public void queNoSePuedaAgregarUnaComisionRepetidaPorIDAUnaUniversidad() {

		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision Comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);

		Integer id2 = 1;
		Materia pb2 = new Materia(2, "pb2");
		CicloLectivo DosC20232 = new CicloLectivo(1, "2023-07-04", "2023-11-06", "2023-07-03");
		Turno TipoDeTurno2 = Turno.NOCHE;

		Comision Comision2 = new Comision(id2, pb2, DosC20232, TipoDeTurno2);
		
		unlam.agregarComision(Comision1);
		assertFalse(unlam.agregarComision(Comision2));

	}
	
	@Test
	public void queNoSePuedaAgregarUnaComisionRepetidaPorCaracteristicasAUnaUniversidad() {

		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision Comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);

		Integer id2 = 2;
		Materia pb12 = new Materia(1, "pb1");
		CicloLectivo UnoC20232 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno2 = Turno.MAÑANA;

		Comision Comision2 = new Comision(id2, pb12, UnoC20232, TipoDeTurno2);
		
		unlam.agregarComision(Comision1);
		assertFalse(unlam.agregarComision(Comision2));

	}
	
}
