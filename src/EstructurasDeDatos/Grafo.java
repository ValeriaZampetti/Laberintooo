package EstructurasDeDatos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author valeriazampetti
 */
public class Grafo 
{
    
     //Lista de listas de adyacencia

    private Lista<Vertice> listaAdyacencia; // columnas
    
    //(vertices)-> (lista de aristas)
    // 0        -> 0 - 1 - 2 - 3    
    // 1        -> 0 - 1 - 2 - 3
    // 2        -> 0 - 1 - 2 - 3
    // 3        -> 0 - 1 - 2 - 3

    private int numVertices;
    
    private int cantAristas;
    
    public Grafo()
    {
        this.numVertices = 0;
    }
    
    public Grafo(int ancho, int largo)
    {
        this.numVertices = ancho;
        this.cantAristas = largo;
    }
    
    public void LoadLAdyacencia()
    {
        if (this.numVertices > 0 && this.cantAristas > 0) 
        {
            for (int i = 0; i < numVertices-1; i++)
            {
                Vertice aux = new Vertice(i); 

                for (int j = 0; j < cantAristas; j++) 
                {
                    Nodo nodito = new Nodo(j);
                    aux.getAristas().insertarUltimo(nodito);
                    // lista de aristas (Nodo info: int) -> 0 - 1 - 2 - 3
                }
                
                this.listaAdyacencia.insertarUltimo(aux);
            }
        }

    }
    public void AddEdge(Object infoAdd, Object infoSearch)
    {
        // necesito la coordena del vertice
        // necesito la coordenada
        // v -> 

    }
    
    public void Prim(Grafo graf, int ancho, int largo)
    {
        // Primer paso - Agregar vertices a la lista (tantas veces como ancho)        
    }
    
    

