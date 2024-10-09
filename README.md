#Personal Budgeting & Financial Calculations Application

Overview
This Java-based command-line application helps users manage their personal budget by tracking monthly income, expenses, and loans (home and vehicle).

The application calculates key financial aspects, such as total expenses, loan repayments, and provides warnings when expenses exceed a recommended threshold.

#Features
Track Monthly Expenses: Capture essential monthly expenses like groceries, utilities, transport, phone bills, etc.
Home Loan Calculation: Automatically calculate the monthly home loan repayment based on user inputs (purchase price, deposit, interest rate).

Vehicle Loan Calculation: Calculate vehicle loan repayments, including insurance, based on user inputs.
Expense Sorting: Sorts expenses from highest to lowest for easy financial visualization.
Warnings: Provides warnings when:
Home loan repayment exceeds one-third of the user's gross income.
Total expenses exceed 75% of the user's gross income.
Remaining Income Calculation: Shows the remaining disposable income after all expenses and deductions.

#Technologies Used
Java 8 or later
Java Scanner for user input
Java ArrayList for storing and managing expenses
Object-oriented design using inheritance and abstract classes
How It Works
Input Monthly Income & Expenses: The application prompts the user to input their gross income and various expense categories (e.g., groceries, utilities).

*Choose Accommodation Type: The user selects either renting or buying a home. If buying, the application asks for home loan details and calculates the monthly repayment.

*Vehicle Loan Option: Users can choose to input details for purchasing a vehicle. The application calculates the vehicle loan and insurance costs and adds them to the total expenses.

*Warnings & Financial Summary: After all inputs are collected, the application checks if expenses are within reasonable limits and issues warnings if necessary. It also provides a summary of expenses and available remaining income.

#Prerequisites
To run this application, ensure you have:

Java Development Kit (JDK) version 8 or above installed on your machine.
A code editor like NetBeans or Eclipse for editing and running the program.
How to Run
Clone or download the repository to your local machine.
Open the project in your preferred IDE (e.g., NetBeans or Eclipse).
Compile and run the Expense2.java file.
Follow the on-screen prompts to enter your income, expenses, and loan details.
Sample Run
text
Copy code
*Enter your Gross monthly income: 50000
*Enter your Monthly tax deductions: 10000
*Enter your Groceries: 5000
*Enter your Water and lights: 1500
*Enter your Travel costs: 3000
*Enter your Phone expenses: 1000
*Enter your Other expenses: 2000

Are you renting or buying a property? (rent/buy): buy
*Enter the purchase price of the property: 500000
*Enter the total deposit: 50000
*Enter the interest rate (%): 7
*Monthly home loan repayment: 3141.17

Are you buying a vehicle? (yes/no): yes
*Enter the purchase price of the vehicle: 200000
*Enter the total deposit for the vehicle: 20000
*Enter the interest rate for the vehicle (%): 9
*Enter the estimated insurance premium: 500
*Total monthly cost of buying the vehicle (loan + insurance): 4243.59
*Available monthly money after deductions: 22315.24
Expenses in descending order:
10000.0
5000.0
4243.59
3141.17
3000.0
2000.0
1500.0
1000.0

#Future Enhancements
Graphical User Interface (GUI): Future versions may include a GUI to make input and output more user-friendly.
Expense Analysis: A breakdown of expenses into categories (essential vs non-essential) for better financial management.
Savings Goals: Add functionality to suggest savings based on income and expense patterns.
License
This project is licensed under the MIT License. See the LICENSE file for details.
