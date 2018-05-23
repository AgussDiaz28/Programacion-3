package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GrafoPonderado {
    
    private Integer n; //Cantidad de nodos
    private Integer lastValue; //valor para asignarle en la matriz a la palabra del genero
    private Integer[][] matriz; // Creacion de la matriz
	private HashMap<String, Integer> myMap;  // Guardo el indice en la matriz con el nombre
	private ArrayList<String> Indice; //Guardo el orden en que se guardan las categorias
    
    public GrafoPonderado(Integer n) {
        this.n = n;
        this.lastValue = 0;
        this.matriz = new Integer[this.n][this.n];
        this.Indice = new ArrayList<String>();
        for(Integer i=0; i< n; i++){
            for(Integer j=0; j< n; j++){
                matriz[i][j] = 0;
            }            
        }
        this.myMap = new HashMap<String, Integer>();
    }
    
    public void assingValueToCat(String key,Integer value) {
    		this.myMap.put(key, value);
    }
    
    public void agregar(String c1, String c2, Integer peso){
    		Integer i = this.myMap.get(c1);
    		Integer j = this.myMap.get(c2);
    		if (i == null ) {
    			i = this.getNewValue(c1);
    		}
    		if (j == null ) {
    			j = this.getNewValue(c2);
    		}
        matriz[i][j] = peso;
    }
    
    private Integer getNewValue(String key) {
    		this.Indice.add(key);
    		Integer value = lastValue;
    		this.assingValueToCat(key,value);
    		this.lastValue = lastValue + 1;
		return value;
	}

	public void remover(Integer i, Integer j){
        if(matriz[i][j]>0)
            matriz[i][j] = -1; // Valor absurdo
    }
    
    public boolean existArista(Integer i, Integer j) {
    		return matriz[i][j] > 0;
    }
    
    public LinkedList<String> getAdyacentes(String cat){ //Hijos directos
	    	LinkedList<String> Lista = new LinkedList<String>();
	    Integer	i = this.myMap.get(cat);
	    	for (int j = 0; j < this.n ;j++) {
	    		if	( this.matriz[i][j] != 0 ) {
	    			Lista.add(this.Indice.get(j));
	    		}
	    	}
	    	int size = Lista.size();
	    	for	(int k = 0; k < size; k++)
	    		System.out.println(Lista.get(k));
	    	return Lista; 
    }
    
    public void imprimir(){
        for(Integer i=0; i< n; i++){
            for(Integer j=0; j< n; j++){
                System.out.print( matriz[i][j] + " " ); 
                System.out.print( " | " );        

            }
            System.out.println();
        }  
    }
}