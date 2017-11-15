package MySQL;

import MySQL.geocoding;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by masinogns on 2017. 11. 1..
 */
public class geocodingTest {
    @Test
    public void test() throws Exception {
        String path = "/Users/masinogns/Desktop/테마관광지.txt";
        ReadTextFile readTextFile = new ReadTextFile();

        geocoding geocoding = new geocoding();

        HashMap<String, String[]> dataset = new HashMap<String, String[]>();

//        String path = "제주특별자치도 제주시 거로중길 28"; 주소를 써도되고 명칭을 써도 된다
        //String keyword = "오설록티뮤지엄";
        String keyword = "해비치컨트리클럽제주";
        String[] data = geocoding.run(keyword);
        System.out.println(data[0]+" "+data[1]+" "+data[2]);

        ArrayList<String> ret = readTextFile.read(path);

        for (String word  : ret){

        }
        dataset.put(keyword, data);

//
//        ForGeo forGeo = new ForGeo();
//        forGeo.insert(dataset);
    }

}