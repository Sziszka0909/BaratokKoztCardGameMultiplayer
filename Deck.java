package Multiplayer;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	ArrayList<Card> cardList = new ArrayList<Card>();

	public void printOut() {
		for (Card c : cardList) {
			System.out.println(c.nev);
		}
	}

	public void shuffle(ArrayList<Card> theList) {
		Collections.shuffle(theList);
	}

}
