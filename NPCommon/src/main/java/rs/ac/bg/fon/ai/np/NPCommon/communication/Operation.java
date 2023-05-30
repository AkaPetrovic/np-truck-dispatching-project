package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.Serializable;

/**
 * Predstavlja enumeraciju koja opisuje koje su sve moguce operacije u okviru aplikacije.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public enum Operation  implements Serializable{
	/**
	 * Prijavljuje korisnika na sistem.
	 */
    LOGIN,
    /**
     * Izlistava sve vozace iz baze podataka.
     */
    GET_ALL_DRIVERS,
    /**
     * Izlistava sve kamione koji se nalaze u bazi podataka.
     */
    GET_ALL_TRUCKS,
    /**
     * Vraca listu proizvodjaca kamiona koji su upisani u bazu podataka.
     */
    GET_ALL_MANUFACTURERS,
    /**
     * Izlistava sve tipove kamiona iz baze podataka.
     */
    GET_ALL_TRUCK_TYPES,
    /**
     * Vraca odredjene vozaca iz baze podataka koji odgovaraju nekom specificnom uslovu.
     */
    GET_DRIVERS,
    /**
     * Vraca odredjene kamione iz baze podataka koji odgovaraju nekom specificnom uslovu.
     */
    GET_TRUCKS,
    /**
     * Vraca odredjene tovare iz baze podataka koji odgovaraju nekom specificnom uslovu.
     */
    GET_LOADS,
    /**
     * Vraca odredjene servise kamiona iz baze podataka koji odgovaraju nekom specificnom uslovu.
     */
    GET_TRUCK_MAINTENANCES,
    /**
     * Cuva jednu instancu vozaca kao novi red u odgovarajucoj tabeli u okviru baze podataka.
     */
    SAVE_DRIVER,
    /**
     * Cuva jednu instancu kamiona kao novi red u odgovarajucoj tabeli u okviru baze podataka.
     */
    SAVE_TRUCK,
    /**
     * Cuva jednu instancu tovara kao novi red u odgovarajucoj tabeli u okviru baze podataka.
     */
    SAVE_LOAD,
    /**
     * Menja odredjeni red iz tabele namenjene vozacima u okviru baze podataka.
     */
    EDIT_DRIVER,
    /**
     * Menja odredjeni red iz tabele namenjene kamionima u okviru baze podataka.
     */
    EDIT_TRUCK,
    /**
     * Menja odredjeni red iz tabele namenjene tovarima u okviru baze podataka.
     */
    EDIT_LOAD,
    /**
     * Brise odredjeni red iz tabele namenjene vozacima u okviru baze podataka.
     */
    DELETE_DRIVER,
    /**
     * Brise odredjeni red iz tabele namenjene tovarima u okviru baze podataka.
     */
    DELETE_LOAD,
}
