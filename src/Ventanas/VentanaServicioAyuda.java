package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Data.Usuario;

public class VentanaServicioAyuda extends JFrame{
	
	public VentanaServicioAyuda(Usuario u) {
		
		// ConfiguraciÃ³n de la ventana.
		setTitle("Ventana servicio de ayuda");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// CreaciÃ³n de contenedores de la ventana y su configuraciÃ³n.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(2,1));
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
		
		JLabel lProblem = new JLabel("Escriba su problema:");
		JTextArea taProblem = new JTextArea();
		JButton btnEnviar = new JButton("Enviar");
		
		// AsignaciÃ³n de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnRegistrarse);
		pCentro.add(lProblem);
		pCentro.add(taProblem);
		pSur.add(btnEnviar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// ConfiguraciÃ³n de la ventana.
		setVisible(true);
		
		// ConfiguraciÃ³n de los eventos.
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaUsuario vu = new VentanaUsuario(u);
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaVerPerfil vp = new VentanaVerPerfil(u);
			}
		});
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(taProblem.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo esta vacio");
				} else {
					JOptionPane.showMessageDialog(null, "Su problema se ha enviado");
					dispose();
				}
			}
		});
	
		
	}

}
