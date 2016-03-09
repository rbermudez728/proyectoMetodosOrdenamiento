package proyecto.ordenamiento.metodo;

import java.util.Arrays;
import java.util.List;

import proyecto.ordenamiento.BaseMetodoOrdenamiento;

public class Mezcla extends BaseMetodoOrdenamiento {

	/**
	 * Constructor
	 * @param datos
	 */
	public Mezcla(List<Integer> datos) {
		super(datos);
	}

	@Override
	protected void ejecutar() {
		mergesort(getDatos(), 0, getDatos().size()-1);
	}
	
	public static void mergesort(List<Integer> A, int izq, int der) {
		if (izq < der) {
			int m = (izq + der) / 2;
			mergesort(A, izq, m);
			mergesort(A, m + 1, der);
			merge(A, izq, m, der);
		}
	}

	public static void merge(List<Integer> A, int izq, int m, int der) {
		int i, j, k;
		// int [] B = new int[A.size()]; //array auxiliar
		List<Integer> B =  Arrays.asList(new Integer[A.size()]);

		for (i = izq; i <= der; i++)
			// copia ambas mitades en el array auxiliar
			// B[i]=A[i];
			B.set(i, A.get(i));
		i = izq;
		j = m + 1;
		k = izq;
		while (i <= m && j <= der)
			// copia el siguiente elemento más grande
			if (B.get(i) <= B.get(j)) {
				A.set(k++, B.get(i++));
			} else {
				A.set(k++, B.get(j++));
			}
		while (i <= m) {
			// copia los elementos que quedan de la
			A.set(k++, B.get(i++)); // primera mitad (si los hay)
		}
	}

}
