import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class IndexData {
	private static Random r = new Random();

	public static String genID(int len) {
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < len ; i++ ) {
			sb.append((char) ('a' + r.nextInt(24)));
		}
		return sb.toString();
		
	}
	/**
	 * generate random name
	 * @return name
	 */
	public static String genName() {
		
		int len = (r.nextInt(15) == 1) ? 3 : 2; //decide length of name
		StringBuffer sb = new StringBuffer();
		final String lname = "가간갈감개경계기김이박정최황나공길금나남노내단당돈도두마매맹명모" +
           "문방반배봉부빙소수순심신아안야양어여연옹요용우옥자장전정제조차최" +
         "탕탄태평포표팽하함현호 ";
		final String fname = "동해물과백두산이마르고달도록하느님보우하사우리나라만세무궁화삼천" +
        "려강산대한사람대한으로길이보전하세남산위저소나무철갑을두른듯바람" +
        "리불변함은우리기상일세";
		int n = r.nextInt(lname.length());
		sb.append(lname.charAt(n));	
		for(int i = 0; i < len; i++) {
			n = r.nextInt(fname.length());
			sb.append(lname.charAt(n));
		}
		return sb.toString();		
	}
	
	public static int genMoney(int max, int unit) {
		return r.nextInt(max/unit) * unit;
		
	}
	public static String genDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    int day = 0 - r.nextInt(100);
	    int hour = 0 - r.nextInt(24);
	    int min = 0 - r.nextInt(60);
	    int sec = 0 - r.nextInt(60);
        cal.add(Calendar.DATE, day);
        cal.add(Calendar.HOUR, hour);
        cal.add(Calendar.MINUTE, min);
        cal.add(Calendar.SECOND, sec);
        return dateFormat.format(cal.getTime());
	}
	
	/**
	csv generator for table user
	+------------+---------------+------+-----+---------+-------+
	| Field      | Type          | Null | Key | Default | Extra |
	+------------+---------------+------+-----+---------+-------+
	| id         | char(16)      | NO   | PRI | NULL    |       |
	| name       | varchar(16)   | YES  |     | NULL    |       |
	| last_visit | datetime      | YES  |     | NULL    |       |
	| money      | decimal(10,0) | YES  |     | NULL    |       |
	| choo       | char(16)      | YES  | MUL | NULL    |       |
	+------------+---------------+------+-----+---------+-------+
	 */

	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		//print header
		System.out.println("id,name,last_visit,money,choo");
		for(int i = 0; i < count ; i ++) {
			String id = genID(4) + i;
			System.out.println(
				id  + "," + 
				genName() + "," +
				genDate() + "," +
				genMoney(1000000, 100) +"," +
				id	);
			progress(i, count);
		}
	}

	public static void progress(int n, int max) {
		if(max < 100)
			return; //do nothing
		if(n + 1 == max)
			System.err.print("\n");
		if(n %( max / 10) == 0)
			System.err.print("*");
	}

}
