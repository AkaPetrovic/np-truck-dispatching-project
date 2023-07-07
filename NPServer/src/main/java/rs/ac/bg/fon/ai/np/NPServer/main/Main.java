package rs.ac.bg.fon.ai.np.NPServer.main;

import rs.ac.bg.fon.ai.np.NPServer.form.FrmMain;

/**
 * Main klasa projekta NPServer koja sadrzi main() metodu, koja sama po sebi oznacava pocetak izvrsavanja serverske aplikacije.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Main {
	/**
	 * Glavna metoda i metoda koja se prva pokrece u okviru projekta.
	 * 
	 * Ima za cilj kreiranje glavne forme sa svojim elementima.
	 * @param args - Argumenti pri pokretanju aplikacije iz komandne linije (nije korisceno u okviru serverskog programa)
	 */
    public static void main(String[] args) {
        new FrmMain().setVisible(true);
    }
}
