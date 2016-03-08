package proyectoOrdenamiento.metodos;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.PriorityQueue;

import proyectoOrdenamiento.utiles.Heap; // Importando la estructura de datos montículo para su uso en el algoritmo
import proyectoOrdenamiento.utiles.RegistrarTiempo;


public class Montones extends Thread{
	private List<Integer> datos;
	private long startTime;
	private long endTime;
	private long elapsedTime;
	
	public Montones(List<Integer> muestra) {
		this.datos=muestra;
	}

	@SuppressWarnings("unused")
	public void run() {
		NumberFormat formatter = new DecimalFormat("0.#####E0");
		
		this.setStartTime(System.currentTimeMillis());//Tiempo inicial
		this.heapSort();//Algoritmo
		this.setEndTime(System.currentTimeMillis());//Tiempo final
		this.setElapsedTime(getEndTime()-getStartTime()); //Tiempo total 
		
		System.out.println(this.getElapsedTime());
		System.out.println("Termina el algoritmo de ordenamiento por Montones con un tiempo de: "+formatter.format(getElapsedTime()));
		
		try {
			RegistrarTiempo Tiempo = new RegistrarTiempo("Montones", 
														 this.datos.size(), 
														 getElapsedTime());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	/**
	 * @return the startTime
	 */
	private long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	private void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	private long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	private void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the elapsedTime
	 */
	private long getElapsedTime() {
		return elapsedTime;
	}

	/**
	 * @param elapsedTime the elapsedTime to set
	 */
	private void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	
}
