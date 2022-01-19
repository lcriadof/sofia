package io.github.lcriadof.sofia.gramatica.castellano;

import java.io.*;


// Importa las clases de log4j.
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator; 
import terica.util.StringTokenV2;




/**
* Esta clase se ha calcular la forma singular dado un plural, 
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 1.0 
* @version agosto 2009 
*/ 


public class numero {


// a t r i b u t o s

 /** Define una variable de tipo Logger.
  El par�metro que se envia es el nombre de la clase que lo contiene. */
     Logger logger = Logger.getLogger(this.getClass());

  String ficheroIn="";
  String plural="",singular=""; 
  int longitudPalabra=0;
  int maximo=50;
  int maximoReal=0;
  String [] excepSingular = new String[maximo]; 
  String [] excepPlural = new String[maximo]; 

   // Constructor 1
   public numero() {
   	 
     this("./gramatica/castellano/numero.txt","./conf/log4j.properties");
   	
   }
   
   
   // Constructor 2
   public numero(String ficheroInput, String logs) {
   	
   	 this.ficheroIn=ficheroInput;
   	 
   	 PropertyConfigurator.configure( logs );
   	  	 
   	 logger.info("La lista de excepciones de singular-plural limitado a el valor de la variable interna [maximo]: "+maximo);

	   // leemos excepciones singular-plural
	   this.leerExcepciones();
	
   }
   
   
   //  m�todos SET
   //**************************************************************
   // m�todo para obtener el SINGULAR dado un PLURAL
   public void setPlural(String palabra) {
 	
 	
	  plural="";singular="";
	  longitudPalabra=0;
	  
	  int bandera=0; // que aun no se ha cumplido
	  String palabraConAcentos=palabra.trim().toLowerCase();
	  
	  palabra=quitarAcentos(palabraConAcentos); // quitamos espacios, sustituimos acentos y ponemos en min�sculas
	  longitudPalabra=palabra.length();
	  
	 
	  
   
	   
	  /*
	  String cadena = "Hola Jorge, �qu� tal estas?";
    String nombre = cadena.substring(5,10);

    Esto genera nombre = "Jorge"
    El m�todo substring(int i,int f) , i indica d�nde comienza (incluido) y f el final (no incluido).
     Adem�s el primer caracter de un String tiene �ndice 0. 
	  */
	  
	  
	  // si el singular termina en -� -� -�       men�s, verm�s, champ�s, pirul�s, etc. 
	  //                     Se trata generalmente de palabras extranjeras asimiladas m�s recientemente en nuestra lengua.
	  //                     http://www.elcastellano.org/consultas.php?Tag=plural
	  // el plural termina en -s
	  if ( bandera==0 ){
	  if ( palabraConAcentos.substring(longitudPalabra-1,longitudPalabra).equals("s")  
	       & 	       
	      (
	       palabraConAcentos.substring(longitudPalabra-2,longitudPalabra-1).equals("�") |
	       palabraConAcentos.substring(longitudPalabra-2,longitudPalabra-1).equals("�") |
	       palabraConAcentos.substring(longitudPalabra-2,longitudPalabra-1).equals("�") 
	       )){
	  
	     plural=palabraConAcentos;
	     singular=palabraConAcentos.substring(0,longitudPalabra-1);
	     bandera=1;
	  }
	} // fin de bandera = 0
	  
	  
		  
	  // si el singular termina en consonante -z (vez)
	  // el plural termina en -ces (veces)
	  if ( bandera==0 ){

	  if ( palabra.substring(longitudPalabra-3,longitudPalabra).equals("ces")  ){
	  
	     plural=palabra;
	     singular=palabra.substring(0,longitudPalabra-3)+"z";
	     bandera=1;
	  }
	  	    

	  } // fin de bandera = 0



	  
  // si el singular termina vocales ��/�/� (sof�, man�, omb�)
	  // el plural termina en   -aes/�es/�es (sofaes, man�es, omb�es)
	  if ( bandera==0 ){

	  if ( palabra.substring(longitudPalabra-3,longitudPalabra).equals("aes") ){
	     plural=palabra;
	     singular=palabra.substring(0,longitudPalabra-3)+"�";
	      bandera=1;
	  }
	  if ( palabra.substring(longitudPalabra-3,longitudPalabra).equals(quitarAcentos("�es")) ){
	     plural=palabra;
	     singular=palabra.substring(0,longitudPalabra-3)+"�";
	      bandera=1;
	  }
	  if ( palabra.substring(longitudPalabra-3,longitudPalabra).equals(quitarAcentos("�es")) ){
	     plural=palabra;
	     singular=palabra.substring(0,longitudPalabra-3)+"�";
	      bandera=1;
	  }
	  	    

	  } // fin de bandera = 0
	
		 
	  
	  // si el singular termina en consonantes -d, -j, -l, -m, -n, -r, -s, -y
	  // el plural termina en -es
	  if ( bandera==0 ){

	    if ( palabra.substring(longitudPalabra-2,longitudPalabra).equals("es")  
	       & 
	       (
	       palabra.substring(longitudPalabra-3,longitudPalabra-2).equals("d") |
	       palabra.substring(longitudPalabra-3,longitudPalabra-2).equals("j") |
	       palabra.substring(longitudPalabra-3,longitudPalabra-2).equals("l") |
	       palabra.substring(longitudPalabra-3,longitudPalabra-2).equals("m") |
	       palabra.substring(longitudPalabra-3,longitudPalabra-2).equals("n") |
	       palabra.substring(longitudPalabra-3,longitudPalabra-2).equals("r") |
	       palabra.substring(longitudPalabra-3,longitudPalabra-2).equals("s") |
	       palabra.substring(longitudPalabra-3,longitudPalabra-2).equals("y") 
	       )
	       ){
	  
	     plural=palabra;
	     singular=palabra.substring(0,longitudPalabra-2);
	     bandera=1;
	     
	  }
	  } // fin de bandera = 0
	  
	  
	  // si el singular termina en -a -e -o
	  // el plural termina en -s
	  if ( bandera==0 ){
	  if ( palabra.substring(longitudPalabra-1,longitudPalabra).equals("s")  
	       & 
	       (
	       palabra.substring(longitudPalabra-2,longitudPalabra-1).equals("a") |
	       palabra.substring(longitudPalabra-2,longitudPalabra-1).equals("e") |
	       palabra.substring(longitudPalabra-2,longitudPalabra-1).equals("o") 
	       )
	       ){
	  
	     plural=palabra;
	     singular=palabra.substring(0,longitudPalabra-1);
	     bandera=1;
	  }
	} // fin de bandera = 0
	  
	
	  
	
	  
	  // hay excepciones, por ejemplo, los d�as de la semana tienen la misma forma singular que plural
	  
	  
	  logger.debug("Longitud de la palabra ["+palabra+"] = "+longitudPalabra);
    logger.trace("   Singular: "+singular+"   Plural: "+plural);
    
    
   
    

   }


  








/**
* M�todos GET
*/  



// posible forma singular
public String getSingular() {
	
	
	
  int i=0;
  logger.info("  Se esta usando para las excepciones singular-plural hasta el elemento "+maximoReal+" incluido." );

     
  while (i<maximoReal+1){
  	// revisamos si es una excepci�n
  	logger.debug("  revisamos si ["+this.plural+"] tiene excepci�n. El valor de i= "+i );
  	logger.debug("  comparamos ["+this.plural+"] con ["+this.excepPlural[i]+"]" );

	  if ( this.plural.equals( this.excepPlural[i]) ){
		  this.singular=this.excepSingular[i];
		  logger.trace("   correcci�n, se trata de un caso especial, el singular de "+this.excepPlural[i]+" es "+this.excepSingular[i]);
		  i=maximoReal+1; // salimos de while
	   }	
	   i++;
  }       		
	
	
  return this.singular;
 
} 


// posible forma plural
public String getPlural() {
  return this.plural;
 
} 






// metodo interno


