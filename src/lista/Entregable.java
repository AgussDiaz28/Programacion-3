package lista;

public class Entregable {

	public static void main(String[] args) {
		ListaSimple listaUno = new ListaSimple();
		ListaSimple listaDos = new ListaSimple();
		
		Nodo n1 = new Nodo(9,null);
		Nodo n2 = new Nodo(10,null);
		Nodo n3 = new Nodo(32,null);
		Nodo n4 = new Nodo(43,null);
		Nodo n5 = new Nodo(51,null);
		Nodo n6 = new Nodo(63,null);
		Nodo n7 = new Nodo(7,null);
		Nodo n8 = new Nodo(8,null);
		Nodo n9 = new Nodo(91,null);
		Nodo n0 = new Nodo(14,null);
		
		listaUno.insert(n1);
		listaUno.insert(n2);
		listaUno.insert(n3);
		listaUno.insert(n4);
		listaUno.insert(n5);
		listaUno.insert(n6);
		listaUno.insert(n7);
		listaUno.insert(n8);
		listaUno.insert(n9);
		listaUno.insert(n0);

		Nodo nd1 = new Nodo(9,null);
		Nodo nd2 = new Nodo(1,null);
		Nodo nd3 = new Nodo(2,null);
		Nodo nd4 = new Nodo(3,null);
		Nodo nd5 = new Nodo(4,null);
		Nodo nd6 = new Nodo(54,null);
		Nodo nd7 = new Nodo(61,null);
		Nodo nd8 = new Nodo(76,null);
		Nodo nd9 = new Nodo(14,null);
		Nodo nd0 = new Nodo(19,null);
		
		listaDos.insert(nd1);
		listaDos.insert(nd2);
		listaDos.insert(nd3);
		listaDos.insert(nd4);
		listaDos.insert(nd5);
		listaDos.insert(nd6);
		listaDos.insert(nd7);
		listaDos.insert(nd8);
		listaDos.insert(nd9);
		listaDos.insert(nd0);
		
		System.out.println("Lista 1: ");
		listaUno.print();
		System.out.println("\n\nLista 2: ");
		listaDos.print();

		
		System.out.println("\n\nLista de elementos comunes: ");
		ListaSimple resultado = ordernarListas(listaUno, listaDos);
		
		resultado.print();	
	}
	
	//por cada elemento de la lista1, la comparo con todos los elementos de la lista2
	
	private static ListaSimple ordernarListas(ListaSimple listaUno, ListaSimple listaDos) {
		ListaSimple resultado = new ListaSimple();
		int size = listaUno.size;
		Nodo Aux = listaUno.getFirst();
		for (int i=0;i< size; i++) {
			if (listaDos.contains(Aux.getInfo()) ) {
				resultado.insertOrdenado(Aux.getInfo());
			}
			Aux = Aux.getNext();
		}
		return resultado;		
	}
	
	
}
