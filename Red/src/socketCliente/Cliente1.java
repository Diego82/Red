package socketCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente1 {

	public static void main(String[] args) {
		try (Socket socket = new Socket("time.nist.gov", 13);
				BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));){
			
			//
			Pattern patron = Pattern.compile(".*?\\s(\\d{1,2}-\\d{1,2}-\\d{1,2})\\s(\\d{1,2}:\\d{1,2}:\\d{1,2})");
			
			String linea="";
			Matcher matcher = null;
			
			while ((linea=in.readLine())!=null) {
				matcher = patron.matcher(linea);
				if (matcher.find()) {
					System.out.printf("HORA: %s, Fecha: %s",matcher.group(2),matcher.group(1));
				}
				
				//System.out.println(linea);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
