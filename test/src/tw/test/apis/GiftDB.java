package tw.test.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GiftDB {
	private static final String user = "root";
	private static final String user_password = "root";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/brad";
	private static final String sql = "select * from gift";
	
	private Connection conn;
	private ResultSet result;
	private String[] fields;
	
	public GiftDB() throws SQLException {
		Properties prop = new Properties();
		prop.put("user",user);
		prop.put("password",user_password);
		
		conn = DriverManager.getConnection(url,prop);
	}
	
	public void Query() throws SQLException {
		Query(sql);
	}
	
	public void Query(String sql) throws SQLException {
		Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		result = state.executeQuery(sql);
		
		ResultSetMetaData meta = result.getMetaData();
		fields = new String[meta.getColumnCount()];
		for(int i=0;i<meta.getColumnCount();i++) {
			fields[i] = meta.getColumnLabel(i+1);
		}
	}
	
	public int getRows() {
		try {
			result.last();
			return result.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	public int getCols() {
		return fields.length;
	}
	
	public String getData(int row,int col) {
		try {
			result.absolute(row+1);
			return result.getString(col+1);
		} catch (Exception e) {
			return "Error";
		}
	}
	

	public String[] getFieldNames() {
		return fields;
	}
	
	public void delData(int row) throws SQLException {
		result.absolute(row);
		result.deleteRow();
	}
	
	public void updateData(String newData,int row,int col) {
		try {
			result.absolute(row+1);
			result.updateString(col+1,newData);
			result.updateRow();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
