package tw.test.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class file_input_stream {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("./dir1/file1.txt");
			int c;
			while((c = fin.read())!= -1) {
				System.out.print((char)c);
			}
			fin.close();
		} catch (IOException e) {
			System.out.println("errors => " + e);
		}
	}
}
