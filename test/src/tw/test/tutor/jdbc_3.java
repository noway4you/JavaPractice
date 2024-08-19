package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class jdbc_3 {

	public static void main(String[] args) {
		String url3 = "jdbc:mysql://127.0.0.1:3306/BRAD";
		Properties property = new Properties();
		property.put("user","root");
		property.put("password","root");
		try(Connection connect3 = DriverManager.getConnection(url3,property)){
			Statement state = connect3.createStatement();
			String sql = "delete from t2 where id = 3";
			int n = state.executeUpdate(sql);
			System.out.println(n);
		}catch(Exception e) {
			System.out.println("error => " + e);
		}
	}
}
