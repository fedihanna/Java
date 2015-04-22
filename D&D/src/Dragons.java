import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Dragons extends JFrame{
	
	private JButton reg;// regular button
	private JButton custom;// custom button with our own images
	
	
	//this is the constructor//
	public Dragons(){
		super("Dragon Screen");//allows access to the super class
		setLayout(new FlowLayout());
		
		reg = new JButton("reg Button");
		add(reg);
		
		Icon fireDragon= new ImageIcon(getClass().getResource("fireDragon.jpg"));
		Icon iceDragon = new ImageIcon(getClass().getResource("iceDragon.jpg"));
		custom = new JButton("Custom", fireDragon);
		custom.setRolloverIcon(iceDragon);
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
