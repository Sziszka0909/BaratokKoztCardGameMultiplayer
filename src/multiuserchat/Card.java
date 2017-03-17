package multiuserchat;

public class Card {

	String nev;
	int igazMondas;
	int balhezas;
	int feltekenyseg;
	String roundWinner;

	public Card(String nev, int igazMondas, int balhezas, int feltekenyseg) {
		this.nev = nev;
		this.igazMondas = igazMondas;
		this.balhezas = balhezas;
		this.feltekenyseg = feltekenyseg;

	}

	public Card() {
	}

	public String getNev() {
		return nev;
	}

	public int getIgazMondas() {
		return igazMondas;
	}

	public int getBalhezas() {
		return balhezas;
	}

	public int getFeltekenyseg() {
		return feltekenyseg;
	}

	public void compareIgazMondas(Card card1) {
		if (card1.igazMondas > this.igazMondas) {
			System.out.println("				" + card1.nev + " nyert.");
			roundWinner = "Vesztett";
		} else if (card1.igazMondas < this.igazMondas) {
			System.out.println("				" + this.nev + " nyert.");
			roundWinner = "Nyert";
		} else {
			System.out.println("				Döntetlen.");
			roundWinner = "Döntetlen";
		}
	}

	public void compareBalhezas(Card card1) {
		if (card1.balhezas > this.balhezas) {
			System.out.println("				" + card1.nev + " nyert.");
			roundWinner = "Vesztett";
		} else if (card1.balhezas < this.balhezas) {
			System.out.println("				" + this.nev + " nyert.");
			roundWinner = "Nyert";
		} else {
			System.out.println("				Döntetlen.");
			roundWinner = "Döntetlen";
		}
	}

	public void compareFeltekenyseg(Card card1) {

		if (card1.feltekenyseg > this.feltekenyseg) {
			System.out.println("				" + card1.nev + " nyert.");
			roundWinner = "Vesztett";
		} else if (card1.feltekenyseg < this.feltekenyseg) {
			System.out.println("				" + this.nev + " nyert.");
			roundWinner = "Nyert";
		} else {
			System.out.println("				Döntetlen");
			roundWinner = "Döntetlen";
		}
	}

}
