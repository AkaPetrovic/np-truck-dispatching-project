package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.util.Objects;

/**
 * Predstavlja tip kamiona.
 * 
 * Sadrzi ID vrednost i naziv tipa.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class TruckType implements GenericEntity{
	/**
     * ID tipa kao Long vrednost (ceo broj).
     */
    private Long id;
    /**
     * Naziv tipa kao String.
     */
    private String name;

    /**
     * Prazan konstruktor za kreiranje jedne instance tovara sa podrazumevanim vrednostima za njegova polja.
     */
    public TruckType() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance tipa kamiona sa specificnim vrednostima za njegova polja.
     * @param id - ID vrednost koja se dodeljuje tipu kamiona prilikom njegovog kreiranja.
     * @param name - Naziv tipa kamiona koji se dodeljuje samom tipu prilikom njegovog kreiranja.
     */
    public TruckType(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /**
     * Vraca ID tipa kamiona.
     * @return id - ID tipa kamiona kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Vraca naziv tipa kamiona.
     * @return name - Naziv tipa kamiona kao String.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Postavlje novu vrednost za atribut name tipa kamiona.
     * @param name - Nova vrednost za atribut name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * Racuna hash code na osnovu svih atributa tipa kamiona.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa tipa kamiona.
	 */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
   	 * Poredi dva tipa kamiona prema svim atributima.
   	 * 
   	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca tipa kamiona nad kojom je pozvana metoda equals().
   	 * @return 
   	 * <ul>
   	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
   	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase TruckType ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
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
        final TruckType other = (TruckType) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Vraca String reprezentaciju tipa na osnovu atributa name.
     * 
     * @return truckType - String reprezentacija tipa kamiona u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public String getTableName() {
        return "truck_type";
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

