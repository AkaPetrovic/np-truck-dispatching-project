package rs.ac.bg.fon.ai.np.NPClient.util;

/**
 * Predstavlja klasu koja se bavi validacijom sadrzaja stringova.
 * 
 * @author Aleksa Petrovic
 * @since 1.1.0
 *
 */
public class FormValidator {
	/**
	 * Proverava da li je prosledjeni string pozitivan broj sa maksimalno 7 cifara i 2 decimalna mesta.
	 * @param str - String koji treba proveriti.
	 * @return true - Ukoliko je string odgovarajuceg formata, u suprotnom vraca false.
	 */
    public static boolean isPositiveDecimalNumberWithUpTo7DigitsAndUpTo2DecimalSpaces(String str) {
        return str.matches("^[0-9]{1,7}(\\.[0-9]{1,2})?$");
    }
    
    /**
	 * Proverava da li je prosledjeni string pozitivan broj sa maksimalno 3 cifre i 2 decimalna mesta.
	 * @param str - String koji treba proveriti.
	 * @return true - Ukoliko je string odgovarajuceg formata, u suprotnom vraca false.
	 */
    public static boolean isPositiveDecimalNumberWithUpTo3DigitsAndUpTo2DecimalSpaces(String str) {
        return str.matches("^[0-9]{1,3}(\\.[0-9]{1,2})?$");
    }
    
    /**
	 * Proverava da li je prosledjeni string pozitivan broj sa maksimalno 4 cifre i 2 decimalna mesta.
	 * @param str - String koji treba proveriti.
	 * @return true - Ukoliko je string odgovarajuceg formata, u suprotnom vraca false.
	 */
    public static boolean isPositiveDecimalNumberWithUpTo4DigitsAndUpTo2DecimalSpaces(String str) {
        return str.matches("^[0-9]{1,4}(\\.[0-9]{1,2})?$");
    }
    
    /**
	 * Proverava da li je prosledjeni string pozitivan broj sa 2 decimalna mesta.
	 * @param str - String koji treba proveriti.
	 * @return true - Ukoliko je string odgovarajuceg formata, u suprotnom vraca false.
	 */
    public static boolean isPositiveDecimalNumberWith2DecimalSpaces(String str) {
        return str.matches("^[0-9]+(\\.[0-9]{1,2})?$");
    }
    
    /**
	 * Proverava da li je prosledjeni string pozitivan broj sa maksimalno 3 cifre.
	 * @param str - String koji treba proveriti.
	 * @return true - Ukoliko je string odgovarajuceg formata, u suprotnom vraca false.
	 */
    public static boolean isPositiveNumberWithUpTo3Digits(String str) {
        return str.matches("[0-9]{1,3}");
    }
    
    /**
	 * Proverava da li je prosledjeni string pozitivan broj sa maksimalno 4 cifre.
	 * @param str - String koji treba proveriti.
	 * @return true - Ukoliko je string odgovarajuceg formata, u suprotnom vraca false.
	 */
    public static boolean isPositiveNumberWith4Digits(String str) {
        return str.matches("[0-9]{4}");
    }
}
