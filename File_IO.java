import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.*;


//to update the seatTaken, can concatenate to the String then update the line
public class File_IO {
    
    public static List<String[]> readFile(String pathName) { 
        
        String path = "CSV/"+pathName+".csv";
        String line = "";
        List<String[]> twoDlist = new ArrayList<String[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            while((line=br.readLine())!=null){
                String[] data = line.split("\t");
                twoDlist.add(data);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error with reading the file!");
        
        }
        return twoDlist;
    }

    public static void writeFile(List<String[]>  twoDList, String pathName){
        String path = "CSV/"+pathName+".csv";
        File file = new File(path);
        

        try {
            System.out.println("Writing to file...");
            FileWriter outputfile = new FileWriter(file); 
            CSVWriter writer = new CSVWriter(outputfile, '\t' , CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            writer.writeAll(twoDList);
           

            writer.close();
        } catch (Exception e) {
            System.out.println("\n\nError with writing the file!");
        }
    }

}
