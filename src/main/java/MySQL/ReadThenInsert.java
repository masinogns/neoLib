package MySQL;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by masinogns on 2017. 11. 8..
 */
public class ReadThenInsert {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://183.111.183.101:3306/captanp696";

    //  Database credentials
    static final String DB_ID = "captanp696";
    static final String DB_PW = "parkli**99";

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String[]> position = getCsvFile("houseLatLng2.csv");
        updatePositionIntoTable("house", position);
    }

    private static void updatePositionIntoTable(String tableName, HashMap<Integer, String[]> position) {
        try {

            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
            PreparedStatement preparedStmt = null;

            Iterator iterator = position.keySet().iterator();

            Integer id;
            String lat, lng;

            while (iterator.hasNext()) {


                id = (Integer) iterator.next();
                String[] latlng = position.get(id);
                lat = latlng[0];
                lng = latlng[1];

                System.out.println(id + ", " + lat + ", " + lng);

//                 create the java mysql update preparedstatement
                String query = "update " + tableName + " set " +
                        "lat = ? , lng = ? " +
                        "where id = ?";

                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, lat);
                preparedStmt.setString(2, lng);
                preparedStmt.setInt(3, id.intValue());

                // execute the java preparedstatement
                preparedStmt.executeUpdate();
                preparedStmt.close();
            }

            conn.close();

        }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName

        }
        System.out.println("Goodbye!");
    }//end createTable


    private static HashMap<Integer, String[]> getCsvFile(String Path ) throws IOException {
        String prefixPath = "/Users/masinogns/IdeaProjects/neoXMLToMySql/";
        String filePath = prefixPath+Path;

        CSVReader reader = new CSVReader(new FileReader(filePath));
        HashMap<Integer, String[]> position = new HashMap<Integer, String[]>();

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            int id = Integer.parseInt(nextLine[0]);
            String lat = nextLine[2];
            String lng = nextLine[1];

//            System.out.println("id:" + id);
//            System.out.println("lat: " + lat);
//            System.out.println("lng: " + lng);
            System.out.println();

            String[] ret = new String[2];
            ret[0] = lat; ret[1] = lng;

            position.put(id, ret);
        }

        return position;
    }
}
