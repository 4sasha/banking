
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        //Account account1 = new Account(); // bank data?? what do i do here ))

        //ArrayList<Data> bankData = new ArrayList<>();
        // File myFile = new File("bankData.csv");   

        List<List<String>> data = new ArrayList<>();

        // Filenames
        String customerData = "customerData.csv";

        String bankData = "bankData.csv";

        //Reading CSV file with scanner  
        try (Scanner scanner = new Scanner(new File(bankData))){

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

        //List<List<String>> customerData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(customerData))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                List<String> lineData = Arrays.asList(values);
                data.add(lineData);
            }
            for (int i = 0; i < data.size(); i++) {
                List<String> row = data.get(i);
                System.out.println("Row " + i + ": " + String.join(", ", row));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not write to file");
        }
        //code help from : https://labex.io/tutorials/java-reading-a-csv-file-117982
            
        
        
        Boolean processing = true;
        
        Scanner linescanner = new Scanner(System.in);


        while (processing){
            System.out.println("Main Menu: ");
            System.out.println("1 - Create customer account");
            System.out.println("2 - Close customer account");
            System.out.println("3 - Get customer account balance");
            System.out.println("4 - Deposit or withdraw from customer account");
            System.out.println("5 - End of day");
            
            
            if (linescanner.hasNext()){
                char input = linescanner.next().charAt(0);
                System.out.println("Input: " + input);
                if (input == '1'){
                    System.out.println("Create account");
                }
                if (input == '2'){
                    System.out.println("Close account");
                }
                if (input == '3'){
                    System.out.println("Get account");
                    for (int i = 0; i < customerData.size(); i++) {
                        System.out.println("Account " + i + ": " + new Account(customerData.get(i)).getName());
                    }
                    Scanner getAccount = new Scanner(System.in);
                    if (getAccount.hasNext()){
                        String accountselected = getAccount.nextLine();
                        System.out.println("Balance: " + new Account(customerData.get(Integer.valueOf(accountselected))).getBalance());
                    }
                }
                if (input == '4'){
                    System.out.println("Deposit or withdraw");
                    //if ("){
                        
                    }
                    
                }
                if (input == '5'){
                    System.out.println("End of day");
                    processing = false;
                    //need to save info
                }
            }
        }
        
        
        
    }



            