
import java.util.Scanner;

public class atmMachine {
    //Account details
    static double balance = 10000.0;
    static int pin = 1234;
    static String accHolder = "Shiva Singh";
    static String accNumber = "HDFC-001";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printWelcome();

        boolean isLoggedIn = verifyPin(sc);

        if(!isLoggedIn){
            System.out.println("Too many failed attempts. Card blocked!");
            sc.close();
            return;
        }
        //show menu
        while(true){
            int choice = showMenu(sc);
            switch(choice){
                case 1: checkBalance();
                        break;
                case 2: deposit(sc);
                        break;
                case 3: withdraw(sc);
                        break;
                case 4: 
                System.out.println("\nThank you for banking with us. Goodbye!");
                sc.close();
                return;
                default:
                    System.out.println("Invalid option! Please choose 1 to 4.");
            }
        }
    }
    public static void printWelcome(){
        System.out.println("===========================================================");
        System.out.println("               Welcome to HDFC bank ATM.                   ");
        System.out.println("===========================================================");
        
    }
    public static boolean verifyPin(Scanner sc){
        int attempts = 0;
        do { 
            System.out.println("\nEnter PIN : ");
            int enteredPin = sc.nextInt();

            if(enteredPin == pin){
                System.out.println("Login Successful! Welcome, " + accHolder);
                return true;
            }
            else{
                attempts++;
                System.out.println("Wrong PIN! Attempts left : " + (3-attempts));
            }
        } while (attempts<3);

        return false;
    }
    public static int showMenu(Scanner sc){
        System.out.println("===========================================================");
        System.out.println("                        ATM MENU                           ");
        System.out.println("===========================================================");
        System.out.println(" 1. Check Balance");
        System.out.println(" 2. Deposit Money");
        System.out.println(" 3. Withdraw Money");
        System.out.println(" 4. Exit");
        System.out.println("===========================================================");
        System.out.println("Choose an option : ");
        return sc.nextInt();
    }
    public static void checkBalance(){
        System.out.println("\n---Account Details---");
        System.out.println("Account Holder : " + accHolder);
        System.out.println("Account Number : " + accNumber);
        System.out.println("Current Balance : Rs. " + balance);
        System.out.println("------------------------------");
    }
    public static void deposit(Scanner sc){
        System.out.println("\nEnter deposit amount : Rs. ");
        double amount = sc.nextDouble();

        if(amount>0){
            balance += amount;
            System.out.println("Rs. " + amount + "deposited successfully");
            System.out.println("Updatted Balance : Rs. " + balance);
        }
        else{
            System.out.println("Invalid amount! Please enter a value greater than 0.");
        }
    }
    public static void withdraw(Scanner sc) {
        System.out.println("\nEnter withdrawal amount : Rs. ");
        double amount = sc.nextDouble();

        if(amount <= 0){
            System.out.println("Invalid amount! Please enter a value greater than 0.");
        }
        else if(amount>0 && balance < amount){
            System.out.println("Insufficient balance! Available : Rs. " + balance);
        }
        else{
            balance -= amount;
            System.out.println("Rs. " + amount + " dispensed. Please collect your cash.");
            System.out.println("Remaining Balance : Rs. " + balance);
        }
    }
}
