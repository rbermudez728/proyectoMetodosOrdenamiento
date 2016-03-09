package proyecto.ordenamiento.utiles;

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
	private List<Integer> datos;
	private Long cantidadDatos;

	public LectorDeDatos(Long n) throws IOException {
		String nombre = "muestra" + n;
		this.setCantidadDatos(n);
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
				for (Long i = 0l; i < this.getCantidadDatos(); i++) {
					int val = (int) Math.floor(Math.random() * 10000 - 1);
					System.out.println(val);
					if(val>0){
						bw.write("" + val + ";");
					}
				}
				System.out.println("Se han insertado en el archivo! "
						+ this.getCantidadDatos());
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
			this.setDatos(new ArrayList<Integer>());

			contenidoArchivo = bw.readLine();
			StringTokenizer st = new StringTokenizer(contenidoArchivo, ";");
			while (st.hasMoreTokens())
				this.datos.add(Integer.parseInt(st.nextToken()));
		} catch (FileNotFoundException e) {
			this.setDatos(null);
			e.printStackTrace();
		}
		return this.datos;
	}

	public Long getCantidadDatos() {
		return cantidadDatos;
	}

	public void setCantidadDatos(Long cantidadDatos) {
		this.cantidadDatos = cantidadDatos;
	}

	public List<Integer> getDatos() {
		return datos;
	}

	public void setDatos(List<Integer> datos) {
		this.datos = datos;
	}
}
