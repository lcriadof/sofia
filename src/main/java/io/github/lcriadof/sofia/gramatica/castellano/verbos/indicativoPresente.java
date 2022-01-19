package io.github.lcriadof.sofia.gramatica.castellano.verbos;

import io.github.lcriadof.cadenas.StringTokenV2;

/**
* Presente de Indicativo
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 2.0 
* @version 2019
*/ 
public class indicativoPresente extends forma {

	 // esta clase tiene un construcctor que s�lo permite buscar si un termino es una forma verbal conocida, en este caso,
	// no se puede invocar a otras clases, pues no se sabe raiz, conjugaci�n y tipo de irregularidad
	 protected boolean metodoActivo=false;
	
	 
	 // irregularidades
	 protected String[] sufijoFlexivo_irregularidad_7 = new String[1];
	 protected String[] sufijoFlexivo_irregularidad_9 = new String[6];
	 protected String[] sufijoFlexivo_irregularidad_29 = new String[6];
	
	
	// este constructor sirve para conjugar una forma del INDICATIVO
	public indicativoPresente( String raiz, String conjugacion, int codigoIrregularidadCastellano) {
		super(raiz, conjugacion, codigoIrregularidadCastellano);
		 this.metodoActivo=true;
		
		 this.modo="Indicativo";
		 this.nombreForma="Presente";
	     this.tiempo="Presente";
	     this.esCompuesta=false;
	     this.voz="activa";
	     
	     this.inicializar_sufijos();
    	}
	
	
	// este constructor sirve para conjugar una forma del INDICATIVO
		public indicativoPresente( String infinitivo, int codigoIrregularidadCastellano) {
			super(infinitivo, codigoIrregularidadCastellano);
			 this.metodoActivo=true;
			
			 this.modo="Indicativo";
			 this.nombreForma="Presente";
		     this.tiempo="Presente";
		     this.esCompuesta=false;
		     this.voz="activa";
		     
		     this.inicializar_sufijos();
	    	}


	
	
