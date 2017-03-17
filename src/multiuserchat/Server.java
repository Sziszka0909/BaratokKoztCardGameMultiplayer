package multiuserchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends Thread {

	private final int port = 9992;

	private ServerSocket ss;

	private ArrayList<clientThread> clients = new ArrayList<>();

	public Server() {
		try {
			System.out.println("A szerver indulásra kész a következő porton: " + port);
			ss = new ServerSocket(port);
			System.out.println("\nSzerver sikeresen elindult");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("\nKliensekre várakozunk...");
				addClient();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public synchronized void handle(int ID, String input) throws IOException {

		System.out.println("\nÜzenet a klienstől: " + input);

		if (input.equals("HELLO SERVER")) {
			clients.get(findClient(ID)).send("HELLO CLIENT!");
		}
	}

	public void addClient() throws IOException {
		clientThread client = new clientThread(this, ss.accept());
		client.open();
		client.start();
		clients.add(client);
		System.out.println("\nKliens elfogadva.");
		client.send(">> ÜDV, KLIENS! ");

	}

	public void removeClient(int ID) {
		clients.remove(findClient(ID));
		System.out.println("\nA kliens eltávolítva.");
	}

	public int findClient(int ID) {
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).ID == ID) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.start();

	}

	@Override
	public void start() {
		run();
	}

}
