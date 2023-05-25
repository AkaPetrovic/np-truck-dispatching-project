package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class Sender {
    private Socket socket;
    private ObjectOutputStream out;

    public Sender(Socket socket) {
        this.socket = socket;
    }
    
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
