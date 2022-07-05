package Evaluar_Funciones;

public class Pila {

	private int n; // TAMAÑO MAXIMO
	private int tope; // CUANTO ESLEMENTOS APILADOS;
	private Object pila[];

	public Pila(int n) {
		this.n = n;
		tope = 0;
		pila = new Object[n];
	}

	public boolean estaVacia() {
		return tope == 0;
	}

	public boolean estaLlena() {
		return tope == n;
	}
	
	public void vaciarPila() {
		tope = 0;
	}

	public boolean push(Object dato) {
		if (estaLlena()) {
			return false;
		}
		pila[tope] = dato;
		tope++;
		return true;
	}

	public Object pop() {
		if (estaVacia()) {
			return null;
		}
		tope--;
		return pila[tope];
	}
	
//	NO LO SACA DE LA PILA SOLO NOS MUESTRA QUIEN ESTA ARRIBA  
	public Object parteSuperiorPila() {
		return pila [tope-1];
	}

	
}// FINAL CLASS
