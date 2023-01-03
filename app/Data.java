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
    
        public void agregarProducto(String name, int precio, int cantidad){
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

        public void aumentarPrecio(String name, int aumento){
            (producto.get(name)).UpdatePrecio(aumento);
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