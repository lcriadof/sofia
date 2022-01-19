import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoPresente;
import io.github.lcriadof.ficheros.secuencial;
public class pruebaVerbo {

	   public static void main(String[] args) {

		     // regulares de referencia; cantar, temer, partir, irregular adquir
            String verbo="abastar"; //"cavar"; 
                // indicativoPresente v=new indicativoPresente( raiz_verbo, "er", 0);
            indicativoPresente v=new indicativoPresente( verbo, 0);
            secuencial fichEntrada=new secuencial();
     	    String lecturalinea="";
     	    System.out.println("Verbo: "+v.getInfinitivo()  ); 
            System.out.println("Conjugacion "+v.getTipoConjugaciona()); 
            System.out.println("modo: "+v.getModo()); 
            System.out.println("forma: "+v.getNombreForma() ); 
            System.out.println("tiempo: "+v.getTiempo()); 
            System.out.println("voz: "+v.getVoz()); 
            System.out.println();
              
             // v.conjugarForma();
              
             
              System.out.println(  v.getFormaConjugadaEnriquecidaString() +"\n" );
              
              String [] vconjugada = new  String[6]; 
             // vconjugada=v.getFormaConjugada();
              vconjugada=v.getFormaConjugadaEnriquecida();
              
              
              for (int i = 0; i < 6; ++i) {
            	  System.out.println(vconjugada[i]);
    		  }
              System.out.println("*******"); 
              System.out.println();
              System.out.println();             
              
             
              
              
              // buscar termino
              //---------------------------------------
              String termino="bendices"; //"quepo"; //"bendecimos";   //"camine";
              System.out.println("buscando "+termino);
              indicativoPresente v2=new indicativoPresente( );
              if ( v2.buscarForma( termino) ) {
            	  System.out.println("modo: "+v2.getModo()); 
                  System.out.println("forma: "+v2.getNombreForma() ); 
                  System.out.println("tiempo: "+v2.getTiempo()); 
                  System.out.println("voz: "+v2.getVoz()); 
                  System.out.println("conjugacion: "+v2.getTipoConjugaciona()); 
                  System.out.println("irregularidad: "+v2.getIrregularidad()  ); 
                  
                  if (v2.isSingular()) {
                	  System.out.println(v2.getPersona()+ " persona del singular"); 
                  } else {
                	  System.out.println(v2.getPersona()+ " persona del plural"); 
                  }
                  
              }
              System.out.println("*******");  
              System.out.println();
              System.out.println();
              
              
              
             // lee un fichero secuencial
  		    fichEntrada.setNombreFichero("e_verbosRegulares.txt");
  		    if (fichEntrada.abrirFicheroModoLectura()) {
  		    	while ( true  ) {
  		    		lecturalinea=fichEntrada.leerSiguienteLinea();
  		    		if (lecturalinea.equals("final") ) {
  		    			break;
  		    		}else {
  		    			System.out.println(lecturalinea);
  		    		}
  		    	} // fin de while
  		    } // fin de if
  		    System.out.println("*******");
  		    System.out.println();
            System.out.println();   
           
		  
		   }  // fin de main

} // fin de clase

