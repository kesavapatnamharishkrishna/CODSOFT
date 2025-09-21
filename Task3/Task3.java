import java.util.Scanner;


class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        balance = initialBalance;
    }

    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
    
    public double getBalance() 
    {
        return balance;
    }  
}

class ATM 
{
    private BankAccount account;

    public ATM(BankAccount account) 
    {
        this.account = account;
    }

    public void deposit(double amount) 
    {
        if (amount <= 0) 
        {
            System.out.println("Deposit amount must be greater than 0.");
        } 
        else 
        {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) 
    {
        if (amount <= 0) 
        {
            System.out.println("Withdrawal amount must be greater than 0.");
        } 
        else if (amount > account.getBalance()) 
        {
            System.out.println("Insufficient balance! Withdrawal failed.");
        } 
        else 
        {
            account.setBalance(account.getBalance() - amount);
            System.out.println(" Withdrawn: " + amount);
        }
    }

    public void checkBalance() 
    {
        System.out.println("Current Balance: " + account.getBalance());
    }
}

public class ATMSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM(userAccount);

        while (true) 
        {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    atm.withdraw(w);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    atm.deposit(d);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
