package rs.ac.bg.fon.ai.np.NPServer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.np.NPServer.thread.ProcessClientsRequests;

public class Server extends Thread{
    private List<ProcessClientsRequests> threads = new ArrayList<>();
    private ServerSocket serverSocket;
    
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
    
    public void stopServer() throws IOException{
        serverSocket.close();
        for(ProcessClientsRequests thread:threads){
            thread.close();
        }
        interrupt();
    }

    private void handleClient(Socket socket) throws Exception {
        ProcessClientsRequests processClientsRequests = new ProcessClientsRequests(socket);
        threads.add(processClientsRequests);
        processClientsRequests.start();
    }
}
