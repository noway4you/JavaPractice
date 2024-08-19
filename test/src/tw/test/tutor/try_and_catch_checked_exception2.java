package tw.test.tutor;

public class try_and_catch_checked_exception2 {

	public static void main(String[] args) {
		check_exception2_2 obj = new check_exception2_2();
		try {
			obj.c1();
		}catch(Exception e) {
			System.out.println("error!");
		}
	}
}

class check_exception2_2 {
	void c1() throws Exception {
		System.out.println("c1-1");
		c2();
	}
	void c2() throws Exception {
		System.out.println("c2-1");
		c3();
	}
	void c3() throws Exception {
		System.out.println("c3-1");
		throw new Exception();
	}
}