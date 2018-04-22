package lista;

public class ListaSimple {
	protected Nodo first;
	protected int size;
	
	//* Constructor *//
	public ListaSimple() {
		this.first = null;
		this.size = 0;	
	}
	
	//* Funcion que incerta siempre el nuevo nodo de la lista al principio de la misma*//
	public void insert(Integer i) {
		Nodo n = new Nodo(i,null);
		n.setNext(this.first);
		this.first = n;
		this.size = this.size +1;
	}
	
	//* Funcion que recorre la lista e inserta el valor en la posicion correcta *//
	public void insertOrdenado(Integer info) {
		Nodo Copia = this.first;
		Nodo NuevoNodo = new Nodo(info,null);
		
		if (Copia != null) {
			
			while (  (Copia.hasNext()) && ( Copia.getNext().getInfo() > info) ) Copia = Copia.getNext();
			
			if (Copia.hasNext()) 
			{
				NuevoNodo.setNext(Copia.getNext());
				Copia.setNext(NuevoNodo);	
			}
			
			if (Copia != null) Copia.setNext(NuevoNodo);
			
		}else {
			this.first = NuevoNodo;
		}
		this.size = this.size +1;
	}
	
	//* Funcion que quita nodo de la lista y lo devuelve *//
	public Nodo extract(){
		Nodo aux = this.first;
		first.setNext(aux.getNext());
		this.size = this.size - 1;
		return aux;
	}
	
	//* Print de la lista  *//
	public void print(){ 
		Nodo Aux = this.first;
		for (int i=0;i< this.size; i++) {
			System.out.println(Aux.getInfo());
			Aux = Aux.getNext();
		}
	}
	
	//* Devuelve si la lista es Vacia o No  *//
	public boolean isEmpty() {
		if (this.size < 1) return true;
		return false; 
	}
	
	//* Devuelve la cantidad de nodos de la lista  *//
	public int size () {
		return this.size; 
	}
	
	//* Recorre la lista hasta encontrar el nodo de la posicion pedida y lo devuelve. De no encontrarlo devuelve Null  *//
	private Nodo getNodoPos(int n){
		int i = 0;
		Nodo aux = this.first;
		while (i<n)
		{
			if (aux.getNext() != null)
			{
				aux = aux.getNext();
				i++;	
			}else{
				return null;
			}
			
		}
		return aux;
	}
	
	//* Devuelve el primer nodo de la lista *//
	public Integer getFirst() {
		return getNodoPos(0).getInfo();
	}
	
	//* Devuelve el siguiente valor de la lista *//
	public Integer getNext() {
		return this.first.getNext().getInfo();
	}
	
	//* Devuelve un boolean dependiendo si el siguiente valor de lista es vacio o no *//
	public boolean hasNext() {
		if (this.first.getNext() == null) return false;
		return true;
	}
	
	//* Devuelve true si el valor dado existe en la lista, de lo contrario devuelve false *//
	public boolean contains(Integer info) {
		for (int i=0; i<this.size;i++) {
			if (this.getNodoPos(i).getInfo() == info) {
				return true;
			}
		}
		return false;
	}
	
	//* Funcion de que devuelve el dato en la posicion pedida*//
	public Integer getValue(int i) {
		return getNodoPos(i).getInfo();
	}
	
	
	
}
