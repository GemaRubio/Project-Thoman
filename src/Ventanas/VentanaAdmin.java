package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Data.Usuario;

public class VentanaAdmin extends JFrame{
	
	public VentanaAdmin(Usuario u) {
		
		// ConfiguraciÃ³n de la ventana.
		setTitle("Ventana administrador");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// CreaciÃ³n de contenedores de la ventana y su configuraciÃ³n.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(1,4));
		
		// CreaciÃ³n de componentes de la ventana y su configuraciÃ³n.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pPanelVacio1 = new JPanel();
		JPanel pPanelVacio2 = new JPanel();
		JPanel pPanelVacio3 = new JPanel();
		JPanel pPanelVacio4 = new JPanel();
		
		JButton btnComprar = new JButton("Comprar");
		JButton btnCodigoFuente = new JButton("CÃ³digo fuente");
		JButton btnVerBaseDatos = new JButton("Ver base de datos");
		JButton btnVerFicheros = new JButton("Ver ficheros");
		
		// AsignaciÃ³n de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pCentro.add(btnComprar);
		pCentro.add(btnCodigoFuente);
		pCentro.add(btnVerBaseDatos);
		pCentro.add(btnVerFicheros);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		
		// ConfiguraciÃ³n de la ventana.
		setVisible(true);
		
		// ConfiguraciÃ³n de los eventos.
		btnComprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaUsuario vp = new VentanaUsuario(u);
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
