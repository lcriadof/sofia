package io.github.lcriadof.sofia.giu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoCondicionalCompuesto;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoCondicionalSimple;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoFuturoImperfecto;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoFuturoPerfecto;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoPresente;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoPreteritoAnterior;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoPreteritoImperfecto;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoPreteritoIndefinido;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoPreteritoPerfecto;
import io.github.lcriadof.sofia.gramatica.castellano.verbos.indicativoPreteritoPluscuamperfecto;
import io.github.lcriadof.ficheros.secuencial;
import io.github.lcriadof.cadenas.StringTokenV2;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.util.HashMap;
import java.util.Vector;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class conjugaciones extends JFrame {

	private JPanel contentPane;
	private secuencial fichEntrada=new secuencial();
	private Vector<String> vecA = new Vector<String>();
	private String verboInfinitivoSeleccionado="";
	private String defVerboInfinitivoSeleccionado="";

	private JLabel lblNewLabel = new JLabel("");
	private JComboBox comboBox = new JComboBox();
	private JScrollPane scrollPane = new JScrollPane();
	private JEditorPane editorPane = new JEditorPane();
	private JTextPane textPane = new JTextPane();
	private HashMap<String, String> verboYdefinicion = new HashMap<String, String>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conjugaciones frame = new conjugaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public conjugaciones() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 600);
		

		
		textPane.setBackground(SystemColor.info);
		
	

		// selecci�n de los obletos JComboBox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				 if ( comboBox.getItemCount()>0 ) { // si tiene items
				    verboInfinitivoSeleccionado=comboBox.getSelectedItem().toString().trim(); // seleccion de verbo infinitivo a conjugar
				    defVerboInfinitivoSeleccionado=verboYdefinicion.get(verboInfinitivoSeleccionado);
				    
				    
				    textPane.setText(verboInfinitivoSeleccionado+": "+defVerboInfinitivoSeleccionado);
				    
			
				 }

				// componemos las partes de la tabla
				String cabecera="",pie="",separaFila="";
				cabecera="<table style=�border: hidden�><tbody style=�border: hidden�><tr style=�border: hidden�>";
				separaFila="</tr>";
				pie="<td style=�border: hidden�></tbody></table>";
				String celdaInicio="<td style=�border: hidden�>";
				String celdaFin="</td>";

				// conjugamos con salida enriquecida en html
				indicativoPresente v1=new indicativoPresente( verboInfinitivoSeleccionado, 0);
				String mostrarIndicativoPresenten=v1.getFormaConjugadaEnriquecidaString();
				mostrarIndicativoPresenten="<h3>Presente</h3>"+mostrarIndicativoPresenten;
				
				indicativoPreteritoPerfecto v2=new indicativoPreteritoPerfecto( verboInfinitivoSeleccionado, 0);
				String mostrarIndicativoPreteritoPerfecto=v2.getFormaConjugadaEnriquecidaString();
				mostrarIndicativoPreteritoPerfecto="<h3>Pret�rito perfecto compuesto</h3>"+mostrarIndicativoPreteritoPerfecto;
				
				indicativoPreteritoPluscuamperfecto v3=new indicativoPreteritoPluscuamperfecto( verboInfinitivoSeleccionado, 0);
				String mostrarindicativoPreteritoPluscuamperfecto=v3.getFormaConjugadaEnriquecidaString();
				mostrarindicativoPreteritoPluscuamperfecto="<h3>Pret�rito pluscuamperfecto</h3>"+mostrarindicativoPreteritoPluscuamperfecto;
				
				indicativoPreteritoImperfecto v4=new indicativoPreteritoImperfecto( verboInfinitivoSeleccionado, 0);
				String mostrarindicativoPreteritoImperfecto=v4.getFormaConjugadaEnriquecidaString();
				mostrarindicativoPreteritoImperfecto="<h3>Pret�rito imperfecto</h3>"+mostrarindicativoPreteritoImperfecto;
				
				
				indicativoPreteritoIndefinido v5=new indicativoPreteritoIndefinido( verboInfinitivoSeleccionado, 0);
				String mostrarindicativoPreteritoIndefinido=v5.getFormaConjugadaEnriquecidaString();
				mostrarindicativoPreteritoIndefinido="<h3>Pret�rito perfecto simple</h3>"+mostrarindicativoPreteritoIndefinido;
				
				indicativoPreteritoAnterior v6=new indicativoPreteritoAnterior( verboInfinitivoSeleccionado, 0);
				String mostrarindicativoPreteritoAnterior=v6.getFormaConjugadaEnriquecidaString();
				mostrarindicativoPreteritoAnterior="<h3>Pret�rito anterior</h3><br>"+mostrarindicativoPreteritoAnterior;
				
				indicativoFuturoImperfecto v7=new indicativoFuturoImperfecto( verboInfinitivoSeleccionado, 0);
				String mostrarindicativoFuturoImperfecto=v7.getFormaConjugadaEnriquecidaString();
				mostrarindicativoFuturoImperfecto="<h3>Futuro imperfecto</h3>"+mostrarindicativoFuturoImperfecto;
		
				indicativoFuturoPerfecto v8=new indicativoFuturoPerfecto( verboInfinitivoSeleccionado, 0);
				String mostrarindicativoFuturoPerfecto=v8.getFormaConjugadaEnriquecidaString();
				mostrarindicativoFuturoPerfecto="<h3>Futuro perfecto</h3>"+mostrarindicativoFuturoPerfecto;
		
				indicativoCondicionalSimple v9=new indicativoCondicionalSimple( verboInfinitivoSeleccionado, 0);
				String mostrarindicativoCondicionalSimple=v9.getFormaConjugadaEnriquecidaString();
				mostrarindicativoCondicionalSimple="<h3>Condicional simple</h3>"+mostrarindicativoCondicionalSimple;
		
				indicativoCondicionalCompuesto v10=new indicativoCondicionalCompuesto( verboInfinitivoSeleccionado, 0);
				String mostrarindicativoCondicionalCompuesto=v10.getFormaConjugadaEnriquecidaString();
				mostrarindicativoCondicionalCompuesto="<h3>Condicional compuesto</h3><br>"+mostrarindicativoCondicionalCompuesto;
		
		
				
				
				editorPane.setContentType("text/html");
				editorPane.setEditable(false); // bloqueamos edicion

				// visualizamos en objeto JEditorPane
				String mostrar="";
				mostrar=cabecera+celdaInicio+mostrarIndicativoPresenten+celdaFin+celdaInicio+mostrarIndicativoPreteritoPerfecto+celdaFin+separaFila+
						celdaInicio+mostrarindicativoPreteritoImperfecto+celdaFin+celdaInicio+mostrarindicativoPreteritoPluscuamperfecto+celdaFin+separaFila+
						celdaInicio+mostrarindicativoPreteritoIndefinido+celdaFin+celdaInicio+mostrarindicativoPreteritoAnterior+celdaFin+separaFila+separaFila+
						celdaInicio+mostrarindicativoFuturoImperfecto+celdaFin+celdaInicio+mostrarindicativoFuturoPerfecto+celdaFin+separaFila+separaFila+
				        celdaInicio+mostrarindicativoCondicionalSimple+celdaFin+celdaInicio+mostrarindicativoCondicionalCompuesto+celdaFin+separaFila+separaFila+pie;

				editorPane.setText(mostrar );
				editorPane.setCaretPosition(0); // para que se posicione el scroll arriba del todo

				/*  referencia de la tabla
                 <table style=�border: hidden�><tbody style=�border: hidden�><tr style=�border: hidden�>
                    <td style=�border: hidden�>1a</td>
                    <td style=�border: hidden�>2a</td>
                </tr>
                    <tr style=�border: hidden�>1b</td>
                    <td style=�border: hidden�>2b</td>
                <td style=�border: hidden�></tbody></table>
			 */

			}
		});
		comboBox.setMaximumRowCount(25);





        // menus
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnRegulares = new JMenu("regulares");
		menuBar.add(mnRegulares);

		// Selecionamos todos los verbos regulares que empiezan por A
		JMenuItem mntmA = new JMenuItem("A");
		mntmA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("Seleccione verbo regular (que empiezen por A)");
				fichEntrada.setNombreFichero("a_verbosRegulares_ver2.txt");
				getCargarFicheroEnComboBox(); 
				String tit=mntmA.getText();
				mntmA.setText(tit+" - " + comboBox.getItemCount()+"");
			}
		});
		mnRegulares.add(mntmA);


		// Selecionamos todos los verbos regulares que empiezan por B
		JMenuItem mntmB = new JMenuItem("B");
		mntmB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("Seleccione verbo regular (que empiezen por B)");
     			fichEntrada.setNombreFichero("b_verbosRegulares.txt");
				getCargarFicheroEnComboBox(); 
				String tit=mntmB.getText();
				mntmB.setText(tit+" - " + comboBox.getItemCount()+"");

			}
		});
		mnRegulares.add(mntmB);
		
		


		JMenuItem mntmC = new JMenuItem("C");
		mntmC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("Seleccione verbo regular (que empiezen por C)");
     			fichEntrada.setNombreFichero("c_verbosRegulares.txt");
				getCargarFicheroEnComboBox();
				String tit=mntmC.getText();
				mntmC.setText(tit+" - " + comboBox.getItemCount()+"");

			}
		});
		mnRegulares.add(mntmC);

		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("D");
		mnRegulares.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("E");
		mnRegulares.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("F");
		mnRegulares.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("G");
		mnRegulares.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("H");
		mnRegulares.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("I");
		mnRegulares.add(mntmNewMenuItem_7);


		JMenu mnIrregulares = new JMenu("irregulares");
		menuBar.add(mnIrregulares);

		JMenu mnAuxiliares = new JMenu("auxiliares");
		menuBar.add(mnAuxiliares);



		// panel

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox.setBounds(347, 11, 171, 20);
		contentPane.add(comboBox);
		
		


		lblNewLabel.setBounds(43, 11, 293, 14);
		contentPane.add(lblNewLabel);

		JLabel lblIndicativo = new JLabel("INDICATIVO");
		lblIndicativo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIndicativo.setBounds(43, 55, 105, 14);
		contentPane.add(lblIndicativo);

		scrollPane.setBounds(27, 75, 300, 450);
		contentPane.add(scrollPane);


		scrollPane.setViewportView(editorPane);
		//scrollPane.setRowHeader(null);


		editorPane.setBackground(new Color(240, 248, 255));
		
		textPane.setBounds(336, 42, 261, 81);
		contentPane.add(textPane);
	


	} // fin de metodo
	
	public void getCargarFicheroEnComboBox() {
		String lecturalinea="";
		StringTokenV2 cad = null;
		
		if (fichEntrada.abrirFicheroModoLectura()) {

		    if ( comboBox.getItemCount()>0 ) { // si tiene items
			    comboBox.removeAllItems();  //Borramos los datos anteriores del comboBox
		    }

	    	while ( true  ) {
	    		 lecturalinea = fichEntrada.leerSiguienteLinea();
	    		  if (lecturalinea.equals("final") ) {
	    			break;
	    		 }else {
	    			 cad = new StringTokenV2(lecturalinea,"=");
	    			comboBox.addItem(cad.getToken(1));
	    			verboYdefinicion.put(cad.getToken(1), cad.getToken(3));
	    		 }
	    	} // fin de while
	    } // fin de if
	}
	
	
} // fin de clase
