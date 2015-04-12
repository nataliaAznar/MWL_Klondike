package klondike;

public class Card {
	private int number;
	
	public Card(int number){
		this.number = number;
	}

	public boolean uncovered() {
		return true;
	}

	public int getNumber() {
		return number;
	}

}
