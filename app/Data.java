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

        //ARCHIVO
        //Abre el a      
        
      
        /*
         * Metodo que carga un articulo con su precio y cantidad en stock
         */
        public void agregarProducto(String name, float precio, float cant2, String tipoVenta){ 
            Nodo<String> nodo = new Nodo<String>(name); 
            Producto articulo = new Producto(cant2, precio, tipoVenta);
            
            if(!(producto.containsKey(name))){
                if(esVacia()){
                    articulo.SetPrecio(precio);
                    articulo.Setcant(cant2);
                    articulo.SetTipoVenta(tipoVenta);
                    producto.put(name, articulo);
                    head = nodo;
                    cant++;
                } else {
                    Nodo<String> aux = head;
                    while(aux.getNext() != null){
                        aux = aux.getNext();
                    }          
                    articulo.SetPrecio(precio);
                    articulo.Setcant(cant2);
                    articulo.SetTipoVenta(tipoVenta);
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
        public void aumentarPrecio(String name, float cant2){
            if(producto.containsKey(name)){
                (producto.get(name)).UpdatePrecio(cant2);
            } else {
                System.out.println("Producto inexistente");
            }
        }

        /*
         * Metodo que aumenta el precio a un producto, ingresando un porsentaje de aumento
        */
        public void aumentarPrecioTodos(float cant2){
            Nodo<String> aux = head;
            while(aux != null ){              
                aumentarPrecio(  aux.getInfo(), cant2);               
                aux = aux.getNext();
            }
        }

        /*
         * Metodo para decrementar el stock por una venta
        */
        public void ventas(String art, float cant2){
            
            if((producto.get(art)).Getcant() != 0){
                (producto.get(art)).Stock(cant2); 
                (producto.get(art)).SetVendido(cant2); 
            } else {
                System.out.println("Sin stock");
            }
        }


        /*
         * Metodo para mostrar la cantidad de ventas de un articulo
        */
        public Float vendido(String art, float cant2){
            
            if((producto.get(art)).Getcant() > 0){
               return ((producto.get(art)).Ventas(cant2));                
            } else {
                System.out.println("Sin stock");
            }
            return null;
            
        }

        /*
         * Metodo para incrementar el stock
        */
        public void modificarStock(String art, float cant2){
            (producto.get(art)).UpdateStock(cant2);
        }

        /*
         * Metodo para modificar el precio, no es lo mismo que aumento
        */
        public void modificarPrecio(String art, float precio){           
            (producto.get(art)).ChangePrecio(precio);            
        }

        /*
         * Metodo para consultar los datos de un articulo
        */
        public void Consultar(String art){
            System.out.println(producto.get(art));
        }

        //Metodo para consultar stock
        public float ConsultarStock(String art){
            return (producto.get(art)).Getcant();
        }

        /*
         * Metodo para consultar el tipo de venta
        */
        public String Tipo(String art){
            return ((producto.get(art)).GetTipoVenta());
        }

         /*
         * Metodo para consultar el precio por unidad de un articulo
        */
        public Float PrecioUnitario(String art){
            return ((producto.get(art)).GetPrecio());
        }

        //Menu
        public void menu(){

            System.out.println("\t\tMENU");
            System.out.println("1) Ingresar articulos.\n2) Modificar stock. \n3) Aumentar precio de un producto. \n4) Aumentar el precio de todos los productos");
            System.out.println("5) Modificar el precio de un producto.\n6) Hacer una venta.\n7) Mostrar lista de articulos. \n8) Consultar articulo, \n9) Salir.");
        }

        //Metodo para ver si un articulo pertenece a la lista
        public Boolean pertenece(String name){
            return producto.containsKey(name);
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
                    Nodo<String> aux = head;
                    head.setNext(aux.getNext());
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