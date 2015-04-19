package klondike;

public class MoveDeckToWasteController {
	private GameController gameController;

	public MoveDeckToWasteController(GameController startGameController) {
		this.gameController = startGameController;
	}

	public void move() {
		int sizeDeck = gameController.sizeDeck();
		if( sizeDeck >= 3){
			gameController.setSizeDeck(sizeDeck - 3);
			for( int i = 0; i < 3; i++)
				gameController.wasteAddCard(new Card(1, Suit.CLUBS));
		}
		else if( sizeDeck > 0){
			gameController.setSizeDeck(0);
			for( int i = 0; i < sizeDeck ; i++)
				gameController.wasteAddCard(new Card(1, Suit.CLUBS));
		}
		
	}

}
