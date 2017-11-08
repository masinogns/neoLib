package MySQL;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by masinogns on 2017. 11. 7..
 */
public class WriteCSVFileTest {
    @Test
    public void name() throws Exception {
        List<String[]> data = new ArrayList<String[]>();

        HashMap<Integer, Double[]> position = new HashMap<Integer, Double[]>();

        // 테스트 데이터 셋
        Double[] aa = new Double[2];
        aa[0] = 11.11; aa[1] = 22.22;
        position.put(1,aa);


        // 로직
        Iterator iterator = position.keySet().iterator();

        while (iterator.hasNext()){
            Integer id = (Integer) iterator.next();
            Double[] doubles = position.get(id);
//            System.out.println(id.toString()+" "+doubles[0].toString()+" "+doubles[1].toString());
            data.add(new String[] {id.toString(), doubles[0].toString(), doubles[1].toString()});
        }

        String filename = "mycsv.csv";

        WriteCSVFile cw = new WriteCSVFile(filename);
        cw.writeCsv(data);

    }
}