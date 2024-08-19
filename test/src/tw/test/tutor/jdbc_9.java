package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import tw.test.bcrypt.BCrypt;

public class jdbc_9 {
	
	static Connection conn;

	public static void main(String[] args) {
		
		System.out.println("Register...");
		
		Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password","root");
		String url = "jdbc:mysql://127.0.0.1:3306/brad";
		
		try {
			conn = DriverManager.getConnection(url,prop);
			
			Scanner sc = new Scanner(System.in);
			String account;
			do {
				System.out.println("Account...");
				account = sc.next();
			}while(isExist(account));
			System.out.println("Password...");
			String password = sc.next();
			System.out.println("Name...");
			String name = sc.next();
			
			String sql = "insert into member (account,password,name) values (?,?,?)";
			String new_password = BCrypt.hashpw(password,BCrypt.gensalt());
			
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1,account);
			prep.setString(2,new_password);
			prep.setString(3,name);
			if(prep.executeUpdate()>0) System.out.println("Update success");
			else System.out.println("Update failure");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static boolean isExist(String account) throws Exception {
		String sql = "select account from member where account = ?";
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1,account);
		ResultSet result = prep.executeQuery();
		return result.next();
	}
}
