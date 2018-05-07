package grafo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class GrafoDirigido implements Grafo {
	
	protected int numV, numA;
	protected LinkedList<LinkedList<Integer>> vertices;

	public GrafoDirigido(int numVertices){
		LinkedList<Integer> aux = new LinkedList<Integer>();;
		numV = numVertices;
		numA = 0;
		this.vertices = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < numV; i++){
			this.vertices.add(aux);
			aux = new LinkedList<Integer>();
		}
	}
	
	public int numVertices() {
		return numV;
	}
	
	public int numAristas() {
		return numA;
	}
	
	@Override
	public void addArista(int v1, int v2) {
		vertices.get(v1).add(v2);
		numA++;
	}
	@Override
	public LinkedList<Integer> getVertices() {
		LinkedList<Integer> salida = new LinkedList<>();
		for(int i = 0; i<numV; i++) {
			salida.add(i);
		}
		return salida;
	}
	@Override
	public boolean existArista(int v1, int v2) {
		return (vertices.get(v1).get(v2) != null);
	}
	
	@Override
	public LinkedList<Integer> getAdyacentes(int v) {
		if(vertices.get(v) != null) {
			return vertices.get(v);		
		}
		return null;
	}
	
	public LinkedList<Integer> dfs() {
		String estado[] = new String[numV];
		Integer padre[] = new Integer[numV];
		for(int i=0; i<numV; i++) {
			estado[i] = "BLANCO";
			padre[i] = null; 
		}
		
		for(int i=0; i<numV; i++) {
			dfs_visitar(i, estado, padre);
		}
		
		return new LinkedList<Integer>(Arrays.asList(padre));
	}
	
	private void dfs_visitar(int v, String estado[], Integer padre[]) {
		estado[v] = "YELLOW";
 
        Iterator<Integer> i = vertices.get(v).listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (estado[n] == "BLANCO") {
	            	padre[n] = v;
	            	dfs_visitar(n, estado, padre);
            }
        }
        estado[v] = "NEGRO";
	}
	

	public LinkedList<Integer> bfs(int s) {
		boolean estado[] = new boolean[numV];
		Integer distancia[] = new Integer[numV];
		Integer padre[] = new Integer[numV];
		
		for(int i=0; i<numV; i++) {
			distancia[i] = null;
			padre[i] = null; 
		}
		
		estado[s] = true;
		distancia[s] = 0;
		padre[s] = null;
		
		LinkedList<Integer> cola = new LinkedList<>();
		cola.add(s);
		
		while(cola.size() != 0) {
			Integer u = cola.poll();
			
			Iterator<Integer> i = vertices.get(u).listIterator();
	        while (i.hasNext())
	        {
	            int v = i.next();
	            if(!estado[v]) {
	            	estado[v] = true;
	            	distancia[v] = distancia[u] + 1;
	            	padre[v] = u;
	            	cola.add(v);
	            }
	           
	        }
		}
		return new LinkedList<Integer>(Arrays.asList(padre));
	}
	
	public boolean dfsCiclo() {
		boolean visitado[] = new boolean[numV];
		boolean hayCiclo = false;
		
		for(int i=0; i<numV; i++) {
			int j = 0;
			hayCiclo = false;
			while(j < vertices.get(i).size() && !hayCiclo) {
				Integer adyacente = vertices.get(i).get(j);				
				if(!visitado[adyacente]) {
					hayCiclo = hayCiclo(i, visitado);
				}
				if(hayCiclo) {
					return true;
				}
				j++;
			}
		}
		
		return hayCiclo;		
	}
	
	private boolean hayCiclo(int v, boolean visitado[]) {
		visitado[v] = true;
		boolean hayCiclo = false;
		
        Iterator<Integer> i = vertices.get(v).listIterator();
        while (i.hasNext() && !hayCiclo)
        {
            int n = i.next();
            if (!visitado[n]) {
            	hayCiclo = hayCiclo(n, visitado);
            }else {
            	hayCiclo = true;
            }
        }
        
        return hayCiclo;
	}
}
