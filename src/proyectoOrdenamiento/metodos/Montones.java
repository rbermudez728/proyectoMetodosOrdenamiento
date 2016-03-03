package proyectoOrdenamiento.metodos;

import java.util.List;
import java.util.PriorityQueue;

import proyectoOrdenamiento.utiles.Heap; // Importando la estructura de datos montículo para su uso en el algoritmo

public class Montones extends Thread{
	private List<Integer> datos;
	
	public Montones(List<Integer> muestra) {
		this.datos=muestra;
	}

	public void run() {
		// Aquí va el codigo del algoritmo
		 this.heapSort();
		System.out.println("Termina el algoritmo de ordenamiento por Montones con un tiempo de: ");
	}
	
	private void heapSort(){
		 PriorityQueue<Integer> heap = new PriorityQueue<Integer>(datos.size());
		    
		    // Add each array element to the heap
		    for (Integer e : datos)
		        heap.add(e);
		    
		    // Elements come off the heap in ascending order
		    for (int i=0; i<datos.size(); i++)
		    	datos.set(i,heap.remove());
	}
	
	
}
