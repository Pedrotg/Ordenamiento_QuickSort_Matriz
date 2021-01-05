package QuickSortMatriz;

public class Main {

	public static void main(String[] args) {
		int arreglo[][] = {{4,5},
							{1,6},
							{3,2}};
		
		int contador = 0, posicion = 0;
		
		System.out.println(" ");
		System.out.println("Matriz original");
		
		//obtener la cantidad de números para el arreglo auxiliar
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo[i].length; j++) {
				System.out.print(" "+arreglo[i][j]);
				
				if(j == arreglo[i].length-1)
					System.out.println(" ");
				
				contador += 1;
			}
		}
		
		int arregloAuxiliar[] = new int[contador];
		
		//llenar el arreglo auxiliar con los datos de la matriz
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo[i].length; j++) {
				arregloAuxiliar[posicion] = arreglo[i][j];
				posicion +=1;
			}
		}
		
		int izq = 0, der = arregloAuxiliar.length-1;
		System.out.println(" ");
		System.out.println("Arreglo auxiliar");
		for (int i = 0; i < arregloAuxiliar.length; i++) {
			System.out.print(" "+arregloAuxiliar[i]);
			
		}
		System.out.println(" ");
		
		//Mando los dos arreglos a la función de ordenamiento
		quicksort(arreglo, arregloAuxiliar, izq, der);
		
		System.out.println(" ");
		//Muestro UNICAMENTE la matriz ya ordenada
		System.out.println("Matriz ordenada: ");
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo[i].length; j++) {
				System.out.print(" "+arreglo[i][j]);
				
				if(j == arreglo[i].length-1)
					System.out.println(" ");
			}
		}
	}

	private static void quicksort(int[][] arreglo, int[] arregloAuxiliar, int izq, int der) {

		int pivote = arregloAuxiliar[izq], aux, i = izq, d = der;
		
		int[]valoresIyJ = new int[4];
		
		while(i<d) {
			while(arregloAuxiliar[i] <= pivote && i<d)
				i++;
			while(arregloAuxiliar[d] > pivote)
				d--;
					
			if(i < d) {
				valoresIyJ = conseguirPosicionesMatriz(arreglo, arregloAuxiliar, i, d);
				aux = arregloAuxiliar[i];

				// cambio en arreglo
				arregloAuxiliar[i] = arregloAuxiliar[d];  
				//cambio en matriz
				arreglo[valoresIyJ[0]][valoresIyJ[1]] = arreglo[valoresIyJ[2]][valoresIyJ[3]]; 
				
				//cambio en arreglo
				arregloAuxiliar[d] = aux;
				
				//cambio en matriz
				arreglo[valoresIyJ[2]][valoresIyJ[3]] = aux;
			}
		}
		
		valoresIyJ = conseguirPosicionesMatriz(arreglo, arregloAuxiliar, izq, d);
		
		//cambio en arreglo
		arregloAuxiliar[izq] = arregloAuxiliar[d];
		
		//cambio en matriz
		arreglo[valoresIyJ[0]][valoresIyJ[1]] = arreglo[valoresIyJ[2]][valoresIyJ[3]];
		
		arregloAuxiliar[d] = pivote;
		
		//cambio en matriz
		arreglo[valoresIyJ[2]][valoresIyJ[3]] = pivote;
						
			
		if(izq < d -1)
			quicksort(arreglo, arregloAuxiliar, izq, d-1);
			
		if(d + 1 < der)
			quicksort(arreglo, arregloAuxiliar, d + 1, der);
	
	}

	private static int[] conseguirPosicionesMatriz(int[][] arreglo, int arregloAuxiliar[], int posI,int posD) {

		int[]valoresIyJ = new int[4];
		
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo[i].length; j++) {
				
				if(arreglo[i][j] == arregloAuxiliar[posI]) {
					valoresIyJ[0] = i;
					valoresIyJ[1] = j;
				}
				
				if(arreglo[i][j] == arregloAuxiliar[posD]) {
					valoresIyJ[2] = i;
					valoresIyJ[3] = j;
				}
			}
		}
		
		return valoresIyJ;
	}
}

