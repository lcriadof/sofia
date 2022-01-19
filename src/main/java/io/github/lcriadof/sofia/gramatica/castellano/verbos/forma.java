package io.github.lcriadof.sofia.gramatica.castellano.verbos;


// Importa las clases de log4j.
import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator; 
import io.github.lcriadof.cadenas.StringTokenV2;



//  Forma
/**
* Clase padre para conjugar un verbo,
*
* autor: <a href="http://luis.criado.online">Luis Criado</a> 
* @since version 2.0 
* @version 2019
*/ 

public abstract class forma {


// a t r i b u t o s

  /** Define una variable de tipo Logger.
  El parametro que se envia es el nombre de la clase que lo contiene. */
     Logger logger = Logger.getLogger(this.getClass());

  /** Define una variable que contiene el verbo en infinitivo
   (con protected se permite que los atributos lo vean lo hijos) */
   protected String infinitivo="";
  
  /** Define una variable que contiene la raiz del verbo 
   (con protected se permite que los atributos lo vean lo hijos) */
   protected String raiz="";
 
   /** Define una variable que contiene el verbo en participio
   (con protected se permite que los atributos lo vean lo hijos) */
   protected String participio="";
   
   
   /** Gerundio */
   protected String gerundio="";
  
  
   /** Indica el tipo de conjugaci�n (-ar, -er, -ir)
   (con protected se permite que los atributos lo vean lo hijos) */
   protected String conjugacion=""; 
  
  
   /** Indica el c�digo de irregularidad
   (con protected se permite que los atributos lo vean lo hijos) */
   protected int irregularidadCastellano=0;  // el valor 0 indica regular
  
   
    /** Define una variable que contiene el modo (Indicativo, Subjuntivo...)
   * (con protected se permite que los atributos lo vean lo hijos) */
   protected String modo="";	 
   	 
   /** Define una variable que contiene el tiempo (presente, pasado, futuro, condicional...)
   * (con protected se permite que los atributos lo vean lo hijos) */
   protected String tiempo="";
   
     
   /** Define una variable que contiene la voz (activa, pasiva, ...)
   * (con protected se permite que los atributos lo vean lo hijos) */
   protected String voz=""; 
   	 
   /** Define una variable que contiene el nombre de la forma (presente, Condicional Perfecto, ...)
   * (con protected se permite que los atributos lo vean lo hijos) */
   protected String nombreForma="";

   /** Define una variable que contiene la persona (primera persona, segunda persona, tercera personaa)
   * (con protected se permite que los atributos lo vean lo hijos) */
   protected String persona="";
      
   /** Define una variable que contiene el numero (singular o plural)
   * (con protected se permite que los atributos lo vean lo hijos) */
   protected boolean esSingular=false;      
      
   /** Define si la forma es simple o compuesta
    * true indica compuesta y false simple
    * (con protected se permite que los atributos lo vean lo hijos) */
    protected boolean esCompuesta=false; 
    
   /**
   Este array contiene las formas conjugadas (el elemeto 0=yo,1=tu,2=el,3=nosotros,4=vosotros,5=ellos)*/
   protected String [] forma = new String[6]; 
   protected String [] formaTextoEnriquecido = new String[6]; 
   
   
   // arrays para las terminaciones de las conjugaciones regulares
   protected String[] sufijoFlexivo_ar = new String[6];
   protected String[] sufijoFlexivo_er = new String[6];
   protected String[] sufijoFlexivo_ir = new String[6];
   
   
   
