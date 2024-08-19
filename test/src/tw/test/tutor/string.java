package tw.test.tutor;

import tw.test.apis.bike;

public class string {

	public static void main(String[] args) {
		String s1 = new String();
		System.out.println(s1.length());
		
		byte[] b1 = {97,98,99,100};
		String s2 = new String(b1);
		System.out.println("s2 length = "+s2.length());
		System.out.println("s2 = "+s2);
		
		bike b2 = new bike();
		System.out.println("b2 = "+b2);
		
		int c = 12;
		System.out.println("c = "+c);
		
		Object ob1 = new Object();
		System.out.println(ob1);
		
		String s3 = "hi";               // String s = "" >> s point to object name String Pool
		String s4 = "hi";
		String s5 = new String("hi");   // String s = new String("") >> s point to object name String
		System.out.println(s3==s4);
		System.out.println(s3==s5);
		System.out.println(s3.equals(s4) + " " + s4.equals(s5) + " " + s5.equals(s3));
		
		String s6 = "hello";
		System.out.println("s6 = "+s6+"\ns6 before = "+s6.concat("1"));
		
		String s7 = "hello";
		System.out.println("s7 before = "+s7+"\ns7 after = "+s7.replace("l", "L"));
	}

}
