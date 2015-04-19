package klondike;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class GameControllerTest {
	private static final int FOUNDATIONS = 4;

	private GameController gameController;
	
	@Before
	public void before(){
		gameController = new GameController();
	}
	@Test
	public void sizeWastetest() {
		assertEquals(0,gameController.sizeWaste());
	}

	@Test
	public void sizeFoundationsTest() {
		for(int i = 0; i < FOUNDATIONS; i++){
			assertEquals(0, gameController.getFoundation(i).size());
		}
	}
	
	@Test
	public void sizeDeckTest() {
		assertEquals(24,gameController.sizeDeck());
	}
	
	@Test
	public void sizeTableausTest() {
		ArrayList<Integer> sizeTableaus = gameController.sizeCoveredCardsTableaus();
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus= gameController.uncoveredCardsStackTableaus();
		assertEquals(7, sizeTableaus.size());
		assertEquals(7, uncoveredCardsStackTableaus.size());
		
		for(int i = 0; i < sizeTableaus.size(); i++)
			assertEquals(new Integer(i+1), sizeTableaus.get(i));
		
		for(Stack<Card> uncoveredCardsStack : uncoveredCardsStackTableaus){
			assertEquals(1, uncoveredCardsStack.size());
			assertTrue(uncoveredCardsStack.peek().uncovered());
		}
	
	}
	
}

