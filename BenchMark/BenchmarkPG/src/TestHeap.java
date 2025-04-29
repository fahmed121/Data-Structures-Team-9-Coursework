
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestHeap {
    // bench marking program to test min heap

    static class Postcode {

        String code;

        Postcode(String code) {
            this.code = code;

        }

    }

    // Comparator that sorys Postcodes (A-Z)
    static class PostcodeComparator implements Comparator<Postcode> {

        @Override
        public int compare(Postcode p1, Postcode p2) {
            return p1.code.compareTo(p2.code); // Compare strings alphabetically
        }

    }

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("Postcode Priority Queue (Alphabetical Order)");
        System.out.println("===================================================");
        System.out.printf("%-25s %-10s %-15s %-15s%n", "File", "Elements", "Insert(ms)", "Poll(ms)");

        //PriorityQueue<Postcode> postcodes = new PriorityQueue<>(new PostcodeComparator());

        long insertStartTime, insertEndTime;
        long pollStartTime, pollEndTime;
        double insertTimeMs, pollTimeMs;
        int elementCount;
        //to read postcode from files using biffered reader
        //String[] files = {
        //"1000_London_Postcodes.txt", 
        //"2000_London_Postcodes.txt", 
        //"4000_London_Postcodes.txt", 
        //"8000_London_Postcodes.txt", 
        //"16000_London_Postcodes.txt" };
        String[] files = {
            "C:\\Users\\donof\\OneDrive\\Documents\\Uni.Notes\\Data Structure and Algorithms\\CourseWork1\\BenchMark\\BenchmarkPG\\src\\1000_London_Postcodes.txt", // "C:\\Users\\donof\\OneDrive\\Documents\\Uni.Notes\\Data Structure and Algorithms\\CourseWork1\\BenchMark\\BenchmarkPG\\src\\2000_London_Postcodes.txt", 
         "C:\\Users\\donof\\OneDrive\\Documents\\Uni.Notes\\Data Structure and Algorithms\\CourseWork1\\BenchMark\\BenchmarkPG\\src\\4000_London_Postcodes.txt", 
        "C:\\Users\\donof\\OneDrive\\Documents\\Uni.Notes\\Data Structure and Algorithms\\CourseWork1\\BenchMark\\BenchmarkPG\\src\\8000_London_Postcodes.txt", 
        "C:\\Users\\donof\\OneDrive\\Documents\\Uni.Notes\\Data Structure and Algorithms\\CourseWork1\\BenchMark\\BenchmarkPG\\src\\16000_London_Postcodes.txt"
        };

//-----------------------------------------------------------------------------------------------------------
       

        for (String fileName : files) {
            PriorityQueue<Postcode> postcodes = new PriorityQueue<>(new PostcodeComparator());
            elementCount = 0;
          
            insertStartTime = System.nanoTime();
            
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
               // System.out.println("Reading file: " + fileName);
                

                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    //skip empty lines
                    if (!line.isEmpty()){
                        postcodes.add(new Postcode(line));
                        elementCount++;
                    }
                }

            } catch (IOException e) {
                System.err.println("Error reading file" + fileName + ": " + e.getMessage());
            }
            insertEndTime = System.nanoTime();
            insertTimeMs = (insertEndTime - insertStartTime) / 1_000_000.0;
    
            pollStartTime = System.nanoTime();
    
            while (!postcodes.isEmpty()) {
                Postcode postcode = postcodes.poll();  // 
            }
    
            pollEndTime = System.nanoTime();
            pollTimeMs = (pollEndTime - pollStartTime) / 1_000_000.0;
            
            // Print results for this file
            String shortFileName = fileName.substring(fileName.lastIndexOf('\\') + 1);
            System.out.printf("%-20s %-15d %-15.3f %-15.3f%n", 
                shortFileName, elementCount, insertTimeMs, pollTimeMs);
    
        
        }

       // System.out.println("Total Postcodes: " + postcodes.size());
        //System.out.println();
        //System.out.println("Printing the queue of Postcodes in the priority queue:");

        //while (!postcodes.isEmpty()) {
           // Postcode postcode = postcodes.poll();  // 
          //  System.out.println("Postcode " + postcode.code);
       //}

    }
}
