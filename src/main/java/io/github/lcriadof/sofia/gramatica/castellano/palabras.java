package io.github.lcriadof.sofia.gramatica.castellano;


import java.io.*;


// Importa las clases de log4j.
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import io.github.lcriadof.cadenas.StringTokenV2;


/**
* Esta clase trata palabras en general, 
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 1.0 
* @version agosto 2009 
*/ 


public class palabras {


// a t r i b u t o s

 /** Define una variable de tipo Logger.
  El par�metro que se envia es el nombre de la clase que lo contiene. */
     Logger logger = Logger.getLogger(this.getClass());

  String ficheroIn="";
  String tipoPalabraParaAnalizar="";
  int longitudPalabra=0;
  int maximo=200;
  int maximoReal=0;
  String [] terminoPalabra = new String[maximo]; 
  String [] tipoPalabra = new String[maximo]; 

   // Constructor 1
   public palabras() {
   	 
     this("./conf/articulo.txt","./conf/log4j.properties","art�culos");
   	
   }
   
   
   // Constructor 2
   //         permite particularizar los tipos de palabras a adverbios, preposiciones, etc....
   public palabras(String ficheroInput, String logs, String tipoPalabra) {
   	
   	 this.ficheroIn=ficheroInput;
   	 this.tipoPalabraParaAnalizar=tipoPalabra;
   	 
   	 PropertyConfigurator.configure( logs );
   	 logger.info("-------------------------------------------------------------------------");
   	 logger.info("Tipo palabra a estudiar: "+this.tipoPalabraParaAnalizar);
   	 logger.info("El valor m�ximo de los arrays es [maximo]: "+maximo);

	   // cargamos lista de palabras
	   this.leerpalabras();
	
   }
   
   

/**
* M�todos Is
*/  



// comprueba si la palabra es de this.tipoPalabraParaAnalizar

public boolean isPalabra(String comprobarPalabra) {

	comprobarPalabra=comprobarPalabra.trim().toLowerCase();
  int i=0;
  boolean resul=false;

 		  logger.debug("  Comprobar si el t�rmino ["+comprobarPalabra+"]  es un "+this.tipoPalabraParaAnalizar);
    
  while (i<maximoReal+1){
     logger.debug("   Comparando el t�rmino ["+comprobarPalabra+"] con el "+this.tipoPalabraParaAnalizar+" "+this.terminoPalabra[i]);
	  if ( comprobarPalabra.equals( this.terminoPalabra[i]) ){
		  resul=true;
		  logger.trace("  El t�rmino [ "+comprobarPalabra+"]  es un "+this.tipoPalabraParaAnalizar+" ["+this.tipoPalabra[i] );
		  i=maximoReal+1; // salimos de while
	   }	
	   i++;
  }       		
  return resul;
 
} 




/**
* M�todos GET
*/  



// posible forma singular
public String getTipoPalabra() {
	return this.tipoPalabraParaAnalizar;
}


//Devuelve la lista de this.tipoPalabraParaAnalizar
public void getListaPalabras() {
  int i=0;
while (i<maximoReal+1){
	System.out.println(  this.terminoPalabra[i]+" ("+this.tipoPalabra[i]+")");
	i++;
}       		


} 



// metodos interno

//-----------------------------------


  private void leerpalabras() { // M�TODO A PARTICULARIZAR EN HERENCIA

   String campo="",valor="",registro="";
   int i=0;
   StringTokenV2 cad = null; 
   
   try{
   
  	
	  // fichero de entrada lectura 
		FileInputStream qaOnline = new FileInputStream(this.ficheroIn);
		BufferedInputStream qaDato=new BufferedInputStream(qaOnline);
		DataInputStream qaLinea=new DataInputStream(qaDato);


    logger.trace("Cargando lista de palabras desde fichero. ");
   
   while ( (registro=qaLinea.readLine().trim()) != null){
  
  
          campo="";valor="";
          
           if ( registro.trim().length()>0 ){
           	cad = new StringTokenV2(registro,":");
              campo=cad.getToken(1);
              valor=cad.getToken(2); }
          
    /// mapeos
    
    
         if (  !cad.isIncluidaSubcadena("#") ){
               	
      	    this.terminoPalabra[i]=valor.trim().toLowerCase();
      	    this.tipoPalabra[i]=campo;
      	    
      	    logger.debug("   add "+this.terminoPalabra[i]+" de "+this.tipoPalabra[i]);
      	    
          	i++;
          }	
          	
     }	// fin de while
          
      
    
   
   } catch (Exception e) {
       logger.warn("Final de fichero: " + this.ficheroIn+ " valor: "+e.getMessage());
       
       
		   
   } // fin de try      
   
   
   maximoReal=i-1;
   int quedan=0;
   quedan=maximo-maximoReal;
  
   logger.info("  Actualmente se esta usando para la lista de palabras hasta el elemento "+maximoReal+" incluido, luego quedan "+quedan+" elementos" );

  
  } // fin de leerpalabras()



// fin de m�todos internos






} // fin de clase
