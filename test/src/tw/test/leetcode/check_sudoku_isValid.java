package tw.test.leetcode;

import java.util.HashSet;
import java.util.Set;

public class check_sudoku_isValid {

	public static void main(String[] args) {
		// given an unfilled sudoku table ("." >> unfilled)
		String[][] nums = {
				{"5","3",".",".","7",".",".",".","."},
				{"6",".",".","1","9","5",".",".","."},
				{".","9","8",".",".",".",".","6","."},
				{"8",".",".",".","6",".",".",".","3"},
				{"4",".",".","8",".","3",".",".","1"},
				{"7",".",".",".","2",".",".",".","6"},
				{".","6",".",".",".",".","2","8","."},
				{".",".",".","4","1","9",".",".","5"},
				{".",".",".",".","8",".",".","7","9"}
		};
		// HashSet() >> output non-repeat elements
		boolean check = true;
		Set seen = new HashSet();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                String number = nums[i][j];
                if (number != ".") {
                	// when checking condition , the add methods also works
                    if (!seen.add(number + " in row " + i) || 
                    	!seen.add(number + " in column " + j) || 
                    	!seen.add(number + " in block " + i/3 + "-" + j/3)) {
                    	check = false;
                    	break;
                    }
                }
            }
            if(!check) break;
        }
        if(check) System.out.println(true);
        else System.out.println(false);
	}

}
