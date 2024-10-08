# Budgeting Application

This is a simple Java console application that helps users manage their monthly income and expenses. The program calculates the total expenses, sorts them in descending order, and checks if the total expenses exceed 75% of the user's income.

### Features:
- Collects user's monthly income.
- Allows the user to input regular living expenses.
- Provides an option to enter vehicle financing details if the user chooses to buy a vehicle.
- Calculates the total monthly cost for vehicle financing (including loan repayment and insurance).
- Displays the user's expenses in descending order.
- Warns the user if their total expenses exceed 75% of their income.

## How to Compile and Run the Program

### Prerequisites:
- You need to have the **Java Development Kit (JDK)** installed on your machine.
  - [Download the JDK here](https://www.oracle.com/java/technologies/javase-downloads.html)
- Make sure the `javac` and `java` commands are available in your terminal or command prompt.

### Step-by-Step Instructions:

#### 1. Compile the Program

- Open a terminal (command prompt) and navigate to the folder where the source code file `BudgetingApp.java` is located.
- Run the following command to compile the Java source file:

    ```bash
    javac BudgetingApp.java
    ```

- This will generate a `BudgetingApp.class` file in the same directory.

#### 2. Run the Program

- After successful compilation, run the program using the following command:

    ```bash
    java BudgetingApp
    ```

- The program will prompt you to enter your monthly income and expenses step by step.
- If you choose to buy a vehicle, it will ask for details such as the model, purchase price, deposit, interest rate, and insurance premium.

#### 3. Example Interaction:

