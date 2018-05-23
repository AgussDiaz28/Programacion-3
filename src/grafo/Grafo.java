package grafo;

import java.util.LinkedList;

public abstract interface Grafo {
	public abstract void addArista(int v1, int v2, int p);
	public abstract LinkedList<Integer> getVertices();
	public abstract int numVertices();
	public abstract int numAristas();
	public abstract boolean existArista(int v1, int v2);
	public abstract LinkedList<Integer> getAdyacentes(int v);
	public abstract LinkedList<Integer> dfs();
	public abstract LinkedList<Integer> bfs(int s);
}