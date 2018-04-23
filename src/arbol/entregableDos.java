package arbol;

public final class entregableDos {

	public static void main(String[] args) {
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
		
		Arbol Arbolito = new Arbol(n0);
		
		Arbolito.insert(n1);
		Arbolito.insert(n2);
		Arbolito.insert(n3);
		Arbolito.insert(n4);
		Arbolito.insert(n5);
		Arbolito.insert(n6);
		Arbolito.insert(n7);
		Arbolito.insert(n8);
		Arbolito.insert(n9);
		
		
		boolean result = Arbolito.hasElem(10);
		
		System.out.println(result);
		
		Arbolito.printPosOrder();

	}
}

