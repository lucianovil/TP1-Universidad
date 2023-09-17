package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Alumno;
import src.Docente;
import src.Materia;
import src.Universidad;

public class TestUniversidad {

	@Test
	public void queSePuedaAgregarUnaMateriaAUnaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer idMateria = 1;
		String nombreMateria = "PB1";
		Materia pb1 = new Materia (idMateria, nombreMateria);
		
		assertTrue(unlam.agregarMateria(pb1));
		
	}
	
	@Test
	public void queNoSePuedaAgregarUnaMateriaAUnaUniversidadConMismoID() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer idMateria = 1;
		String nombreMateria = "PB1";
		Materia pb1 = new Materia (idMateria, nombreMateria);
		Integer idMateria2 = 1;
		String nombreMateria2 = "PB2";
		Materia pb2 = new Materia (idMateria2, nombreMateria2);
		
		unlam.agregarMateria(pb1);
		assertFalse(unlam.agregarMateria(pb2));
		
	}
	
	@Test 
	public void queSePuedaAgregarUnAlumnoEnLaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		
		Integer idAlumno = 1;
		String nombreAlumno = "Lucho";
		String apellidoAlumno = "Vilan";
		String fechaNacimiento = "22/03/1995";
		String fechaIngreso = "01/04/2022";
		
		Alumno alumnoPrueba = new Alumno(idAlumno,nombreAlumno,apellidoAlumno,fechaNacimiento,fechaIngreso);
		
		assertTrue(unlam.registrarAlumno(alumnoPrueba));
		
	}
	
	@Test 
	public void queSePuedaAgregarUnDocenteEnLaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		
		Integer idDocente = 1;
		String nombreDocente = "Juan";
		String apellidoDocente = "Monteagudo";
		String fechaNacimiento = "04/10/1983";
		String fechaIngreso = "01/04/2019";
		
		Docente docentePrueba = new Docente(idDocente,nombreDocente,apellidoDocente,fechaNacimiento,fechaIngreso);
		
		assertTrue(unlam.registrarDocente(docentePrueba));
		
	}
	
	@Test
	public void queNoSePuedaAgregarUnDocenteAUnaUniversidadConMismoDNI() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer idDocente = 1;
		String nombreDocente = "Juan";
		String apellidoDocente = "Monteagudo";
		String fechaNacimiento = "04/10/1983";
		String fechaIngreso = "01/04/2019";
		
		Integer idDocente2 = 1;
		String nombreDocente2 = "Andy";
		String apellidoDocente2 = "Borgeat";
		String fechaNacimiento2 = "15/07/1985";
		String fechaIngreso2 = "01/04/2019";
		Docente docentePrueba = new Docente(idDocente,nombreDocente,apellidoDocente,fechaNacimiento,fechaIngreso);
		Docente docentePrueba2 = new Docente(idDocente2,nombreDocente2,apellidoDocente2,fechaNacimiento2,fechaIngreso2);
		
		unlam.registrarDocente(docentePrueba);
		assertFalse(unlam.registrarDocente(docentePrueba2));
		
	}

}
