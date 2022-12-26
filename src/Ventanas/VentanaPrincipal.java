package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import Data.Instrumento;
import Data.TipoInstrumento;

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
		//Se crea un array de instrumentos vacio.
		ArrayList<Instrumento> instrumentos = new ArrayList<Instrumento>();
		//Se inicializa y se hace una consulta a la base de datos de todos los instrumentos para añadirlos al array de instrumentos.
		try 
		{
			Class.forName("org.sqlite.JDBC");
			String dburl = "jdbc:sqlite:src\\Db\\Instrumentos.db";
			Connection conexion = DriverManager.getConnection(dburl);
				 
			Statement Consulta = conexion.createStatement();
							   
			ResultSet rs = Consulta.executeQuery("SELECT * FROM Instrumentos");
			
			while(rs.next())
			 {
				 
				if (rs.getString(5).equals("CUERDA")) {
					Instrumento inst = new Instrumento(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), TipoInstrumento.CUERDA);
					instrumentos.add(inst);
				} else if (rs.getString(5).equals("VIENTO")) {
					Instrumento inst = new Instrumento(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), TipoInstrumento.VIENTO);
					instrumentos.add(inst);
				} else if (rs.getString(5).equals("PERCUSION")) {
					Instrumento inst = new Instrumento(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), TipoInstrumento.PERCUSION);
					instrumentos.add(inst);
				}
				
			 }
			 rs.close();
			
		} 
		catch (Exception e) 
		{
			System.err.println("Error al consultar o inicializar la base de datos" + e);
		}
		
		//Se añaden los instrumentos del arraylist instrumentos al modelo de la lista y el modelo a la Jlist
		JList<Instrumento> JListaIntrumentos = new JList<Instrumento>();	// JList de instrumentos.
		DefaultListModel<Instrumento> mlInstrumento = new DefaultListModel<Instrumento>();
		for (Instrumento i : instrumentos) {
			mlInstrumento.addElement(i);
		}
		JListaIntrumentos.setModel(mlInstrumento);
		JListaIntrumentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		
		//Evento Inicio
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp = new VentanaPrincipal();
			}
		});
		
		// Evento Registrarse
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaRegistrarse vr = new VentanaRegistrarse();
				}
		});
		
		//Evento Login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaLogin vl = new VentanaLogin();
			}
		});
		
		//Evento Quitar Filtro
		btnQuitarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rBtnCuerda.setSelected(false);
				rBtnViento.setSelected(false);
				rBtnPercusion.setSelected(false);
				sPrecio.setValue(10000);
				cbGibson.setSelected(false);
				cbThomann.setSelected(false);
				
			}
		});
		
		//Evento Anyadir al Carrito
		btnAnyadirAlCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Para poder anyadir al carrito tienes que iniciar sesion o registrarte");
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Selección individual
				if (rBtnCuerda.isSelected()) {
					
				} else if (rBtnViento.isSelected()) {
					
				} else if (rBtnPercusion.isSelected()) {
					
				} else if (cbGibson.isSelected()) {
					
				} else if (cbThomann.isSelected()) {
					
				} 
				//Selección dual
				else if (rBtnCuerda.isSelected() & rBtnViento.isSelected()) {
					
				} else if (rBtnCuerda.isSelected() & rBtnPercusion.isSelected()) {
					
				} else if (rBtnCuerda.isSelected() & cbGibson.isSelected()) {
					
				} else if (rBtnCuerda.isSelected() & cbThomann.isSelected()) {
					
				} else if (rBtnViento.isSelected() & rBtnPercusion.isSelected()) {
					
				} else if (rBtnViento.isSelected() & cbGibson.isSelected()) {
					
				} else if (rBtnViento.isSelected() & cbThomann.isSelected()) {
					
				} else if (rBtnPercusion.isSelected() & cbGibson.isSelected()) {
					
				} else if (rBtnPercusion.isSelected() & cbThomann.isSelected()) {
					
				}
				//Selección trial
				else if (rBtnCuerda.isSelected() & rBtnViento.isSelected() & rBtnPercusion.isSelected()) {
					
				} else if (rBtnCuerda.isSelected() & cbGibson.isSelected() & cbThomann.isSelected()) {
					
				}
			}
		});
	}
		
}
