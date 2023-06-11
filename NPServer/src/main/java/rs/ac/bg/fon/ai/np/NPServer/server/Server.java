package rs.ac.bg.fon.ai.np.NPServer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.np.NPServer.thread.ProcessClientsRequests;

/**
 * Predstavlja sam server (koji je sam po sebi jedna nit) koji se pokrece i sluzi za ostvarivanje konekcije sa klijentskim aplikacijama.
 * 
 * Sadrzi listu niti koje su kreirane kao rezultat uspesnog uspostavljanja konekcije sa klijentom, kao i serverski soket ciji je zadatak da osluskuje odgovarajuci port kako bi se ostvarila konekcija sa klijentskom aplikacijom.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Server extends Thread{
	/**
	 * Lista niti koje obradjuju zahteve klijenta. Implementacija je izvrsena preko ArrayList klase.
	 */
    private List<ProcessClientsRequests> threads = new ArrayList<>();
    /**
     * Serverski soket koji osluskuje odredjeni port zarad uspostavljanja konekcije sa klijentskim aplikacijama.
     */
    private ServerSocket serverSocket;
    
    /**
     * Sve dok nije prekinuta osluskuje odredjeni port i ceka na klijenta da pokusa da ostvari konekciju sa serverom.
     */
    public void run() {
        while (!isInterrupted()) {
            try {
                serverSocket = new ServerSocket(9000);
                while (!isInterrupted()) {
                    System.out.println("Waiting for connection...");
                    Socket socket = serverSocket.accept();
                    System.out.println("Connected!");
                    handleClient(socket);
                }
            } catch (SocketException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Server has stopped");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Zaustavlja server tako sto zatvara serverski soket, prekida izvrsavanje svih niti, a takodje prekida i samu nit servera.
     * @throws IOException - Ukoliko dodje do greske prilikom zatvaranja serverskog soketa ili pojedinacnih niti.
     */
    public void stopServer() throws IOException{
        serverSocket.close();
        for(ProcessClientsRequests thread:threads){
            thread.close();
        }
        interrupt();
    }

    /**
     * Nakon uspesnog uspostavljanja konekcije sa klijentom dodeljuje mu jednu nit koja ce obradjivati njegove zahteve i dalje tu nit dodaje u listu niti klijenata.
     * @param socket - Soket koji nastaje kao rezultat konekcije sa klijentom.
     */
    private void handleClient(Socket socket){
        ProcessClientsRequests processClientsRequests = new ProcessClientsRequests(socket);
        threads.add(processClientsRequests);
        processClientsRequests.start();
    }
}
