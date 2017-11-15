package MySQL;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by masinogns on 2017. 11. 15..
 */
public class ReadTextFileTest {
    @Test
    public void name() throws Exception {
        String path = "/Users/masinogns/Desktop/테마관광지.txt";

        ReadTextFile readTextFile = new ReadTextFile();
        ArrayList<String> ret = readTextFile.read(path);

        for (String aaa  : ret){
            System.out.println(aaa);
        }



    }
}