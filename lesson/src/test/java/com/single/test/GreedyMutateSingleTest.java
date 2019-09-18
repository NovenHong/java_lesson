package com.single.test;

public class GreedyMutateSingleTest {
	
	private static GreedyMutateSingleTest instance = null;
	
	static {
		instance = new GreedyMutateSingleTest();
	}
	
	private GreedyMutateSingleTest() {};
	
	public static GreedyMutateSingleTest getInstance() {
		return instance;
	}

	public static void main(String[] args) {

		GreedyMutateSingleTest instance1 = GreedyMutateSingleTest.getInstance();
		
		GreedyMutateSingleTest instance2 = GreedyMutateSingleTest.getInstance();
		
		System.out.println(instance1);
		
		System.out.println(instance2);

	}

}
