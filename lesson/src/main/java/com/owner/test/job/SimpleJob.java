package com.owner.test.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class SimpleJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobKey key = context.getJobDetail().getKey();
		String name = key.getName();
		
		System.out.println("job key = " + key + "; job name = " + name);
	}

}
