package tw.test.tutor;

import tw.test.apis.check_regular;

public class check {

	public static void main(String[] args) {
		System.out.println(check_regular.check_id_number("L125261385"));
		System.out.println(check_regular.check_ip_address("192.1.1.255"));
		System.out.println(check_regular.check_date("1024-1-31"));
		System.out.println(check_regular.check_time("10:20:10"));
		System.out.println(check_regular.check_mobile_number("0905-599825"));
		System.out.println(check_regular.check_phone_number("04-26393252"));
	}

}
