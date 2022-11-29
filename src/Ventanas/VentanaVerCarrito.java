package Ventanas;

import java.awt.*;
import javax.swing.*;

import Data.Instrumento;

public class VentanaVerCarrito extends JFrame{
	
	public VentanaVerCarrito() {
		
		// Configuración de la ventana.
		setTitle("Ventana ver carrito");
		setSize(800, 600);
		setLocation(400, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Creación de contenedores de la ventana y su configuración.
		JPanel pNorte = new JPanel();
		pNorte.setLayout(new GridLayout(1,7));
		JPanel pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(2,1));
		JPanel pSur = new JPanel();
		pSur.setLayout(new FlowLayout());
		
		// Creación de componentes de la ventana y su configuración.
		JButton btnInicio = new JButton("Inicio");
		JPanel pNombreTienda = new JPanel();
		JButton btnVerPerfil = new JButton("Ver perfil");
		JPanel pVacio1 = new JPanel();
		JButton btnDesconectarse = new JButton("Desconectarse");
		JLabel lEnElCarrito = new JLabel("En el carrito:");
		//TODO
		//Dar formato a la lista
		JList<Instrumento> JLEnElCarrito = new JList<>();
		JButton btnComprar = new JButton("Comprar");
		JButton btnEliminarProducto = new JButton("Eliminar producto");
		
		// Asignación de los componentes a los contenedores.
		pNorte.add(btnInicio);
		pNorte.add(pNombreTienda);
		pNorte.add(pVacio1);
		pNorte.add(btnVerPerfil);
		pNorte.add(btnDesconectarse);
		pCentro.add(lEnElCarrito);
		pCentro.add(JLEnElCarrito);
		pSur.add(btnComprar);
		pSur.add(btnEliminarProducto);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
		// Configuración de la ventana.
		setVisible(true);
		
		// Configuración de los eventos.
		
	}

}

