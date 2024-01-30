import static service.Service.*;


public  class BankingApplication {

    public static void main(String[] args) {


        while (true) {
            System.out.println("\nBanking Application Menu:");
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Update an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Deposit an amount into your account");
            System.out.println("6. Withdraw an amount from your account");
            System.out.println("7. Search for account");
            System.out.println("8. Exit");

            System.out.print("Enter your choice (1-8): \n");
            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    displayAllAccounts();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    depositAmount();
                    break;
                case 6:
                    withdrawAmount();
                    break;
                case 7:
                    searchAccount();
                    break;
                case 8:
                    System.out.println("Exiting the Banking Application. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }
}