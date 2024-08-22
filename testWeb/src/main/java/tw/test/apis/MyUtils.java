package tw.test.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyUtils {
	public static String loadView() throws Exception {
		String url = "D:/JavaPractice/testWeb/src/main/webapp/views/view1.html";
		String source = url;
		File viewFile = new File(source);
		int length = (int)viewFile.length();
		byte[] buffer = new byte[length];
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(viewFile));
		bin.read(buffer);
		bin.close();
		return new String(buffer);
	}
	
	public static String cal(String x,String y) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			return intX + intY + "";
		}catch(Exception e) {
			return "";
		}
	}
}
