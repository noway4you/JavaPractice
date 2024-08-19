package tw.test.tutor;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class internet_HTTP_client4 {

	public static void main(String[] args) {
		try {
			
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			URLConnection connect = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(connect.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
			
			String line;
			StringBuffer buffer = new StringBuffer();
			while((line = reader.readLine())!=null) {
				buffer.append(line);
			}
			
			parseJS(buffer.toString());
			
			bin.close();
			
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}
	
	// use json package
	static void parseJS(String json) {
		JSONArray root = new JSONArray(json);
		for(int i=0;i<root.length();i++) {
			JSONObject element = root.getJSONObject(i);
			String name = element.getString("Name");
			System.out.println(name);
		}
	}

}
