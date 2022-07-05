package Evaluar_Funciones;

import java.util.Scanner;

public class Ejecucion {

	public static String expresion = null;
	
	public static void main(String[] args) {

		 int opcion = 0;
	        Ejecucion ejecucion = new Ejecucion ();
	        Pila pila = new Pila (100);
	        Scanner tec = new Scanner (System.in);

	        do{
	            System.out.println("__________________________________________");
	            System.out.println("__________________ MENU __________________");
	            System.out.println("    1. Registrar expresion                ");         
	            System.out.println("    2. Mostrar expresion registrada       ");
	            System.out.println("    3. Convertir en forma posfija         ");
	            System.out.println("    4. Mostrar elementos en pila          ");
	            System.out.println("    5. Realizar operacion                 ");
	            System.out.println("    6. Vaciar pila                        ");
	            System.out.println("    7. Apagar                             ");
	            System.out.println("__________________________________________");
	            System.out.println("    DIGITE UNA OPCION                     ");
	            opcion = tec.nextInt();
	            System.out.println("__________________________________________");
	            
	            switch (opcion) {
	               case 1 :	                   
	                    ejecucion.Ingresar();  
	               break;
	                  
	                case 2 :
	                    if(expresion != null){
	                    System.out.println("La expresion en su forma infija es :");
	                    System.out.println(""+expresion);
	                    } else {
	                        System.out.println("No has ingresado ninguna expresion!!");
	                    }
	                break;
	                
	                case 3 :
	                    if(expresion != null) {
	                        EvaluadorPosfijo.evaluarExpresionPosfijo(expresion);
	                    }
	                    else {
	                        System.out.println("No has ingresado ninguna expresion!!");
	                    }
	                break;
	                
	                case 4 :
	                    if(expresion != null) { 
	                    	EvaluadorPosfijo.mostrarPila(expresion);        
	                    }
	                    else {
	                        System.out.println("No has ingresado ninguna expresion!!");
	                    }
	                break;
	                
	                case 5 :
	                    if(expresion != null) { 
	                    	System.out.println("El resultado es: "+ EvaluadorPosfijo.evaluarExpresionPosfijo(expresion));        
	                    }
	                    else {
	                        System.out.println("No has ingresado ninguna expresion!!");
	                    }
	                break;
	                
	                case 6 :
	                    
	                    try {
	                       pila.vaciarPila();
	                       expresion = null;
	                       System.out.println("PILA VACIADA!");
	                    }
	                    catch (Exception e) {
	                        System.out.println("No se pudo vaciar la pila");
	                    }
	                    
	                break;
	            }
	                    
	        } while (opcion != 7);
	        System.out.println("Tenga un buen dia :)");
	    }
	    
	    //METODO PARA INGRESAR LA EXPRESION
	    public void Ingresar(){ 	
	         Scanner tec = new Scanner (System.in);
	         System.out.println("Ingrese Expresion");
	         expresion = tec.nextLine();
	         System.out.println("EXPRESION GUARDADA!");    
	    }

}//FINAL CLASS