   /**
    * Construcctor.
    * <p>
    * @since version 2.0 
    * @version enero 2019 
     */  
   public forma() {
	   
	// inicializamos las variables que guardaran las diferentes formas de la conjugaci�n
	      // (el elemeto 0=yo,1=tu,2=el,3=nosotros,4=vosotros,5=ellos )

	    this.forma[0]=""; this.forma[1]=""; this.forma[2]="";
	    this.forma[3]=""; this.forma[4]=""; this.forma[5]="";
   	
   }
   
   
   /**
    * Construcctor.
    * <p>
    * @since version 2.0 
    * @version enero 2019 
    * @param raiz raiz del verbo a conjugar
    * @param conjugacion indica el tipo de conjugaci�n base -ar -er -ir
    * @param codigoIrregularidadCastellano indica el codigo de irregularidad, si es regular se indica "0"
     */  
   public forma( String raiz, String conjugacion, int codigoIrregularidadCastellano) {
	   this.raiz=raiz;
	   this.infinitivo=raiz+conjugacion;
	   this.conjugacion=conjugacion;
	   this.irregularidadCastellano=codigoIrregularidadCastellano;
	   
	   if (codigoIrregularidadCastellano==0) {
		   if (this.conjugacion.equals("ar")){
		    	 this.gerundio=raiz+"ando";
		    }else{ // -er o -ir  son iguales    ---- puede haber gerundios irregulares
		    	 this.gerundio=raiz+"iendo";
		    }
		   
		   if (this.conjugacion.equals("ar")){  
		    	 this.participio=raiz+"ado";
		    }else{ // -er o -ir  son iguales    ---- puede haber participios irregulares
		    	 this.participio=raiz+"ido";
		   }
		   
	   } // fin de if para verbos regulares
	   
	// inicializamos las variables que guardaran las diferentes formas de la conjugaci�n
	      // (el elemeto 0=yo,1=tu,2=el,3=nosotros,4=vosotros,5=ellos )

	    this.forma[0]=""; this.forma[1]=""; this.forma[2]="";
	    this.forma[3]=""; this.forma[4]=""; this.forma[5]="";
	   
   }
  
  
   /**
    * Construcctor.
    * <p>
    * @since version 2.0 
    * @version enero 2019 
    * @param infinitivo del verbo a conjugar
    * @param codigoIrregularidadCastellano indica el codigo de irregularidad, si es regular se indica "0"
     */  
   public forma( String infinitivo, int codigoIrregularidadCastellano) {
	   this.infinitivo=infinitivo;
	   
	   StringTokenV2 cad = new StringTokenV2(infinitivo,":"); 
	   String cad0=cad.getToken(1);
	   
	   this.raiz=cad.getIzquierda(cad0.length()-2);
	   this.conjugacion=cad.getDerecha(2);
	   this.irregularidadCastellano=codigoIrregularidadCastellano;
	   
	   if (codigoIrregularidadCastellano==0) {
		   if (this.conjugacion.equals("ar")){
		    	 this.gerundio=raiz+"ando";
		    }else{ // -er o -ir  son iguales    ---- puede haber gerundios irregulares
		    	 this.gerundio=raiz+"iendo";
		    }
		   
		   if (this.conjugacion.equals("ar")){  
		    	 this.participio=raiz+"ado";
		    }else{ // -er o -ir  son iguales    ---- puede haber participios irregulares
		    	 this.participio=raiz+"ido";
		   }
		   
	   } // fin de if para verbos regulares
	   
	// inicializamos las variables que guardaran las diferentes formas de la conjugaci�n
	      // (el elemeto 0=yo,1=tu,2=el,3=nosotros,4=vosotros,5=ellos )

	    this.forma[0]=""; this.forma[1]=""; this.forma[2]="";
	    this.forma[3]=""; this.forma[4]=""; this.forma[5]="";
	   
   }
    
    
   
  

   
   
   
   
      /// METODOS GET  
  /**
  *Devuelve el modo, es decir, si se trata de Indicativo, Subjuntivo, etc...
  *<p>
  *El MODO verbal denota la actitud del hablante con respecto a lo que dice. 
  *Existen tres modos en castellano:
  *
  *<p>
  *INDICATIVO	
  *Enuncia el hecho de manera real y objetiva	
  *Pedro ESTUDIA medicina en la Facultad de Valencia
  *
  *<p>
  *SUBJUNTIVO	
  *Expresa deseo, temor, voluntad, suposici�n, etc.	
  *quiero que VENGAS;
  *temo que LLUEVA
  *
  *<p>
  *IMPERATIVO	
  *Se utiliza para formular �rdenes, expresar un ruego, hacer una petici�n o dar un consejo	
  *VENID a las doce; 
  *AMA al pr�jimo
  *<p> 
  * @since version 1.0 
  * @version noviembre 2009 
  * @param   void
  * @return  devuelve el modo; Indicativo, Subjuntivo
  */
   public String getModo(){
   	 	return this.modo;
   } 
    
    
     /**
  * Devuelve la forma.
  * <p> 
  * @since version 1.0 
  * @version noviembre 2009 
  * @param   void
  * @return  devuelve la persona (primera, segunda o tercera persona)
  */ 
   public String getPersona(){
     	return this.persona;
    }
   
  
   
  /**
  * Devuelve el tiemo.
  * <p> 
  * @since version 1.0 
  * @version noviembre 2009 
  * @param   void
  * @return  devuelve el tiempo de la forma; Presente, Pasado, Futuro, Condicional,...
  */ 
   public String getTiempo(){
     	return this.tiempo;
    }
  
   
  /**
  * Devuelve la voz del verbo.
  * <p> 
  * @since version 1.0 
  * @version noviembre 2009 
  * @param   void
  * @return  activa, pasiva...
  */ 
   public String getVoz(){
     	return this.voz;
    }
  
    
    
  
    
