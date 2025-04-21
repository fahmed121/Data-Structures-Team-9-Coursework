import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PostcodeFileReader {
    public static List<String> readPostcodesFromFile(String filename) throws IOException {
        List<String> postcodes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    postcodes.add(line);
                }
            }
        }
        return postcodes;

    }
    }

