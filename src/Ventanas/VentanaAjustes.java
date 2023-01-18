package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Data.Usuario;

public class VentanaAjustes extends JFrame {
	
	public VentanaAjustes(Usuario u) {
		
		// ConfiguraciÃ³n de la ventana.
		setTitle("Ventana ajustes");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// CreaciÃ³n de contenedores de la ventana y su configuraciÃ³n.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(1,4));
		JPanel pSur = new JPanel();
		pSur.setLayout(new FlowLayout());
		
		// CreaciÃ³n de componentes de la ventana y su configuraciÃ³n.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pPanelVacio1 = new JPanel();
		JPanel pPanelVacio2 = new JPanel();
		JPanel pPanelVacio3 = new JPanel();
		JPanel pPanelVacio4 = new JPanel();
		JButton btnRegistrarse = new JButton("AtrÃ¡s");
		JButton btnCambiarContrasenya = new JButton("Cambiar contraseÃ±a");
		JButton btnCambiarEmail = new JButton("Cambiar email");
		JButton btnCambiarMetodosPago = new JButton("Cambiar mÃ©todos de pago");
		JButton btnAceptar = new JButton("Aceptar");
		
		// AsignaciÃ³n de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnRegistrarse);
		pCentro.add(btnCambiarContrasenya);
		pCentro.add(btnCambiarEmail);
		pCentro.add(btnCambiarMetodosPago);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// ConfiguraciÃ³n de la ventana.
		setVisible(true);
		
		// ConfiguraciÃ³n de los eventos.
		
		btnCambiarContrasenya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaCambiarContrasenya vcc = new VentanaCambiarContrasenya(u);
			}
		});
		
		btnCambiarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaCambiarEmail vce = new VentanaCambiarEmail(u);
			}
		});
		
		btnCambiarMetodosPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaCambiarMetodosPago vp = new VentanaCambiarMetodosPago(u);
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaVerPerfil vvp = new VentanaVerPerfil(u);
			}
		});
		
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaUsuario vu = new VentanaUsuario(u);
			}
		});
		
	}

}
