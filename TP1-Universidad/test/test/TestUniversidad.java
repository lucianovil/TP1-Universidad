package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Alumno;
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
		
		assertTrue(unlam.agregarMateria(pb1));
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
	
	

}
