package MySQL;

import org.junit.Test;

import java.util.*;

/**
 * Created by masinogns on 2017. 11. 7..
 */
public class ForGeoTest {
    @Test
    public void test() throws Exception {
        ForGeo forGeo = new ForGeo();
        geocoding geocoding = new geocoding();

        String selectQuery  = "select id, address from food";
        HashMap<Integer, String> ret = forGeo.select(selectQuery);
        HashMap<Integer, String[]> position = new HashMap<Integer, String[]>();
        Iterator iterator = ret.keySet().iterator();

        Integer id;String address;

        while (iterator.hasNext()){
            id = (Integer) iterator.next();
            address = ret.get(id);

            System.out.println(id + " " + address);


            try {
                String[] strings= geocoding.run(address);
                System.out.println("변환된 주소 : "+strings[0]+" : "+strings[1]);

                position.put(id, strings);
            }catch (Exception e){
                continue;
            }


        }

        // 로직
        List<String[]> data = new ArrayList<String[]>();
        Iterator iterator11 = position.keySet().iterator();

        while (iterator11.hasNext()){
            Integer id11 = (Integer) iterator11.next();
            String[] doubles = position.get(id11);
//            System.out.println(id.toString()+" "+doubles[0].toString()+" "+doubles[1].toString());
            data.add(new String[] {id11.toString(), doubles[0].toString(), doubles[1].toString()});
        }

        String filename = "foodLatLng2.csv";

        WriteCSVFile cw = new WriteCSVFile(filename);
        cw.writeCsv(data);
    }
}