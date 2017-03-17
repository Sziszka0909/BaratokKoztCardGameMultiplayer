package Multiplayer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.cardList.add(new Card("Berényi András", 9, 3, 1));
		deck.cardList.add(new Card("Berényi Miklós", 1, 9, 7));
		deck.cardList.add(new Card("Szentmihályi Zsófia", 6, 2, 7));
		deck.cardList.add(new Card("Berényi Attila", 3, 8, 5));
		deck.cardList.add(new Card("Kertész Géza", 9, 6, 5));
		deck.cardList.add(new Card("Kertész Vilmos", 8, 4, 3));
		deck.cardList.add(new Card("Magdi Anyus", 10, 10, 9));
		deck.cardList.add(new Card("Magdi Anyus szelleme", 10, 9, 10));
		deck.cardList.add(new Card("Bartha Zsolt", 1, 10, 6));
		deck.cardList.add(new Card("Holman Hanna", 10, 6, 3));
		deck.cardList.add(new Card("Bartha Krisztián", 9, 6, 4));
		deck.cardList.add(new Card("Berényi Claudia", 4, 7, 9));
		deck.cardList.add(new Card("Egressy \"Tóni\" Antal", 2, 9, 6));
		deck.cardList.add(new Card("Nádor Kinga", 5, 6, 7));
		deck.cardList.add(new Card("Balogh Nóra", 6, 6, 6));
		deck.cardList.add(new Card("Berényi Zsuzsa", 7, 6, 8));
		deck.cardList.add(new Card("Berényi Kata", 5, 2, 5));
		deck.cardList.add(new Card("Berényi Dániel", 3, 6, 1));
		deck.cardList.add(new Card("Nagy Tóbiás & (F)Asztalos Kristóf", 7, 7, 6));
		deck.cardList.add(new Card("Illés Vanda", 2, 6, 8));
		deck.cardList.add(new Card("Illés Péter", 1, 10, 7));
		deck.cardList.add(new Card("Illés Júlia", 6, 7, 10));
		deck.cardList.add(new Card("Bokros Gizi", 3, 5, 8));
		deck.cardList.add(new Card("Bartha Linda", 4, 7, 6));
		deck.cardList.add(new Card("Bokros Ádám", 7, 8, 6));
		deck.cardList.add(new Card("Fekete Alíz", 2, 6, 8));
		deck.cardList.add(new Card("Fekete Luca", 10, 3, 5));
		deck.cardList.add(new Card("Cheng", 6, 7, 6));
		deck.cardList.add(new Card("Berci", 10, 9, 9));
		deck.cardList.add(new Card("Berényi Balázs", 3, 8, 7));
		deck.cardList.add(new Card("A pincér", 1, 1, 1));
		deck.cardList.add(new Card("Novák László", 9, 8, 3));
		Scanner name = new Scanner(System.in);
		System.out.println("Első játékos neve: ");
		String name1 = name.nextLine();
		System.out.println("Második játékos neve: ");
		String name2 = name.nextLine();
		Player player1 = new Player(name1, 1);
		Player player2 = new Player(name2, 2);
		player1.getCards(deck.cardList);
		player2.getSecondPlayerCards(deck.cardList, player1);
		int currentPlayer1Card = 0;
		int currentPlayer2Card = 0;
		int round = 1;
		while (true) {
			if (player1.nyert == true) {
				System.out.println(player1.name + " jön.");
				System.out.println(round + ". kör.				" + player1.name + "-" + player2.name + " "
						+ player1.cardsInHand.size() + "-" + player2.cardsInHand.size() + ".");
				Card player1Card = player1.showCard(player1.cardsInHand, 0);
				int inp = player1.chooseSkill();
				Card player2Card = player2.showCard(player2.cardsInHand, 0);
				player1.showWinner(inp, player2);
				if (currentPlayer1Card >= player1.cardsInHand.size() - 1 && player1.cardsInHand.size() > 0) {
					currentPlayer1Card = 0;
				} else {
					currentPlayer1Card++;
				}
				if (currentPlayer2Card >= player2.cardsInHand.size() - 1 && player2.cardsInHand.size() > 0) {
					currentPlayer2Card = 0;
				} else {
					currentPlayer2Card++;
				}
				round++;
				if (player1.cardsInHand.size() > 31) {
					break;
				} else if (player2.cardsInHand.size() > 31) {
					break;
				}
			} else {
				System.out.println(player2.name + " jön.");
				System.out.println(round + ". kör.				" + player1.name + "-" + player2.name + " "
						+ player1.cardsInHand.size() + "-" + player2.cardsInHand.size() + ".");
				Card player2Card = player2.showCard(player2.cardsInHand, 0);
				int inp = player1.chooseSkill();
				Card player1Card = player1.showCard(player1.cardsInHand, 0);
				player2.showWinner(inp, player1);
				if (currentPlayer1Card >= player2.cardsInHand.size() - 1 && player2.cardsInHand.size() > 0) {
					currentPlayer1Card = 0;
				} else {
					currentPlayer1Card++;
				}
				if (currentPlayer1Card >= player1.cardsInHand.size() - 1 && player1.cardsInHand.size() > 0) {
					currentPlayer1Card = 0;
				} else {
					currentPlayer1Card++;
				}
				round++;
				if (player2.cardsInHand.size() > 31) {
					break;
				} else if (player1.cardsInHand.size() > 31) {
					break;
				}
			}
		}
	}

}
