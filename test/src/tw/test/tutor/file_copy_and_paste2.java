package tw.test.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;

public class file_copy_and_paste2 {

	public static void main(String[] args) throws IOException {
		long time = System.currentTimeMillis();
		
		byte[] buffer = new byte[4096];
		File s = new File("dir1/HTML Project");
		FileInputStream fin = new FileInputStream("dir1/creepy-mood-141972.mp3");
		FileOutputStream fout = new FileOutputStream("dir2/creepy-mood-141972.mp3");
		
		int length;
		while((length = fin.read(buffer)) != -1){
			fout.write(buffer,0,length);
		}
		
		fin.close();
		fout.flush();
		fout.close();
		
		System.out.println(System.currentTimeMillis() - time);
	}

}
