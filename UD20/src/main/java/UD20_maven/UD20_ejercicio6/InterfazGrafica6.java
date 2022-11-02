package UD20_maven.UD20_ejercicio6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazGrafica6 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public InterfazGrafica6() {
		setTitle("Indice masa corporal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos los botones, casillas y textos necesarios.
		
		JLabel lblNewLabel = new JLabel("Altura (metros)");
		lblNewLabel.setBounds(41, 42, 98, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso (kg)");
		lblNewLabel_1.setBounds(253, 42, 73, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IMC: ");
		lblNewLabel_2.setBounds(221, 98, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(276, 98, 88, 13);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(133, 39, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(315, 39, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Calcular IMC");
		btnNewButton_1.setBounds(95, 94, 116, 21);
		contentPane.add(btnNewButton_1);
		
		//Eventos
		
		//Evento que llama al método para calcular el IMC y luego lo muestra en el campo de texto
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double IMC = calcularIMC();
				lblNewLabel_3.setText(""+IMC);
			}
		});
	}
	
	//Método para hacer el cálculo con validación de errores.
	
	public double calcularIMC () {
		
		String casilla1 = textField.getText();
		String casilla2 = textField_1.getText();
		double IMC = 0;
		try {
			double valor1 = Double.parseDouble(casilla1);
			double valor2 = Double.parseDouble(casilla2);
			IMC = valor2/Math.pow(valor1, 2);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error en los campos, datos inválidos. Por favor introduce numeros positivos",
					"Algo ha fallado", JOptionPane.ERROR_MESSAGE);
		}
		return IMC;
	}
}
