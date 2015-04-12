package klondike;

public class Card {
	private int number;
	private Suit suit;
	
	public Card(int number, Suit suit){
		this.number = number;
		this.suit = suit;
	}

	public boolean uncovered() {
		return true;
	}

	public int getNumber() {
		return number;
	}

	public Suit getSuit() {
		return suit;
	}

}
