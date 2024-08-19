package tw.test.tutor;

public class string2 {

	public static void main(String[] args) {
		String_3 str3 = new String_3();
	}

}

class String_1 {
	String_1(){
		System.out.println("String_1");
	}
}

class String_2 extends String_1{
	String_2(){
		System.out.println("String_2");
	}
}

class String_3 extends String_2{
	String_3(){
		this(2);
		System.out.println("String_3");
	}
	String_3(int a){
		this(" ");
		System.out.println("String_3("+a+")");
	}
	String_3(String a){
		System.out.println("String_3("+a+")");
	}
}