/*
 
 
 Theme: bank account manager (Units 1-4 built the Bank class).
 
 New class: Finance
 Job: manages a portfolio of Bank accounts plus a savings goal for each month,
 then compares the user's real monthly savings to those goals.
 Relationship: Finance holds a Bank[]; addAccount takes a Bank parameter, and
 compareSavingsToGoal / getTotalBalance read each Bank's data.
 
 Arrays:
 Bank[] accounts        (objects, created with new Bank[n])
 double[] monthlyGoals  (primitives, created with new double[n])
 String[] monthNames    (initializer list, in Main)
 
 Static: portfoliosCreated and MAX_ACCOUNTS are shared by every Finance object;
 average(double[]) only needs its array parameter.
 this: this.ownerName = ownerName; this(...) chaining; this.getAverageGoal() > other.getAverageGoal()
 Algorithms: max, count, average, sum.
 
 My plan: Use this program to create and manage 
 multiple bank accounts to stay on track with financial goals.
 */


import java.util.Scanner;

public class Main{
    // Reads one validated non-negative number on its own line.
    private static double readAmount(Scanner scanner, String prompt) {
        System.out.println(prompt);
        String s = scanner.nextLine();
        while (!s.matches("\\d*\\.?\\d+") && !s.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid amount.");
            s = scanner.nextLine();
        }
        return Double.parseDouble(s);
    }

    // Asks the user for a new value for one expense and returns the value to keep.
    // Higher than before: asks to confirm, else offers to decrease instead.
    private static double askNewExpense(Scanner scanner, String name, double oldValue) {
        System.out.println("What would you like to change your " + name + " expense to?");
        double newValue = readMoney(scanner);
        scanner.nextLine();
        if (newValue > oldValue) {
            System.out.println("Your new " + name + " expense is higher than your previous " + name + " expense. Are you sure you want to change it? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                return newValue;
            }
            System.out.println("Would you like to decrease your " + name + " expense instead? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("What would you like to decrease your " + name + " expense to?");
                double decreased = readMoney(scanner);
                scanner.nextLine();
                return decreased;
            }
            return oldValue;
        }
        return newValue;
    }

    private static double readMoney(Scanner scanner) {
    String s = scanner.next();
    while (!s.matches("\\d*\\.?\\d+") && !s.matches("\\d+\\.\\d*")) {
        System.out.println("Invalid input. Please enter a valid amount.");
        s = scanner.next();
    }
    return Double.parseDouble(s);
    }
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String accountHolderName = scanner.nextLine();

        System.out.println("Hi " + accountHolderName + ", welcome to the bank account management system!");

        // Prompt the user for all the necessary information to create a bank object
        int accountNumber = (int) (Math.random() * 1000000);
        
        String password = "";
        System.out.println("Would you like to set a password for your account? (yes/no)");
        String passwordAnswer = scanner.nextLine();
        if (passwordAnswer.equalsIgnoreCase("yes")) {
            System.out.println("Please enter your password: ");
            password = scanner.nextLine();
        } else {
            password = (int) (Math.random() * 100000000) + "";
            for(int i = 0; i < password.length(); i++){
                String character = password.substring(i, i+1) + "";
                if(character.equals("0") || character.equals("1")){
                    password = password.substring(0, i) + "o" + password.substring(i + 1);
                }
            }
            System.out.println("Your generated password is: " + password + " (write it down, it will not be shown again)");
        }

        
      

        double startingBalance = readAmount(scanner, "Please enter your starting balance in only digits: ");

        double monthlyIncome = readAmount(scanner, "Please enter your monthly income in only digits:");

        double monthlyRentExpense = readAmount(scanner, "Please enter your monthly rent expense in only digits:");

        double monthlyFoodExpense = readAmount(scanner, "Please enter your monthly food expense in only digits:");

        double monthlyUtilityExpense = readAmount(scanner, "Please enter your monthly utility expense in only digits:");

