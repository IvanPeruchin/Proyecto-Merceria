package app;

/**
 *Lo que hace esta clase es cargar los dias para los cuales estaran disponibles los turnos 
*/
public class Producto{

    private float precio;
    private float cant; 
    private float vendido;
    private String tipoVenta;


    //Constructor para un producto
    public Producto(float cant2, float precio, String venta){
        this.cant = cant2;
        this.precio = precio;
        this.tipoVenta = venta;
    }

    public Producto(){
        cant = 0;
        precio = 0;
    }

    //getter para la cantidad de elemento
    public float Getcant(){
        return cant;
    }
    
    //setter para la cantidad de elemento
    public float GetPrecio(){
        return precio;
    }
    
    //getter para la cantidad de ventas de un elemento
    public float GetVendido(){
        return vendido;
    }

    //setter para la cantidad de ventas de un elemento
    public void SetVendido(float ventas){
        this.vendido = this.vendido + ventas;
    }

    //setter para la cantidad de elemento
    public void Setcant( float cant2){
        this.cant = cant2;
    }

    //getter para el precio de  un elemento
    public void SetPrecio(float precio){
        this.precio = precio;
    }
    

    public void UpdatePrecio(float cant2){
        precio = precio + ((precio * cant2)/100);
    }

    public String GetTipoVenta(){
        return tipoVenta;
    }
    public void SetTipoVenta(String tipoVenta){
        this.tipoVenta = tipoVenta;
    }


    public void Stock(float cant2){
        if((this.cant - cant2)<0){
            System.out.println("Stock insuficiente");
            System.out.println("Stock actual " + this.cant);
        } else {
            this.cant = this.cant - cant2;        
        }
    }

    public float Ventas(float cant2){
        return (cant2 * this.precio);
    }

    public void UpdateStock(float cant2){
        this.cant = this.cant + cant2;
    }

    public void ChangePrecio(float precio){
        this.precio = precio;
    }


    @Override
	public String toString(){
		String res = "";
        res += "Precio: $" + precio;
        res += ", Cantidad: " + cant;
        res += ", Venta por " + tipoVenta;
        return res;
	}
}