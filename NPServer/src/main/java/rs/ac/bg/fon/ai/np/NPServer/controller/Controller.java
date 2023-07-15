package rs.ac.bg.fon.ai.np.NPServer.controller;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.np.NPCommon.domain.Country;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Driver;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Manufacturer;
import rs.ac.bg.fon.ai.np.NPCommon.domain.Truck;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckLoad;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckMaintenance;
import rs.ac.bg.fon.ai.np.NPCommon.domain.TruckType;
import rs.ac.bg.fon.ai.np.NPCommon.domain.User;
import rs.ac.bg.fon.ai.np.NPServer.operation.country.GetAllCountries;
import rs.ac.bg.fon.ai.np.NPServer.operation.driver.DeleteDriver;
import rs.ac.bg.fon.ai.np.NPServer.operation.driver.EditDriver;
import rs.ac.bg.fon.ai.np.NPServer.operation.driver.GetAllDrivers;
import rs.ac.bg.fon.ai.np.NPServer.operation.driver.SaveDriver;
import rs.ac.bg.fon.ai.np.NPServer.operation.load.DeleteLoad;
import rs.ac.bg.fon.ai.np.NPServer.operation.load.EditLoad;
import rs.ac.bg.fon.ai.np.NPServer.operation.load.GetAllLoads;
import rs.ac.bg.fon.ai.np.NPServer.operation.load.SaveLoad;
import rs.ac.bg.fon.ai.np.NPServer.operation.manufacturer.GetAllManufacturers;
import rs.ac.bg.fon.ai.np.NPServer.operation.truck.EditTruck;
import rs.ac.bg.fon.ai.np.NPServer.operation.truck.GetAllTrucks;
import rs.ac.bg.fon.ai.np.NPServer.operation.truck.SaveTruck;
import rs.ac.bg.fon.ai.np.NPServer.operation.truckmaintenance.GetAllTruckMaintenances;
import rs.ac.bg.fon.ai.np.NPServer.operation.trucktype.GetAllTruckTypes;
import rs.ac.bg.fon.ai.np.NPServer.operation.user.GetAllUsers;

