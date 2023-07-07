package rs.ac.bg.fon.ai.np.NPClient.main;

import rs.ac.bg.fon.ai.np.NPClient.view.form.FrmLogin;

/**
 * Main klasa projekta NPClient koja sadrzi main() metodu, koja sama po sebi oznacava pocetak izvrsavanja klijentske aplikacije.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Main {
	/**
	 * Glavna metoda i metoda koja se prva pokrece u okviru projekta.
	 * 
	 * Ima za cilj kreiranje forme za prijavu korisnika sa svojim elementima.
	 * @param args - Argumenti pri pokretanju aplikacije iz komandne linije (nije korisceno u okviru klijentskog programa)
	 */
    public static void main(String[] args) {
        new FrmLogin().setVisible(true);
    }
}

