package app;

/**
 *Lo que hace esta clase es cargar los dias para los cuales estaran disponibles los turnos 
*/
public class Producto{

    private int precio;
    private int cant; 

    public Producto(int cant, int precio){
        this.cant = cant;
        this.precio = precio;
    }

    public Producto(){
        cant = 0;
        precio = 0;
    }

    public int Getcant(){
        return cant;
    }

    public int GetPrecio(){
        return precio;
    }

    public void Setcant( int cant){
        this.cant = cant;
    }

    public void SetPrecio(int precio){
        this.precio = precio;
    }
}