    /*public int numnodos;
    public int cantvertices;
    public Lista<Lista> listasAdyacencia;
    
    public Grafo() {
        this.numnodos = 0;
        this.cantvertices = 0;
    }
    
    public Grafo(int numnodos) {
        this.numnodos = numnodos;
        this.cantvertices = 0;
        this.adyacencia = new Lista[numnodos];
    }
    
    public Grafo(int heigth, int width){
        this.numnodos = heigth * width;
        this.cantvertices = 0;
        this.adyacencia = new Lista[heigth];
        
        int count = 0;
        int[] posicion = new int[2];
        for (int i = 0; i < heigth; i++) {
            adyacencia[i] = new Lista();
            for (int j = 0; j < width; j++) {
                posicion[0] = i;
                posicion[1] = j;
                
                adyacencia[i].insertarUltimo(posicion, count);
                count++;
            }
        }
        
        
    }
       
    public Nodo[] getVertices(){
        Nodo[] nodos = new Nodo[cantvertices];
        
        int count = 0;
        for (int i = 0; i < this.adyacencia.length; i++) {
            Nodo aux = this.adyacencia[i].pInicio;
            
            while (aux.pNext != null) {
                nodos[count] = aux;
                aux = aux.pNext;
                count++;
            }
            nodos[count] = aux;
            count++;
        }
        
        return nodos;
    }
    
    public void insertaArista (int i, int j) {
        if (i >= cantvertices){
          System.out.println ("Error, no existe el vértice en el grafo");
          return;
        }
        adyacencia[i].insertarPrimero(j);        
    }
       
   public void eliminaArista (int i, int j) {
        if (j < cantvertices) {
            adyacencia[i].borrarFirst();
        } else {
            System.out.println("Error, no existe el vértice en el grafo");
        } 
    }
   
    public boolean existeArista(int i, int j){
        if (i >= cantvertices){
          System.out.println ("Error, no existe el vértice en el grafo");
          return false;
        }
        return adyacencia[i].buscar(j) == null ? false : true;
    }
   
    
        public void insertaVertice (int n) {
        if (n > numnodos - cantvertices){
            System.out.println ("Error, se supera el número de nodos máximo del grafo");
        } else {
           for (int i = cantvertices; i < cantvertices + n; i++){
               adyacencia[i]= new Lista();               
            }
           cantvertices += n;
         }
    }
    public void imprimirGrafo () {
        System.out.println("Tamaño máximo del grafo: " + numnodos + "\n");
        System.out.println("El grafo contiene " + cantvertices + " vértices: \n");
        for (int i = 0; i < cantvertices; i++) {
            System.out.print ("vértice " + i + ": ");
            adyacencia[i].printlista();
        }
    }
        
        
    public void escribir (Lista lista) {
        Nodo aux;
        aux = lista.pInicio;
        while (aux != null) {
            System.out.print (aux.info + ", ");
            aux = aux.pNext;
        }
        System.out.println ("FIN");
    }
    
    public  Nodo  recorrerProfundidad (int v, boolean [ ] visitados) {
        //se marca el vértice v como visitado
        visitados [v] = true;
        //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
        System.out.println (v);
        //se examinan los vértices adyacentes a v para continuar el recorrido
        for (Integer i = 0; i < this.cantvertices; i++) {
            
            if ((v != i) && (!visitados [i]) && (this.existeArista (v, i)) )
                recorrerProfundidad (i, visitados);
        }
        return null;
    }
    
    public Nodo profundidad(){
        boolean visitados [] = new boolean [this.cantvertices];
        for (int i = 0; i < this.cantvertices; i++) {
            visitados[i] = false;
        }
        
        for (int i = 0; i < this.cantvertices; i++) {
            if (!visitados[i]) {
                Nodo aux = recorrerProfundidad(i, visitados);
                if (aux != null) {
                    return aux;
                }
            }
        }
        return null;
    }
    
    public static void amplitud (Grafo g) {
        Cola cola = new Cola ();
        boolean visitados [ ] = new boolean [g.cantvertices]; 
        int v; //vértice actual
        //Se inicializa el vector visitados [] a false for (int i = 0; i < g.obtenerNumVertices (); i++)
        for (int i = 0; i < g.cantvertices; i++) {
            visitados[i] = false;
        }
        for (int i = 0; i < g.cantvertices; i++) {
            if (!visitados[i]) {
                cola.Encolar(new Nodo(i));
                visitados[i] = true;
                
                while (!cola.EsVacia()) {                    
                    v = (int) cola.Desencolar().info;
                    
                    for (int j = 0; j < g.cantvertices; j++) {
                        if ((v != j) && (g.existeArista(i, j)) && (!visitados[j])) {
                            cola.Encolar(new Nodo(j));
                            visitados[i] = true;
                        }
                    }
                }
            }
        }
    }
    
    public Nodo buscar(int info){
        
        for (int i = 0; i < this.adyacencia.length; i++) {
            Nodo aux = this.adyacencia[i].pInicio;
            
            while (aux.pNext != null) {
                if (aux.info == info) {
                    return aux;
                }
                aux = aux.pNext;
            }
            if (aux.info == info) {
                return aux;
            }
        }
        
        return null;
    }
        
       
 */

}
    
   
   
    
    
//     public boolean EsVacio(){
//        return getpEntrada() == null;
//    }
//        
    
    
    
    //metodos del grafo validar si la entrada tiene algo
    //metodos para validar si la salida tiene algo como booleans if pEntrada
    
//    public boolean esquina(NodoG aux){
//       if (aux.pLeft == null && aux.pRight == null || aux.pUp == null && aux.pDown == null){
//           return true;
//           {else{
//           return false;
//       }
//      
////    
//////        
//////    }
//    
//    
////    
//    //esquina Esquina(Nodo aux) if aux.pLeft== null & & aux.right == null ó(dos rayitas) se hace lo mimso con pUp y pdown  hacerlo con todas las condiciones posibles, son 4 
///       return true else false
    
