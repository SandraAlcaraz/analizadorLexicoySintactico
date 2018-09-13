package continental.tictactoe;

public class token {
	private String tipo;
	private int linea;
	private int numCaracter;
	
	public token(String tipo, int linea, int numCaracter){
		this.tipo=tipo;
		this.linea=linea;
		this.numCaracter=numCaracter;
	}
	public token(){
		this.tipo="";
		this.linea=0;
		this.numCaracter=0;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public int getNumCaracter() {
		return numCaracter;
	}
	public void setNumCaracter(int numCaracter) {
		this.numCaracter = numCaracter;
	}
	
	
}
