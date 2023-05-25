package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TruckLoad implements GenericEntity{
    private Long id;
    private Date startDate;
    private Date endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal incomePerKilometer;
    private Driver driver;
    
    List<LoadItem> loadItems;

    public TruckLoad() {
        this.loadItems = new ArrayList<>();
    }

    public TruckLoad(Long id, Date startDate, Date endDate, LocalTime startTime, LocalTime endTime, BigDecimal incomePerKilometer, Driver driver) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.incomePerKilometer = incomePerKilometer;
        this.driver = driver;
        this.loadItems = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getIncomePerKilometer() {
        return incomePerKilometer;
    }

    public void setIncomePerKilometer(BigDecimal incomePerKilometer) {
        this.incomePerKilometer = incomePerKilometer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<LoadItem> getLoadItems() {
        return loadItems;
    }

    public void setLoadItems(List<LoadItem> loadItems) {
        this.loadItems = loadItems;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.startDate);
        hash = 89 * hash + Objects.hashCode(this.endDate);
        hash = 89 * hash + Objects.hashCode(this.startTime);
        hash = 89 * hash + Objects.hashCode(this.endTime);
        hash = 89 * hash + Objects.hashCode(this.incomePerKilometer);
        hash = 89 * hash + Objects.hashCode(this.driver);
        hash = 89 * hash + Objects.hashCode(this.loadItems);
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
        final TruckLoad other = (TruckLoad) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        if (!Objects.equals(this.incomePerKilometer, other.incomePerKilometer)) {
            return false;
        }
        if (!Objects.equals(this.driver, other.driver)) {
            return false;
        }
        return Objects.equals(this.loadItems, other.loadItems);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return id + " | Departure date: " + sdf.format(startDate) + " | Arrival date: " + sdf.format(endDate) + " | Departure time: " + startTime.format(formatter) + " | Arrival time: " + endTime.format(formatter) + " | Income per kilometer: " + incomePerKilometer
                  + " // Driver: " + driver.toString().substring(4, driver.toString().indexOf('|', 4)).trim();
    }

    @Override
    public String getTableName() {
        return "truck_load";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "start_date, end_date, start_time, end_time, income_per_km, driver_id";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "start_date", "end_date", "start_time", "end_time", "income_per_km", "driver_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        java.sql.Time sqlStartTime = java.sql.Time.valueOf(startTime);
        java.sql.Time sqlEndTime = java.sql.Time.valueOf(endTime);
        return "'" + sqlStartDate + "'" + ", " + "'" + sqlEndDate + "'" + ", " + "'" + sqlStartTime + "'" + ", " + "'" + sqlEndTime + "'" + ", " + incomePerKilometer + ", " + driver.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getDate", "getDate", "getTime", "getTime", "getBigDecimal", "getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        java.sql.Time sqlStartTime = java.sql.Time.valueOf(startTime);
        java.sql.Time sqlEndTime = java.sql.Time.valueOf(endTime);
        return "start_date = '" + sqlStartDate + "', " + "end_date = '" + sqlEndDate + "', " + "start_time = '" + sqlStartTime + "', " + "end_time = '" + sqlEndTime + "', " + "income_per_km = " + incomePerKilometer + ", " + "driver_id = " + driver.getId();
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
