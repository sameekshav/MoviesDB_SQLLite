package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertData {

   
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

    
    public void insert(String Movie_Name,String Lead_Actor,String Lead_Actress,String Director_name, Integer Year_Of_Release) {
        String sql = "INSERT INTO Movies(Movie_Name,Lead_Actor,Lead_Actress,Director_name,Year_Of_Release) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            	pstmt.setString(1, Movie_Name);
		pstmt.setString(2, Lead_Actor);
		pstmt.setString(3, Lead_Actress);
		pstmt.setString(4, Director_name);
            	pstmt.setInt(5, Year_Of_Release);
            	pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertData data = new InsertData();
        // insert three new rows
        data.insert("3Idiots","Amir Khan,R.Madhavan,Sharman Joshi","Kareena Kapoor","Rajkumar Hirani", 2009);
        data.insert("Chhichhore","Sushant Singh Rajput","Shraddha Kapoor","Nitesh Tiwari", 2019);
        data.insert("Zindagi Na Milegi Dobara","Hrithik Roshan,Abhay Deol,Farhan Akhtar","Katrina Kaif,Kalki Koechlin","Zoya Akhtar", 2011);
        data.insert("Super30","Hrithik Roshan","Mrunal Thakur","Vikas Bahl", 2019);
	data.insert("Jhon Wick[Chapter 1]","Keanu Reeves","NA","Chad Stahelski", 2014);
	data.insert("Jhon Wick[Chapter 2]","Keanu Reeves","NA","Chad Stahelski", 2017);
	data.insert("Jhon Wick[Chapter 3]","Keanu Reeves","NA","Chad Stahelski", 2019);
	data.insert("Madmax","Tom Hardy","Charlize Theron","George Miller", 2015);
	data.insert("Kabir Singh","Shahid Kapoor","Kiara Advani","Sandeep Reddy Vanga", 2019);
	data.insert("Kesari","Akshay Kumar","Parineeti Chopra","Anurag Singh", 2019);
    }

}