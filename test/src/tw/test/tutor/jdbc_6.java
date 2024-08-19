package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;

public class jdbc_6 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password","root");
		
		String url = "jdbc:mysql://127.0.0.1:3306/brad";
			
		try {
			Connection conn = DriverManager.getConnection(url,prop);
			String sql = "select * from gift order by city";
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);
			result.next();
			int row = result.getRow();
			System.out.println("row = " + row);
			String id = result.getString("id");
			System.out.println("id = " + id);
			String name = result.getString("name");
			System.out.println("name = " + name);
			
			System.out.println("-------------------------------");
			
			result.next();
			row = result.getRow();
			System.out.println("row = " + row);
			id = result.getString("id");
			System.out.println("id = " + id);
			name = result.getString("name");
			System.out.println("name = " + name);
			
			System.out.println("------------------------------");
			
			while(result.next()) {
				id = result.getString("id");
				name = result.getString("name");
				String city = result.getString("city");
				
				System.out.println(city+" : "+name+" : "+id+"\n");
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
