package UD20_maven.UD20_ejercicio1;

import java.awt.EventQueue;

	public class MainApp {
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InterfazGrafica frame = new InterfazGrafica();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
