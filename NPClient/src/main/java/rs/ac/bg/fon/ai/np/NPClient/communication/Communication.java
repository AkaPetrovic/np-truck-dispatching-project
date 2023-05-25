package rs.ac.bg.fon.ai.np.NPClient.communication;

import java.net.Socket;
import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.communication.Operation;
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

public class Communication {
    Socket socket;
    Sender sender;
    Receiver receiver;
    
    private static Communication instance;
    
    private Communication() throws Exception{
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    public static Communication getInstance() throws Exception{
        if(instance == null){
            instance = new Communication();
        }
        return instance;
    }
    
    public User login(String username, String password) throws Exception {
        try{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            Request request = new Request(Operation.LOGIN, user);
            sender.send(request);
            Response response = (Response)receiver.receive();
            if(response.getException() == null){
                return (User)response.getResult();
            }else{
                throw response.getException();
            }
        } catch(Exception e){
            throw new Exception("User cannot be logged in");
        }
    }
    
    public List<Driver> getAllDrivers(Driver driver) throws Exception{
        Request request = new Request(Operation.GET_ALL_DRIVERS, driver);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){
            return (List<Driver>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<Manufacturer> getAllManufactures(Manufacturer manufacturer) throws Exception{
        Request request = new Request(Operation.GET_ALL_MANUFACTURERS, manufacturer);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){
            return (List<Manufacturer>)response.getResult();
        }else{
            throw response.getException();
        }
    }

    public List<TruckType> getAllTruckTypes(TruckType truckType) throws Exception {
        Request request = new Request(Operation.GET_ALL_TRUCK_TYPES, truckType);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){
            return (List<TruckType>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<Truck> getAllTrucks(Truck truck) throws Exception{
        Request request = new Request(Operation.GET_ALL_TRUCKS, truck);
        sender.send(request);
        Response response = (Response)receiver.receive();
        
        if(response.getException() == null){
            return (List<Truck>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<Truck> getTrucks(Truck truck) throws Exception{
        Request request = new Request(Operation.GET_TRUCKS, truck);
        sender.send(request);
        Response response = (Response)receiver.receive();
        
        if(response.getException() == null){
            return (List<Truck>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<Driver> getDrivers(Driver driver) throws Exception{
        Request request = new Request(Operation.GET_DRIVERS, driver);
        sender.send(request);
        Response response = (Response)receiver.receive();
        
        if(response.getException() == null){
            return (List<Driver>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<TruckLoad> getLoads(TruckLoad load) throws Exception{
        Request request = new Request(Operation.GET_LOADS, load);
        sender.send(request);
        Response response = (Response)receiver.receive();
        
        if(response.getException() == null){
            return (List<TruckLoad>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<TruckMaintenance> getTruckMaintenances(TruckMaintenance truckMaintenance) throws Exception {
        Request request = new Request(Operation.GET_TRUCK_MAINTENANCES, truckMaintenance);
        sender.send(request);
        Response response = (Response)receiver.receive();
        
        if(response.getException() == null){
            return (List<TruckMaintenance>)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public void saveTruck(Truck truck) throws Exception {
        try {
            Request request = new Request(Operation.SAVE_TRUCK, truck);
            sender.send(request);
            Response response = (Response)receiver.receive();

            if(response.getException() != null){
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Truck cannot be saved");
        }
    }
    
    public void saveDriver(Driver driver) throws Exception {
        try {
            Request request = new Request(Operation.SAVE_DRIVER, driver);
            sender.send(request);
            Response response = (Response)receiver.receive();

            if(response.getException() != null){
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Driver cannot be saved");
        }
    }
    
    public void saveLoad(TruckLoad load) throws Exception {
        try {
            Request request = new Request(Operation.SAVE_LOAD, load);
            sender.send(request);
            Response response=(Response)receiver.receive();

            if(response.getException() != null){
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Load cannot be saved");
        }
        
    }
    
    public void editTruck(Truck truck) throws Exception {
        try {
            Request request = new Request(Operation.EDIT_TRUCK, truck);
            sender.send(request);
            Response response = (Response)receiver.receive();

            if(response.getException() != null){
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Truck cannot be edited");
        }
    }
    
    public void editDriver(Driver driver) throws Exception {
        try {
            Request request = new Request(Operation.EDIT_DRIVER, driver);
            sender.send(request);
            Response response = (Response)receiver.receive();

            if(response.getException() != null){
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Driver cannot be edited");
        }
    }
    
    public void editLoad(TruckLoad load) throws Exception {
        try {
            Request request = new Request(Operation.EDIT_LOAD, load);
            sender.send(request);
            Response response = (Response)receiver.receive();

            if(response.getException() != null){
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Load cannot be edited");
        }
    }
    
    public void deleteDriver(Driver driver) throws Exception {
        try {
            Request request = new Request(Operation.DELETE_DRIVER, driver);
            sender.send(request);
            Response response = (Response)receiver.receive();

            if(response.getException() != null){
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Driver cannot be deleted");
        }
    }
    
    public void deleteLoad(TruckLoad load) throws Exception {
        try {
            Request request = new Request(Operation.DELETE_LOAD, load);
            sender.send(request);
            Response response = (Response)receiver.receive();

            if(response.getException() != null){
                throw response.getException();
            }
        } catch (Exception e) {
            throw new Exception("Load cannot be deleted");
        }
    }
}