	// este constructor sirve para aproximar una b�squeda, no sirve para conjugar
	public indicativoPresente( ) {
		 this.modo="Indicativo";
		 this.nombreForma="Presente";
	     this.tiempo="Presente";
	     this.esCompuesta=false;
	     this.voz="activa";
		
	     this.inicializar_sufijos();
		}
	
	
	
	
	@Override
	/*
	* Calcula la forma conjugada concreta, pero no lo devuelve. <br>
	* Metodo polimorfo respecto a la clase padre. <br>
    * @see getFormaConjugada()
    * @see getFormaConjugadaEnriquecida()
    * @see getFormaConjugadaEnriquecidaString()
    * @since version 2.0 
    * @version noviembre 2019 
    * @see getFormaConjugada()
    * @see getFormaConjugadaEnriquecida()
    * @see getFormaConjugadaEnriquecidaString()
    */
	public void conjugarForma() {
		StringTokenV2 cadena1 = null; 
		String raizIrregular="";
		String color="red";
		
	  if (metodoActivo) {
			super.conjugarForma(); // conjugaci�n regular 
			super.conjugarFormaTextoEnriquecido(); // conjugaci�n regular enriquecida con colores
				
			
			// si hay irregularidad se a�ade excepci�n a la confugaci�n regular realizada  
			
			
			   // irregularidar 10,  verbo caber (parece que no es modelo para otro)
              //    no se dice cabo, sino quepo
			  if (this.forma[0].equals("cabo")) {
				  this.forma[0]="quepo";
				  this.formaTextoEnriquecido[0]="<font color=\\\""+color+"\\\">"+"quepo"+"</font>"+"<br>";

			  } 
			
			  // irregularidad 7
			  if (this.irregularidadCastellano==7) {
				  this.forma[0]=this.raiz+this.sufijoFlexivo_irregularidad_7[0];
				  this.formaTextoEnriquecido[0]=this.raiz+"<font color=\\\""+color+"\\\">"+this.sufijoFlexivo_irregularidad_7[0]+"</font>"+"<br>";
			  } 
			  
			  // irregularidad 9
			  if (this.irregularidadCastellano==9) {  // ejemplo: bendecir
				  // hay que cambiar la raiz
				  cadena1=new StringTokenV2(this.raiz,":");
				  raizIrregular=cadena1.getToken(1);
				  raizIrregular=cadena1.getIzquierda(raizIrregular.length()-2);
				  // fin de cambiar la raiz
				  
				  this.forma[0]=raizIrregular+this.sufijoFlexivo_irregularidad_9[0];
				  this.formaTextoEnriquecido[0]="<font color=\\\""+color+"\\\">"+raizIrregular+this.sufijoFlexivo_irregularidad_9[0]+"</font>"+"<br>";
				  
				  this.forma[1]=raizIrregular+this.sufijoFlexivo_irregularidad_9[1];
				  this.formaTextoEnriquecido[1]="<font color=\\\""+color+"\\\">"+raizIrregular+this.sufijoFlexivo_irregularidad_9[1]+"</font>"+"<br>";

				  this.forma[2]=raizIrregular+this.sufijoFlexivo_irregularidad_9[2];
				  this.formaTextoEnriquecido[2]="<font color=\\\""+color+"\\\">"+raizIrregular+this.sufijoFlexivo_irregularidad_9[2]+"</font>"+"<br>";

				  this.forma[5]=raizIrregular+this.sufijoFlexivo_irregularidad_9[5];
				  this.formaTextoEnriquecido[5]="<font color=\\\""+color+"\\\">"+raizIrregular+this.sufijoFlexivo_irregularidad_9[5]+"</font>"+"<br>";

			  } 
			  
			  // irregularidad 29
			  if (this.irregularidadCastellano==29) {  // (Huir, incluir, disminuir...)
				  for (int i=0;i<3;i++) { 
				    this.forma[i]=this.raiz+this.sufijoFlexivo_irregularidad_29[i];
				    this.formaTextoEnriquecido[i]=this.raiz+"<font color=\\\""+color+"\\\">"+this.sufijoFlexivo_irregularidad_29[i]+"</font>"+"<br>";
				  }
				  this.forma[5]=this.raiz+this.sufijoFlexivo_irregularidad_29[5];
				  this.formaTextoEnriquecido[5]=this.raiz+"<font color=\\\""+color+"\\\">"+this.sufijoFlexivo_irregularidad_29[5]+"</font>"+"<br>";
			  } 
			
			  
			  // irregularidad 71
			  
			  // verbos especiales
			  if (this.infinitivo.equals("ser")) {
				  this.forma[0]="soy";
				  this.forma[1]="eres";
				  this.forma[2]="es";
				  this.forma[3]="somos";
				  this.forma[4]="sois";
				  this.forma[5]="son";
				  for (int i=0;i<6;i++) {
					  this.formaTextoEnriquecido[i]="<font color=\\\""+color+"\\\">"+this.forma[i]+"</font>"+"<br>";
				  }
		   	 }
		   	 if (this.infinitivo.equals("haber")) {
		   		 this.forma[0]="he";
		   		 this.forma[1]="has";
		   		 this.forma[2]="ha";
		   		 this.forma[3]="hemos";
		   		 this.forma[4]="hab�is";
		   		 this.forma[5]="han";
				 for (int i=0;i<6;i++) {
					  this.formaTextoEnriquecido[i]="<font color=\\\""+color+"\\\">"+this.forma[i]+"</font>"+"<br>";
				  }
		   	 }
             if (this.infinitivo.equals("tener")) { // irregularidad 66
		   		 this.forma[0]=this.raiz+"go";
				  this.formaTextoEnriquecido[0]=this.raiz+"<font color=\\\""+color+"\\\">"+"go"+"</font>"+"<br>";
				 this.forma[1]="tienes";
		   		 this.forma[2]="tiene";
		   		 this.forma[3]="tenemos";
		   		 this.forma[4]="ten�is";
		   		 this.forma[5]="tienen";
		   		 for (int i=1;i<6;i++) {
					  this.formaTextoEnriquecido[i]="<font color=\\\""+color+"\\\">"+this.forma[i]+"</font>"+"<br>";
				  }
		   	 }
			
			  
	  }
  
	}// fin de metodo
	

	
	
	
	@Override
	 public boolean buscarForma(String cadenabuscada) {
		 boolean localizado=false;
		 String cadTrabajo="";
		 // primero buscamos irregularidades >>>>>>>>>>>>>>
		   // Por ejemplo, si buscamos "asgo" que es irregular y lo buscamos en formas regulares, como termina en "o" lo encontrariamos de forma incorrecta
		 
		 // buscamos en irregularidad 7
		 if (!localizado) { 
			 localizado=this.buscarFormaIrregular(cadenabuscada,this.sufijoFlexivo_irregularidad_7[0], 0);
			 if (localizado) {
				 this.irregularidadCastellano=7;
			 }
		 }	  
		 
		 // buscamos en irregularidad 9
		 if (!localizado) { 
			 localizado=this.buscarFormaIrregular(cadenabuscada,this.sufijoFlexivo_irregularidad_9[0], 0);
			 if (localizado) {
				 this.irregularidadCastellano=9;
			 }
		 }
		 if (!localizado) { 
		     localizado=this.buscarFormaIrregular(cadenabuscada,this.sufijoFlexivo_irregularidad_9[1], 1);
		     if (localizado) {
			 }
		 }
		 if (!localizado) { 
			 localizado=this.buscarFormaIrregular(cadenabuscada,this.sufijoFlexivo_irregularidad_9[2], 2);
			 if (localizado) {
				 this.irregularidadCastellano=9;
			 }
		 }
		 if (!localizado) { 
			 localizado=this.buscarFormaIrregular(cadenabuscada,this.sufijoFlexivo_irregularidad_9[5], 5);
			 if (localizado) {
				 this.irregularidadCastellano=9;
			 }
		 }
	
		 // buscamos en irregularidad 10
		 if (!localizado) { 
		   if (this.forma[0].equals("quepo")) {
			 this.irregularidadCastellano=10;
			 localizado=true;
			 this.conjugacion="er";
		    } 
		 }
		 
		 // si no se encuentra irregularidades buscamos en formas regulares
		 if (!localizado) { 
    		 localizado=super.buscarForma(cadenabuscada);
		 }


		 
		 return localizado;
	 }








// metodos privados de la clase
//***********************************
//*************************************



protected boolean buscarFormaIrregular(String cadenabuscada,String cadenaIrregularidad, int i) {
 
this.conjugacion="";
this.raiz="";
StringTokenV2 cad = new StringTokenV2(cadenabuscada,":");
String cad2="";
boolean salida=false;
cad2=cad.getDerecha( cadenaIrregularidad.length() );
//System.out.println("***   dentro **");
if ( cad2.equals(cadenaIrregularidad)) {
  salida=true;
  // System.out.println("*****"+cadenaIrregularidad);
  if (i==0 | i==1 | i==2) {
	   this.esSingular=true;
  } else {
	this.esSingular=false;
  }
}
if (i==0 | i==3) {
	this.persona="primera";
}
if (i==1 | i==4) {
	this.persona="segunda";
}
if (i==2 | i==5) {
	this.persona="tercera";
}
//this.raiz  y this.conjugacion  NO SE PUEDE SABER SIEMPRE

return salida;
} // fin metodo




