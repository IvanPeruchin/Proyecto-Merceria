package app;


import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *video: Curso Java #38 - FileReader y FileWriter
 * FileReader lee por caracteres
 */
public class Archivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("app\\Archivo.txt",true);            
            
        fw.write("esto es una preuba");
        fw.write(97);
        fw.close();
         
            FileReader fr = new FileReader("app\\Archivo.txt");
            
            int valor = fr.read();
            
            while (valor!=-1) {
                System.out.println((char)valor);
                valor=fr.read();
            }
            fr.close();            

        
        } catch (IOException e) { 
            System.out.println("Error e/S " +e);
        }    
        
        try {
            FileWriter fw = new FileWriter("app\\Archivo.txt",true);           
            fw.close();         
            FileReader fr = new FileReader("app\\Archivo.txt");           
            fr.close();          
        } catch (IOException e) { 
            System.out.println("Error e/S " +e);
        }    
        
      
    }

      
}