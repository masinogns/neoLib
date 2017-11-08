package MySQL;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by masinogns on 2017. 11. 7..
 */
public class ForGeo {
    private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";
    private static final String KEY = "AIzaSyBAQMS5TxTcS4725sI8IH3lr9B8p94ub7k";

    private Connection conn = null;
    private Statement stmt = null;

    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://183.111.183.101:3306/captanp696";

    //  Database credentials
    private String DB_ID = "captanp696";
    private String DB_PW = "parkli**99";

    public HashMap<Integer, String> select(String query) throws SQLException {
        ResultSet rs = null;
        Statement stmt = null;
        HashMap<Integer, String> result = new HashMap<Integer, String>();

        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            int id;
            String address;

            while(rs.next()){
                id = rs.getInt("id");
                address = rs.getString("address");
                result.put(id, address);
                System.out.println(id + " " + address);

            }



        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt!= null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public String[] run(String path) throws IOException, ParseException {
        String ret = getJSONByGoogle(path);
//        System.out.println("dd"+ret);
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
//            System.out.println("d"+address);
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

    public String getJSONByGoogle(String fullAddress) throws IOException {
        URL url = new URL(URL + "?address=" + URLEncoder.encode(fullAddress, "UTF-8") + "&key=" + KEY);
        URLConnection conn = url.openConnection();
        ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
        IOUtils.copy(conn.getInputStream(), output);
        output.close();
        return output.toString();
    }

}
