package com.hitbtc.mytrades;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hitbtc.mytrades.job.BytecoinJob;

@SpringBootApplication
public class MytradesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytradesApplication.class, args);
	}
	
	@Bean
	public JobDetail tradesJobDetail() {
		return JobBuilder.newJob(BytecoinJob.class).withIdentity("tradesJob")
				.usingJobData("name", "trades").storeDurably().build();
	}

	@Bean
	public Trigger sampleJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(30).repeatForever();

		return TriggerBuilder.newTrigger().forJob(tradesJobDetail())
				.withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
	}

}
