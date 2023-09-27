package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import org.junit.Test;

import src.Alumno;
import src.Aula;
import src.CicloLectivo;
import src.Comision;
import src.Docente;
import src.Materia;
import src.Nota;
import src.TipoNota;
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
		String fechaNacimiento = "1995-03-22";
		String fechaIngreso = "2022-04-01";

		Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);

		assertTrue(unlam.registrarAlumno(alumnoPrueba));

	}

	@Test
	public void queNoSePuedaAgregarUnAlumnoEnLaUniversidadConMismoDni() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		String nombreAlumno = "Lucho";
		String apellidoAlumno = "Vilan";
		String fechaNacimiento = "1995-03-22";
		String fechaIngreso = "2022-04-01";
		Integer dni = 39415111;

		String nombreAlumnoDos = "Jose";
		String apellidoAlumnoDos = "Velez";
		String fechaNacimientoDos = "1994-03-22";
		String fechaIngresoDos = "2022-04-05";
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
		String fechaNacimiento = "1983-10-04";
		String fechaIngreso = "2019-04-01";

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
		String fechaNacimiento = "1983-10-04";
		String fechaIngreso = "2019-04-01";

		Integer dNIDocente2 = 1;
		String nombreDocente2 = "Andy";
		String apellidoDocente2 = "Borgeat";
		String fechaNacimiento2 = "1985-07-15";
		String fechaIngreso2 = "2019-04-01";
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
		String fechaInicio = "2023-04-04";
		String fechaFinalizacion = "2023-07-25";
		String fechaInscripcion = "2023-03-03";

		CicloLectivo UnoC2023 = new CicloLectivo(id, fechaInicio, fechaFinalizacion, fechaInscripcion);

		assertTrue(unlam.agregarCicloLectivo(UnoC2023));

	}

	@Test
	public void queNoSePuedaCrearUnCicloLectivoConMismoId() {

		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		String fechaInicio = "2023-04-04";
		String fechaFinalizacion = "2023-07-25";
		String fechaInscripcion = "2023-03-03";

		CicloLectivo UnoC2023 = new CicloLectivo(id, fechaInicio, fechaFinalizacion, fechaInscripcion);

		Integer id2 = 1;
		String fechaInicio2 = "2023-08-04";
		String fechaFinalizacion2 = "2023-12-25";
		String fechaInscripcion2 = "2023-03-03";

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



	@Test
	public void queSePuedaAgregarUnaCorrelativa() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer idMateria = 1;
		String nombreMateria = "PB1";
		Materia pb1 = new Materia(idMateria, nombreMateria);
		unlam.agregarMateria(pb1);

		Integer idMateria2 = 2;
		String nombreMateria2 = "PB2";
		Materia pb2 = new Materia(idMateria2, nombreMateria2);
		unlam.agregarMateria(pb2);

		assertTrue(unlam.agregarCorrelativa(pb2, pb1));

	}

	@Test
	public void queSePuedaEliminarUnaCorrelativa() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer idMateria = 1;
		String nombreMateria = "PB1";
		Materia pb1 = new Materia(idMateria, nombreMateria);
		unlam.agregarMateria(pb1);

		Integer idMateria2 = 2;
		String nombreMateria2 = "PB2";
		Materia pb2 = new Materia(idMateria2, nombreMateria2);
		unlam.agregarMateria(pb2);
		unlam.agregarCorrelativa(pb2, pb1);
		assertTrue(unlam.eliminarCorrelativa(pb2, pb1));

	}
	
	@Test 
	public void queSePuedaRegistrarDosAulasEnLaUniversidad() { 
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Integer numeroAula = 1;
		Integer numeroAula2 = 2;
		Aula aula1 = new Aula(numeroAula);
		Aula aula2 = new Aula(numeroAula2);
		unlam.registrarAula(aula1);
		unlam.registrarAula(aula2);
		Integer valorEsperado = 2;
		Integer valorObtenido = unlam.getAulas().size();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaAsignarAulaALaComision() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);
		unlam.agregarComision(comision1);
		Docente docentePrueba = new Docente(1, "Juan", "Monteagudo", "1983-10-04", "2019-04-01");
		unlam.registrarDocente(docentePrueba);
		Integer numeroAula = 1;
		Aula aula1 = new Aula(numeroAula);
		unlam.registrarAula(aula1);
		
		assertTrue(unlam.asignarAulaAlaComision(comision1, docentePrueba));

	}
	
	@Test
	public void asignarAlumnoALaComision() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);
		unlam.agregarComision(comision1);
		String nombreAlumno = "Lucho";
		String apellidoAlumno = "Vilan";
		String fechaNacimiento = "1995-03-22";
		String fechaIngreso = "2022-04-01";
		Integer dni = 39415111;
		Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(alumnoPrueba);
	
		assertTrue(unlam.asignarAlumnoALacomision(comision1, alumnoPrueba));
		

	}

	
	@Test
	public void queNoSePuedaAsignarElMismoAlumnoALaComision() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);
		unlam.agregarComision(comision1);
		String nombreAlumno = "Lucho";
		String apellidoAlumno = "Vilan";
		String fechaNacimiento = "1995-03-22";
		String fechaIngreso = "2022-04-01";
		Integer dni = 39415111;
		Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(alumnoPrueba);
		
		unlam.asignarAlumnoALacomision(comision1, alumnoPrueba);
		
		
		assertFalse(unlam.asignarAlumnoALacomision(comision1, alumnoPrueba));
		

	}
	
	@Test
	public void queNoSePuedaAsignarAlMismoProfesorEnLaComision() {

		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision Comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);
		unlam.agregarComision(Comision1);
		Docente docentePrueba = new Docente(1, "Juan", "Monteagudo", "1983-10-04", "2019-04-01");
		unlam.registrarDocente(docentePrueba);
	
		unlam.asignarDocenteAComision(docentePrueba, Comision1);

		assertFalse(unlam.asignarDocenteAComision(docentePrueba, Comision1));
	

	}
	
	@Test
	public void queElAlumnoSePuedaInscribirEnLaComisionSoloElDiaDeLaInscripcion() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);
		unlam.agregarComision(comision1);
		String nombreAlumno = "Lucho";
		String apellidoAlumno = "Vilan";
		String fechaNacimiento = "1995-03-22";
		String fechaIngreso = "2022-04-01";
		Integer dni = 39415111;
		Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(alumnoPrueba);
		LocalDate fecha = LocalDate.of(2023, 9, 15);
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaComoTexto = fecha.format(formateador);
		unlam.actualizarFecha(fechaComoTexto);

		
		assertTrue(unlam.asignarAlumnoALacomision(comision1, alumnoPrueba));
		

	}
	
	@Test
	public void registrarNotaValidaEntre1Y10() {

	    String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);

		Integer id = 1;
		Materia pb1 = new Materia(1, "pb1");
		CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		Turno TipoDeTurno = Turno.MAÑANA;

		Comision comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);
		unlam.agregarComision(comision1);
		String nombreAlumno = "Lucho";
		String apellidoAlumno = "Vilan";
		String fechaNacimiento = "1995-03-22";
		String fechaIngreso = "2022-04-01";
		Integer dni = 39415111;
		Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
	   
	    Nota nota = new Nota(8, TipoNota.PRIMER_PARCIAL,pb1); // Asegúrate de configurar el tipo correcto aquí
	    boolean resultado = unlam.registrarNota(comision1, alumnoPrueba, nota);
	    
	 
	    assertTrue(resultado);
	}
	
	
