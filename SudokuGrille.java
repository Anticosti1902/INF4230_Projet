import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SudokuGrille extends JPanel implements MouseListener {
	
	private int[][] _plan;
	private ISudokuCore _sudokuCore;
	
	private SudokuCase[][] _sudokuCases;
    
    private SelectionnerNumeroGrille _numeroGrille;
    
    public SudokuGrille() {
        
    	_plan = null;
    	
    	_sudokuCore = new SudokuCore();
        
        this.setLayout(null);
        
        _sudokuCases = new SudokuCase[9][9];
        
        initialiser();
    }
    
    public void setPlan(int[][] plan){
    	
    	_plan = plan;
    }
    
    public void initialiser(){
    	
    	for (int i = 0; i < 9; i++) {
        	
            for (int j = 0; j < 9; j++) {
            	
            	_sudokuCases[i][j] = new SudokuCase();
                
            	_sudokuCases[i][j].setLocation(20 + i * 50 + (i / 3) * 5, 20 + j * 50 + (j / 3) * 5);
            	
                this.add(_sudokuCases[i][j]);
            }
        }
    	
    }
    
    public void chargerData(){
    	
    	if(_plan == null){
    		
    		return;
    	}
    	
    	for (int i = 0; i < 9; i++) {
        	
            for (int j = 0; j < 9; j++) {
            	
                if (_plan[i][j] != 0) {
                	
                	_sudokuCases[i][j].setText(_plan[i][j] + "");
                	
                	_sudokuCases[i][j].setForeground(Color.GRAY);
                    
                	_sudokuCases[i][j].setBackground(Color.WHITE);
                	
                	_sudokuCases[i][j].setEnabled(false);
                	
                } else {
                	
                	_sudokuCases[i][j].setText(" ");
                	
                	_sudokuCases[i][j].setEnabled(true);
                	
                	_sudokuCases[i][j].addMouseListener(this);
                }
            }
        }
    }
    
    public void verifierTermination(){
    	
    	for (int i = 0; i < 9; i++) {
    		
            for (int j = 0; j < 9; j++) {
            	
                if (!verrifierCase(i, j)) {
                	
                    return;
                }
            }
        }
    	
    	deactiveSudokuCases();
    	
    	MessagePopup message = new MessagePopup("Bravo! Vous avez compl��t�� ce niveau !");
    	
    	message.setModal(true);
        
    	message.setLocation(this.getLocationOnScreen().x + 100, this.getLocationOnScreen().y + 150);
        
    	message.setVisible(true);
    }
    
    public void afficherSolution(){
    	
    	if(_plan != null){
    	
	    	int[][] resultat = _sudokuCore.chercherSolution(_plan);
	    	
	    	if(resultat != null){
	    	
		    	for (int i = 0; i < 9; i++) {
		        	
		            for (int j = 0; j < 9; j++) {
		            	
		            	_sudokuCases[i][j].setText(resultat[i][j] + "");
		            	
		            	if(_plan[i][j] == 0){
		            	
			            	_sudokuCases[i][j].setForeground(Color.BLUE);
			            	
			            	_sudokuCases[i][j].setEnabled(true);
		            	}
		                
		            }
		        }
	    	
	    	}
    	
    	}
    	
    }
    
    public void deactiveSudokuCases() {
    	
        for (int i = 0; i < 9; i++) {
        	
            for (int j = 0; j < 9; j++) {
            	
            	_sudokuCases[i][j].removeMouseListener(this);
            	
            	_sudokuCases[i][j].setEnabled(false);
            }
        }

    }

    public void mousePressed(MouseEvent e) {
    	
        int masque = e.getModifiers();
        
        if ((masque & InputEvent.BUTTON3_MASK) != 0) {
            
            ((SudokuCase) e.getSource()).setText("");
            
        } else if ((masque & InputEvent.BUTTON1_MASK) != 0) {
        	
            if (_numeroGrille != null) {
            	
            	_numeroGrille.dispose();
            }
            
            _numeroGrille = new SelectionnerNumeroGrille(this);
            
            _numeroGrille.setModal(true);
            
            _numeroGrille.setLocation(e.getLocationOnScreen().x, e.getLocationOnScreen().y);
            
            _numeroGrille.setSudokuCase((SudokuCase) e.getSource());
            
            _numeroGrille.setVisible(true);
        }
    }
    
    public void mouseEntered(MouseEvent e) {}
    
    public void mouseClicked(MouseEvent e) {}
    
    public void mouseReleased(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    private boolean verrifierCase(int i, int j) {
    	
        if (_sudokuCases[i][j].getText().trim().isEmpty()) {
        	
            return false;
        }

        for (int x = 0; x < 9; x++) {
        	
            if (_sudokuCases[i][j].getText().trim().equals(_sudokuCases[i][x].getText().trim()) && j!=x) {
            	
                return false;
            }
            
            if (_sudokuCases[i][j].getText().trim().equals(_sudokuCases[x][j].getText().trim()) && i != x) {
            	
                return false;
            }
            
            int iSubMatrice = (i / 3) * 3 + x / 3;
            
            int jSubMatrice = (j / 3) * 3 + x % 3;
            
            if (_sudokuCases[i][j].getText().trim().equals(_sudokuCases[iSubMatrice][jSubMatrice].getText().trim()) &&!(i == iSubMatrice && j == jSubMatrice)) {
            	
                return false;
            }

        }
        
        return true;
    }

    public void montrerErreurs() {

        if (_plan != null) {
            int[][] resultat = _sudokuCore.chercherSolution(_plan);
            if (resultat != null) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!String.valueOf(resultat[i][j]).equals(_sudokuCases[i][j].getText()) && !_sudokuCases[i][j].getText().equals(" ")) {
                            _sudokuCases[i][j].setForeground(Color.red);
                        }
                    }
                }
            }

        }
    }

}
