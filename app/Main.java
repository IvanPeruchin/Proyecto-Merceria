package app;

public class Main{

   public static void main(String[] args){
       Data cola1 = new Data();

       int precio = 150;
       int cant = 3;

       cola1.agregarProducto("Lana", precio, cant);
       cola1.agregarProducto("Pompon", precio, cant);
       cola1.agregarProducto("Aguja", precio, cant);
       System.out.println(cola1);

       cola1.aumentarPrecio("Pompon", 50);
       cola1.aumentarPrecio("Lana", 20);
       cola1.aumentarPrecio("Aguja", 10);
       System.out.println(cola1);

       cola1.eliminarProducto("Aguja");
       System.out.println(cola1);
       

      
   }
}



