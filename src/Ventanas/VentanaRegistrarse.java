package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.*;

import Data.Instrumento;
import Data.Usuario;

public class VentanaRegistrarse  extends JFrame{

	public VentanaRegistrarse() {
		
		// Configuración de la ventana.
		setTitle("Ventana registrarse");
		setSize(750, 300);
		setLocation(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(4,3));
		JPanel pSur = new JPanel();
		pSur.setLayout(new FlowLayout());

		// Creación de componentes de la ventana y su configuración.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pPanelVacio1 = new JPanel();
		JPanel pPanelVacio2 = new JPanel();
		JPanel pPanelVacio3 = new JPanel();
		JPanel pPanelVacio4 = new JPanel();
		JButton btnLogin = new JButton("Login");
		
		JLabel lUsuario = new JLabel("Usuario:");
		JTextField txtUsuario = new JTextField();
		JLabel lErrorUsuario = new JLabel("El nombre está escogido o está vacío");
		lErrorUsuario.setForeground(Color.RED);
		lErrorUsuario.setVisible(false);
		JLabel lEmail = new JLabel("Email:");
		JTextField txtEmail = new JTextField();
		JLabel lErrorEmail = new JLabel("El email está en uso o está vacío");
		lErrorEmail.setForeground(Color.RED);
		lErrorEmail.setVisible(false);
		JLabel lContrasenya = new JLabel("Contraseña:");
		JPasswordField txtContrasenya = new JPasswordField();
		JLabel lErrorContrasenya = new JLabel("La contraseña no coincide o está vacía");
		lErrorContrasenya.setForeground(Color.RED);
		lErrorContrasenya.setVisible(false);
		JLabel lRepetirContrasenya = new JLabel("Repetir contraseña:");
		JPasswordField txtRepetirContrasenya = new JPasswordField();
		JLabel lErrorContrasenya2 = new JLabel("La contraseña no coincide o está vacía");
		lErrorContrasenya2.setForeground(Color.RED);
		lErrorContrasenya2.setVisible(false);
		JButton btnAceptar = new JButton("Aceptar");

		// Asignación de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnLogin);

		pCentro.add(lUsuario);
		pCentro.add(txtUsuario);
		pCentro.add(lErrorUsuario);
		pCentro.add(lEmail);
		pCentro.add(txtEmail);
		pCentro.add(lErrorEmail);
		pCentro.add(lContrasenya);
		pCentro.add(txtContrasenya);
		pCentro.add(lErrorContrasenya);
		pCentro.add(lRepetirContrasenya);
		pCentro.add(txtRepetirContrasenya);
		pCentro.add(lErrorContrasenya2);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);

		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
		
		//Boton Aceptar 
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("src\\Files\\ficheroUsuarios.dat");
				Usuario guardarUsuario = new Usuario(txtUsuario.getText(), txtContrasenya.getText(), txtEmail.getText(), 0, "", "", "", "", new ArrayList<Instrumento>());
				boolean registrado = false;
				//Empieza a leer fichero
				try {
					FileInputStream fis = new FileInputStream(f);
					ObjectInputStream ois = new ObjectInputStream(fis);
					Object u = ois.readObject();
					if(u instanceof Usuario) {
						if(((Usuario) u).getNombre().equals(txtUsuario.getText()) || (((Usuario) u).getEmail().equals(txtEmail.getText()))) {
							registrado = true;
							lErrorUsuario.show();
							lErrorEmail.show();
						}
					}
					while(u != null && registrado == false) { 
						if(u instanceof Usuario) {
							if(((Usuario) u).getNombre().equals(txtUsuario.getText()) || (((Usuario) u).getEmail().equals(txtEmail.getText()))) {
								registrado = true;
								lErrorUsuario.show();
								lErrorEmail.show();
							}
						}
						u = ois.readObject();
					} 
					ois.close();
					fis.close();
				 
				} catch(IOException | ClassNotFoundException ex) {
					System.out.println("Fin de fichero");
				} //Aqui acaba leer en fichero
				
				//Empieza escribir en fichero
				try {
					FileOutputStream fos = new FileOutputStream(f, true);
					AnyadirUsuario oos = new AnyadirUsuario(fos);
					if(registrado == false) {
						if(txtUsuario.getText().length() < 3 | txtContrasenya.getText().length() < 3) {
							JOptionPane.showMessageDialog(null, "Usuario o contrasenya no validos");
						} else {
							if(txtEmail.getText().contains("@") && txtEmail.getText().contains(".com")) {
								if(txtContrasenya.getText().equals(txtRepetirContrasenya.getText())) {
									oos.writeObject(guardarUsuario);
									oos.close();
									fos.close();
									dispose();
									JOptionPane.showMessageDialog(null, "Registro realizado con exito");
									//Hay que añadir la ventana principal del usuario 
								} else {
									lErrorContrasenya.show();
									lErrorContrasenya2.show();
								}
							} else {
								JOptionPane.showMessageDialog(null, "Introduzca un e-mail valido");
							}
						}
					} else {
						lErrorUsuario.show();
					}
				} catch(IOException ex) {
					ex.printStackTrace();
				} //Aqui acaba escribir en fichero
			}
		});

		//Boton Inicio
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal vp = new VentanaPrincipal();
			}
		});
		
		//Boton Login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaLogin vl = new VentanaLogin();
			}
		});
		
	}

}

