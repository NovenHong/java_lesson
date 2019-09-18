package com.callback.test;

public class Teacher implements Callback {
	
	private Student student;
	
	public Teacher(Student student) {
		this.student = student;
	}
	
	public void askQuestion(String question) {
		System.out.println("Teacher ask a question:"+question);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				student.resolveAnswer(Teacher.this, question);
			}
			
		}).start();;
		
		
		System.out.println("Teacher do something ...");
		
	}

	@Override
	public void tellAnswer(int answer) {
		
		System.out.println("Student answer is:"+answer);
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		Teacher teacher = new Teacher(student);
		
		teacher.askQuestion("1 + 1 = ?");
	}

}
