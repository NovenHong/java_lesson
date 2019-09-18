package com.owner.test.job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob {
	
	Integer index = 0;

	public void run() {
		
		if(index < 5) {
			System.out.println(new SimpleDateFormat("任务执行了"+"yyyy-MM-dd HH:mm:ss").format(new Date()));
			index ++;
		}
		
	}
}
