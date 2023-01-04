package app;

import java.util.Scanner;

public class Main2{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scanner nm = new Scanner(System.in);
        Data Merceria = new Data();

        String nombre = "";
        float precio = 0;
        int aumento = 0;
        int cant = 0;
        int op = 0;

        

        
        while(op != 8){
            Merceria.menu();
            System.out.println("\n -Ingrese la opcion que desea");
            op = sc.nextInt();
            Merceria.limpiar();

            //agregar articulo
            if(op == 1){
                System.out.println("Ingrese el nombre del articulo, el precio y la cantidad: \n");

                System.out.print("Nombre: ");
                nombre = nm.nextLine();
                
                System.out.print("\nPrecio: ");
                precio = sc.nextFloat();
                
                System.out.print("\nStock: ");
                cant = sc.nextInt();
                
                Merceria.agregarProducto(nombre, precio, cant);
                System.out.print(Merceria);

                Merceria.limpiar();
            }

            //modificar stock
            if(op == 2){
                System.out.println("Articulo: ");
                nombre = nm.nextLine();
                System.out.println("\n Stock ingresado: ");
                cant = sc.nextInt();
                Merceria.modificarStock(nombre, cant);
                Merceria.limpiar();
            }

            //Aumentar el precio de un producto
            if(op == 3){
                System.out.println("Articulo: ");
                nombre = nm.nextLine();
                System.out.println("\n Porcentaje de aumento: ");
                aumento = sc.nextInt();
                Merceria.aumentarPrecio(nombre, aumento);
                Merceria.limpiar();
            }

            //Aumentar el precio de todos los productos
            if(op == 4){
                System.out.println("\n Porcentaje de aumento: ");
                cant = sc.nextInt();
                Merceria.aumentarPrecioTodos(aumento);
                Merceria.limpiar();
            }

            //Modificar el precio de un producto
            if(op == 5){
                System.out.println("Articulo: ");
                nombre = nm.nextLine();
                System.out.println("\n Stock ingresado: ");
                precio = sc.nextFloat();
                Merceria.modificarPrecio(nombre, precio);
                Merceria.limpiar();
            }

            //hacer una venta
            if(op == 6){
                System.out.println("Articulo: ");
                nombre = nm.nextLine();
                System.out.println("\n Cantidad vendidas: ");
                cant = sc.nextInt();
                Merceria.ventas(nombre, cant);
                Merceria.limpiar();
            }

            //Mostrar los articulos
            if(op == 7){
                System.out.println(Merceria);
            }


            if(op == 8){
                Merceria.limpiar();
                break;
            }
        }

       
      
   }
}
