package Sudoku;

public class TestCore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ISudokuCore sudoku = new SudokuCore();
		
		int[][] matrice = {  
                {8, 0, 0, 0, 0, 0, 0, 0, 0},  
                {0, 0, 3, 6, 0, 0, 0, 0, 0},  
                {0, 7, 0, 0, 9, 0, 2, 0, 0},  
                {0, 5, 0, 0, 0, 7, 0, 0, 0},  
                {0, 0, 0, 0, 4, 5, 7, 0, 0},  
                {0, 0, 0, 1, 0, 0, 0, 3, 0},  
                {0, 0, 1, 0, 0, 0, 0, 6, 8},  
                {0, 0, 8, 5, 0, 0, 0, 1, 0},  
                {0, 9, 0, 0, 0, 0, 4, 0, 0}};
		
		sudoku.backTrackingSearch(matrice, 0, 0);
		
	}

}
