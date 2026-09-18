include java.util.Scanner;

public class main{
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the bank account management system!");

        // Prompt the user for all the necessary information to create a bank object
        System.out.println("Please enter you starting balance: ")
        double startingBalance = scanner.nextDouble();

        System.out.println("Please enter you monthly income:");
        double monthlyIncome = scanner.nextDouble();

        System.out.println("Please enter your monthly rent expense:");
        double monthlyRentExpense = scanner.nextDouble();

        System.out.println("Please enter your monthly food expense:");
        double monthlyFoodExpense = scanner.nextDouble();

        System.out.println("Please enter your monthly utility expense:");
        double monthlyUtilityExpense = scanner.nextDouble();

        System.out.println("Please enter your monthly transportation expense:");
        double monthlyTransportationExpense = scanner.nextDouble();

        System.out.println("Please enter your monthly entertainment expense:");
        double monthlyEntertainmentExpense = scanner.nextDouble();

        System.out.println("Please enter your monthly other expense:");
        double monthlyOtherExpense = scanner.nextDouble();


        // Create a bank object with the user input
        bank userBank = new bank(startingBalance, monthlyIncome, monthlyRentExpense, monthlyFoodExpense, monthlyUtilityExpense, monthlyTransportationExpense, monthlyEntertainmentExpense, monthlyOtherExpense);

        userBank.consultationRent();
        if (userBank.consultationRent()){
            System.out.println("What would you like to change your rent expense to?");
            double newRentExpense = scanner.nextDouble();
            userBank.setMonthlyRentExpense(newRentExpense);
        }

        userBank.consultationFood();
        if (userBank.consultationFood()){
            System.out.println("What would you like to change your food expense to?");
            double newFoodExpense = scanner.nextDouble();
            userBank.setMonthlyFoodExpense(newFoodExpense);
        }

        userBank.consultationUtility();
        if (userBank.consultationUtility()){
            System.out.println("What would you like to change your utility expense to?");
            double newUtilityExpense = scanner.nextDouble();
            userBank.setMonthlyUtilityExpense(newUtilityExpense);
        }
    }
}

class bank{
    // Attributes
    private double balance;
    private double monthlyIncome;
    public double monthlySavings;
    private double monthlyRentExpense;
    private double monthlyFoodExpense;
    private double monthlyUtilityExpense;
    private double monthlyTransportationExpense;
    private double monthlyEntertainmentExpense;
    private double monthlyOtherExpense;

    // No param constructor
    public bank(){
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
    public bank(double balance, double monthlyIncome, double monthlyRentExpense, double monthlyFoodExpense, double monthlyUtilityExpense, double monthlyTransportationExpense, double monthlyEntertainmentExpense, double monthlyOtherExpense) {
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
        if(this.balance >= amount){
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
            return false;
        }
        else {
            System.out.println("Your rent expense is within a healthy range.");
            return true;
        }
    }

    public boolean consultationFood(){
        if(this.monthlyFoodExpense > this.monthlyIncome * 0.15){
            System.out.println("Your food expense is too high. Consider reducing your food expense.");
            return false;
        }
        else {
            System.out.println("Your food expense is within a healthy range.");
            return true;
        }
    }

    public boolean consultationUtility(){
        if(this.monthlyUtilityExpense  > this.monthlyIncome * 0.1){
            System.out.println("Your utility expense is too high. Consider reducing your utility expense.");
            return false;
        }
        else {
            System.out.println("Your utility expense is within a healthy range.");
            return true;
        }
    }

    public boolean consultationTransportation(){
        if(this.monthlyTransportationExpense > this.monthlyIncome * 0.1){
            System.out.println("Your transportation expense is too high. Consider reducing your transportation expense.");
            return false;
        }
        else {
            System.out.println("Your transportation expense is within a healthy range.");
            return true;
        }
    }

    public boolean consultationEntertainment(){
        if(this.monthlyEntertainmentExpense > this.monthlyIncome * 0.1){
            System.out.println("Your entertainment expense is too high. Consider reducing your entertainment expense.");
            return false;
        }
        else {
            System.out.println("Your entertainment expense is within a healthy range.");
            return true;
        }
    }

    public boolean consultationOther(){
        if(this.monthlyOtherExpense > this.monthlyIncome * 0.5){
            System.out.println("Your other expense is too high. Consider reducing your other expense.");
            return false;
        }
        else {
            System.out.println("Your other expense is within a healthy range.");
            return true;
        }
    }

    public boolean consultationSavings(){
        if(this.monthlySavings < this.monthlyIncome * 0.2){
            System.out.println("Your savings is too low. Consider increasing your savings.");
            return false;
        }
        else {
            System.out.println("Your savings is within a healthy range.");
            return true;
        }
    }

    //getters

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


}