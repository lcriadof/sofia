package io.github.lcriadof.cadenas.ordenar;

import java.util.Vector;

public class burbuja {

	
	public burbuja(){
		
	}
	
	
	public String[] ordenar( String[] lista) {
	        String aux; 
	 	   // Inicio del metodo de ordenamiento de la Burbuja
	    	for(int i=1; i<=lista.length; i++) {  
	            for(int j=0; j<lista.length-i; j++) { 
	                if( lista[j].compareTo( lista[j+1] ) > 0 ) { 
	                    aux   = lista[j]; 
	                    lista[j]  = lista[j+1]; 
	                    lista[j+1]= aux; 
	                }    
	            } 
	        }
	        // Fin del metodo de ordenamiento de la Burbuja	 
	    	

		 return lista;
	 } // sin de metdo
	
	
	public Vector<String> ordenar( Vector<String> lista) {
        String aux; 
       
 	   // Inicio del metodo de ordenamiento de la Burbuja
     	for(int i=1; i<=lista.size(); i++) {  
            for(int j=0; j<lista.size()-i; j++) { 
                if( lista.elementAt(j).compareTo( lista.elementAt(j+1) ) > 0 ) { 
                    aux   = lista.elementAt(j); 
                    lista.set(j, lista.elementAt(j+1));
                    lista.set(j+1, aux);
                    
                }    
            } 
        }
        // Fin del metodo de ordenamiento de la Burbuja	 
    	

	 return lista;
 } // sin de metdo
	
	
	
} // fin de clase

