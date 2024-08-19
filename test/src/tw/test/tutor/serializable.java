package tw.test.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class serializable {

	public static void main(String[] args) {
		third obj = new third();
		
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/test.ok"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			
			System.out.println("---------------------");
			
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/test.ok"));
			oin.readObject();
			oin.close();
		}catch(Exception e) {
			System.out.println("error => " + e);
		}
	}

}

class first {
	first(){
		System.out.println("first()");
	}
}
class second extends first {
	second(){
		System.out.println("first()");
	}
}
class third extends second implements Serializable {
	third(){
		System.out.println("first3()");
	}
}