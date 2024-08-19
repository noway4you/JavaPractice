package tw.test.tutor;

import java.util.LinkedHashSet;

public class hashset_linkedlist {

	public static void main(String[] args) {
		LinkedHashSet<String> set = new LinkedHashSet<>();
		String[] s = {"hi","hi2","hi3","hi4","hi5"};
		for(String i:s) set.add(i);
		for (String string : set) System.out.print(string + " ");
	}

}
