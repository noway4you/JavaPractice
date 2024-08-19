package tw.test.tutor;

public class try_and_catch_checked_excption3 {

	public static void main(String[] args) {
		m1();
	}
	
	static void m1() {
		int[] s = {1,2,3,4,5};
		
		try {
			System.out.println(s[10]);
		} catch(Exception e) {
			System.out.println("error => " + e);
		} finally {
			System.out.println("finish");
		}
	}
}
