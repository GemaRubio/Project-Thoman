package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Data.Usuario;

public class VentanaCambiarEmail extends JFrame {
	
	public VentanaCambiarEmail(Usuario u) {
		
		// ConfiguraciÃ³n de la ventana.
		setTitle("Ventana cambiar email");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// CreaciÃ³n de contenedores de la ventana y su configuraciÃ³n.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(1,2));
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
		
		JLabel lEmail = new JLabel("Email: ");
		JTextField txtEmail = new JTextField();
		JButton btnAceptar = new JButton("Aceptar");
		
		// AsignaciÃ³n de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnRegistrarse);
		pCentro.add(lEmail);
		pCentro.add(txtEmail);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// ConfiguraciÃ³n de la ventana.
		setVisible(true);
		
		// ConfiguraciÃ³n de los eventos.
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtEmail.getText().contains("@") && txtEmail.getText().contains(".com")) {
					u.setEmail(txtEmail.getText());
					JOptionPane.showMessageDialog(null, "E.mail cambiado con exito");
					dispose();
					VentanaAjustes va = new VentanaAjustes(u);
				} else {
					JOptionPane.showMessageDialog(null, "E-mail no valido");
				}
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaAjustes va = new VentanaAjustes(u);
			}
		});
		
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaUsuario vp = new VentanaUsuario(u);
			}
		});
		
	}

}
