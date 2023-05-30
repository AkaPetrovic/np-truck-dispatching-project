package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.Serializable;

/**
 * Predstavlja odgovor kao rezultat izvrsenja odredjene operacije u okviru aplikacije.
 * 
 * Moze sadrzati podatak o rezultatu operacije i o eventualnom izuzetku odnosno nepredvidjenoj gresci koja se desila prilikom izvrsavanja opreracije.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Response  implements Serializable{
	/**
	 * Objekat koji predstavlja rezultat izvrsenja operacije.
	 */
    private Object result;
    /**
     * Izuzetak koji se dogodio prilikom izvrsenja operacije.
     */
    private Exception exception;

    /**
     * Prazan konstruktor za kreiranje jedne instance odgovora na zahtev za izvrsenje operacije sa podrazumevanim vrednostima za njegova polja.
     */
    public Response() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance odgovora na zahtev za izvrsenje operacije sa svim atributima postavljenim na zeljene vrednosti.
     * @param result - Rezultat izvrsenja operacije koji se postvlja prilikom kreiranje odgovora na zahtev.
     * @param exception - Izuzetak koji se postavlja inicijalno, odnosno pri kreiranju instance odgovora na zahtev za izvrsenje operacije.
     */
    public Response(Object result, Exception exception) {
        this.result = result;
        this.exception = exception;
    }

    /**
     * Vraca rezultat izvrsenja operacije.
     * @return result - Rezultat izvrsenja operacije sadrzan u odgovoru.
     */
    public Object getResult() {
        return result;
    }

    /**
     * Postavlja novu vrednost za atribut result odgovora.
     * @param result - Nova vrednost atributa result, odnosno rezultata izvrsenja operacije.
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * Vraca izuzetak koji se vezuje za odgovor na zahtev za izvrsenja operacije.
     * @return exception - Izuzetak koji se dogodio pri izvrsenju operacije, pa je stoga sadrzan u odgovoru.
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Postavlja novu vrednost za atribut exception odgovora.
     * @param exception - Nova vrednost atributa exception, odnosno izuzetka nastalog pri izvrsenju operacije.
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }
}
