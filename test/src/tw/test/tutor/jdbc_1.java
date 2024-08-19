package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class jdbc_1 {

	public static void main(String[] args) {
		// load driver (connector)
		// connector name = com.mysql.cj.jdbc.Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
			System.out.println("error => " + e);
			throw new RuntimeException();
		}
		
		//jdbc:mysql://主機名稱:連接阜/[資料庫名稱]?參數列
		// ? >> 隔開
		// 參數列 >> key = value
		
//		String url1 = "jdbc:mysql://127.0.0.1:3306/BRAD?user=root&password=root";
//		try(Connection connect1 = DriverManager.getConnection(url1)){
//			System.out.println("ok");
//		}catch(Exception e) {
//			System.out.println("error => " + e);
//		}
//		
//		String url2 = "jdbc:mysql://127.0.0.1:3306/BRAD";
//		try(Connection connect2 = DriverManager.getConnection(url2,"root","root")){
//			System.out.println("ok2");
//		}catch(Exception e) {
//			System.out.println("error => " + e);
//		}
		
		String url3 = "jdbc:mysql://127.0.0.1:3306/BRAD";
		Properties property = new Properties();
		property.put("user","root");
		property.put("password","root");
		try(Connection connect3 = DriverManager.getConnection(url3,property)){
//			System.out.println("ok3");
			Statement state = connect3.createStatement();
			String sql = "INSERT INTO t2 (name,tel,birthday) VALUES('BRAD','123','1999-01-02')";
			sql += ",('ERIC','1111','1999-01-02')";
			int n = state.executeUpdate(sql);
			System.out.println(n);
		}catch(Exception e) {
			System.out.println("error => " + e);
		}
	}
}
