import io.github.lcriadof.sofia.gramatica.castellano.*;
import io.github.lcriadof.cadenas.StringTokenV2;
// clase de prueba


public class pruebaVariasPalabras{


    public static void main(String[] args) {

        articulos a=new articulos();
        preposiciones p=new preposiciones();
        StringTokenV2 cad = null; 
   
      // ??¡Muy ()
        // ?revolución? 
        
        
    	System.out.println( a.getTipoPalabra());
    	a.getListaPalabras();
    	System.out.println();System.out.println();
    	System.out.println( a.getTipoPalabra());
     System.out.println(  a.isPalabra("las"));
     System.out.println(  a.isPalabra("unas") );
     System.out.println(  a.isPalabra("del") );
     System.out.println(  a.isPalabra("Sí") );
 
     
       System.out.println();
       System.out.println( p.getTipoPalabra());
 	   p.getListaPalabras();
       System.out.println();System.out.println();
     System.out.println( p.getTipoPalabra());
     System.out.println(  p.isPalabra("bajo"));
     System.out.println(  p.isPalabra("unas") );
     System.out.println(  p.isPalabra("cabe") );
     System.out.println(  p.isPalabra("Sí") );
 
     
     cad = new StringTokenV2("??La"," ");
     
     
     
     while ( (cad.isIncluidaSubcadena("?")) ){ // quitar todos los "?" del fichero
    	 cad.getQuitar("?");
	 }
     System.out.println( cad );
     
     
   } 




} // fin clase