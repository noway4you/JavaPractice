package tw.test.tutor;

import tw.test.apis.bike;

public class bike_play {

	public static void main(String[] args) {
		bike mybike = new bike();
		mybike.upSpeed(5);
		mybike.downSpeed(3);
		System.out.println(mybike.displacement(10, 10));
	}

}
