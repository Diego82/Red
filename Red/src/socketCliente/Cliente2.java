package socketCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Cliente2 {

	public static void main(String[] args) {
		try (Socket socket = new Socket("dict.org", 2628);
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));){

			socket.setSoTimeout(4_000);
			//Pasamos los datos al servidor
			out.write("define fd-spa-eng amigo\r\n");
			out.flush();
			
			String linea="";
			while ((linea=in.readLine())!=null) {
				
				//if (linea.matches("\\w+"))
				//	System.out.println(linea);		
				
				System.out.println(linea);
				System.out.println();
				
			}
		} catch (SocketTimeoutException e) {
			// TODO: handle exception
			System.out.println("Final de conexion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
