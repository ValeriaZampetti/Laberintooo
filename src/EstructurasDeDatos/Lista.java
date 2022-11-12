package EstructurasDeDatos;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author valeriazampetti
 * @param <T>
 */
public class Lista<T>{
    
    private Nodo<T> pInicio;
    //public Nodo<T> pFinal;
    private int size;

    public Lista()
    {
        this.pInicio = null;
        this.size = 0;
    }
    
    //Método para agregar primer elemento a la lista
    public void insertarPrimero(Vertice info) 
    {
        Nodo nuevo = new Nodo(info);       
        nuevo.setpNext(getpInicio());
        setpInicio((Nodo<T>) nuevo);
        setSize(getSize() + 1);
    }

    //Método para insertar de ultimo
    public void insertarUltimo(Vertice info) 
    {
        Nodo nuevo = new Nodo(info);
        if (getpInicio() == null) {
            setpInicio((Nodo<T>) nuevo);
        } else {
            Nodo temp = getpInicio();
            while (temp.getpNext() != null) {
                temp = temp.getpNext();
            }
            temp.setpNext(nuevo);
        }
        setSize(getSize() + 1);
    }
    
    public void insertarUltimo(Nodo nodito) 
    {
        if (getpInicio() == null) 
        {
            setpInicio((Nodo<T>) nodito);
        } else 
        {
            Nodo temp = getpInicio();
            while (temp.getpNext() != null) 
            {
                temp = temp.getpNext();
            }
            temp.setpNext(nodito);
        }
        setSize(getSize() + 1);
    }
    
   /* public void insertarUltimo(int[] posicion, int count) 
    {
        Nodo nuevo = new Nodo(posicion, count);
        if (pInicio == null) {
            pInicio = nuevo;
        } else {
            Nodo temp = pInicio;
            while (temp.pNext != null) {
                temp = temp.pNext;
            }
            temp.pNext = nuevo;
        }
        size++;
    }
    */
    
    public Nodo buscar(Vertice info)
    {
        Nodo pAux = getpInicio();
        while (pAux.getpNext() != null) 
        {            
            if (pAux.getInfo().equals(info)) 
            {
                return pAux;
            }
            pAux = pAux.getpNext();
        }        
        return null;
    }
    
    public Vertice buscar(int id)
    {
        Nodo pAux = getpInicio();
        for (int i = 0; i < this.getSize(); i++) 
        {
            if (pAux.getInfo().getId() == id) 
            {
                return pAux.getInfo();
            }
            pAux = pAux.getpNext();
        }        
        return null;
    }
    
    /*public Nodo buscarCount(int posicion)
    {
        Nodo pAux = pInicio;
        for (int i = 0; i < size; i++) 
        {
            pAux = pAux.getpNext();
        }
        
        return pAux;
    }*/
    
    //Método para eliminar el primer elemento
    public void borrarFirst() 
    {
        
        if (getpInicio() != null) 
        {
            Nodo aux = getpInicio();
            setpInicio(getpInicio().getpNext());
            aux.setpNext(null);
            setSize(getSize() - 1);
        }
    }
   
    
    //Método para eliminar el ultimo
    /*public void borrarLast() 
    {
        if (pInicio != null) 
        {
            if (pInicio.getpNext() == null) 
            {
                pInicio = null;
            } 
            else 
            {
                Nodo temp = pInicio;
                while (temp.getpNext() != null) 
                {
                    temp = temp.getpNext();
                }
                temp.pNext = null;
            }
        }
    }*/
    
    
    //Método para eliminar un elemento cualquiera
    public void eliminarElemen(Nodo n) 
    {
        if (getpInicio() != null) 
        {
            Nodo pAux = getpInicio();
            
            while(pAux.getInfo() != n.getInfo())
            {
                pAux = pAux.getpNext();
            }
            
            Nodo sig = pAux.getpNext();
            Nodo ant = pAux.getpLast();
            
            if (sig != null && ant != null)
            {
                ant.setpNext(sig);
                sig.setpLast(ant);
                pAux.setpLast(null);
                pAux.setpNext(null);
                setSize(getSize() - 1);
            } 
            else if (sig == null && ant != null) 
            {
                Nodo aux = ant.getpLast();
                aux.setpNext(null);                
                ant.setpLast(null);
                setSize(getSize() - 1);
            } 
            else if (sig != null && ant == null)
            {
                borrarFirst();
            }
        }                
    }
    
    public void printlista()
    {        
        Nodo aux = this.getpInicio();

        while (aux != null) 
        {
            System.out.println("nodo --> "+ aux.getInfo().getId() + ", ");
            aux = aux.getpNext();
        }        
    }

    /**
     * @return the pInicio
     */
    public Nodo<T> getpInicio() {
        return pInicio;
    }

    /**
     * @param pInicio the pInicio to set
     */
    public void setpInicio(Nodo<T> pInicio) {
        this.pInicio = pInicio;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
         
            

    
    
    
}