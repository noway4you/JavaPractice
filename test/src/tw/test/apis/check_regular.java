package tw.test.apis;

public class check_regular {
	public static boolean check_id_number(String id) {
		if(id.matches("[A-Z][12][0-9]{8}")) return true;
		else return false;
	}
	
	public static boolean check_ip_address(String ip) {
		if(ip.matches("^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\."+
					  	"([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\."+
					  	"([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\."+
					  	"([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$")) return true;
		return false;
	}
	
	public static boolean check_date(String date) {
		if(date.matches("^([0-9]|[1-9][0-9]|[1-9][0-9]{2}|[1-9][0-9]{3})\\-"+
						"([1-9]|1[0-2])\\-"+"([1-9]|[1-2][0-9]|3[0-1])$")) return true;
		else return false;
	}
	
	public static boolean check_time(String time) {
		if(time.matches("^([0-9]|1[0-9]|2[0-3])\\:"+
						"([0-9]|[1-5][0-9])\\:"+
						"([0-9]|[1-5][0-9])$")) return true;
		else return false;
	}
	
	public static boolean check_mobile_number(String number) {
		if(number.matches("^(09[0-9]{2})\\-"+"([0-9]{6})$")) return true;
		else return false;
	}
	
	public static boolean check_phone_number(String number) {
		if(number.matches("^(0[0-9])\\-"+"([0-9]{8})$")) return true;
		else return false;
	}
}