//    public boolean EsAdyacente(NodoG aux){
//        if (aux.pDown == pEntrada || aux.pLeft == pEntrada || aux.pDown == pEntrada || aux.pUp == pEntrada){
//            return true;
//                    
//    }else{
//            return false;
//        }
//    
//    
//    //para la salida, esADyacente(Nodo aux) if aux.left ==pentrada o aux.right==pentrada o aux.up==pentrada, con down igual si es verdad return true else false
    
    
    //metodo generar(m,n) nodo aux g nos sirve para delimitar inicializar i y j=0 arriba for i<m y for j<n i++ y j++ if(j=0) {aux.gpup== null aux.gpleft==null y lo demas apuntaria al siguiente aux2=Nodo al nodo que creamos auxG, en la siguiente corrida aumentara el i; auxg.pright==aux2 if(i=n)pright==null; i=0
    //if(j>0){auxg pLetf==null pFila1==pFirst y la lista 2 la cremaos en el metodo de generar que se tomara en cuenta la primitiva de la lista se debe hacer la lista HACER CLASE DE LISTA DOBLEMENTE ENLAZADA que tendra lista1 y lista2
    
//    public void generar(m,n){
//        int j=0;
//        int i=0;
////        int numero = (int)(Math. random()*10+1);
////        
//              
//    
//        for (i<m) {
//            for (j<n){
//                if(j==0){
//                    aux == null
//                }
//            }
//        }
//            i++;
//        }
//    }
    //otro metodo Generar entrada y salida i=0 o n  j=0 ó m genere numero random con libreria map random o random y alli llamaremos otro metodo llamado generar borde Generar borde() i=0; i=n o j=m if(hayentrada metodo nodo n=0 creamos arriba del for el nodo auxiliar else if(hay salida) n=1 suponiendo que n no es un objeto MODIFICAR EN STATE else n=2 si no es entrada ni salida 
    
    //INTERFAZ SE RECORRE LA MATRIZ Y YA
       

//    
//    private int[][] Adyacentes;
//    private Object[]Informacion;
//    private int nodos;
//    private boolean vacio= true;
//    
//    public Grafo(int[][] Adyacentes, Object[] Informacion, int nodos) {
//        this.Adyacentes = Adyacentes;
//        this.Informacion = Informacion;
//        this.nodos = nodos;
//    
//    public Grafo(int numeroNodos){
//        Adyacentes = new int[numeroNodos][numeroNodos];
//        Informacion= new Object[numeroNodos];
//        for(int i=0; i<numeroNodos; i++)
//            for (int j=0; j<numeroNodos; j++)
//                Adyacentes[i][j]=0;
//            nodos= numeroNodos;
//    }
//    public boolean EsVacio(){return isVacio();}
//
//    /**
//     * @return the Adyacentes
//     */
//    public int[][] getAdyacentes() {
//        return Adyacentes;
//    }
//
//    /**
//     * @param Adyacentes the Adyacentes to set
//     */
//    public void setAdyacentes(int[][] Adyacentes) {
//        this.Adyacentes = Adyacentes;
//    }
//
//    /**
//     * @return the Informacion
//     */
//    public Object[] getInformacion() {
//        return Informacion;
//    }
//
//    /**
//     * @param Informacion the Informacion to set
//     */
//    public void setInformacion(Object[] Informacion) {
//        this.Informacion = Informacion;
//    }
//
//    /**
//     * @return the nodos
//     */
//    public int getNodos() {
//        return nodos;
//    }
//
//    /**
//     * @param nodos the nodos to set
//     */
//    public void setNodos(int nodos) {
//        this.nodos = nodos;
//    }
//
//    /**
//     * @return the vacio
//     */
//    public boolean isVacio() {
//        return vacio;
//    }
//
//    /**
//     * @param vacio the vacio to set
//     */
//    public void setVacio(boolean vacio) {
//        this.vacio = vacio;
//    }
//        
//    }
//}
    



    
    

    
    

