package Multiplayer;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(System.in);
			Socket soc = new Socket("192.168.150.148", 4321);
			OutputStream o = soc.getOutputStream();
			ObjectOutput s = new ObjectOutputStream(o);
			while (true) {
				String text = sc.nextLine();
				System.out.println("Sent: " + text);
				s.writeObject(text);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error during serialization");
			System.exit(1);
		}
	}
}
