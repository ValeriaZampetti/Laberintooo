/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *

 */
public class Vertice<T> 
{
    private Lista <T> aristas; // filas
    private int id;
    private Lista<T> muros;
    public Vertice()
    {
        this.aristas = new Lista();
        // representar los 4 muros
        
        // -> deben ser metodos retornen booleano
        
        // -> // si el vertice es esquina tiene dos muros 
        
        // -> // si el vertice esta en un borde y no es esquina tiene 3 muros
        
        // -> // si el vertice no cumple una de las condiciones anteriores entonces tiene 4 muros
    }
    
    public Vertice(int id)
    {
        this.id = id;
        this.aristas = new Lista();
        this.muros= new Lista();
    }
    
    

    /**
     * @return the aristas
     */
    public Lista<T> getAristas() {
        return aristas;
    }

    /**
     * @param aristas the aristas to set
     */
    public void setAristas(Lista<T> aristas) {
        this.aristas = aristas;
    }
    
    
}
