import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class mainScreen extends JFrame{
	
	
	private JButton reg;
		
	public mainScreen(){
		super("Knights & Dragons");
		setLayout(new FlowLayout());
		
		reg = new JButton("Enter");
		add(reg);
		
		Icon titleScreen = new ImageIcon(getClass().getResource("titleScreen.png"));
		
		HandlerClass handler = new HandlerClass();
		reg.addActionListener(handler);
	}
	private class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
		}
		
	}
	
}



