package klondike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveDeckToWasteControllerTest {
	private static final Suit[] SUITS = {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
	private static final int SUIT_CARDS = 12;
	private static final int MAX_REPETITIONS_NUMBER = 10;
	private static final int FOUNDATIONS = 4;
	private static final int TABLEAUS = 7;
	
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
	
	@Test
	public void testUniqueCard(){
		for(int j = 1; j <= SUIT_CARDS; j++){
			 gameController.foundationAddCard(1, new Card(j, Suit.CLUBS));
			 gameController.tableauAddCard(1, new Card(j, Suit.DIAMONDS));
			 gameController.wasteAddCard(new Card(j, Suit.HEARTS));
		}
		moveDeckToWasteController.move();
		Card card = gameController.getDeckCard();
		 for( int i = 0; i < FOUNDATIONS; i++){
			 Stack<Card> foundation = gameController.getFoundation(i);
			 assertFalse(foundation.contains(card));
		 }
		 for( int i = 0; i < TABLEAUS; i++){
			 Stack<Card> tableau = gameController.getTableau(i);
			 assertFalse(tableau.contains(card));
		 }
		 Stack<Card> waste = gameController.getWaste();
		 assertFalse(waste.contains(card));
		 System.out.println(card);
		 assertTrue(Suit.SPADES.equals(card.getSuit()));
	}
	
}
