package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main2{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Scanner nm = new Scanner(System.in);
        Scanner cnt = new Scanner(System.in);
        Data Merceria = new Data();

        String nombre = "";
        float precio = 0;
        int aumento = 0;
        int cant, cantidad = 0;
        int op = 0;

        

        
        while(op != 9){
            Merceria.menu();
            System.out.println("\n -Ingrese la opcion que desea");
            op = sc.nextInt();
            Merceria.limpiar();

            //agregar articulo
            if(op == 1){
                try {
                    FileWriter fw = new FileWriter("app\\Archivo.txt",true);           
                    System.out.println("Cuantos articulos queres cargar? ");
                    cantidad = cnt.nextInt();
                    Merceria.limpiar();
                    int i = 0;
                    while(i < cantidad){
                        System.out.println("Ingrese el nombre del articulo, el precio y la cantidad: \n");
    
                        System.out.print("Nombre: ");
                        nombre = nm.nextLine();
                        
                        System.out.print("\nPrecio: ");
                        precio = sc.nextFloat();
                        
                        System.out.print("\nStock: ");
                        cant = sc.nextInt();
                        
                        Merceria.agregarProducto(nombre, precio, cant);
                        System.out.print(Merceria);
                        
                        fw.write(nombre + "|" + precio + "|" + cant + "\n");
                        Merceria.limpiar();
                        i++;
                    }
                    fw.close();                  
                } catch (IOException e) { 
                    System.out.println("Error e/S " +e);
                }
                
            }

            //modificar stock
            if(op == 2){
                if(Merceria.esVacia()){
                    System.out.println("-Sin articulos-");
                } else {
                    System.out.println("Articulo: ");
                    nombre = nm.nextLine();                        
                    if(Merceria.pertenece(nombre)){
                        System.out.println("\n Stock ingresado: ");
                        cant = sc.nextInt();
                        Merceria.modificarStock(nombre, cant);
                        Merceria.limpiar();                    
                    } else {
                        System.out.println("Producto inexistente");
                    }
                }
            }

            //Aumentar el precio de un producto
            if(op == 3){
                if(Merceria.esVacia()){
                    System.out.println("-Sin articulos-");
                } else {
                    System.out.println("Articulo: ");
                    nombre = nm.nextLine();
                    if(Merceria.pertenece(nombre)){
                        System.out.println("\n Porcentaje de aumento: ");
                        aumento = sc.nextInt();
                        Merceria.aumentarPrecio(nombre, aumento);
                        Merceria.limpiar();                        
                    } else {
                        System.out.println("Producto inexistente");
                    }
                }
            }

            //Aumentar el precio de todos los productos
            if(op == 4){
                if(Merceria.esVacia()){
                    System.out.println("-Sin articulos-");
                } else {                    
                    System.out.println("\n Porcentaje de aumento: ");
                    cant = sc.nextInt();
                    Merceria.aumentarPrecioTodos(cant);
                    Merceria.limpiar();
                }
            }

            //Modificar el precio de un producto
            if(op == 5){
                if(Merceria.esVacia()){
                    System.out.println("-Sin articulos-");
                } else {
                    System.out.println("Articulo: ");
                    nombre = nm.nextLine();
                    if(Merceria.pertenece(nombre)){
                        System.out.println("\n Precio nuevo22: ");
                        precio = sc.nextFloat();
                        Merceria.modificarPrecio(nombre, precio);
                        Merceria.limpiar();                        
                    } else {
                        System.out.println("Producto inexistente");
                    }
                }
            }

            //hacer una venta
            if(op == 6){
                if(Merceria.esVacia()){
                    System.out.println("-Sin articulos-");
                } else {   
                    String salida = "";
                    char x = '0';
                    while(x != 'S'){
                        System.out.println("Articulo: ");
                        nombre = nm.nextLine();
                        if(Merceria.pertenece(nombre)){                        
                            System.out.println("Cantidad vendidas: ");
                            cant = sc.nextInt();
                            Merceria.ventas(nombre, cant);
                            System.out.println("Precione N para seguir, Precione S para salir");
                            x = cnt.next().charAt(0);
                            salida += "Articulo: " + nombre + "Cantidad: " + cant + "Total: $" + Merceria.vendido(nombre) + "\n";
                        } else {
                            System.out.println("Producto inexistente");
                            System.out.println("Precione N para seguir, Precione S para salir");
                            x = cnt.next().charAt(0);
                        }
                    }  
                    System.out.println(salida);                
                    
            
                    //Merceria.limpiar();
                }
            }

            //Mostrar los articulos
            if(op == 7){
                if(Merceria.esVacia()){
                    System.out.println("-Sin articulos-");
                } else {
                    System.out.println(Merceria);
                }
            }

            //Consultar sobre un articulo
            if(op == 8){
                System.out.println("Articulo: ");
                nombre = nm.nextLine();
                if(Merceria.pertenece(nombre)){                        
                    Merceria.Consultar(nombre);
                } else {
                    System.out.println("Producto inexistente");
                }
            }


            if(op == 9){
                Merceria.limpiar();
                break;
            }
        }

       
      
   }
}
