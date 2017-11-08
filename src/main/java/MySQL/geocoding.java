package MySQL; /**
 * Created by masinogns on 2017. 11. 1..
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.commons.io.IOUtils;
//
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//(For this you need to add "commons-io-1.3.1.jar" in your project.)

public class geocoding {

/*Geocode request URL. Here see we are passing "json" it means we will get the output in JSON format.
* You can also pass "xml" instead of "json" for XML output.
* For XML output URL will be "http://maps.googleapis.com/maps/api/geocode/xml";
*/

        private static final String URL = "https://maps.googleapis.com/maps/api/geocode/json";
        private static final String KEY = "AIzaSyBAQMS5TxTcS4725sI8IH3lr9B8p94ub7k";
        private String lng;
        private String lat;

        public String getLng() {
                return lng;
        }
        public String getLat() {
                return lat;
        }
        public void setLng(String lng) {
                this.lng = lng;
        }
        public void setLat(String lat) {
                this.lat = lat;
        }


        public String[] run(String path) throws IOException, ParseException {
                String ret = getJSONByGoogle(path);
//                System.out.println("dd"+ret);
                JSONObject json = stringToJson(ret);
                Iterator it = json.keySet().iterator();
                JSONArray jsonArray = (JSONArray) json.get("results");

                JSONObject object = (JSONObject) jsonArray.get(0);
                Iterator bb = object.keySet().iterator();

                JSONObject object1 = (JSONObject) object.get("geometry");
                JSONObject object2 = (JSONObject) object1.get("location");
                Iterator itt = object2.values().iterator();

                ArrayList<String> result = new ArrayList();

                while (itt.hasNext()){
                        String address = itt.next().toString();
//                        System.out.println("d"+address);
                        result.add(address);
                }

                String[] ss = new String[2];
                ss[0] = result.get(0); ss[1] = result.get(1);

                // 0이 lng이고 1이 lat이다
//                setLng(result.get(0)); setLat(result.get(1));

                return ss;
        }



        public JSONObject stringToJson(String string) throws ParseException {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(string);
                JSONObject jsonObj = (JSONObject) obj;

                return jsonObj;
        }

        /**
         *
         address="1600+Amphitheatre+Parkway,+Mountain+View,+CA"
         key="my-key-here"
         url="https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s" % (address, key)
         * @param fullAddress
         * @return
         * @throws IOException
         */
        public String getJSONByGoogle(String fullAddress) throws IOException {
                URL url = new URL(URL + "?address=" + URLEncoder.encode(fullAddress, "UTF-8") + "&key=" + KEY);
                URLConnection conn = url.openConnection();
                ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
                IOUtils.copy(conn.getInputStream(), output);
                output.close();
                return output.toString();
        }
}

