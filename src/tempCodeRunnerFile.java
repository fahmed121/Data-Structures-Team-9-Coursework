import java.util.List;

/*public class Main {

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

        System.out.println("Total Postcodes in the Heap " + minHeap.count());

       // extract minimum
        String minPostcode = minHeap.ExtractMinimum();
        System.out.println();
        System.out.println("Minimmum postcode " + minPostcode);

        // search for postcode

        boolean exists = minHeap.Search("W5 3U2");
        System.out.println();
        System.out.println( "exists? " + exists);

        // postcodes in sorted order
        System.out.println();
        System.out.println("Postcodes in sorted order ");
        //String[] sortedPostcodes = minHeap.InOrder();
        String[] sortedPostcodes = minHeap.InOrderKeep();
        for (String postcode : sortedPostcodes) {
            System.out.println(postcode);
        }

    }
}*/
