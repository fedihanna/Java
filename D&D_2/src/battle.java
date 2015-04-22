import java.sql.Time;
import java.util.Random;

public class battle 
{
	String knightWeapon;
	String dragonWeapon;
	boolean knightWins = false;//Signifying that if knight wins, the game is over
	boolean dragonWins = false;//Signifying that if dragon wins, the game is over
	
	knight kng = new knight("", 0,0);//constructor method requires this may arguments at 0,0 because it needs to be accessed
	dragon drg = new dragon("", 0,0);//constructor method requires this may arguments at 0,0 because it needs to be accessed
	
	//setting the dice roller
	private int diceRoller()
	{
		Random dice = new Random();
		return dice.nextInt(6) + 1;
	}


	//knight takes his turn
	public String knightTurn()
	{
		//formula for battle
		int variable = diceRoller();//variable is the dice roller
		drg.setHitpoints(drg.getHitpoints() - kng.getStrength() * variable);
		

		if(drg.getHitpoints() <= 0)
		{
			this.knightWins = true;
			newGame();
			return "Dragon is dead KNIGHT WINS !!!\n";
			
		}
		return "Knight rolled " + variable + "!!\nDamage multiplier is " + variable + "!!\n"
				+ "knight did " + kng.getStrength() * variable + " Damage  with " + kng.weapon +"!!! \n" +
						"Dragon's remaining hp is " + drg.getHitpoints() +".\n\n";
		
		}
	
	
	//dragon takes his turn
	public String dragonTurn()
	{
		
		//formula for battle
		int variable = diceRoller();//variable is the dice roller
		kng.setHitpoints(kng.getHitpoints() - drg.getStrength() * variable);
		
		
		if(kng.getHitpoints() <= 0)
		{
			dragonWins = true;
			newGame();
			return "Knight is dead DRAGON WINS !!!\n";
			
		}
		
		return "Dragon rolled " + variable + "!!\nDamage multiplier is " + variable + "!!\n"
				+ "dragon did " + drg.getStrength() * variable + "  Damage  with " + drg.weapon +"!!! \n" +
						"Knight's remaining hp is " + kng.getHitpoints() +".\n\n";
		
		
		
	}
	
	

	//before the battle, we need to refer to this strings
	public void newGame()
	{
		//constructing a new knight and new dragon for our battle
		this.kng = new knight(knightWeapon, 1000,30);//setting the strength and hit points for knight
		this.drg = new dragon(dragonWeapon, 1000,30);//setting the strength and hit points for dragon
	
	}

	
}