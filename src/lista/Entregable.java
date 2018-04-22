package lista;

public class Entregable {

	public static void main(String[] args) {
		ListaSimple listaUno = new ListaSimple();
		ListaSimple listaDos = new ListaSimple();
		
		Integer n0 = 34;
		Integer n1 = 9;
		Integer n2 = 10;
		Integer n3 = 2;
		Integer n4 = 43;
		Integer n5 = 51;
		Integer n6 = 1;
		Integer n7 = 102;
		Integer n8 = 8;
		Integer n9 = 91;
		
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
		
		Integer nd0 = 102;
		Integer nd1 = 9;
		Integer nd2 = 1;
		Integer nd3 = 10;
		Integer nd4 = 2;
		Integer nd5 = 43;
		Integer nd6 = 91;
		Integer nd7 = 61;
		Integer nd8 = 34;
		Integer nd9 = 3;
		
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
		for (int i=0;i< size; i++) {
			Integer Aux = listaUno.getValue(i);
			if (Aux == null) return null; //Si no se encontro el valor en la posicion devuelvo null
			if (listaDos.contains(Aux) ) {
				resultado.insertOrdenado(Aux);
			}
		}
		return resultado;		
	}
	
	
}
