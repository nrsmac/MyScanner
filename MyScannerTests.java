package scan;

import static org.junit.Assert.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import org.junit.Test;

public class MyScannerTests
{

    @Test(timeout = 1000)
    public void makesObject ()
    {
        MyScanner scn = new MyScanner("");
        assertNotNull(scn);
    }
    
    
    
    @Test(timeout = 1000)
    public void notHasNextIfEmpty ()
    {
        MyScanner scn = new MyScanner("");
        assertEquals(false, scn.hasNext());
    }
    
    @Test(timeout = 1000)
    public void hasNextOneElement ()
    {
        MyScanner scn = new MyScanner("One");
        assertEquals(true, scn.hasNext());
        String token = scn.next();
        assertEquals(false, scn.hasNext());
    }
    
    @Test(timeout = 1000)
    public void hasNextOneElementIntAsString () 
    {
        MyScanner scn = new MyScanner("1");
        assertEquals(true, scn.hasNext());
        String token = scn.next();
        assertEquals(false, scn.hasNext());
    }

    @Test(timeout = 1000)
    public void hasNextMultipleElements ()
    {
        MyScanner scn = new MyScanner("One Two Three");
        assertEquals(true, scn.hasNext());
        String token = scn.next();
        assertEquals(true, scn.hasNext());
        token = scn.next();
        assertEquals(true, scn.hasNext());
        token = scn.next();
        assertEquals(false, scn.hasNext());
    }
    
    @Test(timeout = 1000)
    public void hasNextMultipleElementsIntsAsStrings ()
    {
        MyScanner scn = new MyScanner("1 2 3");
        assertEquals(true, scn.hasNext());
        String token = scn.next();
        assertEquals(true, scn.hasNext());
        token = scn.next();
        assertEquals(true, scn.hasNext());
        token = scn.next();
        assertEquals(false, scn.hasNext());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void nextExceptionIfEmpty()
    {
        MyScanner scn = new MyScanner("");
        String token = scn.next();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void nextExceptionIfCalledOutOfBounds()
    {
        MyScanner scn = new MyScanner("one two");
        String token = scn.next();
        token = scn.next();
        token = scn.next();
    }
    
    @Test(timeout = 1000)
    public void nextOneElement ()
    {
        MyScanner scn = new MyScanner("one");
        assertEquals("one", scn.next());

    }
    
    @Test(timeout = 1000)
    public void nextMultipleElements ()
    {
        MyScanner scn = new MyScanner("one two three");
        assertEquals("one", scn.next());
        assertEquals("two", scn.next());
        assertEquals("three", scn.next());
    }
    
    @Test(timeout = 1000)
    public void notHasNextIntIfEmpty ()
    {
        MyScanner scn = new MyScanner("");
        assertEquals(false, scn.hasNext());
    }
    
    @Test(timeout = 1000)
    public void hasNextIntOneElement ()
    {
        MyScanner scn = new MyScanner("1");
        assertEquals(true, scn.hasNextInt());
        int token = scn.nextInt();
        assertEquals(false, scn.hasNextInt());
    }
    
    @Test(timeout = 1000)
    public void hasNextIntOneElementString ()
    {
        MyScanner scn = new MyScanner("One");
        assertEquals(false, scn.hasNextInt());
    }

    @Test(timeout = 1000)
    public void hasNextIntMultipleElements ()
    {
        MyScanner scn = new MyScanner("1 2 3");
        assertEquals(true, scn.hasNextInt());
        int token = scn.nextInt();
        assertEquals(true, scn.hasNextInt());
        token = scn.nextInt();
        assertEquals(true, scn.hasNextInt());
        token = scn.nextInt();
        assertEquals(false, scn.hasNextInt());
    }
    
    @Test(timeout = 1000)
    public void hasNextIntMultipleElementsStrings ()
    {
        MyScanner scn = new MyScanner("1 2 3");
        assertEquals(true, scn.hasNextInt());
        int token = scn.nextInt();
        assertEquals(true, scn.hasNextInt());
        token = scn.nextInt();
        assertEquals(true, scn.hasNextInt());
        token = scn.nextInt();
        assertEquals(false, scn.hasNextInt());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void nextIntExceptionIfEmpty ()
    {
        MyScanner scn = new MyScanner("");
        int token = scn.nextInt();
    }
    
    @Test(timeout = 1000)
    public void nextIntSingle ()
    {
        MyScanner scn = new MyScanner("1");
        assertEquals(1, scn.nextInt());
    }
    
    @Test(timeout = 1000)
    public void nextIntMultiple ()
    {
        MyScanner scn = new MyScanner("1 2 3");
        assertEquals(1, scn.nextInt());
        assertEquals(2, scn.nextInt());
        assertEquals(3, scn.nextInt());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void nextIntExceptionIfOutOfBounds ()
    {
        MyScanner scn = new MyScanner("1 2 3");
        int token = scn.nextInt();
        token = scn.nextInt();
        token = scn.nextInt();
        token = scn.nextInt();
        token = scn.nextInt();
    }
    
    @Test(timeout = 1000)
    public void nextIntWithStringBetween()
    {
        MyScanner scn = new MyScanner("1 Hello 3");
        assertEquals(1, scn.nextInt());
        assertEquals("Hello", scn.next());
        assertEquals(3, scn.nextInt());

    }
    
    @Test(expected = InputMismatchException.class)
    public void nextIntWithStringCalledAsInt()
    {
        MyScanner scn = new MyScanner("1 Hello 3");
        assertEquals(1, scn.nextInt());
        assertEquals(3, scn.nextInt());
    }
}
