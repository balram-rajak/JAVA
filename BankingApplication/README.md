# Banking Application

## Description
A simple banking application that simulates basic banking operations. The `BankAccount` class manages account information and provides methods for deposits, withdrawals, and balance inquiries.

## Concepts Covered
- Object-Oriented Programming (OOP)
- Encapsulation
- Data validation
- Class methods and instance variables
- Conditional logic for business rules

## Files
- `BankAccount.java` - BankAccount class definition

## Features
- Create bank accounts with account number, holder name, and initial balance
- Deposit money into account
- Withdraw money with balance validation
- Check account balance
- Display account information

## How to Use
1. Compile the program:
   ```bash
   javac BankAccount.java
   ```

2. Create a main class to use the BankAccount class:
   ```java
   BankAccount account = new BankAccount("ACC001", "Jane Smith", 1000.0);
   account.deposit(500.0);
   account.withdraw(200.0);
   account.displayAccountInfo();
   ```

## Learning Objectives
- Implement business logic in Java classes
- Practice data validation (checking for sufficient balance)
- Understand state management in objects
- Work with real-world application scenarios

## Future Enhancements
- Add transaction history
- Implement different account types (savings, checking)
- Add interest calculation
- Create a user interface (console or GUI)
- Implement account-to-account transfers
