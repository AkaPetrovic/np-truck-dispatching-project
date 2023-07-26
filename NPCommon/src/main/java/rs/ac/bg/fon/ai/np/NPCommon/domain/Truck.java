package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Predstavlja kamion koji je u vlasnistvu kompanije.
 * 
 * Sadrzi ID, naziv modela kamiona, snagu, broj predjenih kilometara, godinu proizvodnje, nosivost, podatak o proizvodjacu, kao i tipu kamiona.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Truck implements GenericEntity{
	/**
	 * ID kamiona kao Long vrednost (ceo broj).
	 */
    private Long id;
    /**
     * Model kamiona kao String.
     */
    private String model;
    /**
     * Snaga kamiona kao ceo broj.
     */
    private int power;
    /**
     * Broj predjenih kilometara kao decimalan broj.
     */
    private BigDecimal kmTravelled;
    /**
     * Godina proizvodnje kamiona kao ceo broj.
     */
    private int year;
    /**
     * Nosivost kamiona kao decimalan broj.
     */
    private BigDecimal carryingCapacity;
    /**
     * Proizvodjac kamiona klase Manufacturer.
     */
    private Manufacturer manufacturer;
    /**
     * Tip kamiona klase TruckType.
     */
    private TruckType truckType;

    /**
     * Prazan konstruktor za kreiranje jedne instance kamiona sa podrazumevanim vrednostima za njegova polja.
     */
    public Truck() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance kamiona sa specificnim vrednostima za njegova polja.
     * @param id - ID kamiona koji mu se dodeljuje prilikom kreiranja.
     * @param model - Vrednost atributa model koja predstavlja naziv modela kamiona i dodeljuje mu se prilikom kreiranja.
     * @param power - Snaga kamiona koja mu se dodeljuje prilikom kreiranja.
     * @param kmTravelled - Broj predjenih kilometara kamiona koji mu se dodeljuje prilikom kreiranja.
     * @param year - Godina proizvodnje kamiona koja mu se dodeljuje prilikom kreiranja.
     * @param carryingCapacity - Nosivost kamiona koja mu se dodeljuje prilikom kreiranja.
     * @param manufacturer - Objekat koji predstavlja proizvodjaca kamiona i koji se vezuje za sam kamion prilikom njegovog kreiranja.
     * @param truckType - Objekat koji predstavlja tip kamiona i koji se vezuje za sam kamion prilikom njegovog kreiranja.
     */
    public Truck(Long id, String model, int power, BigDecimal kmTravelled, int year, BigDecimal carryingCapacity, Manufacturer manufacturer, TruckType truckType) {
        setId(id);
        setModel(model);
        setPower(power);
        setKmTravelled(kmTravelled);
        setYear(year);
        setCarryingCapacity(carryingCapacity);
        setManufacturer(manufacturer);
        setTruckType(truckType);
    }

    /**
     * Vraca ID kamiona.
     * @return id - ID kamiona kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
    	if(id == null)
    		throw new NullPointerException("ID vrednost ne sme biti null.");
    	
    	if(id < 1)
    		throw new IllegalArgumentException("ID vrednost ne sme biti manja od 1.");
    	
        this.id = id;
    }

    /**
     * Vraca naziv modela kamiona.
     * @return model - Model kamiona kao String.
     */
    public String getModel() {
        return model;
    }

    /**
     * Postavlje novu vrednost za atribut model kamiona.
     * @param model - Nova vrednost za atribut model.
     * 
     * @throws NullPointerException - ako se unese null vrednost za model
	 * @throws IllegalArgumentException - ako je model prazan String
     */
    public void setModel(String model) {
    	if(model == null)
    		throw new NullPointerException("Naziv modela ne sme biti null.");
    	
    	if(model.isEmpty())
    		throw new IllegalArgumentException("Naziv modela ne sme biti prazan String.");
    	
        this.model = model;
    }

    /**
     * Vraca snagu kamiona.
     * @return power - Snaga kamiona kao ceo broj.
     */
    public int getPower() {
        return power;
    }

    /**
     * Postavlje novu vrednost za atribut power kamiona.
     * @param power - Nova vrednost za atribut power.
     * 
     * @throws IllegalArgumentException - ako je snaga kamiona negativan broj
     */
    public void setPower(int power) {
    	if(power < 0)
    		throw new IllegalArgumentException("Snaga kamiona ne moze biti negativan broj.");
    	
        this.power = power;
    }

    /**
     * Vraca broj predjenih kilometara kamiona.
     * @return kmTravelled - Broj predjenih kilometara kamiona kao BigDecimal (decimalan broj).
     */
    public BigDecimal getKmTravelled() {
        return kmTravelled;
    }

    /**
     * Postavlje novu vrednost za atribut kmTravelled kamiona.
     * @param kmTravelled - Nova vrednost za atribut kmTravelled.
     * 
     * @throws NullPointerException - ako se unese null vrednost za kmTravelled
	 * @throws IllegalArgumentException - ako je kmTravelled negativan broj
     */
    public void setKmTravelled(BigDecimal kmTravelled) {
    	if(kmTravelled == null)
    		throw new NullPointerException("Broj predjenih kilometara kamiona ne sme biti null.");
    	
    	if(kmTravelled.intValue() < 0)
    		throw new IllegalArgumentException("Broj predjenih kilometara kamiona ne sme biti negativan broj.");
    	
        this.kmTravelled = kmTravelled;
    }

    /**
     * Vraca godinu proizvodnje kamiona.
     * @return year - Godina proizvodnje kamiona kao ceo broj.
     */
    public int getYear() {
        return year;
    }

    /**
     * Postavlje novu vrednost za atribut year kamiona.
     * @param year - Nova vrednost za atribut year.
     * 
     * @throws IllegalArgumentException - ako je year negativan broj
     */
    public void setYear(int year) {
    	if(year < 0)
    		throw new IllegalArgumentException("Godina proizvodnje kamiona ne moze biti negativan broj.");
    	
        this.year = year;
    }

    /**
     * Vraca nosivost kamiona.
     * @return carryingCapacity - Nosivost kamiona kao BigDecimal vrednost (decimalan broj).
     */
    public BigDecimal getCarryingCapacity() {
        return carryingCapacity;
    }

    /**
     * Postavlje novu vrednost za atribut carryingCapacity kamiona.
     * @param carryingCapacity - Nova vrednost za atribut carryingCapacity.
     * 
     * @throws NullPointerException - ako se unese null vrednost za carryingCapacity
	 * @throws IllegalArgumentException - ako je carryingCapacity negativan broj
     */
    public void setCarryingCapacity(BigDecimal carryingCapacity) {
    	if(carryingCapacity == null)
    		throw new NullPointerException("Nosivost kamiona ne sme biti null.");
    	
    	if(carryingCapacity.intValue() < 0)
    		throw new IllegalArgumentException("Nosivost kamiona ne sme biti negativan broj.");
    	
        this.carryingCapacity = carryingCapacity;
    }
    
    /**
     * Vraca proizvodjaca kamiona.
     * @return manufacturer - Proizvodjac kamiona koji je tipa Manufacturer.
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Postavlje novu vrednost za atribut manufacturer kamiona.
     * @param manufacturer - Nova vrednost za atribut manufacturer.
     * 
     * @throws NullPointerException - ako se unese null vrednost za manufacturer
     */
    public void setManufacturer(Manufacturer manufacturer) {
    	if(manufacturer == null)
    		throw new NullPointerException("Proizvodjac kamiona ne sme biti null.");
    	
        this.manufacturer = manufacturer;
    }

    /**
     * Vraca tip kamiona.
     * @return truckType - Tip kamiona koji je tipa TruckType.
     */
    public TruckType getTruckType() {
        return truckType;
    }

    /**
     * Postavlje novu vrednost za atribut truckType kamiona.
     * @param truckType - Nova vrednost za atribut truckType.
     * 
     * @throws NullPointerException - ako se unese null vrednost za truckType
     */
    public void setTruckType(TruckType truckType) {
    	if(truckType == null)
    		throw new NullPointerException("Tip kamiona ne sme biti null.");
    	
        this.truckType = truckType;
    }

    /**
	 * Racuna hash code na osnovu svih atributa kamiona.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa kamiona.
	 */
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

    /**
	 * Poredi dva kamiona prema svim atributima.
	 * 
	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca kamiona nad kojom je pozvana metoda equals().
	 * @return 
	 * <ul>
	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase Truck ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
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

    /**
     * Vraca String reprezentaciju kamiona sa svim njegovim atributima.
     * 
     * @return truck - String reprezentacija kamiona u odgovarajucem formatu.
     */
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
