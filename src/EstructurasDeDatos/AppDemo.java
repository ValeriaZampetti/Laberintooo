/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;


//CORRER EL PROYECTO DANDOLE CLICK DERECHO A LA INTERFAZ LLAMADA "InterfazPrincipal.java" Y DARLE A "RUN FILE"



import EstructurasDeDatos.Grafo;
import static javafx.application.Application.launch;
import EstructurasDeDatos.Vertice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class AppDemo extends Application{
    
    public static int width = 10;
    public static int length = 10;
    public static Grafo setUp;


    
    public static void main(String... args) {
        Grafo aux = new Grafo(10, 10);        
        aux.Load();
        //System.out.println("Grafo inicial");
        //aux.PrintGrafo();
        //setUp = aux.Prim(aux);
        //System.out.println("Grafo Prim");
        //setUp.PrintGrafo();
        setUp = aux;
        launch(args);
    }

    
    @Override
    public void start(Stage stage) throws Exception{
        setUp = setUp.Prim(setUp);
        Group g = new Group();
        Scene scene = new Scene(g, (width + 1) * 50, (length + 1) * 50, Color.BLACK);
        stage.setTitle("Laberinto");
        stage.show();
        
        //RECORRER GRAFO
        for (int i = 0; i < setUp.getListaAdyacencia().getSize(); i++) 
        {
            //System.out.println(setUp.getListaAdyacencia().getSize()-1);
            var fila = setUp.getListaAdyacencia().buscar(i);
            //System.out.println("fila: " + fila.getId());
            //System.out.println(this.listaAdyacencia.size);
            //System.out.println("Columnas");
            var listaDeColumnas = fila.getAristas();
            //listaDeColumnas.printlista();
            for (int j = 0; j < listaDeColumnas.getSize(); j++) 
            {
                var celdaColumna = listaDeColumnas.buscar(j);
                g.getChildren().add(drawTop(celdaColumna, fila.getId()));
                g.getChildren().add(drawBottom(celdaColumna, fila.getId()));
                g.getChildren().add(drawLeft(celdaColumna, fila.getId()));
                g.getChildren().add(drawRight(celdaColumna, fila.getId()));                
            }
        }

        stage.setScene(scene);
        stage.show(); //Makes the window visible to the user
    }
    
    //Draws top wall as a line
    private Line drawTop(Vertice vert, int numFila) {
        if (vert.getMuros().isTop()) {
            Line top = new Line(50 * vert.getId(), numFila * 50, (50 * vert.getId() + 50), 50 * numFila);
            top.setStroke(Color.WHITE);
            return top;
        } else{
            Line top = new Line(50 * vert.getId(), numFila * 50, (50 * vert.getId() + 50), 50 * numFila);
            top.setStroke(Color.BLACK);
            return top;
        }
    }

    //Draws right wall as a line
    private Line drawBottom(Vertice vert, int numFila) {
        if (vert.getMuros().isBottom()) {
            Line bottom = new Line(50 * vert.getId(), (50 * numFila + 50), (50 * vert.getId() + 50), (50 * numFila + 50));
            bottom.setStroke(Color.WHITE);
            return bottom;
        }else{
            Line bottom = new Line(50 * vert.getId(), (50 * numFila + 50), (50 * vert.getId() + 50), (50 * numFila + 50));
            bottom.setStroke(Color.BLACK);
            return bottom;
        }
    }

    //Draws left wall as a line
    private Line drawLeft(Vertice vert, int numFila) {
        if (vert.getMuros().isLeft()) {
            Line left = new Line(vert.getId() * 50, numFila * 50, vert.getId() * 50, (50 * numFila + 50));
            left.setStroke(Color.WHITE);
            return left;
        } else{
            Line left = new Line(vert.getId() * 50, numFila * 50, vert.getId() * 50, (50 * numFila + 50));
            left.setStroke(Color.BLACK);
            return left;
        }
    }

    //Draws right wall as a line
    private Line drawRight(Vertice vert, int numFila) {
        if (vert.getMuros().isRight()) {
            Line right = new Line((50 * vert.getId() + 50), numFila * 50, (50 * vert.getId() + 50), (50 * numFila + 50));
            right.setStroke(Color.WHITE);
            return right;
        }else{
            Line right = new Line((50 * vert.getId() + 50), numFila * 50, (50 * vert.getId() + 50), (50 * numFila + 50));
            right.setStroke(Color.BLACK);
            return right;
        }
    }
    
}