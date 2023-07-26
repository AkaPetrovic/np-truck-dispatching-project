package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Predstavlja servis kamiona.
 * 
 * Sadrzi ID vrednost, datum servisa, broj predjenih kilometara u trenutku servisa i podatak o kom se kamionu radi.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class TruckMaintenance implements GenericEntity {
	/**
     * ID servisa kao Long vrednost (ceo broj).
     */
    private Long id;
    /**
     * Datum servisa kamiona kao Date.
     */
    private Date dateOfService;
    /**
     * Broj predjenih kilometara kamiona u trenutku servisa kao decimalan broj.
     */
    private BigDecimal kmAtService;
    /**
     * Kamion na koji se servis odnosi, klase Truck.
     */
    private Truck truck;

    /**
     * Prazan konstruktor za kreiranje jedne instance tovara sa podrazumevanim vrednostima za njegova polja.
     */
    public TruckMaintenance() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance servisa sa specificnim vrednostima za njegova polja.
     * @param id - ID vrednost koja se dodeljuje servisu prilikom njegovog kreiranja.
     * @param dateOfService - Datum servisa koji se dodeljuje kamionu prilikom njegovog kreiranja.
     * @param kmAtService - Broj predjenih kilometara koji se dodeljuje servisu prilikom njegovog kreiranja.
     * @param truck - Kamion koji se vezuje za servis prilikom njegovog kreiranja.
     */
    public TruckMaintenance(Long id, Date dateOfService, BigDecimal kmAtService, Truck truck) {
        setId(id);
        setDateOfService(dateOfService);
        setKmAtService(kmAtService);
        setTruck(truck);
    }
    
    /**
     * Vraca ID servisa.
     * @return id - ID servisa kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Vraca datum servisa vezan za kamion.
     * @return dateOfService - Datum servisa vezan za kamion kao Date.
     */
    public Date getDateOfService() {
        return dateOfService;
    }

    /**
     * Postavlje novu vrednost za atribut dateOfService servisa.
     * @param dateOfService - Nova vrednost za atribut dateOfService.
     */
    public void setDateOfService(Date dateOfService) {
        this.dateOfService = dateOfService;
    }

    /**
     * Vraca broj predjenih kilometara u trenutku servisa kamiona.
     * @return kmAtService - Broj predjenih kilometara u trenutku servisa kamiona kao decimalan broj.
     */
    public BigDecimal getKmAtService() {
        return kmAtService;
    }

    /**
     * Postavlje novu vrednost za atribut kmAtService servisa.
     * @param kmAtService - Nova vrednost za atribut kmAtService.
     */
    public void setKmAtService(BigDecimal kmAtService) {
        this.kmAtService = kmAtService;
    }

    /**
     * Vraca kamion koji se servisira.
     * @return truck - Kamion koji se servisira klase Truck.
     */
    public Truck getTruck() {
        return truck;
    }

    /**
     * Postavlje novu vrednost za atribut truck servisa.
     * @param truck - Nova vrednost za atribut truck.
     */
    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    /**
	 * Racuna hash code na osnovu svih atributa servisa.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa servisa.
	 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.dateOfService);
        hash = 43 * hash + Objects.hashCode(this.kmAtService);
        hash = 43 * hash + Objects.hashCode(this.truck);
        return hash;
    }

    /**
   	 * Poredi dva servisa prema svim atributima.
   	 * 
   	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca servisa nad kojom je pozvana metoda equals().
   	 * @return 
   	 * <ul>
   	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
   	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase TruckMaintenance ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
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

    /**
     * Vraca String reprezentaciju servisa na osnovu svih atributa.
     * 
     * @return truckMaintenance - String reprezentacija servisa u odgovarajucem formatu.
     */
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
