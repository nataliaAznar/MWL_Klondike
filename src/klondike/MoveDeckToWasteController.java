package klondike;

public class MoveDeckToWasteController {
	private StartGameController startGameController;

	public MoveDeckToWasteController(StartGameController startGameController) {
		this.startGameController = startGameController;
	}

	public void move() {
		int sizeDeck = startGameController.sizeDeck();
		int sizeWaste = startGameController.sizeWaste();
		startGameController.setSizeDeck(sizeDeck - 3);
		startGameController.setSizeWaste(sizeWaste + 3);
		
	}

}
