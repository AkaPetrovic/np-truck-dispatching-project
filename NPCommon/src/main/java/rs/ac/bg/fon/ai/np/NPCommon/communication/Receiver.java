package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {
    private Socket socket;
    private ObjectInputStream in;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
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
    
    public void close() throws IOException{
        in.close();
    }
}
