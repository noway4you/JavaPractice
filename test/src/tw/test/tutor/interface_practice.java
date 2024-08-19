package tw.test.tutor;

public class interface_practice {

	public static void main(String[] args) {
		mouse_1 a1 = new mouse_3();
		mouse_2 a2 = new mouse_3();
		mouse_3 a3 = new mouse_3();
		a1.m1(); a1.m2();
		a2.m3(); a2.m4();
		a3.m1(); a3.m2(); a3.m3(); a3.m4();
	}
}

// interface >> only need to define method >> default as public type
interface mouse_1 {
	void m1();
	void m2();
}

interface mouse_2 {
	void m3();
	void m4();
}

class mouse_3 implements mouse_1 , mouse_2 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}