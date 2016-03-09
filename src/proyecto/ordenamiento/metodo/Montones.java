package proyecto.ordenamiento.metodo;

import java.util.List;
import java.util.PriorityQueue;

import proyecto.ordenamiento.BaseMetodoOrdenamiento;

public class Montones extends BaseMetodoOrdenamiento{
	private List<Integer> datos;

	public Montones(List<Integer> datos) {
		super(datos);
	}

	public void ejecutar() {
		this.heapSort();//Algoritmo
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
