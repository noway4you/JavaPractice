package tw.test.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class internet_getname {

	// TCP => 連接導向 => 訊息發送方與訊息接收方會進行雙向確認。
	// UDP => 非連接導向 => 訊息發送方會發送訊息，但不會去進行確認接收方。
	// 網頁預設port = 80(可省略)
	// 運作方式 => ip(位址) => 選擇特定port => 與listener進行通訊協定
	public static void main(String[] args) {
		try {		
			InetAddress ip = InetAddress.getByName("www.google.com.tw");
			System.out.println(ip);
		} catch (UnknownHostException e) {
			System.out.println("error => " + e);
		}
	}

}
