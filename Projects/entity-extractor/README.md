# MDM Entity Extractor

## 📋 Project Overview

A configurable Spring Boot command-line application for extracting entity details from **Reltio MDM (Master Data Management)** platform. This is an enhanced version of the OPSI Details Fetcher with parameterized API URLs, making it more flexible and reusable for different entity types.

## 💡 Concept & Purpose

This project demonstrates:
- Parameterized API URL configuration using Spring properties
- OAuth 2.0 authentication for external APIs
- Generic entity extraction from Reltio MDM
- Functional programming with Java 8
- Configuration-driven application design

## 🏗️ Project Structure

```
entity-extractor/
├── pom.xml                                     # Maven configuration
└── src/
    ├── main/
    │   ├── java/com/balram/org/
    │   │   ├── OpsiDetailsApplication.java    # Main application class
    │   │   ├── Token.java                     # OAuth token model
    │   │   ├── OpsiDetails.java               # Entity model (reusable)
    │   │   └── ResponsePojo.java              # Response wrapper
    │   └── resources/
    │       └── application.properties         # Configuration file
    └── test/
        └── java/com/balram/org/
            └── OpsiDetailsApplicationTests.java
```

## 🔄 Key Difference from OPSI_details

The main enhancement in this project is the **parameterized API URL**:

### OPSI_details (Hardcoded URL)
```java
return OpsiTemplate.exchange(
    "https://test.reltio.com/reltio/api/287t46vb8oiudXlt/entities?filter=" +
    "(equals(type,'configuration/entityTypes/OPSI') and equals(attributes.ID," + 
    OpsiId + ")),preserveURIs",
    HttpMethod.GET, t, String.class
);
```

### entity-extractor (Configurable URL)
```java
@Value("${api.url}")
String url;

return OpsiTemplate.exchange(
    String.format(url, OpsiId),  // URL pattern from properties
    HttpMethod.GET, t, String.class
);
```

## ⚙️ Configuration

### application.properties

```properties
# Reltio OAuth Credentials
reltio.uname=your_client_id
reltio.pass=your_client_secret

# Configurable API URL Pattern
# Use %s as placeholder for entity ID
api.url=https://test.reltio.com/reltio/api/{tenantId}/entities?filter=(equals(type,'configuration/entityTypes/Organization') and equals(attributes.OrgID,%s))&preserveURIs=true

# Entity IDs to fetch (sequential numbering)
id.1=ORG001
id.2=ORG002
id.3=ORG003
# Add more as needed: id.4, id.5, etc.
```

## 🛠️ Tech Stack

- **Language**: Java 17
- **Framework**: Spring Boot 3.0.1
- **Build Tool**: Maven
- **Key Libraries**: Same as OPSI_details project
  - Spring Boot Starter Web
  - Spring Cloud Config Client
  - Jackson & org.json

## 🚀 How to Run

### Prerequisites
- Java JDK 17+
- Maven 3.6+
- Reltio MDM account with API access

### Build & Run

```bash
# Build the project
mvn clean package

# Run the application
mvn spring-boot:run

# Or run the JAR
java -jar target/entity-extractor-0.0.1-SNAPSHOT.jar
```

## 📊 Usage Examples

### Example 1: Extract Organizations

```properties
api.url=https://test.reltio.com/reltio/api/tenant123/entities?filter=(equals(type,'configuration/entityTypes/Organization') and equals(attributes.OrgID,%s))&preserveURIs=true

id.1=ORG001
id.2=ORG002
```

### Example 2: Extract Parties

```properties
api.url=https://test.reltio.com/reltio/api/tenant123/entities?filter=(equals(type,'configuration/entityTypes/Party') and equals(attributes.PartyID,%s))&preserveURIs=true

id.1=PARTY001
id.2=PARTY002
```

### Example 3: Extract Sites

```properties
api.url=https://test.reltio.com/reltio/api/tenant123/entities?filter=(equals(type,'configuration/entityTypes/Site') and equals(attributes.SiteID,%s))&preserveURIs=true

id.1=SITE001
id.2=SITE002
```

## 🎯 Key Benefits

### 1. **Flexibility**
- Single codebase for multiple entity types
- Easy configuration changes without code modification

### 2. **Reusability**
- Can be used for any Reltio MDM entity type
- Just update API URL pattern in properties

### 3. **Maintainability**
- Configuration separated from logic
- Easy to update URLs, tenant IDs, or entity types

### 4. **Environment Support**
- Different configurations for dev, test, prod
- Use Spring profiles for environment-specific settings

## 📝 Output

Generated JSON files follow the same format as OPSI_details:
- Pretty-printed JSON
- Named as: `ID-{entityId}.json` (update path in code line 120)

## 🔧 Customization

To adapt for different entity types:

1. **Update API URL in properties**:
   ```properties
   api.url=https://{environment}.reltio.com/reltio/api/{tenant}/entities?filter=(equals(type,'{entityType}') and equals(attributes.{attributeName},%s))&preserveURIs=true
   ```

2. **Replace placeholders**:
   - `{environment}`: dev, test, prod
   - `{tenant}`: Your Reltio tenant ID
   - `{entityType}`: Organization, Party, Site, Individual, etc.
   - `{attributeName}`: ID field name for the entity

3. **Update entity IDs**:
   ```properties
   id.1=first_entity_id
   id.2=second_entity_id
   ```

## 🔒 Security

Same security considerations as OPSI_details project:
- Use environment variables for credentials
- Never commit real credentials to version control
- Implement token caching for production
- Use HTTPS endpoints only

## 📚 Related Projects

- **OPSI_details**: Hardcoded version for OPSI entities
- **Modular_partner-change-validator**: Integration with validation services

---

**Author**: Balram Rajak  
**Purpose**: Configurable Reltio MDM Entity Extraction  
**Status**: Development/Integration Project
