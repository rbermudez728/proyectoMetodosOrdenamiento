package proyectoOrdenamiento.metodos;

import java.util.List;

public class Montones extends Thread{
	private List<Integer> datos;
	
	public Montones(List<Integer> muestra) {
		this.datos=muestra;
	}

	public void run() {
		// Aquí va el codigo del algoritmo
		
		System.out.println("Termina el algoritmo de ordenamiento por Montones con un tiempo de: ");
	}
}
