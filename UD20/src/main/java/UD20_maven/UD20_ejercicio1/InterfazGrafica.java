package UD20_maven.UD20_ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class InterfazGrafica extends JFrame {

	private JPanel contentPane;

	public InterfazGrafica() {

		
		setTitle("Cambia tamaños");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos los botones, casillas y textos necesarios.
		
		JLabel lblNewLabel = new JLabel("Esta es la reina de las etiquetas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 490, 118);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Subir tamaño");
		btnNewButton.setBounds(10, 173, 178, 21);
		contentPane.add(btnNewButton);
		
		JButton btnBajarTamao = new JButton("Bajar tamaño");
		btnBajarTamao.setBounds(10, 220, 178, 21);
		contentPane.add(btnBajarTamao);
		
		//Eventos
		
		//Eventos que agrandan o empequeñecen el texto dependiendo del botón que pulsemos
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = lblNewLabel.getFont();
				font = font.deriveFont(font.getSize()*1.1f);
				lblNewLabel.setFont(font);
			}
		});
		
		btnBajarTamao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = lblNewLabel.getFont();
				font = font.deriveFont(font.getSize()*0.9f);
				lblNewLabel.setFont(font);
			}
		});
	}
}
