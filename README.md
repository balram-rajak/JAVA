# ☕ Java Learning Repository

> **A comprehensive collection of Java projects, concepts, and custom libraries for learning and reference**

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Repository Structure](#-repository-structure)
- [Projects](#-projects)
- [Concepts](#-concepts)
- [Libraries](#-libraries)
- [Quick Start](#-quick-start)
- [Navigation Guide](#-navigation-guide)
- [Best Use Cases](#-best-use-cases)
- [Learning Path](#-learning-path)
- [Contributing](#-contributing)

---

## 🌟 Overview

This repository is a **comprehensive learning resource** for Java developers at all levels, from beginners to advanced practitioners. It contains real-world projects, conceptual implementations, and custom libraries that demonstrate modern Java development practices, design patterns, and enterprise-grade application architecture.

### What You'll Find Here:

- **5 Production-Grade Projects**: Full-stack web apps, microservices, and API integrations
- **125+ Concept Examples**: Collections, Java 8+, Design Patterns, and more
- **Custom Logging Library**: Reusable MDC-based structured logging solution
- **Complete Documentation**: Every project and concept thoroughly documented

### Technologies Covered:

`Java 17` • `Spring Boot` • `JavaEE` • `Maven` • `AWS` • `MySQL` • `SQL Server` • `REST APIs` • `OAuth 2.0` • `JPA/Hibernate` • `Servlets/JSP` • `Lambda Expressions` • `Stream API` • `Design Patterns` • `Microservices`

---

## 📁 Repository Structure

```
JAVA/
├── 📂 Projects/                    # Production-ready applications
│   ├── Loginportal/               # JavaEE web application with MySQL
│   ├── employee_record_pr1/       # Java 8 functional programming demo
│   ├── OPSI_details/              # Reltio MDM integration
│   ├── entity-extractor/          # Configurable entity extractor
│   └── Modular_partner-change-validator/  # AWS SQS microservice
│
├── 📂 Concepts/                    # 125+ learning examples
│   ├── Collections_JAVA8/         # Collections & Java 8+ features (114 files)
│   ├── DesignPatterns/            # Singleton, Builder patterns
│   ├── I_O/                       # File I/O operations
│   ├── Strings/                   # String manipulation
│   ├── exception/                 # Exception handling
│   └── garbagecollector/          # Memory management
│
├── 📂 Libraries/                   # Custom reusable libraries
│   └── loggy/                     # MDC-based structured logger
│
├── LICENSE                         # Repository license
└── README.md                       # This file
```

---

## 🚀 Projects

### Overview Matrix

| Project | Type | Tech Stack | Complexity | Description |
|---------|------|------------|------------|-------------|
| **[Loginportal](Projects/Loginportal/)** | Web App | JavaEE, Servlets, JSP, MySQL | ⭐⭐ Intermediate | Employee authentication portal with database integration |
| **[employee_record_pr1](Projects/employee_record_pr1/)** | Console App | Java 8, Predicates, Streams | ⭐ Beginner | Functional programming with employee filtering |
| **[OPSI_details](Projects/OPSI_details/)** | CLI | Spring Boot, OAuth 2.0, REST | ⭐⭐⭐ Advanced | Reltio MDM API integration for entity extraction |
| **[entity-extractor](Projects/entity-extractor/)** | CLI | Spring Boot, REST, Config | ⭐⭐⭐ Advanced | Configurable entity extraction from Reltio MDM |
| **[Modular_partner-change-validator](Projects/Modular_partner-change-validator/)** | Microservice | Spring Boot, AWS SQS, SQL Server | ⭐⭐⭐⭐ Expert | Multi-module message processing service |

### 1. 🔐 Loginportal
**JavaEE Web Application with MySQL Integration**

A complete employee login portal demonstrating:
- Servlet-JSP architecture
- JDBC database operations
- Session management
- Properties-based configuration

**Tech**: JavaEE 6, MySQL 8, Maven, Tomcat 7+

[📖 Full Documentation](Projects/Loginportal/README.md)

---

### 2. 👥 employee_record_pr1
**Java 8 Functional Programming Demo**

Showcases modern Java features:
- Lambda expressions & method references
- Predicate composition
- Custom functional interfaces
- Stream API operations

**Tech**: Java 8+, Predicates, Streams, Lambdas

[📖 Full Documentation](Projects/employee_record_pr1/README.md)

---

### 3. 🔗 OPSI_details
**Reltio MDM Integration**

Production-grade API integration:
- OAuth 2.0 authentication
- RESTful API consumption
- Functional programming patterns
- JSON processing & file I/O

**Tech**: Spring Boot 3, OAuth 2.0, RestTemplate, Jackson

[📖 Full Documentation](Projects/OPSI_details/README.md)

---

### 4. 🔧 entity-extractor
**Configurable Entity Extractor**

Enhanced version with:
- Parameterized API URLs
- Spring Cloud Config
- Environment-based configuration
- Reusable for any entity type

**Tech**: Spring Boot 3, Spring Cloud Config, REST

[📖 Full Documentation](Projects/entity-extractor/README.md)

---

### 5. ☁️ Modular_partner-change-validator
**AWS-based Microservice**

Enterprise microservice architecture:
- Multi-module Maven project
- AWS SQS message processing
- SQL Server persistence
- Custom logging integration
- AWS Secrets Manager

**Tech**: Spring Boot 3.4, AWS SDK, OpenFeign, JPA, Loggy

[📖 Full Documentation](Projects/Modular_partner-change-validator/README.md)

---

## 💡 Concepts

**125+ Examples Covering Core to Advanced Java Topics**

### Quick Overview

| Module | Files | Topics | Level |
|--------|-------|--------|-------|
| **Collections_JAVA8** | 114 | Lists, Sets, Maps, Streams, Lambdas, Functional Interfaces | Beginner to Advanced |
| **DesignPatterns** | 6 | Singleton, Builder | Intermediate |
| **I_O** | 1 | BufferedReader, File Operations | Beginner |
| **Strings** | 1 | String Manipulation | Beginner |
| **exception** | 2 | Custom Exceptions, Error Handling | Beginner |
| **garbagecollector** | 1 | Memory Management | Intermediate |

### 📦 Collections_JAVA8 (114 Files)

The most comprehensive module covering:

#### Core Collections
- `List`: ArrayList, LinkedList, Vector
- `Set`: HashSet, TreeSet, LinkedHashSet
- `Map`: HashMap, TreeMap, LinkedHashMap, ConcurrentHashMap
- `Queue`: PriorityQueue, Deque, BlockingQueue

#### Java 8+ Features
- **Lambda Expressions**: Concise functional code
- **Stream API**: filter, map, reduce, collect, flatMap
- **Functional Interfaces**: Predicate, Function, Consumer, Supplier, BiFunction
- **Method References**: Static, Instance, Constructor references
- **Optional**: Null-safe programming
- **Date-Time API**: LocalDate, LocalDateTime, ZonedDateTime

#### Advanced Topics
- **Generics**: Type-safe collections, bounded types, wildcards
- **Inner Classes**: Normal, Static, Anonymous, Local
- **String Operations**: StringBuilder, StringBuffer, String pool
- **Regular Expressions**: Pattern matching, text processing

[📖 Full Concepts Documentation](Concepts/README.md)

---

## 📚 Libraries

### 🪵 Loggy - Custom Structured Logger

**Production-ready logging library with MDC support**

#### Key Features:
- ✅ **Fluent API**: Chain methods for clean code
- ✅ **MDC Context**: Automatic contextual field management
- ✅ **Process Tracking**: START, INTERMEDIATE, END status
- ✅ **Payload Logging**: Log request/response data
- ✅ **Duration Tracking**: Measure execution time
- ✅ **Auto Cleanup**: Prevents context pollution
- ✅ **Thread-Safe**: Leverages SLF4J's thread-local MDC

#### Quick Example:

```java
import com.balram.custom.loggy.Loggy;

private static final Loggy logger = Loggy.loggyFactory(MyClass.class);

// Simple logging
logger.info("User logged in");

// Contextual logging with fluent API
logger.payload(requestJson)
      .timeDuartion("150ms")
      .info("Request processed");

// Process status tracking
logger.changeProcessStatus(ProcessStatus.START);
logger.info("Beginning batch process");
```

#### Installation:

```bash
cd Libraries/loggy
mvn clean install
```

Add to your project:
```xml
<dependency>
    <groupId>com.balram.custom</groupId>
    <artifactId>loggy</artifactId>
    <version>1.0.0</version>
</dependency>
```

[📖 Complete Loggy Documentation](Libraries/loggy/README.md)

---

## 🏁 Quick Start

### Prerequisites

- **Java JDK 17+**: [Download](https://www.oracle.com/java/technologies/downloads/)
- **Apache Maven 3.6+**: [Download](https://maven.apache.org/download.cgi)
- **Git**: [Download](https://git-scm.com/downloads)
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code

### Clone & Explore

```bash
# Clone the repository
git clone https://github.com/balram-rajak/JAVA.git
cd JAVA

# Explore structure
ls -la

# Build a project
cd Projects/employee_record_pr1/src
javac com/*.java functionality/*.java
java com.Employee_data

# Install loggy library
cd ../../Libraries/loggy
mvn clean install

# Build a Maven project
cd ../../Projects/OPSI_details
mvn clean package
java -jar target/OPSI_details-0.0.1-SNAPSHOT.jar
```

---

## 🧭 Navigation Guide

### For Beginners

**Start Here:**
1. 📁 `Concepts/Strings/` - String basics
2. 📁 `Concepts/exception/` - Error handling
3. 📁 `Projects/employee_record_pr1/` - Simple console app
4. 📁 `Concepts/Collections_JAVA8/Collection Framework/` - Core collections

**Learning Path:**
```
Basics → Collections → Java 8 → Projects → Design Patterns → Advanced Projects
```

### For Intermediate Developers

**Recommended Path:**
1. 📁 `Concepts/Collections_JAVA8/java8/` - Modern Java features
2. 📁 `Concepts/DesignPatterns/` - Software design patterns
3. 📁 `Projects/Loginportal/` - Web application with database
4. 📁 `Projects/OPSI_details/` - API integration
5. 📁 `Libraries/loggy/` - Custom library development

### For Advanced Developers

**Deep Dive:**
1. 📁 `Projects/Modular_partner-change-validator/` - Microservice architecture
2. 📁 `Concepts/Collections_JAVA8/generics/` - Type-safe programming
3. 📁 `Concepts/Collections_JAVA8/innerClasses/` - Advanced OOP
4. **Contribute**: Enhance projects or add new patterns

---

## 🎯 Best Use Cases

### 1. **Learning & Education**
- Comprehensive examples for teaching Java concepts
- Step-by-step progression from basics to advanced
- Real-world project implementations

### 2. **Interview Preparation**
- Common design patterns (Singleton, Builder)
- Collection framework deep dive
- Java 8 functional programming
- Exception handling best practices

### 3. **Code Reference**
- Quick lookup for syntax and patterns
- Copy-paste ready implementations
- Documented best practices

### 4. **Project Starter Templates**
- JavaEE web application template (Loginportal)
- Spring Boot microservice template (Modular validator)
- API integration template (OPSI_details)
- Custom library structure (loggy)

### 5. **Portfolio Building**
- Demonstrate full-stack development skills
- Show understanding of design patterns
- Highlight microservice architecture experience
- Custom library development capability

---

## 📈 Learning Path

### 🟢 Level 1: Foundations (Weeks 1-2)
```
├── Strings & Basic I/O
├── Exception Handling
├── Collections Basics (List, Set, Map)
└── First Console Application
```

### 🔵 Level 2: Core Java (Weeks 3-4)
```
├── Advanced Collections
├── Abstract Classes & Interfaces
├── Garbage Collection
└── File I/O Operations
```

### 🟡 Level 3: Modern Java (Weeks 5-6)
```
├── Lambda Expressions
├── Stream API
├── Functional Interfaces
├── Method References
└── Optional & Date-Time API
```

### 🟠 Level 4: Design & Architecture (Weeks 7-8)
```
├── Design Patterns (Singleton, Builder, etc.)
├── Generics & Type Safety
├── Inner Classes
└── Regular Expressions
```

### 🔴 Level 5: Enterprise Applications (Weeks 9-12)
```
├── JavaEE Web Applications (Servlets, JSP)
├── Spring Boot Microservices
├── Database Integration (JDBC, JPA)
├── API Integration (REST, OAuth)
├── Cloud Services (AWS SQS, Secrets Manager)
└── Custom Library Development
```

---

## 🛠️ Development Setup

### IDE Configuration

#### IntelliJ IDEA
```
1. Open → Select JAVA directory
2. Trust project sources
3. Configure JDK: File → Project Structure → SDK → Java 17
4. Enable Maven auto-import
5. Run Maven: mvn clean install
```

#### Eclipse
```
1. File → Import → Existing Maven Projects
2. Select JAVA directory
3. Configure JRE: Preferences → Java → Installed JREs → Add (JDK 17)
4. Update Maven projects
```

#### VS Code
```
1. Install Extension Pack for Java
2. Open JAVA folder
3. Configure java.home in settings.json
4. Use "Java: Clean Java Language Server Workspace"
```

### Environment Variables

```bash
# Add to ~/.bashrc or ~/.zshrc
export JAVA_HOME=/path/to/jdk-17
export PATH=$JAVA_HOME/bin:$PATH
export MAVEN_HOME=/path/to/maven
export PATH=$MAVEN_HOME/bin:$PATH
```

---

## 📊 Repository Statistics

- **Total Projects**: 5
- **Total Concept Files**: 125+
- **Custom Libraries**: 1 (Loggy)
- **Lines of Code**: 10,000+
- **Documentation Pages**: 10+
- **Design Patterns**: 2 (Singleton, Builder)
- **Java Versions**: 8, 17
- **Frameworks**: Spring Boot, JavaEE
- **Cloud Platforms**: AWS (SQS, Secrets Manager)

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Report Issues**: Found a bug? Open an issue
2. **Suggest Enhancements**: Have ideas? Create a feature request
3. **Add Examples**: More examples are always useful
4. **Improve Documentation**: Clarify or expand explanations
5. **Add Design Patterns**: Implement additional patterns

### Contribution Guidelines

```bash
# Fork and clone
git clone https://github.com/your-username/JAVA.git

# Create feature branch
git checkout -b feature/your-feature-name

# Make changes and commit
git commit -m "Add: Your feature description"

# Push and create PR
git push origin feature/your-feature-name
```

---

## 📞 Contact & Support

- **Author**: Balram Rajak
- **GitHub**: [@balram-rajak](https://github.com/balram-rajak)
- **Repository**: [JAVA](https://github.com/balram-rajak/JAVA)

### Getting Help

- 📖 Start with project READMEs
- 💬 Open an issue for questions
- 🐛 Report bugs via GitHub Issues
- 💡 Suggest features via GitHub Issues

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Oracle Java Documentation
- Spring Framework Team
- AWS SDK Contributors
- SLF4J & Logback Communities
- Open Source Community

---

## 🎓 Educational Value

This repository is designed for:
- ✅ Self-paced learning
- ✅ University coursework
- ✅ Coding bootcamps
- ✅ Interview preparation
- ✅ Professional development
- ✅ Portfolio building

---

<div align="center">

### ⭐ If this repository helped you, please give it a star! ⭐

**Made with ☕ and 💻 by Balram Rajak**

[🔝 Back to Top](#-java-learning-repository)

</div>
