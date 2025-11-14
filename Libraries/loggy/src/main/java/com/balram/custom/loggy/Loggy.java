package com.balram.custom.loggy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.event.Level;

import com.balram.custom.loggy.status.ProcessStatus;
import com.balram.custom.loggy.utils.LogUtils;

public class Loggy{

    private static final String PAYLOAD = "payload";
    private Logger logger;

    private Loggy(Logger logger){
        LogUtils.clearLog();
        this.logger = logger;
    }

    // get new instance of Loggy with caller class Logger
    public static Loggy loggyFactory(Class<?> clazz){
        return new Loggy(LoggerFactory.getLogger(clazz));
    }

    public void info(String message, Object... parameters){
        LogUtils.logMessage(logger, Level.INFO, message,parameters);
        LogUtils.clearLog();
    }

    public void error(String message, Object... parameters){
        LogUtils.logMessage(logger, Level.ERROR, message,parameters);
        LogUtils.clearLog();
    }

    public Loggy timeDuartion( String timeDuration){
        MDC.put("timeDuration",timeDuration);
        return this;
    }

    public Loggy payload(String payload){
        MDC.put(PAYLOAD,payload);
        return this;
    }
    
    public void changeProcessStatus(ProcessStatus status){
        MDC.put(LogUtils.STATUS, status.getStatus());
    }
	
}
