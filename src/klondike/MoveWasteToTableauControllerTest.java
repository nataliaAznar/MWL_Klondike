package klondike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoveWasteToTableauControllerTest {
	private MoveWasteToTableauController moveWasteToTableauController;
	private GameController gameController;
	private static final int TABLEAU = 1;

	@Before
	public void before(){
		gameController = new GameController();
		moveWasteToTableauController = new MoveWasteToTableauController(gameController);
	}
	
	@Test
	public void moveTableauSizeZeroTest(){
		gameController.wasteAddCard(new Card(12, Suit.CLUBS));
		boolean move = moveWasteToTableauController.move(TABLEAU);
		assertTrue(move);
		assertEquals(1, gameController.getTableau(TABLEAU).size());
		assertEquals(0, gameController.sizeWaste());
		
		gameController.wasteAddCard(new Card(11, Suit.CLUBS));
		move = moveWasteToTableauController.move(TABLEAU+1);
		assertFalse(move);
		assertEquals(0, gameController.getTableau(TABLEAU+1).size());
		assertEquals(1, gameController.sizeWaste());
	}
	
	@Test
	public void move(){
		gameController.wasteAddCard(new Card(11, Suit.CLUBS));
		gameController.tableauAddCard(TABLEAU, new Card(12, Suit.HEARTS));
		boolean move = moveWasteToTableauController.move(TABLEAU);
		assertTrue(move);
		assertEquals(2, gameController.getTableau(TABLEAU).size());
		assertEquals(0, gameController.sizeWaste());
		
	}

}
