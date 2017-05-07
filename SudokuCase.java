
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class SudokuCase extends JButton {
	
	public SudokuCase(){
		
		setSize(50,50);
		
		Font font = new Font("Times New Roman",1,25);
		
		setFont(font);
		
		setBackground(Color.WHITE);
		
		setForeground(Color.BLUE);
		
		setText(" ");
		
		setEnabled(false);
	}

}
