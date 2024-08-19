package tw.test.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.test.apis.student;

public class object_input_reader {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/s1.score");
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Object obj = oin.readObject();
			student s1 = (student)obj;
			System.out.println(s1);
			System.out.println(s1.sum());
			System.out.println(s1.average());
			System.out.println(s1.getbike());
			
			oin.close();
		}catch(Exception e) {
			System.out.println("error => " + e);
		}
	}

}
