
/**
 * 
 * @author Ryan Dorrity, Cody Young, Sara Kazemi, Nathan Warren-Acord
 * @version 03/20/2019
 */
public class Assign3 
{
	
	public static void main(String[] args)
	{
		
	}
	
}
/**
 * 
 * @author Ryan Dorrity, Cody Young, Sara Kazemi, Nathan Warren-Acord
 * @version 03/20/2019
 */
class Card 
{	
	enum Suit {clubs, diamonds, hearts, spades};
	Suit suit;
	char value;
	boolean errorFlag;
	
	public Card()
	{
		value = 'A';
		suit = Suit.spades;
	}
	public Card(char value, Suit suit)
	{
		this.value = value;
		this.suit = suit;
	}
}
