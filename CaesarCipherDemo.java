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
        // demo of an overflow error
        int n = 1000000;
        System.out.println("Integer overflow: " + n * n);
        
        // demo of floating point imprecision
        double f = 4.35;
        System.out.println(100 * f);
        
        /*
         * A Scanner object parses primitive types and Strings from a stream.
         * 
         * A stream is a sequence of characters from a file, String, terminal, network connection, etc.)
         * 
         * Parsing is separating a sequence o characters into token based on a delimiter.
         * 
         *      A token is a meaningful sequence of characters (e.g, word).
         *      
         *      Delimiters are characters the separate tokens.
         *          (by default, whitespace (space, tab, newLine).
         *          
         *  When we create a Scanner object, we have to specify the input stream
         *      (e.g., System.in which is the terminal input)
         */
        Scanner s = new Scanner(System.in);
        
        /*
         * Best practice:
         *      1. promt the user for what you want them to input.
         *      2. use print, not println; so the cursor is at the end of the line and not the new line
         *      3. leave a space after the prompt
         */
        System.out.print("Enter the text to encrypt: ");
        
        /*
         * The nextLine method returns all characters up to the end of the line
         *      (e.g., where the user typed enter)
         */
        String text = s.nextLine().toUpperCase();  // chaining methods
        //text = text.toUpperCase();
        
        System.out.print("Enter the keyphrase (no spaces): ");
        
        /*
         * The next method return the next token in the stream as a String.
         */
        String keyphrase = s.next();
        keyphrase = keyphrase.toUpperCase();
        
        System.out.println(text);
        System.out.println(keyphrase);
        
        System.out.print("Enter the number of seconds to text a guessed keyphrase: ");
        
        /*
         * The nextInt method attempts to convert the next token in the stream to an int
         *      and return the value.  If the next token cannot be converted, an exception is generated.
         *      
         *      The nextDouble method behaves the same way, but for doubles.
         */
        int secondsPerGuess = s.nextInt();
        
        CaesarCipher cipher = new CaesarCipher(keyphrase);
        String complexityDescription = cipher.getComplexityDescription(secondsPerGuess);
        System.out.println("Complexity: " + complexityDescription);
        
        
        String encryptedText = cipher.encrypt(text);
        System.out.println("Encrypted text: " + encryptedText);
        
        String kp = CaesarCipher.generateKeyphrase(10);
        System.out.println("Random keyphrase: " + kp);
        
        
        
        
        
        
        
        
        
    }
}