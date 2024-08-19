package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class jdbc_7 {

	public static void main(String[] args) {
		System.out.print("Keywords = ");
		Scanner sc = new Scanner(System.in);
		String key = sc.next();
		String sql = "select * from gift where name like ? or feature like ? or address like ?";
		String keywords = "%" + key + "%";
		
		Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password","root");
		
		String url = "jdbc:mysql://127.0.0.1:3306/brad";
		try {
			Connection conn = DriverManager.getConnection(url,prop);
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1,keywords);
			state.setString(2,keywords);
			state.setString(3,keywords);
			
			ResultSet result = state.executeQuery();
			while(result.next()) {
				String name = result.getString("name");
				String feature = result.getString("feature");
				String address = result.getString("address");
				
				System.out.println(name);
				System.out.println(feature);
				System.out.println(address);
				
				System.out.println("-------------------------------------");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
