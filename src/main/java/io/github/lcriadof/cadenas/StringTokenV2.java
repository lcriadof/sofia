package io.github.lcriadof.cadenas;

import java.io.*;
import java.util.*; // Tratamiento de Token // para conocer el usuario, SO, ect
import java.lang.Integer;

//------------------------------------------------------------------
/**
*
* <table border="0" width="600" cellpadding="5" cellspacing="0">
* <tr>
*   <td bgcolor="#CCCCCC"><font color="#006600">
*  La clase StringToken es una clase de tratamiento de Cadenas.
*    </font></td>
* </tr>
* </table>
*   @author Luis Criado
* */
//------------------------------------------------------------------
public class StringTokenV2 {

 // atributos de la clase
 private String s;
 private int nTokenTotales;
 private int nTokenActivo;
 private StringTokenizer t;
 private String NombreDelFuente[]=null;



 // Constructor 1
 public StringTokenV2(String sCadena,String DelimitadorToken){
	 this.s=sCadena;
	 this.t=new StringTokenizer(s,DelimitadorToken);

	 this.nTokenTotales=t.countTokens(); // numero maximo de Tokens
	 this.nTokenActivo=1;

    // ----- generamos la lista de Tokens
    int ciclo=0;
    this.NombreDelFuente= new String[this.nTokenTotales+1];
    this.NombreDelFuente[0]="<Token 0 vacio, se empieza a contar el 1>"; //  (inicializaci�n)
    for (ciclo=1;ciclo<this.nTokenTotales+1;ciclo++){
       this.NombreDelFuente[ciclo]=this.dameToken(ciclo); //  (inicializaci�n)
    }
    // ----- fin de generar la lista de Tokens
  this.nTokenActivo=0; // Importante: lo dejamos activo a 0, para que funcione el nextToken
}// fin del constructor 1




