package backtracking;

public class TableroMagico {
	
	private Integer valorSolucion; // Valor que deberan tomar las filas y columnas 
	private Integer possibleValues; //Valores que podran tomar las filas y colunas
	private Integer MatrizSize; //Tamanio de la matriz
	private Integer[][] matriz; // Creacion de la matriz
	private boolean num_usados[];

	//Creacion del this.matriz
	public TableroMagico(Integer n, Integer k, Integer s) {
		this.matriz = new Integer[n][n];
		this.num_usados = new boolean[k];
		this.MatrizSize = n ; // Una matriz de 3*3 tiene las posiciones 0, 1 y 2
		this.valorSolucion = s; 
		this.possibleValues = k;
	}

	//Creacion del this.matriz por defecto de 3*3
	public TableroMagico() { 
		this(4,30,40); //Llamado al constructor
	}
	
	private boolean sumarFila(int fil) {
  		int sumaTotal = 0;
		for(int col = 0; col<(this.MatrizSize); col++) {
			sumaTotal += this.matriz[fil][col];
		}
		return (sumaTotal == this.valorSolucion);
	}
	
	private boolean sumarColumna(int col) {
		int sumaTotal = 0;
		for(int fil = 0; fil<(this.MatrizSize); fil++) {
			sumaTotal += this.matriz[fil][col];
		}
		return (sumaTotal == this.valorSolucion);
	}
	
	private boolean esSolucionParcial(int fil, int col) {
		return (sumarFila(fil) && sumarColumna(col));
	}
	
	private boolean esSolucionCompleta() {		
		for(int i = 0; i < (this.MatrizSize); i++) {
			if(!esSolucionParcial(i, i)) {
				return false;
			}
		}		
		return true;
	}
	
	public boolean createTablero() {
		return this.createTablero(0);
	}
  
	private boolean createTablero(int iteracion) {
	  if (iteracion == (this.MatrizSize)*(this.MatrizSize)) { 
		  return esSolucionCompleta(); 
	  }
	  for (int num = 1; num <= this.possibleValues; num++) {
		  if (!num_usados[num-1]) {	      
			  num_usados[num-1] = true;
			  int fil = iteracion/(this.MatrizSize);
			  int col = iteracion%(this.MatrizSize);  
			  this.matriz[fil][col] = num;
			  if (solucionValida(iteracion) && createTablero(iteracion+1)) {
				  return true;
			  }
			  this.matriz[fil][col] = 0;
			  num_usados[num-1] = false;
		  }
	  }
	  
	  return false;
	}
	
	private boolean solucionValida(int iteracion) {
		//si el iteracion es la ultima columna, entonces tengo fila completa
		if(iteracion%(this.MatrizSize) == (this.MatrizSize)-1) {
			return sumarFila(iteracion/(this.MatrizSize));
		}
		
		//si el iteracion es la ultima fila, entonces tengo columna completa
	    if(iteracion >= (this.MatrizSize)*(this.MatrizSize)-(this.MatrizSize)) { 
	    	return sumarColumna(iteracion%(this.MatrizSize));
	    }
		return true;
	}

	public void imprimir () {
		for (int fil = 0; fil < (this.MatrizSize); fil++) {
			for (int col = 0; col < (this.MatrizSize); col++) {
				System.out.print(this.matriz[fil][col]);
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}  
}
