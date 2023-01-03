package app;

public class Nodo<T> {

    //atrubuto puntero
    private Nodo<T> next;
    //atributo campo info
    private T info;

    //constructores
    public Nodo(){
        this.next = null;
        this.info = null;
    }

    public Nodo(T elem){
        this.info = elem;
		this.next = null;
    }

    public Nodo(T elem, Nodo<T> n){
        this.next = n;
        this.info = elem;
    }

    //metodos
    public Nodo<T> getNext(){
		return this.next;
	}

	public void setNext(Nodo<T> n){
		this.next = n;
	}

	public T getInfo(){
		return this.info;
	}

	public void setInfo(T elem){
		this.info = elem;
	}

	@Override
	public String toString(){
		if (info != null) {
			return info.toString();
		} else {
			return null;
		}
	}
}