 // Constructor 2
 public StringTokenV2(String sCadena){
	 this.s=sCadena;
	 this.t=new StringTokenizer(s," ");

	 this.nTokenTotales=t.countTokens(); // numero maximo de Tokens
	 this.nTokenActivo=1;

     // ----- generamos la lista de Tokens
           int ciclo=0;
           this.NombreDelFuente= new String[this.nTokenTotales+1];
           this.NombreDelFuente[0]="<Token 0 vacio, se empieza a contar el 1>"; //  (inicializaci�n)
           for (ciclo=1;ciclo<this.nTokenTotales+1;ciclo++){
              this.NombreDelFuente[ciclo]=this.dameToken(ciclo); //  (inicializaci�n)
           }
           // ----- fin de generar la lista de Tokens
    this.nTokenActivo=0; // Importante: lo dejamos activo a 0, para que funcione el nextToken
 }// fin del constructor 2





//-----------------------------------------------------------------------------
/**
* <pre>
*    Descripcion: METODO para comprobar si un String esta contenida en el StringToken actual.
* </pre>
* <pre>
*    Devuelve un dato boolean, true si son iguales.
* </pre>
*/
public boolean equals(StringTokenV2 Cad) {

return s.equals(Cad.s);
} // fin del metodo


//Metodos "is"
//
//-----------------------------------------------------------------------------




/**
* <pre>
*    Descripcion: METODO para comprobar si un String esta contenida en el StringToken actual.
* </pre>
* <pre>
*
*    Usa la notacion moderna de punto.
*
*    Devuelve un dato boolean, true si esta contenida.
* </pre>
*
*/
public boolean isIncluidaSubcadena(String CadClave) {


 int longlinea;
 int longclave;
 int i,j;
 int comp;
 String CadEnLaQueBusca=s;


 try{
    CadEnLaQueBusca=CadEnLaQueBusca.toUpperCase();	// convertimos el string en mayusculas
    CadClave=CadClave.toUpperCase();   // convertimos el string en mayusculas
    longlinea=CadEnLaQueBusca.length(); // longitud de la cadena en la que se busca
    longclave=CadClave.length(); // longitud de la clave
    comp=0;
    i=0;
    j=longclave;
    for (i=0;i<=longlinea-longclave;i++,j=longclave+i)
    {	 // comparamos la clave con todas las posibles subcadenas
	 if ( comp==CadClave.compareTo(CadEnLaQueBusca.substring(i,j)) )
	 {   return(true);  } // la clave se ha encontrado

	}
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(false); // no se ha encontrado
	}
 return(false); // no se ha encontrado
 } // fin del metodo
//-----------------------------------------------------------------------








//-----------------------------------------------------------------------------
/**
*  <pre>
*  Descripcion: METODO para comprobar si un String esta contenida en el StringToken actual.
* </pre>
* <pre>
*  Nota: metodo gemelo al anterior
*
*  Devuelve un dato boolean, true si esta contenida.
*  </pre>
*/
public boolean isIncluidaSubcadena(StringTokenV2 CadClave) {

return isIncluidaSubcadena(CadClave.s);
} // fin del metodo
//-----------------------------------------------------------------------





//Metodos "get"
//
//------------------------------------------------------------------------------------------





/**
* <pre>
*    Descripcion: METODO que devuelve el n�mero m�ximo de token.
* </pre>
* <pre>
*    Devuelve un int.
* </pre>
*/
public int getNumeroTokenTotales() {

 return nTokenTotales;

} // fin del metodo
//-----------------------------------------------------------------------



//-----------------------------------------------------------------------------
/**
* <pre>
*    Descripcion: METODO para localizar la posicion de una subcadena dentro de otra en la que esta incluida.
*  </pre>
* <pre>
*    Usa la notacion moderna de punto.
*
*    Devuelve un dato int; Si esta contenida devuelve la posicion donde esta,
*	    devuelve -1 si no esta contenida.
*
* </pre>
*/
public int getPosicionSubcadena(String CadClave) {

 int longlinea;
 int longclave;
 int i,j;
 int comp;
 String CadEnLaQueBusca=s;


 try{
    CadEnLaQueBusca=CadEnLaQueBusca.toUpperCase();	// convertimos el string en mayusculas
    CadClave=CadClave.toUpperCase();   // convertimos el string en mayusculas
    longlinea=CadEnLaQueBusca.length(); // longitud de la cadena en la que se busca
    longclave=CadClave.length(); // longitud de la clave
    comp=0;
    i=0;
    j=longclave;
    for (i=0;i<=longlinea-longclave;i++,j=longclave+i)
    {	 // comparamos la clave con todas las posibles subcadenas
	 if ( comp==CadClave.compareTo(CadEnLaQueBusca.substring(i,j)) )
	 {   return(i);  } // la clave se ha encontrado

	}
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(-1); // no se ha encontrado
	}
 return(-1); // no se ha encontrado
 } // fin del metodo
//-----------------------------------------------------------------------




//------------------------------------------------------------------------------------------
/**
* <pre>
*    Descripcion: METODO para borrar una cadena incluida en otra.
* </pre>
* <pre>
*    Devuelve un String.
* </pre>
*/
static public String getQuitar(String cad,String sCadQuitar) {


 StringTokenV2 s2=new StringTokenV2(cad);
 StringTokenV2 s3=new StringTokenV2(sCadQuitar);


 return s2.getQuitar(s3).s;// devuelvo un String

} // fin del metodo
//-----------------------------------------------------------------------





/**
* <pre>
*    Descripcion: METODO para reemplazar una subcadena por otra subcadena dentro de una cadena (StringToken).
* </pre>
* <pre>
*     Devuelve un String.
* </pre>
*/
public String getCambiar(String sCadQuitar,String sCadRemplazar) {
 int nx=0;

 while (isIncluidaSubcadena(sCadQuitar)){
   nx=getPosicionSubcadena(sCadQuitar);
   s=getHasta(nx)+sCadRemplazar+getDesde(nx+sCadQuitar.length()+1);
 } // fin de while

 return s;// devuelvo un String

} // fin del metodo
//-----------------------------------------------------------------------






//------------------------------------------------------------------------------------------
/**
* <pre>
*    Descripcion: METODO para borrar una cadena incluida en otra.
* </pre>
* <pre>
*
*    notacion moderna, con el punto.
*
*    Devuelve un StringToken.
* </pre>
*/
public StringTokenV2 getQuitar(String sCadQuitar) {

 int nPosicion;
 int nLongitudQuitar=sCadQuitar.length();
 int nLongitudCadena=s.length();

 nPosicion=getPosicionSubcadena(sCadQuitar);

 s=getHasta(nPosicion)+getDesde(nPosicion+nLongitudQuitar+1);
 return this;// devuelvo el objeto actual

} // fin del metodo
//-----------------------------------------------------------------------





//------------------------------------------------------------------------------------------
/**
* <pre>
*    Descripcion: METODO para borrar una cadena incluida en otra.
* </pre>
* <pre>
*    Nota: Es un metodo gemelo a public StringToken getQuitar(String sCadQuitar).
*
*    notacion moderna, con el punto.
*
*    Devuelve un StringToken.
* </pre>
*/
public StringTokenV2 getQuitar(StringTokenV2 Cad) {

   return getQuitar(Cad.s);

} // fin del metodo
//-----------------------------------------------------------------------





//------------------------------------------------------------------------------------------
/**
* <pre>
*    Descripcion: METODO que devuelve una subcadena a partir de la posicion nX hasta el final.
* </pre>
* <pre>
*
*    Notacion moderna de punto.
*
*    Devuelve un String.
* </pre>
*/
public String getDesde(int nX) {

 String sDatos;

 try{
    int nLongCad=s.length();
    sDatos=s.substring(nX-1,nLongCad); //subcadena
    return(sDatos);	 // devuelvo la subcadena
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(""); // problemas
	}

 } // fin del metodo
//----------------------------------------------------------------------------






/**
* <pre>
*    Descripcion: METODO que devuelve una subcadena desde el principio hasta la posicion nX.
* </pre>
*
* <pre>
*    Notacion moderna de punto
*
*    Devuelve un String.
* </pre>
*/
//------------------------------------------------------------------------------------------
public String getHasta(int nX) {

 String sDatos=s;

 try{
    int nLongCad=s.length();
    if (nX<nLongCad)
	 {sDatos=s.substring(0,nX); //subcadena
	 }
    return(sDatos);	 // devuelvo la subcadena
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(""); // problemas
	}

 } // fin del metodo
//----------------------------------------------------------------------------





/**
* <pre>
*    Descripcion: METODO que devuelve una subcadena desde el principio hasta la posicion nX.
* </pre>
*
* <pre>
*    Notacion moderna de punto.
*
*    Devuelve un String.
* </pre>
*/
//------------------------------------------------------------------------------------------
public static String getHasta(int nX,String cad) {

 String sDatos=cad;

 try{
    int nLongCad=sDatos.length();
    if (nX<nLongCad)
	 {sDatos=sDatos.substring(0,nX); //subcadena
	 }
    return(sDatos);	 // devuelvo la subcadena
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(""); // problemas
	}

 } // fin del metodo
//----------------------------------------------------------------------------





/**
* <pre>
*    Descripcion: METODO que devuelve una subcadena hasta la posicion nX desde el principio.
* </pre>
* <pre>		,es decir, los nX primeros caracteres izquierdos.
*
*    Notacion moderna de punto.
*
*    Devuelve un String.
* </pre>
*/
//------------------------------------------------------------------------------------------
public String getIzquierda(int nX) {

    return( getHasta(nX) );	 // devuelvo la subcadena


 } // fin del metodo
//----------------------------------------------------------------------------






/**
* <pre>
*   Descripcion: METODO que cuenta el n�mero de espacios por la izquierda.
* </pre>
*
*  <pre>
*   Ejemplo: Quito los espacios de la izquierda y los reemplazo por "."
*	     numEspacios=cad3.getCuentaEspaciosIzquierda();
*	     relleno="";
*	     relleno=StringToken.getRellena(relleno,".",numEspacios);
*
*
*    Notacion moderna de punto
*
*    Devuelve un int.
* </pre>
*/
//------------------------------------------------------------------------------------------
public int getCuentaEspaciosIzquierda() {

 String sDatos=s;
 int nX=0;

 try{
    int nLongCad=s.length();

    while (nX<nLongCad)
	     {sDatos=s.substring(nX,nX+1); //subcadena
	      nX++;
	  if (sDatos.equals(" ")) {
	     nX++;   }
	  else{
	     break;
	  }

    }// fin de while

 }catch( Exception e ) {	       // Cualquier excepci�n
    return(0); // problemas
	}
 return(nX); // longitud de blancos por la izquierda  (error)
 } // fin del metodo




