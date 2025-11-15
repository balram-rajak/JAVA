# Loggy - Custom Logger Library

## 📋 Overview

**Loggy** is a lightweight, custom logging library built on top of SLF4J and Logback that provides structured logging with MDC (Mapped Diagnostic Context) support. It enables developers to add contextual information like payload data, execution duration, and process status to their logs through a simple and intuitive fluent API.

## 💡 Key Features

- ✅ **MDC-based Contextual Logging**: Automatically manage context across log statements
- ✅ **Fluent API**: Chain methods for cleaner, more readable code
- ✅ **Automatic Cleanup**: MDC fields are automatically cleared after each log operation
- ✅ **Process Status Tracking**: Track application lifecycle stages (START, INTERMEDIATE, END)
- ✅ **Payload Logging**: Easily log request/response bodies or complex data
- ✅ **Duration Tracking**: Log execution time for operations
- ✅ **SLF4J Compatible**: Works seamlessly with existing SLF4J-based logging infrastructure
- ✅ **Zero Configuration**: Works out of the box with sensible defaults

## 🏗️ Project Structure

```
loggy/
├── pom.xml                                    # Maven configuration
└── src/
    ├── main/
    │   ├── java/com/balram/custom/loggy/
    │   │   ├── Loggy.java                    # Main logger class
    │   │   ├── status/
    │   │   │   └── ProcessStatus.java        # Process status enum
    │   │   └── utils/
    │   │       └── LogUtils.java             # Utility methods
    │   └── resources/
    │       └── application.properties        # Configuration (optional)
    └── test/
        └── java/com/br/loggable/
            └── LoggableApplicationTests.java # Unit tests
```

## 🛠️ Tech Stack

- **Language**: Java 17
- **Build Tool**: Maven
- **Logging Framework**: SLF4J 2.1.0-alpha1
- **Logging Implementation**: Logback 1.5.17
- **Code Generation**: Lombok 1.18.22

## 📦 Installation & Setup

### Maven Dependency

Add the following dependency to your project's `pom.xml`:

```xml
<dependency>
    <groupId>com.balram.custom</groupId>
    <artifactId>loggy</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Build from Source

```bash
# Clone or navigate to the library
cd Libraries/loggy

# Clean and install to local Maven repository
mvn clean install

# This will install the artifact:
# - GroupId: com.balram.custom
# - ArtifactId: loggy
# - Version: 1.0.0
```

After installation, the library will be available in your local Maven repository at:
```
~/.m2/repository/com/balram/custom/loggy/1.0.0/loggy-1.0.0.jar
```

### Gradle Dependency

If using Gradle, add:

```gradle
dependencies {
    implementation 'com.balram.custom:loggy:1.0.0'
}
```

## 🚀 Usage Guide

### Basic Setup

#### 1. Create Logger Instance

```java
import com.balram.custom.loggy.Loggy;

public class MyService {
    // Create logger instance for your class
    private static final Loggy logger = Loggy.loggyFactory(MyService.class);
}
```

#### 2. Simple Logging

```java
// Info level logging
logger.info("User logged in successfully");

// Error level logging
logger.error("Failed to connect to database");

// Parameterized logging (SLF4J style)
logger.info("User {} logged in from IP {}", username, ipAddress);
logger.error("Order {} failed with error: {}", orderId, errorMessage);
```

### Advanced Usage

#### 1. Logging with Payload

```java
String requestJson = "{\"userId\": 123, \"action\": \"purchase\"}";

logger.payload(requestJson)
      .info("Processing user request");

// MDC will include: payload={"userId": 123, "action": "purchase"}
```

#### 2. Logging with Duration

```java
long startTime = System.currentTimeMillis();
// ... perform operation ...
long duration = System.currentTimeMillis() - startTime;

logger.timeDuartion(duration + "ms")
      .info("Operation completed");

// MDC will include: timeDuration=150ms
```

#### 3. Chaining Methods (Fluent API)

```java
String responseJson = "{\"status\": \"success\", \"orderId\": 456}";

logger.payload(responseJson)
      .timeDuartion("250ms")
      .info("Order processed successfully");

// MDC will include both payload and timeDuration
```

#### 4. Process Status Tracking

```java
import com.balram.custom.loggy.status.ProcessStatus;

// At the start of processing
logger.changeProcessStatus(ProcessStatus.START);
logger.info("Starting batch job");

// During processing
logger.changeProcessStatus(ProcessStatus.INTERMEDIATE);
logger.info("Processing record 500 of 1000");

