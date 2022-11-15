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
                var fila = new Vertice(i);

                for (int j = 0; j <= this.getCantAristas() - 1; j++) {
                    var columna = new Vertice(j);

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

    public Grafo Prim(Grafo graph) 
    {
        //paso 3
        // ==> Seleccionar una habitacion inicial
        while (!ExisteVerticesRecorridos(graph)) 
        {
            int coordX = RandomNumber(graph.cantAristas);
            int coordY = RandomNumber(graph.numVertices);
            var fila = this.getListaAdyacencia().buscar(coordY);
            var casilla = fila.getAristas().buscar(coordX);
            
            if (!casilla.isRecorrido()) 
            {

                casilla.setRecorrido(true);
                // paso 4coordX
                BuscarAdyacentes(graph, casilla.getId(), fila.getId());
            }
        }

        return graph; // retornar un grafo
    }

    public boolean ExisteVerticesRecorridos(Grafo graph) 
    {
        boolean result = true;
        for (int i = 0; i < graph.getListaAdyacencia().getSize(); i++) 
        {
            //System.out.println(this.getListaAdyacencia().getSize());
            var fila = graph.getListaAdyacencia().buscar(i);
            System.out.println("fila: " + fila.getId());
            //System.out.println(this.listaAdyacencia.size);
            //System.out.println("Columnas");
            var listaDeColumnas = fila.getAristas();
            for (int j = 0; j < listaDeColumnas.getSize(); j++) 
            {
                Vertice celdaColumna = listaDeColumnas.buscar(j);
                System.out.println("Celda: |"+fila.getId()+"-"+celdaColumna.getId()+"|"+" recorrido: "+celdaColumna.isRecorrido());
                if (!celdaColumna.isRecorrido()) 
                {
                    return false;
                }
            }
        }
        return result;
    }
    
    // paso 4. de Prim
    public Grafo BuscarAdyacentes(Grafo graph, int coordX, int coordY) {
        // buscar y guardar sus vertices adyacentes
        //Lista<Vertice> VerticesAdyacentes = new Lista();
        var casillaActual = graph.getListaAdyacencia().buscar(coordY).getAristas().buscar(coordX);

        int iRandom = RandomNumber(4);

        switch (iRandom) {
            case 0:
                if (!(coordY - 1 < 0)) {   //existe adyacencia superior
                    var fila = graph.getListaAdyacencia().buscar(coordY - 1);
                    var casilla = fila.getAristas().buscar(coordX);

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
                    var fila = graph.getListaAdyacencia().buscar(coordY);
                    var casilla = fila.getAristas().buscar(coordX - 1);

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
                    var fila = graph.getListaAdyacencia().buscar(coordY);
                    var casilla = fila.getAristas().buscar(coordX + 1);

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
//        System.out.println(this.getCantAristas());
//        System.out.println(this.getNumVertices());
//        System.out.println("lista de adyacencia");
//        this.getListaAdyacencia().printlista();

        for (int i = 0; i < this.getListaAdyacencia().getSize(); i++) {
//            System.out.println(this.getListaAdyacencia().getSize());
            var fila = this.getListaAdyacencia().buscar(i);
            System.out.println("fila: " + fila.getId());
            //System.out.println(this.listaAdyacencia.size);
            System.out.println("Columnas");
            var listaDeColumnas = fila.getAristas();
            for (int j = 0; j < listaDeColumnas.getSize(); j++) 
            {
                Vertice celdaColumna = listaDeColumnas.buscar(j);
                System.out.println(celdaColumna.getId() + " Muros = "+ "Arriba: "+celdaColumna.getMuros().isTop()+" "
                + "Abajo: "+celdaColumna.getMuros().isBottom()+" "
                + "Izquierda: "+celdaColumna.getMuros().isLeft()+" "
                + "Derecha: "+celdaColumna.getMuros().isRight() 
                +"Recorrido: "+celdaColumna.isRecorrido()+"\n");                
            }
        }
    }

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