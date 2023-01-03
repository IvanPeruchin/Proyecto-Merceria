package app;

import java.util.HashMap;


public class Data{

    HashMap<String,Integer> producto = new HashMap<String,Integer>();
      
        private Nodo<String> end;
        private int cant;
    
        
        public Data(){
            end = null;
            cant = 0;
        }
    
        public boolean esVacia(){
            return (cant == 0);
        }
    
        public void agregarProducto(String name, Integer precio){
            Nodo<String> nodo = new Nodo<String>(name);    
            if(!(producto.containsKey(name))){
                if(esVacia()){
                    producto.put(name, precio);
                    nodo.setNext(nodo);
                    cant++;
                } else {
                    nodo.setNext(end.getNext());
                    end.setNext(nodo);
                    cant++;
                    producto.put(name, precio);
                }
                end = nodo;
            } else {
                System.out.println("Producto ya cargado. \n");
            }   
        }
    
        public void eliminarProducto(String name){        
            if(esVacia()){
                System.out.println("Cola vacia");
            } else 
                if(producto.containsKey(name)) {
                   Nodo<String> elim = end.getNext();
                   end.setNext(elim.getNext());
                   cant--;
                   producto.remove(name);
                } else {
                   System.out.println("El producto -" + name + "no existe. \n");
                }      
        }
     
        public int elementos(){
            return cant;
        }
    
        public void vaciar(){
            end.setNext(end);
            cant = 0;
            producto = null; 
        }
        
        @Override
        public String toString(){
            if(esVacia()){
                return "[ ]";
            } else {
                Nodo<String> aux = end.getNext();
                String lib = "";
                int i=0;
                while(i < elementos()){
                    lib += "Producto: " + aux.getInfo();
                    lib += ", Precio: $" + producto.get(aux.getInfo());
                    aux = aux.getNext();
                    i++;
                
                    lib += "\n";                    
                }
    
                lib += "\n" + "Total productos: " + elementos();     
    
                return lib;
            }
            
        }   
}