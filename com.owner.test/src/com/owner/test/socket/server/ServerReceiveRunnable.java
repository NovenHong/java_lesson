package com.owner.test.socket.server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ServerReceiveRunnable implements Runnable{

	private Socket socket = null;
	
	public ServerReceiveRunnable(Socket socket) {
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
				
				System.out.println("server received : " + dis.readUTF());
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
	}
	
	
	
}
