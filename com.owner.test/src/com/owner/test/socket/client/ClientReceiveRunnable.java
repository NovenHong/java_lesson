package com.owner.test.socket.client;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientReceiveRunnable implements Runnable{

	private Socket socket = null;
	
	public ClientReceiveRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;
		DataInputStream dis = null;
	
		try {
			
			while(true) {
				is = socket.getInputStream();
				dis = new DataInputStream(is);
				System.out.println("client received : " + dis.readUTF());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