        double monthlyTransportationExpense = readAmount(scanner, "Please enter your monthly transportation expense in only digits:");

        double monthlyEntertainmentExpense = readAmount(scanner, "Please enter your monthly entertainment expense in only digits:");

        double monthlyOtherExpense = readAmount(scanner, "Please enter your monthly other expense in only digits:");

        // Create a bank object with the user input
        Bank userBank = new Bank(accountNumber, accountHolderName, password, startingBalance, monthlyIncome, monthlyRentExpense, monthlyFoodExpense, monthlyUtilityExpense, monthlyTransportationExpense, monthlyEntertainmentExpense, monthlyOtherExpense);


        //check if the user wants to change any of the information they entered
        System.out.println("Does your account information look correct? (yes/no), anything else counts as no!");
        System.out.println("Account Holder Name: " + userBank.getAccountHolderName());
        System.out.println("Account Number: " + userBank.getAccountNumber());
        System.out.println("Password: ********");
        System.out.println("Balance: " + userBank.getBalance());
        System.out.println("Monthly Income: " + userBank.getMonthlyIncome());
        System.out.println("Monthly Rent Expense: " + userBank.getMonthlyRentExpense());
        System.out.println("Monthly Food Expense: " + userBank.getMonthlyFoodExpense());
        System.out.println("Monthly Utility Expense: " + userBank.getMonthlyUtilityExpense());
        System.out.println("Monthly Transportation Expense: " + userBank.getMonthlyTransportationExpense());
        System.out.println("Monthly Entertainment Expense: " + userBank.getMonthlyEntertainmentExpense());
        System.out.println("Monthly Other Expense: " + userBank.getMonthlyOtherExpense());
        System.out.println("Monthly Savings: " + userBank.getMonthlySavings());

        
        String answer2 = scanner.nextLine();

        if (!answer2.equalsIgnoreCase("yes")) {
            System.out.println("Please restart the program and enter the correct information.");
            System.exit(0);
        }

        else {
            System.out.println("Great! Let's continue.");
        }

        // Check if the user wants to change any of the expenses
        if (userBank.consultationRent()) {
            userBank.setMonthlyRentExpense(askNewExpense(scanner, "rent", userBank.getMonthlyRentExpense()));
        }

        if (userBank.consultationFood()) {
            userBank.setMonthlyFoodExpense(askNewExpense(scanner, "food", userBank.getMonthlyFoodExpense()));
        }

        if (userBank.consultationUtility()) {
            userBank.setMonthlyUtilityExpense(askNewExpense(scanner, "utility", userBank.getMonthlyUtilityExpense()));
        }

        if (userBank.consultationTransportation()) {
            userBank.setMonthlyTransportationExpense(askNewExpense(scanner, "transportation", userBank.getMonthlyTransportationExpense()));
        }

        if (userBank.consultationEntertainment()) {
            userBank.setMonthlyEntertainmentExpense(askNewExpense(scanner, "entertainment", userBank.getMonthlyEntertainmentExpense()));
        }

        if (userBank.consultationOther()) {
            userBank.setMonthlyOtherExpense(askNewExpense(scanner, "other", userBank.getMonthlyOtherExpense()));
        }

        if (userBank.consultationSavings()){
            System.out.println("What would you like to change your savings to?");
            double newSavings = readMoney(scanner);
            scanner.nextLine();
            if (newSavings < userBank.getMonthlySavings()){
                System.out.println("Your new savings is lower than your previous savings. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if (answer3.equalsIgnoreCase("yes")) {
                    userBank.setMonthlySavings(newSavings);
                } else {
                    System.out.println("Would you like to increase your savings instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if (answer4.equalsIgnoreCase("yes")){
                        System.out.println("What would you like to increase your savings to?");
                        double increasedSavings = readMoney(scanner);
                        scanner.nextLine();
                        userBank.setMonthlySavings(increasedSavings);
                    }
                }
            } else {
                userBank.setMonthlySavings(newSavings);
            }
        }

