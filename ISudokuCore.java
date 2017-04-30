package Sudoku;

public interface ISudokuCore {
	
	public int[][] chercherSolution(int[][] matrice);

	public boolean verifierMatrice(int[][] matrice, int ligne, int colonne, int chiffre);
}
