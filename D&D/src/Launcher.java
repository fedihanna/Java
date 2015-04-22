import java.util.Random;
import javax.swing.JFrame;


public class Launcher {

	public static void main(String[] args) {
		
		
		Random dice = new Random();
		String number = null;
		System.out.println(number+ " ");
		
		mainScreen go1 = new mainScreen();
		go1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go1.setSize(500,500);
		go1.setVisible(true);
		
		Warriors go2 = new Warriors();
		go2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go2.setSize(500,500);
		go2.setVisible(true);
		
		Dragons go3 = new Dragons();
		go3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go3.setSize(500,500);
		go3.setVisible(true);
		
	}

}//end class