        System.out.println("New Information:");
        System.out.println("Account Holder Name: " + userBank.getAccountHolderName());
        System.out.println("Account Number: " + userBank.getAccountNumber());
        System.out.println("Password: ********");
        System.out.println("Balance: " + userBank.getBalance());
        System.out.println("Monthly Income: " + userBank.getMonthlyIncome());
        System.out.println("Monthly Rent Expense: " + userBank.getMonthlyRentExpense());
        System.out.println("Monthly Food Expense: " + userBank.getMonthlyFoodExpense());
        System.out.println("Monthly Utility Expense: " + userBank.getMonthlyUtilityExpense());
        System.out.println("Monthly Transportation Expense: " + userBank.getMonthlyTransportationExpense());
        System.out.println("Monthly Entertainment Expense: " + userBank.getMonthlyEntertainmentExpense());
        System.out.println("Monthly Other Expense: " + userBank.getMonthlyOtherExpense());
        System.out.println("Monthly Savings: " + userBank.getMonthlySavings());

        //create a loop that allows the user to deposit, withdraw, or check their balance until they choose to exit
        boolean isRunning = true;
        while(isRunning){
            System.out.println("What would you like to do? Enter the number of your choice:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");

            String choiceInput = scanner.nextLine();
            while (!choiceInput.matches("[0-9]+")) {
                System.out.println("Invalid input. Please enter a number (1-4).");
                choiceInput = scanner.nextLine();
            }
            int choice = Integer.parseInt(choiceInput);
            

            if(choice == 1){
                System.out.println("How much would you like to deposit?");
                // Use nextLine + parse so letters don't crash and the newline is consumed
                String depositStr = scanner.nextLine();
                while (!depositStr.matches("\\d*\\.?\\d+") && !depositStr.matches("\\d+\\.\\d*")) {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    depositStr = scanner.nextLine();
                }
                double depositAmount = Double.parseDouble(depositStr);
                userBank.deposit(depositAmount);
                System.out.println("Your new balance is: " + userBank.getBalance());
                System.out.println("______________________________________________________________");
            }

            else if(choice == 2){
                System.out.println("How much would you like to withdraw?");
                String withdrawStr = scanner.nextLine();
                while (!withdrawStr.matches("\\d*\\.?\\d+") && !withdrawStr.matches("\\d+\\.\\d*")) {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    withdrawStr = scanner.nextLine();
                }
                double withdrawAmount = Double.parseDouble(withdrawStr);
                userBank.withdraw(withdrawAmount);
                System.out.println("Your new balance is: " + userBank.getBalance());
                System.out.println("______________________________________________________________");
               
            }

            else if(choice == 3){
                System.out.println("Your current balance is: " + userBank.getBalance());
                System.out.println("______________________________________________________________");
               
            }

           

            else if(choice == 4){
                isRunning = false;
            }

            else{
                System.out.println("Invalid choice. Please try again.");
            }

            
        }
        int month = 1;
        int bonusMonths = 0;
        double totalSavings = 0;
        double monthlySavings = userBank.getMonthlySavings();
        System.out.println("Usual Savings: " + monthlySavings + ", Savings Rate: " + userBank.savingsRate());
        while(month <= 12){
            if(Math.random() < 0.2){
                System.out.println("You have gotten a bonus this month! Your savings will be increased by 10%.");
                monthlySavings *= 1.1;
                bonusMonths++;
            }
            totalSavings += monthlySavings;
            System.out.printf("Month %2d | Total Savings: $%.2f%n", month, totalSavings);
            month++;
        }
        double bonusRate = (double) bonusMonths / 12 * 100;
        System.out.printf("You received a bonus in %.1f%% of months.%n", bonusRate);


       


          
        // Units 5-6 extension
        

        System.out.println("\nFINANCE PORTFOLIO (Units 5-6)");

        // Create a Finance portfolio that will hold Bank accounts
        Finance myFinance = new Finance(accountHolderName);

