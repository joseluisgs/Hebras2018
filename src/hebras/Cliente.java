/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hebras;

/**
 *
 * @author joseluisgs
 */
public class Cliente {

	private String nombre;
	private int[] carroCompra;

	// Constructor, getter y setter
        
        public Cliente(String nombre, int[] carroCompra) {
            this.nombre= nombre;
            this.carroCompra = carroCompra;
        }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the carroCompra
     */
    public int[] getCarroCompra() {
        return carroCompra;
    }

    /**
     * @param carroCompra the carroCompra to set
     */
    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }

}
