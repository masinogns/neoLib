package MySQL;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import au.com.bytecode.opencsv.CSVWriter;

/**
 * Created by masinogns on 2017. 11. 7..
 */
public class WriteCSVFile {
//    String filename = "mycsv.csv";
    CSVWriter cw;

    public WriteCSVFile(String filename) throws IOException {
        cw = new CSVWriter(new FileWriter(filename), ',', '"');
    }

    public void writeCsv(List<String[]> data) {
        try {
            Iterator<String[]> it = data.iterator();
            try {
                while (it.hasNext()) {
                    String[] s = (String[]) it.next();
                    cw.writeNext(s);
                }
            } finally {
                cw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
