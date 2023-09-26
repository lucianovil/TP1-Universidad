package src;

public class Nota {

	   
	    private Integer valor;
	    private String tipo; 
	  

	    public Nota(Integer valor, String tipo) {
	       
	        this.valor = valor;
	        this.tipo = tipo;
	    
	    }


		public Integer getValor() {
			return valor;
		}


		public void setValor(Integer valor) {
			this.valor = valor;
		}


		public String getTipo() {
			return tipo;
		}


		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
}
