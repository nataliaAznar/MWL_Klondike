package klondike;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MoveDeckToWasteControllerTest {
	
private MoveDeckToWasteController moveDeckToWasteController;
private GameController gameController;
	
	@Before
	public void before(){
		gameController = new GameController();
		moveDeckToWasteController = new MoveDeckToWasteController(gameController);
	}

	@Test
	public void moveTest() {
		int sizeDeck = gameController.sizeDeck();
		int sizeWaste = gameController.sizeWaste();
		moveDeckToWasteController.move();
		assertEquals(gameController.sizeDeck(), (sizeDeck - 3));
		assertEquals(gameController.sizeWaste(), (sizeWaste + 3));
	}
	
	@Test
	public void moveDeckSizeLessThanThreeTest() {
		gameController.setSizeDeck(2);
		int sizeDeck = gameController.sizeDeck();
		int sizeWaste = gameController.sizeWaste();
		moveDeckToWasteController.move();
		assertEquals(gameController.sizeDeck(), 0);
		assertEquals(gameController.sizeWaste(), (sizeWaste + sizeDeck));
	}
	
	@Test
	public void moveDeckSizeZeroTest() {
		gameController.setSizeDeck(0);
		int sizeWaste = gameController.sizeWaste();
		moveDeckToWasteController.move();
		assertEquals(gameController.sizeDeck(), 0);
		assertEquals(gameController.sizeWaste(), sizeWaste);
	}
	
}
