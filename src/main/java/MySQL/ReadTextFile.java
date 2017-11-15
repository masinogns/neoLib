package MySQL;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by masinogns on 2017. 11. 15..
 */
public class ReadTextFile {
    public ArrayList<String> read(String path){
        File inFile = new File(path);

        BufferedReader br = null;

        ArrayList<String> list = new ArrayList<String>();

        try {
            br = new BufferedReader(new FileReader(inFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("관광지")){
                    String sub = line.substring(3, line.length());
                    list.add(sub);
//                    System.out.println(sub);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
        }


        return list;
    }
}


