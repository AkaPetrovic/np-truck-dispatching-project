package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Aka
 */
public class TruckMaintenance implements GenericEntity {

    private Long id;
    private Date dateOfService;
    private BigDecimal kmAtService;
    private Truck truck;

    public TruckMaintenance() {
    }

    public TruckMaintenance(Long id, Date dateOfService, BigDecimal kmAtService, Truck truck) {
        this.id = id;
        this.dateOfService = dateOfService;
        this.kmAtService = kmAtService;
        this.truck = truck;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(Date dateOfService) {
        this.dateOfService = dateOfService;
    }

    public BigDecimal getKmAtService() {
        return kmAtService;
    }

    public void setKmAtService(BigDecimal kmAtService) {
        this.kmAtService = kmAtService;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.dateOfService);
        hash = 43 * hash + Objects.hashCode(this.kmAtService);
        hash = 43 * hash + Objects.hashCode(this.truck);
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
        final TruckMaintenance other = (TruckMaintenance) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateOfService, other.dateOfService)) {
            return false;
        }
        if (!Objects.equals(this.kmAtService, other.kmAtService)) {
            return false;
        }
        return Objects.equals(this.truck, other.truck);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        return id + " | Truck: " + truck + " | Date of service: " + sdf.format(dateOfService) + " | KM at service: " + kmAtService;
    }
    
    @Override
    public String getTableName() {
        return "truck_maintenance";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "date_of_service", "km_at_service", "truck_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getDate", "getBigDecimal", "getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereConditionEditOperation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
