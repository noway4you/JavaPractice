package tw.test.apis;

public class scooter extends bike{
	private int gear;
	private String color;
	
	public scooter() {
		System.out.println("hello1");
		color = "Yellow";
	}
	
	public scooter(String color) {
		System.out.println("hello2");
		this.color = color;
	}
	
	public void change_gear(int gear) {
		if(gear >=0 && gear <=4) {
			this.gear = gear;
		}
	}
	
	public void upSpeed() {
		super.upSpeed(10);
	}
	
	public String getColor() {
		return color;
	}
}
