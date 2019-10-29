/**
 * 
 */
package scan;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * A watered-down reconstruction of Java's scanner class. A MyScanner object contains:
 * <ul>
 * <li><strong>tokens</strong> : contains tokens of String passed to constructor</li>
 * <li><strong>tokenCounter</strong> : contains index of <strong>tokens</strong> being accessed.</li>
 * </ul>
 * 
 * @author Noah Schill (u1254484)
 */
public class MyScanner
{
    private String[] tokens;
    private int tokenCounter;

    /**
     * Constructs a MyScanner Object.
     * 
     * @param string takes in a string to be converted to a MyScannerObject. String tokens are assigned to
     *            <strong>tokens</strong>.
     */
    public MyScanner (String string)
    {
        tokens = string.trim().split("\\s+");
        tokenCounter = 0;
    }

    /**
     * @return true if scanner has next element regardless of type
     */

    public boolean hasNext ()
    {
        boolean hasNext = false;

        try
        {
            if (!tokens[tokenCounter].isBlank() || !tokens[tokenCounter].isEmpty())
            {
                hasNext = true;
            }
        }
        catch (Exception e)
        {
            hasNext = false;
        }

        return hasNext;
    }

    /**
     * 
     * @return next token in scanner as a String.
     * @throws NoSuchElementException if token is out of range/no next token
     */

    public String next () throws NoSuchElementException
    {
        try
        {
            String next = tokens[tokenCounter];
            if (next.isEmpty())
            { // Check for empty strings
                throw new NoSuchElementException();
            }
            tokenCounter++;
            return next;

        }
        catch (Exception e)
        {
            throw new NoSuchElementException();
        }
    }

    /**
     * 
     * @return true if scanner has next token & next token is integer
     */
    public boolean hasNextInt ()
    {
        boolean hasNextInt = false;

        try
        {
            Integer.parseInt(tokens[tokenCounter]);
            hasNextInt = true;
        }
        catch (Exception e)
        {
            hasNextInt = false;
        }

        return hasNextInt;
    }

    /**
     * 
     * @return next integer token
     * @throws NoSuchElementException if token is out of range/no next token
     * @throws InputMistmatchException if next element is not int
     */
    public int nextInt ()
    {
        int nextInt = -1;
        try
        {
            nextInt = Integer.parseInt(tokens[tokenCounter]);
            tokenCounter++;
            return nextInt;

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new NoSuchElementException();
        }
        catch (NumberFormatException e)
        {
            throw new InputMismatchException();
        }
    }
}
