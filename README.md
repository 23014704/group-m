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
Enter your monthly income: 20000 Enter your total monthly living expenses (utilities, groceries, etc.): 8000 Would you like to buy a vehicle? (yes/no): yes Enter the vehicle model and make: Toyota Corolla Enter the vehicle purchase price: R300000 Enter the total deposit: R50000 Enter the interest rate (percentage): 8 Enter the estimated monthly insurance premium: R1200 Total monthly cost for the vehicle (loan + insurance): R6170.52

Expenses (sorted in descending order): Living Expenses: R8000.0 Vehicle Financing: R6170.52

Warning: Your total expenses exceed 75% of your income!


### Notes:
- Make sure to follow the prompts and input correct values for each question.
- You can modify the program as needed or extend it to handle additional types of expenses or loans.

### Developer Notes:
- The vehicle loan repayment is calculated assuming a 5-year loan term and fixed interest rate.
- The program sorts all expenses in descending order, so the most significant expense is displayed first.

### Additional Information:
- The source code is written in standard Java and requires JDK version 8 or later to compile and run.
- No external libraries are needed.


