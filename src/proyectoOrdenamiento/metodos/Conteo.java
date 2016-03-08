package proyectoOrdenamiento.metodos;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Conteo extends Thread {
	private List<Integer> datos;
	private long startTime;
	private long endTime;
	private long elapsedTime;
	
	public Conteo(List<Integer> muestra) {
		this.datos=muestra;
	}

	public void run() {
		NumberFormat formatter = new DecimalFormat("0.######E0");
		int[] vordenado = new int[this.datos.size()];
		
		this.setStartTime(System.currentTimeMillis());// Tiempo inicial
		vordenado = this.conteo(99999,0);// Algoritmo
		this.setEndTime(System.currentTimeMillis());// Tiempo final
		this.setElapsedTime(getStartTime() - getEndTime()); // Tiempo total

		 //convirtiendo el arreglo a lista
	    this.datos = IntStream.of(vordenado).boxed().collect(Collectors.toList());
	    System.out
				.println("Termina el algoritmo de ordenamiento por Ordenamiento por conte0o con un tiempo de: "
						+ formatter.format(TimeUnit.MILLISECONDS
								.toSeconds((long) this.getElapsedTime())));
	}

	private int[] conteo(int high, int low) {
		
		//Se crea un vector de colas de 5 posiciones enteras
		int[] counts = new int[10000+2]; // this will hold all possible values, from low to high
	    int[] res = new int[this.datos.size()];
	    
		for (int x: this.datos) {
			if(x<0){
				x=x*(-1);
			}
			counts[x]++;
		}
		
	   int current = 0;
	    for (int i = 0; i < counts.length; i++)
	    {
	    	Arrays.fill(res, current, current+counts[i],i);// fills counts[i] elements of value i + low in current
	        current += counts[i]; // leap forward by counts[i] steps
	    }
		return res;		 
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

/*
 int[] counts = new int[high - low + 1]; // this will hold all possible values, from low to high
    for (int x : a)
        counts[x - low]++; // - low so the lowest possible value is always 0

    int current = 0;
    for (int i = 0; i < counts.length; i++)
    {
        Arrays.fill(a, current, current + counts[i], i + low); // fills counts[i] elements of value i + low in current
        current += counts[i]; // leap forward by counts[i] steps
    }
  
 * */
 