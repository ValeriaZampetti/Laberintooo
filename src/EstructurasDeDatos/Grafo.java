package EstructurasDeDatos;

import java.util.Random;

/**
 *
 * @author valeriazampetti
 */
public class Grafo {

    //Lista de listas de adyacencia
    private Lista<Vertice> listaAdyacencia; // filas
    // (Vertice, Vertice)
    //(vertices)-> (lista de aristas)
    // 0        -> (0,0) - (0,1) - (0,2) - (0,3)    
    // 1        -> (1,0) - (1,1) - (1,2) - (1,3)    
    // 2        -> (2,0) - (2,1) - (2,2) - (2,3)    
    // 3        -> (3,0) - (3,1) - (3,2) - (3,3)    
    private int numVertices;

    private int cantAristas;

    public Grafo() {
        this.numVertices = 0;
    }

    public Grafo(int ancho, int largo) {
        this.numVertices = ancho;
        this.cantAristas = largo;
        this.listaAdyacencia = new Lista();
    }

    public void Load() {
        // representar los 4 muros

        // -> deben ser metodos retornen booleano
        // -> // si el vertice es esquina tiene dos muros  
        //i -> filas j -> columnas
        // (0,0) (i, 0) (0,j) (i,j)        
        // -> // si el vertice esta en un borde y no es esquina tiene 3 muros
        // -> // si el vertice no cumple una de las condiciones anteriores entonces tiene 4 muros
        if (this.getNumVertices() > 0 && this.getCantAristas() > 0) {
            for (int i = 0; i <= getNumVertices() - 1; i++) {
                Vertice fila = new Vertice(i);

                for (int j = 0; j <= this.getCantAristas() - 1; j++) {
                    Vertice columna = new Vertice(j);

                    // instancia de muros, inicializa con todos los muros
                    Muro murito = new Muro();
                    columna.setMuros(murito);
                    var aux = fila.getAristas();
                    aux.insertarUltimo(columna);
                    fila.setAristas(aux);
                }

                this.getListaAdyacencia().insertarUltimo(fila);
            }
        }

    }

    public void Prim(int ancho, int largo) {
        //paso 2
        Grafo graph = new Grafo(ancho, largo);

        graph.Load();

        //paso 3
        // ==> Seleccionar una habitacion inicial
        int coordX = RandomNumber(largo);
        int coordY = RandomNumber(ancho);

        while (ExisteVertivesNoRecorridos(graph)) {
            Vertice fila = this.getListaAdyacencia().buscar(coordY);
            Vertice casilla = fila.getAristas().buscar(coordX);

            if (!casilla.isRecorrido()) {

                casilla.setRecorrido(true);
                // paso 4coordX
                BuscarAdyacentes(graph, casilla.getId(), fila.getId());
            }
        }

        // retornar un grafo
    }

    public boolean ExisteVertivesNoRecorridos(Grafo graph) {
        //recorrer el grafo y ver si todos los vertices estan recorridos
        //retorna true si existen 
        // retorna false si no hay
        return true;
    }

