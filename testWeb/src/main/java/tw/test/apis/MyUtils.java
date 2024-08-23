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
	
	public static String cal(String x,String y,String op) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			StringBuffer sb = new StringBuffer();
			switch(op) {
				case "1": sb.append(intX+intY); break;
				case "2": sb.append(intX-intY); break;
				case "3": sb.append(intX*intY); break;
				case "4": sb.append(intX/intY).append("...").append(intX%intY); break;
			}
			return sb.toString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public static String createScore() {
		return (int)(Math.random()*100+1)+"";
	}
}
