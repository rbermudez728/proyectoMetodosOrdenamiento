package proyectoOrdenamiento.metodos;

import java.util.LinkedList;
import java.util.List;

public class Rapido extends Thread {
	private List<Integer> datos;
	public QuickPosInfo info = new QuickPosInfo();
	
	public class QuickPosInfo {
		public int left;
		public int right;
	};
	
	public Rapido(List<Integer> muestra) {
		this.datos = muestra;
	}

	public void run() {
		this.quickSort(0, this.datos.size() - 1);
		System.out.println("Termina el algoritmo de ordenamiento por Ordenamiento R�pido con un tiempo de: ");
	}

	public int partition(int left, int right) {
		int pivot = this.datos.get(left);
		while (true) {
			while (this.datos.get(left) < pivot)
				left++;

			while (this.datos.get(right)> pivot)
				right--;

			if (left < right) {
				int temp = this.datos.get(right);
				this.datos.set(right,this.datos.get(left));
				this.datos.set(left,temp);
			} else {
				return right;
			}
		}
	}

	public void quickSort(int left, int right) {

		if (left >= right)
			return; // Invalid index range

		LinkedList<QuickPosInfo> list = new LinkedList<QuickPosInfo>();

		info.left = left;
		info.right = right;
		list.add(info);

		while (true) {
			if (list.size() == 0)
				break;

			left = list.get(0).left;
			right = list.get(0).right;
			list.remove(0);

			int pivot = partition(left, right);

			if (pivot > 1) {
				info.left = left;
				info.right = pivot - 1;
				list.add(info);
			}

			if (pivot + 1 < right) {
				info.left = pivot + 1;
				info.right = right;
				list.add(info);
			}
		}
	}

}
