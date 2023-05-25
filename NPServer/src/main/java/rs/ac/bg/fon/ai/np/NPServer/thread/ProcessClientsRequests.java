package rs.ac.bg.fon.ai.np.NPServer.thread;

import java.io.IOException;
import java.net.Socket;

import rs.ac.bg.fon.ai.np.NPCommon.communication.Receiver;
import rs.ac.bg.fon.ai.np.NPCommon.communication.Request;
import rs.ac.bg.fon.ai.np.NPCommon.communication.Response;
import rs.ac.bg.fon.ai.np.NPCommon.communication.Sender;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckMaintenance;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;
import rs.ac.bg.fon.ai.np.NPCommon.domain.User;
import rs.ac.bg.fon.ai.np.NPServer.controller.Controller;

public class ProcessClientsRequests extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;

    public ProcessClientsRequests(Socket socket) {
        this.socket = socket;        
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            response.setResult(Controller.getInstance().login((User) request.getArgument()));
                            break;
                        case GET_ALL_DRIVERS:
                            response.setResult(Controller.getInstance().getAllDrivers((Driver) request.getArgument()));
                            break;
                        case GET_ALL_TRUCKS:
                            response.setResult(Controller.getInstance().getAllTrucks((Truck) request.getArgument()));
                            break;
                        case GET_ALL_MANUFACTURERS:
                            response.setResult(Controller.getInstance().getAllManufacturers((Manufacturer) request.getArgument()));
                            break;
                        case GET_ALL_TRUCK_TYPES:
                            response.setResult(Controller.getInstance().getAllTruckTypes((TruckType) request.getArgument()));
                            break;
                        case GET_DRIVERS:
                            response.setResult(Controller.getInstance().getDrivers((Driver) request.getArgument()));
                            break;
                        case GET_TRUCKS:
                            response.setResult(Controller.getInstance().getTrucks((Truck) request.getArgument()));
                            break;
                        case GET_LOADS:
                            response.setResult(Controller.getInstance().getLoads((TruckLoad) request.getArgument()));
                            break;
                        case GET_TRUCK_MAINTENANCES:
                            response.setResult(Controller.getInstance().getTruckMaintenances((TruckMaintenance) request.getArgument()));
                            break;
                        case SAVE_DRIVER:
                            Controller.getInstance().addDriver((Driver) request.getArgument());
                            break;
                        case SAVE_TRUCK:
                            Controller.getInstance().addTruck((Truck) request.getArgument());
                            break;
                        case SAVE_LOAD:
                            Controller.getInstance().addLoad((TruckLoad) request.getArgument());
                            break;
                        case EDIT_DRIVER:
                            Controller.getInstance().editDriver((Driver) request.getArgument());
                            break;
                        case EDIT_TRUCK:
                            Controller.getInstance().editTruck((Truck) request.getArgument());
                            break;
                        case EDIT_LOAD:
                            Controller.getInstance().editLoad((TruckLoad) request.getArgument());
                            break;
                        case DELETE_DRIVER:
                            Controller.getInstance().deleteDriver((Driver) request.getArgument());
                            break;
                        case DELETE_LOAD:
                            Controller.getInstance().deleteLoad((TruckLoad) request.getArgument());
                            break;
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);
            } catch (IOException ex) {
                interrupt();
            } catch (Exception ex) {
                ex.printStackTrace();
                interrupt();
            }
        }
    }
    
    public void close() throws IOException{
        receiver.close();
    }

}
