package proyecto.ordenamiento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proyecto.ordenamiento.utiles.LectorDeDatos;
import proyecto.ordenamiento.metodo.Mezcla;
import proyecto.ordenamiento.metodo.Montones;
import proyecto.ordenamiento.metodo.Rapido;
import proyecto.ordenamiento.metodo.Conteo;
import proyecto.ordenamiento.metodo.Insercion;

public class Principal {
	
	public static void main(String[] args) {
		Long n = 20000000l;
		List<Integer> datos = new ArrayList<Integer>();
				
		System.out.println("Ejecutando el aplicativo para n="+n);
		try {
			//Inicializamos el test con la cantidad de datos especificada
			LectorDeDatos ld = new LectorDeDatos(n);
			ld.generarDatos();
			datos = ld.leerDatos();
			
			//Creamos los métodos de ordenamiento
			//Insercion ordenamientoInsercion = new Insercion(datos);
			//Mezcla ordenamientoMezcla = new Mezcla(datos);
			//Montones ordenamientoMontones = new Montones(datos);
			//Rapido ordenamientoRapido = new Rapido(datos);
			Conteo ordenamientoConteo = new Conteo(datos);	
			
			//Lanzamos los hilos
			//ordenamientoInsercion.start();
			//ordenamientoMezcla.start();
			//ordenamientoMontones.start();
			//ordenamientoRapido.start();
			ordenamientoConteo.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
