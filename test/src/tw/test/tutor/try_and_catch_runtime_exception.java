package tw.test.tutor;

public class try_and_catch_runtime_exception {

	public static void main(String[] args) {
		int a=10 , b=2;
		int[] c = {1,2,3,4,5};
		
		try {
			System.out.println(a/b);
			System.out.println(c[10]);
		}
		catch(ArithmeticException e) {
			System.out.println("ArithmeticException Error");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("BoundsException Error");
		}catch(RuntimeException e) {
			System.out.println("RunTime Error");
		}
	}

}
