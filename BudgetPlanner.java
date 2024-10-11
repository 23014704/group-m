import java.util.ArrayList;
import java.util.Scanner;

// Abstract class for all types of expenses
// This defines a general structure for an expense category and its amount.
abstract class Expense {
    String category;  // The category of the expense (e.g., Rent, Home Loan, etc.)
    double amount;    // The monetary value of the expense

    // Constructor for initializing the category and amount of an expense
    public Expense(String category, double amount) {
        this.category = category; // Assign the input category to the expense
        this.amount = amount;     // Assign the input amount to the expense
    }

    // Getter method for returning the category of the expense
    public String getCategory() {
        return category;
    }

    // Getter method for returning the amount of the expense
    public double getAmount() {
        return amount;
    }

    // Setter method for updating the amount of the expense
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Abstract method to display the expense details; must be implemented by subclasses
    public abstract void displayExpense();
}

// Class for handling home loan-specific expenses
// This class extends the Expense class and adds details specific to home loans
class HomeLoan extends Expense {
    double purchasePrice;  // The price of the property being purchased
    double deposit;        // The initial deposit for the property
    int interestRate;      // Interest rate for the home loan (as a percentage)
    int monthsToRepay;     // Duration to repay the loan in months

    // Constructor for HomeLoan that initializes the fields and calculates the monthly repayment
    public HomeLoan(double purchasePrice, double deposit, double interestRate, int monthsToRepay) {
        super("Home Loan", 0); // Calling the superclass constructor with category "Home Loan"
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.interestRate = (int) interestRate;
        this.monthsToRepay = monthsToRepay;
        this.amount = calculateMonthlyRepayment(); // Automatically calculate the monthly repayment
    }

    // Method to calculate the monthly repayment for the home loan based on the input details
    double calculateMonthlyRepayment() {
        double loanAmount = purchasePrice - deposit; // Loan amount is the purchase price minus deposit
        double monthlyInterestRate = (interestRate / 100.0); // Convert interest rate percentage to decimal
        return loanAmount * (Math.pow(1 + monthlyInterestRate, monthsToRepay)); // Basic compound interest calculation
    }

    // Method to display home loan expense details
    public void displayExpense() {
        System.out.println("Home Loan Monthly Repayment: " + amount);
    }
}

// Class for handling rent expenses
// This class extends Expense and handles simple rent-based expenses.
class Rent extends Expense {
    public Rent(double rentAmount) {
        super("Rent", rentAmount); // Initialize rent expense using superclass constructor
    }

    // Method to display rent expense details
    public void displayExpense() {
        System.out.println("Monthly Rent: " + amount);
    }
}

// Class for handling other simple expenses like groceries, etc.
class SimpleExpense extends Expense {
    public SimpleExpense(String category, double amount) {
        super(category, amount); // Initialize the simple expense with its category and amount
    }

    // Method to display the simple expense details
    public void displayExpense() {
        System.out.println(category + ": " + amount);
    }
}

// Class for handling vehicle expenses
// This class extends the Expense class and adds details specific to vehicle expenses.
class VehicleExpense extends Expense {
    String modelAndMake;  // The model and make of the vehicle
    double purchasePrice; // Purchase price of the vehicle
    double totalDeposit;  // Initial deposit for the vehicle
    int interestRate;     // Interest rate for the vehicle loan (as a percentage)
    double insurancePremium; // Monthly insurance premium for the vehicle

    // Constructor for VehicleExpense that initializes the fields and calculates the monthly repayment
    public VehicleExpense(String modelAndMake, double purchasePrice, double totalDeposit, double interestRate, double insurancePremium) {
        super("Vehicle", 0); // Calling the superclass constructor with category "Vehicle"
        this.modelAndMake = modelAndMake;
        this.purchasePrice = purchasePrice;
        this.totalDeposit = totalDeposit;
        this.interestRate = (int) interestRate;
        this.insurancePremium = insurancePremium;
        this.amount = calculateMonthlyRepayment(); // Automatically calculate the monthly repayment
    }

    // Method to calculate the monthly repayment for the vehicle loan based on the input details
    double calculateMonthlyRepayment() {
        double loanAmount = purchasePrice - totalDeposit; // Loan amount is the vehicle price minus deposit
        double monthlyInterestRate = (interestRate / 100.0); // Convert interest rate percentage to decimal
        return loanAmount * (Math.pow(1 + monthlyInterestRate, 60)) + insurancePremium; // Compound interest plus insurance premium
    }

