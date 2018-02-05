package com.twentyeighty.core;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CustomLogger {

	public static Logger log;

	public static void logInfo(String className, String messageInLogs) {

		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(className);
		log.info(messageInLogs);

	}
}
