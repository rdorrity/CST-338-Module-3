
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
        return "string";
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
    
    public char getValue()
    {
    	return value;
    }
}
