package reader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class CsvFileReader {
	
	//Lectura de la data
	public ArrayList<String> getData() throws IOException {
		
		ArrayList<String> dataRead =new ArrayList<String>();
		File archivo = new File("src/reader/ejemplo-uno.csv");
		
		//Guardar cada linea del archivo antes de leerlo
		BufferedReader br = new BufferedReader(new FileReader(archivo));
		
		String st;
		
		while((st = br.readLine()) != null) {
			dataRead.add(st);
		}
		
		return dataRead;
	}
}
