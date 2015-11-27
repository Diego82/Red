package direccionesRed;

import java.io.IOException;
import java.net.InetAddress;

public class TestDirecciones {

	public static void main(String[] args) {
		try {
			InetAddress in = InetAddress.getLocalHost();
			System.out.println(in);
			System.out.println(in.isReachable(5000));
			System.out.println(in.isLoopbackAddress());
			
			InetAddress in2 = InetAddress.getByName("www.google.es");
			System.out.println(in2);			
			System.out.println(in2.isReachable(5000));
			System.out.println(in2.isLoopbackAddress());

			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
