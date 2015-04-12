package klondike;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MoveDeckToWasteControllerTest {
	
private MoveDeckToWasteController moveDeckToWasteController;
private StartGameController startGameController;
	
	@Before
	public void before(){
		startGameController = new StartGameController();
		moveDeckToWasteController = new MoveDeckToWasteController(startGameController);
	}

	@Test
	public void moveTest() {
		int sizeDeck = startGameController.sizeDeck();
		int sizeWaste = startGameController.sizeWaste();
		moveDeckToWasteController.move();
		if(sizeDeck >= 3){
			assertEquals(startGameController.sizeDeck(), (sizeDeck - 3));
			assertEquals(startGameController.sizeWaste(), (sizeWaste + 3));
		}
	}

}
