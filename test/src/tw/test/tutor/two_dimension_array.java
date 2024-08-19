package tw.test.tutor;

public class two_dimension_array {

	public static void main(String[] args) {
		int[][] arr1 = new int[3][];
		arr1[0] = new int[2];
		arr1[1] = new int[3];
		arr1[2] = new int[4];
		for(int[] i : arr1) {
			for(int j:i) System.out.print(j + "\t");
			System.out.println();
		}
	}

}
