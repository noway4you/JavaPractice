package tw.test.tutor;

public class constructor2 {

	public static void main(String[] args) {
		c11 res1 = new c11();
		c22 res2 = new c22();
		c33 res3 = new c33();
		
		attack(res1);
		attack(res2);
		attack(res3);
	}
	
	static void attack(c11 a) {
		a.m1();
	}

}

class c11 {
	void m1() {
		System.out.println("c1_m1");
	}
}
class c22 extends c11 {
	void m1() {
		System.out.println("c2_m1");
	}
}
class c33 extends c11 {
	void m1() {
		System.out.println("c3_m1");
	}
}