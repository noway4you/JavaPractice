package tw.test.apis;

import java.io.Serializable;

public class student implements Serializable{
	
	private String name;
	private int math , chinese , english;
	private bike bike;
	
	public student(String name , int math , int chinese , int english) {
		this.name = name;
		this.math = math;
		this.chinese = chinese;
		this.english = english;
		bike = new bike();
	}
	
	public int sum() {
		return math + chinese + english;
	}
	
	public double average() {
		return sum()/3.0;
	}
	
	public bike getbike() {
		return bike;
	}
	
	@Override
	public String toString() {
		return name + " => math = " + math + " , chinese = " + chinese + " , english = " + english;
	}
}
