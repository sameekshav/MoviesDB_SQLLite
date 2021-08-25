package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

    public class QueryWithParameter{
		
		
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/SAMEEKSHA.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	public void Parameter(){
               String sql = "SELECT * from Movies where Lead_Actor like '%Hrithik Roshan%';";
        
        try (Connection conn = this.connect();
              PreparedStatement pstmt  = conn.prepareStatement(sql)){
           
            	ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t" + 
                                   rs.getString("Movie_Name") + "\t" +
				   rs.getString("Lead_Actor") + "\t" +
				   rs.getString("Lead_Actress") + "\t" +
				   rs.getString("Director_name") + "\t" +				   
                                   rs.getInt("Year_Of_Release"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	 public static void main(String[] args) {
        	QueryWithParameter param = new QueryWithParameter();
        	param.Parameter();
    }

}
