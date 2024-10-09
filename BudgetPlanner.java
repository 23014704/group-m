
import java.util.ArrayList;
import java.util.Scanner;

// Abstract class representing the structure of a loan, either for a home or vehicle
abstract class Loan {
    protected double purchasePrice;  // The total cost of the asset being financed (house or car)
    protected double deposit;        // The initial payment made upfront, which reduces the loan amount
    protected double interestRate;   // The annual percentage rate (APR) charged on the loan
    protected int months;            // The loan term expressed in months, determining how long payments will be made

    // Constructor to initialize the key financial details of the loan
    public Loan(double purchasePrice, double deposit, double interestRate, int months) {
        this.purchasePrice = purchasePrice;   // Set the total price of the asset
        this.deposit = deposit;               // Set the deposit amount to reduce the loan size
        this.interestRate = interestRate;     // Set the annual interest rate applied to the loan balance
        this.months = months;                 // Set the loan duration (in months) for repayment
    }

    // Abstract method to calculate the monthly loan payment, requiring implementation by subclasses
    public abstract double getAmount();
}

// HomeLoan class that extends the Loan class, specifically designed for home loan calculations
class HomeLoan extends Loan {
    // Constructor that calls the Loan constructor to initialize details specific to a home loan
    public HomeLoan(double purchasePrice, double deposit, double interestRate, int months) {
        super(purchasePrice, deposit, interestRate, months);  // Inherit and initialize loan details from Loan class
    }

    // Implemented method to calculate the monthly repayment for the home loan using a standard loan formula
    public double getAmount() {
        double loanAmount = purchasePrice - deposit;  // Calculate the loan principal as the purchase price minus the deposit
        double monthlyInterestRate = interestRate / 100 / 12;  // Convert annual interest rate to a monthly rate
        // Calculate the monthly payment using the loan amortization formula
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));
    }
}

// VehicleLoan class that extends the Loan class, specifically designed for vehicle loan calculations
class VehicleLoan extends Loan {
    // Constructor that sets the loan details for vehicle financing with a fixed term of 60 months (5 years)
    public VehicleLoan(double purchasePrice, double deposit, double interestRate) {
        super(purchasePrice, deposit, interestRate, 60);  // Fixed loan term of 60 months for vehicle loans
    }

    // Implemented method to calculate the monthly repayment for the vehicle loan using a standard loan formula
    public double getAmount() {
        double loanAmount = purchasePrice - deposit;  // Calculate the loan principal by subtracting the deposit from the purchase price
        double monthlyInterestRate = interestRate / 100 / 12;  // Convert annual interest rate to a monthly rate
        // Use the loan amortization formula to calculate the monthly repayment
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));
    }
}

