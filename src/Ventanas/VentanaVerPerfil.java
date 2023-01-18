package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Data.Instrumento;
import Data.Usuario;

public class VentanaVerPerfil extends JFrame {
	
	public VentanaVerPerfil(Usuario u) {
		
		// ConfiguraciÃ³n de la ventana.
		setTitle("Ventana ver perfil");
		setSize(800, 600);
		setLocation(400, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// CreaciÃ³n de contenedores de la ventana y su configuraciÃ³n.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(6,1));
		JPanel pSur = new JPanel();
		pSur.setLayout(new GridLayout(1,3));
		
		// CreaciÃ³n de componentes de la ventana y su configuraciÃ³n.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pVacio1 = new JPanel();
		JButton btnVerCarrito = new JButton("Ver carrito");
		JButton btnDesconectarse = new JButton("Desconectarse");
		JLabel lUsuario = new JLabel("Usuario: " + "  " + u.getNombre());
		JLabel lContrasenya = new JLabel("ContraseÃ±a: " + "  " + u.getContrasenya());
		JLabel lEmail = new JLabel("Email: " + "  " + u.getEmail());
		JLabel lSaldo = new JLabel("Saldo: " + "  " + u.getSaldo());
		//TODO METODOS DE PAGO
		JLabel lComprasRealizadas = new JLabel("Compras realizadas:");
		JButton btnServicioDeAyuda = new JButton("Servicio de ayuda");
		JButton btnAjustes = new JButton("Ajustes");
		
		JList<Instrumento> jlComprasRealizadas = new JList<Instrumento>();
		DefaultListModel<Instrumento> modeloInstrumentos = new DefaultListModel<Instrumento>();
		
		jlComprasRealizadas.setModel(modeloInstrumentos);
		jlComprasRealizadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lAnyadirSaldo = new JLabel("AÃ±adir saldo:");
		JTextField txtAnyadirSaldo = new JTextField();
		JButton btnAnyadirSaldo = new JButton("AÃ±adir saldo");
		
		// AsignaciÃ³n de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pVacio1);
		pNorte.add(btnVerCarrito);
		pNorte.add(btnDesconectarse);
		pCentro.add(lUsuario);
		pCentro.add(lContrasenya);
		pCentro.add(lEmail);
		pCentro.add(lSaldo);
		pCentro.add(lComprasRealizadas);
		pCentro.add(jlComprasRealizadas);
		pSur.add(lAnyadirSaldo);
		pSur.add(txtAnyadirSaldo);
		pSur.add(btnAnyadirSaldo);
		pSur.add(btnServicioDeAyuda);
		pSur.add(btnAjustes);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// ConfiguraciÃ³n de la ventana.
		setVisible(true);
		
		// ConfiguraciÃ³n de los eventos.
		btnServicioDeAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaServicioAyuda vp = new VentanaServicioAyuda(u);
			}
		});
		
		btnAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaAjustes va = new VentanaAjustes(u);
			}
		});
		
		btnAnyadirSaldo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtAnyadirSaldo.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Cantidad de saldo incorrecta");
				} else {
					JOptionPane.showMessageDialog(null, "Saldo anyadido correctamente");
				}
				
			}
		});
		
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaUsuario vu = new VentanaUsuario(u);
			}
		});
		
		btnDesconectarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logout realizado con exito");
				dispose();
				VentanaPrincipal vp = new VentanaPrincipal();
			}
		});
		
		btnVerCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaVerCarrito vu = new VentanaVerCarrito(u);
			}
		});
		
	}

}

