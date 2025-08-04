# Java Expression Calculator

A command-line calculator in Java that takes a space-separated arithmetic expression (in infix format) and evaluates it after converting it to postfix notation.

## 🚀 Features

- ✅ Supports basic arithmetic operators: `+`, `-`, `*`, `/`, `%`
- ✅ Handles operator precedence and parentheses
- ✅ Detects divide-by-zero and invalid expressions
- ✅ Stack-based evaluation of postfix expressions
- ✅ Simple and interactive CLI

## 📌 How It Works

1. **Input Parsing:**  
   User inputs a space-separated infix expression like: 2 + 4 * ( 3 + 5 ) / 2

2. **Infix to Postfix Conversion:**  
Using the Shunting Yard algorithm to reorder the expression into postfix notation.

3. **Postfix Evaluation:**  
Evaluate using a stack to compute the result of the postfix expression.

## 📥 Input Format

You must enter the expression with **space-separated tokens**:

Example: 2 + 4 * 3 - 1

**NOT Valid:**
Example: 2+4*3-1 **space not included**

---

## ⚠️ Error Handling

- **Divide by Zero**:  
  Displays a message and halts evaluation.

- **Invalid Expressions**:  
  If unsupported characters or syntax is detected, the program prints `INVALID_EXPRESSION`.

---

## 📦 How to Run

### Prerequisites
- Java JDK installed

### Steps
1. Clone or download this repository.
2. Open terminal in the project folder.
3. Compile:
   ```bash
   javac Claculator.java
you can also open and run the downloaded java file in code editors like vs code.
**SAMPLE OUTPUT**
enter your expression with space separated by each number and operator 
eg: 2 + 45 / 56 * 21 :
2 + 3 * 4
ANS: 14.0

