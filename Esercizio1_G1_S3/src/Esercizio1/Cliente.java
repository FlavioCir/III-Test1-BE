package Esercizio1;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Cliente extends DB {
	
	String nome;
	String cognome;
	LocalDate data_nascita;
	String regione_residenza;
	
	public Cliente(String nome, String cognome, LocalDate data_nascita, String regione_residenza) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.regione_residenza = regione_residenza;
		
	}

	public void inserisciCliente() {
    	try {
    		String sql = "INSERT INTO clienti(nome, cognome, data_nascita, regione_residenza) VALUES (?, ?, ?, ?)";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, nome);
    		stmt.setString(2, cognome);
    		stmt.setDate(3, java.sql.Date.valueOf(data_nascita));
    		stmt.setString(4, regione_residenza);
    		stmt.execute();
    		
    		System.out.println( "Inserimento del cliente eseguito con successo!" );
    	} catch(SQLException e) {
    		System.out.println( "Errore durante l'inserimento del cliente!" );
    		e.printStackTrace();
    	}
    }
	
	public void estraiCliente() {
		try {
	        System.out.println("Clienti estratti:");
	        Statement stmt = conn.createStatement();
	        ResultSet rs = 

	        stmt.executeQuery("SELECT nome, cognome FROM clienti WHERE data_nascita BETWEEN '1982-01-01' AND '1982-12-31'");
	        while( rs.next() ) {
	            System.out.printf(
	                "Nome: %s Cognome: %s%n", 
	                rs.getString("nome"),
	                rs.getString("cognome")
	            );
	            System.out.println("-----------------------------------------------");
	        }

	    }
	    catch(SQLException e) {
	        System.out.println("Errore durante l'estrazione dei clienti!");
	        e.printStackTrace();
	    }
    }
	
}
