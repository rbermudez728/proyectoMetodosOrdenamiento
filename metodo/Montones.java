package proyecto.ordenamiento.metodo;

import java.util.List;
import java.util.PriorityQueue;

import proyecto.ordenamiento.BaseMetodoOrdenamiento;

public class Montones extends BaseMetodoOrdenamiento{

	public Montones(List<Integer> datos) {
		super(datos);
	}

	@Override
	public void ejecutar() {
		this.montones();//Algoritmo
	}
	
	private void montones(){
		 PriorityQueue<Integer> heap = new PriorityQueue<Integer>(super.datos.size());
		    
		    // Se añade cada elemento a la estructura Heap
		    for (Integer e : super.datos)
		        heap.add(e);
		    
		    // Los elementos se sacan del Heap en orden ascendente
		    for (int i=0; i<super.datos.size(); i++)	
		    	datos.set(i,heap.remove());
	}
	
}
