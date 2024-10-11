###Budgeting Application
This is a simple Java console application that helps users manage their monthly income, expenses, and financing options for home loans or rent, as well as vehicle purchases. The program calculates total expenses, sorts them in descending order, and determines whether the user's expenses exceed 75% of their income after taxes.

###Features:
Collects the user's gross monthly income and estimated tax percentage.
Allows the user to input regular living expenses, including groceries, utilities, and other personal expenses.
Provides an option for the user to choose between renting a home or buying a property with a home loan.
Provides an option to enter vehicle financing details if the user chooses to buy a vehicle.
Calculates the total monthly cost for vehicle financing (including loan repayment and insurance).
Displays the user's expenses in descending order.
Warns the user if their total expenses exceed 75% of their income after tax deductions.
How to Compile and Run the Program


###Prerequisites:
Java Development Kit (JDK) must be installed on your machine.
Download the JDK here.
Ensure that the javac (Java compiler) and java commands are available in your terminal or command prompt.
Step-by-Step Instructions:
1. Compile the Program
Open a terminal (or command prompt) and navigate to the folder containing the source code file BudgetPlanner.java.

Run the following command to compile the Java source file:

bash
Copy code
javac BudgetPlanner.java
This will generate a BudgetPlanner.class file in the same directory.

###2. Run the Program
After successful compilation, run the program using the following command:

bash
Copy code
java BudgetPlanner
The program will prompt you to enter your gross monthly income, estimated tax, and various living expenses step by step.

You will also be asked whether you want to rent or buy a home, and whether you want to purchase a vehicle.

Based on your inputs, the program will calculate your total monthly expenses and display them in descending order.

###3. Example Interaction:
text
Copy code
Enter your gross monthly income: 25000
Enter estimated monthly tax (IN PERCENTAGE): 15
Enter monthly groceries expense: 5000
Enter monthly water and lights expense: 1200
Enter monthly travel expense: 1500
Enter monthly phone expense: 500
Enter any other monthly expenses: 1000
Do you want to rent or buy a property? (rent/buy): buy
Enter property purchase price: 1000000
Enter total deposit: 200000
Enter interest rate (IN PERCENTAGE): 7
Enter number of months to repay (between 240 and 360): 300
Do you want to buy a vehicle? (yes/no): yes
Enter vehicle model and make: Toyota Corolla
Enter vehicle purchase price: 300000
Enter total deposit: 50000
Enter interest rate (IN PERCENTAGE): 9
Enter estimated insurance premium: 1200

###Expenses (sorted in descending order):
Home Loan Monthly Repayment: 7125.99
Groceries: 5000.0
Vehicle Monthly Repayment: 5248.50
Travel: 1500.0
Water and Lights: 1200.0
Phone: 500.0
Other: 1000.0

###Remaining amount after tax and expenses: R2575.51
Notes:
Ensure to follow the prompts and input the correct values for each question.
The program can be easily modified to add additional types of expenses or financial options if required.
The expenses are sorted in descending order, with the most significant expense displayed first.

Developer Notes:
The home loan repayment is calculated based on compound interest, allowing for flexibility in terms of loan duration (240 to 360 months).
Vehicle loan repayment is calculated assuming a 5-year term (60 months) with a fixed interest rate.
The program also calculates the monthly repayment for home loans and vehicles and checks if the user's expenses exceed 75% of their income after taxes.
Additional Information:
The source code is written in standard Java and requires JDK version 8 or later to compile and run.
No external libraries are required to run this application.





