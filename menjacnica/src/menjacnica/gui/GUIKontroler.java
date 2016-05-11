package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import menjacnica.Menjacnica;
import menjacnica.MenjacnicaInterface;
import menjacnica.gui.models.MenjacnicaTableModel;

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
	public static void prikaziObrisiKurs(int selectedRow, JTable table) {
		MenjacnicaTableModel model = (MenjacnicaTableModel)(table.getModel());
		ObrisiKursGUI prozor = new ObrisiKursGUI(glavniProzor,
				model.vratiValutu(selectedRow));
		prozor.setLocationRelativeTo(null);
		prozor.setVisible(true);
	}
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(glavniProzor,
				"Da li ZAISTA zelite da izadjete iz apliacije", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	public static void prikaziAboutProzor() {
		JOptionPane.showMessageDialog(glavniProzor,
				"Autor: Bojan Tomic, Verzija 1.0", "O programu Menjacnica",
				JOptionPane.INFORMATION_MESSAGE);
	}
	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				menjacnica.sacuvajUFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor, e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void ucitajIzFajla(JTable table) {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				menjacnica.ucitajIzFajla(file.getAbsolutePath());
				prikaziSveValute(table);
			}	
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor, e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void prikaziSveValute(JTable table) {
		MenjacnicaTableModel model = (MenjacnicaTableModel)(table.getModel());
		model.staviSveValuteUModel(menjacnica.vratiKursnuListu());

	}
	public static void prikaziIzvrsiZamenuGUI(JTable table) {
		
			MenjacnicaTableModel model = (MenjacnicaTableModel)(table.getModel());
			IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI(glavniProzor,
					model.vratiValutu(table.getSelectedRow()));
			prozor.setLocationRelativeTo(null);
			prozor.setVisible(true);
		
	}
}
