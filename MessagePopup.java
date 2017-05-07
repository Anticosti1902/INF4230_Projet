
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MessagePopup extends JDialog{

	public MessagePopup(String message){
		
		setSize(400, 150);
        
        setBackground(Color.WHITE);
        
        setTitle("TP3 Sudoku");
        
        JPanel panel = new JPanel();
        
        Font font = new Font("Times New Roman",2,20);
        
        JLabel label = new JLabel(message);
    	
        label.setFont(font);
        
        label.setBorder(BorderFactory.createEmptyBorder(25, 20, 0, 0));
        
        panel.add(label, BorderLayout.CENTER);

        this.getContentPane().add(panel);
	}
}
