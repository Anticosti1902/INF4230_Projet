
public class SudokuCore implements ISudokuCore{
	
	private boolean continuer = true;
	
	public int[][] chercherSolution(int[][] matrice){
		
		int[][] resultat = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
        	
            for (int j = 0; j < 9; j++) {
            	
            	resultat[i][j] = matrice[i][j];
            }
            
        }
		
		continuer = true;
		
		backTrackingSearch(resultat, 0, 0);
		
		return resultat;
	}
	
	private void backTrackingSearch(int[][] matrice, int ligne, int colonne){
		
		if (ligne == 8 && colonne == 9) {
			
			continuer = false;
			
            return ;
        }
  
        if (colonne == 9) {
        	
        	ligne++;
        	
        	colonne = 0;
        }
  
        //Si la case actuelle est disponible
        if (matrice[ligne][colonne] == 0) {
        	
            for (int n = 1; n <= 9; n++) {
            	
                if (verifierMatrice(matrice, ligne, colonne, n)) {
                      
                	matrice[ligne][colonne] = n;
                	
                	backTrackingSearch(matrice, ligne, colonne + 1);
                    
                	//Initialiser la case
                	if(continuer){
                		matrice[ligne][colonne] = 0;
                	}
                    
                }
            }
        } else {
            //Aller a la prochaine case
        	backTrackingSearch(matrice, ligne, colonne + 1);
        }
	}
	
	private boolean verifierMatrice(int[][] matrice, int ligne, int colonne, int chiffre){
		
        for (int i = 0; i < 9; i++) {
        	
            if (matrice[ligne][i] == chiffre || matrice[i][colonne] == chiffre) {
            	
                return false;
            }
        }
        //Verifier la sub matrice
        int iSubMatrice = ligne / 3;
        
        int jSubMatrice = colonne / 3;
        
        for (int i = 0; i < 3; i++) {
        	
            for (int j = 0; j < 3; j++) {
            	
                if (matrice[iSubMatrice * 3 + i][jSubMatrice * 3 + j] == chiffre) {
                	
                    return false;
                }
            }
        }
        
        return true;
	}
	
	private void clonerMatrice(int[][] original) {
		
		int[][] matrice = new int[9][9];
		
        for (int i = 0; i < 9; i++) {
        	
            for (int j = 0; j < 9; j++) {
            	
            	matrice[i][j] = original[i][j];
            }
        }
    }
	
	private void afficherMatrice(int[][] matrice) {
		
        for (int i = 0; i < 9; i++) {
        	
            for (int j = 0; j < 9; j++) {
            	
                System.out.print(matrice[i][j] + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
    }

}
