package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class jdbc_8 {

	public static void main(String[] args) {
		
		int rpp = 10;
		
		System.out.println("pages = ");
		Scanner sc = new Scanner(System.in);
		int page = sc.nextInt();
		
		Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password","root");
		
		String url = "jdbc:mysql://127.0.0.1:3306/brad";
			
		try {
			Connection conn = DriverManager.getConnection(url,prop);
			String sql = "select * from gift order by id limit " + (page-1)*rpp + "," + rpp;
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);
			
			while(result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String city = result.getString("city");
				
				System.out.println(id+" : "+name+" : "+city+"\n");
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
