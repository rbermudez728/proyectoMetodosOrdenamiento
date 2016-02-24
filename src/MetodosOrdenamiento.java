package proyectoOrdenamiento;

import java.io.IOException;

public class MetodosOrdenamiento {
	MetodosOrdenamiento() {
		System.out.println("Iniciando...");
		try {
			LectorDeDatos ld = new LectorDeDatos(100l);
			ld.generarDatos();
			ld.leerDatos();
			System.out.println(ld.datos.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
