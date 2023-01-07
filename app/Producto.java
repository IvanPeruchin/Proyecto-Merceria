package app;

/**
 *Lo que hace esta clase es cargar los dias para los cuales estaran disponibles los turnos 
*/
public class Producto{

    private float precio;
    private int cant; 
    private float vendido;

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
    
    public float GetVendido(){
        return vendido;
    }

    public void SetVendido(float ventas){
        vendido = vendido + ventas;
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
        if((this.cant - cant)<0){
            System.out.println("Stock insuficiente");
        } else {
            this.cant = this.cant - cant;        
        }
    }

    public float Ventas(int cant){
        vendido = vendido + cant * precio;
        return vendido;
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