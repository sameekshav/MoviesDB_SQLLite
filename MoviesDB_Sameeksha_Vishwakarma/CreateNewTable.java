package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateNewTable {

    public static void NewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/SAMEEKSHA.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"
                + " Id integer PRIMARY KEY,\n"
                + " Movie_Name text NOT NULL,\n"
		+ " Lead_Actor text NOT NULL,\n"
		+ " Lead_Actress text NOT NULL,\n"
		+ " Director_Name text NOT NULL,\n"
		+ " Year_Of_Release integer NOT NULL\n"
                + ");";

        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        NewTable();
    }

}