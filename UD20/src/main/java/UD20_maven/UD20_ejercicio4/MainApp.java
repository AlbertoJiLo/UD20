package UD20_maven.UD20_ejercicio4;

import java.awt.EventQueue;

public class MainApp {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica4 frame = new InterfazGrafica4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
