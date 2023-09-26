package src;

import java.util.ArrayList;

public class Materia {

	private Integer id;
	private String nombre;
	private ArrayList<Materia> correlativas;

	public Materia(Integer idMateria, String nombreMateria) {
		this.id = idMateria;
		this.nombre = nombreMateria;
		this.correlativas = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public boolean agregarCorrelativa(Materia correlativa) {
		if (correlativas.contains(correlativa))
			return false;

		return correlativas.add(correlativa);
	}

	public boolean eliminarCorrelativa(Materia correlativa) {
		if (correlativas.contains(correlativa)) {
			return correlativas.remove(correlativa);
		}
		return false;

	}

}
