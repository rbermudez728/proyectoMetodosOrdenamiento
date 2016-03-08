package proyectoOrdenamiento.utiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;


public class RegistrarTiempo {
	public File archivo;

	public RegistrarTiempo(String algoritmo, int n, Long t) throws IOException {
		String nombre = algoritmo;
		File directorio = new File("c:\\data\\csv");
		directorio.mkdirs();

		this.archivo = new File("c:\\data\\csv\\" + nombre + ".json");
		if (this.archivo.createNewFile()) {
			System.out.println("Empezando a registrar tiempos!!");
		} else {
			System.out.println("Empezando a registrar tiempos!!");
		}
		this.agregarDato(n, t);
	}
	
	@SuppressWarnings("unchecked")
	public void agregarDato(int n, Long t){
		JSONObject obj = new JSONObject();
		obj.put("n",n);
		obj.put("t",t);
		
		try {
			FileWriter file = new FileWriter(this.archivo);
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			System.out.println("Error manipulando JSON");
		}

		System.out.print(obj);

		
	}
	

}
