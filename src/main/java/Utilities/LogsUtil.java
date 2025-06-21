package Utilities;

import org.apache.logging.log4j.LogManager;

public class LogsUtil {
    // Path where log files will be stored
    public static String LOGS_Path = "TestOutputs/logs";

    /**
     * Logs a TRACE level message.
     * @param message The message to log.
     */
    public static void trace(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .trace(message);
    }

    /**
     * Logs a DEBUG level message.
     * @param message The message to log.
     */
    public static void debug(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .debug(message);
    }
    /**
     * Logs an INFO level message.
     * @param message The message to log.
     */
    public static void info(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .info(message);
    }
    /**
     * Logs a WARN level message.
     * @param message The message to log.
     */
    public static void Warn(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .warn(message);
    }
    /**
     * Logs an ERROR level message.
     * @param message The message to log.
     */
    public static void Error(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .error(message);
    }
    /**
     * Logs a FATAL level message.
     * @param message The message to log.
     */
    public static void fatal(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString())
                .fatal(message);
    }
}
