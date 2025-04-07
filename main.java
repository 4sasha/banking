/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;


public class main
{
    
    //if numebr is int turn into string
    public static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch(NumberFormatException e){
            return false;  
        }
    }

    
    
    public static void main(String[] args)
    {

        // Filenames
        String customerDataFilename = "customerData.csv";
        String bankDataFilename = "bankData.csv";

        // Create list for bank data csv 
        List<List<String>> bankData = new ArrayList<>();
        //Reading CSV file with scanner 
        // code help from : https://labex.io/tutorials/java-reading-a-csv-file-117982
        try (Scanner scanner = new Scanner(new File(bankDataFilename))){

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                //Puts data into a list, to store the data
                List<String> lineData = Arrays.asList(values);

                bankData.add(lineData);
            }

        }
        catch(FileNotFoundException e){
            //if the file has an error
            System.out.println("Error: Could not write to file");
        }

        List<List<String>> customerData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(customerDataFilename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                List<String> lineData = Arrays.asList(values);
                customerData.add(lineData);
            }
         
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not write to file");
        }
        //code help from : https://labex.io/tutorials/java-reading-a-csv-file-117982

        // Main program 
        System.out.println("welcome to the sasha bank!");
        boolean processing = true;
        Scanner linescanner = new Scanner(System.in);
        while (processing){
            System.out.println("Main Menu: ");
            System.out.println("1 - Create customer account");
            System.out.println("2 - Close customer account");
            System.out.println("3 - Get customer account balance");
            System.out.println("4 - Deposit or withdraw from customer account");
            System.out.println("5 - Create new account type");
            System.out.println("6 - End of day");

            if (linescanner.hasNextLine()){
                char input = linescanner.nextLine().charAt(0);
                
                if (input == '1'){
                    System.out.println("Bank account types:");
                    for (int i = 0; i < bankData.size(); i++) {
                        System.out.println(bankData.get(i).get(0));
                    }
                    System.out.println("\nWhat account type do you want?");
                    if (linescanner.hasNextLine()){
                        String accountType = linescanner.nextLine();
                        for (int i = 0; i < bankData.size(); i++) {
                            // https://www.w3schools.com/java/ref_string_equals.asp got help from here for java string equals
                            if (bankData.get(i).get(0).toUpperCase().equals(accountType.toUpperCase())) {
                                // create a new account data array list
                                List<String> newAccountData = new ArrayList<String>();
    
                                System.out.println("Account Name:");
                                if (linescanner.hasNextLine()){
                                    //the next line turns into an array called account name and is linked back to account class
                                    String accountName = linescanner.nextLine();
                                    newAccountData.add(accountName);
                                }
                                System.out.println("Address of account:");
                                if (linescanner.hasNextLine()){
                                    String address = linescanner.nextLine();
                                    newAccountData.add(address);
                                }
                                System.out.println("Account number:");
                                if (linescanner.hasNextLine()){
                                    String accountNumber = linescanner.nextLine();
                                    newAccountData.add(accountNumber);
                                }
    
                                // Add account type
                                newAccountData.add(bankData.get(i).get(0));
                                
                                System.out.println("Balance:");
                                if (linescanner.hasNextLine()){
                                    String accountBalance = linescanner.nextLine();
                                    newAccountData.add(accountBalance);
                                }
                                new Account(newAccountData).print();
                                System.out.println("Create new account? (Y / N):");

                                if (linescanner.hasNextLine()){
                                    char check = linescanner.nextLine().toUpperCase().charAt(0);
                                    if (check == 'Y'){
                                        customerData.add(newAccountData); //gets all the data
                                        System.out.println("account successfully made!");
                                    }
                                }
                            }
                        }
                    }
                }
                if (input == '2'){
                    System.out.println("Close account");
                    System.out.println("What account do you want to close?");
                    // for loop that loops through cvs customer file and prints all of them so user can pick which one they want
                    for (int i = 0; i < customerData.size(); i++) {
                        System.out.println("Account " + i + ": " + new Account(customerData.get(i)).getName());
                    }
                    
                    if (linescanner.hasNext()){
                        List<String> accountToClose = new ArrayList<String>();
                        //making an array list of a string bcuz its text thats being inputted, and making the 
                        String accountselected = linescanner.nextLine();
                
                        int accountToRemove = Integer.valueOf(accountselected);
                        if (accountToRemove < customerData.size()){
                            accountToClose = customerData.get(Integer.valueOf(accountselected));
                        }
                        customerData.remove(accountToClose);
                    }                    

                }
                if (input == '3'){
                    System.out.println("Get current account balance?");
                    //prints same for loop thats printed fo r closing account, to show the diff accounts
                    for (int i = 0; i < customerData.size(); i++) {
                        System.out.println("Account " + (i + 1) + ": " + new Account(customerData.get(i)).getName());
                    }
                    //scanner for keyboard input
                    Scanner getAccount = new Scanner(System.in);
                    if (getAccount.hasNext()){
                        String accountselected = getAccount.nextLine();
                        System.out.println("Balance: $" + new Account(customerData.get(Integer.valueOf(accountselected))).getBalance());
                        //help from : https://www.geeksforgeeks.org/integer-valueof-method-in-java/
                    }
                }
                if (input == '4'){
                    System.out.println("deposit(d) or withdraw?(w)");
                     Scanner depositscanner = new Scanner(System.in);
                    if (linescanner.hasNextLine()){
                        if (input == 'd'){
                            System.out.println("how much do u want to deposit?");
                            String deposit =  linescanner.nextLine();
                        } else if (input == 'w') {
                            System.out.println("how much do u want to withdraw?");
                            String withdraw =  linescanner.nextLine();
                        }
                    }
                }
                if (input == '6'){
                    System.out.println("End of day!");
                    try{
                        FileWriter writeCustomerData = new FileWriter(customerDataFilename);
                        for (int i = 0; i < customerData.size(); i++) {
                            List<String> row = customerData.get(i);
                            writeCustomerData.write(String.join(",", row) + "\n");
                            System.out.println("Customer Data: " + String.join(",", row));
                        }
                        writeCustomerData.close();
                    } catch (IOException e) {
                        System.out.println("error when writing customer data");
                    }
                    System.out.println("customer data saved");
                    processing = false;
                }
            }
        }
    }
}
        




            