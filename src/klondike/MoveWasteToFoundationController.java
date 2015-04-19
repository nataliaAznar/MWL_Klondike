package klondike;

import java.util.Stack;

public class MoveWasteToFoundationController {
	private GameController gameController;

	public MoveWasteToFoundationController(
			GameController startGameController) {
		this.gameController = startGameController;
	}

	public boolean move(int foundationNum) {
		Card card = gameController.wasteCard();
		Stack<Card> foundation = gameController.getFoundation(foundationNum);
		if(foundation.size() > 0){
			Card lastCard = foundation.peek();
			if( (card.getNumber() == lastCard.getNumber() + 1) && (card.getSuit() == lastCard.getSuit())){
				gameController.foundationAddCard(foundationNum, card);
				gameController.wasteRemoveCard();
				return true;
			}
		}
		else if(card.getNumber() == 1){
			gameController.foundationAddCard(foundationNum, card);
			return true;
		}
		return false;
	}

}
