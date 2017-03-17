package multiuserchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class clientThread extends Thread {

	private Socket s;
	private DataOutputStream out;
	private DataInputStream in;
	public int ID = -1;
	private Server srv;

	public clientThread(Server srv, Socket s) {
		this.srv = srv;
		this.s = s;
		ID = s.getPort();
	}

	@Override
	public void run() {
		try {
			while (true) {
				srv.handle(ID, in.readUTF());
			}
		} catch (IOException e) {
			srv.removeClient(ID);
		}
	}

	public void send(String msg) throws IOException {
		out.writeUTF(msg);
	}

	public void open() throws IOException {
		out = new DataOutputStream(s.getOutputStream());
		in = new DataInputStream(s.getInputStream());
	}

	public void close() throws IOException {
		in.close();
		out.close();
		s.close();
	}
}