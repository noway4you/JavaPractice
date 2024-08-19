package tw.test.tutor;

import java.util.LinkedList;
import java.util.List;

public class linkedlist_practice {

	public static void main(String[] args) {
		List list = new LinkedList();
		list.add("hi");
		list.add(1);
		list.add(0,true);
		list.add(1.1);
		System.out.print("list size: ");
		System.out.print(list.size());
		System.out.println("\n-----------------------");
		System.out.print("forEach method: ");
		for(Object object : list) System.out.print(object + " ");
	}

}
