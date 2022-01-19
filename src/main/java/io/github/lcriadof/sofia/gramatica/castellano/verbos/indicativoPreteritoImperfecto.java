package io.github.lcriadof.sofia.gramatica.castellano.verbos;

// documentacion sobre el Preterito Imperfecto
// https://espanol.lingolia.com/es/gramatica/tiempos/preterito-imperfecto

/*
 El pret�rito imperfecto de indicativo se utiliza en espa�ol para expresar cursos de acciones pasados cuyo principio y fin no se concretan.
 Del mismo modo, sirve para recalcar la continuidad o regularidad de una acci�n en el pasado.


En este apartado aprender�s a identificar las situaciones en las que se debe emplear en espa�ol el pret�rito imperfecto y
las reglas de conjugaci�n de los verbos regulares e irregulares. En la secci�n de ejercicios puedes poner a prueba tus conocimientos.

 */

// En espa�ol solo hay tres verbos de conjugaci�n irregular en pret�rito imperfecto:
//   ser, estar, ir

// Los verbos terminados en -er e -ir adoptan las mismas terminaciones.

/**
* Preterito Imperfecto de Indicativo
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 2.0 
* @version 2019
*/ 
public class indicativoPreteritoImperfecto extends forma {

	 // esta clase tiene un construcctor que s�lo permite buscar si un termino es una forma verbal conocida, en este caso,
		// no se puede invocar a otras clases, pues no se sabe raiz, conjugaci�n y tipo de irregularidad
		 protected boolean metodoActivo=false;

	// este constructor sirve para conjugar una forma del INDICATIVO
		public indicativoPreteritoImperfecto( String infinitivo, int codigoIrregularidadCastellano) {
			super(infinitivo, codigoIrregularidadCastellano);
			 this.metodoActivo=true;

			 this.modo="Indicativo";
			 this.nombreForma="Pasado";
		     this.tiempo="Preterito Imperfecto";
		     this.esCompuesta=false;
		     this.voz="activa";

		     this.inicializar_sufijos();
		     this.conjugarForma();
	    	}


		   /**
	     * Calcula la forma conjugada concreta, pero no lo devuelve. <br>
	     * Para recuperar la conjugacion hay que utilizar el metodo "getForma".<br>
	     *  <p>
	     * @since version 2.0
	     * @version noviembre 2019
	     */
	     public void conjugarForma() {
	    	 super.conjugarForma();
	    	 super.conjugarFormaTextoEnriquecido(); // conjugaci�n regular enriquecida con colores
	    	 /*
	    	 for (int i=0; i<6 ;i++) {
	   			 this.formaTextoEnriquecido[i]=this.forma[i]+"<br>";
		      */
	     } // fin de m�todo







		// sufijos regulares
		protected void inicializar_sufijos() {
		    	 this.cargar_sufijoFlexivo_ar();
		    	 this.cargar_sufijoFlexivo_er();
		    	 this.cargar_sufijoFlexivo_ir();
		    }





		protected void cargar_sufijoFlexivo_ar() {
				sufijoFlexivo_ar[0]="aba";
				sufijoFlexivo_ar[1]="abas";
				sufijoFlexivo_ar[2]="aba";
				sufijoFlexivo_ar[3]="\u00E1bamos";
				sufijoFlexivo_ar[4]="abais";
				sufijoFlexivo_ar[5]="aban";
			}





		// no hay diferencias entre  -er -ir
		protected void cargar_sufijoFlexivo_er() {
				sufijoFlexivo_er[0]="\u00EDa";
				sufijoFlexivo_er[1]="\u00EDas";
				sufijoFlexivo_er[2]="\u00EDa";
				sufijoFlexivo_er[3]="\u00EDamos";
				sufijoFlexivo_er[4]="\u00EDais";
				sufijoFlexivo_er[5]="\u00EDan";

			}
		
		// no hay diferencias entre  -er -ir
		protected void cargar_sufijoFlexivo_ir() {
				sufijoFlexivo_ir[0]=sufijoFlexivo_er[0];
				sufijoFlexivo_ir[1]=sufijoFlexivo_er[1];
				sufijoFlexivo_ir[2]=sufijoFlexivo_er[2];
				sufijoFlexivo_ir[3]=sufijoFlexivo_er[3];
				sufijoFlexivo_ir[4]=sufijoFlexivo_er[4];
				sufijoFlexivo_ir[5]=sufijoFlexivo_er[5];
 		}



}
