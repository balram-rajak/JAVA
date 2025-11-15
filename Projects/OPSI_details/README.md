# OPSI Details Fetcher

## 📋 Project Overview

A Spring Boot command-line application that fetches **OPSI** (Organization, Party, Site, Individual) entity details from **Reltio MDM (Master Data Management)** platform. The application demonstrates OAuth 2.0 authentication, RESTful API consumption, and functional programming patterns using Java 8.

## 💡 Concept & Purpose

This project serves as a practical implementation of:
- OAuth 2.0 client credentials flow for API authentication
- RESTful API integration using Spring's RestTemplate
- Functional programming with Java 8 functional interfaces
- Command-line application using Spring Boot CommandLineRunner
- JSON processing and file I/O operations
- External configuration management with Spring properties

## 🏗️ Project Structure

```
OPSI_details/
├── pom.xml                                      # Maven configuration
└── src/
    ├── main/
    │   ├── java/com/mdm/OPSI_details/
    │   │   ├── OpsiDetailsApplication.java     # Main application class
    │   │   ├── Token.java                      # OAuth token model
    │   │   ├── OpsiDetails.java                # OPSI entity model
    │   │   ├── JsonObj.java                    # JSON utility
    │   │   └── mdm.java                        # MDM utility
    │   └── resources/
    │       └── application.properties          # Configuration file
    └── test/
        └── java/com/mdm/OPSI_details/
            └── OpsiDetailsApplicationTests.java
```

## 🔄 Execution Flow

```
┌────────────────────────────────────────────┐
│   Spring Boot Application Startup         │
└─────────────────┬──────────────────────────┘
                  │
                  ├──► 1. Load Configuration
                  │       Read credentials & OPSI IDs from
                  │       application.properties
                  │
                  ├──► 2. OAuth Authentication
                  │       ┌─────────────────────────┐
                  │       │ getCredentials()        │
                  │       │      ↓                  │
                  │       │ getEncodedCredentials() │
                  │       │      ↓                  │
                  │       │ getTokenRequest()       │
                  │       │      ↓                  │
                  │       │ POST to OAuth API       │
                  │       │      ↓                  │
                  │       │ Receive Access Token    │
                  │       └─────────────────────────┘
                  │
                  ├──► 3. Fetch OPSI Details (Loop)
                  │       For each id.1, id.2, id.3...
                  │       ┌─────────────────────────┐
                  │       │ Build OPSI API Request  │
                  │       │      ↓                  │
                  │       │ Set Bearer Token        │
                  │       │      ↓                  │
                  │       │ GET Entity Details      │
                  │       │      ↓                  │
                  │       │ Parse JSON Response     │
                  │       └─────────────────────────┘
                  │
                  ├──► 4. Save to File
                  │       Format as pretty JSON
                  │       Save as ID-{opsiId}.json
                  │
                  └──► 5. Application Shutdown
                        Close Spring context
```

## 🛠️ Tech Stack

- **Language**: Java 17
- **Framework**: Spring Boot 3.0.1
- **Build Tool**: Maven
- **Key Libraries**:
  - Spring Boot Starter Web (REST client)
  - Spring Boot DevTools (development utilities)
  - Spring Cloud Config Client (configuration management)
  - Jackson (JSON processing)
  - Apache Commons Codec (Base64 encoding)
  - org.json (JSON manipulation)

### Maven Dependencies

```xml
<!-- Spring Boot Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- JSON Processing -->
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20220924</version>
</dependency>

<!-- Spring Cloud Config -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-client</artifactId>
    <version>4.0.0</version>
</dependency>
```

## ⚙️ Configuration

### application.properties

Create or update `src/main/resources/application.properties`:

```properties
# Reltio OAuth Credentials
reltio.uname=your_client_id
reltio.pass=your_client_secret

# OPSI IDs to fetch (sequential numbering)
id.1=12345
id.2=67890
id.3=54321
# Add more as needed: id.4, id.5, etc.

# Output directory (update in code)
output.dir=/path/to/output/directory
```

### File Path Configuration

Update the hardcoded output path in `OpsiDetailsApplication.java` (line 120):

```java
String opsiFileName = String.format("/path/to/your/output/ID-%s.json", OpsiId);
```

Replace `/path/to/your/output/` with your desired output directory.

## 🚀 How to Run

### Prerequisites

- Java JDK 17 or higher
- Apache Maven 3.6+
- Reltio MDM account with API access
- Valid OAuth 2.0 client credentials

### Build the Project

```bash
# Navigate to project directory
cd OPSI_details

# Clean and build
mvn clean package
```

### Run the Application

