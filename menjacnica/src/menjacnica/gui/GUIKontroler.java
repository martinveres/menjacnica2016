package menjacnica.gui;

import java.awt.EventQueue;

import menjacnica.Menjacnica;
import menjacnica.MenjacnicaInterface;

public class GUIKontroler {
	public static MenjacnicaGUI glavniProzor;
	public static MenjacnicaInterface menjacnica;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new MenjacnicaGUI();
					menjacnica = new Menjacnica();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void prikaziDodajKursGUI() {
	DodajKursGUI prozor = new DodajKursGUI(glavniProzor);
	prozor.setLocationRelativeTo(null);
	prozor.setVisible(true);
	}
}
