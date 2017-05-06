package Sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SelectionnerNiveauxPopup extends JDialog implements MouseListener {

	private SudokuGrille _sudokuGrille;
	
	private SudokuPlans _sudokuPlans;
	
	public SelectionnerNiveauxPopup(SudokuGrille sudokuGrille){
		
		_sudokuGrille = sudokuGrille;
		
		_sudokuPlans = new SudokuPlans();
		
		setSize(200, 500);
        
        setBackground(Color.WHITE);
        
        setTitle("TP3 Sudoku");
        
        JPanel panel = new JPanel();
        
        panel.setBorder(new TitledBorder("S¨¦lectionnez un niveau"));
        
        panel.setLayout(new GridLayout(9, 1));
        
        Font font = new Font("Times New Roman",2,20);
        
        for(int i = 1; i <= 9; i++){
        	
        	JLabel niveau = new JLabel("Niveau " + i);
        	
            niveau.setFont(font);
            
            niveau.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
            
            niveau.addMouseListener(this);
            
            panel.add(niveau);
        }

        this.getContentPane().add(panel);
        
	}
	
	public void mousePressed(MouseEvent e) {
    	
        int masque = e.getModifiers();
        
        if ((masque & InputEvent.BUTTON1_MASK) != 0) {
        	
        	JLabel label = (JLabel) e.getSource();
            
            String labelName = label.getText();
            
            int[][] planSelectionne = _sudokuPlans.get(labelName);
            
            if(planSelectionne != null){
            	
            	_sudokuGrille.setPlan(planSelectionne);
            	
            	_sudokuGrille.deactiveSudokuCases();
                
                _sudokuGrille.chargerData();
            }
        }
        
        this.setVisible(false);
    }
    
    public void mouseEntered(MouseEvent e) {}
    
    public void mouseClicked(MouseEvent e) {}
    
    public void mouseReleased(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
}
