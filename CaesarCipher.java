import java.util.Scanner;

/**
 * This class encrypts strings with a keyphrase version of the classic
 *      Caesar Cipher.
 *      (as described in The Code Book by Simon Singh)
 *
 * @author mcallaghan
 * @version 26 September 2024
 */
public class CaesarCipher
{
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String keyphrase;

    public CaesarCipher(String intialKeyphrase)
    {
        //this.keyphrase = intialKeyphrase;
        this.compressKeyphrase(intialKeyphrase);
    }
    
    /**
     * Compress the specified keyphrase by removing all duplicate letters.
     * 
     * @param initKeyphrase the keyphrase to compress
     */
    private void compressKeyphrase(String initKeyphrase)
    {
        this.keyphrase = "";
        
        /*
         * length
         *   return the number of characters in a string
         */
        int keyphraseLength = initKeyphrase.length();
        
        for (int i = 0; i < keyphraseLength; i++)  // loop kephraseLength times
        {
            /*
             * substring
             *      returns part of a string starting with the first specified index up to, but
             *          not including, the seconf specified index.
             *          
             *          initKeyphrase:
             *          C A E S A R
             *          0 1 2 3 4 5  => indices, index values
             *          
             *          length: 6
             *          
             *          substring does not support negative indices, like python
             *          instead, to access the last postion in a string, do this:
             *              initKeyphrase.substring(initKeyphrase.length() - 1)
             */
            String letter = initKeyphrase.substring( i , i + 1);
            
            /*
             * if only one index is specified, returns part of the string starting at the specified
             *  index through the end of the string.
             *  
             */
            String restOfKeyphrase = initKeyphrase.substring(i + 1);
            // same as: initKeyphrase.substring( i + 1, initKeyphrase.length());
            
            /*
             * indexOf
             *  returns the index of the start of the first occurence of the specifies string.
             *      returns -1 if not found
             *      
             *      restOfKeyphrase:
             *      A E S A R
             *      0 1 2 3 4
             *      
             *      length: 5
             *      
             *      For example: restOfKeyphrase.indexOf("SA");  => returns 2
             */
            int index = restOfKeyphrase.indexOf(letter);
            
            if(index == -1)  // if the letter is not a duplicate
            {
                this.keyphrase = this.keyphrase + letter;
                // same as: this.keyphrase += letter;
            }
            
            
        }
        
        
    }

    /**
     * Returns a string that describes the average time to crack the cipher,
     *      in several formats, based on the specified number of seconds per guess.
     *      
     * @param secPerGuess the number of seconds to evaluate each attempt
     * @return a string that decribe the average time to crack the cipher
     */
    public String getComplexityDescription(int secPerGuess)
    {
        /*
         * Instead of using "magic numbers"(e.g., 3.1415), use constants defined by us
         *      or the java standard library.  For example, in the Math class
         *      Pi is defined:
         *      
         *      public static final double PI = 3.141592654;
         *      
         *      to use this, we call Math.PI
         *      
         *      Declare a constant with the final keyword.
         *      
         *      By convention, constants are in all caps with underscores.
         */
        final int SECONDS_FOR_EVERY_MINUTE = 60;
        final int MINUTES_FOR_EVERY_HOUR = 60;
        final int HOURS_FOR_EVERY_DAY = 24;
        final int DAYS_FOR_EVERY_YEAR = 365;

        //SECONDS_FOR_EVERY_MINUTE = 30;  // compiler will not allow a final variable to change

        String desc = "";

        // one method can invoke another method! invoke the method on 'this'.
        long totalSeconds = this.calculateAverageTimeToCrack(secPerGuess);

        /*
         * Use integer division to calculate how many whole minutes are in a 
         *  specified numbe rof seconds.
         *  
         *  Integer division (like // in Python) discards the remainder.
         *  
         *  Java does integer division when both operands are integer types;
         *      floating point divison occurs when one or both operands are floats (or doubles)
         *      
         *      For example:
         *          3 / 4 => 0          (3 and 4 are int literals)
         *          3.0 / 4 => 0.75     (3.0 is a double literal)
         */
        long wholeMinutes = totalSeconds / SECONDS_FOR_EVERY_MINUTE;

        /*
         * Use the modulo (mod) operator to calculate how many seconds are left over.
         * 
         * The mod (%) operator returns the remainder from a division operation.
         * 
         * It can be very useful when pair it with integer division.
         * 
         * For example:
         *    7 % 2 => 1
         *    11 % 3 => 2
         *    6 % 2 => 0
         *    4 % 11 => 4
         */
        long leftoverSeconds = totalSeconds % SECONDS_FOR_EVERY_MINUTE;

        long wholeHours = wholeMinutes / MINUTES_FOR_EVERY_HOUR;
        long leftoverMinutes = wholeMinutes % MINUTES_FOR_EVERY_HOUR;

        long wholeDays = wholeHours / HOURS_FOR_EVERY_DAY;
        long leftoverHours = wholeHours % HOURS_FOR_EVERY_DAY;

        long wholeYears = wholeDays / DAYS_FOR_EVERY_YEAR;
        long leftoverDays = wholeDays % DAYS_FOR_EVERY_YEAR;

        desc = "Average time to crack: " + wholeYears + " years, " + leftoverDays + " days, " +
        leftoverHours + " hours, " + leftoverMinutes + " minutes, " + leftoverSeconds + " seconds\n";
        
        /*
         * A conversion is when a data value is converted from type to another
         *  (e.g., int to double; double to int; int to long)
         *  
         *  Widening: preserves information (e.g., int to double, int to long)
         *  Narrowing: lossy; may lose information (e.g., double to int)
         *  
         *  Java only automatically performs widening conversions.
         */
        double yearsAsDecimal = totalSeconds;
        
        /*
         * Arithmetic promotion
         * 
         * If the two operands are of different types, Java attempts to promote one of the operands
         *  (widening conversion) and then performs the operation.
         *  
         *  This promotion may be too late! If the multiplication overflows an int,
         *      the wrong value will be assigned.
         */
        final long SECONDS_FOR_EVERY_YEAR = (long) SECONDS_FOR_EVERY_MINUTE * MINUTES_FOR_EVERY_HOUR * 
            HOURS_FOR_EVERY_DAY * DAYS_FOR_EVERY_YEAR;
            
        /*
         * In this example, the value of the SECONDS_FOR_EVERY_YEAR is promoted to a double
         *  and then floating point division is performed and the result assigned to yearsAsDecimal.
         */
        yearsAsDecimal = yearsAsDecimal / SECONDS_FOR_EVERY_YEAR;
        desc += "or " + yearsAsDecimal + " years\n";
        
        /*
         * To force a conversion, use the cast operator.
         *  A cast is the "I know what I'm doing" conversion.
         *  
         *      (int) 84.94 => truncates to an int and results in 84
         *      (int) (3.6 + 0.5) => truncates the decimal 4.1 to an int value of 4
         *      (int) (3.1 + 0.5) => 3.6 truncates to 3
         *      
         *  The following diviides the yearsAsDecimal by 10, then rounds the resulting double to an int.
         */
        int decades = (int) ((yearsAsDecimal / 10) + 0.5);
        
        /*
         * However, you cannot cast from any type to another.  For example, a number cannot
         *  be cast to a String.  Use string contacenation for converting numbers to Strings.
         */
        //String decadesString = (String) decades;
        desc += "or about " + decades + " decades\n";
        
        return desc;
    }

