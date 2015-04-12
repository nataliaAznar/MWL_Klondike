package klondike;

import java.util.Stack;

public class MoveWasteToFoundationController {
	private StartGameController startGameController;

	public MoveWasteToFoundationController(
			StartGameController startGameController) {
		this.startGameController = startGameController;
	}

	public boolean move(int foundationNum) {
		Card card = startGameController.wasteCard();
		Stack<Card> foundation = startGameController.getFoundation(foundationNum);
		if(foundation.size() > 0){
			Card lastCard = foundation.peek();
			if( (card.getNumber() == lastCard.getNumber() + 1) && (card.getSuit() == lastCard.getSuit())){
				startGameController.foundationAddCard(foundationNum, card);
				startGameController.wasteRemoveCard();
				return true;
			}
		}
		else if(card.getNumber() == 1){
			startGameController.foundationAddCard(foundationNum, card);
			return true;
		}
		return false;
	}

}
