package Multiplayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

	private Socket s;
	private DataInputStream in;
	private DataOutputStream out;

	public Client(final String host, final int port) {
		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Kapcsolódás a szerverhez: " + host + " és port: " + port);
			s = new Socket(host, port);
			if (s.isConnected()) {

				open();
				System.out.println("Kapcsolódva a szerverhez: " + host + " és port: " + port);
				String szoveg = in.nextLine();
				send(szoveg);
			}

		} catch (IOException e) {
			System.out.println("Nem sikerült csatlakozni a szerverhez. " + e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				String message = in.readUTF();
				System.out.println("Üzenet a szervertől: " + message);
			}
		} catch (IOException e) {
			close();
			System.out.println("Kapcsolat megszakítva. " + e.getMessage());
		}
	}

	public void open() throws IOException {

		in = new DataInputStream(s.getInputStream());
		out = new DataOutputStream(s.getOutputStream());
	}

	public void close() {
		try {
			out.close();
			in.close();
			s.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void send(String msg) throws IOException {
		out.writeUTF(msg);
	}

	public static void main(String[] args) {
		new Client("localhost", 9998);

	}
}
