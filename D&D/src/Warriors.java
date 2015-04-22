import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Warriors extends JFrame{
	
	private JButton reg;// regular button
	private JButton custom;// custom button with our own images
	
	
	//this is the constructor//
	public Warriors(){
		super("Warrior Screen");//allows access to the super class
		setLayout(new FlowLayout());
		
		reg = new JButton("reg Button");
		add(reg);
		
		Icon knight = new ImageIcon(getClass().getResource("knight.jpg"));
		Icon wizard = new ImageIcon(getClass().getResource("iceDragon.jpg"));
		custom = new JButton("Custom", knight);
		custom.setRolloverIcon(wizard);
		add(custom);
		
		HandlerClass handler = new HandlerClass();
		reg.addActionListener(handler);
		custom.addActionListener(handler);
		//end of the constructor//
		
		}

	private class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
		}
	}
}
