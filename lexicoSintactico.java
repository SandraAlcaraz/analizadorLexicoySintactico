package continental.tictactoe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFileChooser;

public class lexicoSintactico {
	private static void fileChooser() {

        JFileChooser jFileChooser = new JFileChooser();
	int result = jFileChooser.showOpenDialog(null);
        File selectedFile = jFileChooser.getSelectedFile();
        if (result == JFileChooser.APPROVE_OPTION) {
            printContents(selectedFile);
        } else {
            System.out.println("Error selecting file");
        }
    }
	
	
	
	public static String numeros (String x){ 
		int ascii;
		boolean bandera=false;
		for(char c: x.toCharArray()){
			ascii=(int)c;
			if(ascii==46&&bandera){
				//si es igual a "."
				return "error doble punto"; //error doble punto
			}
			if(ascii==46){
				bandera=true;		
			}
			else if(!((ascii>47&&ascii<58))){
				return "caracter no permitido";	//error caracter se sale de lo permitido
			}
		}
		if(bandera==true){
			return "real"; //punto decimal correcto
		}
		else{
			return "entero"; //numero entero aceptado
		}
	}
	
	public static String identificador(String x){
		int ascii;
		boolean bandera=false;
		for(char c: x.toCharArray()){
			ascii=(int)c;
			if(!(ascii>96&&ascii<128)){
				return "error identificador";
			}
			}
		
		return "identificador";
	}
	
	
	public static String automata(String str){
		int ascii;
		
			ascii=(int)str.toCharArray()[0];
			if(ascii>96&&ascii<128){
				return identificador(str);
			}
			else if(ascii>47&&ascii<58){
				return numeros(str);
			}
			else if(ascii==44){
				//coma
				return "coma";
			}
			else if(ascii==40||ascii==41){
				//parentesis
				return "parentesis";
			}
			else if(ascii==123||ascii==125){
				//llaves {
				return "llave";
			}
			else if(ascii==59){
				//punto y coma
				return "punto y coma";
			}
			else if(ascii==38||ascii==124){
				//logicos  & | 
				return "logicos";
			}
			else if(ascii==33){
				//not !
				return "not";
			}
			else if(ascii==60||ascii==62){
				//> <
				return "relacionales";
			}
			else if(ascii==61&&((int)str.toCharArray()[1])==61){
				//==
				return "relacionales";
				//*completar
			}else if(ascii==61){
				return "asignacion";
			}
		
		
		return "error";
	}

    private static void printContents(File selectedFile) {
        String textFile = "";

        try {
            FileReader fr = new FileReader(selectedFile);
            FileInputStream fis = new FileInputStream(selectedFile);
            ArrayList<token> myArrayList = new ArrayList<token>();
            
            char current;
            boolean state=false;
            boolean first=true; 
            String tok="";
            String tipo;
            int numline=0;
            token t=new token();
            int countcharacter=0;
            while (fis.available() > 0) {
            	//TimeUnit.MILLISECONDS.sleep(100);
              current = (char) fis.read();
              countcharacter++; //modificar para que sólo cuente desde el principio
            
              if(current=='('||current==')'||current==';'||current==','){
            	 // tok=tok+current;//borra el ultimo char del string
            	  tipo=automata(tok);
            	  t= new token(tok, tipo,numline, (countcharacter-1)); //lo anterior al 
            	  System.out.println(t.toString());
            	  myArrayList.add(t);
            	  tipo=automata(Character.toString(current));
            	  t= new token(Character.toString(current), tipo,numline, (countcharacter));
            	  System.out.println(t.toString());
            	  tok="";
              }
              else if((current==' '||current=='\n'|| current=='\r'||current=='\t')&&!tok.isEmpty()){
            	  if (!first){
            		  tipo=automata(tok);
                	  t= new token(tok, tipo,numline, (countcharacter-1)); //lo anterior al 
                	  System.out.println(t.toString());
                	  myArrayList.add(t);
                	  tok="";
   
            	  }  
              }else{
            	  tok=tok+current;
            	  first=false;
            	  
            	  if(state){
            		  
            		 // System.out.print(" ");
            	  }
            	  state=false;
            	  //System.out.print(current);
              }
              
            }
            
            fr.close();
            
           System.out.println( myArrayList.toString());

        } catch (Exception error) {
            error.printStackTrace();
        }

        System.out.println(textFile);
    }

    public static void main(String[] args) {
        fileChooser();
    }
}