 /**
 * <pre>
 *	Descripcion: METODO que quita los tabuladores por la izquierda.
 * </pre>
 */
//------------------------------------------------------------------------------------------
 public void getQuitarTabuladoresIzquierda() {

	String sDatos=s;
	int nX=0;

	try{
	   int nLongCad=s.length();

	   while ( this.isIncluidaSubcadena("\t") )  {
	      this.getQuitar("\t"); // quitamos tabulador

	   }// fin de while

	}catch( Exception e ) {        // Cualquier excepci�n
	   System.out.println("\nProblema al quitar tabuladores por la izquierda. Fallo en  getQuitarTabuladoresIzquierda()\n");
	}


  } // fin del metodo








/**
* <pre>
*   Descripcion: METODO que devuelve una subcadena desde la posicion nX1 hasta la posicion nX2.
*</pre>
* <pre>
*
*   Notacion: propia de programacion a objetos. Notacion con punto.
*
*   Devuelve un String.
* </pre>
*/
//------------------------------------------------------------------------------------------
public String getDesdeHasta(int nX1,int nX2) {

 String sDatos;
 String CadEnLaQueRecorto;


 CadEnLaQueRecorto=s;

 try{
    int nLongCad=CadEnLaQueRecorto.length();
    sDatos=CadEnLaQueRecorto;
    if (nX2-1<nLongCad)
	   {sDatos=CadEnLaQueRecorto.substring(nX1,nX2); //subcadena
  	 }
    return(sDatos);	 // devuelvo la subcadena
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(""); // problemas
	}

 } // fin del metodo
//----------------------------------------------------------------------------






/**
* <pre>
*    Descripcion: METODO que devuelve una subcadena de nX caracteres empezando por la derecha.
* </pre>
* <pre>
*   Notacion moderna de punto
*
*   Devuelve un String.
* </pre>
*///------------------------------------------------------------------------------------------
public String getDerecha(int nX) {

 String sDatos="";
 int nLongCad=s.length();

 try{

    if (nX<nLongCad)
	 {sDatos=s.substring(nLongCad-nX,nLongCad); //subcadena
	 }
    return(sDatos);	 // devuelvo la subcadena
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(""); // problemas
	}

 } // fin del metodo
//----------------------------------------------------------------------------







/**
* <pre>
*   Descripcion: METODO que convierte un objeto StringToken en entero (int).
* </pre>
* <pre>
*
*   Notacion moderna de punto.
*
*   Devuelve un int.
* </pre>
*/
//------------------------------------------------------------------------------------------
public int getANumero() {


 Integer IntegerNumeroDeDatos=new Integer(0);
 int nNumeroDeDatos=0;
 try{
    nNumeroDeDatos=IntegerNumeroDeDatos.parseInt(s);// paso la subcadena a tipo Integer y luego a int
    return(nNumeroDeDatos);	 // devuelvo la longitud de los datos
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(0); // problemas
	}

 } // fin del metodo
//----------------------------------------------------------------------------





/**
* <pre>
*    Descripcion: METODO que convierte un objeto String en entero (int)
* </pre>
* <pre>
*
*    Notacion moderna de punto.
*
*
*    Devuelve un int.
* </pre>
*/
//------------------------------------------------------------------------------------------
static public int getANumero(String cad) {



 Integer IntegerNumeroDeDatos=new Integer(0);
 int nNumeroDeDatos=0;
 try{
    nNumeroDeDatos=IntegerNumeroDeDatos.parseInt(cad);// paso la subcadena a tipo Integer y luego a int
    return(nNumeroDeDatos);	 // devuelvo la longitud de los datos
 }catch( Exception e ) {	       // Cualquier excepci�n
    return(0); // problemas
	}

 } // fin del metodo
//----------------------------------------------------------------------------







/**
* <pre>
*    Descripcion: METODO que convierte un (int) en un (String).
* </pre>
* <pre>
*
*    Notacion moderna de punto.
*
*    Devuelve un int.
* </pre>
*/
//------------------------------------------------------------------------------------------
static public String getIntAString(int num) {

 String cad=num+" "; // el operador + es quien fuerza la conversion
 return cad.trim();
 } // fin del metodo
//----------------------------------------------------------------------------






/**
* <pre>
*   Descripcion: METODO que convierte un (String) en un (Vector).
* </pre>
* <pre>
*
*   Notacion moderna de punto.
*
*   Devuelve un Vector.
* </pre>
*/
//---------------------------------------
public Vector getAVector(){

int numMax=nTokenTotales; // numero de tokens
Vector Valores=new Vector();
int i=0; // ciclo for-next

for (i=1;i<numMax+1;i++){
  Valores.addElement(t.nextToken()); // a�ado un elemento al vector
}
return Valores;

}
//--------------------------------------------




/**
* <pre>
*   Descripcion: Metodo que rellena un string con un caracter "String c" por la izquierda
*		 hasta alcanzar una longitud maxima "int max".
* </pre>
* <pre>
*   Devuelve un String.
* </pre>
*/
//------------------------------------------------------------------------------------------
static public String getRellena(String cad,String c,int max) {

int n,n2;
cad=cad.trim(); // quitamos espacios en blanco a izquierda y derecha
n=cad.length(); // longitud del String
n2=c.length();

while (max>n){
cad=c+cad;
n=n+n2;
}// fin de while

return(cad);
} // fin del metodo
//----------------------------------------------------------------------------





/**
* <pre>
*   Descripcion: Metodo que rellena un string con un caracter "String c" por la derecha
*		 hasta alcanzar una longitud maxima "int max".
* </pre>
* <pre>
*
*    Devuelve un String
* </pre>
*/
//------------------------------------------------------------------------------------------
static public String getRellenaDerecha(String cad,String c,int max) {

int n,n2;
cad=cad.trim(); // quitamos espacios en blanco a izquierda y derecha
n=cad.length(); // longitud del String
n2=c.length();

while (max>n){
cad=cad+c;
n=n+n2;
}// fin de while

return(cad);
} // fin del metodo
//----------------------------------------------------------------------------





/**
* <pre>
*  Descripcion: Metodo que devuelve el Token de la posicion deseada.
* </pre>
* <pre>
*  Nota: Se puede devolver un token en cualquier orden (aportaci�n de esta versi�n)
*
*  notacion moderna (de punto)
*
*  Devuelve un String.
* </pre>
*/
//------------------------------------------------------------------------------------------
public String getToken(int nToken) {

String st="null"; // "No hay Token "+nToken+", el Token m�nimo es 1 y el m�ximo es "+this.nTokenTotales;

if (nToken<this.nTokenTotales+1){
   st=this.NombreDelFuente[nToken];
   this.nTokenActivo=nToken;
}

st=st.trim(); // quitamos espacios a derecha e izquierda


return(st);
} // fin del metodo