        // Add the first bank account (the one the user already created)
        boolean added = myFinance.addAccount(userBank);
        if (added) {
            System.out.println("Your first bank account was successfully added to the portfolio.");
        } else {
            System.out.println("Could not add first account - portfolio is full.");
        }

        // Let the user create a 2nd bank account (same format as first)
        System.out.println("\nWould you like to add a second bank account to your portfolio? (yes/no)");
        String addSecond = scanner.nextLine();
        if (addSecond.equalsIgnoreCase("yes")) {
            System.out.println("\n--- Creating Second Bank Account ---");

            int accountNumber2 = (int) (Math.random() * 1000000);

            double startingBalanceNew = readAmount(scanner, "Please enter your starting balance in only digits: ");

            double monthlyIncomeNew = readAmount(scanner, "Please enter your monthly income in only digits:");

            double monthlyRentExpenseNew = readAmount(scanner, "Please enter your monthly rent expense in only digits:");

            double monthlyFoodExpenseNew = readAmount(scanner, "Please enter your monthly food expense in only digits:");

            double monthlyUtilityExpenseNew = readAmount(scanner, "Please enter your monthly utility expense in only digits:");

            double monthlyTransportationExpenseNew = readAmount(scanner, "Please enter your monthly transportation expense in only digits:");

            double monthlyEntertainmentExpenseNew = readAmount(scanner, "Please enter your monthly entertainment expense in only digits:");

            double monthlyOtherExpenseNew = readAmount(scanner, "Please enter your monthly other expense in only digits:");

            // Create the second Bank object with the same constructor style
            Bank secondBank = new Bank(accountNumber2, accountHolderName + " (Account 2)", password,
                    startingBalanceNew, monthlyIncomeNew,
                    monthlyRentExpenseNew, monthlyFoodExpenseNew, monthlyUtilityExpenseNew,
                    monthlyTransportationExpenseNew, monthlyEntertainmentExpenseNew, monthlyOtherExpenseNew);


            // Check if the user wants to change any of the expenses
            if (secondBank.consultationRent()) {
            secondBank.setMonthlyRentExpense(askNewExpense(scanner, "rent", secondBank.getMonthlyRentExpense()));
        }

            if (secondBank.consultationFood()) {
            secondBank.setMonthlyFoodExpense(askNewExpense(scanner, "food", secondBank.getMonthlyFoodExpense()));
        }

            if (secondBank.consultationUtility()) {
            secondBank.setMonthlyUtilityExpense(askNewExpense(scanner, "utility", secondBank.getMonthlyUtilityExpense()));
        }

            if (secondBank.consultationTransportation()) {
            secondBank.setMonthlyTransportationExpense(askNewExpense(scanner, "transportation", secondBank.getMonthlyTransportationExpense()));
        }

            if (secondBank.consultationEntertainment()) {
            secondBank.setMonthlyEntertainmentExpense(askNewExpense(scanner, "entertainment", secondBank.getMonthlyEntertainmentExpense()));
        }

            if (secondBank.consultationOther()) {
            secondBank.setMonthlyOtherExpense(askNewExpense(scanner, "other", secondBank.getMonthlyOtherExpense()));
        }

            if (secondBank.consultationSavings()){
                System.out.println("What would you like to change your savings to?");
                double newSavings = readMoney(scanner);
                scanner.nextLine();
                if (newSavings < secondBank.getMonthlySavings()){
                    System.out.println("Your new savings is lower than your previous savings. Are you sure you want to change it? (yes/no)");
                    String answer3 = scanner.nextLine();
                    if (answer3.equalsIgnoreCase("yes")) {
                        secondBank.setMonthlySavings(newSavings);
                    } else {
                        System.out.println("Would you like to increase your savings instead? (yes/no)");
                        String answer4 = scanner.nextLine();
                        if (answer4.equalsIgnoreCase("yes")){
                            System.out.println("What would you like to increase your savings to?");
                            double increasedSavings = readMoney(scanner);
                            scanner.nextLine();
                            secondBank.setMonthlySavings(increasedSavings);
                        }
                    }
                } else {
                    secondBank.setMonthlySavings(newSavings);
                }
            }

            System.out.println("New Information:");
            System.out.println("Account Holder Name: " + secondBank.getAccountHolderName());
            System.out.println("Account Number: " + secondBank.getAccountNumber());
            System.out.println("Password: ********");
            System.out.println("Balance: " + secondBank.getBalance());
            System.out.println("Monthly Income: " + secondBank.getMonthlyIncome());
            System.out.println("Monthly Rent Expense: " + secondBank.getMonthlyRentExpense());
            System.out.println("Monthly Food Expense: " + secondBank.getMonthlyFoodExpense());
            System.out.println("Monthly Utility Expense: " + secondBank.getMonthlyUtilityExpense());
            System.out.println("Monthly Transportation Expense: " + secondBank.getMonthlyTransportationExpense());
            System.out.println("Monthly Entertainment Expense: " + secondBank.getMonthlyEntertainmentExpense());
            System.out.println("Monthly Other Expense: " + secondBank.getMonthlyOtherExpense());
            System.out.println("Monthly Savings: " + secondBank.getMonthlySavings());

            boolean added2 = myFinance.addAccount(secondBank);
            if (added2) {
                System.out.println("Second bank account added successfully!");
            } else {
                System.out.println("Could not add second account – portfolio is full.");
            }
        }

