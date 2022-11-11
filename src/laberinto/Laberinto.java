/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laberinto;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.Grafo;
//import EstructurasDeDatos.Prim;
//import Interfaces.InterfazPrincipal;
//
// *
// * @author valeriazampetti
// */
public class Laberinto {
       //private static final InterfazPrincipal window = new InterfazPrincipal();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //window.setVisible(true);

         
         Grafo graph = new Grafo(4, 4);
         
         graph.Load();
         
         graph.PrintGrafo();
         
    }
    
}