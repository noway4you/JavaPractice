package tw.test.tutor;

import java.io.FileReader;
import java.io.IOException;

public class file_reader1_1 {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("./dir1/file2.txt");
		
		int c;
		while((c = fr.read())!= -1) {
			System.out.print((char)c);
		}
		
		fr.close();
	}

}
