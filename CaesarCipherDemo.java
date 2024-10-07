import java.util.Scanner;

/**
 * Demonstrates the CaesarCipher class
 *
 * @author mcallaghan
 * @version 26 sep 2024
 */
public class CaesarCipherDemo
{
    public static void main(String[] args)
    {
        // demo 1
        int n = 1000000;
        System.out.println("Integer overflow: " + n * n);
        
        // demo 2
        double f = 4.35;
        System.out.println("floating point imprecision: " + 100 * f);
        
        /*
         * A Scanner object parses primitive types and Strings from a stream.
         * 
         * A stream is a sequence of characters from a file, String, terminal, network connection...
         * 
         * Parsing is separating a sequencee of characters into tokens based on delimiters.
         * 
         *      A token is a meaningful sequence of characters (e.g., word).
         *      
         *      Delimiters are characters that separate tokens
         *          (by default, whitespace (space, tab, new line)).
         *          
         *  When we create a Scanner object, you have to specify the input stream
         *          (e.g., System.in which is the terminal input)
         */
        Scanner s = new Scanner(System.in);
        
        /*
         * Best practice:
         *  1. prompt the user for what you want them to type
         *  2. use print, not println, so that the cursor or input text goes after the prompt
         *          and not on the next line.
         *  3. leave a space after the prompt
         */
        System.out.print("Enter the text to encrypt: ");
        
        /*
         * The nextLine method return all characters up to the end of the line.
         *  (e.g., when the user presses enter)
         */
        String text = s.nextLine();
        text = text.toUpperCase();
        
        System.out.println(text);
        
        
        System.out.print("Enter the keyphrase (no spaces): ");
        /*
         * The next method returns the next token in the stream as a String.
         */
        String keyphrase = s.next().toUpperCase();  // chaining methods
        
        System.out.println(keyphrase);
        
        System.out.print("Enter the number of seconds to test a guessed keyphrase: ");
        
        /*
         * The nextiNt method attempts to convert the next token in the stream to an int
         *  and retuns the value.  If the next token cannot be converted, an exception is generated.
         *  
         *  The nextDouble method behaves the same way but for doubles.
         */
        int secondsPerGuess = s.nextInt();
        
        CaesarCipher cipher = new CaesarCipher(keyphrase);
        
        String complexityDescription = cipher.getComplexityDescription(secondsPerGuess);
        System.out.println("Complexity: " + complexityDescription);
        
        String encryptedText = cipher.encrypt(text);
        System.out.println("Encrypted: " + encryptedText);
        
        
        String randomKeyphrase = CaesarCipher.generateKeyphrase(8);
        System.out.println("Random keyphrase: " + randomKeyphrase);
        
        
    }
}