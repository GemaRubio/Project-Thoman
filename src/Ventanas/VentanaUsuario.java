package Ventanas;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;

import Data.Instrumento;
import Data.TipoInstrumento;
import Data.Usuario;

public class VentanaUsuario extends JFrame {
	
	public VentanaUsuario(Usuario u){
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
				JButton btnVerPerfil = new JButton("Ver Perfil");
				JButton btnVerCarrito = new JButton("Ver Carrito");
				JButton btnLogout = new JButton("Logout");
				
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
					String dburl = "jdbc:sqlite:Project-Thoman-Master/src\\Db\\Instrumentos.db";
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
				pNorte.add(btnVerCarrito);
				pNorte.add(btnVerPerfil);
				pNorte.add(btnLogout);
				
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
						VentanaUsuario vu = new VentanaUsuario(u);
					}
				});
				
				// Evento Registrarse
				btnVerCarrito.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						VentanaVerCarrito vc = new VentanaVerCarrito();
						}
				});
				
				//Evento Login
				btnLogout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						VentanaPrincipal vp = new VentanaPrincipal();
					}
				});
				
				btnVerPerfil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						VentanaVerPerfil vvp = new VentanaVerPerfil(u);
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
						
						//Se eliminan todos los elementos del modelo de lista.
						mlInstrumento.removeAllElements();
						
						//Se crea el ArrayList vacío para que cada vez que se pulse buscar la lista de instrumentos filtrados siempre esté vacía.
						ArrayList<Instrumento> filtrados = new ArrayList<Instrumento>();
						
						/*
						Según los botones que estén seleccionados y si cumple los requisitos el instrumento, se añadirá a lista de filtrados.
						
						Este algoritmo funciona de la siguiente manera:
						Si no hay ningún botón seleccionado se muestran todos los instrumentos, por el contrario, con que haya un botón seleccionado o más
						empieza a buscar las posibles combinaciones de los botones hasta encontrara la correcta, despues se analizan las caracteristicas de
						cada instrumento si son las correctas se añaden a la lista de filtrados. Finalmente esta lista se pasará como modelo de lista para 
						poder ser mostrada en la JList.
						*/
						if (rBtnCuerda.isSelected() == true || rBtnViento.isSelected() == true || rBtnPercusion.isSelected() == true 
								|| cbGibson.isSelected() == true || cbThomann.isSelected() == true  || sPrecio.getValue() >= 0) {
							for (Instrumento i : instrumentos) {
								if (i.getPrecio() <= sPrecio.getValue()) {
							
									if (rBtnCuerda.isSelected() == true && rBtnViento.isSelected() == true && rBtnPercusion.isSelected() == true 
									&& cbGibson.isSelected() == true && cbThomann.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)
											|| i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) && (i.getMarca().equals(cbGibson.getText())
											|| i.getMarca().equals(cbThomann.getText()))) {
										filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && rBtnViento.isSelected() == true && rBtnPercusion.isSelected() == true 
											&& cbGibson.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)
											|| i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}	
									} else if (rBtnCuerda.isSelected() == true && rBtnViento.isSelected() == true && rBtnPercusion.isSelected() == true 
											&& cbThomann.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)
											|| i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) && i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}	
									} else if (rBtnCuerda.isSelected() == true && rBtnViento.isSelected() == true && cbGibson.isSelected() == true
											&& cbThomann.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)) 
											&& (i.getMarca().equals(cbGibson.getText()) || i.getMarca().equals(cbThomann.getText()))) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && rBtnPercusion.isSelected() == true && cbGibson.isSelected() == true
											&& cbThomann.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) 
											&& (i.getMarca().equals(cbGibson.getText()) || i.getMarca().equals(cbThomann.getText()))) {
											filtrados.add(i);
										}	
									} else if (rBtnViento.isSelected() == true && rBtnPercusion.isSelected() == true && cbGibson.isSelected() == true
											&& cbThomann.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) || i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) 
											&& (i.getMarca().equals(cbGibson.getText()) || i.getMarca().equals(cbThomann.getText()))) {
											filtrados.add(i);
										}	
									} else if (rBtnCuerda.isSelected() == true && rBtnViento.isSelected() == true && rBtnPercusion.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)
											|| i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && rBtnViento.isSelected() == true && cbGibson.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)
											) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && rBtnViento.isSelected() == true && cbThomann.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)
											) && i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && rBtnPercusion.isSelected() == true && cbGibson.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)
											) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && rBtnPercusion.isSelected() == true && cbThomann.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)
											) && i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && cbGibson.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) && (i.getMarca().equals(cbGibson.getText())
											|| i.getMarca().equals(cbThomann.getText()))) {
											filtrados.add(i);
										}
									} else if (rBtnViento.isSelected() == true && rBtnPercusion.isSelected() == true && cbGibson.isSelected() == true) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) || i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)
											) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnViento.isSelected() == true && cbGibson.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) && (i.getMarca().equals(cbGibson.getText())
											|| i.getMarca().equals(cbThomann.getText()))) {
											filtrados.add(i);
										}
									} else if (rBtnPercusion.isSelected() == true && cbGibson.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION) && (i.getMarca().equals(cbGibson.getText())
											|| i.getMarca().equals(cbThomann.getText()))) {
											filtrados.add(i);
										}
									}  else if (rBtnViento.isSelected() == true && rBtnPercusion.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) || i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) {
											filtrados.add(i);
										}
									} else if (rBtnViento.isSelected() == true && cbGibson.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnViento.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) && i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnPercusion.isSelected() == true && cbGibson.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnPercusion.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION) && i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && rBtnViento.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && rBtnPercusion.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && cbGibson.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) && i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnViento.isSelected() == true && rBtnPercusion.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) || i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) {
											filtrados.add(i);
										}
									} else if (rBtnViento.isSelected() == true && cbGibson.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnViento.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.VIENTO) && i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnPercusion.isSelected() == true && cbGibson.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION) && i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnPercusion.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION) && i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (cbGibson.isSelected() == true && cbThomann.isSelected() == true) {
										if (i.getMarca().equals(cbGibson.getText()) || i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.CUERDA)) {
											filtrados.add(i);
										}
									} else if (rBtnViento.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)) {
											filtrados.add(i);
										}
									} else if (rBtnPercusion.isSelected() == true) {
										if (i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) {
											filtrados.add(i);
										}
									} else if (cbGibson.isSelected() == true) {
										if (i.getMarca().equals(cbGibson.getText())) {
											filtrados.add(i);
										}
									} else if (cbThomann.isSelected() == true) {
										if (i.getMarca().equals(cbThomann.getText())) {
											filtrados.add(i);
										}
									} else if (rBtnCuerda.isSelected() == false || rBtnViento.isSelected() == false || rBtnPercusion.isSelected() == false 
											|| cbGibson.isSelected() == false || cbThomann.isSelected() == false) {
										if ((i.getTipoInstrumento().equals(TipoInstrumento.CUERDA) || i.getTipoInstrumento().equals(TipoInstrumento.VIENTO)
											|| i.getTipoInstrumento().equals(TipoInstrumento.PERCUSION)) && (i.getMarca().equals(cbGibson.getText())
											|| i.getMarca().equals(cbThomann.getText()))) {
											filtrados.add(i);
									}
								} 
							}
					}
					
						for (Instrumento instrumento : filtrados) {
							mlInstrumento.addElement(instrumento);
						}
					
					} else {
						for (Instrumento instrumento : instrumentos) {
							mlInstrumento.addElement(instrumento);
						}
					}
						//Se añade el modelo de instrumentos filtrados a la JList.
						JListaIntrumentos.setModel(mlInstrumento);
						JListaIntrumentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					}
				});
	}

}
