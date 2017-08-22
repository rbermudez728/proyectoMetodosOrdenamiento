package proyecto.ordenamiento.utiles;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RegistrarTiempo {
	public File archivo;

	public RegistrarTiempo(String algoritmo, int n, Long t) throws IOException {
		String nombre = algoritmo;
		File directorio = new File("c:\\data\\csv");
		directorio.mkdirs();

		this.archivo = new File("c:\\data\\csv\\" + nombre + ".json");
		this.archivo.createNewFile();
		this.agregarDato(n, t);
	}

	@SuppressWarnings({ "unchecked" })
	public void agregarDato(int n, Long t) {
		JSONArray arreglo = new JSONArray();
		JSONParser parser = new JSONParser();
		JSONObject nuevoDato = new JSONObject();
		nuevoDato.put("n", n);
		nuevoDato.put("t", t);

		try {
			Object obj = parser.parse(new FileReader(this.archivo));
			arreglo = (JSONArray) obj;
		} catch (Exception ex) {
			System.err.println("Creando el archivo json de medidas");
		} finally {
			arreglo.add(nuevoDato);
			FileWriter file;
			try {
				file = new FileWriter(this.archivo);
				file.write(arreglo.toJSONString());
				file.flush();
				file.close();
			} catch (IOException e) {
				System.err.println("No se pueden registrar los tiempos");
			}

		}

	}

}
