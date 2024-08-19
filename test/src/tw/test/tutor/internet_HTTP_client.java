package tw.test.tutor;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class internet_HTTP_client {

	public static void main(String[] args) {
		try {
			
			URL url = new URL("https://www.iii.org.tw");
			URLConnection connect = url.openConnection();
			
			BufferedInputStream bin = new BufferedInputStream(connect.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
			
			String line;
			while((line = reader.readLine())!=null) {
				System.out.println(line);
			}
			Desktop.getDesktop().browse(new URI("https://www.iii.org.tw"));
			
			bin.close();
			
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}

}
