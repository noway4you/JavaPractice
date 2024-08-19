package tw.test.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class jdbc_16 {
	
	private static final String user = "root";
	private static final String user_password = "root";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/brad";
	private static final String sql = "select * from gift";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user",user);
		prop.put("password",user_password);
		
		try {
			Connection conn = DriverManager.getConnection(url,prop);
			PreparedStatement prep = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = prep.executeQuery();
			while(result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				System.out.println(id + " : " + name);
			}
			System.out.println("-------------------------");
			if(result.first()) {
				String id = result.getString("id");
				String name = result.getString("name");
				System.out.println(id + " : " + name);
			}
			System.out.println("-------------------------");
			if(result.absolute(47)) {
				String id = result.getString("id");
				String name = result.getString("name");
				System.out.println(id + " : " + name);
			}
			result.updateString("name","AAA");
			result.updateRow();
			System.out.println("-------------------------");
//			result.deleteRow();
			String id = result.getString("id");
			String name = result.getString("name");
			System.out.println(id + " : " + name);
			System.out.println("-------------------------");
			result.moveToInsertRow();
			result.updateString("name","AAA");
			System.out.println(id + " : " + name);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
