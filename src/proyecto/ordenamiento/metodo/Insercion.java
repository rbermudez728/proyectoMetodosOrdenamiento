package proyecto.ordenamiento.metodo;

import java.util.List;

import proyecto.ordenamiento.BaseMetodoOrdenamiento;

/**
 * Clase que contiene la logica del metodo de insercion
 * 
 * @author Brigitte
 * 
 */
public class Insercion extends BaseMetodoOrdenamiento {

	/**
	 * Constructor
	 * @param datos
	 */
	public Insercion(List<Integer> datos) {
		super(datos);
	}

	@Override
	protected void ejecutar() {

		ordInsercion(getDatos());// Algoritmo

	}

	/**
	 * Logica del metodo de ordenamiento INSERCION
	 * @param list
	 */
	public static void ordInsercion(List<Integer> list) {
		int i, j;
		int aux;
		for (i = 1; i < list.size(); i++) {
			/*
			 * indice j es para explorar la sublista a[i-1]..a[0] buscando la
			 * 
			 * posicion correcta del elemento destino
			 */
			j = i;
			aux = list.get(i);
			// se localiza el punto de inserción explorando hacia abajo
			while (j > 0 && aux < list.get(j - 1)) {
				// desplazar elementos hacia arriba para hacer espacio
				// a[j] = a[j - 1];
				list.set(j, list.get(j - 1));
				j--;
			}
			// list.get(j) = aux;
			list.set(j, aux);
		}
	}
}
