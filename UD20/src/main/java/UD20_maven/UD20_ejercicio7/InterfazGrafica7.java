package UD20_maven.UD20_ejercicio7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazGrafica7 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private String convertir_a;

	/**
	 * Create the frame.
	 */
	public InterfazGrafica7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad a Convertrir");
		lblNewLabel.setBounds(10, 11, 132, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(152, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setBounds(271, 11, 57, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(338, 8, 86, 20);
		textField_1.setEnabled(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Euros a pesetas");
		convertir_a = "pesetas";
		btnNewButton.setBounds(120, 57, 126, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cambiar");
		btnNewButton_1.setBounds(252, 57, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double resultado = convertirDivisas(textField.getText(),convertir_a);
					textField_1.setText(""+resultado);
				}catch(NumberFormatException ex) {
					System.out.println("Debes introducir un número");
				}
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(convertir_a) {
				case "pesetas":
					convertir_a = "euros";
					btnNewButton.setText("Pesetas a euros");
					break;
				case "euros":
					convertir_a = "pesetas";
					btnNewButton.setText("Euros a pesetas");
					break;
				}
			}
		});
	}
	
	public double convertirDivisas(String valor,String convertir_a) {
		double cantidad = Double.parseDouble(valor);
		double resultado = 0.0;
		switch(convertir_a) {
		case "pesetas":
			resultado = cantidad*166.386;
			break;
		case "euros":
			resultado = cantidad/166.386;
			break;
		}
		return resultado;
	}

}