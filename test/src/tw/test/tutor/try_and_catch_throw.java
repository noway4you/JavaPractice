package tw.test.tutor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.IllegalFormatException;

public class try_and_catch_throw {

	public static void main(String[] args) {
		
	}
}

class t1 {
	void t11() throws Exception {
		
	}
}

class t2 extends t1{
	void t11() throws IOException , SQLException , IllegalFormatException{
		
	}
}