package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.util.Objects;

/**
 * Predstavlja korisnika koji se prijavljuje prilikom pokretanja aplikacije.
 * 
 * Sadrzi ID, osnovne podatke u vidu imena i prezimena, kao i podatke sa kojima ce se prijavljivati na sistem (username i password).
 * Korisnik takodje sadrzi i podatak koji predstavlja njegovu ulogu.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class User implements GenericEntity {
    
	/**
	 * ID korisnika kao ceo broj.
	 */
    private Long id;
    /**
     * Ime korisnika kao String.
     */
    private String firstname;
    /**
     * Prezime korisnika kao String.
     */
    private String lastname;
    /**
     * Username korisnika kao String.
     */
    private String username;
    /**
     * Password korisnika kao String.
     */
    private String password;
    /**
     * Uloga korisnika kao String.
     */
    private String role;

    /**
     * Prazan konstruktor za kreiranje jedne instance korisnika sa podrazumevanim vrednostima za njegova polja.
     */
    public User() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance korisnika sa specificnim vrednostima za njegova polja.
     * @param id - ID korisnika koji se kreira.
     * @param firstname - Ime korisnika koji se kreira.
     * @param lastname - Prezime korisnika koji se kreira.
     * @param username - Korisnicko ime (username) korisnika koji se kreira i koji ce se koristiti prilikom prijave na sistem.
     * @param password - Lozinka (password) korisnika koji se kreira i koja ce se koristiti prilikom prijave korisnika na sistem.
     * @param role - Uloga korisnika koju ce imati u sistemu, koja mu se dodeljuje prilikom kreiranja. Predvidjene dozvoljene vrednosti su "manager" i "dispatcher".
     */
    public User(Long id, String firstname, String lastname, String username, String password, String role) {
        setId(id);
        setFirstname(firstname);
        setLastname(lastname);
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    /**
     * Vraca ID korisnika.
     * @return id - ID korisnika kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vraca ime korisnika.
     * @return firstname - Ime korisnika kao String.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Postavlje novu vrednost za atribut firstname korisnika.
     * @param firstname - Nova vrednost za atribut ime.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Vraca prezime korisnika.
     * @return lastname - Prezime korisnika kao String.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Postavlje novu vrednost za atribut lastname korisnika.
     * @param lastname - Nova vrednost za atribut lastname.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Vraca korisnicko ime koje se vezuje za korisnika.
     * @return username - Korisnicko ime korisnika kao String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlje novu vrednost za atribut username korisnika.
     * @param username - Nova vrednost za atribut username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Vraca lozinku korisnika.
     * @return password - Lozinka korisnika kao String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlje novu vrednost za atribut password korisnika.
     * @param password - Nova vrednost za atribut password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Vraca ulogu korisnika.
     * @return role - Uloga korisnika kao String.
     */
    public String getRole() {
        return role;
    }

    /**
     * Postavlje novu vrednost za atribut role korisnika.
     * @param role - Nova vrednost za atribut role. Predvidjene dozvoljene vrednosti su "manager" i "dispatcher".
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
	 * Racuna hash code na osnovu svih atributa korisnika.
	 * 
	 * @return hash - Hash code izracunat na osnovu svih atributa korisnika.
	 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.firstname);
        hash = 67 * hash + Objects.hashCode(this.lastname);
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.role);
        return hash;
    }

    /**
	 * Poredi dva korisnika prema svim atributima.
	 * 
	 * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca korisnika nad kojom je pozvana metoda equals().
	 * @return 
	 * <ul>
	 * 		<li> true - ako je unet isti objekat ili ako su svi atributi isti </li>
	 * 		<li> false - ako je unet null objekat ili ako uneti objekat nije klase User ili ako se uneti objekat razlikuje po vrednosti nekog atributa </li>
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
        final User other = (User) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Vraca String reprezentaciju korisnika sa svim njegovim atributima.
     * 
     * @return user - String reprezentacija korisnika.
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, username, password, role";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "firstname", "lastname", "username", "password", "role"};
        return columnNames;
    }
    
    @Override
    public String getInsertValues() {
        return id + ", " + "'" + firstname + "'" + ", " + "'" + lastname + "'" + ", " + "'" + username + "'" + ", " + "'" + password + "'" + ", " + "'" + role + "'";
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getString", "getString", "getString"};
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
