package Ventanas;

import java.awt.*;
import javax.swing.*;
import Data.Instrumento;

public class VentanaVerPerfil extends JFrame{
	
	public VentanaVerPerfil() {
		
		// Configuración de la ventana.
		setTitle("Ventana ver perfil");
		setSize(800, 600);
		setLocation(400, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(6,1));
		JPanel pSur = new JPanel();
		pSur.setLayout(new GridLayout(1,3));
		
		// Creación de componentes de la ventana y su configuración.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JPanel pVacio1 = new JPanel();
		JButton btnVerCarrito = new JButton("Ver carrito");
		JButton btnDesconectarse = new JButton("Desconectarse");
		JLabel lUsuario = new JLabel("Usuario: ");
		JLabel lContrasenya = new JLabel("Contraseña: ");
		JLabel lEmail = new JLabel("Email: ");
		JLabel lSaldo = new JLabel("Saldo: ");
		//TODO METODOS DE PAGO
		JLabel lComprasRealizadas = new JLabel("Compras realizadas:");
		
		JList<Instrumento> jlComprasRealizadas = new JList<Instrumento>();
		DefaultListModel<Instrumento> modeloInstrumentos = new DefaultListModel<Instrumento>();
		
		jlComprasRealizadas.setModel(modeloInstrumentos);
		jlComprasRealizadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lAnyadirSaldo = new JLabel("Añadir saldo:");
		JTextField txtAnyadirSaldo = new JTextField();
		JButton btnAnyadirSaldo = new JButton("Añadir saldo");
		
		// Asignación de los componentes a los contenedores.
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
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
		
	}

}