// At completion
logger.changeProcessStatus(ProcessStatus.END);
logger.info("Batch job completed");

// Status persists across log statements until changed
```

### Complete Example

```java
package com.example.service;

import com.balram.custom.loggy.Loggy;
import com.balram.custom.loggy.status.ProcessStatus;

public class OrderService {
    private static final Loggy logger = Loggy.loggyFactory(OrderService.class);
    
    public void processOrder(String orderId, String orderData) {
        logger.changeProcessStatus(ProcessStatus.START);
        logger.info("Starting order processing for orderId: {}", orderId);
        
        try {
            long startTime = System.currentTimeMillis();
            
            // Validate order
            logger.changeProcessStatus(ProcessStatus.INTERMEDIATE);
            logger.payload(orderData)
                  .info("Validating order data");
            
            validateOrder(orderData);
            
            // Process payment
            logger.info("Processing payment for orderId: {}", orderId);
            processPayment(orderId);
            
            // Complete order
            long duration = System.currentTimeMillis() - startTime;
            logger.changeProcessStatus(ProcessStatus.END);
            logger.timeDuartion(duration + "ms")
                  .info("Order processed successfully: {}", orderId);
                  
        } catch (Exception e) {
            logger.changeProcessStatus(ProcessStatus.END);
            logger.error("Order processing failed for orderId: {}, Error: {}", 
                        orderId, e.getMessage());
            throw e;
        }
    }
}
```

## 📊 MDC Fields

Loggy automatically manages the following MDC fields:

| Field Name | Type | Description | Persistence |
|-----------|------|-------------|-------------|
| `payload` | String | Request/response data or any contextual data | Cleared after log |
| `timeDuration` | String | Execution duration | Cleared after log |
| `status` | String | Process status (Start/Intermediate/End) | Persists until changed |

### MDC Cleanup Behavior

- **Automatic**: `payload` and `timeDuration` are automatically cleared after each `info()` or `error()` call
- **Manual**: `status` persists until explicitly changed with `changeProcessStatus()`
- **Thread-Safe**: Each thread has its own MDC context

## 🔧 Configuration

### Logback Configuration (logback.xml)

To fully utilize MDC fields in your log output, configure your `logback.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>
                %d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg 
                [status=%X{status}] [duration=%X{timeDuration}] [payload=%X{payload}]%n
            </pattern>
        </encoder>
    </appender>
    
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>logs/application.log</file>
        <encoder>
            <pattern>
                %d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg 
                [status=%X{status}] [duration=%X{timeDuration}] [payload=%X{payload}]%n
            </pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>logs/application-%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
    </appender>
    
    <root level="INFO">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </root>
</configuration>
```

### Example Log Output

With the above configuration, your logs will look like:

```
2024-01-15 10:30:45.123 [main] INFO  com.example.service.OrderService - Starting order processing for orderId: ORD-12345 [status=Start] [duration=] [payload=]

2024-01-15 10:30:45.234 [main] INFO  com.example.service.OrderService - Validating order data [status=Intermediate] [duration=] [payload={"orderId":"ORD-12345","amount":99.99}]

2024-01-15 10:30:45.789 [main] INFO  com.example.service.OrderService - Order processed successfully: ORD-12345 [status=End] [duration=666ms] [payload=]
```

## 🎯 Use Cases

### 1. Microservices Logging

```java
@RestController
public class UserController {
    private static final Loggy logger = Loggy.loggyFactory(UserController.class);
    
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody String userJson) {
        logger.changeProcessStatus(ProcessStatus.START);
        logger.payload(userJson).info("Creating new user");
        
        User user = userService.create(userJson);
        
        logger.changeProcessStatus(ProcessStatus.END);
        logger.info("User created with ID: {}", user.getId());
        
        return ResponseEntity.ok(user);
    }
}
```

### 2. Batch Processing

```java
public class BatchProcessor {
    private static final Loggy logger = Loggy.loggyFactory(BatchProcessor.class);
    
    public void processBatch(List<Record> records) {
        logger.changeProcessStatus(ProcessStatus.START);
        logger.info("Starting batch processing: {} records", records.size());
        
        for (int i = 0; i < records.size(); i++) {
            logger.changeProcessStatus(ProcessStatus.INTERMEDIATE);
            logger.info("Processing record {} of {}", i + 1, records.size());
            processRecord(records.get(i));
        }
        
        logger.changeProcessStatus(ProcessStatus.END);
        logger.info("Batch processing completed");
    }
}
```

### 3. API Integration

```java
public class ApiClient {
    private static final Loggy logger = Loggy.loggyFactory(ApiClient.class);
    
