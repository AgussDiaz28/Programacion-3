package arbol;

import java.util.ArrayList;
import java.util.List;


public class Arbol {
	
	NodoArbol first;
	
	public Arbol(){
		this.first = null;	
	}
	
	public Arbol(Integer i, NodoArbol nodoDerecho, NodoArbol nodoIzquierdo ){
		this.first.setinfo(i);
		this.first.setDer(nodoDerecho);
		this.first.setIzq(nodoIzquierdo);
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
		
	}
	
	public void printPreOrder() {
		
	}
	
	public void printInOrder() {
		
	}
	
	public ArrayList getLongestBranch() {
		return null;
		
	}
	
	public ArrayList getFrontera() { //hojas
		return null;
		
	}
	
	public Object getMaxElem() {
		return null;
		
	}
	
	public ArrayList getElemAtLevel(int i) {
		return null;
		
	}
}
