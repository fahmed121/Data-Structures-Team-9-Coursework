import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PostcodeFileReader {
    private String filepath;

    public PostcodeFileReader(String filepath){
        this.filepath = filepath;
    }

    public List<String> readPostcodes(){
       List<String> postcodes = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            //System.out.println("file content");
           // System.out.println("------------------");
            while((line = br.readLine()) != null){
                line = line.trim();
                if(!line.isEmpty()){
                    postcodes.add(line);
                }
                
            }

        }catch (IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
        return postcodes;


    }


    }


