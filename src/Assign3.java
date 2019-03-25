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

        // Print out test Deck object
       System.out.print("\n");
       System.out.println("Test deck 1:\n");
       Deck testDeck = new Deck();
       System.out.print(testDeck.toString());

       //Shuffle deck, reprint
      // testDeck.shuffle();
       System.out.print("\n");
       System.out.println("Shuffled testDeck:\n");
       System.out.print(testDeck.toString());

    }
}
/**
 * Card class
 * Defines Card objects, which have a suit and value.
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
        if (!errorFlag)
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

/** Hand class
 * Has cards (Stored in private instance variable myCards, an array of Cards
 * Represents a player's hand of cards
 */
class Hand
{
   public int MAX_CARDS = 50; // Max cards a Hand can have

   // private instance variables
   Card[] myCards;
   int numCards;

   // Zero argument constructor
   // Initalizes numCards to maximum length specified by MAX_CARDS
   // and initalizes numCards to 0 (empty hand)
   public Hand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }

   // Accessor methods

   // Returns myCard array reference
   public Card[] getMyCards()
   {
      return myCards;
   }

   // Returns number of cards
   public int getNumCards()
   {
      return numCards;
   }

   // Returns Card at index k in myCards
   public Card inspectCard(int k)
   {
      if(k < myCards.length)
      {
         return myCards[k]; // return card if k is good
      }
      return new Card('X', Card.Suit.diamonds); // invalid card if k is bad

   }

   // Sets all values in myCards to null
   // Represents removing all cards from Hand
   public void resetHand()
   {
      for(int index = 0; index < myCards.length; index++)
      {
         myCards[index] = null;
      }

   }

   // Take a card only if we can fit it in the Hand and increase numCards
   // Return if successful or not (boolean)
   public boolean takeCard(Card card)
   {

      if(numCards < MAX_CARDS)
      {
         myCards[numCards] = card;
         numCards++;
         return true;
      }
      return false;

   }

   // return and remove the Card last entered into the Hand
   public Card playCard()
   {
      return myCards[numCards--];
   }


   @Override
   public String toString()
   {
      String result = "Hand = ( ";
      for(int index = 0; index < myCards.length; index++)
      {
         if(myCards[index] != null)
         {
            result += myCards[index] + ", ";
            if (index % 5 == 3)
            {
               result += "\n";
            }
         }

      }
      result = result.substring(0, result.length()-2) + " )";
      return result;
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
   // Maximum number of 52 card decks
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
      this(1);
   }

   /**
    * Overloaded constructor for Deck objects. Sets number of packs by
    * default to 1.
    * @param numPacks
    */
   public Deck(int numPacks)
   {
      allocateMasterPack();
      this.numPacks = 1;
      init(numPacks);
      cards = new Card[numPacks * 52];
   }

   /**
    * Repopulates Card array with standard Card objects.
    * @param numPacks
    */
   public void init(int numPacks)
   {
      int cardIndex = 0;

      for (int initPacks = 0; initPacks < numPacks; initPacks++)
         for (int mpIndex = 0; mpIndex < 52; mpIndex++)
         {
            cards[cardIndex] = masterPack[mpIndex];
            cardIndex++;
         }
      topCard = cards.length - 1;
   }

   /**
    * Allocates master pack. Checks if master pack is already initialized. If
    * true, returns without doing anything.
    */
   private static void allocateMasterPack()
   {
      if (masterPack != null)
      {
         // Debug statement
         System.out.println("masterPack already exists.");
         return;
      }
      else
      {
         // Allocate and initialize array of Card objects
         // Variable to track Card object position in masterPack
         masterPack = new Card[52];
         int cardIndex = 0;

         // Initialize arrays of Card suits and values
         char values [] = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J',
                 'Q', 'K', 'A'};
         Card.Suit [] suits = {Card.Suit.clubs, Card.Suit.diamonds,
                 Card.Suit.hearts, Card.Suit.spades};

         for (Card.Suit suit : suits)

            for (char value : values)
            {
               masterPack[cardIndex] = new Card(value, suit);
               cardIndex++;
            }
      }
   }

   /**
    * Shuffles cards using a random number generator.
    */
   public void shuffle()
   {
      Card temp;

      // Number of swaps done in Card array
      int swaps = 8;

      for (int i = 0; i < swaps; i++)
      {
         // Create two random index values within bounds of array for swapping
         int tempIndex1 = (int)(Math.random() * 51);
         int tempIndex2 = (int)(Math.random() * 51);

         // Set cards at index values
         temp = cards[tempIndex1];
         cards[tempIndex1] = cards[tempIndex2];
         cards[tempIndex2] = temp;

      }
   }

   /**
    * Deals Card object. Returns and removes Card object in top position of the
    * Card array.
    */
   public Card dealCard()
   {
      Card dealtCard = cards[topCard];

      if (topCard >= 0)
      {
         cards[topCard] = null;
         topCard--;
      }

      return dealtCard;
   }

   /**
    * Getter for topCard.
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
    * @return Individual invalid Card object
    */
   public Card inspectCard(int i)
   {
      if (i < topCard)
      {
         return cards[i];
      }
      return new Card('E', Card.Suit.diamonds);
   }

   /**
    * Prints out Card objects stored in Deck object.
    * @return Contents of Deck object (Card objects)
    */
   @Override
   public String toString()
   {
      StringBuilder decksb = new StringBuilder();
      String deckString;
      // Debug only
      int cardTotal = 0;

      for (int i = 0; i <= cards.length; i++)
      {
         decksb.append(cards[i]);
         cardTotal++;
      }

      System.out.print("Number of cards: " + cardTotal);
      deckString = decksb.toString();
      return deckString;

   }
}