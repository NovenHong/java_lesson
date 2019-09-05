package com.owner.test.socket.client;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendRunnable implements Runnable {
	
	private Socket socket = null;
	
	public ClientSendRunnable(Socket socket) {
		this.socket = socket;
	}

	@SuppressWarnings("resource")
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
