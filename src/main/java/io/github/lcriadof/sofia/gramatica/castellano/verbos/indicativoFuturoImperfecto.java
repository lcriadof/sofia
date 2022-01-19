package io.github.lcriadof.sofia.gramatica.castellano.verbos;

/**
* Futuro Imperfecto de Indicativo
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 2.0 
* @version 2019
*/ 
public class indicativoFuturoImperfecto extends forma {

	 // esta clase tiene un construcctor que s�lo permite buscar si un termino es una forma verbal conocida, en este caso,
		// no se puede invocar a otras clases, pues no se sabe raiz, conjugaci�n y tipo de irregularidad
		 protected boolean metodoActivo=false;

	// este constructor sirve para conjugar una forma del INDICATIVO
		public indicativoFuturoImperfecto( String infinitivo, int codigoIrregularidadCastellano) {
			super(infinitivo, codigoIrregularidadCastellano);
			 this.metodoActivo=true;

			 this.modo="Indicativo";
			 this.nombreForma="Futuro";
		     this.tiempo="Futuro imperfecto";
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
	    	 
	    	 if (this.infinitivo.equals("ser")) {
	    		 this.forma[0]="ser�";
	    		 this.forma[1]="ser�s";
	    		 this.forma[2]="ser�";
	    		 this.forma[3]="seremos";
	    		 this.forma[4]="ser�is";
	    		 this.forma[5]="ser�n";
	    	 }
	    	 
	    	 if (this.infinitivo.equals("haber")) {
	    		 this.forma[0]="habr�";
	    		 this.forma[1]="habr�s";
	    		 this.forma[2]="habr�";
	    		 this.forma[3]="habremos";
	    		 this.forma[4]="habr�is";
	    		 this.forma[5]="habr�n";
	    	 }
	    	 
	    	 if (this.infinitivo.equals("tener")) { // irregularidad 66
	    		 this.forma[0]="tendr�";
	    		 this.forma[1]="tendr�s";
	    		 this.forma[2]="tendr�";
	    		 this.forma[3]="tendremos";
	    		 this.forma[4]="tendr�is";
	    		 this.forma[5]="tendr�n";
	    	 }
	     } // fin de m�todo







		// sufijos regulares
		protected void inicializar_sufijos() {
		    	 this.cargar_sufijoFlexivo_ar();
		    	 this.cargar_sufijoFlexivo_er();
		    	 this.cargar_sufijoFlexivo_ir();
		    }





		protected void cargar_sufijoFlexivo_ar() {
				sufijoFlexivo_ar[0]="ar\u00E9";
				sufijoFlexivo_ar[1]="ar\u00E1s";
				sufijoFlexivo_ar[2]="ar\u00E1";
				sufijoFlexivo_ar[3]="aremos";
				sufijoFlexivo_ar[4]="areis";
				sufijoFlexivo_ar[5]="ar\u00E1n";
			}



		protected void cargar_sufijoFlexivo_er() {
				sufijoFlexivo_er[0]="er\u00E9";
				sufijoFlexivo_er[1]="er\u00E1s";
				sufijoFlexivo_er[2]="er\u00E1";
				sufijoFlexivo_er[3]="eremos";
				sufijoFlexivo_er[4]="er\u00E9is";
				sufijoFlexivo_er[5]="er\u00E1n";
			}
		
		protected void cargar_sufijoFlexivo_ir() {
				sufijoFlexivo_ir[0]="ir\u00E9";
				sufijoFlexivo_ir[1]="ir\u00E1s";
				sufijoFlexivo_ir[2]="ir\u00E1";
				sufijoFlexivo_ir[3]="iremos";
				sufijoFlexivo_ir[4]="ir\u00E9is";
				sufijoFlexivo_ir[5]="ir\u00E1n";
		}



}