    // Method to display vehicle expense details
    public void displayExpense() {
        System.out.println("Vehicle Monthly Repayment: " + amount);
    }
}

// Main class for managing the budget and expense details
public class BudgetPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input gross income and estimated tax
        System.out.println("Enter your gross monthly income: ");
        double grossIncome = scanner.nextDouble();

        System.out.println("Enter estimated monthly tax (IN PERCENTAGE): ");
        int tax = scanner.nextInt();

        // Input basic monthly expenses
        System.out.println("Enter monthly groceries expense: ");
        double groceries = scanner.nextDouble();

        System.out.println("Enter monthly water and lights expense: ");
        double waterLights = scanner.nextDouble();

        System.out.println("Enter monthly travel expense: ");
        double travel = scanner.nextDouble();

        System.out.println("Enter monthly phone expense: ");
        double cellPhone = scanner.nextDouble();

        System.out.println("Enter any other monthly expenses: ");
        double other = scanner.nextDouble();

        // Create an ArrayList to store basic expenses as strings
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Groceries: " + groceries);
        expenses.add("Water and Lights: " + waterLights);
        expenses.add("Travel: " + travel);
        expenses.add("Cell Phone: " + cellPhone);
        expenses.add("Other: " + other);

        // Decision: Rent or Buy property
        System.out.println("Do you want to rent or buy a property? (rent/buy): ");
        String decision = scanner.next();
        Expense homeExpense = null; // Home expense will be either Rent or HomeLoan

        switch (decision) {
            case "rent":
                System.out.println("Enter your monthly rent: ");
                double rentAmount = scanner.nextDouble();
                homeExpense = new Rent(rentAmount); // Create Rent object
                break;

            case "buy":
                System.out.println("Enter property purchase price: ");
                double purchasePrice = scanner.nextDouble();

                System.out.println("Enter total deposit: ");
                double deposit = scanner.nextDouble();

                System.out.println("Enter interest rate (IN PERCENTAGE): ");
                int interestRate = scanner.nextInt();

                System.out.println("Enter number of months to repay (between 240 and 360): ");
                int monthsToRepay = scanner.nextInt();

                homeExpense = new HomeLoan(purchasePrice, deposit, interestRate, monthsToRepay); // Create HomeLoan object
                break;

            default:
                System.out.println("Error! Please Enter 'rent' or 'buy'");
                break;
        }

        // Decision: Buy a vehicle
        System.out.println("Do you want to buy a vehicle? (yes/no): ");
        String vehicleDecision = scanner.next();
        Expense vehicleExpense = null; // Vehicle expense will be either null or VehicleExpense

        switch (vehicleDecision) {
            case "yes":
                System.out.println("Enter vehicle model and make: ");
                String modelAndMake = scanner.next();

                System.out.println("Enter vehicle purchase price: ");
                double vehiclePurchasePrice = scanner.nextDouble();

                System.out.println("Enter total deposit: ");
                double vehicleDeposit = scanner.nextDouble();

                System.out.println("Enter interest rate (IN PERCENTAGE): ");
                int vehicleInterestRate = scanner.nextInt();

                System.out.println("Enter estimated insurance premium: ");
                double insurancePremium = scanner.nextDouble();

                vehicleExpense = new VehicleExpense(modelAndMake, vehiclePurchasePrice, vehicleDeposit, vehicleInterestRate, insurancePremium); // Create VehicleExpense object
                break;

            case "no":
                break;

            default:
                System.out.println("Error! Please Enter 'yes' or 'no'");
                break;
        }

        // Sort expenses in descending order based on the amount
        expenses.sort((a, b) -> Double.compare(Double.parseDouble(b.split(": ")[1]), Double.parseDouble(a.split(": ")[1])));

        // Calculate total expenses
        double totalExpenses = 0.0;
        for (String expense : expenses) {
            String[] parts = expense.split(": ");
            double amount = Double.parseDouble(parts[1]);
            totalExpenses += amount;
            System.out.println("Expense: " + parts[0] + " R " + amount); // Display each expense
        }

        // Display home loan monthly repayment if applicable
        if (homeExpense != null) {
            homeExpense.displayExpense();
        }

        // Display vehicle monthly repayment if applicable
        if (vehicleExpense != null) {
            vehicleExpense.displayExpense();
        }

        // Calculate remaining amount after tax and expenses
        double remainingAmount = grossIncome - (grossIncome * (tax / 100.0)) - totalExpenses;
        System.out.println("Remaining amount after tax and expenses: R" + remainingAmount);
    }
}
