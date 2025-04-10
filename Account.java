
/**
 
 *
sasha lambrechtsen banking game - account class.1.!>!>!!>!>!>!>! :
 *
 */


import java.util.List;

public class Account {

    //defining private variables for account
    private String name;
    private String address;
    private String accountNumber;
    private String accountType;
    private String accountBalance; 
   
    //creating account class that links into private variables - can call from main
    public Account(String name, String address, String accountNumber, String accountType, String accountBalance) {
        this.name = name;
        this.address = address;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }
    
    //or u can create account class using a string list and then getting each column from the list
    public Account(List<String> lineData) {
        this.name = lineData.get(0);
        this.address = lineData.get(1);
        this.accountNumber = lineData.get(2);
        this.accountType = lineData.get(3);
        this.accountBalance = lineData.get(4);
    }

    public String getName() {
        return this.name;//if calling getname in main class then return the name
    }
   
    public Double getBalance() {
        return Double.parseDouble(this.accountBalance); // first converting from string to double, then doing same with name except account balance - a double because it is money
    }
   
    public String getAccountType() {
        return this.accountType; //same as name
    }
   
    public void print() {
        System.out.println("\nAccount information");
        System.out.println("Account name            : " + this.name);
        System.out.println("Account address         : " + this.address);
        System.out.println("Account account number  : " + this.accountNumber);
        System.out.println("Account account type    : " + this.accountType);
        System.out.println("Account balance         : " + this.accountBalance);
    } //print out account data when calling print


}








