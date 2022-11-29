package Ventanas;

import javax.swing.*;
import java.awt.*;
import Data.Instrumento;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal() {
		
		// Configuración de la ventana.
		setTitle("Menú principal");
		setSize(1100, 800);
		setLocation(275, 0);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(1,2));
		JPanel pOeste = new JPanel();
		pOeste.setLayout(new GridLayout(11,1));
		JPanel pSur = new JPanel();
		pSur.setLayout(new FlowLayout());

		// Creación de componentes de la ventana y su configuración.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pPanelVacio1 = new JPanel();
		JPanel pPanelVacio2 = new JPanel();
		JPanel pPanelVacio3 = new JPanel();
		JButton btnRegistrarse = new JButton("Registrarse");
		JButton btnLogin = new JButton("Login");
		
		JLabel lFiltros = new JLabel("Filtros:");
		JButton btnBuscar = new JButton("Buscar");
		ButtonGroup bgTipoInstrumento = new ButtonGroup();
		JRadioButton rBtnCuerda = new JRadioButton("Cuerda");
		JRadioButton rBtnViento = new JRadioButton("Viento");
		JRadioButton rBtnPercusion = new JRadioButton("Percusion");
		JLabel lPrecio = new JLabel("Precio:");
		JSlider sPrecio = new JSlider(0, 10000, 10000);
		sPrecio.setMajorTickSpacing(2000);
		sPrecio.setMinorTickSpacing(1000);
		sPrecio.setPaintTicks(true);
		sPrecio.setPaintLabels(true);
		
		JLabel lMarcas = new JLabel("Marcas:");
		CheckboxGroup gCbMarcas = new CheckboxGroup();
		JCheckBox cbGibson = new JCheckBox("Gibson");
		JCheckBox cbThomann = new JCheckBox("Thomann");
		JButton btnQuitarFiltros = new JButton("Quitar filtros");
		
		//TODO
		//Dar formato a la JLIST
		JList<Instrumento> JListaIntrumentos = new JList<>();	// JList de instrumentos.
		
		JButton btnAnyadirAlCarrito= new JButton("Añadir al carrito");
		

		// Asignación de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(btnRegistrarse);
		pNorte.add(btnLogin);
		
		pOeste.add(lFiltros);
		pOeste.add(btnBuscar);
		pOeste.add(rBtnCuerda);
		pOeste.add(rBtnViento);
		pOeste.add(rBtnPercusion);
		pOeste.add(lPrecio);
		pOeste.add(sPrecio);
		pOeste.add(lMarcas);
		pOeste.add(cbGibson);
		pOeste.add(cbThomann);
		pOeste.add(btnQuitarFiltros);
		
		pCentro.add(JListaIntrumentos);
		
		pCentro.add(btnAnyadirAlCarrito);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pOeste, BorderLayout.WEST);
		add(pSur, BorderLayout.SOUTH);

		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
	}
		
}
