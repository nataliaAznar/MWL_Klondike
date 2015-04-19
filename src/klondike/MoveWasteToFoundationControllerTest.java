package klondike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveWasteToFoundationControllerTest {
	private MoveWasteToFoundationController moveWasteToFoundationController;
	private GameController gameController;
	private static final int FOUNDATION = 1;
	
	@Before
	public void before(){
		gameController = new GameController();
		moveWasteToFoundationController = new MoveWasteToFoundationController(gameController);
	}
	
	@Test
	public void moveFoundationSizeZeroTest(){
		gameController.wasteAddCard(new Card(1, Suit.CLUBS));
		boolean move = moveWasteToFoundationController.move(FOUNDATION);
		assertTrue(move);
	}
	
	@Test
	public void moveTest(){
		gameController.wasteAddCard(new Card(2, Suit.CLUBS));
		gameController.foundationAddCard(FOUNDATION, new Card(1, Suit.CLUBS));
		Stack<Card> foundation = gameController.getFoundation(FOUNDATION);
		int foundationSize = foundation.size();
		int sizeWaste = gameController.sizeWaste();
		assertTrue(moveWasteToFoundationController.move(FOUNDATION));
		assertEquals(sizeWaste-1, gameController.sizeWaste());
		assertEquals(foundationSize+1, gameController.getFoundation(FOUNDATION).size());
	}
	
	@Test
	public void moveBadTest(){
		gameController.wasteAddCard(new Card(1, Suit.CLUBS));
		gameController.foundationAddCard(FOUNDATION, new Card(1, Suit.CLUBS));
		Stack<Card> foundation = gameController.getFoundation(FOUNDATION);
		int foundationSize = foundation.size();
		int sizeWaste = gameController.sizeWaste();
		assertFalse(moveWasteToFoundationController.move(FOUNDATION));
		assertEquals(sizeWaste, gameController.sizeWaste());
		assertEquals(foundationSize, gameController.getFoundation(FOUNDATION).size());
	}

}
