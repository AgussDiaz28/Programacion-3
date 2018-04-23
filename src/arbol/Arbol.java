package arbol;

public class Arbol {
	
	NodoArbol first;
	
	public Arbol(){
		this.first = null;
	}
	
	public Arbol(Integer i){
		NodoArbol N = new NodoArbol(i,null,null); 
		this.first = N;
	}
	
	public NodoArbol getRoot() {
		return this.first;
		
	}
	
	public boolean hasElem(Integer i) {
		return this.hasElem(i,this.getRoot());
	}
	
	private boolean hasElem(Integer i, NodoArbol Aux) {
		if (Aux == null) {
			return false;
		}
		if (Aux.getInfo() < i) {
			return hasElem(i,Aux.getDer());
		}else if (Aux.getInfo() > i) {
			return hasElem(i,Aux.getIzq());
		}else{
			return true;
		}
	}
	
	public boolean isEmpty() {
		if  (this.first == null) {
			return true;
		}
		return false;
	}
	
	public void insert(Integer i) {
		if (this.getRoot() != null) {
			this.insert(i,this.getRoot());
		}
	}
	
	private void insert(Integer i, NodoArbol Aux) {
		if (Aux.getInfo() < i) {
			if (Aux.getDer() == null) {
				NodoArbol N = new NodoArbol(i,null,null);
				Aux.setDer(N);
			}else {
				insert(i,Aux.getDer());
			}	
		}else if (Aux.getInfo() > i) {
			if (Aux.getIzq() == null) {
				NodoArbol N = new NodoArbol(i,null,null);
				Aux.setIzq(N);
			}else {
				insert(i,Aux.getIzq());
			}
		}
	}
	
	public void delete(int i) {
		if(!this.isEmpty()) {
			delete(i,this.first);
		}
	}
	
	private void delete (Integer i, NodoArbol Aux ) {
		if (Aux != null) {
			
			if (Aux.getInfo() < i) {
				delete(i,Aux.getDer());
			}else if (Aux.getInfo() > i) {
				delete(i,Aux.getIzq());	
			}else if(Aux.getInfo() == i) {
				if	((Aux.getDer() == null) && (Aux.getIzq() == null)) { //Si es hoja
					Aux = null;
				}else if(Aux.getDer() == null) { //Solo tiene hijos a izq
					
				}else if(Aux.getIzq() == null)  { //Solo tiene hijos a derecha
					
				}else {	//si tiene los dos hijos
					NodoArbol N = buscarMaxIzq(Aux);	
					delete(i,N);
				}
			}
			
		}else {
			System.out.println("No se encontro el nodo a eliminar");
		}
		
	}
	
	private NodoArbol buscarMaxIzq(NodoArbol Aux) {
		if (Aux.getDer() == null) {
			return Aux;
		}else {
			return buscarMaxIzq(Aux.getDer());
		}
	}
	
	public int getHeight() {
		return 0;	
	}
	
	public void printPosOrder() {
		printPosOrder(this.getRoot());
	}
	
	private void printPosOrder(NodoArbol A) {
		if (A != null) {
			printPosOrder(A.getDer());
			printPosOrder(A.getIzq());
			System.out.println(A.getInfo());
		}
	}
	
	public void printPreOrder() {
		printPreOrder(this.getRoot());	
	}
	
	private void printPreOrder(NodoArbol A) {
		if (A != null) {
			System.out.println(A.getInfo());
			printPosOrder(A.getDer());
			printPosOrder(A.getIzq());
		}
	}

	public void printInOrder() {
		printInOrder(this.getRoot());	
	}
	
	private void printInOrder(NodoArbol A) {
		if (A != null) {
			printPosOrder(A.getDer());
			System.out.println(A.getInfo());
			printPosOrder(A.getIzq());
		}
		
	}
	
}
