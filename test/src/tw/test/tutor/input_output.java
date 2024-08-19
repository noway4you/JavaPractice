package tw.test.tutor;

import java.io.File;

public class input_output {

	public static void main(String[] args) {
		File nowdir = new File(".");
		System.out.println(nowdir.getAbsolutePath());
		File f1 = new File("C:/Users/User/eclipse-workspace/test/dir1");
		File f2 = new File("C:/Users/User/eclipse-workspace/test/dir2");
		if(f1.exists()) System.out.println(true);
		f1.mkdir(); f2.mkdir();
		
	}

}
