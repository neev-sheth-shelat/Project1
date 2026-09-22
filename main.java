import java.util.Scanner;

public class main{
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
        }

        
      

        System.out.println("Please enter your starting balance in only digits: ");
        String startingBalance1 = scanner.nextLine();
        double startingBalance = Double.parseDouble(startingBalance1.replaceAll("[^0-9.]", ""));

        System.out.println("Please enter your monthly income in only digits:");
        String monthlyIncome1 = scanner.nextLine();
        double monthlyIncome = Double.parseDouble(monthlyIncome1.replaceAll("[^0-9.]", ""));

        System.out.println("Please enter your monthly rent expense in only digits:");
        String monthlyRentExpense1 = scanner.nextLine();
        double monthlyRentExpense = Double.parseDouble(monthlyRentExpense1.replaceAll("[^0-9.]", ""));

        System.out.println("Please enter your monthly food expense in only digits:");
        String monthlyFoodExpense1 = scanner.nextLine();
        double monthlyFoodExpense = Double.parseDouble(monthlyFoodExpense1.replaceAll("[^0-9.]", ""));

        System.out.println("Please enter your monthly utility expense in only digits:");
        String monthlyUtilityExpense1 = scanner.nextLine();
        double monthlyUtilityExpense = Double.parseDouble(monthlyUtilityExpense1.replaceAll("[^0-9.]", ""));

        System.out.println("Please enter your monthly transportation expense in only digits:");
        String monthlyTransportationExpense1 = scanner.nextLine();
        double monthlyTransportationExpense = Double.parseDouble(monthlyTransportationExpense1.replaceAll("[^0-9.]", ""));

        System.out.println("Please enter your monthly entertainment expense in only digits:");
        String monthlyEntertainmentExpense1 = scanner.nextLine();
        double monthlyEntertainmentExpense = Double.parseDouble(monthlyEntertainmentExpense1.replaceAll("[^0-9.]", ""));

        System.out.println("Please enter your monthly other expense in only digits:");
        String monthlyOtherExpense1 = scanner.nextLine();
        double monthlyOtherExpense = Double.parseDouble(monthlyOtherExpense1.replaceAll("[^0-9.]", ""));

        // Create a bank object with the user input
        Bank userBank = new Bank(accountNumber, accountHolderName, password, startingBalance, monthlyIncome, monthlyRentExpense, monthlyFoodExpense, monthlyUtilityExpense, monthlyTransportationExpense, monthlyEntertainmentExpense, monthlyOtherExpense);


        //check if the user wants to change any of the information they entered
        System.out.println("Does your account information look correct? (yes/no)");
        System.out.println("Account Holder Name: " + userBank.getAccountHolderName());
        System.out.println("Account Number: " + userBank.getAccountNumber());
        System.out.println("Password: " + userBank.getPassword());
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

        if (answer2.equalsIgnoreCase("no")) {
            System.out.println("Please restart the program and enter the correct information.");
            System.exit(0);
        }

        else {
            System.out.println("Great! Let's continue.");
        }

        // Check if the user wants to change any of the expenses
        if (userBank.consultationRent()){
            System.out.println("What would you like to change your rent expense to?");
            double newRentExpense = scanner.nextDouble();
            scanner.nextLine();
            if(newRentExpense> monthlyRentExpense){
                System.out.println("Your new rent expense is higher than your previous rent expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if(answer3.equalsIgnoreCase("no")){
                    System.out.println("Would you like to decrease your rent expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if(answer4.equalsIgnoreCase("yes")){
                        System.out.println("What would you like to decrease your rent expense to?");
                        double decreasedRentExpense = scanner.nextDouble();
                        userBank.setMonthlyRentExpense(decreasedRentExpense);
                    }
                }
                else{
                    userBank.setMonthlyRentExpense(newRentExpense);
                }
            }
           
                
            
        }

      
        if (userBank.consultationFood()){
            System.out.println("What would you like to change your food expense to?");
            double newFoodExpense = scanner.nextDouble();
            scanner.nextLine();
            if(newFoodExpense> monthlyFoodExpense){
                System.out.println("Your new food expense is higher than your previous food expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if(answer3.equalsIgnoreCase("no")){
                    System.out.println("Would you like to decrease your food expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if(answer4.equalsIgnoreCase("yes")){
                        System.out.println("What would you like to decrease your food expense to?");
                        double decreasedFoodExpense = scanner.nextDouble();
                        userBank.setMonthlyFoodExpense(decreasedFoodExpense);
                    }
                }
                else{
                    userBank.setMonthlyFoodExpense(newFoodExpense);
                }
            }
        }

        
        if (userBank.consultationUtility()){
            System.out.println("What would you like to change your utility expense to?");
            double newUtilityExpense = scanner.nextDouble();
            scanner.nextLine();
            if(newUtilityExpense> monthlyUtilityExpense){
                System.out.println("Your new utility expense is higher than your previous utility expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if(answer3.equalsIgnoreCase("no")){
                    System.out.println("Would you like to decrease your utility expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if(answer4.equalsIgnoreCase("yes")){
                        System.out.println("What would you like to decrease your utility expense to?");
                        double decreasedUtilityExpense = scanner.nextDouble();
                        userBank.setMonthlyUtilityExpense(decreasedUtilityExpense);
                    }
                }
                else{
                    userBank.setMonthlyUtilityExpense(newUtilityExpense);
                }
            }
        }

        if(userBank.consultationTransportation()){
            System.out.println("What would you like to change your transportation expense to?");
            double newTransportationExpense = scanner.nextDouble();
            scanner.nextLine();
            if(newTransportationExpense> monthlyTransportationExpense){
                System.out.println("Your new transportation expense is higher than your previous transportation expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if(answer3.equalsIgnoreCase("no")){
                    System.out.println("Would you like to decrease your transportation expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if(answer4.equalsIgnoreCase("yes")){
                        System.out.println("What would you like to decrease your transportation expense to?");
                        double decreasedTransportationExpense = scanner.nextDouble();
                        userBank.setMonthlyTransportationExpense(decreasedTransportationExpense);
                    }
                }
                else{
                    userBank.setMonthlyTransportationExpense(newTransportationExpense);
                }
            }
        }

        if (userBank.consultationEntertainment()){
            System.out.println("What would you like to change your entertainment expense to?");
            double newEntertainmentExpense = scanner.nextDouble();
            scanner.nextLine();
            if(newEntertainmentExpense> monthlyEntertainmentExpense){
                System.out.println("Your new entertainment expense is higher than your previous entertainment expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if(answer3.equalsIgnoreCase("no")){
                    System.out.println("Would you like to decrease your entertainment expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if(answer4.equalsIgnoreCase("yes")){
                        System.out.println("What would you like to decrease your entertainment expense to?");
                        double decreasedEntertainmentExpense = scanner.nextDouble();
                        userBank.setMonthlyEntertainmentExpense(decreasedEntertainmentExpense);
                    }
                }
                else{
                    userBank.setMonthlyEntertainmentExpense(newEntertainmentExpense);
                }
            }
        }

        if (userBank.consultationOther()){
            System.out.println("What would you like to change your other expense to?");
            double newOtherExpense = scanner.nextDouble();
            scanner.nextLine();
            if(newOtherExpense> monthlyOtherExpense){
                System.out.println("Your new other expense is higher than your previous other expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if(answer3.equalsIgnoreCase("no")){
                    System.out.println("Would you like to decrease your other expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if(answer4.equalsIgnoreCase("yes")){
                        System.out.println("What would you like to decrease your other expense to?");
                        double decreasedOtherExpense = scanner.nextDouble();
                        userBank.setMonthlyOtherExpense(decreasedOtherExpense);
                    }
                }
                else{
                    userBank.setMonthlyOtherExpense(newOtherExpense);
                }
            }
        }

        if (userBank.consultationSavings()){
            System.out.println("What would you like to change your savings to?");
            double newSavings = scanner.nextDouble();
            scanner.nextLine();
            if(newSavings < userBank.getMonthlySavings()){
                System.out.println("Your new savings is lower than your previous savings. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if(answer3.equalsIgnoreCase("no")){
                    System.out.println("Would you like to increase your savings instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if(answer4.equalsIgnoreCase("yes")){
                        System.out.println("What would you like to increase your savings to?");
                        double increasedSavings = scanner.nextDouble();
                        userBank.setMonthlySavings(increasedSavings);
                    }
                }
                else{
                    userBank.setMonthlySavings(newSavings);
                }
            }
        }

        System.out.println("New Information:");
        System.out.println("Account Holder Name: " + userBank.getAccountHolderName());
        System.out.println("Account Number: " + userBank.getAccountNumber());
        System.out.println("Password: " + userBank.getPassword());
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

            int choice = scanner.nextInt();

            if(choice == 1){
                System.out.println("How much would you like to deposit?");
                double depositAmount = scanner.nextDouble();
                userBank.deposit(depositAmount);
                System.out.println("Your new balance is: " + userBank.getBalance());
               
            }

            else if(choice == 2){
                System.out.println("How much would you like to withdraw?");
                double withdrawAmount = scanner.nextDouble();
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
        double totalSavings = 0;
        double monthlySavings = userBank.getMonthlySavings();
        System.out.println("Usual Savings: " + monthlySavings + ", Savings Rate: " + userBank.savingsRate());
        while(month <= 12){
            if(Math.random() < 0.2){
                System.out.println("You have gotten a bonus this month! Your savings will be increased by 10%.");
                monthlySavings *= 1.1;
            }
            totalSavings += monthlySavings;
            System.out.printf("Month %2d | Total Savings: $%.2f%n", month, totalSavings);
            month++;
        }


        System.out.println("Thank you for using the bank account management system!");
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

    // Method for adding money to the account
    public double deposit(double amount){
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

    //setters

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setMonthlyRentExpense(double monthlyRentExpense) {
        this.monthlyRentExpense = monthlyRentExpense;
    }

    public void setMonthlyFoodExpense(double monthlyFoodExpense) {
        this.monthlyFoodExpense = monthlyFoodExpense;
    }

    public void setMonthlyUtilityExpense(double monthlyUtilityExpense) {
        this.monthlyUtilityExpense = monthlyUtilityExpense;
    }

    public void setMonthlyTransportationExpense(double monthlyTransportationExpense) {
        this.monthlyTransportationExpense = monthlyTransportationExpense;
    }

    public void setMonthlyEntertainmentExpense(double monthlyEntertainmentExpense) {
        this.monthlyEntertainmentExpense = monthlyEntertainmentExpense;
    }

    public void setMonthlyOtherExpense(double monthlyOtherExpense) {
        this.monthlyOtherExpense = monthlyOtherExpense;
    }

    public void setMonthlySavings(double monthlySavings) {
        this.monthlySavings = monthlySavings;
    }



    //xtra methods

    public String savingsRate(){
        double savingsRate = (this.monthlySavings / this.monthlyIncome) * 100;
        return "Your savings rate is: " + savingsRate + "%";
    }

}
