package socketServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private int puerto;
	private ServerSocket servidor;

	public Servidor(int puerto) {
		this.puerto = puerto;
	}
	
	public Socket conectar() throws IOException{
		servidor = new ServerSocket(this.puerto);
		
		return servidor.accept();
	}
	
	public String mensaje(String recibido){
		return "hola "+recibido;
	}
}
class TestServidor{
	public static void main(String[] args) {

		System.out.println("Servidor esperando datos.....");
		Servidor servidor = new Servidor(3000);
		try (Socket cliente = servidor.conectar();
				BufferedReader in = new BufferedReader(
										new InputStreamReader(
												cliente.getInputStream()));
				PrintWriter out = new PrintWriter(cliente.getOutputStream());){
			
			//recibiendo datos
			String nombre = in.readLine();
			//Procesando datos
			String mensaje = servidor.mensaje(nombre);
			//Enviando datos
			out.write(mensaje);
			out.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
