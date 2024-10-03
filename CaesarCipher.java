import java.util.Scanner;

/**
 * This class encrypts strings with a keyphrase version of the classic
 *      Caesar Cipher.
 *      (as described in The Code Book by Simon Singh)
 *
 * @author mcallaghan
 * @version 26 sep 2024
 */
public class CaesarCipher
{
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    private String keyphrase;
    
    public CaesarCipher(String initialKeyphrase)
    {
        //this.keyphrase = initialKeyphrase;
        // prepare the keyphrase by removing duplicate letters
        this.compressKeyphrase(initialKeyphrase);
        System.out.println(this.keyphrase);
    }
    
    /**
     * Comress the specified keyphrase by removing all duplicate letters.
     * 
     * @param initKeyphrase the keyphrase to compress
     */
    private void compressKeyphrase(String initKeyphrase)
    {
        this.keyphrase = "";
        
        /*
         * length
         *      return the number of characters in the string
         */
        int keyphraseLength = initKeyphrase.length();
        
        for(int i = 0; i < keyphraseLength; i++)
        {
            /*
             * substring
             *      returns part of the string starting at the first specified index
             *          up to, but not including, the seond specified index
             *          
             *      intiKeyphrase:
             *      C A E S A R
             *      0 1 2 3 4 5  <= indices
             *      
             *      length = 6
             */
            String letter = initKeyphrase.substring(i, i + 1);
            
            /*
             * substring
             *  if only one index is specified, returns part of the string starting
             *      at the specified index through the end of the string
             *      
             *      substring does not support negative indices
             *        For example, instead of -2, we would specift intiKeyphrase.length() - 2
             */
            String restOfKeyphrase = initKeyphrase.substring(i + 1);
            // same as: initKeyphrase.substring(i + 1, initKeyphrase.length())
            
            /*
             * indexOf
             *      returns the index of the start of the first occurence of the specified string
             *      if not found, returns -1
             *      
             *      restOfKeyphrase:
             *      A E S A R
             *      0 1 2 3 4  <= indices
             *      
             *      length = 5
             *      
             *      For example: restOfKeyphrase.indexOf("SA") => returns 2
             */
            int index = restOfKeyphrase.indexOf(letter);
            
            
            /*
             * String concatentation
             *  + is the string concatenation operator
             *      concatentates the seconds string operand to the end of the first string operand
             *          and returns a reference to the new String.
             *          
             *  if one or both operands are a String type, + is the String concatentation
             *      operator (operands are converted to String objects); otherwise + is the addition operator.
             */
            if(index == -1)  // checks if letter is not a duplicate
            {
                this.keyphrase = this.keyphrase + letter;
                // same as: this.keyphrase += letter
            }
            
        }
               
        
    }
    
