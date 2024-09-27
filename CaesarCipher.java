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
        this.keyphrase = initialKeyphrase;
    }
    
    /**
     * Returns a string that describes the average time to crack the cipher,
     *      in several formats, based on the specified number of seconds per guess.
     *      
     * @param secPerGuess the numbe rof seconds to evaluate each attempt
     * @return a string that describes the average time to crack the cipher
     */
    public String getComplexityDescription(int secPerGuess)
    {
        /*
         * Instead of using "magic numbers"  (e.g., 3.14159), use constants defined by us
         *      or the java standard library.  For Example, in the Math calss Pi is defined as:
         *      
         *      public static final double PI = 3.141592654;
         *      
         *      reference this value by writing: Math.PI
         *      
         * Declare a constant with the final keyword.
         *      By convention, constants are in all caps with underscores.
         */
        final int SECONDS_FOR_EVERY_MINUTE = 60;
        //SECONDS_FOR_EVERY_MINUTE = 30;  // cannot reassign to a final variable
        final int MINUTES_FOR_EVERY_HOUR = 60;
        final int HOURS_FOR_EVERY_DAY = 24;
        final int DAYS_FOR_EVERY_YEAR = 365;
        
        String desc = "";
        
        long totalSeconds = this.calculateAverageTimeToCrack(secPerGuess);
        
        /*
         * Use integer division to calculate how many whole minutes are in the specified number of
         *  seconds.
         *  
         *  Integer divison (like // operator in python) discards the remainder (truncates).
         *  
         *  Java does integer division when both operands are integer types;
         *      floating point division when one or both operands are floats.
         *      
         *      For Example:
         *        3 / 4 => 0  (3 and 4 are int literals)
         *        3.0 / 4 => 0.75 (3.0 is a double literal)
         */
        long wholeMinutes = totalSeconds / SECONDS_FOR_EVERY_MINUTE;
        
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

        
         /* The keyphrase, after removing any repeated letters is used as the beginning of the
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
