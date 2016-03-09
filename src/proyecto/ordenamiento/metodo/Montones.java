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
		    
		    // Se añade cada elemento a la estructura Heap
		    for (Integer e : datos)
		        heap.add(e);
		    
		    // Los elementos se sacan del Heap en orden ascendente
		    for (int i=0; i<datos.size(); i++)	
		    	datos.set(i,heap.remove());
	}
	
}
