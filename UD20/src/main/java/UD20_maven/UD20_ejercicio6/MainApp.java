package UD20_maven.UD20_ejercicio6;

import java.awt.EventQueue;

public class MainApp {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica6 frame = new InterfazGrafica6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