  /**
  * Devuelve la forma.
  * <p> 
  * @since version 1.0 
  * @version noviembre 2009 
  * @param   void
  * @return  devuelve la forma; Presente, Preterito Imperfecto,...
  */ 
   public String getNombreForma(){
     	return this.nombreForma;
    }
    
   
   
   
   /**
    * raiz del verbo
    * <p> 
    * @since version 2.0 
    * @version enero 2019 
    * @param   void
    * @return  devuelve la raiz del verbo a conjugar
    */ 
   public String getRaiz(){
   	return this.raiz;
  }
  

   /**
    * Infinitivo
    * <p> 
    * @since version 2.0 
    * @version enero 2019 
    * @param   void
    * @return  devuelve el infinitivo
    */ 
   public String getInfinitivo(){
    	return this.infinitivo;
   }
   
   
   /**
    * Participio
    * <p> 
    * @since version 2.0 
    * @version enero 2019 
    * @param   void
    * @return  devuelve el participio
    */ 
   public String getParticipio(){
    	return this.participio;
   }
   
   /**
    * Gerundio
    * <p> 
    * @since version 2.0 
    * @version enero 2019 
    * @param   void
    * @return  devuelve el gerundio
    */ 
   public String getGerundio(){
   	return this.gerundio;
  }
 
   
   /**
    * Codigo de Irregularidad
    * <p> 
    * @since version 2.0 
    * @version enero 2019 
    * @param   void
    * @return  devuelve el c�digo de irregularidad en base "el libro de los verbos" de Arturo Ramonera (2006) 
    */ 
  public int getIrregularidad() {
	  return this.irregularidadCastellano;
  }
    
 
 
   
  /**
   * Devuelve el tipo de conjugaci�n
   * <p> 
   * @since version 2.0 
   * @version enero 2019 
   * @param   void
   * @return  devuelve el tipo de conjugacion: -ar  -er  o -ir
   * 
   *    */ 
  public String getTipoConjugaciona(){
   	return this.conjugacion;
  }
   
   
   
   
 
  /**
  * Devuelve la forma conjugada
  * <p>
  * @since version 1.0 
  * @version noviembre 2009 
  * @param   void
  * @return  Devuelve un array de 6 elementos que contiene la conjugacion de la forma
  */ 
    public String [] getFormaConjugada() {
      	return this.forma;
    }
    
    
    
    /**
     * Devuelve la forma conjugada erriquecido con HTML
     * <p>
     * @since version 1.0 
     * @version noviembre 2009 
     * @param   void
     * @return  Devuelve un array de 6 elementos que contiene la conjugaci�n de la forma
     */ 
     public String [] getFormaConjugadaEnriquecida() {
       	return this.formaTextoEnriquecido;
     }
         
    
     /**
      * Forma conjugada erriquecido con HTML 
      * <p>
      * @since version 2.0 
      * @version noviembre 2019 
      * @param   void
      * @return  Devuelve un String con la conjugacion de la forma erriquecido con HTML
      */ 
     public String getFormaConjugadaEnriquecidaString() {
 		String todaLaFormaEnString="";
 		StringTokenV2 cadenatrab = null; 
 		this.conjugarForma();
 		
 		cadenatrab=new StringTokenV2(this.formaTextoEnriquecido[0],":");
 		todaLaFormaEnString=cadenatrab.getCambiar("\\", "");
 		
 		cadenatrab=new StringTokenV2(this.formaTextoEnriquecido[1],":");
 		todaLaFormaEnString=todaLaFormaEnString+cadenatrab.getCambiar("\\", "");
 		
 		cadenatrab=new StringTokenV2(this.formaTextoEnriquecido[2],":");
 		todaLaFormaEnString=todaLaFormaEnString+cadenatrab.getCambiar("\\", "");
 		
 		cadenatrab=new StringTokenV2(this.formaTextoEnriquecido[3],":");
 		todaLaFormaEnString=todaLaFormaEnString+cadenatrab.getCambiar("\\", "");
 		
 		cadenatrab=new StringTokenV2(this.formaTextoEnriquecido[4],":");
 		todaLaFormaEnString=todaLaFormaEnString+cadenatrab.getCambiar("\\", "");
 		
 		cadenatrab=new StringTokenV2(this.formaTextoEnriquecido[5],":");
 		todaLaFormaEnString=todaLaFormaEnString+cadenatrab.getCambiar("\\", "");
 		
 		
 		return todaLaFormaEnString;
 	}
 	  
     
     
     
    
    
  /**
  * Devuelve la forma conjugada particular <br>
  * <p>
  * <pre><u>Ejemplo:</u><br>
  * Sea 'a' un String <br>
  * Sea 'b` una instancia de un hijo de la clase "forma" <br>
  *     <br>
  *     a=b.getPersonaConjugada("tu");   // devuelve la conjugaci�n de la segunda persona del singular
  *      <br>
  * </pre>
  * @since version 1.0 
  * @version noviembre 2009 
  * @param   pronombre indica el pronombre de la forma concreta que se desea (yo, tu el, nosotros, vosotros, ellos)
  * @return  Devuelve un String con la conjugacion para la persona correspondiente.
  */ 
    public String getPersonaConjugada(String pronombre) {
    	String devolverForma="";
    	pronombre=pronombre.trim().toLowerCase();
    	
    	if (pronombre.equals("yo")){
    		devolverForma=this.forma[0];
    	}	
    	if (pronombre.equals("tu")){
    		devolverForma=this.forma[1];
    	}	
    	if (pronombre.equals("el")){
    		devolverForma=this.forma[2];
    	}	
    	if (pronombre.equals("nosotros")){
    		devolverForma=this.forma[3];
    	}	
    	if (pronombre.equals("vosotros")){
    		devolverForma=this.forma[4];
    	}	
    	if (pronombre.equals("ellos")){
    		devolverForma=this.forma[5];
    	}	
    	
      	return devolverForma;
    } // fin del metodo
    
    
    
    
  
    
    
    
  // metodos Is
    

