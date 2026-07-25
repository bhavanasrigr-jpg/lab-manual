import java.util.*; 
 
class Account { 
    int accountNumber; 
    String name; 
    String phone; 
    String address; 
    double balance; 
 
    Account(int accountNumber, String name, String phone, String address, double balance) { 
        this.accountNumber = accountNumber; 
        this.name = name; 
        this.phone = phone; 
        this.address = address; 
        this.balance = balance; 
    } 
 
    void deposit(double amount) { 
        balance += amount; 
        System.out.println("Amount deposited successfully."); 
    } 
 
    void withdraw(double amount) { 
        if (amount <= balance) { 
            balance -= amount; 
            System.out.println("Withdrawal successful."); 
        } else { 
            System.out.println("Insufficient balance."); 
        } 
    } 
 
    void display() { 
        System.out.println("------------------------------------"); 
        System.out.println("Account Number : " + accountNumber); 
        System.out.println("Name           : " + name); 
        System.out.println("Phone          : " + phone); 
        System.out.println("Address        : " + address); 
        System.out.println("Balance        : ₹" + balance); 
        System.out.println("------------------------------------"); 
    } 
} 
 
public class Main { 
 
    static HashMap<Integer, Account> accounts = new HashMap<>(); 
    static Scanner sc = new Scanner(System.in); 
 
    public static void createAccount() { 
 
        System.out.print("Enter Account Number: "); 
        int accNo = sc.nextInt(); 
 
        if (accounts.containsKey(accNo)) { 
            System.out.println("Account already exists."); 
            return; 
        } 
 
        sc.nextLine(); 
 
        System.out.print("Enter Name: "); 
        String name = sc.nextLine(); 
 
        System.out.print("Enter Phone: "); 
        String phone = sc.nextLine(); 
 
        System.out.print("Enter Address: "); 
        String address = sc.nextLine(); 
 
        System.out.print("Enter Initial Deposit: "); 
        double balance = sc.nextDouble(); 
 
        Account account = new Account(accNo, name, phone, address, balance); 
 
        accounts.put(accNo, account); 
 
        System.out.println("Account created successfully."); 
    } 
 
    public static void deposit() { 
 
        System.out.print("Enter Account Number: "); 
        int accNo = sc.nextInt(); 
 
        Account account = accounts.get(accNo); 
 
        if (account == null) { 
            System.out.println("Account not found."); 
            return; 
        } 
 
        System.out.print("Enter Amount: "); 
        double amount = sc.nextDouble(); 
 
        account.deposit(amount); 
 
        System.out.println("Current Balance: ₹" + account.balance); 
    } 
 
    public static void withdraw() { 
 
        System.out.print("Enter Account Number: "); 
        int accNo = sc.nextInt(); 
 
        Account account = accounts.get(accNo); 
 
        if (account == null) { 
            System.out.println("Account not found."); 
            return; 
        } 
 
        System.out.print("Enter Amount: "); 
        double amount = sc.nextDouble(); 
 
        account.withdraw(amount); 
 
        System.out.println("Current Balance: ₹" + account.balance); 
    } 
 
    public static void checkBalance() { 
 
        System.out.print("Enter Account Number: "); 
        int accNo = sc.nextInt(); 
 
        Account account = accounts.get(accNo); 
 
        if (account == null) { 
            System.out.println("Account not found."); 
            return; 
        } 
 
        System.out.println("Current Balance: ₹" + account.balance); 
    } 
 
    public static void transferMoney() { 
 
        System.out.print("From Account Number: "); 
        int from = sc.nextInt(); 
 
        System.out.print("To Account Number: "); 
        int to = sc.nextInt(); 
 
        Account sender = accounts.get(from); 
        Account receiver = accounts.get(to); 
 
        if (sender == null || receiver == null) { 
            System.out.println("Invalid account number."); 
            return; 
        } 
 
        System.out.print("Enter Amount: "); 
        double amount = sc.nextDouble(); 
 
        if (sender.balance >= amount) { 
            sender.balance -= amount; 
            receiver.balance += amount; 
            System.out.println("Transfer successful."); 
        } else { 
            System.out.println("Insufficient balance."); 
        } 
    } 
 
    public static void viewAccounts() { 
 
        if (accounts.isEmpty()) { 
            System.out.println("No accounts available."); 
            return; 
        } 
 
        for (Account account : accounts.values()) { 
            account.display(); 
        } 
    } 
 
    public static void deleteAccount() { 
 
        System.out.print("Enter Account Number: "); 
        int accNo = sc.nextInt(); 
 
        if (accounts.remove(accNo) != null) { 
            System.out.println("Account deleted successfully."); 
        } else { 
            System.out.println("Account not found."); 
        } 
    } 
 
    public static void searchAccount() { 
 
        System.out.print("Enter Account Number: "); 
        int accNo = sc.nextInt(); 
 
        Account account = accounts.get(accNo); 
 
        if (account != null) { 
            account.display(); 
        } else { 
            System.out.println("Account not found."); 
        } 
    } 
 
    public static void main(String[] args) { 
 
        int choice; 
 
        do { 
 
            System.out.println("\n========================================"); 
            System.out.println("      BANK MANAGEMENT SYSTEM"); 
            System.out.println("========================================"); 
            System.out.println("1. Create Account"); 
            System.out.println("2. Deposit Money"); 
            System.out.println("3. Withdraw Money"); 
            System.out.println("4. Check Balance"); 
            System.out.println("5. Transfer Money"); 
            System.out.println("6. View All Accounts"); 
            System.out.println("7. Search Account"); 
            System.out.println("8. Delete Account"); 
            System.out.println("9. Exit"); 
            System.out.print("Enter your choice: "); 
 
            choice = sc.nextInt(); 
 
            switch (choice) { 
 
                case 1: 
                    createAccount(); 
                    break; 
 
                case 2: 
                    deposit(); 
                    break; 
 
                case 3: 
                    withdraw(); 
                    break; 
 
                case 4: 
                    checkBalance(); 
                    break; 
 
                case 5: 
                    transferMoney(); 
                    break; 
 
                case 6: 
                    viewAccounts(); 
                    break; 
 
                case 7: 
                    searchAccount(); 
                    break; 
 
                case 8: 
                    deleteAccount(); 
                    break; 
 
                case 9: 
                    System.out.println("Thank you for using Bank Management System."); 
                    break; 
 
                default: 
                    System.out.println("Invalid choice."); 
            } 
 
        } while (choice != 9); 
 
        sc.close(); 
    } 
} 
 
