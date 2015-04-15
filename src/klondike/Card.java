package klondike;

public class Card {
	private int number;
	private Suit suit;
	private Color color;
	
	public Card(int number, Suit suit){
		this.number = number;
		this.suit = suit;
		if( (suit == Suit.SPADES) || (suit == Suit.CLUBS))
			this.color = Color.BLACK;
		else
			this.color = Color.RED;
	}

	public boolean uncovered() {
		return true;
	}

	public int getNumber() {
		return this.number;
	}

	public Suit getSuit() {
		return this.suit;
	}

	public Color getColor() {
		return this.color;
	}

}
