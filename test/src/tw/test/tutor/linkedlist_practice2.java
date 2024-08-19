package tw.test.tutor;

import java.util.LinkedList;
import java.util.List;

public class linkedlist_practice2 {

	public static void main(String[] args) {
		List<String> times = new LinkedList<String>();
		times.add(0,"10:20:30");
		times.add(0,"10:20:31");
		times.add(0,"10:20:32");
		times.add(0,"10:20:33");
		times.add(0,"10:20:34");
		times.add(0,"10:20:35");
		
		for (String string : times) System.out.println(string);
	}

}
