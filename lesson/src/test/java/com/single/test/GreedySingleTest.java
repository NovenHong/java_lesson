package com.single.test;

public class GreedySingleTest {
	
	private static GreedySingleTest instance = new GreedySingleTest();
	
	private GreedySingleTest() {};
	
	public static GreedySingleTest getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		
		GreedySingleTest instance1 = GreedySingleTest.getInstance();
		
		GreedySingleTest instance2 = GreedySingleTest.getInstance();
		
		System.out.println(instance1);
		System.out.println(instance2);
		
	}

}
