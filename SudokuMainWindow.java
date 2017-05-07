
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SudokuMainWindow extends JFrame {
	
	private SudokuGrille _sudokuGrille;
	
	private SelectionnerNiveauxPopup _selectionnerNiveauxPopup;

    public SudokuMainWindow() {
        
    	setSize(515, 600);
        
        setLocation(500, 50);
        
        setTitle("TP3 Sudoku");
        
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        _sudokuGrille = new SudokuGrille();
        
        _sudokuGrille.setBorder(new TitledBorder("Sudoku"));

        this.add(_sudokuGrille, BorderLayout.CENTER);
        
        _selectionnerNiveauxPopup = new SelectionnerNiveauxPopup(_sudokuGrille);
        
        
        JPanel commandePanel = new JPanel();
        
        
        JButton selectNiveauxBtn = new JButton();
        
        selectNiveauxBtn.setSize(300, 100);
        
        selectNiveauxBtn.setText("Selectionner Niveau");
        
        selectNiveauxBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	
            	selectNiveaux();
            }
        });
        
        
        JButton recommencerBtn = new JButton();
        
        recommencerBtn.setSize(300, 100);
        
        recommencerBtn.setText("Recommencer");
        
        recommencerBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	
            	recommencer();
            }
        });
        
        
        JButton afficherSolutionBtn = new JButton();
        
        afficherSolutionBtn.setSize(300, 100);
        
        afficherSolutionBtn.setText("Afficher Solution");
        
        afficherSolutionBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	
            	afficherSolution();
            }
        });
        
        
        commandePanel.add(selectNiveauxBtn, BorderLayout.WEST);
        
        commandePanel.add(recommencerBtn, BorderLayout.CENTER);
        
        commandePanel.add(afficherSolutionBtn, BorderLayout.EAST);
        
        
        this.add(commandePanel, BorderLayout.NORTH);

    }
    
    private void selectNiveaux(){
    	
    	_selectionnerNiveauxPopup.setModal(true);
        
    	_selectionnerNiveauxPopup.setLocation(this.getLocationOnScreen().x, this.getLocationOnScreen().y);
        
    	_selectionnerNiveauxPopup.setVisible(true);
    }
    
    private void recommencer(){
    	
    	_sudokuGrille.deactiveSudokuCases();
    	
    	_sudokuGrille.chargerData();
    }
    
    private void afficherSolution(){
    	
    	_sudokuGrille.deactiveSudokuCases();
    	
    	_sudokuGrille.afficherSolution();
    }

}
