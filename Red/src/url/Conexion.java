package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Conexion {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.iesvirgendelcarmen.com/ies/index.php");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String linea;
			while ((linea=in.readLine())!=null) {
				System.out.println(linea);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
