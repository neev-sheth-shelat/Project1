//Finance file is to organize all your bank accounts. 
//You then set monthly goals to achieve for savings.
//Then the code checks all the savings you get from all your bank accounts and tells
//you whether your above or below the goal.


import java.util.Scanner;

public class Main{
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
        }

        
      

        System.out.println("Please enter your starting balance in only digits: ");
        String startingBalance1 = scanner.nextLine();
        while(!startingBalance1.matches("\\d*\\.?\\d+") && !startingBalance1.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid starting balance.");
            startingBalance1 = scanner.nextLine();
        }
        double startingBalance = Double.parseDouble(startingBalance1);

        System.out.println("Please enter your monthly income in only digits:");
        String monthlyIncome1 = scanner.nextLine();
        while(!monthlyIncome1.matches("\\d*\\.?\\d+") && !monthlyIncome1.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid monthly income.");
            monthlyIncome1 = scanner.nextLine();
        }
        double monthlyIncome = Double.parseDouble(monthlyIncome1);

        System.out.println("Please enter your monthly rent expense in only digits:");
        String monthlyRentExpense1 = scanner.nextLine();
        while(!monthlyRentExpense1.matches("\\d*\\.?\\d+") && !monthlyRentExpense1.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid monthly rent expense.");
            monthlyRentExpense1 = scanner.nextLine();
        }
        double monthlyRentExpense = Double.parseDouble(monthlyRentExpense1);

        System.out.println("Please enter your monthly food expense in only digits:");
        String monthlyFoodExpense1 = scanner.nextLine();
        while(!monthlyFoodExpense1.matches("\\d*\\.?\\d+") && !monthlyFoodExpense1.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid monthly food expense.");
            monthlyFoodExpense1 = scanner.nextLine();
        }
        double monthlyFoodExpense = Double.parseDouble(monthlyFoodExpense1);

        System.out.println("Please enter your monthly utility expense in only digits:");
        String monthlyUtilityExpense1 = scanner.nextLine();
        while(!monthlyUtilityExpense1.matches("\\d*\\.?\\d+") && !monthlyUtilityExpense1.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid monthly utility expense.");
            monthlyUtilityExpense1 = scanner.nextLine();
        }
        double monthlyUtilityExpense = Double.parseDouble(monthlyUtilityExpense1);

        System.out.println("Please enter your monthly transportation expense in only digits:");
        String monthlyTransportationExpense1 = scanner.nextLine();
        while(!monthlyTransportationExpense1.matches("\\d*\\.?\\d+") && !monthlyTransportationExpense1.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid monthly transportation expense.");
            monthlyTransportationExpense1 = scanner.nextLine();
        }
        double monthlyTransportationExpense = Double.parseDouble(monthlyTransportationExpense1);

        System.out.println("Please enter your monthly entertainment expense in only digits:");
        String monthlyEntertainmentExpense1 = scanner.nextLine();
        while(!monthlyEntertainmentExpense1.matches("\\d*\\.?\\d+") && !monthlyEntertainmentExpense1.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid monthly entertainment expense.");
            monthlyEntertainmentExpense1 = scanner.nextLine();
        }
        double monthlyEntertainmentExpense = Double.parseDouble(monthlyEntertainmentExpense1);

        System.out.println("Please enter your monthly other expense in only digits:");
        String monthlyOtherExpense1 = scanner.nextLine();
        while(!monthlyOtherExpense1.matches("\\d*\\.?\\d+") && !monthlyOtherExpense1.matches("\\d+\\.\\d*")) {
            System.out.println("Invalid input. Please enter a valid monthly other expense.");
            monthlyOtherExpense1 = scanner.nextLine();
        }
        double monthlyOtherExpense = Double.parseDouble(monthlyOtherExpense1);

        // Create a bank object with the user input
        Bank userBank = new Bank(accountNumber, accountHolderName, password, startingBalance, monthlyIncome, monthlyRentExpense, monthlyFoodExpense, monthlyUtilityExpense, monthlyTransportationExpense, monthlyEntertainmentExpense, monthlyOtherExpense);


        //check if the user wants to change any of the information they entered
        System.out.println("Does your account information look correct? (yes/no), anything else counts as no!");
        System.out.println("Account Holder Name: " + userBank.getAccountHolderName());
        System.out.println("Account Number: " + userBank.getAccountNumber());
        System.out.println("Password: " + password);   
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
        if (userBank.consultationRent()){
            System.out.println("What would you like to change your rent expense to?");
            double newRentExpense = readMoney(scanner);
            scanner.nextLine();
            if (newRentExpense > monthlyRentExpense) {
                System.out.println("Your new rent expense is higher than your previous rent expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if (answer3.equalsIgnoreCase("yes")) {
                    userBank.setMonthlyRentExpense(newRentExpense);
                } else {
                    System.out.println("Would you like to decrease your rent expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if (answer4.equalsIgnoreCase("yes")) {
                        System.out.println("What would you like to decrease your rent expense to?");
                        double decreasedRentExpense = readMoney(scanner);
                        scanner.nextLine();
                        userBank.setMonthlyRentExpense(decreasedRentExpense);
                    }
                }
            } else {
                userBank.setMonthlyRentExpense(newRentExpense);
            }
        }

        if (userBank.consultationFood()){
            System.out.println("What would you like to change your food expense to?");
            double newFoodExpense = readMoney(scanner);
            scanner.nextLine();
            if (newFoodExpense > monthlyFoodExpense) {
                System.out.println("Your new food expense is higher than your previous food expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if (answer3.equalsIgnoreCase("yes")) {
                    userBank.setMonthlyFoodExpense(newFoodExpense);
                } else {
                    System.out.println("Would you like to decrease your food expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if (answer4.equalsIgnoreCase("yes")) {
                        System.out.println("What would you like to decrease your food expense to?");
                        double decreasedFoodExpense = readMoney(scanner);
                        scanner.nextLine();
                        userBank.setMonthlyFoodExpense(decreasedFoodExpense);
                    }
                }
            } else {
                userBank.setMonthlyFoodExpense(newFoodExpense);
            }
        }

        if (userBank.consultationUtility()){
            System.out.println("What would you like to change your utility expense to?");
            double newUtilityExpense = readMoney(scanner);
            scanner.nextLine();
            if (newUtilityExpense > monthlyUtilityExpense) {
                System.out.println("Your new utility expense is higher than your previous utility expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if (answer3.equalsIgnoreCase("yes")) {
                    userBank.setMonthlyUtilityExpense(newUtilityExpense);
                } else {
                    System.out.println("Would you like to decrease your utility expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if (answer4.equalsIgnoreCase("yes")) {
                        System.out.println("What would you like to decrease your utility expense to?");
                        double decreasedUtilityExpense = readMoney(scanner);
                        scanner.nextLine();
                        userBank.setMonthlyUtilityExpense(decreasedUtilityExpense);
                    }
                }
            } else {
                userBank.setMonthlyUtilityExpense(newUtilityExpense);
            }
        }

        if (userBank.consultationTransportation()){
            System.out.println("What would you like to change your transportation expense to?");
            double newTransportationExpense = readMoney(scanner);
            scanner.nextLine();
            if (newTransportationExpense > monthlyTransportationExpense) {
                System.out.println("Your new transportation expense is higher than your previous transportation expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if (answer3.equalsIgnoreCase("yes")) {
                    userBank.setMonthlyTransportationExpense(newTransportationExpense);
                } else {
                    System.out.println("Would you like to decrease your transportation expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if (answer4.equalsIgnoreCase("yes")) {
                        System.out.println("What would you like to decrease your transportation expense to?");
                        double decreasedTransportationExpense = readMoney(scanner);
                        scanner.nextLine();
                        userBank.setMonthlyTransportationExpense(decreasedTransportationExpense);
                    }
                }
            } else {
                userBank.setMonthlyTransportationExpense(newTransportationExpense);
            }
        }

        if (userBank.consultationEntertainment()){
            System.out.println("What would you like to change your entertainment expense to?");
            double newEntertainmentExpense = readMoney(scanner);
            scanner.nextLine();
            if (newEntertainmentExpense > monthlyEntertainmentExpense) {
                System.out.println("Your new entertainment expense is higher than your previous entertainment expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if (answer3.equalsIgnoreCase("yes")) {
                    userBank.setMonthlyEntertainmentExpense(newEntertainmentExpense);
                } else {
                    System.out.println("Would you like to decrease your entertainment expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if (answer4.equalsIgnoreCase("yes")) {
                        System.out.println("What would you like to decrease your entertainment expense to?");
                        double decreasedEntertainmentExpense = readMoney(scanner);
                        scanner.nextLine();
                        userBank.setMonthlyEntertainmentExpense(decreasedEntertainmentExpense);
                    }
                }
            } else {
                userBank.setMonthlyEntertainmentExpense(newEntertainmentExpense);
            }
        }

        if (userBank.consultationOther()){
            System.out.println("What would you like to change your other expense to?");
            double newOtherExpense = readMoney(scanner);
            scanner.nextLine();
            if (newOtherExpense > monthlyOtherExpense) {
                System.out.println("Your new other expense is higher than your previous other expense. Are you sure you want to change it? (yes/no)");
                String answer3 = scanner.nextLine();
                if (answer3.equalsIgnoreCase("yes")) {
                    userBank.setMonthlyOtherExpense(newOtherExpense);
                } else {
                    System.out.println("Would you like to decrease your other expense instead? (yes/no)");
                    String answer4 = scanner.nextLine();
                    if (answer4.equalsIgnoreCase("yes")) {
                        System.out.println("What would you like to decrease your other expense to?");
                        double decreasedOtherExpense = readMoney(scanner);
                        scanner.nextLine();
                        userBank.setMonthlyOtherExpense(decreasedOtherExpense);
                    }
                }
            } else {
                userBank.setMonthlyOtherExpense(newOtherExpense);
            }
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
        System.out.println("Password: " + password);  
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

            System.out.println("Please enter your starting balance in only digits: ");
            String startingBalance2 = scanner.nextLine();
            while (!startingBalance2.matches("\\d*\\.?\\d+") && !startingBalance2.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid starting balance.");
                startingBalance2 = scanner.nextLine();
            }
            double startingBalanceNew = Double.parseDouble(startingBalance2);

            System.out.println("Please enter your monthly income in only digits:");
            String monthlyIncome2 = scanner.nextLine();
            while (!monthlyIncome2.matches("\\d*\\.?\\d+") && !monthlyIncome2.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid monthly income.");
                monthlyIncome2 = scanner.nextLine();
            }
            double monthlyIncomeNew = Double.parseDouble(monthlyIncome2);

            System.out.println("Please enter your monthly rent expense in only digits:");
            String monthlyRentExpense2 = scanner.nextLine();
            while (!monthlyRentExpense2.matches("\\d*\\.?\\d+") && !monthlyRentExpense2.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid monthly rent expense.");
                monthlyRentExpense2 = scanner.nextLine();
            }
            double monthlyRentExpenseNew = Double.parseDouble(monthlyRentExpense2);

            System.out.println("Please enter your monthly food expense in only digits:");
            String monthlyFoodExpense2 = scanner.nextLine();
            while (!monthlyFoodExpense2.matches("\\d*\\.?\\d+") && !monthlyFoodExpense2.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid monthly food expense.");
                monthlyFoodExpense2 = scanner.nextLine();
            }
            double monthlyFoodExpenseNew = Double.parseDouble(monthlyFoodExpense2);

            System.out.println("Please enter your monthly utility expense in only digits:");
            String monthlyUtilityExpense2 = scanner.nextLine();
            while (!monthlyUtilityExpense2.matches("\\d*\\.?\\d+") && !monthlyUtilityExpense2.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid monthly utility expense.");
                monthlyUtilityExpense2 = scanner.nextLine();
            }
            double monthlyUtilityExpenseNew = Double.parseDouble(monthlyUtilityExpense2);

            System.out.println("Please enter your monthly transportation expense in only digits:");
            String monthlyTransportationExpense2 = scanner.nextLine();
            while (!monthlyTransportationExpense2.matches("\\d*\\.?\\d+") && !monthlyTransportationExpense2.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid monthly transportation expense.");
                monthlyTransportationExpense2 = scanner.nextLine();
            }
            double monthlyTransportationExpenseNew = Double.parseDouble(monthlyTransportationExpense2);

            System.out.println("Please enter your monthly entertainment expense in only digits:");
            String monthlyEntertainmentExpense2 = scanner.nextLine();
            while (!monthlyEntertainmentExpense2.matches("\\d*\\.?\\d+") && !monthlyEntertainmentExpense2.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid monthly entertainment expense.");
                monthlyEntertainmentExpense2 = scanner.nextLine();
            }
            double monthlyEntertainmentExpenseNew = Double.parseDouble(monthlyEntertainmentExpense2);

            System.out.println("Please enter your monthly other expense in only digits:");
            String monthlyOtherExpense2 = scanner.nextLine();
            while (!monthlyOtherExpense2.matches("\\d*\\.?\\d+") && !monthlyOtherExpense2.matches("\\d+\\.\\d*")) {
                System.out.println("Invalid input. Please enter a valid monthly other expense.");
                monthlyOtherExpense2 = scanner.nextLine();
            }
            double monthlyOtherExpenseNew = Double.parseDouble(monthlyOtherExpense2);

            // Create the second Bank object with the same constructor style
            Bank secondBank = new Bank(accountNumber2, accountHolderName + " (Account 2)", password,
                    startingBalanceNew, monthlyIncomeNew,
                    monthlyRentExpenseNew, monthlyFoodExpenseNew, monthlyUtilityExpenseNew,
                    monthlyTransportationExpenseNew, monthlyEntertainmentExpenseNew, monthlyOtherExpenseNew);


            // Check if the user wants to change any of the expenses
            if (secondBank.consultationRent()){
                System.out.println("What would you like to change your rent expense to?");
                double newRentExpense = readMoney(scanner);
                scanner.nextLine();
                if (newRentExpense > monthlyRentExpenseNew) {
                    System.out.println("Your new rent expense is higher than your previous rent expense. Are you sure you want to change it? (yes/no)");
                    String answer3 = scanner.nextLine();
                    if (answer3.equalsIgnoreCase("yes")) {
                        secondBank.setMonthlyRentExpense(newRentExpense);
                    } else {
                        System.out.println("Would you like to decrease your rent expense instead? (yes/no)");
                        String answer4 = scanner.nextLine();
                        if (answer4.equalsIgnoreCase("yes")) {
                            System.out.println("What would you like to decrease your rent expense to?");
                            double decreasedRentExpense = readMoney(scanner);
                            scanner.nextLine();
                            secondBank.setMonthlyRentExpense(decreasedRentExpense);
                        }
                    }
                } else {
                    secondBank.setMonthlyRentExpense(newRentExpense);
                }
            }

            if (secondBank.consultationFood()){
                System.out.println("What would you like to change your food expense to?");
                double newFoodExpense = readMoney(scanner);
                scanner.nextLine();
                if (newFoodExpense > monthlyFoodExpenseNew) {
                    System.out.println("Your new food expense is higher than your previous food expense. Are you sure you want to change it? (yes/no)");
                    String answer3 = scanner.nextLine();
                    if (answer3.equalsIgnoreCase("yes")) {
                        secondBank.setMonthlyFoodExpense(newFoodExpense);
                    } else {
                        System.out.println("Would you like to decrease your food expense instead? (yes/no)");
                        String answer4 = scanner.nextLine();
                        if (answer4.equalsIgnoreCase("yes")) {
                            System.out.println("What would you like to decrease your food expense to?");
                            double decreasedFoodExpense = readMoney(scanner);
                            scanner.nextLine();
                            secondBank.setMonthlyFoodExpense(decreasedFoodExpense);
                        }
                    }
                } else {
                    secondBank.setMonthlyFoodExpense(newFoodExpense);
                }
            }

            if (secondBank.consultationUtility()){
                System.out.println("What would you like to change your utility expense to?");
                double newUtilityExpense = readMoney(scanner);
                scanner.nextLine();
                if (newUtilityExpense > monthlyUtilityExpenseNew) {
                    System.out.println("Your new utility expense is higher than your previous utility expense. Are you sure you want to change it? (yes/no)");
                    String answer3 = scanner.nextLine();
                    if (answer3.equalsIgnoreCase("yes")) {
                        secondBank.setMonthlyUtilityExpense(newUtilityExpense);
                    } else {
                        System.out.println("Would you like to decrease your utility expense instead? (yes/no)");
                        String answer4 = scanner.nextLine();
                        if (answer4.equalsIgnoreCase("yes")) {
                            System.out.println("What would you like to decrease your utility expense to?");
                            double decreasedUtilityExpense = readMoney(scanner);
                            scanner.nextLine();
                            secondBank.setMonthlyUtilityExpense(decreasedUtilityExpense);
                        }
                    }
                } else {
                    secondBank.setMonthlyUtilityExpense(newUtilityExpense);
                }
            }

            if (secondBank.consultationTransportation()){
                System.out.println("What would you like to change your transportation expense to?");
                double newTransportationExpense = readMoney(scanner);
                scanner.nextLine();
                if (newTransportationExpense > monthlyTransportationExpenseNew) {
                    System.out.println("Your new transportation expense is higher than your previous transportation expense. Are you sure you want to change it? (yes/no)");
                    String answer3 = scanner.nextLine();
                    if (answer3.equalsIgnoreCase("yes")) {
                        secondBank.setMonthlyTransportationExpense(newTransportationExpense);
                    } else {
                        System.out.println("Would you like to decrease your transportation expense instead? (yes/no)");
                        String answer4 = scanner.nextLine();
                        if (answer4.equalsIgnoreCase("yes")) {
                            System.out.println("What would you like to decrease your transportation expense to?");
                            double decreasedTransportationExpense = readMoney(scanner);
                            scanner.nextLine();
                            secondBank.setMonthlyTransportationExpense(decreasedTransportationExpense);
                        }
                    }
                } else {
                    secondBank.setMonthlyTransportationExpense(newTransportationExpense);
                }
            }

            if (secondBank.consultationEntertainment()){
                System.out.println("What would you like to change your entertainment expense to?");
                double newEntertainmentExpense = readMoney(scanner);
                scanner.nextLine();
                if (newEntertainmentExpense > monthlyEntertainmentExpenseNew) {
                    System.out.println("Your new entertainment expense is higher than your previous entertainment expense. Are you sure you want to change it? (yes/no)");
                    String answer3 = scanner.nextLine();
                    if (answer3.equalsIgnoreCase("yes")) {
                        secondBank.setMonthlyEntertainmentExpense(newEntertainmentExpense);
                    } else {
                        System.out.println("Would you like to decrease your entertainment expense instead? (yes/no)");
                        String answer4 = scanner.nextLine();
                        if (answer4.equalsIgnoreCase("yes")) {
                            System.out.println("What would you like to decrease your entertainment expense to?");
                            double decreasedEntertainmentExpense = readMoney(scanner);
                            scanner.nextLine();
                            secondBank.setMonthlyEntertainmentExpense(decreasedEntertainmentExpense);
                        }
                    }
                } else {
                    secondBank.setMonthlyEntertainmentExpense(newEntertainmentExpense);
                }
            }

            if (secondBank.consultationOther()){
                System.out.println("What would you like to change your other expense to?");
                double newOtherExpense = readMoney(scanner);
                scanner.nextLine();
                if (newOtherExpense > monthlyOtherExpenseNew) {
                    System.out.println("Your new other expense is higher than your previous other expense. Are you sure you want to change it? (yes/no)");
                    String answer3 = scanner.nextLine();
                    if (answer3.equalsIgnoreCase("yes")) {
                        secondBank.setMonthlyOtherExpense(newOtherExpense);
                    } else {
                        System.out.println("Would you like to decrease your other expense instead? (yes/no)");
                        String answer4 = scanner.nextLine();
                        if (answer4.equalsIgnoreCase("yes")) {
                            System.out.println("What would you like to decrease your other expense to?");
                            double decreasedOtherExpense = readMoney(scanner);
                            scanner.nextLine();
                            secondBank.setMonthlyOtherExpense(decreasedOtherExpense);
                        }
                    }
                } else {
                    secondBank.setMonthlyOtherExpense(newOtherExpense);
                }
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
            System.out.println("Password: " + password);  
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
            System.out.println("Your portfolio has higher average goals than the comparison portfolio.");
        } else {
            System.out.println("Your portfolio does not have higher average goals than the comparison portfolio.");
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