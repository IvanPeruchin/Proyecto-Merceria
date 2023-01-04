package app;

/**
 *Lo que hace esta clase es cargar los dias para los cuales estaran disponibles los turnos 
*/
public class Producto{

    private float precio;
    private int cant; 

    public Producto(int cant, float precio){
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

    public float GetPrecio(){
        return precio;
    }

    public void Setcant( int cant){
        this.cant = cant;
    }

    public void SetPrecio(float precio){
        this.precio = precio;
    }

    public void UpdatePrecio(int aumento){
        precio = precio + ((precio * aumento)/100);
    }

    public void Stock(int cant){
        this.cant = this.cant - cant;
    }

    public void UpdateStock(int cant){
        this.cant = this.cant + cant;
    }

    public void ChangePrecio(float precio){
        this.precio = precio;
    }

    @Override
	public String toString(){
		String res = "";
        res += "Precio: $" + precio;
        res += ", Cantidad: " + cant;
        return res;
	}
}