package proyectoOrdenamiento.metodos;

import java.util.List;

public class Mezcla extends Thread {
	private List<Integer> datos;
	
	public Mezcla(List<Integer> muestra) {
		this.datos=muestra;
	}

	public void run() {
		// Aqu� va el codigo del algoritmo
		
		System.out.println("Termina el algoritmo de ordenamiento por Inserci�n con un tiempo de: ");
	}
}
