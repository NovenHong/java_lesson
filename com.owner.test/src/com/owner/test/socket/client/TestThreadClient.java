package com.owner.test.socket.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestThreadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("127.0.0.1",5652);
		
		ClientSendRunnable clientSendRunnable = new ClientSendRunnable(socket);
		Thread thread1 = new Thread(clientSendRunnable);
		thread1.start();
		
		ClientReceiveRunnable clientReceiveRunnable = new ClientReceiveRunnable(socket);
		Thread thread2 = new Thread(clientReceiveRunnable);
		thread2.start();
	}
}
