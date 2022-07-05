package Evaluar_Funciones;

public class StringBuffer {
   
	String Qexpresion; 
    int indice; 
    
    public StringBuffer(String expre) { 
        this.indice= 0; 
        Qexpresion = new String(); 
        Qexpresion =  expre; 
    }
    
    public String Retorna() {
         String Aux = Qexpresion.substring(indice,  indice+1); 
         indice ++; 
         return (Aux); 
    }
    
    public void entrarCaracFin(String car) { 
        Qexpresion = Qexpresion.concat(car);
    }
    
    public int CaracterNum() { 
        return Qexpresion.length();
    }
    
}//FINAL CLASS
