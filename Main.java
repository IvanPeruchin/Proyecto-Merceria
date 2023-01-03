package app;

public class Main{

   public static void main(String[] args){
       Data cola1 = new Data();

       int precio = 150;

       cola1.agregarProducto("Lana", precio);
       cola1.agregarProducto("Pompon", precio);
       cola1.agregarProducto("Aguja", precio);
       System.out.println(cola1);
       
      
   }
}
