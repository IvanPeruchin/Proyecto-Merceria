package app;

//import java.io.FileReader;
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
        String venta = "";
        float precio = 0;
        int aumento = 0;
        float cant;
        int cantidad = 0;
        int op = 0;

        

        
        while(op != 9){
            Merceria.menu();
            System.out.println("\n -Ingrese la opcion que desea");
            op = sc.nextInt();
            Merceria.limpiar();

            //agregar articulo
            if(op == 1){
                try {
                    FileWriter fw = new FileWriter("Archivo.txt",true);           
                    System.out.println("Cuantos articulos queres cargar? ");
                    cantidad = cnt.nextInt();
                    Merceria.limpiar();
                    int i = 0;
                    while(i < cantidad){
                        System.out.println("Ingrese el nombre del articulo, el precio y la cantidad: \n");
    
                        System.out.print("Nombre: ");
                        nombre = nm.nextLine();
                        
                        while(Merceria.pertenece(nombre)){
                            System.out.print(nombre + " ya existe, por favor ingrese otro articulo:  ");
                            nombre = nm.nextLine();
                        }

                        System.out.print("\nPrecio: ");
                        precio = sc.nextFloat();
                        
                        System.out.print("\nStock: ");
                        cant = sc.nextInt();

                        System.out.print("\nTipo de venta(metro o unidad): ");
                        venta = nm.nextLine();
                        
                        Merceria.agregarProducto(nombre, precio, cant, venta);
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
                    while(!(Merceria.pertenece(nombre))){
                        System.out.println("Producto inexistente, ingrese uno valido");
                        System.out.println("Articulo: ");
                        nombre = nm.nextLine();
                    } 
                    System.out.println("\n Stock ingresado: ");
                    cant = sc.nextInt();
                    Merceria.modificarStock(nombre, cant);
                    Merceria.limpiar();                    
                    
                }
            }

            //Aumentar el precio de un producto
            if(op == 3){
                if(Merceria.esVacia()){
                    System.out.println("-Sin articulos-");
                } else {
                    System.out.println("Articulo: ");
                    nombre = nm.nextLine();
                    while(!(Merceria.pertenece(nombre))){
                        System.out.println("Producto inexistente, ingrese uno valido");
                        System.out.println("Articulo: ");
                        nombre = nm.nextLine();
                    } 
                    System.out.println("\n Porcentaje de aumento: ");
                    aumento = sc.nextInt();
                    Merceria.aumentarPrecio(nombre, aumento);
                    Merceria.limpiar();                        
                   
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
                    while(!(Merceria.pertenece(nombre))){
                        System.out.println("Producto inexistente, ingrese uno valido");
                        System.out.println("Articulo: ");
                        nombre = nm.nextLine();
                    } 
                    System.out.println("\n Precio nuevo: ");
                    precio = sc.nextFloat();
                    Merceria.modificarPrecio(nombre, precio);
                    Merceria.limpiar();                        
                   
                }
            }

            //hacer una venta
            if(op == 6){
                float ventaTotal = 0;
                if(Merceria.esVacia()){
                    System.out.println("-Sin articulos-");
                } else {   
                    String salida = "";
                    char x = '0';
                    while(x != 'S'){
                        System.out.println("Articulo: ");
                        nombre = nm.nextLine();
                        while(!(Merceria.pertenece(nombre))){
                            System.out.println("Producto inexistente, ingrese uno valido");
                            System.out.println("Articulo: ");
                            nombre = nm.nextLine();
                        }                        
                        System.out.println("Cantidad vendidas: ");
                        cant = sc.nextFloat();
                        Merceria.ventas(nombre, cant);
                        if(Merceria.ConsultarStock(nombre) > cant){
                            System.out.println(Merceria.ConsultarStock(nombre));
                            salida += "Articulo: " + nombre + " /Cantidad por " + Merceria.Tipo(nombre) + ": " + cant + " /Precio por " + Merceria.Tipo(nombre) + ": $" + Merceria.PrecioUnitario(nombre) +  " /Total: $" + Merceria.vendido(nombre, cant) + "\n";
                            ventaTotal = ventaTotal + (cant*Merceria.PrecioUnitario(nombre));
                            System.out.println(salida); 
                        }
                        System.out.println("\nPrecione N para seguir, Precione S para salir");
                        x = cnt.next().charAt(0);
                    }
                    Merceria.limpiar(); 
                    salida += "\n Precio final de ventas: " + ventaTotal; 
                    System.out.println(salida); 
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
            }

            if(op == 10){
                String newName;
                System.out.println("Articulo que dese modificar: ");
                nombre = nm.nextLine();
                System.out.println("uevo nombre: ");
                newName = nm.nextLine();
                Merceria.cambiarNombre(nombre,newName);
            }        
        }
    }            
}

