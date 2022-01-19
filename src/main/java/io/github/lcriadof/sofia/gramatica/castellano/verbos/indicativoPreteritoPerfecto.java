package io.github.lcriadof.sofia.gramatica.castellano.verbos;

/**
* Preterito Perfecto (o Preterito Perfecto Compuesto) de Indicativo
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 2.0 
* @version 2019
*/ 
public class indicativoPreteritoPerfecto extends forma {

	 // esta clase tiene un construcctor que s�lo permite buscar si un termino es una forma verbal conocida, en este caso,
		// no se puede invocar a otras clases, pues no se sabe raiz, conjugaci�n y tipo de irregularidad
		 protected boolean metodoActivo=false;
		
	// este constructor sirve para conjugar una forma del INDICATIVO
		public indicativoPreteritoPerfecto( String infinitivo, int codigoIrregularidadCastellano) {
			super(infinitivo, codigoIrregularidadCastellano);
			 this.metodoActivo=true;
			
			 this.modo="Indicativo";
			 this.nombreForma="Presente";
		     this.tiempo="Preterito Perfecto"; // o preterito perfecto compuesto
		     this.esCompuesta=true;
		     this.voz="activa";
		     
		     this.inicializar_sufijos();
	    	}

		
		   /**
	     * Calcula la forma conjugada concreta, pero no lo devuelve. <br>
	     * Para recuperar la conjugaci�n hay que utilizar el m�todo "getForma".<br>
	     *  <p>
	     * @since version 2.0 
	     * @version noviembre 2019 
	     */
	     public void conjugarForma() {
		    for (int i=0; i<6 ;i++) {
	   			this.forma[i]=sufijoFlexivo_ar[i]+" "+this.participio;
	   			this.formaTextoEnriquecido[i]=this.forma[i]+"<br>";
		    }
	      } // fin de m�todo  
	    
		
		
		
		
		
		
		// sufijos regulares
		protected void inicializar_sufijos() {
		    	 this.cargar_sufijoFlexivo_ar();
		     // no hay irregularidades en esta forma
		    }

		// no hay diferencias entre -ar -er -ir
		protected void cargar_sufijoFlexivo_ar() {
				sufijoFlexivo_ar[0]="he";
				sufijoFlexivo_ar[1]="has";
				sufijoFlexivo_ar[2]="ha";
				sufijoFlexivo_ar[3]="hemos";
				sufijoFlexivo_ar[4]="hab\u00E9is";
				sufijoFlexivo_ar[5]="han";
			}
			
	
			
}
