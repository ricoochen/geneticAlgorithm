package ga.aps.controller.myConnection;

import java.sql.Connection; 
import java.sql.DriverManager;
 
public class DBConnection {
	private Connection conn = null;
	private static String driver = "com.hxtt.sql.access.AccessDriver";
//	private static String prjpath = System.getProperty("user.dir");
//	private static String DBurl = prjpath + "\\WebContent\\access\\GAAPS.mdb";
//	private static String chgurl = DBurl.replaceAll("\\\\", "/");
//	private static String url =  "jdbc:Access:///"+chgurl;

	public DBConnection() throws Exception { 
    	String path = this.getClass().getResource("/").getPath().replaceAll("%20"," ");
    	path = path.substring(1,path.length()) + "GAAPS.mdb";
    	String url = "jdbc:Access:///" + path;
    	try {
	    	Class.forName(driver);  //需要导入JAR包：Access_JDBC30.JAR
	    	conn = DriverManager.getConnection(url);	    	
    	} catch (Exception e) {
    	// TODO Auto-generated catch block
    		e.printStackTrace();
    	}		    	
	}
	
	public Connection getConnection() throws Exception{ 
		return conn;
	} 
	
	public void close() throws Exception{ 
		if(conn!=null) {
			conn.close();
		}
	} 
}
