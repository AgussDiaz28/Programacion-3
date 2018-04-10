package lista;

public class ListaSimple {
	protected Nodo first;
	protected int size;
	
	public ListaSimple() {
		this.first = null;
		this.size = 0;	
	}
	
	public void insert(Nodo n) {
		n.setNext(this.first);
		this.first = n;
		this.size = this.size +1;
	}
	
	public void insertOrdenado(Integer info) {
		Nodo Copia = this.first;
		Nodo NuevoNodo = new Nodo(info,null);
		
		if (Copia != null) {
			
			while ( ( Copia.getInfo() < NuevoNodo.getInfo() ) && Copia.hasNext()) {
				Copia = Copia.getNext();
			}
			
			if (Copia.hasNext()) {
				NuevoNodo.setNext(Copia.getNext());
				Copia.setNext(NuevoNodo);	
			}else {
				Copia.setNext(NuevoNodo);
			}
		}else {
			this.first = NuevoNodo;
		}
		
		this.size = this.size +1;
	}
	
	public Nodo extract(){
		Nodo aux = this.first;
		first.setNext(aux.getNext());
		this.size = this.size - 1;
		return aux;
	}
	
	public void print(){ //Imprime hasta la posicion indicada
		Nodo Aux = this.first;
		for (int i=0;i< this.size; i++) {
			System.out.println(Aux.getInfo());
			Aux = Aux.getNext();
		}
	}
	
	public boolean isEmpty() {
		if (this.size < 1)
		{
			return true;
		}
		return false; 
	}
	
	public int size () {
		return this.size; 
	}
	
	public Nodo getNodoPos(int n)
	{
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

	public Nodo getFirst() {
		return getNodoPos(0);
	}

	public Nodo getNext() {
		return this.first.getNext();
	}
	
	public boolean hasNext() {
		if (this.first.getNext() == null){
			return false;
		}
		return true;
	}
	
	public Nodo getNext(Nodo N) {
		return N.getNext();
	}

	public boolean contains(Integer info) {
		for (int i=0; i<this.size;i++) {
			if (this.getNodoPos(i).getInfo() == info) {
				return true;
			}
		}
		return false;
	}
	
	
}
