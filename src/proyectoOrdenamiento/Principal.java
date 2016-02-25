package proyectoOrdenamiento;

import java.io.IOException;

public class Principal {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			LectorDeDatos ld = new LectorDeDatos(1l);
			ld.generarDatos();
			ld.leerDatos();
			System.out.println(ld.getDatos().size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MetodosOrdenamiento mo = new MetodosOrdenamiento();
	}

}
