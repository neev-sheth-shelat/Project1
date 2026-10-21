
 //Finance represents a user's overall financial portfolio.
 // It holds multiple Bank accounts and a set of monthly savings goals.
 
public class Finance {

    // static: counter shared by every Finance object 
    private static int portfoliosCreated = 0;

    // static constant: every Finance object uses the same default account limit
    public static final int MAX_ACCOUNTS = 5;

    //instance variables 
    private String ownerName;
    private Bank[] accounts;          // array of objects of the original class
    private double[] monthlyGoals;    // savings goal for each of 12 months
    private int accountCount;         // how many accounts have been added so far

    /**
     * Full constructor.
     * Precondition:  numAccounts > 0 and numGoals > 0
     * Postcondition: a Finance object is created with empty account slots
     *                and zeroed goal array; portfoliosCreated is increased by 1
     */
    public Finance(String ownerName, int numAccounts, int numGoals) {
        this.ownerName = ownerName;
        this.accounts = new Bank[numAccounts];   
        this.monthlyGoals = new double[numGoals];
        this.accountCount = 0;
        portfoliosCreated++;
    }

    
     //Overloaded constructor that uses the default MAX_ACCOUNTS and 12 goals.
      //Demonstrates this(...) to call the other constructor.
     
    public Finance(String ownerName) {
        this(ownerName, MAX_ACCOUNTS, 12);   // this(...) constructor call
    }

    /**
     * Adds a Bank account to the first empty slot.
     * Precondition: account is not null
     * Postcondition: returns true if the account was added;
     *                returns false and leaves the array unchanged if full
     */
    public boolean addAccount(Bank account) {
        for (int i = 0; i < this.accounts.length; i++) {   // standard for loop
            if (this.accounts[i] == null) {
                this.accounts[i] = account;
                this.accountCount++;
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the savings goal for a specific month.
     * Precondition: 0 <= month < monthlyGoals.length and goal >= 0
     * Postcondition: monthlyGoals[month] equals the given goal
     */
    public void setMonthlyGoal(int month, double goal) {
        if (month >= 0 && month < this.monthlyGoals.length && goal >= 0) {
            this.monthlyGoals[month] = goal;
        }
    }

    
     //Returns the highest balance among all non-null accounts.
     //Uses an enhanced for loop and null check.
     
    public double getHighestBalance() {
        double highest = 0;
        for (Bank account : this.accounts) {               // enhanced for loop
            if (account != null && account.getBalance() > highest) {
                highest = account.getBalance();
            }
        }
        return highest;
    }

    
   
    // Counts how many accounts currently exist (non-null).
    //  Precondition: accounts array has been initialized.
    //  Postcondition: returns the number of non-null Bank objects in the array.
     
    public int countAccounts() {
        int count = 0;
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] != null) {
                count++;
            }
        }
        return count;
    }

   
     //Calculates the average of the monthly goals array.
     //Static because it only needs the array parameter – no instance data required.
    
    public static double average(double[] values) {
        if (values == null || values.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (double v : values) {                          // enhanced for loop
            sum += v;
        }
        return sum / values.length;
    }

    
    //Instance method that uses the static average helper on this object's goals.
    //  Precondition: monthlyGoals has been initialized.
    //  Postcondition: returns the average of all values in monthlyGoals.
     
    public double getAverageGoal() {
        return average(this.monthlyGoals);
    }

    
     //Compares this portfolio's average goal to another Finance object.
 
    public boolean hasHigherGoals(Finance other) {
        return this.getAverageGoal() > other.getAverageGoal();
    }



    
    /**
     * Compares the combined monthly savings of all accounts to the goal for one month.
     * Precondition:  0 <= month < monthlyGoals.length
     * Postcondition: returns a message stating whether the total savings of every
     *                account is higher than, lower than, or equal to that month's goal
     */
    public String compareSavingsToGoal(int month) {
        if (month < 0 || month >= this.monthlyGoals.length) {
            return "Invalid month.";
        }

        // add up the monthly savings of every non-null account
        double totalSavings = 0;
        for (Bank account : this.accounts) {               // enhanced for loop
            if (account != null) {
                totalSavings += account.getMonthlySavings();
            }
        }

        double goal = this.monthlyGoals[month];
        if (totalSavings > goal) {
            return "Your total monthly savings of $" + String.format("%.2f", totalSavings)
                    + " is higher than your goal of $" + String.format("%.2f", goal) + ".";
        } else if (totalSavings < goal) {
            return "Your total monthly savings of $" + String.format("%.2f", totalSavings)
                    + " is lower than your goal of $" + String.format("%.2f", goal) + ".";
        } else {
            return "Your total monthly savings of $" + String.format("%.2f", totalSavings)
                    + " is exactly equal to your goal of $" + String.format("%.2f", goal) + ".";
        }
    }

    
    //  accessors 
    public String getOwnerName() {
        return this.ownerName;
    }

    public int getAccountCount() {
        return this.accountCount;
    }

    public double[] getMonthlyGoals() {
        return this.monthlyGoals;
    }

    //  mutator 
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;   // this.name = name style
    }

   
     //Static method: belongs to the class
    //Returns how many Finance portfolios have ever been created.
   
    public static int getPortfoliosCreated() {
        return portfoliosCreated;
    }

    
     //Returns a readable summary of the portfolio.
     
    public String toString() {
        return this.ownerName + "'s Finance Portfolio ("
                + this.accountCount + " accounts, avg goal $"
                + String.format("%.2f", this.getAverageGoal()) + ")";
    }
}