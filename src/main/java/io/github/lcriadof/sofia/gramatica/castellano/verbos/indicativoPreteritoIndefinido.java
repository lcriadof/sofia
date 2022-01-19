package io.github.lcriadof.sofia.gramatica.castellano.verbos;

/**
* Preterito Indefinido (o Preterito o Preterito Perfecto Simple) de Indicativo
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 2.0 
* @version 2019
*/ 
public class indicativoPreteritoIndefinido extends forma {

	 // esta clase tiene un construcctor que s�lo permite buscar si un termino es una forma verbal conocida, en este caso,
		// no se puede invocar a otras clases, pues no se sabe raiz, conjugaci�n y tipo de irregularidad
		 protected boolean metodoActivo=false;
		 
		 
		 // irregularidades
		 protected String[] sufijoFlexivo_irregularidad_29 = new String[6];
		

	// este constructor sirve para conjugar una forma del INDICATIVO
		public indicativoPreteritoIndefinido( String infinitivo, int codigoIrregularidadCastellano) {
			super(infinitivo, codigoIrregularidadCastellano);
			 this.metodoActivo=true;

			 this.modo="Indicativo";
			 this.nombreForma="Pasado";
		     this.tiempo="Preterito Indefinido";  // o preterito o preterito perfecto simple
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
	    	 String color="red";
	    	 
	    	 if (this.irregularidadCastellano==29) {
	    		 this.forma[2]=sufijoFlexivo_irregularidad_29[2];
	    		 this.forma[5]=sufijoFlexivo_irregularidad_29[5];
	    	 }
	    	 
	    	 if (this.infinitivo.equals("asar")) { // tiene una irregularidad
	   		      this.forma[0]=this.raiz+"\u00E9";
			      this.formaTextoEnriquecido[0]=this.raiz+"<font color=\\\""+color+"\\\">"+"\u00E9"+"</font>"+"<br>";
	     	 }
	    	 if (this.infinitivo.equals("amplificar")) { // tiene una irregularidad
	   		      this.forma[0]="amplifiqu\u00E9";
			      this.formaTextoEnriquecido[0]="<font color=\\\""+color+"\\\">"+this.forma[0]+"</font>"+"<br>";
	     	 }
	    	 
	    	 if (this.infinitivo.equals("ser")) {
	    		 this.forma[0]="fui";
	    		 this.forma[1]="fuiste";
	    		 this.forma[2]="fue";
	    		 this.forma[3]="fuimos";
	    		 this.forma[4]="fuisteis";
	    		 this.forma[5]="fueron";
	    	 }
	    	 if (this.infinitivo.equals("haber")) {
	    		 this.forma[0]="hube";
	    		 this.forma[1]="hubiste";
	    		 this.forma[2]="hubo";
	    		 this.forma[3]="hubimos";
	    		 this.forma[4]="hubisteis";
	    		 this.forma[5]="hubieron";
	    	 }
	    	 if (this.infinitivo.equals("tener")) { // irregularidad 66
	    		 this.forma[0]="tuve";
	    		 this.forma[1]="tuiste";
	    		 this.forma[2]="tuvo";
	    		 this.forma[3]="tuvimos";
	    		 this.forma[4]="tuvisteis";
	    		 this.forma[5]="tuvieron";	
	    	 }
	    	
	     } // fin de m�todo







		// sufijos regulares
		protected void inicializar_sufijos() {
		    	 this.cargar_sufijoFlexivo_ar();
		    	 this.cargar_sufijoFlexivo_er();
		    	 this.cargar_sufijoFlexivo_ir();
		    	 this.sufijoFlexivo_irregularidad_29();
		    }





		protected void cargar_sufijoFlexivo_ar() {
				sufijoFlexivo_ar[0]="\u00E9";
				sufijoFlexivo_ar[1]="aste";
				sufijoFlexivo_ar[2]="\u00F3";
				sufijoFlexivo_ar[3]="amos";
				sufijoFlexivo_ar[4]="asteis";
				sufijoFlexivo_ar[5]="aron";
		} 



		// no hay diferencias entre  -er -ir
		protected void cargar_sufijoFlexivo_er() {
				sufijoFlexivo_er[0]="\u00ED";
				sufijoFlexivo_er[1]="iste";
				sufijoFlexivo_er[2]="i\u00F3";
				sufijoFlexivo_er[3]="imos";
				sufijoFlexivo_er[4]="isteis";
				sufijoFlexivo_er[5]="ieron";
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


		
		// sufijos de irregularidades
	protected void sufijoFlexivo_irregularidad_29() { // irregularidad 29 (Huir, incluir, disminuir...)
			sufijoFlexivo_irregularidad_29[0]="";
			sufijoFlexivo_irregularidad_29[1]=""; 
			sufijoFlexivo_irregularidad_29[2]="y�"; 
			sufijoFlexivo_irregularidad_29[3]=""; 
			sufijoFlexivo_irregularidad_29[4]=""; 
			sufijoFlexivo_irregularidad_29[5]="yeron";
			
		}
		

}
