package proyectoOrdenamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//import com.csvreader.CsvReader;

public class LectorDeDatos {
	public File archivo;
	public List<Integer> datos;
	public Long cantidadDatos;

	LectorDeDatos(Long n) throws IOException {
		String nombre = "muestra" + n;
		this.cantidadDatos=n;
		File directorio = new File("c:\\data\\csv");
		directorio.mkdirs();
		
		this.archivo = new File("c:\\data\\csv\\" + nombre + ".csv");
		if (this.archivo.createNewFile()) {
			System.out.println("Archivo creado!!");
		} else {
			System.out.println("Archivo ya existente!!");
		}
	}

	public boolean generarDatos() {
		FileWriter fw;
		boolean valor = true;
		
		try {
			if (this.archivo.length() == 0) {
				fw = new FileWriter(this.archivo);
				BufferedWriter bw = new BufferedWriter(fw);
				for (Long i = 0l; i < this.cantidadDatos; i++) {
					int val = (int) Math.floor(Math.random() * 10000 - 1);
					System.out.println(val);
					bw.write("" + val + ";");
				}
				System.out.println("Se han insertado en el archivo! "
						+ this.cantidadDatos);
				bw.close();
				valor = true;
			} else {
				System.out.println("Datos existentes!");
			}
		} catch (IOException e) {
			valor = false;
			System.out.println("Error generando números");
			e.printStackTrace();
		}
		return valor;
	}

	@SuppressWarnings("resource")
	public List<Integer> leerDatos() throws IOException {
		try {
			String contenidoArchivo = null;
			FileReader fw = new FileReader(archivo);
			BufferedReader bw = new BufferedReader(fw);
			this.datos = new ArrayList<Integer>();

			contenidoArchivo = bw.readLine();
			StringTokenizer st = new StringTokenizer(contenidoArchivo, ";");
			while (st.hasMoreTokens())
				datos.add(Integer.parseInt(st.nextToken()));
			System.out.println(datos);
		} catch (FileNotFoundException e) {
			this.datos = null;
			e.printStackTrace();
		}
		return this.datos;
	}
}
