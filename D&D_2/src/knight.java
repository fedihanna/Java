//inheritance method
public class knight extends characters
{
	private int hitPoints;
	private int strength;
	String weapon;
	
	//constructor method named for the knight object
	knight(String weapon, int hp, int st)
	{
		this.weapon = weapon;//'this" means the property of this class and not the method 
		this.hitPoints = hp;
		this.strength = st;
	}
	
	//overriding abstract methods
	@Override
	public  int getHitpoints()
	{
		return hitPoints;
	}
	
	@Override
	public  int getStrength() {
		return strength;
	}
	
	@Override
	public void setHitpoints(int hp) 
	{
		this.hitPoints = hp;
	}
	
	@Override
	public  void setStrength(int st) 
	{
		this.strength = st;
	}
}
