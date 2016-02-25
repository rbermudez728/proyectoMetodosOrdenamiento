package proyectoOrdenamiento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proyectoOrdenamiento.metodos.Conteo;
import proyectoOrdenamiento.metodos.Insercion;
import proyectoOrdenamiento.metodos.Mezcla;
import proyectoOrdenamiento.metodos.Montones;
import proyectoOrdenamiento.metodos.Rapido;
import proyectoOrdenamiento.utiles.LectorDeDatos;

public class Principal {
	
	public static void main(String[] args) {
		Long n = 100l;
		List<Integer> datos = new ArrayList<Integer>();
		
		
		System.out.println("Ejecutando el aplicativo para n="+n);
		try {
			//Inicializamos el test con la cantidad de datos especificada
			LectorDeDatos ld = new LectorDeDatos(n);
			ld.generarDatos();
			datos = ld.leerDatos();
			
			//Creamos los métodos de ordenamiento
			Insercion ordenamientoInsercion = new Insercion(datos);
			Mezcla ordenamientoMezcla = new Mezcla(datos);
			Montones ordenamientoMontones = new Montones(datos);
			Rapido ordenamientoRapido = new Rapido(datos);
			Conteo ordenamientoConteo = new Conteo(datos);	
			
			//Lanzamos los hilos
			ordenamientoInsercion.start();
			ordenamientoMezcla.start();
			ordenamientoMontones.start();
			ordenamientoRapido.start();
			ordenamientoConteo.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
