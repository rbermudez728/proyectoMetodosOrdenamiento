package proyectoOrdenamiento.metodos;

import java.util.Arrays;
import java.util.List;

public class Conteo extends Thread {
	private List<Integer> datos;
	
	public Conteo(List<Integer> muestra) {
		this.datos=muestra;
	}

	public void run() {
		// Aquí va el codigo del algoritmo
		
		System.out.println("Termina el algoritmo de ordenamiento por Conteo con un tiempo de: ");
	}
	
	
	public static void countingSort(int[] a, int low, int high)
	{
	    int[] counts = new int[high - low + 1]; // this will hold all possible values, from low to high
	    for (int x : a)
	        counts[x - low]++; // - low so the lowest possible value is always 0

	    int current = 0;
	    for (int i = 0; i < counts.length; i++)
	    {
	        Arrays.fill(a, current, current + counts[i], i + low); // fills counts[i] elements of value i + low in current
	        current += counts[i]; // leap forward by counts[i] steps
	    }
	}
}
