package tw.test.tutor;

public class class_1 {

	public static void main(String[] args) {
		class_3 obj = new class_3();
	}

}

class class_2{
	// new object once , static method is already exist
	static {System.out.println("class_2:static{}");}
	
	{System.out.println("class_2:{}");}
	
	class_2(){System.out.println("class_2()");}

	static void m2() {System.out.println("class_2:static m2()");}
	
	void m1() {System.out.println("class_2:static m1()");}
}

class class_3 extends class_2{
	static {System.out.println("class_3:static{}");}
}