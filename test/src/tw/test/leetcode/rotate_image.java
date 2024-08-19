package tw.test.leetcode;

// rotate matrix with clockwise 90 degrees
public class rotate_image {

	public static void main(String[] args) {
		// given the matrix
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Before rotate :");
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		rotate(matrix);
		System.out.println();
		System.out.println("After rotate :");
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void rotate(int[][] matrix){
		int n = matrix.length;
		
		for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - row - 1; col++) {
            	// exchange top-left element and top-right element
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][n - 1 - row];
                matrix[col][n - 1 - row] = temp;

                // exchange top-left element and bottom-right element
                temp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - row][n - 1 - col];
                matrix[n - 1 - row][n - 1 - col] = temp;

                // exchange top-left element and bottom-left element
                temp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - col][row];
                matrix[n - 1 - col][row] = temp;
            }
        }
	}

}
