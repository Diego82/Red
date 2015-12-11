package socketServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	private int puerto;
	private String host;
	public Cliente(int puerto, String host) {
		this.puerto = puerto;
		this.host = host;
	}
	
	public Socket conectar() throws UnknownHostException, IOException{
		return new Socket(this.host, this.puerto);
	}
}

class TestCliente{
	public static void main(String[] args) {
		Cliente cliente = new Cliente(3000, "192.168.17.53");
		try (Socket socket = cliente.conectar();
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				BufferedReader in = new BufferedReader(
										new InputStreamReader(socket.getInputStream()));){
		
			//mandamos datos
			out.write("juan\n");
			out.flush();
			//recibimos datos
			String recibido = in.readLine();
			System.out.println("Dani cabron que quieres hacer hoy "+recibido+"\n\n");
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
