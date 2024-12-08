# Bank Account Management System

## Overview
The **Bank Account Management System** is a Java-based application that allows users to manage bank accounts. It supports operations such as deposits, withdrawals, and admin-only functions like viewing user data. The system includes robust error handling using custom exceptions to manage scenarios like insufficient balance, invalid deposits, and unauthorized access.

---

## Features
### 1. User Management
- **Sign Up**: Create new users with unique IDs.
- **Login**:
    - Normal users can log in to access their accounts.
    - Admin users have additional privileges to view all user data.

### 2. Bank Account Operations
- **Deposit**: Add money to an account with validation.
- **Withdraw**: Remove money from an account with sufficient balance checks.
- **View Data**:
    - Admins can view all user accounts.
    - Normal users can view their own account details.

### 3. Error Handling
- Custom exceptions for:
    - Invalid deposits (`InvalidDepositException`).
    - Insufficient balance (`NegativeBalanceException`).
    - Unauthorized access (`UnauthorizedAccessException`).

---

## How It Works
1. **Sign Up:**
    - Users can create accounts by providing:
        - Name
        - Initial Balance
        - Admin Status (true/false)

2. **Login:**
    - Users log in using their unique ID.
    - Admins can access additional admin-only features.

3. **Perform Actions:**
    - **Deposit**: Add a valid amount to your account.
    - **Withdraw**: Remove money, ensuring sufficient balance.
    - **View Data**:
        - Normal users view their account details.
        - Admins view all accounts.

---

## Exception Scenarios
The system handles errors gracefully using custom exceptions:
1. **InvalidDepositException**:
    - Thrown when attempting to deposit a negative or zero amount.

2. **NegativeBalanceException**:
    - Thrown when attempting to withdraw more money than available.

3. **UnauthorizedAccessException**:
    - Thrown when non-admin users attempt to access admin features.

4. **NoUserExistsException**:
    - Thrown when an operation references a non-existent user.

