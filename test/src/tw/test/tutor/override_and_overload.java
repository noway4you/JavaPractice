package tw.test.tutor;

public class override_and_overload {

	public static void main(String[] args) {
		
	}

}

class o1 {
	void m1() {}
	void m1(int a) {}
	public int m1(double a) {return 1;}
	int m2() {return 1;}
}

class o2 extends o1 {
	int m2() {return 2;}
}