    /**
   * Devuelve la forma.
   * <p> 
   * @since version 1.0 
   * @version noviembre 2009 
   * @param   void
   * @return  devuelve true si es singular.
   */ 
    public boolean isSingular(){
      	return this.esSingular;
     }
     
    
   /**
   * Devuelve true si la forma es compuesta
   * <p> 
   * @since version 1.0 
   * @version noviembre 2009 
   * @param   void
   * @return  devuelve true si la forma es compuesta
   */ 
    public boolean isCompuesta(){
      	return this.esCompuesta;
     }   
    
     
    
 

   
   /**
    * Busca una forma conjugada
    * <p>
    * @since version 2.0 
    * @version enero 2019 
    * @param   cadenabuscada forma verbal que queremos encontrar
    * @return  Devuelve true si se ha encontrado la forma
    */ 
   public boolean buscarForma(String cadenabuscada) {
		StringTokenV2 cad = new StringTokenV2(cadenabuscada,":"); 
		String valoractual="";
		String cad2="";
		boolean salida=false;
		
		
		// for para revisar sufijos conjugacion -ar
		for (int i = 0; i < 6; ++i) {
			valoractual=sufijoFlexivo_ar[i];
			cad2=cad.getDerecha( valoractual.length() );
			if ( cad2.equals(valoractual)) {
				salida=true;
				if (i==0 | i==1 | i==2) {
					this.esSingular=true;
				} else {
					this.esSingular=false;
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
				this.conjugacion="ar";
				this.raiz=cad.getIzquierda(cadenabuscada.length()-cad2.length());
				break;
			}
		} // fin de for
		
		
			
		
		// for para revisar sufijos conjugacion -er
	    if (!salida) {
	 			for (int i = 0; i < 6; ++i) {
					valoractual=sufijoFlexivo_er[i];
					cad2=cad.getDerecha( valoractual.length() );
					if ( cad2.equals(valoractual)) {
						salida=true;
						if (i==0 | i==1 | i==2) {
							this.esSingular=true;
						} else {
							this.esSingular=false;
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
						this.conjugacion="er";
						this.raiz=cad.getIzquierda(cadenabuscada.length()-cad2.length());
						break;
					}
				} // fin de for
	    }
	    
	    
	 // for para revisar sufijos conjugacion -ir
	    if (!salida) {
	 			for (int i = 0; i < 6; ++i) {
					valoractual=sufijoFlexivo_ir[i];
					cad2=cad.getDerecha( valoractual.length() );
					if ( cad2.equals(valoractual)) {
						salida=true;
						if (i==0 | i==1 | i==2) {
							this.esSingular=true;
						} else {
							this.esSingular=false;
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
						this.conjugacion="ir";
						this.raiz=cad.getIzquierda(cadenabuscada.length()-cad2.length());
						break;
					}
				} // fin de for
	    }
	    this.conjugacion=""; // no se ha encontrado nada
		return salida;
	}

       
   
   
   
   // metodos VOID 
  // metodos de proceso
   
   
	
   
    /**
     * Calcula la forma conjugada concreta, pero no lo devuelve. <br>
     * @see getFormaConjugada()
     * @see getFormaConjugadaEnriquecida()
     * @see getFormaConjugadaEnriquecidaString()
     * @since version 2.0 
     * @version noviembre 2019 
     */
   public void conjugarForma() {
   		 //Las irregularidadews son correcciones sobre alguna de sus conjugaciones
    	  // de forma que siempre antes se realiza la conjugacion regular
   				if (this.conjugacion.equals("ar")) {
   					this.forma[0]=this.raiz+sufijoFlexivo_ar[0];
   					this.forma[1]=this.raiz+sufijoFlexivo_ar[1];
   					this.forma[2]=this.raiz+sufijoFlexivo_ar[2];
   					this.forma[3]=this.raiz+sufijoFlexivo_ar[3];
   					this.forma[4]=this.raiz+sufijoFlexivo_ar[4];
   					this.forma[5]=this.raiz+sufijoFlexivo_ar[5];
   				}
   				if (this.conjugacion.equals("er")) {
   					this.forma[0]=this.raiz+sufijoFlexivo_er[0];
   					this.forma[1]=this.raiz+sufijoFlexivo_er[1];
   					this.forma[2]=this.raiz+sufijoFlexivo_er[2];
   					this.forma[3]=this.raiz+sufijoFlexivo_er[3];
   					this.forma[4]=this.raiz+sufijoFlexivo_er[4];
   					this.forma[5]=this.raiz+sufijoFlexivo_er[5];
   				}
   				if (this.conjugacion.equals("ir")) {
   					this.forma[0]=this.raiz+sufijoFlexivo_ir[0];
   					this.forma[1]=this.raiz+sufijoFlexivo_ir[1];
   					this.forma[2]=this.raiz+sufijoFlexivo_ir[2];
   					this.forma[3]=this.raiz+sufijoFlexivo_ir[3];
   					this.forma[4]=this.raiz+sufijoFlexivo_ir[4];
   					this.forma[5]=this.raiz+sufijoFlexivo_ir[5];
   				}
   		  
      } // fin de m�todo  
    
   
   

   /**
    * Calcula la forma conjugada concreta, pero no lo devuelve. <br>
     * @see getFormaConjugada()
     * @see getFormaConjugadaEnriquecida()
     * @see getFormaConjugadaEnriquecidaString()
    * @since version 2.0 
    * @version noviembre 2019 
    */
  public void conjugarFormaTextoEnriquecido() {
  		 //Las irregularidadews son correcciones sobre alguna de sus conjugaciones
   	  // de forma que siempre antes se realiza la conjugacion regular
	  String color="blue";
  				if (this.conjugacion.equals("ar")) {
  					this.formaTextoEnriquecido[0]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ar[0]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[1]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ar[1]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[2]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ar[2]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[3]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ar[3]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[4]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ar[4]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[5]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ar[5]+"</font>"+"<br>";
  				}
  				if (this.conjugacion.equals("er")) {
  					this.formaTextoEnriquecido[0]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_er[0]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[1]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_er[1]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[2]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_er[2]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[3]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_er[3]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[4]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_er[4]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[5]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_er[5]+"</font>"+"<br>";
  				}
  				if (this.conjugacion.equals("ir")) {
  					this.formaTextoEnriquecido[0]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ir[0]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[1]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ir[1]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[2]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ir[2]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[3]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ir[3]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[4]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ir[4]+"</font>"+"<br>";
  					this.formaTextoEnriquecido[5]=this.raiz+"<font color=\\\""+color+"\\\">"+sufijoFlexivo_ir[5]+"</font>"+"<br>";
  				}
  		  
     } // fin de m�todo  
   
    
  
 //metodos PRIVADOS DE LA CLASE
	//***********************************
   //************************************
   
   
  /** Elimina los acentos de una cadena
  */
 /** para evitar problemas de encoding se utilizan caracteres latinos en UNICODE para Java
  */
  protected String quitarAcentos(String cad){
 
		StringTokenV2 cad2=new StringTokenV2(cad,":");
   
   // sustituir 'a' con acento \u00E1 por a;
   	cad2.getCambiar("\\u00E1","a");
   	
  // sustituir \u00E9 por e;
   	cad2.getCambiar("\\u00E9","e");
 
  // sustituir \u00ED por i;
   	cad2.getCambiar("\\u00ED","i");
   	
  // sustituir \u00F3 por o;
   	cad2.getCambiar("\\u00F3","o");
   	
  // sustituir \u00FA por u
   	cad2.getCambiar("\\u00FA","u");
 
   	// la ñ es \u00F1
   	
  return cad2.toString();
 }

 
} // fin de la clase