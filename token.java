package continental.tictactoe;

public class token {
	private String contenido;
	private String tipo;
	private int linea;
	private int numCaracter;
	
	
	public token(String contenido, String tipo, int linea, int numCaracter){
		this.contenido=contenido;
		this.tipo=tipo;
		this.linea=linea;
		this.numCaracter=numCaracter;
	}
	public token(){
		this.contenido="";
		this.tipo="";
		this.linea=0;
		this.numCaracter=0;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String toString() {
		return "token [contenido= '" + contenido + "', tipo=" + tipo + ", linea=" + linea + ", Caracter=" + numCaracter
				+ "]\n";
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
