/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laberinto;
import EstructurasDeDatos.Lista;
//import EstructurasDeDatos.Grafo;
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
        
      
        // TODO code application logic here
        
         //Grafo grafo = Prim.genLaberinto(10, 10);
         
         var list = new Lista<String>();
         
         list.insertarPrimero("a");
         list.insertarPrimero("b");
         list.insertarPrimero("c");
         list.insertarPrimero("d");
         list.insertarPrimero("e");
         
         list.printlista();
         
    }
    
}
