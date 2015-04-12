package klondike;

import java.util.ArrayList;
import java.util.Stack;

public class StartGameController {
	private static final int TABLEAUS = 7;
	private static final int FOUNDATIONS = 4;
	
	private int sizeDeck;
	
	private ArrayList<Stack<Card>> foundations;
	private Stack<Card> waste;
	
	public StartGameController(){
		sizeDeck = 24;
		foundations = new ArrayList<Stack<Card>>(4);
		for(int i = 0; i < FOUNDATIONS; i++){
			foundations.add(new Stack<Card>());
		}
		waste= new Stack<Card>();
	}

	public int sizeWaste() {
		return waste.size();
	}

	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for (int i = 0; i < FOUNDATIONS; i++) {
			sizeFoundations.add(0);
		}
		return sizeFoundations;
	}

	public int sizeDeck() {
		return sizeDeck;
	}

	public ArrayList<Integer> sizeCoveredCardsTableaus() {
		ArrayList<Integer> sizeTableaus = new ArrayList<Integer>();
		for (int i = 0; i < TABLEAUS; i++) {
			sizeTableaus.add(i+1);
		}
		return sizeTableaus;
	}

	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus = new ArrayList<Stack<Card>>();
		for (int i = 0; i < TABLEAUS; i++) {
			Stack<Card> uncoveredCardsStack = new Stack<Card>();
			uncoveredCardsStack.add(new Card(0, Suit.CLUBS));
			uncoveredCardsStackTableaus.add(uncoveredCardsStack);
		}
		return uncoveredCardsStackTableaus;
	}

	public void setSizeDeck(int sizeDeck) {
		this.sizeDeck = sizeDeck;
		
	}

	public Card wasteCard() {
		return waste.peek();
	}
	
	public Stack<Card> getFoundation(int foundation){
		return this.foundations.get(foundation);
	}

	public void foundationAddCard(int foundation, Card card) {
		this.getFoundation(foundation).add(card);
	}

	public void wasteRemoveCard() {
		waste.pop();
	}

	public void wasteAddCard(Card card) {
		waste.add(card);		
	}

}
