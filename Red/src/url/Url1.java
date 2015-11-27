package url;

import java.net.MalformedURLException;
import java.net.URL;

public class Url1 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://github.com/Diego82?tab=repositories");
			System.out.println("Protocolo: "+url.getProtocol());
			System.out.println("Host: "+url.getHost());
			System.out.println("Port: "+url.getPort());
			System.out.println("Port: "+url.getDefaultPort());
			System.out.println(url.getPath());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