//	@Test
//	public void registrarNotaMayorIgualA7SinCorrelativasAprobadas() {
//	    
//	    
//		  String nombreUni = "Unlam";
//			Universidad unlam = new Universidad(nombreUni);
//
//			Integer id = 1;
//			Materia pb1 = new Materia(1, "pb1");
//			CicloLectivo UnoC2023 = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
//			Turno TipoDeTurno = Turno.MAÑANA;
//
//			Comision comision1 = new Comision(id, pb1, UnoC2023, TipoDeTurno);
//			unlam.agregarComision(comision1);
//			String nombreAlumno = "Lucho";
//			String apellidoAlumno = "Vilan";
//			String fechaNacimiento = "1995-03-22";
//			String fechaIngreso = "2022-04-01";
//			Integer dni = 39415111;
//			Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
//		 
//	  
//	    Nota nota = new Nota(8, TipoNota.PRIMER_PARCIAL, pb1); 
//	    boolean resultado = unlam.registrarNota(comision1, alumnoPrueba, nota);
//	    
//	    
//	    assertFalse(resultado);
//	}
	
	
	@Test
	public void alumnoNoPuedeRendirDosRecuperatorios() {
	   
	    String nombreUni = "Unlam";
	    Universidad unlam = new Universidad(nombreUni);

	    Integer dni = 39415111;
	    String nombreAlumno = "Juan";
	    String apellidoAlumno = "Acunia";
	    String fechaNacimiento = "1995-01-01";
	    String fechaIngreso = "2022-03-01";
	    Alumno alumno = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
	    unlam.rendirRecuperatorio(alumno); 
	    assertFalse(unlam.rendirRecuperatorio(alumno));
	}
	
	
	 
	 

	    @Test
	    public void cargarNotaFinalConParcialesAprobados() {
	      
	        String nombreUni = "Unlam";
	        Universidad unlam = new Universidad(nombreUni);

	        Integer id = 1;
	        Materia pb1 = new Materia(id, "PB1");
	        CicloLectivo cicloLectivo = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
	        Turno turno = Turno.MAÑANA;

	        Comision comision1 = new Comision(id, pb1, cicloLectivo, turno);
	        unlam.agregarComision(comision1);

	        String nombreAlumno = "Lucho";
	        String apellidoAlumno = "Vilan";
	        String fechaNacimiento = "1995-03-22";
	        String fechaIngreso = "2022-04-01";
	        Integer dni = 39415111;
	        Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
	        
	       
	        Nota parcial1 = new Nota(5, TipoNota.PRIMER_PARCIAL,pb1);
	        Nota parcial2 = new Nota(6, TipoNota.SEGUNDO_PARCIAL,pb1);
	        alumnoPrueba.agregarNota(parcial1);
	        alumnoPrueba.agregarNota(parcial2);
	       
	        int promedioParciales = alumnoPrueba.calcularPromedioDeNotas();
	        // Configura una nota final
	        Nota notaFinal = new Nota(promedioParciales, TipoNota.FINAL,pb1);

	  
	        boolean resultado = unlam.cargarNotaFinal(comision1, alumnoPrueba, notaFinal);

	        
	        assertTrue(resultado);
	    }
	    
	    @Test
		 public void obtenerNotaExistente() {
	    	 String nombreUni = "Unlam";
		        Universidad unlam = new Universidad(nombreUni);

		        Integer id = 1;
		        Materia pb1 = new Materia(id, "PB1");
		        CicloLectivo cicloLectivo = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
		        Turno turno = Turno.MAÑANA;
		        unlam.agregarMateria(pb1);
		        
		        Comision comision1 = new Comision(id, pb1, cicloLectivo, turno);
		        unlam.agregarComision(comision1);

		        String nombreAlumno = "Lucho";
		        String apellidoAlumno = "Vilan";
		        String fechaNacimiento = "1995-03-22";
		        String fechaIngreso = "2022-04-01";
		        Integer dni = 39415111;
		        Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
		        unlam.registrarAlumno(alumnoPrueba);
		        
		       
		        Nota parcial1 = new Nota(5, TipoNota.PRIMER_PARCIAL,pb1);
		        unlam.registrarNota(comision1, alumnoPrueba, parcial1);
		        
		        Nota notaObtenida = unlam.obtenerNota(alumnoPrueba,pb1);
		        assertEquals(parcial1, notaObtenida);
		        
		        
			 
		 }
	    
	    @Test
	    public void obtenerMateriasAprobadasParaUnAlumno() {
	        
	        String nombreUni = "Unlam";
	        Universidad unlam = new Universidad(nombreUni);

	        Integer id = 1;
	        Materia pb1 = new Materia(id, "pb1");
	       
	        CicloLectivo cicloLectivo = new CicloLectivo(1, "2023-03-04", "2023-07-06", "2023-03-03");
	        Turno turno = Turno.MAÑANA;
	        unlam.agregarMateria(pb1);
	      

	        Comision comision1 = new Comision(id, pb1, cicloLectivo, turno);
	        unlam.agregarComision(comision1);

	        String nombreAlumno = "Lucho";
	        String apellidoAlumno = "Vilan";
	        String fechaNacimiento = "1995-03-22";
	        String fechaIngreso = "2022-04-01";
	        Integer dni = 39415111;
	        Alumno alumnoPrueba = new Alumno(dni, nombreAlumno, apellidoAlumno, fechaNacimiento, fechaIngreso);
	        unlam.registrarAlumno(alumnoPrueba);

	
	        Nota parcial1 = new Nota(5, TipoNota.PRIMER_PARCIAL, pb1);
	        Nota parcial2 = new Nota(6, TipoNota.SEGUNDO_PARCIAL, pb1);
	        unlam.registrarNota(comision1, alumnoPrueba, parcial1);
	        unlam.registrarNota(comision1, alumnoPrueba, parcial2);
	        int promedioParciales = alumnoPrueba.calcularPromedioDeNotas();
	        Nota notaFinal = new Nota(promedioParciales, TipoNota.FINAL,pb1);
	        
	       
	      
	    
	        unlam.cargarNotaFinal(comision1, alumnoPrueba, notaFinal);
	        

	       
	        int valorObtenido = unlam.obtenerMateriasAprobadasParaUnAlumno(alumnoPrueba).size();
	        int valorEsperado = 1;
	       
	        assertEquals(valorEsperado, valorObtenido);

	       
	    }
}