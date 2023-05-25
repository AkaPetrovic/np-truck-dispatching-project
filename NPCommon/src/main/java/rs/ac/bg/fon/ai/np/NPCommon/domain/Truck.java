package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class Truck implements GenericEntity{
    private Long id;
    private String model;
    private int power;
    private BigDecimal kmTravelled;
    private int year;
    private BigDecimal carryingCapacity;
    private Manufacturer manufacturer;
    private TruckType truckType;

    public Truck() {
    }

    public Truck(Long id, String model, int power, BigDecimal kmTravelled, int year, BigDecimal carryingCapacity, Manufacturer manufacturer, TruckType truckType) {
        this.id = id;
        this.model = model;
        this.power = power;
        this.kmTravelled = kmTravelled;
        this.year = year;
        this.carryingCapacity = carryingCapacity;
        this.manufacturer = manufacturer;
        this.truckType = truckType;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public BigDecimal getKmTravelled() {
        return kmTravelled;
    }

    public void setKmTravelled(BigDecimal kmTravelled) {
        this.kmTravelled = kmTravelled;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(BigDecimal carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
    
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public TruckType getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckType truckType) {
        this.truckType = truckType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.model);
        hash = 37 * hash + this.power;
        hash = 37 * hash + Objects.hashCode(this.kmTravelled);
        hash = 37 * hash + this.year;
        hash = 37 * hash + Objects.hashCode(this.carryingCapacity);
        hash = 37 * hash + Objects.hashCode(this.manufacturer);
        hash = 37 * hash + Objects.hashCode(this.truckType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Truck other = (Truck) obj;
        if (this.power != other.power) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.kmTravelled, other.kmTravelled)) {
            return false;
        }
        if (!Objects.equals(this.carryingCapacity, other.carryingCapacity)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        return Objects.equals(this.truckType, other.truckType);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return id + " | " + manufacturer + " " + model + " | Year: " + year + " | Power: " + power + " HP | Type: " + truckType + " | Carrying capacity: " + df.format(Double.parseDouble(carryingCapacity.toString())) + " | KM travelled: " + df.format(Double.parseDouble(kmTravelled.toString()));
    }

    @Override
    public String getTableName() {
        return "truck";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "model, power, kilometers, year, carrying_capacity, manufacturer_id, truck_type_id";
    }
    
    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "model", "power", "kilometers", "year", "carrying_capacity", "manufacturer_id", "truck_type_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return "'" + model + "'" + ", " + power + ", " + kmTravelled + ", " + year + ", " + carryingCapacity + ", " + manufacturer.getId() + ", " + truckType.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getInt", "getBigDecimal", "getInt", "getBigDecimal", "getLong", "getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        return "model = '" + model + "', " + "power = " + power + ", " + "kilometers = " + kmTravelled + ", " + "year = " + year + ", " + "carrying_capacity = " + carryingCapacity + ", " + "manufacturer_id = " + manufacturer.getId() + ", " + "truck_type_id = " + truckType.getId();
    }

    @Override
    public String getWhereCondition() {
        return "id = " + id;
    }

    @Override
    public String getWhereConditionEditOperation() {
        return "id = " + id;
    }
}