        // Let the user set their monthly goals
        // Demonstrates both array creation styles required by the rubric:
        // 1.initializer list
        String[] monthNames = {"January", "February", "March", "April", "May", "June"};  // initializer list

        // 2.new Type[size]
        double[] sampleGoals = new double[6];

        System.out.println("\nNow set your monthly savings goals for the next 6 months.");
        for (int i = 0; i < sampleGoals.length; i++) {
            System.out.println("Enter savings goal for " + monthNames[i] + ":");
            String goalStr = scanner.nextLine();
            while (!goalStr.matches("\\d*\\.?\\d+") && !goalStr.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid number.");
                goalStr = scanner.nextLine();
            }
            sampleGoals[i] = Double.parseDouble(goalStr);
            myFinance.setMonthlyGoal(i, sampleGoals[i]);
        }

        // Show the user the results of the new class and arrays
        System.out.println("\n----- Portfolio Summary -----");
        System.out.println(myFinance.toString());
        System.out.println("Number of accounts in portfolio: " + myFinance.countAccounts());
        System.out.println("Highest balance among accounts: $" + myFinance.getHighestBalance());
        System.out.println("Total balance across accounts: $" + myFinance.getTotalBalance());
        System.out.println("Average monthly savings goal: $" + String.format("%.2f", myFinance.getAverageGoal()));
        System.out.println("Highest monthly savings goal: $" + String.format("%.2f", Finance.findMax(myFinance.getMonthlyGoals())));
        System.out.println("Total Finance portfolios ever created: " + Finance.getPortfoliosCreated());

        // Check if the combined savings of the accounts is higher or lower than the goals
        for (int i = 0; i < 6; i++) {
        System.out.println(monthNames[i] + ": " + myFinance.compareSavingsToGoal(i));
        }

        // a second Finance object so we can use the this comparison
        Finance comparisonPortfolio = new Finance("Comparison User");
        comparisonPortfolio.setMonthlyGoal(0, 300.0);
        comparisonPortfolio.setMonthlyGoal(1, 320.0);
        if (myFinance.hasHigherGoals(comparisonPortfolio)) {
            System.out.println("Your portfolio has higher average goals than the preset comparison portfolio.");
        } else {
            System.out.println("Your portfolio does not have higher average goals than the preset comparison portfolio.");
        }

        // Traverse the goals array with a standard for loop and print them
        System.out.println("\nYour monthly goals:");
        for (int i = 0; i < sampleGoals.length; i++) {
            System.out.printf("  %s goal: $%.2f%n", monthNames[i], sampleGoals[i]);
        }

