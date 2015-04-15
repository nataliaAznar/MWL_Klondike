package klondike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoveWasteToTableauControllerTest {
	private MoveWasteToTableauController moveWasteToTableauController;
	private StartGameController startGameController;
	private static final int TABLEAU = 1;

	@Before
	public void before(){
		startGameController = new StartGameController();
		moveWasteToTableauController = new MoveWasteToTableauController(startGameController);
	}
	
	@Test
	public void moveTableauSizeZeroTest(){
		startGameController.wasteAddCard(new Card(12, Suit.CLUBS));
		boolean move = moveWasteToTableauController.move(TABLEAU);
		assertTrue(move);
		assertEquals(1, startGameController.getTableau(TABLEAU).size());
		assertEquals(0, startGameController.sizeWaste());
		
		startGameController.wasteAddCard(new Card(11, Suit.CLUBS));
		move = moveWasteToTableauController.move(TABLEAU+1);
		assertFalse(move);
		assertEquals(0, startGameController.getTableau(TABLEAU+1).size());
		assertEquals(1, startGameController.sizeWaste());
	}
	
	@Test
	public void move(){
		startGameController.wasteAddCard(new Card(11, Suit.CLUBS));
		startGameController.tableauAddCard(TABLEAU, new Card(12, Suit.HEARTS));
		boolean move = moveWasteToTableauController.move(TABLEAU);
		assertTrue(move);
		assertEquals(2, startGameController.getTableau(TABLEAU).size());
		assertEquals(0, startGameController.sizeWaste());
		
	}

}
