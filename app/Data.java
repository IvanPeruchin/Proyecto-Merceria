package app;

import java.util.HashMap;


public class Data{

    HashMap<String, Producto> producto = new HashMap<String, Producto>();
      
        private Nodo<String> head;
        private int cant;
    
        
        public Data(){
            head = null;
            cant = 0;
        }
    
        public boolean esVacia(){
            return (cant == 0);
        }
        
        /*
         * Metodo que carga un articulo con su precio y cantidad en stock
         */
        public void agregarProducto(String name, float precio, int cantidad){
            Nodo<String> nodo = new Nodo<String>(name); 
            Producto articulo = new Producto(cantidad, precio);
            
            if(!(producto.containsKey(name))){
                if(esVacia()){
                    articulo.SetPrecio(precio);
                    articulo.Setcant(cantidad);
                    producto.put(name, articulo);
                    head = nodo;
                    cant++;
                } else {
                    Nodo<String> aux = head;
                    while(aux.getNext() != null){
                        aux = aux.getNext();
                    }          
                    articulo.SetPrecio(precio);
                    articulo.Setcant(cantidad);
                    producto.put(name, articulo);

                    aux.setNext(nodo); 
                    cant++;                   
                }
            } else {
                System.out.println("Producto ya cargado. \n");
            }   
        }

        /*
         * Metodo que aumenta el precio a un producto, ingresando un porsentaje de aumento
         */
        public void aumentarPrecio(String name, int aumento){
            (producto.get(name)).UpdatePrecio(aumento);
        }

        /*
         * Metodo que aumenta el precio a un producto, ingresando un porsentaje de aumento
         */
        public void aumentarPrecioTodos(int aumento){
            Nodo<String> aux = head;
            int i=0;
            while(i < elementos()){
                (producto.get(aux.getInfo())).UpdatePrecio(aumento);
                aux = aux.getNext();
                i++;
            }
        }

        /*
         * Metodo para decrementar el stock por una venta
        */
        public void ventas(String art, int cant){
            if((producto.get(art)).Getcant() != 0){
                (producto.get(art)).Stock(cant);
            } else {
                System.out.println("Sin stock");
            }
        }

        /*
         * Metodo para incrementar el stock
        */
        public void modificarStock(String art, int cant){
            (producto.get(art)).UpdateStock(cant);
        }

        /*
         * Metodo para modificar el precio, no es lo mismo que aumento
        */
        public void modificarPrecio(String art, float precio){
            if(producto.containsKey(art)){
                (producto.get(art)).ChangePrecio(precio);
            } else {
                System.out.println("Producto inexistente");
            }
        }

        public void menu(){

            System.out.println("\t\tMENU");
            System.out.println("1) Ingresar articulos.\n2) Modificar stock. \n3) Aumentar precio de un producto. \n4) Aumentar el precio de todos los productos");
            System.out.println("5) Modificar el precio de un producto.\n6) Hacer una venta.\n7) Mostrar lista de articulos. \n8) Salir.");
        }


        //No anda
        public void eliminarProducto(String name){  
            Nodo<String> elim = new Nodo<String>();
        
            if(esVacia()){
                System.out.println("Sin articulos");
            } else{ 
                elim = head;
                if(!(head.getInfo().equals(name))){
                    System.out.println("entre al if");
                    while((name.equals(elim.getInfo())) && (elim != null)){
                        elim.setNext(elim.getNext());
                        System.out.println("estoy en el while");
                    }
                    System.out.println("sali del while");
                    Nodo<String> aux = elim.getNext();
        
                    elim.setNext(aux.getNext());
                    cant--;
                    producto.remove(name);
                } else {
                    System.out.println("entre al else");
                    //Nodo<String> aux = head;
                    head = elim.getNext();
                }   
            }
        }
    
      /* public void eliminarProducto(String name){  
            Nodo<String> elim = new Nodo<String>();
     
            if(esVacia()){
                System.out.println("Sin articulos");
            } else 
                if(producto.containsKey(name)){
                    if(elementos() > 1){
                        elim = head;
                        while(name.equals(elim.getInfo()) && elim != null){
                            elim.setNext(elim.getNext());
                        }
                        System.out.println("hola");
                        Nodo<String> aux = elim.getNext();

                        elim.setNext(aux.getNext());
                        cant--;
                        producto.remove(name);
                    } else {
                        Nodo<String> aux = head;
                        head = aux.getNext();
                    }
                } else {
                   System.out.println("El producto -" + name + " no existe. \n");
                }      
        } */

        public void limpiar(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
     
        public int elementos(){
            return cant;
        }
    
        public void vaciar(){
            head.setNext(head);
            cant = 0;
            producto = null; 
        }
        
        @Override
        public String toString(){
            if(esVacia()){
                return "[ ]";
            } else {
                Nodo<String> aux = head;
                String lib = "";
                int i=0;
                while(i < elementos()){
                    lib += "Producto: " + aux.getInfo() + ", " + producto.get(aux.getInfo());
                    aux = aux.getNext();
                    i++;
                
                    lib += "\n";                    
                }
    
                lib += "\n" + "Total productos: " + elementos();     
    
                return lib;
            }
            
        }   
}