    public String callExternalApi(String endpoint, String payload) {
        long startTime = System.currentTimeMillis();
        
        logger.payload(payload).info("Calling external API: {}", endpoint);
        
        String response = restTemplate.postForObject(endpoint, payload, String.class);
        
        long duration = System.currentTimeMillis() - startTime;
        logger.payload(response)
              .timeDuartion(duration + "ms")
              .info("Received response from: {}", endpoint);
        
        return response;
    }
}
```

## 📚 API Reference

### Loggy Class

#### Factory Method
- `static Loggy loggyFactory(Class<?> clazz)` - Creates a new Loggy instance

#### Logging Methods
- `void info(String message, Object... parameters)` - Log at INFO level
- `void error(String message, Object... parameters)` - Log at ERROR level

#### Context Methods (Fluent API)
- `Loggy payload(String payload)` - Set payload for next log statement
- `Loggy timeDuartion(String timeDuration)` - Set duration for next log statement
- `void changeProcessStatus(ProcessStatus status)` - Change process status

### ProcessStatus Enum

- `START` - Beginning of a process
- `INTERMEDIATE` - Middle/ongoing stage
- `END` - Completion stage

## 🔒 Thread Safety

Loggy is thread-safe because:
- It uses SLF4J's MDC, which is thread-local
- Each thread maintains its own MDC context
- No shared mutable state in Loggy class

## 📈 Performance Considerations

1. **Lazy Evaluation**: Use SLF4J parameterized logging for better performance
   ```java
   // Good - String concatenation happens only if logging is enabled
   logger.info("User {} logged in", username);
   
   // Bad - String concatenation happens always
   logger.info("User " + username + " logged in");
   ```

2. **Large Payloads**: Be cautious with large payload strings as they're stored in MDC
3. **Cleanup**: Automatic cleanup ensures no memory leaks from MDC

## 🧪 Testing

```java
import org.junit.jupiter.api.Test;
import com.balram.custom.loggy.Loggy;

public class LoggyTest {
    private static final Loggy logger = Loggy.loggyFactory(LoggyTest.class);
    
    @Test
    public void testBasicLogging() {
        logger.info("Test log message");
        // Verify in log output
    }
    
    @Test
    public void testPayloadLogging() {
        String json = "{\"test\": \"data\"}";
        logger.payload(json).info("Test with payload");
        // Verify MDC fields in log output
    }
}
```

## 🤝 Integration Examples

### With Spring Boot

```java
@Service
public class MyService {
    private static final Loggy logger = Loggy.loggyFactory(MyService.class);
    
    @Transactional
    public void performOperation() {
        logger.changeProcessStatus(ProcessStatus.START);
        logger.info("Operation started");
        // ... business logic ...
    }
}
```

### With AWS Lambda

```java
public class MyHandler implements RequestHandler<Map<String, Object>, String> {
    private static final Loggy logger = Loggy.loggyFactory(MyHandler.class);
    
    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        logger.payload(input.toString())
              .info("Lambda invoked");
        // ... process request ...
    }
}
```

## 📝 Dependencies Required in Your Project

When using Loggy, ensure your project includes:

```xml
<dependencies>
    <!-- Loggy library -->
    <dependency>
        <groupId>com.balram.custom</groupId>
        <artifactId>loggy</artifactId>
        <version>1.0.0</version>
    </dependency>
    
    <!-- SLF4J API (if not already included) -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.1.0-alpha1</version>
    </dependency>
    
    <!-- Logback (if not already included) -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.5.17</version>
    </dependency>
</dependencies>
```

## 🔍 Troubleshooting

### Issue: MDC fields not appearing in logs
**Solution**: Ensure your `logback.xml` includes `%X{fieldName}` in the pattern

### Issue: MDC fields from previous log appearing
**Solution**: This shouldn't happen as fields are auto-cleared. Check if you're using `changeProcessStatus()` which persists

### Issue: Class not found exception
**Solution**: Ensure loggy is properly installed in local Maven repo: `mvn clean install`

## 📄 License

This library is part of the JAVA learning repository by Balram Rajak.

---

**Author**: Balram Rajak  
**Version**: 1.0.0  
**Purpose**: Custom structured logging library for Java applications  
**Status**: Production-Ready
