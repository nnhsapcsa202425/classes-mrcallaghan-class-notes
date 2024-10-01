import java.util.Scanner;

/**
 * Demonstrates the CaesarCipher class
 *
 * @author mcallaghan
 * @version 26sep2024
 */
public class CaesarCipherDemo
{
    public static void main(String[] args)
    {
        
        
        /*
         * A Scanner object parses primitive types and Strings from a stream.
         * 
         * A stream is a sequence of characters from a file, String, terminal, network connection, etc.
         * 
         * Parsing is separating a sequence of characters into tokens based on delimiters.
         * 
         *      A token is a meaningful sequence of characters (e.g., word).
         *      
         *      Delimiters are characters that separate tokens
         *          (by default, whitespace (space, tab, new line)).
         *          
         *  When we create a Scanner object, we have to specify the input stream
         *      (e.g., System.in which is the terminal input)
         */
        
        Scanner s = new Scanner(System.in);
        
        /*
         * Best practices:
         *  1. prompt the user for what to type
         *  2. use print, instead of println, so the input goes to the end of the line and not on a newline
         *  3. include a space at the end of the prompt
         */
        System.out.print("Enter the text to encrypt: ");
        
        /*
         * The nextLine method return all characters up to the end of the line (where the user presses enter)
         */
        String text = s.nextLine();
        text = text.toUpperCase();
        
        System.out.println(text);
        
        System.out.print("Enter the keyphrase (no spaces): ");
        
        /*
         * The next method returns the next token in teh steam as a String.
         */
        String keyphrase = s.next().toUpperCase();  // chaining methods
        //String keyphrase2 = s.next().toUpperCase();
        System.out.println(keyphrase);
        //System.out.println(keyphrase2);
        
        System.out.print("Enter the number of seconds to test a guessed keyphrase: ");
        /*
         * The nextInt method attempts to convert the next token in the stream to an int
         *  and return it. If the next token cannot be converted, an exception is generated.
         *  
         *  The nextDouble method behaves the same way for doubles.
         */
        int secondsPerGuess = s.nextInt();
        
        System.out.println("Seconds per guess: " + secondsPerGuess);
        
        CaesarCipher cipher = new CaesarCipher(keyphrase);
        
        String complexityDesc = cipher.getComplexityDescription(secondsPerGuess);
        System.out.println("Complexity: " + complexityDesc);
        
        String encryptedText = cipher.encrypt(text);
        System.out.println("Encrypted: " + encryptedText);
        
        
        // demo #1
        int n = 1000000;
        System.out.println("Integer overflow: " + n * n);
        
        // demo #2
        double f = 4.35;
        System.out.println("Floating point imprecision: " + 100 * f);
    }
}