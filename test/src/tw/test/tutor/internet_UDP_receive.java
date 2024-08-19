package tw.test.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class internet_UDP_receive {

	public static void main(String[] args) {
		byte[] buffer = new byte[4096];
		try {
			DatagramSocket socket = new DatagramSocket(8888);
			DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
			socket.receive(packet);
			socket.close();
			
			String ip = packet.getAddress().getHostAddress();
			byte[] data = packet.getData();
			int length = packet.getLength();
			System.out.println(ip + " => " + new String(buffer,0,length));
			
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
		
	}

}
