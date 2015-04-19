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
	
	@Override
	public String toString() {
		return this.getNumber() + " of " + this.getSuit();
	}

	@Override
	public boolean equals(Object obj) {
		Card card = (Card) obj;
		return this.getNumber() == card.getNumber()&&this.getSuit().equals(card.getSuit());
	}
}
