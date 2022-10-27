package UD20_maven.UD20.ejercicio5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosRaton extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public EventosRaton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.setBounds(171, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 41, 414, 209);
		contentPane.add(textPane);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
			}
		});
		
		//listener de eventos del ratón
		textPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//evento de click
				String texto = textPane.getText();
				textPane.setText(texto+"\n Has hecho click en el área");
			}
			@Override
			public void mouseEntered(MouseEvent e) {//evento al entrar en el panel de texto
				String texto = textPane.getText();
				textPane.setText(texto+"\n Has entrado en el área");
			}
			@Override
			public void mouseExited(MouseEvent e) {//evento al salir del panel de texto
				String texto = textPane.getText();
				textPane.setText(texto+"\n Has salido del área");
			}
			@Override
			public void mousePressed(MouseEvent e) {//evento al apretar el click del raton en el panel de texto
				String texto = textPane.getText();
				textPane.setText(texto+"\n Has apretado el ratón sobre el área");
			}
			@Override
			public void mouseReleased(MouseEvent e) {//evento al soltar el click del raton en el panel de texto
				String texto = textPane.getText();
				textPane.setText(texto+"\n Has soltado el ratón sobre el área");
			}
		});
	}
}
