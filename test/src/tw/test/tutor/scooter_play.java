package tw.test.tutor;

import tw.test.apis.bike;
import tw.test.apis.scooter;
import tw.test.apis.car;

public class scooter_play {

	public static void main(String[] args) {
		scooter s = new scooter("red");
		System.out.println(s.getColor());
		
		bike b1 = new bike();
		
		car c1 = new car(3);
		
		
	}

}
