package tw.test.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.test.apis.student;

public class object_output_reader {

	public static void main(String[] args) {
		student s1 = new student("A",10,20,30);
		
		try {
			FileOutputStream fout = new FileOutputStream("dir1/s1.score");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(s1);
			
			oout.flush();
			oout.close();
		}catch(Exception e) {
			System.out.println("error => " + e);
		}
	}

}
