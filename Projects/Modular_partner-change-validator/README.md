# AWS SQS Message Processor - Partner Change Validator

## 📋 Project Overview

A **modular Spring Boot microservice** that processes partner change request messages from **AWS SQS (Simple Queue Service)**, validates the changes, and saves them to a **Microsoft SQL Server** database. The project demonstrates enterprise-grade microservice architecture with AWS integration, multi-module Maven structure, and custom logging.

## 💡 Concept & Purpose

This project showcases:
- **Microservices Architecture**: Multi-module Maven project with separated concerns
- **AWS Integration**: SQS message queue processing
- **Database Operations**: Dynamic datasource creation and JPA persistence
- **API Integration**: RESTful API calls using OpenFeign
- **Custom Logging**: Integration with custom loggy library
- **Configuration Management**: Externalized configuration with Spring Cloud Config
- **Security**: AWS Secrets Manager for credential management

## 🏗️ Project Structure

```
Modular_partner-change-validator/
├── pom.xml                               # Parent POM
├── validator-save-api/                   # Main service module
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   ├── java/com/balram/custom/
│       │   │   ├── Application.java           # Main Spring Boot app
│       │   │   ├── controller/
│       │   │   │   ├── ValidatorSaver.java    # Controller interface
│       │   │   │   └── impl/
│       │   │   │       └── ValidatorController.java
│       │   │   ├── service/
│       │   │   │   └── sqs/
│       │   │   │       ├── MessageStreamReader.java   # SQS consumer
│       │   │   │       └── QueryFormator.java         # Query builder
│       │   │   ├── model/
│       │   │   │   └── MessageRecorder.java   # Data model
│       │   │   └── config/
│       │   │       ├── DataSourceCreation.java
│       │   │       └── impl/
│       │   │           ├── DataSourceCreationImpl.java
│       │   │           ├── AppConfig.java
│       │   │           ├── HeaderInterceptor.java
│       │   │           └── HeaderInterceptorAppConfig.java
│       │   └── resources/
│       │       ├── application.properties
│       │       └── application-dev.properties
│       └── test/
│           └── java/com/balram/custom/
│               └── ApplicationTests.java
└── api-call/                             # API module
    ├── pom.xml
    └── src/
        └── main/
            └── java/com/balram/custom/service/api/
                ├── RestApiCall.java          # API interface
                └── impl/
                    ├── ApiCall.java          # GET/POST operations
                    └── UpdateCall.java       # PUT/PATCH operations
```

## 🔄 Execution Flow

```
┌─────────────────────────────────────────────────────┐
│           Application Startup                       │
│   ┌──────────────────────────────────────────┐    │
│   │ 1. Load AWS Secrets                      │    │
│   │    (Database credentials, Config server) │    │
│   │                                           │    │
│   │ 2. Initialize Spring Cloud Config Client │    │
│   │                                           │    │
│   │ 3. Create Dynamic DataSource              │    │
│   │    (SQL Server connection)                │    │
│   │                                           │    │
│   │ 4. Start SQS Message Listener            │    │
│   └──────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────┘
                        │
                        ▼
┌─────────────────────────────────────────────────────┐
│          Message Processing Loop                    │
│                                                     │
│   ┌──► Read Message from SQS Queue                │
│   │         │                                      │
│   │         ▼                                      │
│   │    Parse JSON Message                         │
│   │         │                                      │
│   │         ▼                                      │
│   │    Validate Partner Change Request            │
│   │         │                                      │
│   │         ▼                                      │
│   │    Transform to MessageRecorder Entity        │
│   │         │                                      │
│   │         ▼                                      │
│   │    Save to SQL Server Database                │
│   │         │                                      │
│   │         ▼                                      │
│   │    Acknowledge Message (Delete from SQS)      │
│   │         │                                      │
│   │         ▼                                      │
│   │    Log Success/Failure with Loggy             │
│   │         │                                      │
│   └─────────┘                                      │
│                                                     │
└─────────────────────────────────────────────────────┘
                        │
                        ▼
          ┌───────────────────────────┐
          │   Optional: API Calls      │
          │   (api-call module)        │
          │   - GET: Fetch data        │
          │   - POST: Submit data      │
          │   - PUT: Update data       │
          │   - PATCH: Partial update  │
          └───────────────────────────┘
```

## 🛠️ Tech Stack

### Core Framework
- **Language**: Java 17
- **Framework**: Spring Boot 3.4.3
- **Build Tool**: Maven (Multi-module)
- **Packaging**: Multi-module project (pom)

### Key Dependencies

#### Spring Boot Starters
- `spring-boot-starter-web` - REST API support
- `spring-boot-starter-data-jpa` - Database persistence
- `spring-cloud-starter-openfeign` - Declarative REST client
- `spring-boot-devtools` - Development utilities

#### AWS Integration
- `aws-java-sdk-secretsmanager` (1.12.750) - Secrets management
- `sqs` (2.30.36) - SQS message queue client

#### Database
- `mssql-jdbc` - Microsoft SQL Server driver
- JPA/Hibernate - ORM framework

#### Custom Libraries
- `loggy` (1.0.0) - Custom logging library (from Libraries/loggy)

#### Utilities
- `json` (20240303) - JSON processing
- `lombok` - Reduce boilerplate code
- `mockito-core` - Testing framework

## ⚙️ Configuration

### 1. AWS Secrets Manager Setup

