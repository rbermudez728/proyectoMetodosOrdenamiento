package proyecto.ordenamiento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proyecto.ordenamiento.metodo.Conteo;
import proyecto.ordenamiento.metodo.Insercion;
import proyecto.ordenamiento.metodo.Mezcla;
import proyecto.ordenamiento.metodo.Montones;
import proyecto.ordenamiento.metodo.Rapido;
import proyecto.ordenamiento.utiles.LectorDeDatos;

public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/* hay que tomar datos para n=
			a) 1 millón de datos
			b) 2 millones de datos
			c) 5 millones de datos
			d)10 millones de datos
			e)20 millones de datos
		*/
		Long n = 2000002L;
		List<Integer> datos = new ArrayList<Integer>();
		
		System.out.println(Thread.currentThread().getName() + " - Main");
		System.out.println("Ejecutando el aplicativo para n="+n);
		try {
			//Inicializamos el test con la cantidad de datos especificada
			LectorDeDatos ld = new LectorDeDatos(n);
			ld.generarDatos();
			datos = ld.leerDatos();
			
			//Creamos los métodos de ordenamiento
			Insercion ordenamientoInsercion = new Insercion(ld.leerDatos());
			Mezcla mezcla = new Mezcla(ld.leerDatos());
			Rapido rapido = new Rapido(ld.leerDatos());
			Montones montones = new Montones(ld.leerDatos());
			Conteo conteo = new Conteo(ld.leerDatos());
			
			//Lanzamos los hilos
			ordenamientoInsercion.start();
			mezcla.start();
			rapido.start();
			montones.start();
			conteo.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

