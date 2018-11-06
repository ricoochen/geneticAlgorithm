package ga.aps.run;

import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import ga.aps.controller.myConnection.DBConnection;

public class connDB {
	
    public static void main(String[] args) throws Exception { 

    	try {
    		
	    	Connection conn = new DBConnection().getConnection();
	
	    	Statement stat =  conn.createStatement();
	
	    	String sql =  "select * from APS_ConstraintTemplateItem";
	
	    	ResultSet rs  = stat.executeQuery(sql);

	    	while(rs.next()){

	    		System.out.println(rs.getString(2));

	    	}
	    	
	    	rs.close();
	    	conn.close();

    	} catch (ClassNotFoundException | SQLException e) {

    	// TODO Auto-generated catch block

    		e.printStackTrace();

    	}

    }
}
