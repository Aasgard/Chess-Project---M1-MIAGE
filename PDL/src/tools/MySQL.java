package tools;

import java.sql.*;
import com.mysql.jdbc.Connection;

public class MySQL {

	private Connection cnx;
	private static MySQL db;
	private String lastQuery;
	
	private MySQL(){
		/*String url= "jdbc:mysql://109.8.192.56/";
        String dbName = "pdlchess";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "pdlchess";
        String password = "miage2015";*/
        
             
        String url= "jdbc:mysql://127.0.0.1/";
        String dbName = "pdl2";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        
        try {
            Class.forName(driver).newInstance();
            this.cnx = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception e) { e.printStackTrace(); }
	}
	
	public static synchronized MySQL getInstance(){
		if(db == null){
			db = new MySQL();
		}
		return db;
	}
	
	public ResultSet query(String query) throws SQLException{
		Statement st = db.cnx.createStatement();
		ResultSet rs = st.executeQuery(query);
		this.lastQuery = query;
		
		return rs;
	}
	
	public String getLastQUeery(){
		return this.lastQuery;
	}
	
	
}
