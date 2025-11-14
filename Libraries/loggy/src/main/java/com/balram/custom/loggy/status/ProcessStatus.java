package com.balram.custom.loggy.status;

import lombok.Getter;

/**
 * Enum representing different stages of a process lifecycle.
 * Used with Loggy to track and log the current status of operations.
 * 
 * <p>This enum helps in identifying where in the process flow a particular
 * log statement was generated, making it easier to trace application execution.</p>
 * 
 * <h2>Usage Example:</h2>
 * <pre>{@code
 * // At the beginning of processing
 * logger.changeProcessStatus(ProcessStatus.START);
 * logger.info("Starting order processing");
 * 
 * // During processing
 * logger.changeProcessStatus(ProcessStatus.INTERMEDIATE);
 * logger.info("Validating order data");
 * 
 * // At the end of processing
 * logger.changeProcessStatus(ProcessStatus.END);
 * logger.info("Order processing completed");
 * }</pre>
 * 
 * @author Balram Rajak
 * @version 1.0.0
 */
public enum ProcessStatus {
    /** Initial stage of the process */
    START("Start"),
    
    /** Middle/ongoing stage of the process */
    INTERMEDIATE("Intermediate"),
    
    /** Final/completion stage of the process */
    END("End");

    /**
     * String representation of the process status.
     * This value is stored in MDC for logging.
     */
    @Getter
    private final String status;

    /**
     * Constructor for ProcessStatus enum.
     * 
     * @param status String representation of the status
     */
    ProcessStatus(String status) {
        this.status = status;
    }
}

