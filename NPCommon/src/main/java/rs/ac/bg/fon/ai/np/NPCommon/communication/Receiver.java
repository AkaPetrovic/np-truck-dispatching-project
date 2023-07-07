package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Predstavlja primaoca u komunikaciji izmedju klijent i server aplikacije.
 * 
 * Sadrzi podatak o soketu i ulaznom toku podataka koji sluzi za prijem podataka od suprotne strane.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Receiver {
	/**
	 * Soket koji se vezuje za prijemnu stranu odnosno primaoca u komunikaciji, klase Socket.
	 */
    private Socket socket;
    /**
     * Ulazni tok podataka koji je predvidjen da radi sa odredjenim instancama objekata.
     */
    private ObjectInputStream in;

    /**
     * Konstruktor koji postavlja soket na odgovarajucu vrednost prilikom kreiranja objekta klase Receiver.
     * @param socket - Konkretan soket koji se postavlja kao pocetna vrednost za atribut socket koji je deo primaoca.
     */
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Prihvata objekat koji je poslat od strance posiljaoca (klijenta ili servera).
     * 
     * @return receivedObject - Objekat koji je pristigao kao rezultat komunikacije.
     * @throws Exception - Ukoliko dodje do greske pri radu sa ObjectInputStream-om.
     */
    public Object receive() throws Exception{
        try {
            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        }catch (IOException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object!\n"+ex.getMessage());
        }
    }
    
    /**
     * Zatvara ObjectInputStream, sto se koristi da se oznaci kraj rada sa tom instancom.
     * @throws IOException - Ukoliko dodje do greske pri zatvaranju ObjectInputStrema-a.
     */
    public void close() throws IOException{
        try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
    }
}
