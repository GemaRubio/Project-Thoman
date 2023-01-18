package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Data.Usuario;

public class VentanaCambiarContrasenya extends JFrame {
	
	public VentanaCambiarContrasenya(Usuario u) {
		
		// ConfiguraciÃ³n de la ventana.
		setTitle("Ventana cambiar contraseÃ±a");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// CreaciÃ³n de contenedores de la ventana y su configuraciÃ³n.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(3,3));
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
		
		JLabel lContrasenyaActual = new JLabel("ContraseÃ±a actual:");
		JPasswordField txtContrasenyaActual = new JPasswordField();
		JLabel lErrorContrasenyaActual = new JLabel("La contraseÃ±a no es correcta.");
		lErrorContrasenyaActual.setForeground(Color.RED);
		lErrorContrasenyaActual.setVisible(false);
		JLabel lContrasenyaNueva = new JLabel("ContraseÃ±a nueva:");
		JPasswordField txtContrasenyaNueva = new JPasswordField();
		JPanel pPanelVacio5 = new JPanel();
		JLabel lContrasenyaRepetir = new JLabel("Repite la contraseÃ±a nueva:");
		JPasswordField txtContrasenyaRepetir = new JPasswordField();
		JLabel lErrorContrasenyaRepetir = new JLabel("La contraseÃ±a no coincide.");
		lErrorContrasenyaRepetir.setForeground(Color.RED);
		lErrorContrasenyaRepetir.setVisible(false);
		JButton btnAceptar = new JButton("Aceptar");
		
		// AsignaciÃ³n de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnRegistrarse);
		pCentro.add(lContrasenyaActual);
		pCentro.add(txtContrasenyaActual);
		pCentro.add(lErrorContrasenyaActual);
		pCentro.add(lContrasenyaNueva);
		pCentro.add(txtContrasenyaNueva);
		pCentro.add(pPanelVacio5);
		pCentro.add(lContrasenyaRepetir);
		pCentro.add(txtContrasenyaRepetir);
		pCentro.add(lErrorContrasenyaRepetir);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// ConfiguraciÃ³n de la ventana.
		setVisible(true);
		
		// ConfiguraciÃ³n de los eventos.
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtContrasenyaActual.getText() == u.getContrasenya()) {
					if(txtContrasenyaNueva.getText().length() > 3 && txtContrasenyaNueva.getText().equals(txtContrasenyaRepetir)) {
						u.setEmail(txtContrasenyaNueva.getText());
						JOptionPane.showMessageDialog(null, "Contrasenya cambiada con exito");
						VentanaAjustes va = new VentanaAjustes(u);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "La contrasenya no es valida o no coincide");
					}
				} else {
					lErrorContrasenyaActual.show();
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
