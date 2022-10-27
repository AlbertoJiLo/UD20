package UD20_maven.UD20_ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazGrafica2 extends JFrame {

	private JPanel contentPane;

	public InterfazGrafica2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Has pulsado: Boton 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 37, 208, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Boton 1");
		btnNewButton.setBounds(307, 43, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Boton 2");
		btnNewButton_1.setBounds(307, 87, 85, 21);
		contentPane.add(btnNewButton_1);
		
		//Eventos
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Has pulsado: Boton 1");
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Has pulsado: Boton 2");
			}
		});
	}
}
