/**

/**
 *banking program
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


       
        // Create bank data list array
        List<List<String>> bankData = new ArrayList<>();


        // Read bank data file using scanner - code help from : https://labex.io/tutorials/java-reading-a-csv-file-117982
        // Check the file exists and can be opened
        try (Scanner scanner = new Scanner(new File(bankDataFilename))){
           
            // Loop through the file line by line, until it doesn't have any more lines.
            while (scanner.hasNextLine()) {
                // Read the line into a string
                String line = scanner.nextLine();
                // Split the string into an Array with the comma as the delimiter
                String[] values = line.split(",");


                //Convert the array into a single dimentional list.
                List<String> lineData = Arrays.asList(values);


                // Add the bank data line as a list and add it to the bank data two dimentational list for each line
                bankData.add(lineData);
            }


            //for (int i = 0; i < data.size(); i++) {
            //    List<String> row = data.get(i);
                // System.out.println("Row " + i + ": " + String.join(", ", row));
            //}
        }
        catch(FileNotFoundException e){
            //if the file has an error
            System.out.println("Error: Could not write to file");
        }


        // Now do exactly the same thing for the Customer data that you just did for the bank data.
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


        // Main program loop
        // Create a boolean
        boolean processing = true;
       
        // Read a line of input scanner
        Scanner linescanner = new Scanner(System.in);
        while (processing){
            System.out.println("Main Menu: ");
            System.out.println("1 - Create customer account");
            System.out.println("2 - Close customer account");
            System.out.println("3 - Get customer account balance");
            System.out.println("4 - Deposit or withdraw from customer account");
            System.out.println("5 - Create new account type");
            System.out.println("6 - End of day");


            // wait for the next line to be input
            if (linescanner.hasNextLine()){
                // get line first character
                char input = linescanner.nextLine().charAt(0);
               
                if (input == '1'){
                    // Print out the bank accounts types
                    System.out.println("Bank account types:");
                    for (int i = 0; i < bankData.size(); i++) {
                        System.out.println(bankData.get(i).get(0));
                    }
                   
                    // Ask about what account you want
                    System.out.println("\nWhat account type do you want?");
                    if (linescanner.hasNextLine()){
                        String accountType = linescanner.nextLine();
                       
                        // Loop through all the different bank types to check, if none of them are found print an error
                        boolean accountnotfound = true;
                        for (int accounttype = 0; accounttype < bankData.size(); accounttype++) {
                            // https://www.w3schools.com/java/ref_string_equals.asp java string equals
                            if (bankData.get(accounttype).get(0).toUpperCase().equals(accountType.toUpperCase())) {
                                // account found, so set accountnotfound to false
                                accountnotfound = false;
                               
                                // create a new account data line array list
                                List<String> newAccountData = new ArrayList<String>();
   
                                System.out.println("Account Name:");
                                if (linescanner.hasNextLine()){
                                    String accountName = linescanner.nextLine();
                                    // add account name to the array list
                                    newAccountData.add(accountName);
                                }
                               
                                // next item in the list address
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
                                newAccountData.add(bankData.get(accounttype).get(0));
                               
                                System.out.println("Balance:");
                                if (linescanner.hasNextLine()){
                                    String accountBalance = linescanner.nextLine();


                                    // Check the account balance is a number
                                    try {
                                        // Convert the account balance string into an integer, if it fails then because it is in a try, catch, the catch will be used
                                        int accountBalanceInt = Integer.valueOf(accountBalance);
                                        // Get the account type minimum value from bank data
                                        int accountTypeMin = Integer.valueOf(bankData.get(accounttype).get(1));
                                        // Check the balance entered is more than the account type minimum
                                        if ( accountBalanceInt > accountTypeMin) {
                                            // If it is ok then add it into the list
                                            newAccountData.add(accountBalance);
                                        } else {
                                            // if it is under the value then display an error and set the balance to zero.
                                            System.out.println("invalid balance for " + bankData.get(accounttype).get(0) + " needs to be more than " + bankData.get(accounttype).get(1));
                                            newAccountData.add("0");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("invalid balance entered");
                                        newAccountData.add("0");
                                    }


                                }
                               
                                // print out the full account to create to check everything is correct before creating the new account.
                                new Account(newAccountData).print();


                                System.out.println("Create new account? (Y / N):");


                                if (linescanner.hasNextLine()){
                                    char check = linescanner.nextLine().toUpperCase().charAt(0);
                                    if (check == 'Y'){
                                        customerData.add(newAccountData);
                                        System.out.println("account successfully made!");
                                    } else {
                                        System.out.println("account not added");
                                    }
                                   
                                }
                            }
                        }
                        if (accountnotfound) {
                            // If the account hasn't been found then we need to say invalid account type specified
                            System.out.println("invalid account type");
                        }
                    }
                }
                if (input == '2'){
                    System.out.println("Close account");
                    System.out.println("What account do you want to close?");
                    for (int i = 0; i < customerData.size(); i++) {
                        System.out.println("Account " + (i+1) + ": " + new Account(customerData.get(i)).getName());
                    }
                    if (linescanner.hasNext()){
                        List<String> accountToClose = new ArrayList<String>();
                        String accountselected = linescanner.nextLine();
                        int accountToRemove = Integer.valueOf(accountselected)-1;
                        if (accountToRemove < customerData.size()){
                            accountToClose = customerData.get(Integer.valueOf(accountselected));
                        }
                        customerData.remove(accountToClose);
                    }                    


                }
                if (input == '3'){
                    System.out.println("Get current account balance?");
                    for (int i = 0; i < customerData.size(); i++) {
                        System.out.println("Account " + (i+1) + ": " + new Account(customerData.get(i)).getName());
                    }
                    if (linescanner.hasNext()){
                        String accountselected = linescanner.nextLine();
                        System.out.println("Balance: $" + new Account(customerData.get(Integer.valueOf(accountselected)-1)).getBalance());
                        //help from : https://www.geeksforgeeks.org/integer-valueof-method-in-java/
                    }
                }
                if (input == '4'){
                    System.out.println("Which account do you want to deposit or withdraw into?");
                    // Print out all the accounts to let the user select which account they want
                    for (int i = 0; i < customerData.size(); i++) {
                        System.out.println("Account " + (i+1) + ": " + new Account(customerData.get(i)).getName());
                    }
                    if (linescanner.hasNext()){
                        // Find the account number you want to select using linescanner
                        String accountselectedstr = linescanner.nextLine();
                        // convert the account number string into a int
                        try {
                            int accountselected = Integer.valueOf(accountselectedstr)-1;
                            // Create an account object with the current account selected
                            Account currentAccount = new Account(customerData.get(Integer.valueOf(accountselected)));
                            // print the current account balance
                            System.out.println("Current balance: $" + currentAccount.getBalance());
                            // Doing a deposit or withdraw
                            System.out.println("(D)eposit or (W)ithdraw?");
                            if (linescanner.hasNextLine()){
                                // get a single character entered, make it upper case and take the first character
                                char depositorwithdraw = linescanner.nextLine().toUpperCase().charAt(0);


                                if (depositorwithdraw == 'D'){
                                    System.out.println("how much do u want to deposit?");
                                    if (linescanner.hasNextLine()){
                                        String depositstring = linescanner.nextLine();
                                        try {
                                            // Convert the deposit number an integer, if it fails then because it is in a try, catch, the catch will be used
                                            Double deposit = Double.valueOf(depositstring);
                                            // Check the number is greater than zero, as you can't add negative numbers
                                            if ( deposit > 0 ) {
                                                // Create new balance adding the new value to deposit
                                                Double newBalance = currentAccount.getBalance() + deposit;
                                                // print the new balance
                                                System.out.println("Setting new balance to " + newBalance);
                                                // update the list with the account selected with the new balance
                                                customerData.get(accountselected).set(4, String.valueOf(newBalance));
                                            } else {
                                                // if the number to deposit is not larger than zero give an error
                                                System.out.println("Number needs to be more than zero");
                                            }
                                        } catch (NumberFormatException e) {
                                            // if it isn't a number give an error
                                            System.out.println("invalid number entered");
                                        }
                                    }
                                } else if (depositorwithdraw == 'W') {
                                    System.out.println("how much do u want to withdraw?");
                                    if (linescanner.hasNextLine()){
                                        String withdrawstring = linescanner.nextLine();
                                        try {
                                            // Convert the withdraw number to an integer, if it fails then because it is in a try, catch, the catch will be used
                                            Double withdraw = Double.valueOf(withdrawstring);
                                            // number to withdraw needs to be larger than 0
                                            if ( withdraw > 0 ) {
                                               
                                                Double newBalance = currentAccount.getBalance() - withdraw;
                                               
                                                // loop through all the account types to find the current account type being used.
                                                for (int accounttype = 0; accounttype < bankData.size(); accounttype++) {
                                                    // https://www.w3schools.com/java/ref_string_equals.asp java string equals
                                                    // Check the bank data account type to make sure it matches the account type
                                                    if (bankData.get(accounttype).get(0).toUpperCase().equals(currentAccount.getAccountType().toUpperCase())) {
                                                        // create an int for the new account minimum
                                                        int accountTypeMin = Integer.valueOf(bankData.get(accounttype).get(1));
                                                        // if the new balance is larger than the account supported minimum then update to the new balance
                                                        if ( newBalance > accountTypeMin) {
                                                            // print new balance
                                                            System.out.println("Setting new balance to " + newBalance);
                                                            customerData.get(accountselected).set(4, String.valueOf(newBalance));
                                                        } else {
                                                            // if it is under the value then display an error and set the balance to zero.
                                                            System.out.println("invalid new balance " + newBalance + " for " + currentAccount.getAccountType() + " needs to be more than " + (accountTypeMin));
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println("Number needs to be more than zero");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("invalid number entered");
                                        }
                                    }                                    
       
                                } else {
                                    System.out.println("invalid option");
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("invalid account value entered");
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
       





            