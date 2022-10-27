package UD20_maven.UD20_ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class InterfazGrafica3 extends JFrame {

	private JPanel contentPane;
	int c=0;
	int i=0;
	
	public InterfazGrafica3() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Boton 1");
		btnNewButton.setBounds(51, 166, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Boton 2");
		btnNewButton_1.setBounds(289, 166, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Boton 1: "+c+" veces. Boton 2: "+i+" veces");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(20, 27, 416, 84);
		contentPane.add(lblNewLabel);
		
		//Eventos
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c++;
				lblNewLabel.setText("Boton 1: "+c+" veces. Boton 2: "+i+" veces");
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				lblNewLabel.setText("Boton 1: "+c+" veces. Boton 2: "+i+" veces");
			}
		});
	}

}
