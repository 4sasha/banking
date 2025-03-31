
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
    }


    public String getName() {
        return this.name;
    }


    public Double getBalance() {
        return Double.parseDouble(this.accountBalance);
    }


}

