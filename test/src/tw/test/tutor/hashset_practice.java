package tw.test.tutor;

import java.util.HashSet;

public class hashset_practice {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		int[] arr1 = {1,2,3,4,1,2,5};
		for(int i:arr1) set.add(i);    // add() >> input will be packed as object
		System.out.println(set);   
	}

}
