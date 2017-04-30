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
		
		int[][] solution = sudoku.chercherSolution(matrice);
		
		for (int i = 0; i < 9; i++) {
        	
            for (int j = 0; j < 9; j++) {
            	
                System.out.print(solution[i][j] + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
		
	}

}
