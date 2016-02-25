package proyectoOrdenamiento;

import java.io.IOException;

public class Principal {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		try {
			LectorDeDatos ld = new LectorDeDatos(2l);
			ld.generarDatos();
			ld.leerDatos();
			System.out.println(ld.getDatos().size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MetodosOrdenamiento mo = new MetodosOrdenamiento();
	}

}
