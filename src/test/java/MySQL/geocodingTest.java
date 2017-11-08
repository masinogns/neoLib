package MySQL;

import MySQL.geocoding;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by masinogns on 2017. 11. 1..
 */
public class geocodingTest {
    @Test
    public void test() throws Exception {
        geocoding bb = new geocoding();

//        String path = "제주특별자치도 제주시 거로중길 28";
        String path = "제주특별자치도 제주시 조천읍 비자림로 645";

        String[] SS = bb.run(path);
        System.out.println(SS[0]+" "+SS[1]);

    }

}