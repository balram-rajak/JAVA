# Employee Login Portal

## 📋 Project Overview

A Java-based web application implementing an employee login portal using **Servlets**, **JSP**, **JDBC**, and **MySQL**. This project demonstrates core JavaEE concepts including database connectivity, session management, and MVC-like architecture for user authentication.

## 💡 Concept & Purpose

This project serves as a practical implementation of:
- User authentication and authorization
- Database-driven web applications
- Servlet-JSP integration
- JDBC for database operations
- Properties file-based configuration
- Layered architecture with separation of concerns

## 🏗️ Project Structure

```
Loginportal/
├── pom.xml                           # Maven configuration
└── src/
    └── main/
        ├── java/
        │   ├── Client_side_op.java       # Client operations interface
        │   ├── Employee_Login.java       # Employee login handler
        │   ├── LoginPortal.java          # Main portal class
        │   ├── Operation.java            # Database operations interface
        │   ├── Portal.java               # Base portal interface
        │   ├── Query.java                # SQL query handler
        │   ├── Validator.java            # Credential validator
        │   ├── PassCheck.java            # Password checker
        │   ├── Calling_property.java     # Property loader
        │   ├── com/
        │   │   ├── Logger.java           # Logging utility
        │   │   ├── Loginverification.java # Login servlet
        │   │   └── Mysql_Properties.java # DB config loader
        │   └── resources/
        │       └── mysql.properties      # Database configuration
        └── webapp/
            ├── WEB-INF/
            │   └── web.xml               # Web app configuration
            ├── loginform.jsp             # Login form page
            ├── Register.jsp              # Registration page
            ├── pass_check.jsp            # Password check page
            ├── Wrong_pass.jsp            # Error page
            └── yourportal.jsp            # User portal page
```

## 🔄 Execution Flow

```
┌──────────────────────────────────────────────────┐
│          User Access (Browser)                   │
└───────────────┬──────────────────────────────────┘
                │
                ├──► 1. loginform.jsp
                │       User enters credentials
                │
                ├──► 2. Loginverification Servlet
                │       Receives POST request
                │
                ├──► 3. Validator.Login(username, password)
                │       │
                │       ├──► Mysql_Properties
                │       │    (Loads DB config)
                │       │
                │       ├──► Query.select()
                │       │    (Builds SQL query)
                │       │
                │       └──► Database Query
                │            (Fetches password)
                │
                ├──► 4. Credential Verification
                │       Compares input with DB password
                │
                └──► 5. Response
                      ├─► Success: yourportal.jsp
                      └─► Failure: Wrong_pass.jsp
```

## 🛠️ Tech Stack

- **Language**: Java 17
- **Framework**: JavaEE (Servlets, JSP)
- **Build Tool**: Maven
- **Database**: MySQL 8.0
- **JDBC Driver**: MySQL Connector/J 8.0.31
- **Server**: Apache Tomcat 7+
- **Packaging**: WAR (Web Application Archive)

### Key Dependencies

```xml
<!-- JavaEE Web API -->
<dependency>
    <groupId>javax</groupId>
    <artifactId>javaee-web-api</artifactId>
    <version>6.0</version>
</dependency>

<!-- MySQL Connector -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.31</version>
</dependency>
```

## ⚙️ Configuration

### 1. Database Setup

Create MySQL database and table:

```sql
-- Create database
CREATE DATABASE employee_data;

-- Use database
USE employee_data;

-- Create login table
CREATE TABLE login_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data
INSERT INTO login_details (username, password) 
VALUES ('balram', 'password123');
```

### 2. Update Database Configuration

Edit `src/main/java/resources/mysql.properties`:

```properties
jdbc-url=jdbc:mysql://localhost:3306/employee_data
uname=root
validation=your_password_here
```

**⚠️ Important**: Replace `your_password_here` with your actual MySQL root password.

### 3. Update File Paths

Update the hardcoded path in `Mysql_Properties.java` (line 16):

```java
// Change this path to your project location
new FileInputStream("/path/to/your/project/Loginportal/src/main/java/resources/mysql.properties")
```

## 🚀 How to Run

### Prerequisites

- Java JDK 17 or higher
- Apache Maven 3.6+
- MySQL 8.0+
- Apache Tomcat 7+ or compatible servlet container

### Build & Deploy

```bash
# Navigate to project directory
cd Loginportal

# Clean and build the project
mvn clean package

# Deploy WAR file to Tomcat
# Copy target/Loginportal-0.0.1-SNAPSHOT.war to Tomcat's webapps folder

# Or run with Tomcat Maven plugin
mvn tomcat7:run
```

### Access the Application

Open browser and navigate to:
```
http://localhost:8080/loginform.jsp
```

## 📊 Authentication Flow

### Return Codes

The `Validator.Login()` method returns different status codes:

| Code | Meaning | Description |
|------|---------|-------------|
| +1 | Success | Credentials are valid |
| 0 | Wrong Password | Username exists but password is incorrect |
| -1 | User Not Found | Username doesn't exist in database |
| -2 | SQL Error | Database connection or query error |

### Example Usage

```java
Validator validator = new Validator();
int status = validator.Login("balram", "password123");

switch(status) {
    case 1:
        // Redirect to portal
        break;
    case 0:
        // Show wrong password error
        break;
    case -1:
        // Show user not found error
        break;
    case -2:
        // Show database error
        break;
}
```

## 🔐 Security Considerations

**⚠️ This is a learning project. For production use, implement:**

1. **Password Hashing**: Use BCrypt or similar for password storage
2. **SQL Injection Prevention**: Use PreparedStatement (already implemented)
3. **HTTPS**: Use SSL/TLS for secure communication
4. **Session Management**: Implement proper session handling
5. **Input Validation**: Validate all user inputs
6. **Configuration Security**: Don't hardcode credentials; use environment variables

## 📁 Key Files Description

- **Validator.java**: Core authentication logic with database queries
- **Mysql_Properties.java**: Loads database configuration from properties file
- **Loginverification.java**: Servlet handling HTTP requests for login
- **Query.java**: SQL query builder for database operations
- **loginform.jsp**: User interface for login
- **mysql.properties**: Database connection configuration

## 🎯 Key Learning Points

1. **Servlet-JSP Architecture**: Request handling and view rendering
2. **JDBC Operations**: Database connectivity and query execution
3. **Properties File**: External configuration management
4. **MVC Pattern**: Separation of concerns (Model-View-Controller)
5. **Error Handling**: Graceful error management with try-catch
6. **Maven Build**: Project dependency and build management

## 🔧 Troubleshooting

### Common Issues

1. **ClassNotFoundException: com.mysql.cj.jdbc.Driver**
   - Ensure MySQL connector is in classpath
   - Run `mvn clean install`

2. **SQLException: Access denied**
   - Verify MySQL credentials in mysql.properties
   - Check MySQL user permissions

3. **FileNotFoundException: mysql.properties**
   - Update the hardcoded path in Mysql_Properties.java
   - Ensure file exists at specified location

4. **Port already in use**
   - Change Tomcat port in server.xml
   - Or stop existing Tomcat instance

---

**Author**: Balram Rajak  
**Purpose**: Educational - JavaEE Web Application with JDBC  
**Status**: Development/Learning Project
