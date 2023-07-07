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

/**
 * Predstavlja klasu zaduzenu za komunikaciju klijentske sa serverskom stranom. Implementira singleton patern.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Communication {
	/**
	 * Soket koji se koristi kao sredstvo komunikacije klijenta i servera.
	 */
    Socket socket;
    /**
     * Posiljalac zahteva.
     */
    Sender sender;
    /**
     * Primalac odgovora.
     */
    Receiver receiver;
    
    /**
     * Jedinstvena instanca klase Communication.
     */
    private static Communication communication;
    
    /**
     * Konstruktor koji sluzi kako bi se kreirao soket i kako bi komunicirao sa portom na kome je pokrenut serverski soket.
     * 
     * Takodje postavlja da klijentska strana moze da salje zahteve i prima odgovore od strane servera.
     * 
     * @throws Exception - Ukoliko dodje do greske prilikom kreiranja soketa.
     */
    private Communication() throws Exception{
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    /**
     * Kreira jedinstvenu instancu ove klase ukoliko ne postoji, u suprotnom vraca postojecu instancu.
     * @return instance - jedinstvena instanca klase Communication.
     * @throws Exception - Ukoliko dodje do greske prilikom kreiranje instance.
     */
    public static Communication getInstance() throws Exception{
        if(communication == null){
            communication = new Communication();
        }
        return communication;
    }
    
    /**
     * Kreira korisnika na osnovu unetog username-a i password-a, a zatim salje zahtev serveru za prijavom korisnika ukoliko on postoji u bazi podataka.
     * @param username - Korisnicko ime koje je uneto.
     * @param password - Lozinka koja je uneta prilikom prijave korisnika.
     * @return user - Vraca podatke o korisniku ukoliko je uspesno prijavljen u okviru aplikacije.
     * @throws Exception - Ukoliko korisnik ne postoji u bazi ili ne moze da bude prijavljen.
     */
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
    
    /**
     * Salje zahtev serveru za listom svih vozaca iz baze podataka.
     * @param driver - Oznacava da se zahtev odnosi na listu vozaca.
     * @return drivers - Vraca listu vozaca dobijenu u odgovoru od servera.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste vozaca iz baze podataka na strani servera.
     */
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
    
    /**
     * Salje zahtev serveru za listom svih proizvodjaca kamiona iz baze podataka.
     * @param manufacturer - Oznacava da se zahtev odnosi na listu proizvodjaca kamiona.
     * @return manufacturers - Vraca listu proizvodjaca kamiona dobijenu u odgovoru od servera.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste proizvodjaca kamiona iz baze podataka na strani servera.
     */
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

    /**
     * Salje zahtev serveru za listom svih tipova kamiona iz baze podataka.
     * @param truckType - Oznacava da se zahtev odnosi na listu tipova kamiona.
     * @return truckTypes - Vraca listu tipova kamiona dobijenu u odgovoru od servera.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste tipova kamiona iz baze podataka na strani servera.
     */
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
    
    /**
     * Salje zahtev serveru za listom svih kamiona iz baze podataka.
     * @param truck - Oznacava da se zahtev odnosi na listu kamiona.
     * @return trucks - Vraca listu kamiona dobijenu u odgovoru od servera.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste kamiona iz baze podataka na strani servera.
     */
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
    
    /**
     * Salje zahtev serveru za listom kamiona iz baze podataka koji ispunjavaju odredjene uslove.
     * @param truck - Oznacava da se zahtev odnosi na listu kamiona.
     * @return trucks - Vraca listu kamiona dobijenu u odgovoru od servera.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste kamiona iz baze podataka na strani servera.
     */
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
    
    /**
     * Salje zahtev serveru za listom vozaca iz baze podataka koji ispunjavaju odredjene uslove.
     * @param driver - Oznacava da se zahtev odnosi na listu vozaca.
     * @return drivers - Vraca listu vozaca dobijenu u odgovoru od servera.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste vozaca iz baze podataka na strani servera.
     */
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
    
    /**
     * Salje zahtev serveru za listom tovara iz baze podataka koji ispunjavaju odredjene uslove.
     * @param load - Oznacava da se zahtev odnosi na listu tovara.
     * @return loads - Vraca listu tovara dobijenu u odgovoru od servera.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste tovara iz baze podataka na strani servera.
     */
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
    
    /**
     * Salje zahtev serveru za listom servisa kamiona iz baze podataka koji ispunjavaju odredjene uslove.
     * @param truckMaintenance - Oznacava da se zahtev odnosi na listu servisa kamiona.
     * @return truckMaintenances - Vraca listu servisa kamiona dobijenu u odgovoru od servera.
     * @throws Exception - Ukoliko dodje do greske prilikom preuzimanja liste servisa kamiona iz baze podataka na strani servera.
     */
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
    
    /**
     * Salje zahtev serveru za dodavanjem novog kamiona u bazu podataka.
     * @param truck - Kamion koji treba dodati u bazu podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom dodavanja kamiona u bazu podataka.
     */
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
    
    /**
     * Salje zahtev serveru za dodavanjem novog vozaca u bazu podataka.
     * @param driver - Vozac koji treba dodati u bazu podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom dodavanja vozaca u bazu podataka.
     */
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
    
    /**
     * Salje zahtev serveru za dodavanjem novog tovara u bazu podataka.
     * @param load - Tovar koji treba dodati u bazu podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom dodavanja tovara u bazu podataka.
     */
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
    
    /**
     * Salje zahtev serveru za izmenom odgovarajuceg kamiona u bazi podataka.
     * @param truck - Kamion na osnovu kojeg treba izvrsiti odredjene izmene nad odgovarajucim kamionom u bazi podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom izmene kamiona u bazi podataka.
     */
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
    
    /**
     * Salje zahtev serveru za izmenom odgovarajuceg vozaca u bazi podataka.
     * @param driver - Vozac na osnovu kojeg treba izvrsiti odredjene izmene nad odgovarajucim vozacom u bazi podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom izmene vozaca u bazi podataka.
     */
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
    
    /**
     * Salje zahtev serveru za izmenom odgovarajuceg tovara u bazi podataka.
     * @param load - Tovar na osnovu kojeg treba izvrsiti odredjene izmene nad odgovarajucim tovarom u bazi podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom izmene tovara u bazi podataka.
     */
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
    
    /**
     * Salje zahtev serveru za brisanjem odgovarajuceg vozaca iz baze podataka.
     * @param driver - Vozac kojeg treba obrisati iz baze podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom brisanja vozaca iz baze podataka.
     */
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
    
    /**
     * Salje zahtev serveru za brisanjem odgovarajuceg tovara iz baze podataka.
     * @param load - Tovar kojeg treba obrisati iz baze podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom brisanja tovara iz baze podataka.
     */
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
