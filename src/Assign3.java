/**
 * Module 3 - Deck of Cards
 * Simulates a deck of cards, player hands, and basic card operations such
 * as shuffling and dealing.
 * Cannot build a house of cards. The authors apologize for this lack of
 * advanced functionality.
 *
 * @author Ryan Dorrity, Cody Young, Sara Kazemi, Nathan Warren-Acord - SCSI
 * Logic
 * @version 03/20/2019
 */

import java.util.*;

public class Assign3
{
    public static void main(String[] args)
    {
        /************
         * Unit Tests
         ************/

        // PHASE 1

        // Print out test Card objects
        System.out.println("~PHASE 1 TEST~");
        System.out.println("Card object test:\n");
        Card testA = new Card();
        Card testB = new Card('2', Card.Suit.clubs);
        Card testC = new Card('X', Card.Suit.hearts);
        System.out.println(testA);
        System.out.println(testB);
        System.out.println(testC);

        System.out.println("\nTesting set()");


        // set valid card to invalid card object
        testA.set('X', Card.Suit.diamonds);
        System.out.println(testC);

        // set Invalid card to valid card object
        testC.set('A', Card.Suit.hearts);
        System.out.println(testC);
        System.out.println("~END PHASE 1 TEST~\n\n");

        // END PHASE 1

        // PHASE 2
        System.out.println("~PHASE 2 TEST~");
        Card c = new Card();
        Hand h = new Hand();
        for(int index = 0; index < h.myCards.length; index+=3)
        {
            h.takeCard(testC);
            h.takeCard(testB);
            h.takeCard(c);

        }
        if(!h.takeCard(testA))
        {
            System.out.println("Hand full!");
        }
        System.out.println("After deal: ");
        System.out.println(h);

        System.out.println("\nTesting inspectCard()");
        System.out.println(h.inspectCard(99)); // illegal index
        for(int index = 0; index < h.myCards.length; index++)
        {
            System.out.println("Playing " + h.inspectCard(index));
        }

        System.out.println("~END PHASE 2 TEST~\n\n");
        // END PHASE 2 TEST

        // PHASE 3
        System.out.println("~PHASE 3 TEST~");
        // Create double pack deck and deal
        System.out.print("\n");
        System.out.println("Test double pack deck:\n");
        Deck testDeck = new Deck(2);
        System.out.println("**********DEAL UNSHUFFLED");
        for(int index = 0; index < 104; index++)
        {
            System.out.println("Dealing: "+ testDeck.dealCard());
        }

        // Shuffle deck, reprint
        testDeck.init(2);
        testDeck.shuffle();
        System.out.print("\n");
        System.out.println("Shuffled test deck:\n");
        System.out.print(testDeck);

        // Create Hand object, take Card object and verify correct Card is in
        //  Hand
        System.out.println("\nHand test\n");
        Hand h1 = new Hand();
        System.out.println("Hand created.");
        for (int i = 0; i < 5; i++)
        {
            h.takeCard(testDeck.dealCard());
            System.out.println("Playing card: " + h.playCard());
        }

        System.out.print('\n');
        Scanner userInput = new Scanner(System.in);

        int playerCount = 0;

        while (playerCount < 1 || playerCount > 10)
        {
            System.out.println("Please select the number of players (1 - 10):");
            playerCount = userInput.nextInt();
        }

        int[] playerNumbers = new int[playerCount];

        Deck deck = new Deck();
        int deckSize = 52;
        Hand[] players = new Hand[playerCount];

        for (int i = 0; i < players.length; i++)
        {
            players[i] = new Hand();
        }

        for (int i = 0; i < deckSize; i++)
        {
            players[i % playerCount].takeCard(deck.dealCard());
        }

        // Initialize playerNumbers array
        for (int i = 0; i < playerCount; i++)
        {
            playerNumbers[i] = i + 1;
        }

        // Unshuffled deck
        System.out.println("Printing hands from an unshuffled deck:\n");
        for (int i = 0; i < players.length; i++)
        {
            System.out.println("Player " + (i + 1) + " hand :\n" +
                    (players[i].toString() + ")\n"));
        }

        deck = new Deck();
        deck.shuffle();

        for (int i = 0; i < deckSize; i++)
        {
            players[i % playerCount].takeCard(deck.dealCard());
        }

        // Shuffled deck
        System.out.println("Printing hands from a shuffled deck:");

        for (int i = 0; i < players.length; i++)
        {
            System.out.println("Player " + playerNumbers[i] + " hand :\n" +
                    (players[i].toString() + ")\n"));
        }
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
    private char[] cardRank = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J',
            'Q', 'K'};

