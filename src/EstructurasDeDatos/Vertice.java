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
    private Lista<T> aristas; // columnas
    private Muro muros; // muros de cada casilla del laberinto
    private int id;
    
    public Vertice()
    {
        this.aristas = new Lista();
    }
    
    public Vertice(int id)
    {
        this.id = id;
        this.aristas = new Lista();
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

    /**
     * @return the muros
     */
    public Muro getMuros() {
        return muros;
    }

    /**
     * @param muros the muros to set
     */
    public void setMuros(Muro muros) {
        this.muros = muros;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}