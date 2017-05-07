
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class SelectionnerNumeroGrille extends JDialog implements MouseListener {

	private SudokuGrille _sudokuGrille;
	
	private SudokuCase _sudokuCase;
	
	private final int _tailleBoutton = 60;
	
	public SelectionnerNumeroGrille(SudokuGrille sudokuGrille){
		
		_sudokuGrille = sudokuGrille;
		
        setSize(_tailleBoutton*3, _tailleBoutton*3);
        
        setBackground(Color.WHITE);
        
        setUndecorated(true);
        
        setLayout(null);
        
        remplirGrille();
    }

    public void setSudokuCase(SudokuCase sudokuCase) {
    	
    	_sudokuCase = sudokuCase;
    	
    }
    
    public void mousePressed(MouseEvent e) {
    	
        int masque = e.getModifiers();
        
        if ((masque & InputEvent.BUTTON1_MASK) != 0) {
        	
            JButton boutton = (JButton) e.getSource();
            
            String contenu = boutton.getText();
            
            _sudokuCase.setText(contenu);
            
            _sudokuCase.setForeground(Color.BLUE);
            
        }
        
        this.dispose();
        
        _sudokuGrille.verifierTermination();
    }
    
    public void mouseEntered(MouseEvent e) {}
    
    public void mouseClicked(MouseEvent e) {}
    
    public void mouseReleased(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    private void remplirGrille() {
    	
        for (int i = 0; i < 3; i++) {
        	
            for (int j = 0; j < 3; j++) {
            	
                JButton boutton = new JButton();
                
                boutton.setSize(_tailleBoutton, _tailleBoutton);
                
                boutton.setText((j*3 + i + 1) + "");
                
                boutton.setLocation(i*_tailleBoutton, j*_tailleBoutton);
                
                boutton.addMouseListener(this);
                
                boutton.setBackground(new Color(255, 255, 230));
                
                Font font = new Font("Times New Roman",2,25);
                
                boutton.setFont(font);
                
                boutton.setForeground(Color.BLACK);
                
                this.add(boutton);
            }
        }

    }
}
