package tw.test.tutor;

public class interface_extends {

	public static void main(String[] args) {
		
	}

}

interface a1 {
	void a11();
}
interface a2 {
	void a22();
}
interface a3 extends a1 , a2 {
	void a33();
}

class a123 implements a3 {

	@Override
	public void a11() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void a22() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void a33() {
		// TODO Auto-generated method stub
		
	}
	
}