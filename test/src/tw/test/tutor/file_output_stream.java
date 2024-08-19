package tw.test.tutor;

import java.io.FileOutputStream;
import java.io.IOException;

public class file_output_stream {

	public static void main(String[] args) throws IOException {
		String s = "Hello,World => 嗨囉";
		
		FileOutputStream fout = new FileOutputStream("./dir1/file3.txt");
		fout.write(s.getBytes());
		fout.flush();
		fout.close();
	}
}
