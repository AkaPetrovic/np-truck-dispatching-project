package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja tovar koji kamion prevozi.
 * 
 * Sadrzi ID vrednost, datume i vremena polaska i dolaska, prihod po predjenom kilometru, vozaca za koga se vezuje kamion koji prevozi tovar i listu stavki koje se vezuju za sam tovar.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class TruckLoad implements GenericEntity{
	/**
     * ID tovara kao Long vrednost (ceo broj).
     */
    private Long id;
    /**
     * Datum polaska kao Date.
     */
    private Date startDate;
    /**
     * Datum dolaska kao Date.
     */
    private Date endDate;
    /**
     * Vreme polaska kao LocalTime.
     */
    private LocalTime startTime;
    /**
     * Vreme dolaska kao LocalTime.
     */
    private LocalTime endTime;
    /**
     * Prihod po kilometru kao decimalan broj.
     */
    private BigDecimal incomePerKilometer;
    /**
     * Vozac koji se vezuje za tovar koji se prevozi klase Driver.
     */
    private Driver driver;
    
    /**
     * Lista stavki tovara. Implementacija je u vidu ArrayList-e.
     */
    List<LoadItem> loadItems;

    /**
     * Prazan konstruktor za kreiranje jedne instance tovara sa podrazumevanim vrednostima za njegova polja.
     */
    public TruckLoad() {
        this.loadItems = new ArrayList<>();
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance tovara sa specificnim vrednostima za njegova polja.
     * @param id - ID vrednost tovara koja mu se dodeljuje prilikom kreiranja.
     * @param startDate - Datum polaska tovara koji mu se dodeljuje prilikom kreiranja.
     * @param endDate - Datum dolaska tovara koji mu se dodeljuje prilikom kreiranja.
     * @param startTime - Vreme polaska tovara koje mu se dodeljuje prilikom kreiranja.
     * @param endTime - Vreme dolaska tovara koje mu se dodeljuje prilikom kreiranja.
     * @param incomePerKilometer - Pocetna vrednost prihoda koji se ostvaruje svakim predjenim kilometrom.
     * @param driver - Vozac koji se vezuje za prevoz samog tovara.
     */
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

    /**
     * Vraca ID tovara.
     * @return id - ID tovara kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vraca datum polaska vezan za tovar.
     * @return startDate - Datum polaska vezan za tovar kao Date.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Postavlje novu vrednost za atribut startDate tovara.
     * @param startDate - Nova vrednost za atribut startDate.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Vraca datum dolaska vezan za tovar.
     * @return endDate - Datum dolaska vezan za tovar kao Date.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Postavlje novu vrednost za atribut endDate tovara.
     * @param endDate - Nova vrednost za atribut endDate.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Vraca vreme polaska vezano za tovar.
     * @return startTime - Vreme polaska vezano za tovar kao LocalTime.
     */
    public LocalTime getStartTime() {
        return startTime;
    }
    
    /**
     * Postavlje novu vrednost za atribut startTime tovara.
     * @param startTime - Nova vrednost za atribut startTime.
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Vraca vreme dolaska vezano za tovar.
     * @return endTime - Vreme dolaska vezano za tovar kao LocalTime.
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Postavlje novu vrednost za atribut endTime tovara.
     * @param endTime - Nova vrednost za atribut endTime.
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Vraca prihod po predjenom kilometru vezan za tovar.
     * @return incomePerKilometer - Prihod po predjenom kilometru vezan za tovar kao decimalan broj.
     */
    public BigDecimal getIncomePerKilometer() {
        return incomePerKilometer;
    }

    /**
     * Postavlje novu vrednost za atribut incomePerKilometer tovara.
     * @param incomePerKilometer - Nova vrednost za atribut incomePerKilometer.
     */
    public void setIncomePerKilometer(BigDecimal incomePerKilometer) {
        this.incomePerKilometer = incomePerKilometer;
    }

    /**
     * Vraca vozaca odgovornog za tovar.
     * @return driver - Vozac odgovoran za tovar klase Driver.
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Postavlje novu vrednost za atribut driver tovara.
     * @param driver - Nova vrednost za atribut driver.
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * Vraca list stavki tovara.
     * @return loadItems - Lista stavki tovara kao ArrayList.
     */
    public List<LoadItem> getLoadItems() {
        return loadItems;
    }

    /**
     * Postavlje novu vrednost za atribut loadItems tovara.
     * @param loadItems - Nova vrednost za atribut loadItems.
     */
    public void setLoadItems(List<LoadItem> loadItems) {
        this.loadItems = loadItems;
    }

    /**
	 * Racuna hash code na osnovu svih atributa tovara.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa tovara.
	 */
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

    /**
	 * Poredi dva tovara prema svim atributima.
	 * 
	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca tovara nad kojom je pozvana metoda equals().
	 * @return 
	 * <ul>
	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase TruckLoad ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
	 * </ul>
	 */
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

    /**
     * Vraca String reprezentaciju tovara na osnovu svih atributa.
     * 
     * @return truckLoad - String reprezentacija tovara u odgovarajucem formatu.
     */
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
