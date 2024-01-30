package model;

import java.util.Date;

public class BankAccount{

    private String name;
    private Date creationDate;
    private  double balance;
    private final String accNumber;
    private  String accType;

    public BankAccount(String name, double balance, String accNumber, String accType) {
        this.name = name;
        this.creationDate = new Date();
        this.balance = balance;
        this.accNumber = accNumber;
        this.accType = accType;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}