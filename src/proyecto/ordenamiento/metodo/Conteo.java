package proyecto.ordenamiento.metodo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import proyecto.ordenamiento.BaseMetodoOrdenamiento;

public class Conteo extends BaseMetodoOrdenamiento {

	/**
	 * Constructor
	 * 
	 * @param datos
	 */
	public Conteo(List<Integer> datos) {
		super(datos);
	}

	@Override
	protected void ejecutar() {
		int[] vordenado = new int[super.datos.size()];
		vordenado = this.conteo(99999, 0);// Algoritmo
		super.datos = IntStream.of(vordenado).boxed()
				.collect(Collectors.toList());
	}

	private int[] conteo(int high, int low) {

		// Se crea un vector de colas de 5 posiciones enteras
		int[] counts = new int[10000 + 2]; // this will hold all possible
											// values, from low to high
		int[] res = new int[super.datos.size()];

		for (int x : super.datos) {
			if (x < 0) {
				x = x * (-1);
			}
			counts[x]++;
		}

		int current = 0;
		for (int i = 0; i < counts.length; i++) {
			Arrays.fill(res, current, current + counts[i], i);// fills counts[i]
																// elements of
																// value i + low
																// in current
			current += counts[i]; // leap forward by counts[i] steps
		}
		return res;
	}

}