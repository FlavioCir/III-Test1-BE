package Esercizio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DB {

	private final String url = "jdbc:postgresql://localhost:5432/es1-s3-week3?useSSL=false";
    private final String username = "postgres";
    private final String password = "postgres";
    
    static Connection conn = null;
    
    public void connect() {
    	try {
            System.out.println("Connecting to database " + url);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connsessione eseguita con successo!");
          }
          catch(Exception e) {
              e.printStackTrace();
          }
    }
    
    public void disconnect() {
    	if( conn != null ) {
        	try {
        		conn.close();
        		System.out.println( "Disconnessione eseguita con successo!" );
	        } catch ( SQLException e ) {
	        	e.printStackTrace();
	        }
        }
    }
	
}
