package lostfilm;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder
                .newJob(QuartzJob.class)
                .withIdentity("QuartzJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("QuartzTrigger", "group1")
                .withSchedule(CronScheduleBuilder
                        .cronSchedule("0 0 9-18/1 ? * MON,TUE,WED,THU,FRI"))
                .build();


        SchedulerFactory schedFact = new StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        sched.start();
        sched.scheduleJob(job,trigger);
    }
}
