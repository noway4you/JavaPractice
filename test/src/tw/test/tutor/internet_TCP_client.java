package tw.test.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class internet_TCP_client {

	public static void main(String[] args) {
		File source = new File("dir1/kitty.jpg");
		try (Socket client = new Socket(InetAddress.getByName("10.0.100.112"), 9999);
				BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());
				BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source))) {
			byte[] br = new byte[(int)source.length()];
			bin.read(br);
			bout.write(br);
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}

}
