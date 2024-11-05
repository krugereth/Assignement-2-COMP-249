import java.io.*;
import java.util.Scanner;

public class Part1 {

    public static void do_part1() {

       Scanner fileReader = null;
       BufferedWriter fileWriter = null;
        // Opens the part1 input file names files to try and read the names of the files inside
        try {
            fileReader = new Scanner(new FileInputStream("part1_input_file_names.txt"));
            fileWriter = new BufferedWriter(new FileWriter("syntax_error_file.txt", true));

        }catch (FileNotFoundException e) {
            System.out.println("File not found. The program will now terminate");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
            int fileCount = 0;
            int numFiles = fileReader.nextInt();

        int invalidGenreCount = 0, tooManyFieldsCount = 0, tooFewFieldsCount = 0,  missingFieldCount = 0;
        int CCBcount = 0, HCBcount = 0, MTVcount = 0, MRBcount = 0, NEBcount = 0, OTRcount = 0, SSMcount = 0, TPAcount = 0;

        String title, authors, price, isbn, genre, year;

            String fileName; //String for the file names

            // Loop through each file name in the list
            while ((fileName = fileReader.nextLine()) != null) {

                System.out.println("Processing file: " + fileName);

                Scanner bookRecordScanner = null;
                // Try to open and read the contents of each file
                try {
                     bookRecordScanner = new Scanner(new FileInputStream(fileName));
                } catch (FileNotFoundException e) {
                    System.out.println("File not found. The program will now terminate");
                    System.exit(0);
                }


                    String line;
                    // Loop through each line in the current file
                    while ((line = fileReader.readLine()) != null) {

                        
                        String[] fields2 = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                        if(fields2.length != 6){
                            BufferedWriter bw1 = new BufferedWriter(new FileWriter("syntax_error_file.txt",true));
                            bw1.write(line + "\n");
                            bw1.close();
                        }
                            if(line.contains("CCB")) {
                            BufferedWriter bw1 = new BufferedWriter(new FileWriter("Cartoons_Comics_Books.csv.txt",true));
                            bw1.write(line +"\n");
                            bw1.close();
                        } else if (line.contains("HCB")) {
                            BufferedWriter bw1 = new BufferedWriter(new FileWriter("Hobbies_Collectibles_Books.csv.txt",true));
                            bw1.write(line + "\n");
                            bw1.close();
                        }

                    }
                } catch (FileNotFoundException e) { // Handle case where a file in the list is not found
                    System.out.println("File not found: " + e.getMessage());
                } catch (IOException e) { // Handle other IO exceptions while reading the file
                    System.out.println("IO exception occurred while reading " + fileName + ": " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) { // Handle case where the main list file is not found
            System.out.println("File not found: part1_input_file_names.txt");
        } catch (IOException e) { // Handle other IO exceptions while reading the list file
            System.out.println("IO exception occurred: " + e.getMessage());
        }
    }
}