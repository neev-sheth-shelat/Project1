public class Finance {
    private String ownerName;
    private static Bank[] accounts;
    private double[] monthlyGoals;

    private static int portfoliosCreated = 0;
    private static final int MAX_ACCOUNTS = 5;

    public Finance(String ownerName, int accounts, int monthlyGoals){
        this.ownerName = ownerName;
        this.accounts = new Bank[accounts];
        this.monthlyGoals = new double[monthlyGoals];
        portfoliosCreated++;
    }

    public Finance(String ownerName){
        this(ownerName, MAX_ACCOUNTS, 12);
    }

    public void addAccount(Bank account){
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] == null){
                accounts[i] = account;
                return;
            }
        }
    }
    public double getHighestBalance(){
        double highestBalance = 0;
        for(Bank account : accounts){
            if(account != null){
                double balance = account.getBalance();
                if(balance > highestBalance){
                    highestBalance = balance;
                }
            }
        }
        return highestBalance;
    }

    public static double averageGoals(){
        double total = 0;
        for(int i = 0; i < portfoliosCreated; i++){
            total += accounts[i].getMonthlySavings();
        }
        return total / portfoliosCreated;
    }

    public static int getPortfoliosCreated() {
        return portfoliosCreated;
    }
    
}
