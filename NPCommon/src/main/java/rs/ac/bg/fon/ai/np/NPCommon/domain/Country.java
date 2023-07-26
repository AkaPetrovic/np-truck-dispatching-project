package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.util.Objects;

/**
 * Predstavlja drzavu koja se vezuje za odredjenog proizvodjaca kamiona.
 * 
 * Sadrzi ID i naziv drzave.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Country implements GenericEntity {
	/**
	 * ID drzave u vidu Long vrednosti (ceo broj).
	 */
    private Long id;
    /**
     * Naziv drzave kao String.
     */
    private String name;

    /**
     * Prazan konstruktor za kreiranje jedne instance drzave sa podrazumevanim vrednostima za njena polja.
     */
    public Country() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance drzave sa specificnim vrednostima za njena polja.
     * @param id - ID drzave koji joj se dodaje prilikom njenog kreiranja
     * @param name - Naziv drzave koji joj se dodaje prilikom njenog kreiranja
     */
    public Country(Long id, String name) {
        setId(id);
        setName(name);
    }

    /**
     * Vraca ID drzave.
     * @return id - ID drzave kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Vraca naziv drzave.
     * @return name - Naziv drzave kao String.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Postavlje novu vrednost za atribut name drzave.
     * @param name - Nova vrednost za atribut name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * Racuna hash code na osnovu svih atributa drzave.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa drzave.
	 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
	 * Poredi dve drzave prema svim atributima.
	 * 
	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca drzave nad kojom je pozvana metoda equals().
	 * @return 
	 * <ul>
	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase Country ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
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
        final Country other = (Country) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Vraca String reprezentaciju drzave na osnovu atributa name.
     * 
     * @return country - String reprezentacija drzave u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTableName() {
        return "country";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "name"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString"};
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
