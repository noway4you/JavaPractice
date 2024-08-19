package tw.test.tutor;

import java.util.Iterator;
import java.util.TreeSet;

public class hashset_practice2 {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		while(set.size()<=6) set.add((int)(Math.random()*39)+1);
		System.out.println(set);
		System.out.println("----------------------");
		
		System.out.print("iterator method: ");
		Iterator<Integer> set_it = set.iterator();
		while(set_it.hasNext()) {
			int num = set_it.next();
			System.out.print(num + " ");
		}
		System.out.println("\n----------------------");
		
		System.out.print("forEach method: ");
		for (Integer integer : set) {
			System.out.print(integer + " ");
		}
		System.out.println("\n----------------------");
		
		
	}

}
