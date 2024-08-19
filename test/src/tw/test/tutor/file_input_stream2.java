package tw.test.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class file_input_stream2 {

	// filestream >> normally be used in reading binary type data
	public static void main(String[] args) {
		try {
			File source = new File("./dir1/file2.txt");
			FileInputStream fin = new FileInputStream(source);
			byte[] s = new byte[(int)source.length()];
			fin.read(s);
			System.out.print(new String(s));
			fin.close();
		} catch (IOException e) {
			System.out.println("errors => " + e);
		}
	}
}
