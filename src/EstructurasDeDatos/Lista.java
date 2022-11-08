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
    
    public Nodo<T> pInicio;
    //public Nodo<T> pFinal;
    public int size;

    public Lista()
    {
        this.pInicio = null;
        this.size = 0;
    }
    
    //Método para agregar primer elemento a la lista
    public void insertarPrimero(Object info) 
    {
        Nodo nuevo = new Nodo(info);       
        nuevo.setpNext(pInicio);
        pInicio = nuevo;
        size++;
    }

    //Método para insertar de ultimo
    public void insertarUltimo(Object info) 
    {
        Nodo nuevo = new Nodo(info);
        if (pInicio == null) {
            pInicio = nuevo;
        } else {
            Nodo temp = pInicio;
            while (temp.getpNext() != null) {
                temp = temp.getpNext();
            }
            temp.setpNext(nuevo);
        }
        size++;
    }
    
    public void insertarUltimo(Nodo nodito) 
    {
        if (pInicio == null) 
        {
            pInicio = nodito;
        } else 
        {
            Nodo temp = pInicio;
            while (temp.getpNext() != null) 
            {
                temp = temp.getpNext();
            }
            temp.setpNext(nodito);
        }
        size++;
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
    
    public Nodo buscar(Object info)
    {
        Nodo pAux = pInicio;
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
        
        if (pInicio != null) 
        {
            Nodo aux = pInicio;
            pInicio = pInicio.getpNext();
            aux.setpNext(null);
            size--;
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
        if (pInicio != null) 
        {
            Nodo pAux = pInicio;
            
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
                size--;
            } 
            else if (sig == null && ant != null) 
            {
                Nodo aux = ant.getpLast();
                aux.setpNext(null);                
                ant.setpLast(null);
                size--;
            } 
            else if (sig != null && ant == null)
            {
                borrarFirst();
            }
        }                
    }
    
    public void printlista()
    {        
        Nodo aux = this.pInicio;

        while (aux != null) 
        {
            System.out.println("nodo --> "+ aux.getInfo().toString() + ", ");
            aux = aux.getpNext();
        }        
    }
    
         
            

    
    
    
}
