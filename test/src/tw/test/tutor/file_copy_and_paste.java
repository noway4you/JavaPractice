package tw.test.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class file_copy_and_paste {

	public static void main(String[] args) throws IOException {
		long time = System.currentTimeMillis();
		
		FileInputStream fin = new FileInputStream("dir1/kitty.jpg");
		FileOutputStream fout = new FileOutputStream("dir2/kitty.jpg");
		
		int b;
		while((b = fin.read()) == -1){
			fout.write(b);
		}
		
		fin.close();
		fout.flush();
		fout.close();
		
		System.out.println(System.currentTimeMillis() - time);
	}

}
