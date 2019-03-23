
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
        //System.out.println(testA.toString());
        Card testB = new Card('2', Card.Suit.clubs);
        //System.out.println(testB.toString());
        Card testC = new Card('0', Card.Suit.hearts);
        //System.out.println(testC.toString());
        testC.set('3', Card.Suit.diamonds);
        System.out.println(testC.toString());
        testA.set('0', Card.Suit.hearts);
        System.out.println(testA.toString());
    }
}
/**
 *
 * @author Ryan Dorrity, Cody Young, Sara Kazemi, Nathan Warren-Acord
 * @version 03/20/2019
 */
class Card
{
    private char[] cardRank = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J',
            'Q', 'K'};
    enum Suit {clubs, diamonds, hearts, spades};
    private Suit suit;
    private char value;
    private boolean errorFlag = true;

    /**
     *
     */
    public Card()
    {
        value = 'A';
        suit = Suit.spades;
        errorFlag = isValid('A', Suit.spades);
        System.out.println(toString());
    }

    /**
     *
     * @param value
     * @param suit
     */
    public Card(char value, Suit suit)
    {
        errorFlag = set(value, suit);
        System.out.println(toString());
    }

    /**
     *
     */
    public String toString()
    {
        if (errorFlag == true)
        {
            return "Invalid";
        }
        else
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
        errorFlag = isValid(value, suit);
        if (errorFlag == false)
        {
            this.value = value;
            this.suit = suit;
            return errorFlag;
        }
        else
            this.suit = suit;
        return errorFlag;
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
        for (int i = 0; i < cardRank.length; i++)
        {
            if (cardRank[i] == value)
            {
                //System.out.println("Valid");
                return false;
            }
        }
        //System.out.println("Invalid");
        return true;
    }
}
class Hand
{
    public int MAX_CARDS = 50;
    Card[] myCards;
    int numCards;

    public Hand()
    {

    }

    void resetHand()
    {

    }

    boolean takeCard(Card card)
    {
        return true;
    }

    Card playCard()
    {
        return myCards[0];
    }

    public String toString()
    {
        return "string";
    }

    public int getNumCards()
    {
        return numCards;
    }

    Card InspectCard(int k)
    {
        return myCards[k];
    }
}