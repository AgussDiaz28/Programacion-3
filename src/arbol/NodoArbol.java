package arbol;

public class NodoArbol {
	
	private Integer info;
	private NodoArbol izq;
	private NodoArbol der;
	
	public NodoArbol(){
		this.izq = null;
		this.der = null;
	}
	
	public NodoArbol( Integer i, NodoArbol n1, NodoArbol n2 ){
		this.info = i;
		this.izq = n1;
		this.der = n2;
	}
	
	public void setinfo(Integer i ){
		this.info = i;
	}
	
	public void setIzq(NodoArbol i ){
		this.izq = i;
	}
	
	public void setDer(NodoArbol i ){
		this.der = i;
	}
	
	public Integer getInfo() {
		return this.info;
	}

	
	public NodoArbol getIzq(){
		return this.izq;
	}
	
	public NodoArbol getDer(){
		return this.der;
	}
	
	public boolean hasIzq() {
		if (this.izq == null){
			return false;
		}
		return true;
	}
	
	public boolean hasDer() {
		if (this.der == null){
			return false;
		}
		return true;
	}
	

	
	
}
