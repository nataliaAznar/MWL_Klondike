package klondike;

import java.util.Stack;

public class MoveWasteToTableauController {
	private GameController startGameController;

	public MoveWasteToTableauController(GameController startGameController) {
		this.startGameController = startGameController;
	}

	public boolean move(int tableauNumber) {
		Stack<Card> tableau = startGameController.getTableau(tableauNumber);
		Card moveCard = startGameController.wasteCard();
		if( (tableau.size() == 0) && (moveCard.getNumber() == 12)){
			return moveCard(tableauNumber, moveCard);
		}
		else if(tableau.size() > 0){
			Card lastCard = tableau.peek();
			if((lastCard.getNumber()==(moveCard.getNumber()+1))&&(lastCard.getColor()!=moveCard.getColor())){
				return moveCard(tableauNumber, moveCard);
			}
		}
		return false;
	}
	
	public boolean moveCard(int tableau, Card card){
		startGameController.tableauAddCard(tableau, card);
		startGameController.wasteRemoveCard();
		return true;
	}

}
