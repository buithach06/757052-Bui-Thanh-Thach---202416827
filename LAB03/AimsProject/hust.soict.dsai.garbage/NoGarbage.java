

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

    public static void main(String[] args) {
        String filename = "large_file.txt"; 
        
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            
            for (byte b : inputBytes) {
                outputStringBuilder.append((char)b); 
            }
            String outputString = outputStringBuilder.toString();
            
            endTime = System.currentTimeMillis();
            System.out.println("NoGarbage (using StringBuilder)");
            System.out.println("Read " + inputBytes.length + " bytes.");
            System.out.println("Execution time: " + (endTime - startTime) + " ms");
            
        } catch (IOException e) {
            System.err.println("Error: File not found. Please create the file '" + filename + "' in the project's root directory.");
            e.printStackTrace();
        }
    }
}