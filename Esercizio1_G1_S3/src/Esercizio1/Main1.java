package Esercizio1;

import java.time.LocalDate;

public class Main1 {

	public static void main(String[] args) {
		
		DB db = new DB();
		Cliente c1 = new Cliente("Francesco", "Neri", LocalDate.of(1999, 9, 17), "Sicilia");
		db.connect();
		
		boolean nuovoCliente = false;
        
        if( nuovoCliente ) {
        	c1.inserisciCliente();
        }
        
        boolean estraiClinte = true;
        
        if( estraiClinte ) {
        	c1.estraiCliente();
        }
        
        db.disconnect();

	}

}
