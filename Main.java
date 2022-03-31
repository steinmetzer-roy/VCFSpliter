import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        Path filename = Path.of(args[0]);
        List<String> aStrings = Files.readAllLines(filename);
        int contactCounter = 0;
        ListIterator<String> li = aStrings.listIterator();
        
        while(li.hasNext()){
            String tmp = "";
            contactCounter++;
            File file = new File(contactCounter+".vcf");
            FileWriter fileWR = new FileWriter(file);
            do {
                tmp = li.next();
                fileWR.append(tmp + "\n");
            } while (!tmp.equals("END:VCARD"));
            fileWR.close();
        }
    }
}

