package com.balram.custom.loggy.utils;

import org.slf4j.Logger;
import org.slf4j.MDC;
import org.slf4j.event.Level;

/**
 * Utility class for logging.
 *
 * @author Balram Rajak
 */
public interface LogUtils{

    

    static final String PAYLOAD = "payload";
    static final String STATUS = "status";
    static final String MESSAGE = "message";

    public static void clearLog(){
        MDC.put(PAYLOAD, "");
        MDC.put("timeDuration","");
    }

    
    public static void logMessage(Logger logger,Level logLevel,String message, Object... parameters){
        switch (logLevel) {
            case DEBUG:
                logger.debug(message, parameters);
                break;
            case INFO:
                logger.info(message, parameters);
                break;
            case WARN:
                logger.warn(message, parameters);
                break;
            case ERROR:
                logger.error(message, parameters);
                break;
            default:
                logger.info(message, parameters);
                break;
        }
    }

    public static void log(Logger logger,Level logLevel,String payload,String message,String timeDuration, Object... parameters){
        MDC.put(PAYLOAD, payload);
        MDC.put("timeDuration",timeDuration);
        switch (logLevel) {
            case DEBUG:
                logger.debug(message, parameters);
                break;
            case INFO:
                logger.info(message, parameters);
                break;
            case WARN:
                logger.warn(message, parameters);
                break;
            case ERROR:
                logger.error(message, parameters);
                break;
            default:
                logger.info(message, parameters);
                break;
        }
        clearLog();
    }

}

