package tw.test.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class internet_TCP_server {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9999);Socket socket = server.accept()) {

			String ip = socket.getInetAddress().getHostAddress();
			System.out.print(ip + " => ");
			
			String filename = "dir2/" + ip + ".jpg";
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filename));
			
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
			byte[] buffer = new byte[4096];
			int length;
			while((length = bin.read(buffer))!=-1) bout.write(buffer,0,length);
			
			bout.flush();
			bout.close();
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}

}
