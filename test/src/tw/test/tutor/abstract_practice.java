package tw.test.tutor;

public class abstract_practice {

	public static void main(String[] args) {
		abstract_1 ab1 = new abstract_1() { void m2() {
			System.out.println("ab1_m2");
		}};
		ab1.m1(); ab1.m2();
		
		abstract_1 ab2 = new abstract_2();
		ab2.m1(); ab2.m2();
	}
}

abstract class abstract_1 {
	void m1() {System.out.println("ab_m1");}
	abstract void m2();
}

class abstract_2 extends abstract_1 {
	void m2() {System.out.println("ab2_m2");}
}

class abstract_3 extends abstract_1 {
	void m2() {System.out.println("ab3_m2");}
}