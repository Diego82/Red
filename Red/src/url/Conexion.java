package url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conexion {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://elpais.com/tag/fecha/ultimahora/");
			File archivo = new File("/home/matinal/Escritorio/salida.txt");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			BufferedWriter out = new BufferedWriter(new PrintWriter(archivo));
			String linea;
			String codigo="";
			Pattern patron = Pattern.compile("<h2><a title=\"Ver noticia\" href (.*?)\">(.*?)</a></h2>");
			
			while ((linea=in.readLine())!=null) codigo+= linea;

				Matcher matcher = null;
				matcher = patron.matcher(codigo);
				while(matcher.find())
					System.out.println(matcher.group(1));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
