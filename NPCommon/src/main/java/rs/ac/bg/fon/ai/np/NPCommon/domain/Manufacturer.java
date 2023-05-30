package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.util.Objects;

/**
 * Predstavlja proizvodjaca kamiona.
 * 
 * Sadrzi ID vrednost, naziv i podatak o tome iz koje drzave dolazi proizvodjac (klase Country).
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Manufacturer implements GenericEntity{
    /**
     * ID proizvodjaca kao Long vrednost (ceo broj).
     */
    private Long id;
    /**
     * Naziv proizvodjaca kao String.
     */
    private String name;
    /**
     * Drzava iz koje dolazi proizvodjac klase Country.
     */
    private Country country;

    /**
     * Prazan konstruktor za kreiranje jedne instance proizvodjaca sa podrazumevanim vrednostima za njegova polja.
     */
    public Manufacturer() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance proizvodjaca sa specificnim vrednostima za njegova polja.
     * @param id - ID vrednost koja se dodeljuje proizvodjacu prilikom kreiranja.
     * @param name - Naziv proizvodjaca koji se dodeljuje proizvodjacu prilikom kreiranja.
     * @param country - Drzava iz koje proizvodjac dolazi koja se dodeljuje prilikom kreiranja.
     */
    public Manufacturer(Long id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    /**
     * Vraca ID proizvodjaca.
     * @return id - ID proizvodjaca kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vraca naziv proizvodjaca.
     * @return name - Naziv proizvodjaca kao String.
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlje novu vrednost za atribut name proizvodjaca.
     * @param name - Nova vrednost za atribut name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Vraca drzavu iz koje proizvodjac dolazi.
     * @return country - Drzava iz koje proizvodjac dolazi klase Country.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Postavlje novu vrednost za atribut country proizvodjaca.
     * @param country - Nova vrednost za atribut country.
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
	 * Racuna hash code na osnovu svih atributa proizvodjaca.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa proizvodjaca.
	 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.country);
        return hash;
    }

    /**
	 * Poredi dva proizvodjaca prema svim atributima.
	 * 
	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca proizvodjaca nad kojom je pozvana metoda equals().
	 * @return 
	 * <ul>
	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase Manufacturer ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
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
        final Manufacturer other = (Manufacturer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.country, other.country);
    }

    /**
     * Vraca String reprezentaciju proizvodjaca na osnovu atributa name i country.
     * 
     * @return manufacturer - String reprezentacija proizvodjaca u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return name + " (" + country.getName() + ")";
    }

    @Override
    public String getTableName() {
        return "manufacturer";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "name", "country_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getLong"};
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
