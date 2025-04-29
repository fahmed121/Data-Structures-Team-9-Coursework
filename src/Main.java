
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // to read the file with postcode
        PostcodeFileReader fileReader = new PostcodeFileReader("C:\\Users\\donof\\OneDrive\\Documents\\Uni.Notes\\Data Structure and Algorithms\\CourseWork1\\BenchMark\\BenchmarkPG\\src\\1000_London_Postcodes.txt");
        List<String> postcodes = fileReader.readPostcodes();

        // To create Min-heap 
        PostcodeMinHeap minHeap = new PostcodeMinHeap(postcodes.size());

        //insert postcodes
        for (String postcode : postcodes) {
            minHeap.insert(postcode);
        }

        // The Total number of postcodes
        System.out.println("Total Postcodes in the Heap " + minHeap.count());

        // extract minimum
        String minPostcode = minHeap.ExtractMinimum();
        System.out.println();
        System.out.println("Minimmum postcode " + minPostcode);

        // search for postcode
        boolean exists = minHeap.Search("W5 3U2");
        System.out.println();
        System.out.println("Does this Postcode exists? " + exists);

        // delete a postcode a specific postcode
        String postcodeDelete = "N1 5GH";
        boolean deleted = minHeap.delete(postcodeDelete);
        System.out.println();
        System.out.println("Deleting " + postcodeDelete);
        System.out.println("Total number of Postcodes after deletion " + minHeap.count());

        // postcodes in sorted order
        System.out.println();
        System.out.println("Postcodes in sorted order ");
        //String[] sortedPostcodes = minHeap.InOrder();
        String[] sortedPostcodes = minHeap.InOrderKeep();
        for (String postcode : sortedPostcodes) {
            System.out.println(postcode);
        }

        //print sorted postcodes to text file
        try {
            File myPc = new File("C:\\Users\\donof\\OneDrive\\Documents\\Uni.Notes\\Data Structure and Algorithms\\CourseWork1\\BenchMark\\BenchmarkPG\\src\\Sorted1000_London_Postcodes.txt");
            if (myPc.createNewFile()) {
                System.out.println("File created " + myPc.getName());

                FileWriter writer = new FileWriter(myPc);
                for (String postcode : sortedPostcodes) {
                    writer.write(postcode + "\n");

                }
                writer.close();

            } else {
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            System.err.println("Error has occured");
            e.printStackTrace();
        }

    }
}
