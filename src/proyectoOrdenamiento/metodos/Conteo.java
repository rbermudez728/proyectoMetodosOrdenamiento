package proyectoOrdenamiento.metodos;

import java.util.List;

public class Conteo extends Thread {
	private List<Integer> datos;
	
	public Conteo(List<Integer> muestra) {
		this.datos=muestra;
	}

	public void run() {
		// Aqu� va el codigo del algoritmo
		
		System.out.println("Termina el algoritmo de ordenamiento por Inserci�n con un tiempo de: ");
	}
}
