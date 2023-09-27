package src;

public class Nota {

	private int valor;
	private TipoNota tipo;
	private Materia materia;

	public Nota(int valor, TipoNota tipo, Materia materia) {
		this.valor = valor;
		this.tipo = tipo;
		this.materia = materia;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setTipo(TipoNota tipo) {
		this.tipo = tipo;
	}

	public int getValor() {
		return valor;
	}

	public TipoNota getTipo() {
		return tipo;
	}

}