package com.callback.test;

public class Student {

	
	public void resolveAnswer(Callback callback,String question) {
		
		System.out.println("Student receive the question:"+question);
		
		System.out.println("Student do something ...");
		doSomething();
		System.out.println("Student done something ...");
		
		callback.tellAnswer(2);
		
	}
	
	public void doSomething() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
