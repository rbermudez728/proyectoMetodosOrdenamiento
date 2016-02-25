package proyectoOrdenamiento;

import java.io.IOException;

import proyectoOrdenamiento.metodos.Insercion;

public class Principal {

	public static void main(String[] args) {
		Long n = 100l;
//		Long n = (long) Integer.parseInt(args[0]); 		
		try {
			LectorDeDatos ld = new LectorDeDatos(n);
			ld.generarDatos();
			ld.leerDatos();
			System.out.println(ld.getDatos().size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
