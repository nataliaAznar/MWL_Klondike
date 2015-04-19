package klondike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class MoveDeckToWasteControllerTest {
	private static final Suit[] SUITS = {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
	private static final int SUIT_CARDS = 12;
	private static final int MAX_REPETITIONS_NUMBER = 10;
	
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
	
	@Test
	public void cardRandomTest(){
		HashMap<Suit, ArrayList<Integer>> cont = new HashMap<Suit, ArrayList<Integer>>();
		for(Suit suit : SUITS){
			ArrayList<Integer> cards = new ArrayList<Integer>();
			for(int j = 0; j < SUIT_CARDS; j++)
				cards.add(0);
			cont.put(suit, cards);
		}
		for(int x = 0; x < 200; x++){
			gameController = new GameController();
			moveDeckToWasteController = new MoveDeckToWasteController(gameController);
			moveDeckToWasteController.move();
			Card card = gameController.getDeckCard();
			ArrayList<Integer> suit = cont.get(card.getSuit());
			Integer repetitions = suit.get(card.getNumber()-1);
			repetitions ++;
			assertTrue(repetitions <= MAX_REPETITIONS_NUMBER);
			suit.add(card.getNumber()-1, repetitions);
			cont.put(card.getSuit(), suit);
		}
	}
	
}
