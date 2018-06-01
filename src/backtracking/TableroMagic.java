package backtracking;

public class TableroMagic {
	
	private Integer solucion; // Valor que deberan tomar las filas y columnas 
	private Integer valores; //Valores que podran tomar las filas y colunas
	private Integer tamanio; //Tamanio de la matriz
	private Integer[][] matriz; // Creacion de la matriz
	private boolean num_usados[];

	//Creacion del this.matriz
	public TableroMagic(Integer n, Integer k, Integer s) {
		this.matriz = new Integer[n][n];
		this.num_usados = new boolean[k];
		this.tamanio = n ; // Una matriz de 3*3 tiene las posiciones 0, 1 y 2
		this.solucion = s; 
		this.valores = k;
	}

	//Creacion del this.matriz por defecto de 3*3
	public TableroMagic() { 
		this(3,20,15); //Llamado al constructor
	}

}
