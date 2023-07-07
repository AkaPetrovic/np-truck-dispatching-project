package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Predstavlja vozaca kamiona.
 * 
 * Sadrzi ID, ime, prezime, datum rodjenja i podatak o tome koji kamion vozi.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Driver implements GenericEntity{
	/**
	 * ID vozaca u vidu Long vrednosti (ceo broj).
	 */
    private Long id;
    /**
     * Ime vozaca kao String.
     */
    private String name;
    /**
     * Prezime vozaca kao String.
     */
    private String surname;
    /**
     * Datum rodjenja vozaca.
     */
    private Date birthday;
    /**
     * Kamion tipa Truck koji vozac vozi.
     */
    private Truck truck;

    /**
     * Prazan konstruktor za kreiranje jedne instance vozaca sa podrazumevanim vrednostima za njegova polja.
     */
    public Driver() {
    }
    
    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance vozaca sa specificnim vrednostima za njegova polja.
     * @param id - ID vozaca koji mu se dodeljuje pri kreiranju.
     * @param name - Ime vozaca koje mu se dodeljuje prilikom kreiranja.
     * @param surname - Prezime vozaca koje mu se dodeljuje prilikom kreiranja.
     * @param birthday - Datum rodjenja vozaca koji mu se dodeljuje prilikom kreiranja.
     * @param truck - Kamion klase Truck koji se vezuje za vozaca prilikom kreiranja instance vozaca.
     */
    public Driver(Long id, String name, String surname, Date birthday, Truck truck) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.truck = truck;
    }

    /**
     * Vraca ID vozaca.
     * @return id - ID vozaca kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Vraca ID vozaca.
     * @return id - ID vozaca kao Long vrednost (ceo broj).
     */
    public String getName() {
        return name;
    }
    
    /**
     * Postavlje novu vrednost za atribut name vozaca.
     * @param name - Nova vrednost za atribut name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Vraca prezime vozaca.
     * @return surname - Prezime vozaca kao String.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Postavlje novu vrednost za atribut surname vozaca.
     * @param surname - Nova vrednost za atribut surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Vraca datum rodjenja vozaca.
     * @return birthday - Datum rodjenja vozaca kao objekat klase Date.
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Postavlje novu vrednost za atribut birthday vozaca.
     * @param birthday - Nova vrednost za atribut birthday.
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Vraca podatak o kamionu vozaca.
     * @return truck - Kamion koji vozac vozi klase Truck.
     */
    public Truck getTruck() {
        return truck;
    }

    /**
     * Postavlje novu vrednost za atribut truck vozaca.
     * @param truck - Nova vrednost za atribut truck.
     */
    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    /**
	 * Racuna hash code na osnovu svih atributa vozaca.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa vozaca.
	 */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + Objects.hashCode(this.birthday);
        hash = 97 * hash + Objects.hashCode(this.truck);
        return hash;
    }

    /**
	 * Poredi dva vozaca prema svim atributima.
	 * 
	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca vozaca nad kojom je pozvana metoda equals().
	 * @return 
	 * <ul>
	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase Driver ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
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
        final Driver other = (Driver) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return Objects.equals(this.truck, other.truck);
    }

    /**
     * Vraca String reprezentaciju vozaca na osnovu svih atributa.
     * 
     * @return driver - String reprezentacija vozaca u odgovarajuce formatu.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        return id + " | " + name + " " + surname + " | Birthday: " + sdf.format(birthday)
                  + " // Truck: " + truck.toString().substring(4, truck.toString().indexOf('|', 4)).trim();
    }

    @Override
    public String getTableName() {
        return "driver";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, surname, birthday, truck_id";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "name", "surname", "birthday", "truck_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
        return "'" + name + "'" + ", " + "'" + surname + "'" + ", " + "'" + sqlDate + "'" + ", " + truck.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getDate", "getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
        return "name = '" + name + "', " + "surname = '" + surname + "', " + "birthday = '" + sqlDate + "', " + "truck_id = " + truck.getId();
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
