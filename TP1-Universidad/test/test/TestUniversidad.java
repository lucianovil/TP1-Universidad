package test;

import static org.junit.Assert.*;

import org.junit.Test;

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
		
		String lala;
		String lala2;
	}
	
	

}
