import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {

    static double balance = 5000;

    // Store usernames and passwords
    static ArrayList<String> usernames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;

        System.out.println("===== BANKING SYSTEM =====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Choose Option: ");
        option = sc.nextInt();
        sc.nextLine();

        // Register User
        if (option == 1) {

            System.out.print("Create Username: ");
            String newUser = sc.nextLine();

            System.out.print("Create Password: ");
            String newPass = sc.nextLine();

            usernames.add(newUser);
            passwords.add(newPass);

            System.out.println("Registration Successful!");
        }

        // Login User
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        boolean loginSuccess = false;

        for (int i = 0; i < usernames.size(); i++) {

            if (username.equals(usernames.get(i)) &&
                    password.equals(passwords.get(i))) {

                loginSuccess = true;
                break;
            }
        }

        if (loginSuccess) {

            int choice;

            do {

                System.out.println("\n===== BANK MENU =====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Balance Inquiry");
                System.out.println("4. Exit");

                System.out.print("Select Operation: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Deposit Amount: ");
                        double deposit = sc.nextDouble();

                        balance += deposit;

                        System.out.println("Deposit Successful!");
                        System.out.println("Balance: " + balance);
                        break;

                    case 2:
                        System.out.print("Enter Withdraw Amount: ");
                        double withdraw = sc.nextDouble();

                        if (withdraw <= balance) {

                            balance -= withdraw;

                            System.out.println("Withdraw Successful!");
                            System.out.println("Balance: " + balance);

                        } else {
                            System.out.println("Insufficient Balance!");
                        }

                        break;

                    case 3:
                        System.out.println("Current Balance: " + balance);
                        break;

                    case 4:
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 4);

        } else {
            System.out.println("Invalid Login!");
        }

        sc.close();
    }
}