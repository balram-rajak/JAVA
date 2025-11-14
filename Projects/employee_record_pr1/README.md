# Employee Record Management System

## 📋 Project Overview

This project demonstrates Java 8 functional programming concepts through an employee record management system. It showcases the usage of **Predicates**, **Functional Interfaces**, **Lambda Expressions**, and **Stream API** to filter and display employee data based on various criteria.

## 💡 Concept & Purpose

The project serves as a practical example of:
- Creating custom functional interfaces
- Using Predicate functional interface for filtering
- Composing predicates with logical operations (AND, OR, NOT)
- Leveraging Java 8 Stream API for data processing
- Building a simple data model with proper encapsulation

## 🏗️ Project Structure

```
employee_record_pr1/
└── src/
    ├── com/
    │   ├── Data.java              # Employee data model
    │   └── Employee_data.java     # Main application class
    └── functionality/
        └── Display.java           # Custom functional interface
```

## 🔄 Execution Flow

```
┌─────────────────────────────────┐
│   Employee_data (Main Class)   │
└────────────┬────────────────────┘
             │
             ├──► 1. Populate employee list with sample data
             │
             ├──► 2. Display all employees
             │
             ├──► 3. Filter & display all managers
             │       (using filterManagers predicate)
             │
             ├──► 4. Filter & display support department employees
             │       (using filterByDepartment predicate)
             │
             ├──► 5. Filter & display managers in support dept
             │       (using combined predicates with AND)
             │
             ├──► 6. Filter & display non-managers
             │       (using negated predicate)
             │
             └──► 7. Demonstrate Predicate.isEqual() usage
```

## 🛠️ Tech Stack

- **Language**: Java
- **Java Version**: 8 or higher (requires Java 8 features)
- **Key Features Used**:
  - Lambda Expressions
  - Predicates
  - Functional Interfaces
  - Stream API
  - Method References

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or higher installed
- IDE (Eclipse, IntelliJ IDEA, or VS Code) or command line

### Compilation

```bash
# Navigate to the src directory
cd src

# Compile all Java files
javac com/*.java functionality/*.java
```

### Execution

```bash
# Run the main class
java com.Employee_data
```

### Expected Output

The program will display:
1. Complete employee list
2. All managers
3. All employees from support department
4. All managers in support department
5. All employees who are not managers
6. All employees not in support department
7. Results of equality checks using Predicate.isEqual()

## 📊 Employee Data Structure

Each employee record contains:
- **Employee Number**: Unique identifier
- **Employee Name**: Full name
- **Designation Code**: Single character (e, c, k, r, m)
- **Department**: Department name
- **Basic Salary**: Base salary amount
- **DA (Dearness Allowance)**: Calculated based on designation
- **Total Salary**: Basic Salary + DA

### Designation Codes & DA

| Code | Designation   | DA Amount |
|------|--------------|-----------|
| e    | Engineer     | ₹20,000   |
| c    | Consultant   | ₹32,000   |
| k    | Clerk        | ₹12,000   |
| r    | Receptionist | ₹12,000   |
| m    | Manager      | ₹40,000   |

## 🎯 Key Learning Points

1. **Predicate Interface**: Demonstrates filtering with boolean-valued functions
2. **Predicate Composition**: Shows how to combine predicates using `and()`, `or()`, `negate()`, and `not()`
3. **Custom Functional Interface**: Implementation of `Display` interface
4. **Lambda Expressions**: Concise way to represent functional interfaces
5. **Stream API**: Efficient data processing and transformation

## 📝 Configuration

No external configuration required. All data is hardcoded in the `populateList()` method for demonstration purposes.

## 🔍 Code Highlights

### Predicate Examples
```java
// Simple predicate
Predicate<Data> filterManagers = t -> t.getDesignation().contentEquals("Manager");

// Combined predicate (AND operation)
filterManagers.and(filterByDepartment)

// Negated predicate
filterManagers.negate()

// Static predicate method
Predicate.not(filterByDepartment)
```

### Custom Functional Interface
```java
Display listAllManager = (predicate, list) -> list.stream()
    .map(item -> predicate.test(item) ? item + "\n" : "")
    .forEach(System.out::print);
```

---

**Author**: Balram Rajak  
**Purpose**: Educational - Java 8 Functional Programming Demonstration
