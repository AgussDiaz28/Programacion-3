package lista;

public class Nodo {

	private Integer info;
	private Nodo next;
	
	public Nodo(){
		this.info = null;
		this.next = null;
	}
	
	public Nodo( Integer i, Nodo n){
		this.info = i;
		this.next = n;
	}
	
	public void setinfo(Integer i ){
		this.info = i;
	}
	
	public Nodo getNext(){
		return this.next;
	}

	public void setNext(Nodo n) {
		this.next = n;
	}

	public Integer getInfo() {
		return this.info;
	}

	public boolean hasNext() {
		if (next == null){
			return false;
		}
		return true;
	}
}