    enum Suit
    {
        clubs, diamonds, hearts, spades
    }

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
    }

    /**
     *
     * @param value
     * @param suit
     */
    public Card(char value, Suit suit)
    {
        errorFlag = set(value, suit);
    }

    /**
     *
     */
    public String toString()
    {
        if (errorFlag == true)
        {
            return "Invalid";
        } else
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
        } else
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
        if (this.value == card.value && this.suit == card.suit)
        {
            return true;
        } else
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
        if (k < myCards.length)
        {
            return myCards[k]; // return card if k is good
        }
        return new Card('X', Card.Suit.diamonds); // invalid card if k is bad

    }

    // Sets all values in myCards to null
    // Represents removing all cards from Hand
    public void resetHand()
    {
        for (int index = 0; index < myCards.length; index++)
        {
            myCards[index] = null;
        }

    }

    // Take a card only if we can fit it in the Hand and increase numCards
    // Return if successful or not (boolean)
    public boolean takeCard(Card card)
    {

        if (numCards < MAX_CARDS)
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
        Card result = new Card(myCards[numCards - 1].getValue(), myCards[numCards - 1].getSuit());
        myCards[numCards - 1] = null;
        numCards--;
        return result;
    }


    @Override
    public String toString()
    {
        String result = "( ";
        for (int index = 0; index < myCards.length; index++)
        {
            if (myCards[index] != null)
            {
                result += myCards[index] + ", ";
                if (index % 5 == 3)
                {
                    result += "\n";
                }
            }

        }
        result = result.substring(0, result.length() - 2) + " )";
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
    private static Card[] masterPack;
    private Card[] cards;
    private int topCard;

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
        cards = new Card[numPacks * 52];
        init(numPacks);
    }

    /**
     * Repopulates Card array with standard Card objects.
     * @param numPacks
     */
    public void init(int numPacks)
    {
        topCard = cards.length - 1;
        int cardIndex = 0;

        for (int initPacks = 0; initPacks < numPacks; initPacks++)
            for (int mpIndex = 0; mpIndex < 52; mpIndex++)
            {
                cards[cardIndex] = masterPack[mpIndex];
                cardIndex++;
            }

    }

    /**
     * Allocates master pack. Checks if master pack is already initialized. If
     * true, returns without doing anything.
     */
    private static void allocateMasterPack()
    {
        if (masterPack == null)
        {
            // Allocate and initialize array of Card objects
            // Variable to track Card object position in masterPack
            masterPack = new Card[52];
            int cardIndex = 0;

            // Initialize arrays of Card suits and values
            char values[] = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J',
                    'Q', 'K', 'A'};
            Card.Suit[] suits = {Card.Suit.clubs, Card.Suit.diamonds,
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
        Card temp = new Card();
        for (int index = 0; index < cards.length; index++)
        {
            int randomIndex = (int) (Math.random() * 51);
            temp = cards[index];
            cards[index] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    /**
     * Deals Card object. Returns and removes Card object in top position of the
     * Card array.
     */
    public Card dealCard()
    {
        Card dealtCard = new Card(inspectCard(topCard).getValue(), inspectCard(topCard).getSuit());

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
    public Card inspectCard(int k)
    {
        if(k < cards.length)
        {
            return cards[k];
        }
        return new Card('X', Card.Suit.diamonds); // invalid card
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

        for (int i = 0; i < cards.length; i++)
        {
            decksb.append(cards[i] + " " + "\n");
            cardTotal++;
        }

        System.out.print("Number of cards: " + cardTotal + "\n");
        deckString = decksb.toString();
        return deckString;
    }
}

/* TEST PHASE 1 - Card class
Card object test:

A of spades
2 of clubs
Invalid

Testing set()
Invalid
A of hearts
 */

//-------------------------------

/*
TEST PHASE 2 - Hand Class
Test run:
Hand full!
After deal:
Hand = ( Q of clubs, A of spades, K of diamonds, Q of clubs,
A of spades, K of diamonds, Q of clubs, A of spades, K of diamonds,
Q of clubs, A of spades, K of diamonds, Q of clubs, A of spades,
K of diamonds, Q of clubs, A of spades, K of diamonds, Q of clubs,
A of spades, K of diamonds, Q of clubs, A of spades, K of diamonds,
Q of clubs, A of spades, K of diamonds, Q of clubs, A of spades,
K of diamonds, Q of clubs, A of spades, K of diamonds, Q of clubs,
A of spades, K of diamonds, Q of clubs, A of spades, K of diamonds,
Q of clubs, A of spades, K of diamonds, Q of clubs, A of spades,
K of diamonds, Q of clubs, A of spades, K of diamonds, Q of clubs,
A of spades )
Testing inspectCard()
** invalid **
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
Playing K of diamonds
Playing Q of clubs
Playing A of spades
*/

//-------------------------------

/* TEST PHASE 3 - Deck Class
**********DEAL UNSHUFFLED
Dealing: 2 of spades
Dealing: 3 of spades
Dealing: 4 of spades
Dealing: 5 of spades
Dealing: 6 of spades
Dealing: 7 of spades
Dealing: 8 of spades
Dealing: 9 of spades
Dealing: T of spades
Dealing: J of spades
Dealing: Q of spades
Dealing: K of spades
Dealing: A of spades
Dealing: 2 of hearts
Dealing: 3 of hearts
Dealing: 4 of hearts
Dealing: 5 of hearts
Dealing: 6 of hearts
Dealing: 7 of hearts
Dealing: 8 of hearts
Dealing: 9 of hearts
Dealing: T of hearts
Dealing: J of hearts
Dealing: Q of hearts
Dealing: K of hearts
Dealing: A of hearts
Dealing: 2 of diamonds
Dealing: 3 of diamonds
Dealing: 4 of diamonds
Dealing: 5 of diamonds
Dealing: 6 of diamonds
Dealing: 7 of diamonds
Dealing: 8 of diamonds
Dealing: 9 of diamonds
Dealing: T of diamonds
Dealing: J of diamonds
Dealing: Q of diamonds
Dealing: K of diamonds
Dealing: A of diamonds
Dealing: 2 of clubs
Dealing: 3 of clubs
Dealing: 4 of clubs
Dealing: 5 of clubs
Dealing: 6 of clubs
Dealing: 7 of clubs
Dealing: 8 of clubs
Dealing: 9 of clubs
Dealing: T of clubs
Dealing: J of clubs
Dealing: Q of clubs
Dealing: K of clubs
Dealing: A of clubs
Dealing: 2 of spades
Dealing: 3 of spades
Dealing: 4 of spades
Dealing: 5 of spades
Dealing: 6 of spades
Dealing: 7 of spades
Dealing: 8 of spades
Dealing: 9 of spades
Dealing: T of spades
Dealing: J of spades
Dealing: Q of spades
Dealing: K of spades
Dealing: A of spades
Dealing: 2 of hearts
Dealing: 3 of hearts
Dealing: 4 of hearts
Dealing: 5 of hearts
Dealing: 6 of hearts
Dealing: 7 of hearts
Dealing: 8 of hearts
Dealing: 9 of hearts
Dealing: T of hearts
Dealing: J of hearts
Dealing: Q of hearts
Dealing: K of hearts
Dealing: A of hearts
Dealing: 2 of diamonds
Dealing: 3 of diamonds
Dealing: 4 of diamonds
Dealing: 5 of diamonds
Dealing: 6 of diamonds
Dealing: 7 of diamonds
Dealing: 8 of diamonds
Dealing: 9 of diamonds
Dealing: T of diamonds
Dealing: J of diamonds
Dealing: Q of diamonds
Dealing: K of diamonds
Dealing: A of diamonds
Dealing: 2 of clubs
Dealing: 3 of clubs
Dealing: 4 of clubs
Dealing: 5 of clubs
Dealing: 6 of clubs
Dealing: 7 of clubs
Dealing: 8 of clubs
Dealing: 9 of clubs
Dealing: T of clubs
Dealing: J of clubs
Dealing: Q of clubs
Dealing: K of clubs
Dealing: A of clubs
 Test invalid k: ** invalid **

**********SHUFFLING!!!!
Deck = ( T of hearts, Q of clubs, 7 of spades, 9 of hearts,
K of spades, 5 of diamonds, K of spades, 8 of hearts, 8 of clubs,
A of hearts, 4 of hearts, 4 of clubs, 4 of spades, A of spades,
7 of spades, J of spades, T of hearts, 3 of hearts, Q of spades,
T of clubs, Q of spades, K of hearts, K of clubs, 3 of spades,
J of hearts, A of clubs, T of spades, 7 of clubs, Q of hearts,
6 of spades, A of clubs, 5 of spades, T of spades, 7 of hearts,
A of hearts, K of diamonds, 8 of diamonds, 7 of hearts, 9 of hearts,
2 of spades, 2 of diamonds, 5 of clubs, 6 of hearts, T of diamonds,
7 of clubs, 5 of hearts, 3 of diamonds, 8 of diamonds, Q of diamonds,
3 of hearts, 2 of hearts, 9 of spades, 5 of diamonds, J of spades,
6 of spades, 6 of diamonds, 4 of clubs, Q of clubs, 2 of spades,
J of clubs, 9 of diamonds, Q of diamonds, 2 of clubs, K of clubs,
T of diamonds, 7 of diamonds, 4 of diamonds, A of diamonds, 8 of spades,
4 of hearts, A of diamonds, J of diamonds, J of clubs, A of spades,
8 of clubs, 3 of clubs, Q of hearts, T of clubs, 5 of spades,
J of diamonds, 3 of spades, 6 of clubs, 2 of hearts, 5 of clubs,
3 of diamonds, 6 of hearts, 4 of spades, 9 of diamonds, K of diamonds,
3 of clubs, 4 of diamonds, 9 of clubs, 9 of clubs, 2 of diamonds,
7 of diamonds, 8 of hearts, 2 of clubs, 6 of diamonds, J of hearts,
6 of clubs, K of hearts, 5 of hearts, 8 of spades, 9 of spades )

**********DEAL UNSHUFFLED
Dealing: 2 of spades
Dealing: 3 of spades
Dealing: 4 of spades
Dealing: 5 of spades
Dealing: 6 of spades
Dealing: 7 of spades
Dealing: 8 of spades
Dealing: 9 of spades
Dealing: T of spades
Dealing: J of spades
Dealing: Q of spades
Dealing: K of spades
Dealing: A of spades
Dealing: 2 of hearts
Dealing: 3 of hearts
Dealing: 4 of hearts
Dealing: 5 of hearts
Dealing: 6 of hearts
Dealing: 7 of hearts
Dealing: 8 of hearts
Dealing: 9 of hearts
Dealing: T of hearts
Dealing: J of hearts
Dealing: Q of hearts
Dealing: K of hearts
Dealing: A of hearts
Dealing: 2 of diamonds
Dealing: 3 of diamonds
Dealing: 4 of diamonds
Dealing: 5 of diamonds
Dealing: 6 of diamonds
Dealing: 7 of diamonds
Dealing: 8 of diamonds
Dealing: 9 of diamonds
Dealing: T of diamonds
Dealing: J of diamonds
Dealing: Q of diamonds
Dealing: K of diamonds
Dealing: A of diamonds
Dealing: 2 of clubs
Dealing: 3 of clubs
Dealing: 4 of clubs
Dealing: 5 of clubs
Dealing: 6 of clubs
Dealing: 7 of clubs
Dealing: 8 of clubs
Dealing: 9 of clubs
Dealing: T of clubs
Dealing: J of clubs
Dealing: Q of clubs
Dealing: K of clubs
Dealing: A of clubs
 Test invalid k: ** invalid **

**********SHUFFLING!!!!
Deck = ( 7 of hearts, 2 of hearts, 5 of spades, A of diamonds,
A of hearts, K of diamonds, T of diamonds, A of spades, 9 of clubs,
Q of clubs, 3 of diamonds, 9 of diamonds, K of clubs, 4 of diamonds,
J of clubs, 3 of spades, 7 of clubs, 3 of hearts, 2 of diamonds,
6 of hearts, 2 of spades, 9 of spades, J of spades, 8 of diamonds,
7 of diamonds, 6 of spades, T of hearts, 6 of diamonds, Q of hearts,
T of spades, J of diamonds, 4 of spades, Q of diamonds, 6 of clubs,
Q of spades, 2 of clubs, K of hearts, 5 of clubs, 5 of hearts,
8 of hearts, J of hearts, 4 of hearts, 5 of diamonds, 7 of spades,
9 of hearts, K of spades, A of clubs, T of clubs, 4 of clubs,
3 of clubs, 8 of spades, 8 of club )
 */

//-------------------------------

/* PHASE 4 TEST RUN - Putting Everything Together!
Please select the number of players (1 - 10):
5
Printing hands from an unshuffled deck:

Player 1 hand :
( A of spades, 9 of spades, 4 of spades, Q of hearts,
7 of hearts, 2 of hearts, T of diamonds, 5 of diamonds, K of clubs,
8 of clubs, 3 of clubs ))

Player 2 hand :
( K of spades, 8 of spades, 3 of spades, J of hearts,
6 of hearts, A of diamonds, 9 of diamonds, 4 of diamonds, Q of clubs,
7 of clubs, 2 of clubs ))

Player 3 hand :
( Q of spades, 7 of spades, 2 of spades, T of hearts,
5 of hearts, K of diamonds, 8 of diamonds, 3 of diamonds, J of clubs,
6 of clubs ))

Player 4 hand :
( J of spades, 6 of spades, A of hearts, 9 of hearts,
4 of hearts, Q of diamonds, 7 of diamonds, 2 of diamonds, T of clubs,
5 of clubs ))

Player 5 hand :
( T of spades, 5 of spades, K of hearts, 8 of hearts,
3 of hearts, J of diamonds, 6 of diamonds, A of clubs, 9 of clubs,
4 of clubs ))

Printing hands from a shuffled deck:
Player 1 hand :
( A of spades, 9 of spades, 4 of spades, Q of hearts,
7 of hearts, 2 of hearts, T of diamonds, 5 of diamonds, K of clubs,
8 of clubs, 3 of clubs, A of diamonds, 7 of spades, 7 of hearts,
6 of spades, 8 of clubs, J of spades, 9 of hearts, Q of diamonds,
J of clubs, 3 of hearts, T of clubs ))

Player 2 hand :
( K of spades, 8 of spades, 3 of spades, J of hearts,
6 of hearts, A of diamonds, 9 of diamonds, 4 of diamonds, Q of clubs,
7 of clubs, 2 of clubs, K of clubs, 3 of clubs, 3 of diamonds,
A of clubs, 2 of hearts, 2 of clubs, 8 of hearts, 4 of spades,
J of diamonds, T of diamonds, Q of spades ))

Player 3 hand :
( Q of spades, 7 of spades, 2 of spades, T of hearts,
5 of hearts, K of diamonds, 8 of diamonds, 3 of diamonds, J of clubs,
6 of clubs, 7 of diamonds, 2 of diamonds, 5 of hearts, A of hearts,
4 of clubs, 9 of spades, 7 of clubs, Q of hearts, 8 of diamonds,
9 of clubs ))

Player 4 hand :
( J of spades, 6 of spades, A of hearts, 9 of hearts,
4 of hearts, Q of diamonds, 7 of diamonds, 2 of diamonds, T of clubs,
5 of clubs, 3 of spades, K of diamonds, 6 of diamonds, 5 of spades,
T of spades, J of hearts, 5 of diamonds, 9 of diamonds, Q of clubs,
K of hearts ))

Player 5 hand :
( T of spades, 5 of spades, K of hearts, 8 of hearts,
3 of hearts, J of diamonds, 6 of diamonds, A of clubs, 9 of clubs,
4 of clubs, A of spades, T of hearts, 5 of clubs, 8 of spades,
2 of spades, 6 of clubs, 6 of hearts, 4 of diamonds, 4 of hearts,
K of spades ))

 */