```bash
# Run with Maven
mvn spring-boot:run

# Or run the JAR directly
java -jar target/OPSI_details-0.0.1-SNAPSHOT.jar
```

### Expected Output

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

2024-01-15 10:30:45.123  INFO --- OpsiDetailsApplication : Started OpsiDetailsApplication
2024-01-15 10:30:47.456  INFO --- OpsiDetailsApplication : Opsi_done: 12345
2024-01-15 10:30:49.789  INFO --- OpsiDetailsApplication : Opsi_done: 67890
2024-01-15 10:30:52.012  INFO --- OpsiDetailsApplication : Opsi_done: 54321
```

Output JSON files will be created:
- `ID-12345.json`
- `ID-67890.json`
- `ID-54321.json`

## 📊 API Integration Details

### 1. OAuth Token Endpoint

**URL**: `https://auth.reltio.com/oauth/token`  
**Method**: POST  
**Authentication**: Basic Auth (Base64 encoded credentials)  
**Content-Type**: application/x-www-form-urlencoded

**Request Body**:
```
grant_type=client_credentials
```

**Response**:
```json
{
    "access_token": "eyJhbGc...",
    "token_type": "Bearer",
    "expires_in": 3600
}
```

### 2. OPSI Details Endpoint

**URL**: `https://test.reltio.com/reltio/api/{tenantId}/entities`  
**Method**: GET  
**Authentication**: Bearer Token  
**Query Parameters**:
```
filter=(equals(type,'configuration/entityTypes/OPSI') and equals(attributes.ID,{opsiId}))
preserveURIs=true
```

**Response**: JSON object containing OPSI entity details

## 🎯 Key Features & Functional Programming

### Functional Interfaces Used

1. **Function<Environment, String>**: Extract and format credentials
2. **UnaryOperator<String>**: Encode credentials to Base64
3. **BiFunction**: Execute HTTP requests and return responses
4. **Predicate**: Validate OPSI ID existence
5. **BiPredicate**: Save data to file and return status

### Example: Function Composition

```java
String token = getToken.andThen(getTokenCode)
    .apply(
        getCredentials
            .andThen(getEncodedCredentials)
            .andThen(getTokenAuthorisationHeaders)
            .andThen(getTokenRequest)
            .apply(environment), 
        OpsiTemplate
    );
```

This chains multiple operations:
1. Get credentials from environment
2. Encode credentials with Base64
3. Create authorization headers
4. Build token request entity
5. Make API call to get token
6. Extract access token string

## 📝 Output Format

Each OPSI entity is saved as a formatted JSON file:

```json
{
  "uri": "entities/ABC123",
  "type": "configuration/entityTypes/OPSI",
  "attributes": {
    "ID": [{
      "value": "12345"
    }],
    "Name": [{
      "value": "Example Organization"
    }]
  },
  "crosswalks": [...],
  "references": [...]
}
```

## 🔒 Security Considerations

**⚠️ Important Security Notes:**

1. **Credentials Storage**: Never commit `application.properties` with real credentials to version control
2. **Environment Variables**: Use environment variables for sensitive data:
   ```bash
   export RELTIO_USERNAME=your_username
   export RELTIO_PASSWORD=your_password
   ```
3. **Properties Encryption**: Consider using Spring Cloud Config with encryption
4. **Token Management**: Implement token caching and refresh logic for production use
5. **HTTPS Only**: Always use HTTPS endpoints for API calls

## 🔧 Troubleshooting

### Common Issues

1. **401 Unauthorized**
   - Verify client credentials in application.properties
   - Check if OAuth client has required permissions

2. **404 Not Found**
   - Verify OPSI IDs exist in Reltio MDM
   - Check tenant ID in API URL

3. **FileNotFoundException**
   - Ensure output directory exists
   - Update hardcoded path in code
   - Check write permissions

4. **Connection Timeout**
   - Check network connectivity
   - Verify API endpoints are accessible
   - Consider increasing timeout settings

## 🎓 Learning Outcomes

This project demonstrates:

1. **OAuth 2.0 Client**: Implementing client credentials flow
2. **REST API Consumption**: Using Spring RestTemplate
3. **Functional Programming**: Leveraging Java 8 functional interfaces
4. **Spring Boot CLI**: Creating command-line applications
5. **Configuration Management**: Externalizing configuration
6. **Error Handling**: Graceful error management with try-catch
7. **File I/O**: Writing formatted JSON to files
8. **Function Composition**: Chaining operations for clean code

---

**Author**: Balram Rajak  
**Purpose**: Reltio MDM Integration - OPSI Data Extraction  
**Status**: Development/Integration Project