        System.out.println("\nThank you for using the bank account management system!");
        scanner.close();
    }
}

class Bank{
    // Attributes
    private String accountHolderName;
    private int accountNumber;
    private String password;
    private double balance;
    private double monthlyIncome;
    private double monthlySavings;
    private double monthlyRentExpense;
    private double monthlyFoodExpense;
    private double monthlyUtilityExpense;
    private double monthlyTransportationExpense;
    private double monthlyEntertainmentExpense;
    private double monthlyOtherExpense;

    // No param constructor
    public Bank(){
        this.balance = 0;
        this.monthlyIncome = 0;
        this.monthlyRentExpense = 0;
        this.monthlyFoodExpense = 0;
        this.monthlyUtilityExpense = 0;
        this.monthlyTransportationExpense = 0;
        this.monthlyEntertainmentExpense = 0;
        this.monthlyOtherExpense = 0;
        this.monthlySavings = 0;
    }

    // Param constructor
    public Bank(int accountNumber, String accountHolderName, String password, double balance, double monthlyIncome, double monthlyRentExpense, double monthlyFoodExpense, double monthlyUtilityExpense, double monthlyTransportationExpense, double monthlyEntertainmentExpense, double monthlyOtherExpense) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.balance = balance;
        this.monthlyIncome = monthlyIncome;
        this.monthlyRentExpense = monthlyRentExpense;
        this.monthlyFoodExpense = monthlyFoodExpense;
        this.monthlyUtilityExpense = monthlyUtilityExpense;
        this.monthlyTransportationExpense = monthlyTransportationExpense;
        this.monthlyEntertainmentExpense = monthlyEntertainmentExpense;
        this.monthlyOtherExpense = monthlyOtherExpense;
        this.monthlySavings = monthlyIncome - (monthlyRentExpense + monthlyFoodExpense + monthlyUtilityExpense + monthlyTransportationExpense + monthlyEntertainmentExpense + monthlyOtherExpense);
    }

    // Helper that keeps monthlySavings correct whenever income or an expense changes
    private void recalculateMonthlySavings() {
        this.monthlySavings = this.monthlyIncome - (this.monthlyRentExpense + this.monthlyFoodExpense + this.monthlyUtilityExpense + this.monthlyTransportationExpense + this.monthlyEntertainmentExpense + this.monthlyOtherExpense);
    }

    // Method for adding money to the account
    public double deposit(double amount){
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return this.balance;
        }
        this.balance += amount;
        return this.balance;
    }

    // Method for withdrawing money from the account
    public double withdraw(double amount){
        if(amount > 0 && this.balance >= amount){
            this.balance -= amount;
            return this.balance;
        } else {
            System.out.println("Insufficient balance");
            return this.balance;
        }
    }

    // Method for checking if each expense is within a healthy range based on the monthly income
    public boolean consultationRent(){
        if(this.monthlyRentExpense > this.monthlyIncome * 0.3 ){
            System.out.println("Your rent expense is too high. Consider reducing your rent expense.");
            return true;
        }
        else {
            System.out.println("Your rent expense is within a healthy range.");
            return false;
        }
    }

    public boolean consultationFood(){
        if(this.monthlyFoodExpense > this.monthlyIncome * 0.15){
            System.out.println("Your food expense is too high. Consider reducing your food expense.");
            return true;
        }
        else {
            System.out.println("Your food expense is within a healthy range.");
            return false;
        }
    }

    public boolean consultationUtility(){
        if(this.monthlyUtilityExpense  > this.monthlyIncome * 0.1){
            System.out.println("Your utility expense is too high. Consider reducing your utility expense.");
            return true;
        }
        else {
            System.out.println("Your utility expense is within a healthy range.");
            return false;
        }
    }

    public boolean consultationTransportation(){
        if(this.monthlyTransportationExpense > this.monthlyIncome * 0.1){
            System.out.println("Your transportation expense is too high. Consider reducing your transportation expense.");
            return true;
        }
        else {
            System.out.println("Your transportation expense is within a healthy range.");
            return false;
        }
    }

    public boolean consultationEntertainment(){
        if(this.monthlyEntertainmentExpense > this.monthlyIncome * 0.1){
            System.out.println("Your entertainment expense is too high. Consider reducing your entertainment expense.");
            return true;
        }
        else {
            System.out.println("Your entertainment expense is within a healthy range.");
            return false;
        }
    }

    public boolean consultationOther(){
        if(this.monthlyOtherExpense > this.monthlyIncome * 0.5){
            System.out.println("Your other expense is too high. Consider reducing your other expense.");
            return true;
        }
        else {
            System.out.println("Your other expense is within a healthy range.");
            return false;
        }
    }

    public boolean consultationSavings(){
        if(this.monthlySavings < this.monthlyIncome * 0.2){
            System.out.println("Your savings is too low. Consider increasing your savings.");
            return true;
        }
        else {
            System.out.println("Your savings is within a healthy range.");
            return false;
        }
    }

    //getters
    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getMonthlyIncome() {
        return this.monthlyIncome;
    }

    public double getMonthlyRentExpense() {
        return this.monthlyRentExpense;
    }

    public double getMonthlyFoodExpense() {
        return this.monthlyFoodExpense;
    }

    public double getMonthlyUtilityExpense() {
        return this.monthlyUtilityExpense;
    }

    public double getMonthlyTransportationExpense() {
        return this.monthlyTransportationExpense;
    }

    public double getMonthlyEntertainmentExpense() {
        return this.monthlyEntertainmentExpense;
    }

    public double getMonthlyOtherExpense() {
        return this.monthlyOtherExpense;
    }

    public double getMonthlySavings() {
        return this.monthlySavings;
    }

    //setters – each expense/income setter recalculates monthlySavings

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
        recalculateMonthlySavings();
    }

    public void setMonthlyRentExpense(double monthlyRentExpense) {
        this.monthlyRentExpense = monthlyRentExpense;
        recalculateMonthlySavings();
    }

    public void setMonthlyFoodExpense(double monthlyFoodExpense) {
        this.monthlyFoodExpense = monthlyFoodExpense;
        recalculateMonthlySavings();
    }

    public void setMonthlyUtilityExpense(double monthlyUtilityExpense) {
        this.monthlyUtilityExpense = monthlyUtilityExpense;
        recalculateMonthlySavings();
    }

    public void setMonthlyTransportationExpense(double monthlyTransportationExpense) {
        this.monthlyTransportationExpense = monthlyTransportationExpense;
        recalculateMonthlySavings();
    }

    public void setMonthlyEntertainmentExpense(double monthlyEntertainmentExpense) {
        this.monthlyEntertainmentExpense = monthlyEntertainmentExpense;
        recalculateMonthlySavings();
    }

    public void setMonthlyOtherExpense(double monthlyOtherExpense) {
        this.monthlyOtherExpense = monthlyOtherExpense;
        recalculateMonthlySavings();
    }

    public void setMonthlySavings(double monthlySavings) {
        this.monthlySavings = monthlySavings;
    }



    //xtra methods

    public String savingsRate(){
        if (this.monthlyIncome == 0) { return "Your savings rate is: 0%"; }
        double savingsRate = (this.monthlySavings / this.monthlyIncome) * 100;
        return "Your savings rate is: " + savingsRate + "%";
    }

}
// Wendy Wang
// The set up and the services was easy to understand and use.
// Very simple, just place the instriction closer to the input. Other then that very good. Place edge case in for digits.


//Connor Doherty
//make it clear that answers other than 'yes' or 'no' default to 'no'
//catch exception of multiple periods in an input number being accepted
//it looks like rent expense doesn't change after the user provides input



/*Krish Sharma
   - I like the clean layout of the code and the use of methods to organize the different functionalities.
   - Ensure all user inputs are validated before processing
*/