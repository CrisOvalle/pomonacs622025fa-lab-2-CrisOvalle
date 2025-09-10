package flippy;

/**
 * Keeps track of the cards and and answers questions
 * for the flippy card game.
 * 
 * Red cards (hearts and diamonds) award positive points, while black cards
 * (clubs and spades) award negative points. Cards 2-10 have points worth
 * their face value, Jack, Queen and King 10 and Ace 11.
 * 
 * @author Cris Ovalle
 *
 */
public class FlippyCards {
	private Card[] cards; // the cards for the game

	/**
	 * Create a new flippy card game state, which consists of the
	 * numCards cards for the game.
	 * 
	 * @param numCards number of cards in the game
	 */

	int numCards = 0;

	public FlippyCards(int n) {
		// Creates a new CardDealer object to create the cards needed to play
		CardDealer dealer = new CardDealer(1);

		numCards = n;
		cards = new Card[numCards];

		// assigns cards from CardDealer to the player's hand
		for (int i = 0; i < numCards; i++) {
			cards[i] = dealer.next();
		}

	}

	/**
	 * Returns the flippy card at the given index
	 * 
	 * @return the flippy card at the given index
	 */
	public Card getCard(int index) {
		// TODO: Fill in good stuff here!
		return cards[index];
	}

	/**
	 * Flip the card over at this index. Card indices
	 * start at 0 and go up the cards.length-1
	 * 
	 * @param cardIndex the index of the card to flip over
	 */
	public void flipCard(int cardIndex) {
		cards[cardIndex].flip();
		// TODO: Fill in good stuff here!
	}

	/**
	 * Calculate the best possible score for the
	 * current cards.
	 * 
	 * @return the optimal score
	 */
	public int calculateOptimalScore() {
		// TODO: Fill in good stuff here!
		// Loops thorugh the player's hand and only adds the score of red cards
		int bestScore = 0;
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getSuit().equals("hearts") || cards[i].getSuit().equals("diamonds")) {
				bestScore += cards[i].getFlippyCardValue();
			}
		}
		return bestScore;
	}

	/**
	 * Calculate the flippy card score for the cards that are
	 * face up.
	 * 
	 * @return the flippy card score for faceup cards
	 */
	public int faceUpTotal() {
		// TODO: Fill in good stuff here!
		// loops through the hand and checks for all the face up cards
		// and adds and subtracts form score depending on suit type
		int score = 0;
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].isFaceUp()) {
				if (cards[i].getSuit().equals("hearts") || cards[i].getSuit().equals("diamonds")) {
					score += cards[i].getFlippyCardValue();
				} else {
					score -= cards[i].getFlippyCardValue();
				}
			}
		}
		return score;
	}

	/**
	 * Calculate the flippy card score for the cards that are
	 * face down.
	 * 
	 * @return the flippy card score for facedown cards
	 */
	public int faceDownTotal() {
		// TODO: Fill in good stuff here!
		// loops through the hand and checks for all the face down cards
		// and adds and subtracts form score depending on suit type
		int score = 0;
		for (int i = 0; i < cards.length; i++) {
			if (!cards[i].isFaceUp()) {
				if (cards[i].getSuit().equals("hearts") || cards[i].getSuit().equals("diamonds")) {
					score += cards[i].getFlippyCardValue();
				} else {
					score -= cards[i].getFlippyCardValue();
				}
			}
		}
		return score;
	}

	// TODO: Add a toString method here!
	public String toString() {
		// loops through the hand and if the card is face up, prints the value and suit
		// if the card is face down, prints "FACE-DOWN", and adds spacing bars "|"
		String result = "";
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].isFaceUp()) {
				result += cards[i].toString();
			} else {
				result += "FACE-DOWN";
			}

			if (i != cards.length - 1) {
				result += " | ";
			}
		}
		return result;
	}
}
