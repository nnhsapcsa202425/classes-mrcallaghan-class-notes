import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest
{
    public VendingMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testFillUp()
    {
        VendingMachine testMachine= new VendingMachine();
        int numberOfCans = testMachine.getCanCount();
        testMachine.fillUp(10);
        int newNumberOfCans = testMachine.getCanCount();
        assertEquals(numberOfCans + 10, newNumberOfCans);

        // best practice: invoke method multiple times for a more robust test
        numberOfCans = newNumberOfCans;
        testMachine.fillUp(5);
        newNumberOfCans = testMachine.getCanCount();
        assertEquals(numberOfCans + 5, newNumberOfCans);
    }

    @Test
    public void testInsertToken()
    {
        VendingMachine testMachine= new VendingMachine();

        int numberOfCans = testMachine.getCanCount();
        int numberOfTokens = testMachine.getTokenCount();
        testMachine.insertToken();
        int newNumberOfCans = testMachine.getCanCount();
        int newNumberOfTokens = testMachine.getTokenCount();
        assertEquals(numberOfCans - 1, newNumberOfCans);
        assertEquals(numberOfTokens + 1, newNumberOfTokens);

        // best practice: invoke method multiple times for a more robust test
        numberOfCans = newNumberOfCans;
        numberOfTokens = newNumberOfTokens;
        testMachine.insertToken();
        newNumberOfCans = testMachine.getCanCount();
        newNumberOfTokens = testMachine.getTokenCount();
        assertEquals(numberOfCans - 1, newNumberOfCans);
        assertEquals(numberOfTokens + 1, newNumberOfTokens);
    }
    
    @Test
    public void testDefaultConstructor()
    {
        VendingMachine testMachine= new VendingMachine();
        int numberOfCans = testMachine.getCanCount();
        int numberOfTokens = testMachine.getTokenCount();
        assertEquals(10, numberOfCans);
        assertEquals(0, numberOfTokens);
    }
    
    // @Test
    // public void testConstructor()
    // {
        // VendingMachine testMachine= new VendingMachine(20);
        // int numberOfCans = testMachine.getCanCount();
        // int numberOfTokens = testMachine.getTokenCount();
        // assertEquals(20, numberOfCans);
        // assertEquals(0, numberOfTokens);
    // }
}