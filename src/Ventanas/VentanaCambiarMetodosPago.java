package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Data.Usuario;

public class VentanaCambiarMetodosPago extends JFrame {
	
	public VentanaCambiarMetodosPago(Usuario u) {
		
		// ConfiguraciÃ³n de la ventana.
		setTitle("Ventana cambiar mÃ©todos de pago");
		setSize(750, 300);
		setLocation(450, 250);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// CreaciÃ³n de contenedores de la ventana y su configuraciÃ³n.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(4,2));
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
		
		JLabel lCuentaPaypal = new JLabel("NÃºmero de cuenta de PayPal:");
		JTextField txtCuentaPaypal = new JTextField();
		JLabel lErrorCuentaPaypal = new JLabel("Cuenta de Paypal incorrecta");
		JLabel lNTarjeta = new JLabel("NÃºmero de tarjeta:");
		JTextField txtNTarjeta = new JTextField();
		JLabel lErrorNTarjeta = new JLabel("Numero de tarjeta incorrecto");
		JLabel lCaducidadTarjeta = new JLabel("Fecha de caducidad de la tarjeta:");
		JTextField txtCaducidadTarjeta = new JTextField();
		JLabel lErrorCaducidadTarjeta = new JLabel("Numero de tarjeta incorrecto");
		JLabel lCodigoTarjeta = new JLabel("CÃ³digo de la tarjeta:");
		JTextField txtCodigoTarjeta = new JTextField();
		JLabel lErrorCodigoTarjeta = new JLabel("Numero de tarjeta incorrecto");
		lErrorCuentaPaypal.setForeground(Color.RED);
		lErrorCuentaPaypal.setVisible(false);
		lErrorNTarjeta.setForeground(Color.RED);
		lErrorNTarjeta.setVisible(false);
		lErrorCaducidadTarjeta.setForeground(Color.RED);
		lErrorCaducidadTarjeta.setVisible(false);
		lErrorCodigoTarjeta.setForeground(Color.RED);
		lErrorCodigoTarjeta.setVisible(false);
		

		JButton btnAceptar = new JButton("Aceptar");
		
		// AsignaciÃ³n de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pPanelVacio1);
		pNorte.add(pPanelVacio2);
		pNorte.add(pPanelVacio3);
		pNorte.add(pPanelVacio4);
		pNorte.add(btnRegistrarse);
		pCentro.add(lCuentaPaypal);
		pCentro.add(txtCuentaPaypal);
		pCentro.add(lNTarjeta);
		pCentro.add(txtNTarjeta);
		pCentro.add(lCaducidadTarjeta);
		pCentro.add(txtCaducidadTarjeta);
		pCentro.add(lCodigoTarjeta);
		pCentro.add(txtCodigoTarjeta);
		pSur.add(btnAceptar);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// ConfiguraciÃ³n de la ventana.
		setVisible(true);
		
		// ConfiguraciÃ³n de los eventos.
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCuentaPaypal.getText().length() > 0) {
					u.setCuentaPaypal(txtCuentaPaypal.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Cuenta de Paypal incorrecta");
				}
				if(txtNTarjeta.getText().length() < 16) {
					JOptionPane.showMessageDialog(null, "Numero de tarjeta no valido");
				} else {
					u.setnTarjeta(txtNTarjeta.getText());
				}
				if(txtCaducidadTarjeta.getText().contains("/")) {
					u.setCaducidadTarjeta(txtCaducidadTarjeta.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Caducidad de tarjeta no valida");
				}
				if(txtCodigoTarjeta.getText().length() == 3) {
					u.setCodigoTarjeta(txtCodigoTarjeta.getText());
					JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Codigo de tarjeta no valido");
				}
			}
		});
		
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaUsuario vp = new VentanaUsuario(u);
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaAjustes va = new VentanaAjustes(u);
			}
		});
	}

}
