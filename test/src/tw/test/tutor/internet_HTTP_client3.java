package tw.test.tutor;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class internet_HTTP_client3 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("dir2/http.pdf");
			
			URL url = new URL("https://pdfmyurl.com/?url=https://www.google.com.tw");
			URLConnection connect = url.openConnection();
			
			BufferedInputStream bin = new BufferedInputStream(connect.getInputStream());
			
			byte[] buffer = new byte[4096];
			int length;
			while((length = bin.read(buffer))!= -1) {
				fout.write(buffer,0,length);
			}
			
			fout.flush();
			fout.close();
			
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}

}
