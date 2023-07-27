package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.io.Serializable;

/**
 * Predstavlja genericki entitet koji moze vratiti ime tabele u bazi, nazive kolona za operacije dodavanja i prikazivanja, 
 * vrednosti atributa za operaciju dodavanja, nazive metoda koje ce posluziti u radu sa ResultSet-om, 
 * vrednosti atributa za operaciju izmene podataka u bazi, kao i uslove koji ce se koristiti u operacijama brisanja i izmene podataka.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 * 
 */
public interface GenericEntity extends Serializable {

	/**
	 * Vraca naziv tabele datog entiteta u bazi podataka.
	 * @return tableName - Ime tabele u bazi podataka kao String vrednost.
	 */
    String getTableName();

    /**
     * Vraca nazive kolona koje ce se koristiti za potrebe operacije dodavanja novog entiteta u bazu podataka.
     * @return columnNamesInsert - String koji sadrzi odredjene nazive kolona koje pripadaju tabeli vezanoj za odgovarajuci entitet. Nazivi kolona su odvojeni zarezom i blanko znakom.
     */
    String getColumnNamesForInsert();
    
    /**
     * Vraca nazive kolona koje ce se koristiti za potrebe operacije prikazivanja entiteta iz bazr podataka.
     * @return columnNamesSelect - Niz String vrednosti koje predstavljaju pojedine nazive kolona koje pripadaju tabeli vezanoj za odgovarajuci entitet. Nazivi kolona su odvojeni zarezom i blanko znakom.
     */
    String[] getColumnNamesForSelect();

    /**
     * Vraca vrednosti atributa odredjenog entiteta koje predstavljaju deo upita za izvodjenje operacije dodavanja novog entiteta u bazu podataka.
     * @return insertValues - String vrednost koja sadrzi odgovarajuce vrednosti atributa koje treba navesti prilikom pisanja INSERT upita. Vrednosti su obuhvacene navodnicima u slucajevima kada je to potrebno.
     */
    String getInsertValues();
    
    /**
     * Vraca nazive metoda koje sluze kao pomoc pri radu sa ResultSet klasom.
     * @return resultSetMethods - Niz String vrednosti koje predstavljaju odgovarajuce nazive metoda koje ce koristiti instance ResultSet klase.
     */
    String[] getResultSetMethods();
    
    /**
     * Vraca vrednosti atributa odredjenog entiteta koje predstavljaju deo upita za izvodjenje operacije izmene podataka entiteta u bazi podataka.
     * @return updateValues - String vrednost koja sadrzi odgovarajuce vrednosti atributa koje treba navesti prilikom pisanja UPDATE upita. Vrednosti su obuhvacene navodnicima u slucajevima kada je to potrebno.
     */
    String getUpdateValues();
    
    /**
     * Vraca WHERE deo upita koji predstavlja uslov prilikom izvrsavanja odredjenog upita. U okviru aplikacije koristi se kod operacije za brisanje odgovarajuceg entiteta iz baze podataka.
     * @return whereCondition - String vrednost koja predstavlja WHERE uslov prilikom izvrsavanja upita za brisanje podataka iz baze, koji se dodaje na samom kraju upita.
     */
    String getWhereCondition();
    
    /**
     * Vraca WHERE deo upita koji predstavlja uslov prilikom izvrsavanja odredjenog upita. U okviru aplikacije koristi se kod operacije za izmenu podataka odgovarajuceg entiteta u bazi podataka.
     * @return whereConditionEdit - String vrednost koja predstavlja WHERE uslov prilikom izvrsavanja upita za brisanje podataka iz baze, koji se dodaje na samom kraju upita.
     */
    String getWhereConditionEditOperation();

    /**
     * Postavlja novu vrednost id atributu odgovarajuceg entiteta.
     * @param id - Nova ID vrednost nekog entiteta koja se dodaje id atributu u vidu Long vrednosti (ceo broj).
     * 
     * @throws NullPointerException - ako se unese null vrednost za ID
	 * @throws IllegalArgumentException - ako se ID vrednost koja je manja od 1
     */
    void setId(Long id);
}
