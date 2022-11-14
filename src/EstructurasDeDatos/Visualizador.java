package EstructurasDeDatos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;


/**
 *
 * @author marin
 */
public class Visualizador extends Application{
    
    private int width = 10;
    private int length = 10;
    private static Grafo setUp;
    
    
    public static void main(String... args) {
        setUp = new Grafo(10, 10);
        
        setUp.Load();
        
        setUp.PrintGrafo();
        
        launch(args);
    }
    
    public void start(Stage stage) {
        Group g = new Group();
        Scene scene = new Scene(g, (width + 1) * 50, (length + 1) * 50, Color.BLACK);
        stage.setTitle("Prim's Maze Generator");
        stage.show();
        
        
        
        
        
        Text text = new Text(62, 80, "Start");
        Ellipse ellipse = new Ellipse(75, 75, 20, 20);
        ellipse.setFill(Color.BLUE);
        g.getChildren().add(ellipse);
        g.getChildren().add(text);

        stage.setScene(scene);
        stage.show(); //Makes the window visible to the user
    }
    
}
