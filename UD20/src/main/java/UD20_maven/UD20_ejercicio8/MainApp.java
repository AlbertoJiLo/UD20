
package UD20_maven.UD20_ejercicio8;


import java.awt.EventQueue;

public class MainApp {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica8 frame = new InterfazGrafica8();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