	// sufijos regulares
protected void inicializar_sufijos() {
    	 this.cargar_sufijoFlexivo_ar();
	     this.cargar_sufijoFlexivo_er();
	     this.cargar_sufijoFlexivo_ir();
	     
	     // cargar sufijos irregulares
	     this.sufijoFlexivo_irregularidad_7();
	     this.sufijoFlexivo_irregularidad_9();
	     this.sufijoFlexivo_irregularidad_29();
    }

	
protected void cargar_sufijoFlexivo_ar() {
		sufijoFlexivo_ar[0]="o";
		sufijoFlexivo_ar[1]="as";
		sufijoFlexivo_ar[2]="a";
		sufijoFlexivo_ar[3]="amos";
		sufijoFlexivo_ar[4]="\u00E1is";
		sufijoFlexivo_ar[5]="an";
	}
	
protected void cargar_sufijoFlexivo_er() {
		sufijoFlexivo_er[0]="o";
		sufijoFlexivo_er[1]="es";
		sufijoFlexivo_er[2]="e";
		sufijoFlexivo_er[3]="emos";
		sufijoFlexivo_er[4]="\u00E9is";
		sufijoFlexivo_er[5]="en";
		
	}
	
protected void cargar_sufijoFlexivo_ir() {
		sufijoFlexivo_ir[0]="o";
		sufijoFlexivo_ir[1]="es";
		sufijoFlexivo_ir[2]="e";
		sufijoFlexivo_ir[3]="imos";
		sufijoFlexivo_ir[4]="\u00EDs";
		sufijoFlexivo_ir[5]="en";
	
	}
	
	
	// sufijos de irregularidades
protected void sufijoFlexivo_irregularidad_7() { // ejemplo verbo asir (que significa  Tomar o coger con la mano, y, en general, tomar, coger, prender)
		sufijoFlexivo_irregularidad_7[0]="go";
	}
	
	// sufijos de irregularidades
protected void sufijoFlexivo_irregularidad_9() { // ejemplos: bendecir, predecir
		sufijoFlexivo_irregularidad_9[0]="igo"; // tambi�n hay que cambiar la raiz
		sufijoFlexivo_irregularidad_9[1]="ices"; 
		sufijoFlexivo_irregularidad_9[2]="ice"; 
		sufijoFlexivo_irregularidad_9[5]="icen";
	}
	

// sufijos de irregularidades
protected void sufijoFlexivo_irregularidad_29() { // irregularidad 29 (Huir, incluir, disminuir...)
	sufijoFlexivo_irregularidad_29[0]="yo";
	sufijoFlexivo_irregularidad_29[1]="yes";
	sufijoFlexivo_irregularidad_29[2]="ye";
	sufijoFlexivo_irregularidad_29[3]="";
	sufijoFlexivo_irregularidad_29[4]="";
	sufijoFlexivo_irregularidad_29[5]="yen";	
}
	
	
} // fin de clase
