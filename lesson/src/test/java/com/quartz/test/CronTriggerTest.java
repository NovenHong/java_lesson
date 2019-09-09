package com.quartz.test;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.owner.test.job.SimpleJob;

public class CronTriggerTest {

	public static void main(String[] args) throws SchedulerException {
		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		
		JobDetail job = JobBuilder.newJob(SimpleJob.class)
			.withIdentity("job1","group1")
			.build();
		
		CronTrigger trigger = TriggerBuilder.newTrigger()
			.withIdentity("trigger1","group1")
			.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
			.startAt(new Date())
			.build();
		
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
	}
}
