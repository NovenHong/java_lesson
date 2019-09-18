package com.single.test;

public class StaticInternalClassSingleTest {
	
	private static class SingletonClassInstance {
		private static final StaticInternalClassSingleTest instance = new StaticInternalClassSingleTest();
	}
	
	private StaticInternalClassSingleTest() {};
	
	public static StaticInternalClassSingleTest getInstance() {
		return SingletonClassInstance.instance;
	}

	public static void main(String[] args) {
		
		StaticInternalClassSingleTest instance1 = StaticInternalClassSingleTest.getInstance();
		
		StaticInternalClassSingleTest instance2 = StaticInternalClassSingleTest.getInstance();
		
		System.out.println(instance1);
		
		System.out.println(instance2);

	}

}
