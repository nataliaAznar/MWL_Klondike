package klondike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoveWasteToTableauControllerTest {
	private MoveWasteToTableauController moveWasteToTableauController;
	private StartGameController startGameController;
	private static final int FOUNDATION = 1;

	@Before
	public void before(){
		startGameController = new StartGameController();
		moveWasteToTableauController = new MoveWasteToTableauController(startGameController);
	}
	
	@Test
	public void moveTableauSizeZeroTest(){
		startGameController.wasteAddCard(new Card(12, Suit.CLUBS));
		boolean move = moveWasteToTableauController.move(FOUNDATION);
		assertTrue(move);
		assertEquals(1, startGameController.getFoundation(FOUNDATION).size());
		assertEquals(0, startGameController.sizeWaste());
		
		startGameController.wasteAddCard(new Card(11, Suit.CLUBS));
		move = moveWasteToTableauController.move(FOUNDATION+1);
		assertFalse(move);
		assertEquals(0, startGameController.getFoundation(FOUNDATION+1).size());
		assertEquals(1, startGameController.sizeWaste());
	}
	
	@Test
	public void move(){
		startGameController.wasteAddCard(new Card(11, Suit.CLUBS));
		startGameController.foundationAddCard(FOUNDATION, new Card(12, Suit.HEARTS));
		boolean move = moveWasteToTableauController.move(FOUNDATION);
		assertTrue(move);
		assertEquals(2, startGameController.getFoundation(FOUNDATION).size());
		assertEquals(0, startGameController.sizeWaste());
		
	}

}
