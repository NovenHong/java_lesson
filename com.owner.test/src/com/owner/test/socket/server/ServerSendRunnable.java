package com.owner.test.socket.server;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerSendRunnable implements Runnable{
	
	private Socket socket = null;

	public ServerSendRunnable(Socket socket) {
		this.socket = socket;
	}

	@SuppressWarnings("resource")
	@Override
	public void run() {
		
		OutputStream os = null;
		DataOutputStream dos = null;
		
		try {
			
			while(true) {
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				
				Scanner scanner = new Scanner(System.in);
				String line = scanner.nextLine();
				
				dos.writeUTF(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