/**
 * Predstavlja kontroler koji ima mogucnost da poziva razlicite sistemske operacije. Implementira singleton patern.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Controller {
	/**
	 * Jedinstvena instanca Controller klase.
	 */
    private static Controller controller;

    /**
     * Privatni konstruktor koji se poziva samo jednom kako bi se kreirala jedina instanca klase Controller.
     */
    private Controller() {
    }
    
    /**
     * Vraca instancu kontrolera ukoliko ona postoji, ali ukoliko ne postoji kreira je.
     * @return controller - Instanca kontrolera.
     */
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
    
    /**
     * Pretrazuje bazu podataka kako bi se utvrdilo da li prosledjeni korisnik sa svojim podacima za pristup aplikaciji postoji.
     * @param user - Korisnik ciji se podaci proveravaju.
     * @return us - Pronadjeni korisnik.
     * @throws Exception - Ukoliko korisnik ne postoji u bazi podataka.
     */
    public User login(User user) throws Exception {
        GetAllUsers operation = new GetAllUsers();
        operation.execute(user);
        List<User> users = operation.getUsers();
        for (User us : users) {
            if (user.getUsername().equals(us.getUsername()) && user.getPassword().equals(us.getPassword())) {
                return us;
            }
        }
        throw new Exception("Unknown user!");
    }
    
    /**
     * Vraca sve kamione koji odgovaraju po odredjenim parametrima kamionu prosledjenom u pozivu metode.
     * @param truck - Kamion koji sluzi za poredjenje sa svim kamionima iz baze podataka.
     * @return trucks - Lista kamiona koji odgovaraju prosledjenom kamionu.
     * @throws Exception - Ukoliko nema kamiona koji odgovara uslovima.
     */
    public List<Truck> getTrucks(Truck truck) throws Exception {
        List<Truck> allTrucks = getAllTrucks(truck);
        
        List<Truck> trucks = new ArrayList<>();
        
        for(Truck tr:allTrucks){
            if(tr.getManufacturer().equals(truck.getManufacturer()))
                trucks.add(tr);
        }
        
        if(trucks.isEmpty()){
            throw new Exception("No truck match the criteria.");
        }
        return trucks;
    }
    
    /**
     * Vraca sve kamione iz baze podataka.
     * @param truck - Oznacava da su objekti u listi tipa Truck.
     * @return trucks - Lista kamiona iz baze podataka.
     * @throws Exception - Ukoliko nema kamiona u bazi podataka.
     */
    public List<Truck> getAllTrucks(Truck truck) throws Exception {
        List<TruckType> truckTypes = getAllTruckTypes(new TruckType());
        List<Manufacturer> manufacturers = getAllManufacturers(new Manufacturer());
        GetAllTrucks operation = new GetAllTrucks();
        operation.execute(truck);
        List<Truck> trucks = operation.getTrucks();
        
        for(Truck tr:trucks){
            for(Manufacturer manu:manufacturers){
                if(tr.getManufacturer().getId().equals(manu.getId())){
                    tr.setManufacturer(manu);
                    break;
                }
            }
        }
        
        for(Truck tr:trucks){
            for(TruckType type:truckTypes){
                if(tr.getTruckType().getId().equals(type.getId())){
                    tr.setTruckType(type);
                    break;
                }
            }
        }
        
        if(trucks.isEmpty()){
            throw new Exception("No trucks were found in the database.");
        }
        return trucks;
    }
    
    /**
     * Vraca sve proizvodjace kamiona iz baze podataka.
     * @param manufacturer - Oznacava da su objekti u listi tipa Manufacturer.
     * @return manufacturers - Lista proizvodjaca iz baze podataka.
     * @throws Exception - Ukoliko nema proizvodjaca u bazi podataka.
     */
    public List<Manufacturer> getAllManufacturers(Manufacturer manufacturer) throws Exception {
        List<Country> countries = getAllCountries(new Country());
        GetAllManufacturers operation = new GetAllManufacturers();
        operation.execute(manufacturer);
        List<Manufacturer> manufacturers = operation.getManufacturers();
        
        for(Manufacturer mr:manufacturers){
            for(Country cr:countries){
                if(mr.getCountry().getId().equals(cr.getId())){
                    mr.setCountry(cr);
                    break;
                }
            }
        }
        
        if(manufacturers.isEmpty()){
            throw new Exception("No manufacturers were found in the database.");
        }
        return manufacturers;
    }
    
    /**
     * Vraca sve drzave iz kojih dolaze proizvodjaci kamiona koje se nalaze u bazi podataka.
     * @param country - Oznacava da metoda treba da vrati listu drzava.
     * @return countries - Lista drzava iz baze podataka.
     * @throws Exception - Ukoliko nema drzava u bazi podataka.
     */
    public List<Country> getAllCountries(Country country) throws Exception {
        GetAllCountries operation = new GetAllCountries();
        operation.execute(country);
        List<Country> countries = operation.getCountries();
        if(countries.isEmpty()){
            throw new Exception("No countries were found in the database.");
        }
        return countries;
    }

    /**
     * Vraca sve tipove kamiona iz baze podataka.
     * @param truckType - Oznacava da metoda treba da vrati listu tipova kamiona.
     * @return truckTypes - Lista tipova kamiona iz baze podataka
     * @throws Exception - Ukoliko nema nijednog tipa kamiona u bazi podataka.
     */
    public List<TruckType> getAllTruckTypes(TruckType truckType) throws Exception {
        GetAllTruckTypes operation = new GetAllTruckTypes();
        operation.execute(truckType);
        List<TruckType> truckTypes = operation.getTruckTypes();
        if(truckTypes.isEmpty()){
            throw new Exception("No truck types were found in the database.");
        }
        return truckTypes;
    }
    
    /**
     * Vraca sve vozace koji odgovaraju po odredjenim parametrima vozacu prosledjenom u pozivu metode.
     * @param driver - Vozac koji sluzi za poredjenje sa svim vozacima iz baze podataka.
     * @return drivers - Lista vozaca koji odgovaraju prosledjenom vozacu.
     * @throws Exception - Ukoliko nema vozaca koji odgovaraju uslovima.
     */
    public List<Driver> getDrivers(Driver driver) throws Exception {
        List<Driver> allDrivers = getAllDrivers(driver);
        
        List<Driver> drivers = new ArrayList<>();
        
        for(Driver dr:allDrivers){
            if(dr.getName().equals(driver.getName()))
                drivers.add(dr);
        }
        if(drivers.isEmpty()){
            throw new Exception("No driver match the criteria.");
        }
        return drivers;
    }
    
    /**
     * Vraca sve vozace iz baze podataka.
     * @param driver - Oznacava da metoda treba da vrati listu vozaca.
     * @return drivers - Lista vozaca iz baze podataka
     * @throws Exception - Ukoliko nema nijednog vozaca u bazi podataka.
     */
    public List<Driver> getAllDrivers(Driver driver) throws Exception{
        List<Truck> trucks = getAllTrucks(new Truck());
        GetAllDrivers operation =  new GetAllDrivers();
        operation.execute(driver);
        List<Driver> drivers = operation.getDrivers();
        
        for(Driver dr:drivers){
            for(Truck tr:trucks){
                if(dr.getTruck().getId().equals(tr.getId())){
                    dr.setTruck(tr);
                    break;
                }
            }
        }
        
        if(drivers.isEmpty()){
            throw new Exception("No drivers were found in the database.");
        }
        return drivers;
    }
    
    /**
     * Vraca sve tovare iz baze podataka.
     * @param load - Oznacava da metoda treba da vrati listu tovara.
     * @return loads - Lista tovara iz baze podataka
     * @throws Exception - Ukoliko nema nijednog tovara u bazi podataka.
     */
    public List<TruckLoad> getAllLoads(TruckLoad load) throws Exception {
        List<Driver> drivers = getAllDrivers(new Driver());
        GetAllLoads operation = new GetAllLoads();
        operation.execute(load);
        List<TruckLoad> loads = operation.getLoads();
        
        for(TruckLoad tl:loads){
            for(Driver dr:drivers){
                if(tl.getDriver().getId().equals(dr.getId())){
                    tl.setDriver(dr);
                    break;
                }
            }
        }
        
        if(loads.isEmpty()){
            throw new Exception("No truck loads were found in the database.");
        }
        return loads;
    }
    
    /**
     * Vraca sve tovare koji odgovaraju po odredjenim parametrima tovaru prosledjenom u pozivu metode.
     * @param load - Tovar koji sluzi za poredjenje sa svim vozacima iz baze podataka.
     * @return loads - Lista tovara koji odgovaraju prosledjenom tovaru.
     * @throws Exception - Ukoliko nema tovara koji odgovaraju uslovima.
     */
    public List<TruckLoad> getLoads(TruckLoad load) throws Exception {
        List<Driver> drivers = getAllDrivers(new Driver());
        GetAllLoads operation = new GetAllLoads();
        operation.execute(load);
        List<TruckLoad> allLoads = operation.getLoads();
        
        for(TruckLoad tl:allLoads){
            for(Driver dr:drivers){
                if(tl.getDriver().getId().equals(dr.getId())){
                    tl.setDriver(dr);
                    break;
                }
            }
        }
        
        List<TruckLoad> loads = new ArrayList<>();
        
        for(TruckLoad tl:allLoads){
            if(tl.getStartDate().equals(load.getStartDate()))
                loads.add(tl);
        }
        
        if(loads.isEmpty()){
            throw new Exception("No load match the criteria.");
        }
        return loads;
    }
    
    /**
     * Vraca sve servise kamiona koji odgovaraju po odredjenim parametrima servisu prosledjenom u pozivu metode.
     * @param truckMaintenance - Servis kamiona koji sluzi za poredjenje sa svim servisima iz baze podataka.
     * @return truckMaintenances - Lista servisa kamiona koji odgovaraju prosledjenom servisu.
     * @throws Exception - Ukoliko nema servisa kamiona koji odgovaraju uslovima.
     */
    public List<TruckMaintenance> getTruckMaintenances(TruckMaintenance truckMaintenance) throws Exception {
        List<Truck> trucks = getAllTrucks(new Truck());
        GetAllTruckMaintenances operation = new GetAllTruckMaintenances();
        operation.execute(truckMaintenance);
        List<TruckMaintenance> allTruckMaintenances = operation.getTruckMaintenances();
        
        for(TruckMaintenance tm:allTruckMaintenances){
            for(Truck tr:trucks){
                if(tm.getTruck().getId().equals(tr.getId())){
                    tm.setTruck(tr);
                    break;
                }
            }
        }
        
        List<TruckMaintenance> truckMaintenances = new ArrayList<>();
        
        for(TruckMaintenance tm:allTruckMaintenances){
            if(tm.getDateOfService().equals(truckMaintenance.getDateOfService()))
                truckMaintenances.add(tm);
        }
        
        if(truckMaintenances.isEmpty()){
            throw new Exception("No truck maintenance match the criteria.");
        }
        return truckMaintenances;
    }
    
    /**
     * Dodaje kamion u bazu podataka.
     * @param truck - Kamion koji treba da se doda u bazu podataka.
     * @throws Exception - Ukoliko se desi greska prilikom dodavanja kamiona u bazu podataka.
     */
    public void addTruck(Truck truck) throws Exception{
        SaveTruck operation = new SaveTruck();
        operation.execute(truck);
    }
    
    /**
     * Dodaje vozaca u bazu podataka.
     * @param driver - Vozac koji treba da se doda u bazu podataka.
     * @throws Exception - Ukoliko se desi greska prilikom dodavanja vozaca u bazu podataka.
     */
    public void addDriver(Driver driver) throws Exception{
        SaveDriver operation = new SaveDriver();
        operation.execute(driver);
    }
    
    /**
     * Dodaje tovar u bazu podataka.
     * @param load - Tovar koji treba da se doda u bazu podataka.
     * @throws Exception - Ukoliko se desi greska prilikom dodavanja tovara u bazu podataka.
     */
    public void addLoad(TruckLoad load) throws Exception {
        SaveLoad operation = new SaveLoad();
        operation.execute(load);
    }
    
    /**
     * Menja odredjeni kamion u bazi podataka.
     * @param truck - Izmenjeni tovar na osnovu koga treba da se promeni odgovarajuci kamion u samoj bazi podataka.
     * @throws Exception - Ukoliko se desi greska prilikom izmene kamiona u bazi podataka.
     */
    public void editTruck(Truck truck) throws Exception {
        EditTruck operation = new EditTruck();
        operation.execute(truck);
    }
    
    /**
     * Menja odredjenog vozaca u bazi podataka.
     * @param driver - Izmenjeni vozac na osnovu koga treba da se promeni odgovarajuci vozac u samoj bazi podataka.
     * @throws Exception - Ukoliko se desi greska prilikom izmene vozaca u bazi podataka.
     */
    public void editDriver(Driver driver) throws Exception {
        EditDriver operation = new EditDriver();
        operation.execute(driver);
    }
    
    /**
     * Menja odredjeni tovar u bazi podataka.
     * @param load - Izmenjeni tovar na osnovu koga treba da se promeni odgovarajuci tovar u samoj bazi podataka.
     * @throws Exception - Ukoliko se desi greska prilikom izmene tovara u bazi podataka.
     */
    public void editLoad(TruckLoad load) throws Exception {
        EditLoad operation = new EditLoad();
        operation.execute(load);
    }
    
    /**
     * Brise odredjenog vozaca iz baze podataka.
     * @param driver - Vozac koji treba da se obrise iz baze podataka.
     * @throws Exception - Ukoliko se desi greska prilikom brisanja vozaca u bazi podataka.
     */
    public void deleteDriver(Driver driver) throws Exception {
        DeleteDriver operation = new DeleteDriver();
        operation.execute(driver);
    }
    
    /**
     * Brise tovar iz baze podataka.
     * @param load - Tovar koji treba da se obrise iz baze podataka.
     * @throws Exception - Ukoliko dodje do greske prilikom brisanja tovara iz baze podataka.
     */
    public void deleteLoad(TruckLoad load) throws Exception {
        DeleteLoad operation = new DeleteLoad();
        operation.execute(load);
    }
}
