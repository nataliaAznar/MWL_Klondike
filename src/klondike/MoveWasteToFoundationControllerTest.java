package klondike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveWasteToFoundationControllerTest {
	private MoveWasteToFoundationController moveWasteToFoundationController;
	private StartGameController startGameController;
	private static final int FOUNDATION = 1;
	
	@Before
	public void before(){
		startGameController = new StartGameController();
		moveWasteToFoundationController = new MoveWasteToFoundationController(startGameController);
	}
	
	@Test
	public void moveFoundationSizeZeroTest(){
		startGameController.wasteAddCard(new Card(1, Suit.CLUBS));
		Card card = startGameController.wasteCard();
		boolean move = moveWasteToFoundationController.move(FOUNDATION);
		if((card.getNumber() == 1) )
			assertTrue(move);
		else
			assertFalse(move);
	}
	
	@Test
	public void moveTest(){
		startGameController.wasteAddCard(new Card(2, Suit.CLUBS));
		startGameController.foundationAddCard(FOUNDATION, new Card(1, Suit.CLUBS));
		Stack<Card> foundation = startGameController.getFoundation(FOUNDATION);
		int foundationSize = foundation.size();
		int sizeWaste = startGameController.sizeWaste();
		assertTrue(moveWasteToFoundationController.move(FOUNDATION));
		assertEquals(sizeWaste-1, startGameController.sizeWaste());
		assertEquals(foundationSize+1, startGameController.getFoundation(FOUNDATION).size());
	}

}
