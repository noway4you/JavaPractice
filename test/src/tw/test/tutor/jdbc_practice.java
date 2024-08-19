package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class jdbc_practice {

	public static void main(String[] args) {
		
		// sqlite.org >> search sql syntax from here
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name:");
		String name = sc.nextLine();
		System.out.println("Enter the tel:");
		String tel = sc.nextLine();
		System.out.println("Enter the birthday:");
		String birthday = sc.nextLine();
		
		String url3 = "jdbc:mysql://127.0.0.1:3306/BRAD";
		Properties property = new Properties();
		property.put("user","root");
		property.put("password","root");
		
		try(Connection connect3 = DriverManager.getConnection(url3,property)){

			String sql = "insert into t2 (name,tel,birthday) values (?,?,?)";
			PreparedStatement prepare = connect3.prepareStatement(sql);
			prepare.setString(1,name);
			prepare.setString(2,tel);
			prepare.setString(3,birthday);
			
			prepare.executeUpdate();
			
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println("error => " + e);
		}
	}
}
