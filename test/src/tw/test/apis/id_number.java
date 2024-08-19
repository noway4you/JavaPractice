package tw.test.apis;

import java.util.Random;

public class id_number {
	private String id;
	static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public id_number() {
		this(new Random().nextInt(2)==0); 
	}
	
	public id_number(boolean isMale) {
		this(isMale, alpha.charAt(new Random().nextInt(26)));
	}
	
	public id_number(char area) {
		this(new Random().nextInt(2)==0,area);
	}
	
	public id_number(boolean isMale,char area) {
		String c1 = new String(new char[] {area});
		StringBuffer sb = new StringBuffer(c1);
		sb.append(isMale?"1":"2");
		for(int i=0;i<7;i++) sb.append(new Random().nextInt(10));
		for(int i=0;i<10;i++) {
			if(isRight(sb.toString()+i)) {
				id = sb.toString()+i;
				break;
			}
		}
		
	}
	
	public String getId() {
		return id;
	}
	
  	public static boolean isRight(String id) {
		if(id.length()==10 && Character.isUpperCase(id.charAt(0))) {
			if(id.charAt(1)=='1'||id.charAt(1)=='2') {
				for(int i=2;i<10;i++) {
					if(!Character.isDigit(id.charAt(i))) return false;
				}
				return true;
			}
		}
		return false;
	}
	
	// regular expression
	public static boolean isRight2(String id) {
		if(id.matches("[A-Z][12][0-9]{8}")) return true;
		else return false;
	}
}
