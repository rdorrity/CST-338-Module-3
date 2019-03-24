/**
 * Module 3 - Cards
 * Simulates a deck of cards, player hands, and basic card operations such
 * as shuffling and dealing.
 * Cannot build a house of cards. We apologize for this lack of
 * advanced functionality.
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
    enum Suit {clubs, diamonds, hearts, spades}

   private Suit suit;
    private char value;
    private boolean errorFlag = true;

    /**
     * Default constructor for Card objects.
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
            return value + " of " + suit;
    }

    /**
     * Setter for Card objects.
     * @param value
     * @param suit
     * @return If no errors are raised, sets suit of Card object.
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
     * Getter for Suit values.
     * @return Suit of card
     */
    public Suit getSuit()
    {
        return suit;
    }

    /**
     * Getter for numerical card values.
     * @return Value of card as a char.
     */
    public char getValue()
    {
        return value;
    }

    /**
     * Getter for the Card object boolean var, errorFlag.
     * @return Status of error flag.
     */
    public boolean getFlag()
    {
        return errorFlag;
    }

    /**
     * Checks if a Card object is equal to another.
     * @param
     * @return True if Card objects are equal, false otherwise
     */
    public boolean equals(Card card)
    {
        return false;
    }

    /**
     * Checks if a Card object holds a valid suit and numeric value.
     * @param value
     * @param suit
     * @return True if Card object has valid parameters, false otherwise.
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

/**
 * Deck class
 * Incorporates Card objects. Interacts with Hand objects through card
 * distribution.
 */

class Deck
{
   // Class variables
   // Maximum number of 62 card decks
   public final int MAX_CARDS = 6 * 52;
   // Static array that holds 52 references to standard Card objects.
   private static Card [] masterPack;
   private Card [] cards;
   private int topCard;
   private int numPacks;

   /**
    * Default constructor for Deck objects.
    */
   public Deck()
   {

      for(int i = 0; i <= 52; i++)
      {
         masterPack[i] = new Card();
      }

      numPacks++;

   }

   /**
    * Overloaded constructor for Deck objects.
    * @param numPacks
    */
   public Deck(int numPacks)
   {
      this.numPacks = 1;
   }

   /**
    * Repopulates Card array with standard Card objects.
    * @param numPacks
    */
   public void init(int numPacks)
   {

   }

   /**
    * Allocates master pack. Checks if master pack is already initialized.
    */
   private static void allocateMasterPack()
   {

   }

   /**
    * Shuffles cards using a random number generator.
    */
   public void shuffle()
   {

   }

   /**
    * Deals Card object. Returns and removes Card object in top position of the
    * Card array.
    */
   public Card dealCard()
   {

   }

   /**
    * Getter for topCard
    * @return Value of top Card in deck
    */
   public int getTopCard()
   {
      return topCard;
   }

   /**
    * Getter for individual Card object. Returns a Card with errorFlag = true
    * if int i is invalid.
    * @param i
    * @return Individual Card object
    */
   public Card inspectCard(int i)
   {

   }
}