package Sudoku;

public interface ISudokuCore {
	
	public void backTrackingSearch(int[][] matrice, int ligne, int colonne);

	public boolean verifierMatrice(int[][] matrice, int ligne, int colonne, int chiffre);
}
