


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class MainFrame extends JFrame 
{
	// The "battleClass" variable is giving us access to the methods in out "battle" class. 
	// Example: "public int diceRoller()"
	battle battleClass = new battle();


	//arrays for an list of knight and dragon weapons
	private static String[] knightWeap = {"sword", "axe"};
	private static String[] dragWeap = {"throwCrystals", "breathesFire"};

	//2 arrays to show images of weapons being selected for the knight and dragon
	private Icon[] pics = {new ImageIcon(getClass().getResource(knightWeap[0]+".jpg")), 
			new ImageIcon(getClass().getResource(knightWeap[1]+".jpg"))};

	private Icon[] dragPics = {new ImageIcon(getClass().getResource(dragWeap[0]+".jpg")), 
			new ImageIcon(getClass().getResource(dragWeap[1]+".jpg"))};

	//the 4 panels in our game being declared each time ???????????
	private JPanel contentPane;
	JPanel panel_dragon = new JPanel();//declaring panel
	final JPanel panel_knight = new JPanel();//""
	JPanel panel_battle = new JPanel();//""
	JTextArea txt_BA = new JTextArea();//""
	final JButton btn_rollDice = new JButton("ROLL DICE");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//entrance screen
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Knights & Dragons");


		//the intro panel can't be edited
		final JPanel pannel_Intro = new JPanel();
		pannel_Intro.setBounds(5, 5, 424, 252);
		contentPane.add(pannel_Intro);
		pannel_Intro.setLayout(null);

		//once user presses the ENTER button on the intro screen, it takes him to the knight 
		JButton btn_enter = new JButton("ENTER");
		btn_enter.addActionListener(new ActionListener() {//waiting for the user to do something
			public void actionPerformed(ActionEvent arg0) {//returns the action of the button when pressed
				pannel_Intro.setVisible(false);//thus making the intro screen close 
				panel_knight.setVisible(true);//and the knight screen will open
				setTitle("Knight Armory");
			}
		});
		btn_enter.setBounds(116, 218, 89, 23);
		pannel_Intro.add(btn_enter);



		//close the main screen when exit is pressed, thus closing the whole game
		JButton btn_exit = new JButton("EXIT");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//when you push EXIT, screen closes
			}
		});
		btn_exit.setBounds(215, 218, 89, 23);
		pannel_Intro.add(btn_exit);

		//on our main screen, this is the way I designed the font and display
		JLabel lbl_title = new JLabel("Knights & Dragons \r\nBy: Fedi Hanna\r\n");
		lbl_title.setFont(new Font("Impact", Font.PLAIN, 25));
		lbl_title.setVerticalAlignment(SwingConstants.TOP);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setBounds(10, 95, 404, 112);
		pannel_Intro.add(lbl_title);

		JLabel lbl_titleScreenImage = new JLabel(new ImageIcon(getClass().getResource("titleScreen.jpg")));
		lbl_titleScreenImage.setBounds(0, 0, 424, 252);
		pannel_Intro.add(lbl_titleScreenImage);

		//dims for our knight panel
		panel_knight.setBounds(5, 5, 424, 252);
		contentPane.add(panel_knight);
		panel_knight.setLayout(null);
		panel_knight.setVisible(false);// set o false because we don't want it opening
                                        //until enter button is pressed on intro screen.
		
		//dims for our knight image on the knight panel
		JLabel lbl_knPic = new JLabel(new ImageIcon(getClass().getResource("knight.jpg")));
		lbl_knPic.setBounds(42, 11, 100, 77);
		lbl_knPic.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_knight.add(lbl_knPic);

		//display pictures for our knights weapons
		final JLabel lbl_wepImage = new JLabel(pics[0]);
		lbl_wepImage.setBounds(152, 24, 100, 99);
		panel_knight.add(lbl_wepImage);

		//weapon combo box that lets user choose weapon for the knight
		final JComboBox weapBox = new JComboBox(knightWeap);//array of the images that display when we select
		weapBox.setBounds(42, 99, 100, 20);
		panel_knight.add(weapBox);

		//Exit button for the knight panel, press it and kills the game
		JButton btn_exitKnight = new JButton("EXIT");
		btn_exitKnight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_exitKnight.setBounds(202, 218, 89, 23);
		panel_knight.add(btn_exitKnight);

		//NEXT button on the knight panel, press it and user goes to the dragon panel
		JButton btn_toDragon = new JButton("NEXT");
		btn_toDragon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_knight.setVisible(false);
				panel_dragon.setVisible(true);

				//this puts the weapon into the battle class for the knight
				battleClass.knightWeapon = (String) weapBox.getSelectedItem();
				setTitle("Dragon Armory");
			}
		});
		btn_toDragon.setBounds(103, 218, 89, 23);
		panel_knight.add(btn_toDragon);

		//we need to add functions...add an itemListener
		weapBox.addItemListener(
				new ItemListener(){
					//allows us to change the pic
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange()==ItemEvent.SELECTED)
							lbl_wepImage.setIcon(pics[weapBox.getSelectedIndex()]);

					}
				}
				);

		//dims for the dragon panel
		panel_dragon.setBounds(5, 5, 424, 252);
		contentPane.add(panel_dragon);
		panel_dragon.setLayout(null);
		panel_dragon.setVisible(false);

		//dims for the picture of the dragon in the dragon panel
		JLabel lbl_dragPic = new JLabel(new ImageIcon(getClass().getResource("iceDragon.jpg")));
		lbl_dragPic.setBounds(42, 11, 100, 77);
		lbl_dragPic.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_dragon.add(lbl_dragPic);

		//label for the pictures of the dragon weapons
		final JLabel lbl_dragWeap = new JLabel(dragPics[0]);
		lbl_dragWeap.setBounds(152, 24, 100, 99);
		panel_dragon.add(lbl_dragWeap);

		//combo box to let us choose which weapon the dragon is going to use
		final JComboBox drag_weapList = new JComboBox(dragWeap);
		drag_weapList.setBounds(42, 99, 100, 20);
		panel_dragon.add(drag_weapList);


		//we need to add functions...add an itemListener
		drag_weapList.addItemListener(
				new ItemListener(){
					//allows us to change the pic
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange()==ItemEvent.SELECTED)
							lbl_dragWeap.setIcon(dragPics[drag_weapList.getSelectedIndex()]);

					}
				}
				);

		//Dragon panel EXIT button
		JButton btn_exitDragon = new JButton("EXIT");
		btn_exitDragon.setBounds(272, 218, 89, 23);
		panel_dragon.add(btn_exitDragon);
		btn_exitDragon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);//when you push EXIT, screen closes
			}

		});

		//Dragon panel NEXT button which takes you to the BATTLE TO DEATH SCREEN
		JButton btn_toBattle = new JButton("NEXT");
		btn_toBattle.setBounds(163, 218, 89, 23);
		panel_dragon.add(btn_toBattle);
		btn_toBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("BATTLE TO THE DEATH");

				//this puts the weapon into the battle class for the dragon
				battleClass.dragonWeapon = (String) drag_weapList.getSelectedItem();

				battleClass.newGame();//calling the newGame method in battle class
				panel_dragon.setVisible(false);//when NEXT button is pushed, dragon screen closes
				panel_battle.setVisible(true);//BATTLE TO DEATH screen will show 
			}

		});

		//Dragon panel BACK button
		JButton btn_backToKnight = new JButton("BACK");
		btn_backToKnight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_dragon.setVisible(false);//when back is pressed, dragon screen will not show
				panel_knight.setVisible(true);//knight screen will show
			}
		});
		btn_backToKnight.setBounds(53, 218, 89, 23);
		panel_dragon.add(btn_backToKnight);

		//setting the dimensions for the Battle panel
		panel_battle.setBounds(5, 5, 424, 252);
		contentPane.add(panel_battle);
		panel_battle.setLayout(null);
		panel_battle.setVisible(false);

		//Battle panel knight pic dims
		JLabel lbl_KnightBA = new JLabel(new ImageIcon(getClass().getResource("knight.jpg")));
		lbl_KnightBA.setBounds(10, 0, 100, 100);
		panel_battle.add(lbl_KnightBA);

		//battle panel dragon pic dims
		JLabel lbl_DragonBA = new JLabel(new ImageIcon(getClass().getResource("iceDragon.jpg")));
		lbl_DragonBA.setBounds(314, 0, 100, 100);
		panel_battle.add(lbl_DragonBA);

		//ROLL DICE button on the battle panel
		btn_rollDice.setBounds(147, 41, 143, 23);
		btn_rollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_rollDice.setEnabled(false);
				setBattlePanelText();
			}
		});
		panel_battle.add(btn_rollDice);

		//Scroll pane for both fighters actions, when the text area fills up we must be able to scroll down.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 404, 130);
		panel_battle.add(scrollPane);
		txt_BA.setFont(new Font("Monospaced", Font.PLAIN, 11));

		//we don't want our text area to be editable
		txt_BA.setEditable(false);
		scrollPane.setViewportView(txt_BA);

	}

	//this method writes the turn's information to the text area.
	public void setBattlePanelText()
	{

		final Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){ //its final, it can't be altered
			public void run()
			{	
				txt_BA.append(battleClass.knightTurn());//knight takes his turn 
				txt_BA.setCaretPosition(txt_BA.getDocument().getLength()-2);//scrolls down the text area to show what was written
				try {
					Thread.sleep(2000);//pauses for 2000 milliseconds
				} catch (InterruptedException e) {// try catch so program will not corrupt
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(battleClass.knightWins != true)//!= means not true, so if the dragon is still alive it goes to next line
				{
					txt_BA.append(battleClass.dragonTurn());//dragon will take his turn
					txt_BA.setCaretPosition(txt_BA.getDocument().getLength()-2);//scrolls down text area to show what was written
	
				}
				if(battleClass.knightWins == true || battleClass.dragonWins == true)
					//if knight or dragon is dead, execute this following code
				{
				
				battleClass.knightWins = false;//if knights wins stop the game by the IF statement
				                               //in our battle class in the dragons turn.
				battleClass.dragonWins = false;
				btn_rollDice.setEnabled(true);//until the game is over we can't click the ROLL DICE button again
				timer.cancel();//tells the timer that when the game is over to stop the timer.
				}
			}
		}, 1, 4000);//time it takes for both players to take turns.
		
		


	}
}