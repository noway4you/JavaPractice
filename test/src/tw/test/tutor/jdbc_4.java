package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class jdbc_4 {

	public static void main(String[] args) {
		String url3 = "jdbc:mysql://127.0.0.1:3306/BRAD";
		Properties property = new Properties();
		property.put("user","root");
		property.put("password","root");
		
		try(Connection connect3 = DriverManager.getConnection(url3,property)){
			String name = "Amy";
			String tel = "123456789";
			String birthday = "1999-03-04";
			int id = 4;
			
			String sql = "update t2 set name = ? , tel = ? , birthday = ? where id = ?";
			PreparedStatement prepare = connect3.prepareStatement(sql);
			prepare.setString(1,name);
			prepare.setString(2,tel);
			prepare.setString(3,birthday);
			prepare.setInt(4,id);
			
			prepare.executeUpdate();
			
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println("error => " + e);
		}
	}
}
