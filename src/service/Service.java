package service;

import model.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Service {
    static double  minbalanceToOpen;
    static double minBalanceToWithdraw;

    public static Scanner scanner=new Scanner(System.in);
    static Map<String, BankAccount> bankAccountMap=new HashMap<String,BankAccount>();

    static long random() {
        long smallest = 1000_0000_0000_0000L;
        long biggest =  9999_9999_9999_9999L;
        return ThreadLocalRandom.current().nextLong(smallest, biggest+1);
    }

    public static void displayAccountInfo(String bankId,BankAccount bankAccount) {
        Map<String,String> reference=new HashMap<>(){{put("1","Current");put("2","Savings");put("3","Salary");}};
        System.out.println("Account Number: " + bankAccount.getAccNumber());
        System.out.println("Account Type: " + reference.get(bankAccount.getAccType()));
        System.out.println("Account Holder: " + bankAccount.getName());
        System.out.println("Balance: " + bankAccount.getBalance());
        System.out.println("Creation Date: "+ bankAccount.getCreationDate());
        System.out.println();
    }
    public static  void createAccount(){

        if(bankAccountMap.isEmpty())
        {
            System.out.println("Minimum Balance to Open Account: \n");
            minbalanceToOpen=scanner.nextDouble();

            System.out.println("Minimum required balance to stay on  Account: \n");
            minBalanceToWithdraw=scanner.nextDouble();
        }



        System.out.println("Enter account type : \n 1. Current \n 2. Saving \n 3. Salary");

        Integer acc=scanner.nextInt();

        String accType=acc.toString();

        String accNumber;
        String bankId;
        do {
            accNumber = Long.toString(random());

            bankId = accType + "-" + accNumber;

        } while (bankAccountMap.containsKey(bankId));
        System.out.print("Enter account holder's name: ");
        String name = scanner.next();
        double balance;
        while (true){

            System.out.print("Enter initial balance: ");
            balance= scanner.nextDouble();
            if(balance>=minbalanceToOpen)
            {
                break;
            }
            else {
                System.out.println("It requires "+minbalanceToOpen+" to open an account for the first time.");
            }
        }
        BankAccount bankAccount=new BankAccount(name,balance,accNumber,accType);

        bankAccountMap.put(bankId,bankAccount);

        System.out.println("Account Has been created successfully");
        System.out.println("Your Account Number is "+accNumber);

    }
    public static  void displayAllAccounts(){

        for(Map.Entry<String,BankAccount> entry:bankAccountMap.entrySet())
        {
            displayAccountInfo(entry.getKey(),entry.getValue());
        }
    }
    public static  void  updateAccount(){

        System.out.println("Enter account type : \n 1. Current \n 2. Saving \n 3. Salary");
        int accT= scanner.nextInt();
        String accTy= Integer.toString(accT);
        System.out.println("Enter your Account Number");
        long accNo= scanner.nextLong();
        String accNumber= Long.toString(accNo);
        String bankId=accTy+"-"+accNumber;
        if(bankAccountMap.containsKey(bankId))
        {
            System.out.println("Update your Name");
            String de=scanner.nextLine();
            String name=scanner.nextLine();

            System.out.println("Update your account type : \n 1. Current \n 2. Saving \n 3. Salary");

            int acc=scanner.nextInt();
            String accType= Integer.toString(acc);


            BankAccount bankAccount=bankAccountMap.get(bankId);
            bankAccount.setName(name);
            bankAccount.setAccType(accType);
            bankId=accType+"-"+accNumber;
            bankAccountMap.remove(bankId);
            bankAccountMap.put(bankId,bankAccount);
            System.out.println("Your Bank Account has been successfully updated");

        }

    }

    public static  void  deleteAccount(){

        System.out.println("Enter account type : \n 1. Current \n 2. Saving \n 3. Salary");
        int x=scanner.nextInt();
        String accType=Integer.toString(x);


        System.out.println("Enter Your Account Number");
        long acc= scanner.nextLong();
        String accNumber=Long.toString(acc);

        String accId=accType+"-"+accNumber;

        if(bankAccountMap.containsKey(accId))
        {

            bankAccountMap.remove(accId);
            System.out.println("Your Account "+accNumber +" has been successfully removed");
        }
        else {
            System.out.println("Sorry!! Could not find the account");
        }

    }
    public static  void  depositAmount(){

        System.out.println("Enter account type : \n 1. Current \n 2. Saving \n 3. Salary");
        int x=scanner.nextInt();
        String accType=Integer.toString(x);


        System.out.println("Enter Your Account Number");
        long acc= scanner.nextLong();
        String accNumber=Long.toString(acc);

        String accId=accType+"-"+accNumber;
        if(bankAccountMap.containsKey(accId))
        {
            System.out.println("Please Enter your Deposit Amount on Account "+accNumber);
            double depositMoney=scanner.nextDouble();

            BankAccount bankAccount=bankAccountMap.get(accId);

            double amount=bankAccount.getBalance()+depositMoney;
            bankAccount.setBalance(amount);

            bankAccountMap.put(accId,bankAccount);

            System.out.println("Money has been deposited to the account "+accNumber);

        }
        else {
            System.out.println("Account Could Not Found");
        }
    }

    public static  void  withdrawAmount(){

        System.out.println("Enter account type : \n 1. Current \n 2. Saving \n 3. Salary");
        int x=scanner.nextInt();
        String accType=Integer.toString(x);


        System.out.println("Enter Your Account Number");
        long acc= scanner.nextLong();
        String accNumber=Long.toString(acc);

        String accId=accType+"-"+accNumber;
        if(bankAccountMap.containsKey(accId))
        {
            System.out.println("Please Enter your Withdrawal Amount");
            double withDrawalMoney=scanner.nextDouble();

            BankAccount bankAccount=bankAccountMap.get(accId);

            double amount=bankAccount.getBalance()-withDrawalMoney;
            if(amount<minBalanceToWithdraw)
            {
                System.out.println("Sorry you are reaching your limit for withdrawing money. The balance must remain at least "+minBalanceToWithdraw);
            }
            else {
                bankAccount.setBalance(amount);

                bankAccountMap.put(accId,bankAccount);
                System.out.println("Amount "+withDrawalMoney+" has been withdrawn from the account "+accNumber);

            }


        }
        else {
            System.out.println("Account Could Not Found");
        }
    }

    public static  void  searchAccount(){

        System.out.println("Enter account type : \n 1. Current \n 2. Saving \n 3. Salary");
        int x=scanner.nextInt();
        String accType=Integer.toString(x);


        System.out.println("Enter Your Account Number");
        long acc= scanner.nextLong();
        String accNumber=Long.toString(acc);
        String accId=accType+"-"+accNumber;

        if(bankAccountMap.containsKey(accId))
        {

            displayAccountInfo(accId,bankAccountMap.get(accId));

        }
        else {
            System.out.println("Account Could Not Found");
        }
    }
}
