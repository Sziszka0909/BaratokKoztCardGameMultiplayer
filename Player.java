package Multiplayer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

	int myCounter = 0;
	int AICounter = 0;
	boolean nyert;
	String name;

	ArrayList<Card> cardsInHand = new ArrayList<Card>();

	public Player(String name, int i) {
		if (i == 1) {
			this.nyert = true;
		} else if (i == 2) {
			this.nyert = false;
		}
		this.name = name;
	}

	public void getCards(ArrayList<Card> cardList) {
		Random random = new Random();
		int counter = 1;
		while (counter <= 16) {
			int rand = random.nextInt(cardList.size());
			Card randomCard = cardList.get(rand);
			if (!cardsInHand.contains(randomCard)) {
				cardsInHand.add(randomCard);
				counter++;
			}
		}
	}

	public void getSecondPlayerCards(ArrayList<Card> cardList, Player player) {
		int counter = 1;
		while (counter <= 16) {
			for (Card card : cardList) {
				if (!player.cardsInHand.contains(card)) {
					this.cardsInHand.add(card);
					counter++;
				}
			}
		}
	}

	public void printIn(ArrayList<Card> cList) {
		for (Card c : cList) {
			System.out.println(c.nev);
		}
	}

	public Card showCard(ArrayList<Card> cList, int i) {
		System.out.println(cList.get(i).nev + "\nIgazmondás: " + cList.get(i).igazMondas + "\nBalhézás: "
				+ cList.get(i).balhezas + "\nFéltékenység: " + cList.get(i).feltekenyseg);
		return cList.get(i);
	}

	public int chooseSkill() {
		Scanner input = new Scanner(System.in);
		System.out.println("Válassz egy tulajdonságot. (Igazmondás: [1]; Balhézás: [2]; Féltékenység: [3])");
		int inp = 0;
		while (inp > 3 || inp < 1) {
			inp = input.nextInt();
			if (inp > 3 || inp < 1) {
				System.err.println("1-3 közötti számot adj meg!!!");
			}

		}
		return inp;
	}

	public int showWinner(int inp, Player player) {
		if (inp == 1) {
			Card player1Card = cardsInHand.get(0);
			Card player2Card = player.cardsInHand.get(0);
			player1Card.compareIgazMondas(player2Card);
			if (cardsInHand.get(0).roundWinner == "Nyert") {
				player.cardsInHand.remove(player2Card);
				cardsInHand.add(player2Card);
				cardsInHand.remove(player1Card);
				cardsInHand.add(player1Card);
				this.nyert = true;
				player.nyert = false;
			} else if (cardsInHand.get(0).roundWinner == "Vesztett") {
				cardsInHand.remove(player1Card);
				player.cardsInHand.add(player1Card);
				player.cardsInHand.remove(player2Card);
				player.cardsInHand.add(player2Card);
				this.nyert = false;
				player.nyert = true;
			} else {
				player.cardsInHand.remove(player2Card);
				player.cardsInHand.add(player2Card);
				cardsInHand.remove(player1Card);
				cardsInHand.add(player1Card);
			}
			return cardsInHand.get(0).igazMondas;
		} else if (inp == 2) {
			Card player1Card = cardsInHand.get(0);
			Card player2Card = player.cardsInHand.get(0);
			player1Card.compareBalhezas(player2Card);
			if (cardsInHand.get(0).roundWinner == "Nyert") {
				player.cardsInHand.remove(player2Card);
				cardsInHand.add(player2Card);
				cardsInHand.remove(player1Card);
				cardsInHand.add(player1Card);
				this.nyert = true;
				player.nyert = false;
			} else if (cardsInHand.get(0).roundWinner == "Vesztett") {
				cardsInHand.remove(player1Card);
				player.cardsInHand.add(player1Card);
				player.cardsInHand.remove(player2Card);
				player.cardsInHand.add(player2Card);
				this.nyert = false;
				player.nyert = true;
			} else {
				player.cardsInHand.remove(player2Card);
				player.cardsInHand.add(player2Card);
				cardsInHand.remove(player1Card);
				cardsInHand.add(player1Card);
			}
			return cardsInHand.get(0).balhezas;
		} else if (inp == 3) {
			Card player1Card = cardsInHand.get(0);
			Card player2Card = player.cardsInHand.get(0);
			player1Card.compareFeltekenyseg(player2Card);
			if (cardsInHand.get(0).roundWinner == "Nyert") {
				player.cardsInHand.remove(player2Card);
				cardsInHand.add(player2Card);
				cardsInHand.remove(player1Card);
				cardsInHand.add(player1Card);
				this.nyert = true;
				player.nyert = false;
			} else if (cardsInHand.get(0).roundWinner == "Vesztett") {
				cardsInHand.remove(player1Card);
				player.cardsInHand.add(player1Card);
				player.cardsInHand.remove(player2Card);
				player.cardsInHand.add(player2Card);
				this.nyert = false;
				player.nyert = true;
			} else {
				player.cardsInHand.remove(player2Card);
				player.cardsInHand.add(player2Card);
				cardsInHand.remove(player1Card);
				cardsInHand.add(player1Card);
			}
			return cardsInHand.get(0).feltekenyseg;
		}
		return 1;
	}

}
