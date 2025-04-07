
/**
 * Write a description of class account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.List;


public class Account {

    private String name;
    private String address;
    private String accountNumber;
    private String accountType;
    private String accountBalance;
    
    public Account(String name, String address, String accountNumber, String accountType, String accountBalance) {
        this.name = name;
        this.address = address;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }


    public Account(List<String> lineData) {
        this.name = lineData.get(0);
        this.address = lineData.get(1);
        this.accountNumber = lineData.get(2);
        this.accountType = lineData.get(3);
        this.accountBalance = lineData.get(4);
      //  accountType();
    }


    public String getName() {
        return this.name;
    }
    
    
    //private String everydayAccount;
    //private String savingsAccount;
    //private String currentAccount;
   // public String accountType(String everydayAccount, String savingsAccount, String currentAccount){
    //    this.everydayAccount = everydayAccount;
   //     this.savingsAccount = savingsAccount;
     //   this.currentAccount = currentAccount;
   // }

   // public accountType(List<String> lineData) {
     //   this.everydayAccount = lineData.get(0);
       // this.savingsAccount = lineData.get(1);
   //     this.currentAccount = lineData.get(3);
   // }
   // private void accountType(){
     //   if(this.accountType.equals("Everyday")){this.value="Everyday";}
      //  else if(this.accountType.equals("Savings")){this.value="Savings";}
       // else if(this.accountType.equals("Current")){this.value="Current";}
       // System.out.println(this.value);
    //}
    
    
    
    public Double getBalance() {
        return Double.parseDouble(this.accountBalance);
    }
    
    public void print() {
        System.out.println("Account information");
        System.out.println("Account name            : " + this.name);
        System.out.println("Account address         : " + this.address);
        System.out.println("Account account number  : " + this.accountNumber);
        System.out.println("Account account type    : " + this.accountType);
        System.out.println("Account account balance : " + this.accountBalance);
    }

}

