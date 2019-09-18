package com.single.test;

public class LazySingleTest {
	
	private static LazySingleTest instance = null;
	
	private LazySingleTest() {};
	
	public static synchronized LazySingleTest getInstance() {
		if(instance == null) {
			instance = new LazySingleTest();
		}
		
		return instance;
	}

	public static void main(String[] args) {
		
		LazySingleTest instance1 = LazySingleTest.getInstance();
		
		LazySingleTest instance2 = LazySingleTest.getInstance();
		
		System.out.println(instance1);
		System.out.println(instance2);

	}

}
