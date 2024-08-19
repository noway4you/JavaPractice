package tw.test.tutor;

import tw.test.bcrypt.BCrypt;

public class bcrypt {
	
	//encoding algorithm res aes
	
	public static void main(String[] args) {
		String password = "123456";
		String new_password = BCrypt.hashpw(password,BCrypt.gensalt());
		System.out.println(new_password);
		if(BCrypt.checkpw("123456",new_password)) System.out.println("ok");
		else System.out.println("none");
	}
}
