
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
                System.out.println("Row " + i + ": " + String.join(", ", row));
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

        // Double totalCash; //making a variable for the total cash
        // totalCash = 0D;
        //for loop that goes through each line in customer data
        //   for (int i = 0; i < customerData.size(); i++) {
        //     List<String> row = customerData.get(i);
        //     totalCash = totalCash + Double.parseDouble(row.get(4));
        //    }
        //    System.out.println("Total cash " + totalCash);
        //

    }
}

            
            
            
            
// Scanner scanner = new Scanner(Paths.get("bankData.cvs")){
//           while (scanner.hasNextLine()) {
//         lines.add(scanner.nextLine());

       
//Scanner dataReader = new Scanner(myFile);

//String csvFile = "bankData.csv";

//int accountLength = dataReader.nextInt();
//dataReader.nextLine();

//String[] accounts = new String[accountLength];

           
//for (int i = 0; i < data.size(); i++) {
//List<String> row = data.get(i);
//  System.out.println("Row " + i + ": " + String.join(", ", row));
//for(int i=0; i<accountLength; i++){
//   accounts[i] = dataReader.nextLine();
// }

//for(int i=0; i<accountLength; i++){
//   System.out.println(accounts[i]);
//}
