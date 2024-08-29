
package pi.model;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Lista {
    private static ArrayList<Codigo> Listaa = new ArrayList<Codigo>();
    
 public static void Adicionar(Codigo c){
     c.setId(Listaa.size() + 1);
     Listaa.add(c);
 } 
 
 public static ArrayList<Codigo> listar(){
     return Listaa;
 }
 
 public static boolean Excluir(int Id){
     try {
             if (Id < 0){
                
             } else {
                 Listaa.remove(Id);
                 return true;
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir da lista");
         }
         return false;
     }
 }
 
    

