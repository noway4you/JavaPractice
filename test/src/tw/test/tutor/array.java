package tw.test.tutor;

public class array {

	public static void main(String[] args) {
		// 除基本型別外，都算object
		int[] arr1;
		arr1 = new int[3];
		boolean[] arr2;
		arr2 = new boolean[3];
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i] + "\t");
		}
		System.out.print(arr1.length);
		System.out.println();
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i] + "\t");
		}
		System.out.print(arr1.length);
		System.out.println();
		//for-each
		for(int i:arr1) System.out.print(i+"\t");
	}

}
