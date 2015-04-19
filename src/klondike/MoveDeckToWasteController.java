package klondike;

public class MoveDeckToWasteController {
	private GameController startGameController;

	public MoveDeckToWasteController(GameController startGameController) {
		this.startGameController = startGameController;
	}

	public void move() {
		int sizeDeck = startGameController.sizeDeck();
		if( sizeDeck >= 3){
			startGameController.setSizeDeck(sizeDeck - 3);
			for( int i = 0; i < 3; i++)
				startGameController.wasteAddCard(new Card(1, Suit.CLUBS));
		}
		else if( sizeDeck > 0){
			startGameController.setSizeDeck(0);
			for( int i = 0; i < sizeDeck ; i++)
				startGameController.wasteAddCard(new Card(1, Suit.CLUBS));
		}
		
	}

}