    public Grafo BuscarAdyacentes(Grafo graph, int coordX, int coordY) {
        // buscar y guardar sus vertices adyacentes
        //Lista<Vertice> VerticesAdyacentes = new Lista();
        Vertice casillaActual = graph.getListaAdyacencia().buscar(coordY).getAristas().buscar(coordX);

        int iRandom = RandomNumber(4);

        switch (iRandom) {
            case 0:
                if (!(coordY - 1 < 0)) {   //existe adyacencia superior
                    Vertice fila = graph.getListaAdyacencia().buscar(coordY - 1);
                    Vertice casilla = fila.getAristas().buscar(coordX);

                    Muro muroActual = casillaActual.getMuros();
                    muroActual.setTop(false);
                    Muro muroAdyacencia = casilla.getMuros();
                    muroAdyacencia.setBottom(false);

                    casillaActual.setMuros(muroActual);
                    casilla.setMuros(muroAdyacencia);
                } else {
                    BuscarAdyacentes(graph, coordX, coordY);
                }
                break;
            case 1:
                if (!(coordY + 1 > this.numVertices - 1)) {
                    // existe adyacencia inferior
                    Vertice fila = graph.getListaAdyacencia().buscar(coordY + 1);
                    Vertice casilla = fila.getAristas().buscar(coordX);

                    Muro muroActual = casillaActual.getMuros();
                    muroActual.setBottom(false);
                    Muro muroAdyacencia = casilla.getMuros();
                    muroAdyacencia.setTop(false);

                    casillaActual.setMuros(muroActual);
                    casilla.setMuros(muroAdyacencia);

                } else {
                    BuscarAdyacentes(graph, coordX, coordY);
                }
                break;
            case 2:
                if (!(coordX - 1 < 0)) {
                    // existe adyacencia izquierda
                    Vertice fila = graph.getListaAdyacencia().buscar(coordY);
                    Vertice casilla = fila.getAristas().buscar(coordX - 1);

                    Muro muroActual = casillaActual.getMuros();
                    muroActual.setLeft(false);
                    Muro muroAdyacencia = casilla.getMuros();
                    muroAdyacencia.setRight(false);
                    
                    casillaActual.setMuros(muroActual);
                    casilla.setMuros(muroAdyacencia);

                } else {
                    BuscarAdyacentes(graph, coordX, coordY);
                }
                break;
            case 3:
                if (!(coordX + 1 > this.cantAristas - 1)) {
                    // adyacencia derecha
                    Vertice fila = graph.getListaAdyacencia().buscar(coordY);
                    Vertice casilla = fila.getAristas().buscar(coordX + 1);

                    Muro muroActual = casillaActual.getMuros();
                    muroActual.setRight(false);
                    Muro muroAdyacencia = casilla.getMuros();
                    muroAdyacencia.setLeft(false);
                    
                    casillaActual.setMuros(muroActual);
                    casilla.setMuros(muroAdyacencia);


                } else {
                    BuscarAdyacentes(graph, coordX, coordY);
                }
                break;
            default:
                break;
        }

        return graph; // retornar un grafo
    }

    public static int RandomNumber(int end) {
        Random rd = new Random();
        return rd.nextInt(end);
    }

    public void PrintGrafo() {
        System.out.println(this.getCantAristas());
        System.out.println(this.getNumVertices());
        System.out.println("lista de adyacencia");
        this.getListaAdyacencia().printlista();

        for (int i = 0; i < this.getListaAdyacencia().getSize(); i++) {
//            System.out.println(this.getListaAdyacencia().getSize());
            Vertice fila = this.getListaAdyacencia().buscar(i);
            System.out.println("fila: " + fila.getId());
            //System.out.println(this.listaAdyacencia.size);
            System.out.println("Columnas");
            fila.getAristas().printlista();
        }
    }


    /*
    
    for (int j = 0; j < fila.getAristas().size - 1; j++) {
                System.out.println(fila.getAristas().size);
                Vertice columna = fila.getAristas().buscar(j);
                System.out.println("columna: " + columna.getId());
            }
    
    
    public int numnodos;
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
    /**
     * @return the listaAdyacencia
     */
    public Lista<Vertice> getListaAdyacencia() {
        return listaAdyacencia;
    }

    /**
     * @param listaAdyacencia the listaAdyacencia to set
     */
    public void setListaAdyacencia(Lista<Vertice> listaAdyacencia) {
        this.listaAdyacencia = listaAdyacencia;
    }

    /**
     * @return the numVertices
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * @param numVertices the numVertices to set
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * @return the cantAristas
     */
    public int getCantAristas() {
        return cantAristas;
    }

    /**
     * @param cantAristas the cantAristas to set
     */
    public void setCantAristas(int cantAristas) {
        this.cantAristas = cantAristas;
    }
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