    /**
     * Encrypts the specified text using the specified keyphrase using a
     *      keyphrase-enhanced Caesar Cipher.
     *      
     *  @param  text        the text to encrypt
     *  @param  keyphrase   the keyphrase with which to encrypt the specified text
     *  @return             the encrypted text
     */
    public String encrypt(String text)
    {
        String encryptedText = "";

        /*
         * The keyphrase, after removing any repeated letters is used as the beginning of the
         *      jumbled cipher alphabet. The remainder of the cipher alphabet is merely the
         *      remaining letters of the alphabet, in their correct order, starting where the
         *      keyphrase ends.
         */
        String cipherAlphabet = this.keyphrase;
        for(int i = 0; i < CaesarCipher.ALPHABET.length(); i++)
        {
            char letter = CaesarCipher.ALPHABET.charAt(i);
            if(this.keyphrase.indexOf(letter) == -1)
            {
                cipherAlphabet += letter;
            }
        }

        /*
         * For each letter in the text that is a letter, find the corresponding letter
         *      at the same position in the cipher alphabet as its replacement.
         */
        for(int i = 0; i < text.length(); i++)
        {
            char letter = text.charAt(i);

            // if the letter is between A and Z
            if(letter >= 'A' && letter <= 'Z')
            {
                // 65 is the ASCII value of 'A'
                int cipherIndex = letter - 65;
                encryptedText += cipherAlphabet.charAt(cipherIndex);
            }
            else    // don't substitute the letter; just use it as is
            {
                encryptedText += letter;
            }
        }

        return encryptedText;
    }

    /*
     *  This method is private and, therefore, can only be invoked from within this class.
     *      For example, the getComplexityDescription method invokes this method.
     */

    /**
     * Calculates the average time to crack the cipher, based on the
     *      specified length of the keyphrase and seconds to evaluate
     *      each attempt, using a brute force approach. This calculation
     *      assumes that the cracker knows the length of the keyphrase.
     *      If the length is not know, it will take substantially longer
     *      to crack the cipher. Regardless, this calculation is only
     *      for a brute force approach; other techniques (e.g., frequency
     *      analysis) can crack the cipher extremely quickly.
     *      
     *  @param  secPerGuess     the number of seconds to evaluate each attempt
     *  @return                 the average number of seconds to crack the cipher
     */
    private long calculateAverageTimeToCrack(int secPerGuess)
    {
        final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
        int lettersRemaining = NUMBER_OF_LETTERS_IN_ALPHABET;
        int keyphraseLength = this.keyphrase.length();
        long combinations = 1;

        /*
         * Calculate the number of combintations for the specified keyphrase length.
         *  For example, if the keyphrase is six characters long:
         *      26 * 25 * 24 * 23 * 22 * 21
         *      would be the number of combinations of cipher alphabets for keyphrases
         *      that are six characters long.
         */
        for(int i = 0; i < keyphraseLength; i++)
        {
            combinations *= lettersRemaining;
            lettersRemaining -= 1;
        }

        long worstCaseTimeToCrack = combinations * secPerGuess;

        // average time is half the worst time since the best time is cracking the
        //  cipher on the first attempt
        return worstCaseTimeToCrack/2;
    }
}
