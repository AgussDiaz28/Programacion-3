package grafo;

public class Entregable {

	public static void main(String[] args) {
		GrafoPonderado grafo = new GrafoPonderado(5);
		
		grafo.agregar("Terror", "Romantica", 14);
		grafo.agregar("Terror", "Aventura", 24);
		grafo.agregar("Terror", "Accion", 22);
		grafo.agregar("Terror", "Cs. Ficcion", 3);
		grafo.agregar("Terror", "Aventura", 7);
        
		grafo.agregar("Romantica", "Accion", 44);
		
		grafo.imprimir();
		System.out.println("-----------");
        
        grafo.getAdyacentes("Terror");
        System.out.println("-----------");
        grafo.getAdyacentes("Romantica");
	}

}
