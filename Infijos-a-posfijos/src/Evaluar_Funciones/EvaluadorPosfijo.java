package Evaluar_Funciones;

public class EvaluadorPosfijo {

	public static double evaluarExpresionPosfijo(String infija) {
		String posfija = convertirPosfijo(infija);
		System.out.println("La expresion en posfija es: " + posfija);
		return evaluarPosfija(posfija);
	}

	public static double evaluarPosfija(String posfija) {
		Pila pila = new Pila(100);
		for (int i = 0; i < posfija.length(); i++) {
			char letra = posfija.charAt(i);
			if (!esOperador(letra)) {
				double num = new Double(letra + "");
				pila.push(num);
			} else {
				double num2 = (double) pila.pop();
				double num1 = (double) pila.pop();
				double num3 = calcular(letra, num1, num2);
				pila.push(num3);
			}
		}
		return (double) pila.parteSuperiorPila();
	}

	private static double calcular(char letra, double num1, double num2) {
		if (letra == '*')
			return num1 * num2;
		if (letra == '/')
			return num1 / num2;
		if (letra == '+')
			return num1 + num2;
		if (letra == '-')
			return num1 - num2;
		if (letra == '^') 
			return Math.pow(num1, num2);
		return 0;
	}

	private static void imprimirPila(String cadena) {
		StringBuffer expresion = new StringBuffer(cadena);
		for(int i =0 ; i<expresion.CaracterNum();i++) {
			String cadena1 = expresion.Retorna();
			System.out.println(cadena1);
		}
	}
	
	private static String convertirPosfijo(String infija) {
		String posfija = "";
		Pila pila = new Pila(100);
		for (int i = 0; i < infija.length(); i++) {
			char letra = infija.charAt(i);
			if (esOperador(letra)) {
				if (letra == ')') {
					while ((char) pila.parteSuperiorPila() != '(')
						posfija += pila.pop();
					if ((char) pila.parteSuperiorPila() == '(')
						pila.pop();
				}
				if (pila.estaVacia()) {
					if (letra != ')')
						pila.push(letra);
				} else {
					if (letra != ')') {
						int pExpresion = precedenciaEnExpresion(letra);
						int pPila = precedenciaEnPila((char) pila.parteSuperiorPila());
						
						if (pExpresion > pPila) {
							pila.push(letra);
						}

						else {
							posfija += pila.pop();
							pila.push(letra);
						}
					}
				}
			} else {
				posfija += letra;
			}
		}
		while (!pila.estaVacia()) {
			posfija += pila.pop();
		}
		return posfija;
	}

	private static int precedenciaEnExpresion(char operador) {
		if (operador == '^')
			return 4;
		if (operador == '*' || operador == '/')
			return 2;
		if (operador == '+' || operador == '-')
			return 1;
		if (operador == '(')
			return 5;
		return 0;
	}

	private static int precedenciaEnPila(char operador) {
		if (operador == '^')
			return 3;
		if (operador == '*' || operador == '/')
			return 2;
		if (operador == '+' || operador == '-')
			return 1;
		if (operador == '(')
			return 0;
		return 0;
	}

	private static boolean esOperador(char letra) {
		if (letra == '*' || letra == '/' || letra == '+' || letra == '-' || letra == '(' || letra == ')'
				|| letra == '^') {
			return true;
		}
		return false;
	}
	
	public static void mostrarPila(String infija) {
		String posfija = convertirPosfijo(infija);
		System.out.println("Elementos en pila: ");
		imprimirPila(posfija);
	}

}// FINAL CLASS
