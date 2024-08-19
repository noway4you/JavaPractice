package tw.test.tutor;

public class constructor {

	public static void main(String[] args) {
		c1 res = new c1();
		res.m1(); res.m2();
		
		System.out.println();
		
		c2 res2 = new c2();
		res2.m1(); res2.m2(); res2.m3();
		
		System.out.println();
		
		c1 res3 = new c2();
		res3.m1(); res3.m2();
		
		System.out.println();
		
		c2 res4 = (c2)res3;
		res4.m1(); res4.m2(); res4.m3();
		
		System.out.println();
		
		if(res3 instanceof Object) System.out.println("yes");
		else System.out.println("no");
		if(res3 instanceof c1) System.out.println("yes1");
		else System.out.println("no1");
		if(res3 instanceof c2) System.out.println("yes2");
		else System.out.println("no2");
		if(res3 instanceof c3) System.out.println("yes3");
		else System.out.println("no3");
	}
}

class c1 {
	void m1() {
		System.out.println("c1_m1");
	}
	
	void m2() {
		System.out.println("c1_m2");
	}
}

class c2 extends c1{
	void m2() {
		System.out.println("c2_m2");
	}
	
	void m3() {
		System.out.println("c2_m3");
	}
}
class c3 extends c1{
	void m2() {
		System.out.println("c3_m2");
	}
	
	void m3() {
		System.out.println("c3_m3");
	}
}
