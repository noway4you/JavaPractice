package tw.test.tutor;

import java.util.HashMap;

public class hashmap {

	public static void main(String[] args) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("name","hi");
		map.put("age",18);
		map.put("gender",true);
		map.put("weight",10.1);
		
		System.out.println(map.get("age"));
		System.out.println("--------------");
		for (String key : map.keySet()) System.out.println(map.get(key));
	}

}
