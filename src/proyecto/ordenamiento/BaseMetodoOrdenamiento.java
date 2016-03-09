package proyecto.ordenamiento;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Clase base para los metodos de ordenamiento
 * 
 * @author Brigitte
 * 
 */
public abstract class BaseMetodoOrdenamiento extends Thread {

	protected List<Integer> datos;
	
	
	public BaseMetodoOrdenamiento(List<Integer> datos){
		this.datos = datos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		long tInicial;
		long tFinal;
		long tTotal;
		String identificador = Thread.currentThread().getName() + " - " + this.getClass().getSimpleName();
		//System.out.println(identificador + ": Se inicial el metodo ");
		//System.out.println(identificador + ": Se va a ordenar " + this.datos);
		tInicial = System.nanoTime();
		ejecutar();
		tFinal = System.nanoTime();
		tTotal = tFinal - tInicial;
		
		//System.out.println(identificador + ": Resultado ordenado va a ordenar " + this.datos);
		System.out.println(identificador + ": Se tardó  " + TimeUnit.NANOSECONDS.convert(tTotal, TimeUnit.NANOSECONDS));
		System.out.println("---------------------------------------------------------------------");
	}

	/**
	 * Ejecuta la logica de ordenamiento
	 */
	protected abstract void ejecutar();

	public List<Integer> getDatos() {
		return datos;
	}

	public void setDatos(List<Integer> datos) {
		this.datos = datos;
	}
	

}
