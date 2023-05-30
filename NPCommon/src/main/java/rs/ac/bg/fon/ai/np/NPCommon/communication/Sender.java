package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Predstavlja posiljaoca u komunikaciji izmedju klijent i server aplikacije.
 * 
 * Sadrzi podatak o soketu i izlaznom toku podataka koji sluzi za slanje podataka ka suprotnoj strani.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Sender {
	/**
	 * Soket koji se vezuje za posiljaoca u komunikaciji, klase Socket.
	 */
    private Socket socket;
    /**
     * Izlazni tok podataka koji je predvidjen da radi sa odredjenim instancama objekata.
     */
    private ObjectOutputStream out;

    /**
     * Konstruktor klase Sender koji postavlja soket na odgovarajucu vrednost prilikom kreiranja objekta date klase.
     * @param socket - Odgovarajuci soket koji se postavlja kao pocetna vrednost za sam atribut socket koji je deo posiljaoca.
     */
    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Salje objekat ka drugom - prijemnoj strani (moze biti klijent ili server).
     * @param object - Predstavlja tacno odredjeni objekat koji se salje.
     * @throws Exception - U slucaju da dodje do greske pri radu ObjectOutputStream-a ili generalno nastane greska pri slanju objekta.
     */
    public void send(Object object) throws Exception{
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (SocketException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object!\n" + ex.getMessage());
        }
    }
}