    /**
     * Returns a string that descriibes the average time to crack the cipher,
     *      in several formats, based on the specific number of seconds per guess.
     *      
     * @param secPerGuess the number of seconds to evaluate each attempt
     * @return a string that describes the average time to crack the cipher
     */
    public String getComplexityDescription(int secPerGuess)
    {
        /*
         * Instead of using a "magic number" (e.g., 3.14159), us constants defined
         *  by us or the java standard library.  For example, in the Math class, Pi is defined 
         *  as:
         *  
         *  public static final double PI = 3.141592654;
         *  
         *  Math.PI
         *  
         *  Declare a constant with the final keyword.
         *      By convention, constant are in all uppercase with underscores.
         */
        final int SECONDS_FOR_EVERY_MINUTE = 60;
        //SECONDS_FOR_EVERY_MINUTE = 30;  // if we try to change the value, a compile-time error occurs.
        
        final int MINUTES_FOR_EVERY_HOUR = 60;
        final int HOURS_FOR_EVERY_DAY = 24; 
        final int DAYS_FOR_EVERY_YEAR = 365;
        
        String desc = "";
        
        // one method in a class can invoke another method in the same class
        //  we invoke the method on "this"
        long totalSeconds = this.calculateAverageTimeToCrack(secPerGuess);
        
        /*
         * Use integer division to calculate how many whole minutes are in a specified number 
         *      of seconds.
         *      
         *      Integer Division (like // operator in Python) discards the remainder.
         *      
         *      Java does integer division when both operands are integer types;
         *        floating point division ocurs when one or both operands are floats (or doubles).
         *        
         *  For example:
         *     3 / 4 => 0  ( 3 and 4 are integer literals)
         *     3.0 / 4 => 0.75 ( 3.0 is a double literal)
         */
        long wholeMinutes = totalSeconds / SECONDS_FOR_EVERY_MINUTE;
        
        /*
         * Use the modulo (mod) operator to calcualte how many seconds are left over (remainder).
         * 
         * The mod operator (%) returns the remainder of a division operation.
         * 
         * It can be very useful  when paired with integer dvision.
         * 
         * For Example:
         *      7 % 2 => 1
         *      11 % 3 => 2
         *      6 % 2 => 0
         *      4 % 11 => 4
         */
        long leftoverSeconds = totalSeconds % SECONDS_FOR_EVERY_MINUTE;
        
        long wholeHours = wholeMinutes / MINUTES_FOR_EVERY_HOUR;
        long leftoverMinutes = wholeMinutes % MINUTES_FOR_EVERY_HOUR;
        
        long wholeDays = wholeHours / HOURS_FOR_EVERY_DAY;
        long leftoverHours = wholeHours % HOURS_FOR_EVERY_DAY;
        
        long wholeYears = wholeDays / DAYS_FOR_EVERY_YEAR;
        long leftoverDays = wholeDays % DAYS_FOR_EVERY_YEAR;
        
        desc = "Average time to crack: " + wholeYears + " years, " + leftoverDays +
            " days, " + leftoverHours + " hours, " + leftoverMinutes + " minutes, " +
            leftoverSeconds + " seconds\n";
        
        /*
         * A conversion is when  a data value is converted from one type to another
         *  (e.g., int to a double; double to an int; int to a long)
         *  
         *  Widening: preserves information (e.g., int to a double, int to a long)
         *  Narrowing: lossy;may lose infornation (e.g, double to an int)
         *  
         *  Java only automatically performs widening conversion.
         */    
        double yearsAsDecimal = totalSeconds;
        
        /*
         * Arithmetic Promotion
         * 
         * If the two operands are of different types, Java attempts to promote one of the two
         *  operands (widening conversion) and the performs the operation.
         *  
         *  This promotion may be too late!  If the multiplication overflows the int type,
         *      the wrong value would be promoted to along and stored.
         */
        final long SECONDS_FOR_EVERY_YEAR = SECONDS_FOR_EVERY_MINUTE * MINUTES_FOR_EVERY_HOUR *
            HOURS_FOR_EVERY_DAY * DAYS_FOR_EVERY_YEAR;
        
        /*
         * In this example, the value of SECONDS_FOR_EVERY_YEAR is promoted to a double
         *  and then floating point division is pefomred and the result is assigned
         *  to yearsAsDecimal.
         */
        yearsAsDecimal = yearsAsDecimal / SECONDS_FOR_EVERY_YEAR;
        desc += "or " + yearsAsDecimal + " years\n";
        
        /*
         * To force a conversion, use the cast operator.
         *      A cast is the "I know what I'm doing, trust me" conversion.
         *      
         *      (int)84.69 => truncates to an int with the value of 84
         *      (int)(3.6 + 0.5) => truncates 4.1 to an int with the value of 4
         *      
         *      If we want to round a double to the nearest integer value, one appraoch
         *       is to add 0.5 and then cast the result to an int, which truncates the decimal portion.
         */
        int decades = (int) ((yearsAsDecimal / 10) + 0.5);
        
        /*
         * You cannot always cast from one type to another.For example, Strings cannot be cast to numbers.
         *  Instead rely on the String concatenation operator to convert (not cast) the primitive
         *  to a String representation of that value.
         */
        //String decadesAsString = (String) decades;
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
