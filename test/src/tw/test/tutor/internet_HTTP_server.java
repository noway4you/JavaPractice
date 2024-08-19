package tw.test.tutor;

import java.net.ServerSocket;
import java.net.Socket;

public class internet_HTTP_server {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(80);Socket socket = server.accept()){
			System.out.println("ok"); 
		}catch(Exception e) {
			System.out.println("error =>" + e);
		}
	}

}
