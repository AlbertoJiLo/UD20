package UD20_maven.UD20.ejercicio8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import java.awt.Font;

public class CambioDivisas2 extends JFrame {

	private JPanel contentPane;
	private JTextField textCantidad;
	private JTextField textField_1;
	private JButton btnCambiar;
	private String convertir_a;
	private JButton btnBorrar;
	private JButton btnConvertir;
	private JLabel lblInstrucciones;
	private JLabel lblConversion;
	private JLabel lblCambiar;
	private JLabel lblBorrar;

	/**
	 * Create the frame.
	 */
	public CambioDivisas2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad a Convertrir");
		lblNewLabel.setBounds(20, 11, 126, 14);
		contentPane.add(lblNewLabel);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(20, 36, 176, 20);
		
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setBounds(234, 11, 57, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(234, 36, 190, 20);
		textField_1.setEnabled(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnConvertir = new JButton("Euros a pesetas");
		convertir_a = "pesetas";
		btnConvertir.setBounds(70, 71, 126, 23);
		contentPane.add(btnConvertir);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(206, 71, 89, 23);
		contentPane.add(btnCambiar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(305, 71, 89, 23);
		contentPane.add(btnBorrar);
		
		lblInstrucciones = new JLabel("Instrucciones:");
		lblInstrucciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInstrucciones.setBounds(10, 117, 114, 24);
		contentPane.add(lblInstrucciones);
		
		lblConversion = new JLabel("-Puedes hacer la conversión apretando la tecla ENTER o haciendo click en el botón");
		lblConversion.setBounds(20, 152, 404, 14);
		contentPane.add(lblConversion);
		
		lblCambiar = new JLabel("-Puedes cambiar de divisa apretando la tecla C o haaciendo click en el botón");
		lblCambiar.setBounds(20, 177, 404, 14);
		contentPane.add(lblCambiar);
		
		lblBorrar = new JLabel("-Puedes borrar los valores apretando la tecla B o haciendo click en el botón");
		lblBorrar.setBounds(20, 202, 404, 14);
		contentPane.add(lblBorrar);
		
		//añado un listener para que cuando se abra la ventana le asigne el foco al contentPane
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				contentPane.requestFocusInWindow();
			}
		});
		
		//action listener para hacer la conversión
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double resultado = convertirDivisas(textCantidad.getText(),convertir_a);
					textField_1.setText(""+resultado);
				}catch(NumberFormatException ex) {
					System.out.println("Debes introducir un número");
				}
				
			}
		});
		
		//action listener para el botón que cambia el tipo de divisa a convertir
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarDivisas();
			}
		});
		
		//event listener para el botón de borrar
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarValores();
			}
		});
		
		//event listener para que al apretar el enter en el campo donde se introduce la cantidad se haga el cálculo
		textCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						double resultado = convertirDivisas(textCantidad.getText(),convertir_a);
						textField_1.setText(""+resultado);
					}catch(NumberFormatException ex) {
						System.out.println("Debes introducir un número");
					}
				}
			}
		});
		
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==67){
					cambiarDivisas();
				}else if (e.getKeyCode()==66) {
					borrarValores();
				}
			}
		});
	}
	
	//función que recoge la cantidad a converitir y el tipo de divisa al cual se va a hacer la conversión
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
		contentPane.requestFocusInWindow();
		return Math.round(resultado * 100.0) / 100.0;
	}
	
	public void borrarValores() {
		textCantidad.setText("");
		textField_1.setText("");
	}
	
	public void cambiarDivisas() {
		switch(convertir_a) {
		case "pesetas":
			convertir_a = "euros";
			btnConvertir.setText("Pesetas a euros");
			break;
		case "euros":
			convertir_a = "pesetas";
			btnConvertir.setText("Euros a pesetas");
			break;
		}
	}

}
