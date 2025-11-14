package com.balram.custom.loggy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.event.Level;

import com.balram.custom.loggy.status.ProcessStatus;
import com.balram.custom.loggy.utils.LogUtils;

/**
 * Custom logger implementation that extends SLF4J with MDC (Mapped Diagnostic Context) support.
 * Provides structured logging with custom fields like payload, timeDuration, and process status.
 * 
 * <p>This logger automatically manages MDC fields and clears them after each log operation
 * to prevent context pollution across different log statements.</p>
 * 
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>MDC-based contextual logging</li>
 *   <li>Fluent API for chaining log context</li>
 *   <li>Automatic cleanup of MDC fields</li>
 *   <li>Process status tracking</li>
 *   <li>Payload and duration logging support</li>
 * </ul>
 * 
 * <h2>Usage Example:</h2>
 * <pre>{@code
 * Loggy logger = Loggy.loggyFactory(MyClass.class);
 * 
 * // Simple logging
 * logger.info("Processing started");
 * 
 * // Logging with context
 * logger.payload(jsonPayload)
 *       .timeDuration("150ms")
 *       .info("Request processed successfully");
 * 
 * // Change process status
 * logger.changeProcessStatus(ProcessStatus.START);
 * }</pre>
 * 
 * @author Balram Rajak
 * @version 1.0.0
 * @see LogUtils
 * @see ProcessStatus
 */
public class Loggy{

    /** MDC key for payload field */
    private static final String PAYLOAD = "payload";
    
    /** Underlying SLF4J logger instance */
    private Logger logger;

    /**
     * Private constructor to enforce factory pattern.
     * Initializes logger and clears any existing MDC context.
     * 
     * @param logger SLF4J Logger instance for the calling class
     */
    private Loggy(Logger logger){
        LogUtils.clearLog();
        this.logger = logger;
    }

    /**
     * Factory method to create a new Loggy instance.
     * This is the recommended way to obtain a Loggy logger.
     * 
     * @param clazz The class for which logger is created (used for logger name)
     * @return New Loggy instance configured for the specified class
     * 
     * @example
     * <pre>{@code
     * private static final Loggy logger = Loggy.loggyFactory(MyService.class);
     * }</pre>
     */
    public static Loggy loggyFactory(Class<?> clazz){
        return new Loggy(LoggerFactory.getLogger(clazz));
    }

    /**
     * Logs an informational message and automatically clears MDC context.
     * Supports SLF4J parameterized logging for better performance.
     * 
     * @param message Log message with optional {} placeholders
     * @param parameters Values to substitute in message placeholders
     * 
     * @example
     * <pre>{@code
     * logger.info("User {} logged in from IP {}", username, ipAddress);
     * }</pre>
     */
    public void info(String message, Object... parameters){
        LogUtils.logMessage(logger, Level.INFO, message,parameters);
        LogUtils.clearLog();
    }

    /**
     * Logs an error message and automatically clears MDC context.
     * Supports SLF4J parameterized logging for better performance.
     * 
     * @param message Log message with optional {} placeholders
     * @param parameters Values to substitute in message placeholders
     * 
     * @example
     * <pre>{@code
     * logger.error("Failed to process order {}: {}", orderId, exception.getMessage());
     * }</pre>
     */
    public void error(String message, Object... parameters){
        LogUtils.logMessage(logger, Level.ERROR, message,parameters);
        LogUtils.clearLog();
    }

    /**
     * Sets the time duration in MDC for the next log statement.
     * Returns this instance for method chaining (fluent API).
     * 
     * @param timeDuration Time duration as string (e.g., "150ms", "2.5s", "500 milliseconds")
     * @return This Loggy instance for method chaining
     * 
     * @example
     * <pre>{@code
     * logger.timeDuration("150ms").info("Request completed");
     * }</pre>
     */
    public Loggy timeDuartion( String timeDuration){
        MDC.put("timeDuration",timeDuration);
        return this;
    }

    /**
     * Sets the payload in MDC for the next log statement.
     * Returns this instance for method chaining (fluent API).
     * Useful for logging request/response bodies or data being processed.
     * 
     * @param payload Payload data as string (typically JSON or XML)
     * @return This Loggy instance for method chaining
     * 
     * @example
     * <pre>{@code
     * String jsonPayload = "{\"orderId\": 123, \"status\": \"completed\"}";
     * logger.payload(jsonPayload).info("Order processed");
     * }</pre>
     */
    public Loggy payload(String payload){
        MDC.put(PAYLOAD,payload);
        return this;
    }
    
    /**
     * Changes the current process status in MDC.
     * Status persists across log statements until explicitly changed again.
     * Useful for tracking application lifecycle and processing stages.
     * 
     * @param status ProcessStatus enum value (START, INTERMEDIATE, END)
     * 
     * @example
     * <pre>{@code
     * logger.changeProcessStatus(ProcessStatus.START);
     * // ... processing ...
     * logger.changeProcessStatus(ProcessStatus.INTERMEDIATE);
     * // ... more processing ...
     * logger.changeProcessStatus(ProcessStatus.END);
     * }</pre>
     * 
     * @see ProcessStatus
     */
    public void changeProcessStatus(ProcessStatus status){
        MDC.put(LogUtils.STATUS, status.getStatus());
    }
	
}
