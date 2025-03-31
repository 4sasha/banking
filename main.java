
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
    public static void main(String[] args)
    {
        //Account account1 = new Account(); // bank data?? what do i do here ))

        //ArrayList<Data> bankData = new ArrayList<>();
        // File myFile = new File("bankData.csv");   

        List<List<String>> data = new ArrayList<>();

        // Filenames
        String customerDataFilename = "customerData.csv";

        String bankDataFilename = "bankData.csv";

        List<List<String>> bankData = new ArrayList<>();

        //Reading CSV file with scanner  
        try (Scanner scanner = new Scanner(new File(bankDataFilename))){

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                //Puts data into a list, to store the data
                List<String> lineData = Arrays.asList(values);

                data.add(lineData);
            }

            for (int i = 0; i < data.size(); i++) {
                List<String> row = data.get(i);
                // System.out.println("Row " + i + ": " + String.join(", ", row));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error: Could not write to file");
        }

        List<List<String>> customerData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(customerDataFilename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                List<String> lineData = Arrays.asList(values);
                data.add(lineData);
            }
            for (int i = 0; i < data.size(); i++) {
                List<String> row = data.get(i);
                //System.out.println("Row " + i + ": " + String.join(", ", row));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not write to file");
        }
        //code help from : https://labex.io/tutorials/java-reading-a-csv-file-117982

        
        boolean processing = true;

        Scanner linescanner = new Scanner(System.in);

        while (processing){
            System.out.println("Main Menu: ");
            System.out.println("1 - Create customer account");
            System.out.println("2 - Close customer account");
            System.out.println("3 - Get customer account balance");
            System.out.println("4 - Deposit or withdraw from customer account");
            System.out.println("5 - End of day");

            if (linescanner.hasNextLine()){
                char input = linescanner.next().charAt(0);
                //System.out.println("Input: " + input);

                if (input == '1'){
                    while (input == '1'){
                    System.out.println("Create new account");
                    Scanner createAccount = new Scanner(System.in);
                    boolean notvalidaccount = true;
                    while (notvalidaccount = true) {
                        List<String> newAccountData = new ArrayList<String>();
                        System.out.println("Account Name:");
                        if (createAccount.hasNextLine()){
                            String accountName = createAccount.nextLine();
                            // System.out.println("Balance: " + accountName);
                            newAccountData.add(accountName);
                        }
                        System.out.println("Address of account:");
                        if (createAccount.hasNextLine()){
                            String address = createAccount.nextLine();
                            newAccountData.add(address);
                            // System.out.println("Address: " + address);
                        }
                        System.out.println("Account number:");
                        if (createAccount.hasNextLine()){
                            String accountNumber = createAccount.nextLine();
                            newAccountData.add(accountNumber);
                            // System.out.println("Number: " + accountNumber);
                        }
                        System.out.println("Account type (everyday, savings or current):");
                        if (createAccount.hasNextLine()){
                            String accountType = createAccount.nextLine();
                            newAccountData.add(accountType);
                            // System.out.println("Number: " + accountType);
                        }
                        System.out.println("Balance:");
                        if (createAccount.hasNextLine()){
                            String accountBalance = createAccount.nextLine();
                            newAccountData.add("$" + accountBalance);
                            // System.out.println("Balance: " + accountBalance);
                        }
                        System.out.println("Create new account? (Y / N):\n\n" + String.join(", ", newAccountData));
                        if (createAccount.hasNextLine()){
                            char check = createAccount.nextLine().toUpperCase().charAt(0);
                            if (check == 'Y'){
                                notvalidaccount = false;
                                System.out.println("account successfully made!");
                                //go back to main menu
                            } else {
                                notvalidaccount = true;
                            }
                        }
                    }
                }
            }

                if (input == '2'){
                    System.out.println("Close account");
                }
                if (input == '3'){
                    System.out.println("Get current account balance?");
                    for (int i = 0; i < customerData.size(); i++) {
                        System.out.println("Account " + i + ": " + new Account(customerData.get(i)).getName());
                    }
                    Scanner getAccount = new Scanner(System.in);
                    if (getAccount.hasNext()){
                        String accountselected = getAccount.nextLine();
                        System.out.println("Balance: " + new Account(customerData.get(Integer.valueOf(accountselected))).getBalance());
                        //help from : https://www.geeksforgeeks.org/integer-valueof-method-in-java/
                    }
                }
                if (input == '4'){
                    System.out.println("deposit or withdraw?");
                    //if ("){

                }
                if (input == '5'){

                    System.out.println("End of day!");
                    // making a delete backup file if it exists
                    File backupfile = new File(customerDataFilename + ".backup");
                    if (backupfile.exists()){
                        backupfile.delete();
                    }
                    // rename current customer data file to .backup
                    if(new File(customerDataFilename).renameTo(backupfile)){
                        try{
                            FileWriter writeCustomerData = new FileWriter(customerDataFilename);
                            for (int i = 0; i < customerData.size(); i++) {
                                List<String> row = customerData.get(i);
                                writeCustomerData.write(String.join(", ", row) + "\n");
                            }                            
                        } catch (IOException e) {
                            System.out.println("error when writing customer data");
                        }

                        System.out.println("customer data saved");
                    } else {
                        System.out.println("customer data was not backed up");
                    }
                    processing = false;
                }
            }
        }
    }
}

            