Store database credentials and config server URL in AWS Secrets Manager:

```json
{
  "db.url": "jdbc:sqlserver://your-server:1433;databaseName=your_db",
  "db.username": "your_username",
  "db.password": "your_password",
  "configserver.url": "config-server:http://config-server-url:8888"
}
```

### 2. application.properties

```properties
# Application Name
spring.application.name=message-processor

# AWS SQS Configuration
aws.sqs.queue.url=https://sqs.{region}.amazonaws.com/{account-id}/{queue-name}
aws.sqs.region=us-east-1

# Spring Cloud Config
spring.cloud.config.enabled=true
spring.cloud.config.uri=${configserver.url}

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Logging
logging.level.com.balram.custom=DEBUG
```

### 3. application-dev.properties

```properties
# Development-specific configurations
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Debug logging
logging.level.root=INFO
logging.level.com.balram.custom=DEBUG
```

## 🚀 How to Build & Run

### Prerequisites

- Java JDK 17+
- Apache Maven 3.8+
- AWS Account with SQS and Secrets Manager access
- Microsoft SQL Server instance
- AWS CLI configured with appropriate credentials

### Build the Project

```bash
# Navigate to project root
cd Modular_partner-change-validator

# Clean and build all modules
mvn clean install

# Build specific module
cd validator-save-api
mvn clean package
```

### Run the Application

#### Option 1: Using Maven

```bash
cd validator-save-api
mvn spring-boot:run
```

#### Option 2: Using JAR

```bash
cd validator-save-api/target
java -jar validator-save-api-1.0.0.jar
```

#### Option 3: With Profile

```bash
# Run with dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Or with JAR
java -jar validator-save-api-1.0.0.jar --spring.profiles.active=dev
```

## 📊 Module Details

### Module 1: validator-save-api

**Purpose**: Main service for processing SQS messages and persisting to database

**Key Components**:

1. **Application.java**: Entry point with AWS Secrets integration
2. **MessageStreamReader**: Polls and reads messages from SQS
3. **ValidatorController**: REST endpoints for validation
4. **MessageRecorder**: JPA entity for database persistence
5. **DataSourceCreationImpl**: Dynamic datasource configuration
6. **QueryFormator**: SQL query builder

**Endpoints**:
```
POST /api/validate - Validate partner change request
GET  /api/status   - Check service health
```

### Module 2: api-call

**Purpose**: Reusable module for external API calls

**Key Components**:

1. **RestApiCall**: Interface defining API operations
2. **ApiCall**: Implementation for GET and POST
3. **UpdateCall**: Implementation for PUT and PATCH

**Usage Example**:
```java
@Autowired
private RestApiCall apiCall;

// GET request
ResponseEntity<String> response = apiCall.get(url, headers);

// POST request
ResponseEntity<String> response = apiCall.post(url, body, headers);
```

## 🔐 Security Features

1. **AWS Secrets Manager**: Secure credential storage
2. **Environment-based Configuration**: Separate configs for dev/test/prod
3. **HTTP Header Interceptor**: Custom header management for API calls
4. **Database Connection Security**: Encrypted connection strings

## 📝 Data Model

### MessageRecorder Entity

```java
@Entity
@Table(name = "partner_changes")
public class MessageRecorder {
    @Id
    @GeneratedValue
    private Long id;
    
    private String partnerId;
    private String changeType;
    private String changeData;
    private LocalDateTime timestamp;
    private String status;
    
    // Getters, setters, constructors
}
```

## 🎯 Key Features

1. **Multi-Module Architecture**: Separated concerns, reusable components
2. **AWS Native**: Full AWS SDK integration
3. **Scheduled Processing**: Spring scheduling for periodic tasks
4. **Custom Logging**: Structured logging with loggy library
5. **Dynamic Configuration**: Spring Cloud Config for centralized configuration
6. **OpenFeign Integration**: Declarative REST clients
7. **Database Agnostic Design**: Easy to switch database vendors

## 🔧 Troubleshooting

### Common Issues

1. **SQS Connection Failed**
   - Check AWS credentials
   - Verify SQS queue URL and permissions
   - Ensure AWS region is correct

2. **Database Connection Error**
   - Verify secrets in AWS Secrets Manager
   - Check SQL Server accessibility
   - Validate JDBC URL format

3. **Secrets Manager Access Denied**
   - Check IAM permissions
   - Verify AWS CLI configuration
   - Ensure secret name is correct

4. **Module Dependency Issues**
   - Run `mvn clean install` from parent directory
   - Check module versions in parent POM

## 🧪 Testing

```bash
# Run all tests
mvn test

# Run tests for specific module
cd validator-save-api
mvn test

# Run with coverage
mvn test jacoco:report
```

## 📚 Dependencies Between Modules

```
validator-save-api
    ├── api-call (module dependency)
    ├── loggy (external library dependency)
    └── Spring Boot starters
```

## 🔍 Monitoring & Logging

The application uses the custom **loggy** library for structured logging:

```java
private static final Loggy logger = Loggy.loggyFactory(Application.class);

// Log with status
logger.changeProcessStatus(ProcessStatus.START);
logger.info("Processing message: {}", messageId);
logger.error("Failed to process: {}", error);
```

---

**Author**: Balram Rajak  
**Purpose**: Enterprise Microservice - AWS SQS Message Processing  
**Status**: Production-Ready Multi-Module Application  
**Version**: 1.0.0
