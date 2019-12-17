/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hebras;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseluisgs
 */
public class Hebras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //procesarCarrosSecuencial();
       procesarCarrosConcurrentemente();
        
    }

    private static void procesarCarrosSecuencial() {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3});
	Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();

		cajera1.procesarCompra(cliente1, initialTime);
		cajera2.procesarCompra(cliente2, initialTime);
    }

    private static void procesarCarrosConcurrentemente() {
       Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		CajeraHebra cajera1 = new CajeraHebra("Cajera 1", cliente1, initialTime);
		CajeraHebra cajera2 = new CajeraHebra("Cajera 2", cliente2, initialTime);
                
                // Ejecución concurrente
		cajera1.start();
		cajera2.start();
             
        try {
            // Esperamos que termine el programa
            cajera1.join();
            cajera2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hebras.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
}
