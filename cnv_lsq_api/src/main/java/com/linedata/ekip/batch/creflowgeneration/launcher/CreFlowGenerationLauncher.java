package com.linedata.ekip.batch.creflowgeneration.launcher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreFlowGenerationLauncher
{

   /** The logger. */
   private static final Log LOG = LogFactory.getLog(CreFlowGenerationLauncher.class);

   public static void main(String[] args) throws Exception
   {

      String[] springConfig =
      { "spring/mono/sql/import.spring.xml" };

      // Creating the application context object
      ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
//
//      // Creating the job launcher
//      JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
//
//      // Creating the job
//      Job job = (Job) context.getBean("CreFlowGenerationJob");
//
//      // Executing the JOB
//      JobExecution execution = jobLauncher.run(job, new JobParameters());
//      LOG.info("Mono Sql Exit Status : " + execution.getStatus());

   }
}
