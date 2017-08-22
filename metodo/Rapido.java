package proyecto.ordenamiento.metodo;

import java.util.List;

import proyecto.ordenamiento.BaseMetodoOrdenamiento;

public class Rapido extends BaseMetodoOrdenamiento {
	
	public Rapido(List<Integer> datos) {
		super(datos);
	}

	@Override
	public void ejecutar() {

		this.quickSort(0, super.datos.size() - 1);// Algoritmo

	}

	private void quickSort(int inicio, int fin) {
		int i = inicio;
		int j = fin;
		int pivote = (this.datos.get(i) + this.datos.get(j)) / 2;
		//System.out.println("Pivote-->" + pivote + " i=" + i + " j=" + j);
		// iteramos hasta que i no sea menor que j
		while (i < j) {

			// iteramos mientras que el valor de L[i] sea menor que pivote
			while (this.datos.get(i) < pivote) {
				// System.out.println("i-->"+i);
				i++;
			}
			// iteramos mientras que el valor de L[j] sea mayor que pivote
			while (this.datos.get(j) > pivote) {
				// System.out.println("j-->"+j);
				j--;
			}
			// si i es menor o igual que j significa que los índices se han
			// cruzado
			if (i <= j) {
				//System.out.println("intercambiando i-->" + i + " j-->" + j);
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

}