// Main class to handle the user's personal budgeting and loan calculations
public class Expense2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Initialize the scanner to capture user input
        ArrayList<Double> expenses = new ArrayList<>();  // Create a list to store all user expenses for later calculations

        // Define the categories of monthly expenses that the user will provide input for
        String[] expenseCategories = {
            "Gross monthly income",   // Total pre-tax income earned each month
            "Monthly tax deductions", // Amount deducted from gross income for taxes
            "Groceries",              // Money spent on food and household supplies
            "Water and lights",       // Utility costs for water and electricity
            "Travel costs",           // Money spent on transportation, including fuel or public transport
            "Phone expenses",         // Monthly phone or mobile data costs
            "Other expenses"          // Any other miscellaneous expenses
        };

        // Loop through each expense category and ask the user to input their corresponding monthly costs
        for (String category : expenseCategories) {
            System.out.print("Enter your " + category + ": ");
            expenses.add(scanner.nextDouble());  // Collect and store the user input as a double value in the expenses list
        }

        double grossIncome = expenses.get(0);  // The first entry in the list is the user's gross monthly income
        double tax = expenses.get(1);  // The second entry is the user's tax deductions
        double totalExpenses = 0;  // Initialize the total monthly expenses, which will be calculated later

        // Sum all non-income and non-tax expenses (starting from index 2) to calculate total expenses
        for (int i = 2; i < expenses.size(); i++) {
            totalExpenses += expenses.get(i);
        }

        // Ask the user if they are buying or renting a property
        System.out.print("Are you renting or buying a property? (rent/buy): ");
        String accommodation = scanner.next();

        // If the user is buying a property, collect home loan details and calculate the loan repayment
        if (accommodation.equalsIgnoreCase("buy")) {
            System.out.print("Enter the purchase price of the property: ");  // Collect the property price
            double purchasePrice = scanner.nextDouble();

            System.out.print("Enter the total deposit: ");  // Collect the down payment amount
            double deposit = scanner.nextDouble();

            System.out.print("Enter the interest rate (%): ");  // Collect the annual interest rate
            double interestRate = scanner.nextDouble();

            // Create a HomeLoan object with a fixed term of 360 months (30 years) and calculate the repayment
            HomeLoan homeLoan = new HomeLoan(purchasePrice, deposit, interestRate, 360);
            double monthlyRepayment = homeLoan.getAmount();  // Calculate the monthly home loan repayment
            System.out.println("Monthly home loan repayment: " + monthlyRepayment);

            // Check if the home loan repayment exceeds one-third of the user's gross monthly income
            if (monthlyRepayment > (grossIncome / 3)) {
                System.out.println("Warning: Home loan repayment is more than a third of your gross income.");
            }

            // Add the monthly home loan repayment to the user's total monthly expenses
            totalExpenses += monthlyRepayment;
            expenses.add(monthlyRepayment);  // Include the repayment in the list of expenses
        } else {
            // If the user is renting, collect the monthly rental amount and add it to their total expenses
            System.out.print("Enter your monthly rental amount: ");
            double rent = scanner.nextDouble();
            totalExpenses += rent;  // Add the rental amount to total monthly expenses
            expenses.add(rent);  // Store the rental amount in the expenses list
        }

        // Ask the user if they are purchasing a vehicle and gather relevant loan details if applicable
        System.out.print("Are you buying a vehicle? (yes/no): ");
        String buyVehicle = scanner.next();

        // If the user is buying a vehicle, collect vehicle loan and insurance details to calculate total monthly costs
        if (buyVehicle.equalsIgnoreCase("yes")) {
            System.out.print("Enter the purchase price of the vehicle: ");  // Collect the vehicle price
            double vehiclePurchasePrice = scanner.nextDouble();

            System.out.print("Enter the total deposit for the vehicle: ");  // Collect the vehicle deposit amount
            double vehicleDeposit = scanner.nextDouble();

            System.out.print("Enter the interest rate for the vehicle (%): ");  // Collect the annual interest rate
            double vehicleInterestRate = scanner.nextDouble();

            System.out.print("Enter the estimated insurance premium: ");  // Collect the monthly insurance premium
            double insurancePremium = scanner.nextDouble();

            // Create a VehicleLoan object and calculate the monthly loan repayment
            VehicleLoan vehicleLoan = new VehicleLoan(vehiclePurchasePrice, vehicleDeposit, vehicleInterestRate);
            double vehicleMonthlyRepayment = vehicleLoan.getAmount();

            // Calculate the total monthly cost for the vehicle, including both the loan repayment and insurance
            double totalVehicleCost = vehicleMonthlyRepayment + insurancePremium;
            System.out.println("Total monthly cost of buying the vehicle (loan + insurance): " + totalVehicleCost);

            // Add the total vehicle costs (loan and insurance) to the user's overall monthly expenses
            totalExpenses += totalVehicleCost;
            expenses.add(totalVehicleCost);  // Store the total vehicle costs in the expenses list
        }

        // Check if the total monthly expenses exceed 75% of the user's gross income and issue a warning if true
        notifyIfExpensesExceedThreshold(totalExpenses, grossIncome);

        // Calculate the user's remaining money after all taxes and expenses have been deducted from gross income
        double availableMoney = grossIncome - tax - totalExpenses;
        System.out.println("Available monthly money after deductions: " + availableMoney);

        // Sort the expenses in descending order (highest to lowest) for clearer financial visualization
        expenses.sort((a, b) -> Double.compare(b, a));  // Use a comparator to sort the expenses from highest to lowest
        System.out.println("Expenses in descending order:");
        for (double expense : expenses) {
            System.out.println(expense);  // Print each expense in descending order
        }

        scanner.close();  // Close the scanner to prevent resource leaks
    }

    // Method to check if total expenses exceed 75% of gross income and notify the user if they do
