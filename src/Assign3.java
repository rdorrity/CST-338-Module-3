
/**
 * 
 * @author Ryan Dorrity, Cody Young, Sara Kazemi, Nathan Warren-Acord
 * @version 03/20/2019
 */
public class Assign3 
{
    
    public static void main(String[] args)
    {
        Card testA = new Card();
        Card testB = new Card('2', Card.Suit.clubs);
        Card testC = new Card('0', Card.Suit.hearts);
        
        System.out.println(testA.toString());
        System.out.println(testB.toString());
        System.out.println(testC.toString());
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
    
    /**
     * 
     */
    public Card()
    {
        value = 'A';
        suit = Suit.spades;
    }
    
    /**
     * 
     * @param value
     * @param suit
     */
    public Card(char value, Suit suit)
    {
        this.value = value;
        this.suit = suit;
    }
    
    /**
     * 
     */
    public String toString()
    {
        return Character.toString(value) + " of " + suit;
    }
    
    /**
     * 
     * @param value
     * @param suit
     * @return
     */
    boolean set(char value, Suit suit)
    {
    	return false;
    }
    
    /**
     * 
     * @return
     */
    public Suit getSuit()
    {
    	return suit;
    }
    
    /**
     * 
     * @return
     */
    public char getValue()
    {
    	return value;
    }
    
    /**
     * 
     * @return
     */
    public boolean getFlag()
    {
    	return errorFlag;
    }
    
    /**
     * 
     * @param card
     * @return
     */
    public boolean equals(Card card)
    {
    	return false;    	
    }
    
    /**
     * 
     * @param value
     * @param suit
     * @return
     */
    private boolean isValid(char value, Suit suit)    
    {
    	if (suit.equals(this.suit))
    	{
    		System.out.println("True");
    	}
    	return false;
    }
}
