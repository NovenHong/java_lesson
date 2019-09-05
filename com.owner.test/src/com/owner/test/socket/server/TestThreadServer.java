package com.owner.test.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestThreadServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(5652);
		
		System.out.println("server is running on port:5652...");
		
		while(true) {
			Socket socket = serverSocket.accept();
			
			System.out.println(socket);
			
			ServerReceiveRunnable serverReceiveRunnable = new ServerReceiveRunnable(socket);
			Thread thread1 = new Thread(serverReceiveRunnable);
			thread1.start();
			
			ServerSendRunnable serverSendRunnable = new ServerSendRunnable(socket);
			Thread thread2 = new Thread(serverSendRunnable);
			thread2.start();
		}
	}
}
