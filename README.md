# 🎅 Secret Santa Assignment Challenge

## 📌 Overview
The **Secret Santa Assignment Challenge** is a fun coding task where employees are randomly assigned as Secret Santas to each other. The goal is to ensure a fair and randomized assignment while following certain constraints.

## 🎯 Problem Statement
The challenge involves assigning each employee a Secret Santa such that:
- No employee is assigned to themselves.
- The assignments should be randomized each time.
- If a previous year’s assignment is provided, an employee should not be assigned the same recipient as last year.
- If a valid assignment is not possible, the program should handle it gracefully.

## 🛠️ Solution Approach
The solution consists of multiple steps:
1. **Reading Employee Data**: The employee list is read from a CSV file.
2. **Reading Previous Year Assignments**: If available, the program reads last year’s assignments from a CSV file.
3. **Assigning Secret Santas**:
    - A shuffled list of employees is used to ensure randomness.
    - Each employee is assigned a Secret Santa while avoiding conflicts.
4. **Handling Edge Cases**:
    - If only one employee is present, assignment is not possible.
    - If a valid assignment cannot be made, an appropriate error is thrown.

## 📂 File Structure
- **CSV Files**: Contains employee names and previous assignments.
- **Service Classes**: Handles reading data, randomization, and assignment logic.
- **Exception Handling**: Ensures invalid cases are managed correctly.
- **Test Cases**: Validates the assignment logic with different scenarios.

## 🔍 Key Features
✅ Randomized assignments to ensure fairness  
✅ Avoids assigning an employee to themselves  
✅ Prevents repetition of last year’s assignments  
✅ Handles edge cases gracefully

## 🧪 Testing Strategy
The solution includes JUnit test cases to verify the correctness of assignments. The tests cover:
- Assigning Secret Santas to multiple employees
- Handling cases where only one or no employee is available
- Ensuring no employee gets assigned to themselves
- Validating proper exception handling