  private String quitarAcentos(String cad) {
  
		StringTokenV2 cad2=new StringTokenV2(cad,":");
    
    // sustituir � por a;
    	cad2.getCambiar("�","a");
    	
   // sustituir � por e;
    	cad2.getCambiar("�","e");
  
   // sustituir � por i;
    	cad2.getCambiar("�","i");
    	
   // sustituir � por &#243;
    	cad2.getCambiar("�","o");
    	
   // sustituir � por &#250;
    	cad2.getCambiar("�","u");
 
   return cad2.toString();
  }





  private void leerExcepciones() {

   String campo="",valor="",registro="";
   int i=0,bandera=0;
   StringTokenV2 cad = null; 
   
   try{
   
  	
	  // fichero de entrada lectura 
		FileInputStream qaOnline = new FileInputStream(this.ficheroIn);
		BufferedInputStream qaDato=new BufferedInputStream(qaOnline);
		DataInputStream qaLinea=new DataInputStream(qaDato);


    logger.trace("Cargando lista de excepciones singular-plural desde fichero. ");
   
   while ( (registro=qaLinea.readLine().trim()) != null){
  
  
          campo="";valor="";
          
           if ( registro.trim().length()>0 ){
           	cad = new StringTokenV2(registro,":");
              campo=cad.getToken(1);
              valor=cad.getToken(2); }
          
    /// mapeos
    
    
         if (campo.equals("singular")){
      	    this.excepSingular[i]=valor;
          	bandera=1;
          }	
          
          if (campo.equals("plural") && bandera==1 ){
         	  this.excepPlural[i]=valor;
         	   logger.debug("   singular: "+this.excepSingular[i]+", plural: "+ this.excepPlural[i]);
         		bandera=0;
         		i++;
   		   	}
          	
          	
     }	// fin de while
          
      
    
   
   } catch (Exception e) {
       logger.warn("Final de fichero: " + this.ficheroIn+ " valor: "+e.getMessage());
       
       
		   
   } // fin de try      
   
   
   maximoReal=i-1;
   int quedan=0;
   quedan=maximo-maximoReal;
  
   logger.info("  Actualmente se esta usando para las excepciones singular-plural hasta el elemento "+maximoReal+" incluido, luego quedan "+quedan+" elementos" );

  	
		


  } // fin de leerExcepciones()



// fin de m�todos internos




} // fin de clase
