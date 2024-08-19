package tw.test.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class internet_UDP_send {
	
	// cmd檢查port是否被佔用
	// netstat -ano | findstr 8888(port)    >> 檢查該port佔用的程式
	// taskstat -ano | findstr (id number)  >> 查看該id的程式
	public static void main(String[] args) {
		String message = "1";
		byte[] buffer = message.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(buffer,buffer.length,InetAddress.getByName("10.0.100.255"),8888);
			socket.send(packet);
			socket.close();
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}

}
