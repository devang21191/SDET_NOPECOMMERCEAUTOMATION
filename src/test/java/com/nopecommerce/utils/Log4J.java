package com.nopecommerce.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4J {

//	private static Logger Log = Logger.getLogBuilder(Logger.class.getName());//

	private static final Logger Log = LogManager.getLogger(Log4J.class);
	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite

	public static void startTestCase(String testCaseName) {
		Log.info("####################################################################################################");
		Log.info("START -----> "+testCaseName);
		Log.info("----------------------------------------------------------------------------------------------------");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String testCaseName) {
		Log.info("----------------------------------------------------------------------------------------------------");
		Log.info("END -----> "+testCaseName);
		Log.info("----------------------------------------------------------------------------------------------------");
	}

	public static void failedTestCase(String testCaseName) {
		Log.info("----------------------------------------------------------------------------------------------------");
		Log.info("***** FAILED ***** -----> "+testCaseName);
		Log.info("----------------------------------------------------------------------------------------------------");
	}
	
	public static void skippedTestCase(String testCaseName) {
		Log.info("----------------------------------------------------------------------------------------------------");
		Log.info("!!!!! SKIPPED !!!!! -----> "+testCaseName);
		Log.info("----------------------------------------------------------------------------------------------------");

	}
	// Need to create these methods, so that they can be called

	public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}

}
