package app;


import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


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
        
        try {   
            ArrayList<String> array = new ArrayList<String>();
            FileReader fr = new FileReader("Ventas.txt");  
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while((linea=br.readLine())!=null){
                array.add(linea) ;
            }         

            fr.close(); 
            br.close();   

            int i=0;
            while(i < array.size()){
                System.out.println(array.get(i));
                i++;                        
            }           
        } catch (IOException e) { 
            System.out.println("Error e/S " +e);
        } 
    }
    }

      
