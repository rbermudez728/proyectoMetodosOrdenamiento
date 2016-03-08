package proyectoOrdenamiento.metodos;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Rapido extends Thread {
	private List<Integer> datos;
	private QuickPosInfo info = new QuickPosInfo();
	private long startTime;
	private long endTime;
	private long elapsedTime;

	public class QuickPosInfo {
		public int left;
		public int right;
	};

	public Rapido(List<Integer> muestra) {
		this.datos = muestra;
	}

	public void run() {
		NumberFormat formatter = new DecimalFormat("0.######E0");

		this.setStartTime(System.currentTimeMillis());// Tiempo inicial
		this.quickSort(0, this.datos.size() - 1);// Algoritmo
		this.setEndTime(System.currentTimeMillis());// Tiempo final
		this.setElapsedTime(getStartTime() - getEndTime()); // Tiempo total

		System.out
				.println("Termina el algoritmo de ordenamiento por Ordenamiento Rápido con un tiempo de: "
						+ formatter.format(TimeUnit.MILLISECONDS
								.toSeconds((long) this.getElapsedTime())));
		//System.out.println(this.datos);
	}

	private void quickSort(int inicio, int fin) {
		int i = inicio;
		int j = fin;
		int pivote = (this.datos.get(i) + this.datos.get(j)) / 2;
		System.out.println("Pivote-->" + pivote + " i=" + i + " j=" + j);
		// iteramos hasta que i no sea menor que j
		while (i < j) {
			
			// iteramos mientras que el valor de L[i] sea menor que pivote
			while (this.datos.get(i) < pivote) {
				//System.out.println("i-->"+i);
				i++;
			}
			// iteramos mientras que el valor de L[j] sea mayor que pivote
			while (this.datos.get(j) > pivote) {
				//System.out.println("j-->"+j);
				j--;
			}
			// si i es menor o igual que j significa que los índices se han
			// cruzado
			if (i <= j) {
				System.out.println("intercambiando i-->"+i+" j-->"+j);
				this.intercambiar(i, j);
				i++;
				j--;
			}
		}

		// si first es menor que j mantenemos la recursividad
		if (inicio < j) {
			this.quickSort(inicio, j);
		}
		// si last es mayor que i mantenemos la recursividad
		if (fin > i) {
			this.quickSort(i, fin);
		}
	}

	private void intercambiar(int i, int j) {
		int temp;
		temp = this.datos.get(i);
		this.datos.set(i, this.datos.get(j));
		this.datos.set(j, temp);
	}

	private long getElapsedTime() {
		return elapsedTime;
	}

	private void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	/**
	 * @return the endTime
	 */
	private long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	private void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the startTime
	 */
	private long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	private void setStartTime(long startTime) {
		this.startTime = startTime;
	}

}

/*
 * def quicksort(L, first, last): # definimos los índices y calculamos el pivote
 * i = first j = last pivote = (L[i] + L[j]) / 2
 * 
 * # iteramos hasta que i no sea menor que j while i < j: # iteramos mientras
 * que el valor de L[i] sea menor que pivote while L[i] < pivote: #
 * Incrementamos el índice i+=1 # iteramos mientras que el valor de L[j] sea
 * mayor que pivote while L[j] > pivote: # decrementamos el índice j-=1 # si i
 * es menor o igual que j significa que los índices se han cruzado if i < = j: #
 * creamos una variable temporal para guardar el valor de L[j] x = L[j] #
 * intercambiamos los valores de L[j] y L[i] L[j] = L[i] L[i] = x #
 * incrementamos y decrementamos i y j respectivamente i+=1 j-=1
 * 
 * # si first es menor que j mantenemos la recursividad if first < j: L =
 * quicksort(L, first, j) # si last es mayor que i mantenemos la recursividad if
 * last > i: L = quicksort(L, i, last)
 * 
 * # devolvemos la lista ordenada return L
 */