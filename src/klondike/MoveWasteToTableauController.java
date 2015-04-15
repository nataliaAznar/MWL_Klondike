package klondike;

import java.util.Stack;

public class MoveWasteToTableauController {
	private StartGameController startGameController;

	public MoveWasteToTableauController(StartGameController startGameController) {
		this.startGameController = startGameController;
	}

	public boolean move(int foundationNumber) {
		Stack<Card> foundation = startGameController.getFoundation(foundationNumber);
		Card moveCard = startGameController.wasteCard();
		if( (foundation.size() == 0) && (moveCard.getNumber() == 12)){
			return moveCard(foundationNumber, moveCard);
		}
		else if(foundation.size() > 0){
			Card lastCard = foundation.peek();
			if((lastCard.getNumber()==(moveCard.getNumber()+1))&&(lastCard.getColor()!=moveCard.getColor())){
				return moveCard(foundationNumber, moveCard);
			}
		}
		return false;
	}
	
	public boolean moveCard(int foundation, Card card){
		startGameController.foundationAddCard(foundation, card);
		startGameController.wasteRemoveCard();
		return true;
	}

}