 /**
  * <pre>
   *  Descripcion: Metodo que devuelve el Sigiente Token de la posicion activa.
  * </pre>
  * <pre>
   *  Nota: Se puede devolver un token en cualquier orden (aportaci�n de esta versi�n)
   *
   *  notacion moderna (de punto)
   *
   *  Devuelve un String.
  * </pre>
 */
//------------------------------------------------------------------------------------------
 public String getNextToken() {
   return(this.getToken(nTokenActivo+1));
 } // fin del metodo



//----------------------------------------------------------------------------

 /**
  * <pre>
   *  Descripcion: Metodo que guarda en una matriz todos los Tokens
  * </pre>
  */
//------------------------------------------------------------------------------------------
 private String dameToken(int nToken) {

  String st="";

  if (nTokenTotales+1>nToken)   {

     if ( nTokenActivo==nToken ){
        st=t.nextToken();}

     if ( nToken>nTokenActivo ){
       while (nToken!=nTokenActivo){
        nTokenActivo++;
        st=t.nextToken();
                 }// fin de while
      } // fin de if

 } // fin del if principal
 st=st.trim(); // quitamos espacios a derecha e izquierda


 return(st);
 } // fin del metodo
//----------------------------------------------------------------------------




/**
* <pre>
*    Descripcion: Metodo que convierte un dato de tipo StringToken a String.
* </pre>
* <pre>
*
*  Metodo sobrecargado.
*
*   Devuelve un String.
* </pre>
*/
//--------------------------------------------------------
public String toString(){

return s;
} // fin del metodo



} // fin de la clase StringToken

