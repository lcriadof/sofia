package io.github.lcriadof.sofia.gramatica.castellano.verbos;

/**
* Condicional simple de Indicativo
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 2.0 
* @version 2019
*/ 
public class indicativoCondicionalSimple extends forma {

	 // esta clase tiene un construcctor que s�lo permite buscar si un termino es una forma verbal conocida, en este caso,
		// no se puede invocar a otras clases, pues no se sabe raiz, conjugaci�n y tipo de irregularidad
		 protected boolean metodoActivo=false;

	// este constructor sirve para conjugar una forma del INDICATIVO
		public indicativoCondicionalSimple( String infinitivo, int codigoIrregularidadCastellano) {
			super(infinitivo, codigoIrregularidadCastellano);
			 this.metodoActivo=true;

			 this.modo="Indicativo";
			 this.nombreForma="Condicional";
		     this.tiempo="Condicional simple";
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
				sufijoFlexivo_ar[0]="ar\u00EDa";
				sufijoFlexivo_ar[1]="ar\u00EDas";
				sufijoFlexivo_ar[2]="ar\u00EDa";
				sufijoFlexivo_ar[3]="ar\u00EDamos";
				sufijoFlexivo_ar[4]="ar\u00EDais";
				sufijoFlexivo_ar[5]="ar\u00EDan";
			}


		protected void cargar_sufijoFlexivo_er() {
				sufijoFlexivo_er[0]="er\u00EDa";
				sufijoFlexivo_er[1]="er\u00EDas";
				sufijoFlexivo_er[2]="er\u00EDa";
				sufijoFlexivo_er[3]="er\u00EDamos";
				sufijoFlexivo_er[4]="er\u00EDais";
				sufijoFlexivo_er[5]="er\u00EDan";
			}
		
		protected void cargar_sufijoFlexivo_ir() {
				sufijoFlexivo_ir[0]="ir\u00EDa";
				sufijoFlexivo_ir[1]="ir\u00EDas";
				sufijoFlexivo_ir[2]="ir\u00EDa";
				sufijoFlexivo_ir[3]="ir\u00EDamos";
				sufijoFlexivo_ir[4]="ir\u00EDais";
				sufijoFlexivo_ir[5]="ir\u00EDan";
		}



}
