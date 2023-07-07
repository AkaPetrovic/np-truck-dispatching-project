package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.Serializable;

/**
 * Predstavlja zahtev koji se koristi za slanje odgovarajuce operacije i argumenta.
 * 
 * Sadrzi operaciju koju treba izvrsiti i odgovarajuci argument koji se prosledjuje pri izvrsavanju operacije.
 * Klasa implementira Serializable interfejs kako bi omogućila serijalizaciju objekata tipa Request.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class Request implements Serializable{
	/**
	 * Opreracija koju treba izvrsiti.
	 */
    private Operation operation;
    /**
     * Argument nad kojim ce se raditi u okviru operacije.
     */
    private Object argument;

    /**
     * Podrazumevani konstruktor klase Request.
     * 
     * Kreira novi objekat klase Request sa nepromenjenim vrednostima atributa.
     */
    public Request() {
    }

    /**
     * Parametrizovani konstruktor klase Request.
     * 
     * Kreira novi objekat klase Request sa prosledjenom operacijom i argumentom.
     * 
     * @param operation - Operacija koju treba izvrsiti
     * @param argument - Argument koji se prosledjuje pri izvrsavanju operacije
     */
    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    /**
     * Vraca operaciju vezanu za konkretan zahtev.
     * @return operation - Operacija specificirana u zahtevu.
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Postavlja novu vrednost atributa operation.
     * @param operation - Nova vrednost operacije, odnosno atributa operation u okviru zahteva.
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * Vraca argument koju se prosledjuje u okviru zahteva.
     * @return argument - Argument prosledjen uz zahtev prilikom izvrsenja operacije.
     */
    public Object getArgument() {
        return argument;
    }

    /**
     * Postavlja novu vrednost atributa argument.
     * @param argument - Nova vrednost argumenta zahteva za izvrsenje operacije, odnosno atributa argument u okviru zahteva.
     */
    public void setArgument(Object argument) {
        this.argument = argument;
    }
}
