package EstructurasDeDatos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author valeriazampetti
 */
public class Nodo<T> 
{
   private Nodo<T> pNext;
    private Nodo<T> pLast;
    private Vertice info;
    
    public Nodo() 
    {
        this.pNext = null;
        this.pLast = null;
    }
    
    public Nodo(Vertice info) 
    {
        this.pNext = null;
        this.pLast = null;
        this.info = info;
    }
     
     /**
     * @return the pNext
     */
    public Nodo<T> getpNext() {  return pNext;  }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo<T> pNext) { this.pNext = pNext; }

    /**
     * @return the pLast
     */
    public Nodo<T> getpLast() { return pLast; }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo<T> pLast) { this.pLast = pLast; }

    /**
     * @return the info
     */
    public Vertice getInfo() { return info; }

    /**
     * @param info the info to set
     */
    public void setInfo(Vertice info) { this.info = info; }    
}




