package io.github.lcriadof.sofia.gramatica.castellano.verbos;

/**
* Preterito Perfecto (o Preterito Perfecto Compuesto) de Indicativo
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 2.0 
* @version 2019
*/ 
public class indicativoFuturoPerfecto extends forma {

	 // esta clase tiene un construcctor que s�lo permite buscar si un termino es una forma verbal conocida, en este caso,
		// no se puede invocar a otras clases, pues no se sabe raiz, conjugaci�n y tipo de irregularidad
		 protected boolean metodoActivo=false;
		
	// este constructor sirve para conjugar una forma del INDICATIVO
		public indicativoFuturoPerfecto( String infinitivo, int codigoIrregularidadCastellano) {
			super(infinitivo, codigoIrregularidadCastellano);
			 this.metodoActivo=true;
			
			 this.modo="Indicativo";
			 this.nombreForma="Futuro";
		     this.tiempo="Futuro perfecto"; // o preterito perfecto compuesto
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
				sufijoFlexivo_ar[0]="habr\u00E9";
				sufijoFlexivo_ar[1]="habr\u00E1s";
				sufijoFlexivo_ar[2]="habr\u00E1";
				sufijoFlexivo_ar[3]="habremos";
				sufijoFlexivo_ar[4]="habr\u00E9is";
				sufijoFlexivo_ar[5]="habr\u00E1n";
			}
			
	
			
}
