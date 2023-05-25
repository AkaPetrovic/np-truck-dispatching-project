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

public class Controller {
    private static Controller controller;

    private Controller() {
    }
    
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
    
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
    
    public List<Country> getAllCountries(Country country) throws Exception {
        GetAllCountries operation = new GetAllCountries();
        operation.execute(country);
        List<Country> countries = operation.getCountries();
        if(countries.isEmpty()){
            throw new Exception("No countries were found in the database.");
        }
        return countries;
    }

    public List<TruckType> getAllTruckTypes(TruckType truckType) throws Exception {
        GetAllTruckTypes operation = new GetAllTruckTypes();
        operation.execute(truckType);
        List<TruckType> truckTypes = operation.getTruckTypes();
        if(truckTypes.isEmpty()){
            throw new Exception("No truck types were found in the database.");
        }
        return truckTypes;
    }
    
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
    
    public void addTruck(Truck truck) throws Exception{
        SaveTruck operation = new SaveTruck();
        operation.execute(truck);
    }
    
    public void addDriver(Driver driver) throws Exception{
        SaveDriver operation = new SaveDriver();
        operation.execute(driver);
    }
    
    public void addLoad(TruckLoad load) throws Exception {
        SaveLoad operation = new SaveLoad();
        operation.execute(load);
    }
    
    public void editTruck(Truck truck) throws Exception {
        EditTruck operation = new EditTruck();
        operation.execute(truck);
    }
    
    public void editDriver(Driver driver) throws Exception {
        EditDriver operation = new EditDriver();
        operation.execute(driver);
    }
    
    public void editLoad(TruckLoad load) throws Exception {
        EditLoad operation = new EditLoad();
        operation.execute(load);
    }
    
    public void deleteDriver(Driver driver) throws Exception {
        DeleteDriver operation = new DeleteDriver();
        operation.execute(driver);
    }
    
    public void deleteLoad(TruckLoad load) throws Exception {
        DeleteLoad operation = new DeleteLoad();
        operation.execute(load);
    }
}
