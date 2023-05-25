package rs.ac.bg.fon.ai.np.NPClient.util;

public class FormValidator {
    public static boolean isPositiveDecimalNumberWithUpTo7DigitsAndUpTo2DecimalSpaces(String str) {
        return str.matches("^[0-9]{1,7}(\\.[0-9]{1,2})?$");
    }
    
    public static boolean isPositiveDecimalNumberWithUpTo3DigitsAndUpTo2DecimalSpaces(String str) {
        return str.matches("^[0-9]{1,3}(\\.[0-9]{1,2})?$");
    }
    
    public static boolean isPositiveDecimalNumberWithUpTo4DigitsAndUpTo2DecimalSpaces(String str) {
        return str.matches("^[0-9]{1,4}(\\.[0-9]{1,2})?$");
    }
    
    public static boolean isPositiveDecimalNumberWith2DecimalSpaces(String str) {
        return str.matches("^[0-9]+(\\.[0-9]{1,2})?$");
    }
    
    public static boolean isPositiveNumberWithUpTo3Digits(String str) {
        return str.matches("[0-9]{1,3}");
    }
    
    public static boolean isPositiveNumberWith4Digits(String str) {
        return str.matches("[0-9]{4}");
    }
}
