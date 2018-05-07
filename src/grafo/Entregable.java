package grafo;

public class Entregable {

	public static void main(String[] args) {
		GrafoDirigido g = new GrafoDirigido(4);
		g.addArista(0, 1);
		g.addArista(0, 2);
		g.addArista(1, 2);
		g.addArista(2, 0);
		g.addArista(2, 3);
		g.addArista(3, 3);		
		
		boolean n = g.dfsCiclo();
		if(n) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}

}
