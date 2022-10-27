package UD20_maven.UD20_ejercicio4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazGrafica4 extends JFrame {

	private JPanel contentPane;

	public InterfazGrafica4() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos los botones, casillas y textos necesarios.
		
		JLabel lblNewLabel = new JLabel("Eventos");
		lblNewLabel.setBounds(10, 121, 45, 13);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrTextoInicialn = new JTextArea();
		txtrTextoInicialn.setText("Texto inicial\n");
		txtrTextoInicialn.setBounds(51, 10, 375, 243);
		contentPane.add(txtrTextoInicialn);
		
		//Eventos
		
		//Eventos que, dependiendo lo que hagamos con la ventana, nos añade un registro en el texto de lo ocurrido
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtrTextoInicialn.setText(txtrTextoInicialn.getText()+"Ventana abierta\n"); //Al abrir la ventana
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				txtrTextoInicialn.setText(txtrTextoInicialn.getText()+"Ventana desactivada\n"); //Al desactivar la ventana
			}
			@Override
			public void windowClosing(WindowEvent e) {
				txtrTextoInicialn.setText(txtrTextoInicialn.getText()+"Ventana cerrandose\n"); //Al estar la ventana cerrándose
			}
			@Override
			public void windowClosed(WindowEvent e) {
				txtrTextoInicialn.setText(txtrTextoInicialn.getText()+"Ventana cerrada\n"); //Al cerrar la ventana
			}
			@Override
			public void windowActivated(WindowEvent e) {
				txtrTextoInicialn.setText(txtrTextoInicialn.getText()+"Ventana activada\n"); //Al activar de nuevo la ventana
			}
		});

	}

}
