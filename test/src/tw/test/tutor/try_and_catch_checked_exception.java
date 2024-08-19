package tw.test.tutor;

public class try_and_catch_checked_exception {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setleg(7);
		} catch (Exception e) {
			System.out.println("error");;
		}
	}
}

class Bird {
	private int leg;
	void setleg(int leg) throws Exception {
		if(leg >= 0 && leg <= 2) {
			this.leg = leg;
		}else {
			throw new Exception();
		}
	}
}