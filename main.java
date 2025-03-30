
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
        //Account account1 = new Account(

        //ArrayList<Data> bankData = new ArrayList<>();
       // File myFile = new File("bankData.csv");
       String bankData = "bankData.csv";
       
            List<List<String>> data = new ArrayList<>();
           
           
        try (Scanner scanner = new Scanner(new File(bankData))){
           
             while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
             String[] values = line.split(",");
                List<String> lineData = Arrays.asList(values);
       
                // Add the line data to our main list
                data.add(lineData);
            }
                  System.out.println("\nData read from CSV file:");    
                   for (int i = 0; i < data.size(); i++) {
                List<String> row = data.get(i);
                System.out.println("Row " + i + ": " + String.join(", ", row));
            }
             }
                catch(FileNotFoundException e){
                    System.out.println("Error: Could not write to file");
                }
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
