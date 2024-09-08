

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MileageTrackerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MileageTrackerTest
{
    /**
     * Default constructor for test class MileageTrackerTest
     */
    public MileageTrackerTest()
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
    public void testIncrementDistanceDriven()
    {
        MileageTracker testTracker = new MileageTracker();
        testTracker.incrementDistanceDriven(10);
        int amount = testTracker.getDistanceDriven();
        
        assertEquals(10, amount);
        
        // best practice: invoke method multiple times for a more robust test
        testTracker.incrementDistanceDriven(5);
        amount = testTracker.getDistanceDriven();
        assertEquals(15, amount);
    }
    
    @Test
    public void testGetMileage()
    {
        MileageTracker testTracker = new MileageTracker();
        testTracker.incrementDistanceDriven(100);
        testTracker.incrementFuelConsumed(4);
        int mileage = testTracker.getMileage();
        assertEquals(25, mileage);
    }
    
    @Test
    public void testSetVIN()
    {
        MileageTracker testTracker = new MileageTracker();
        String testVIN = new String("V176342FGB45B323A");
        testTracker.setVIN(testVIN);
        String returnedVIN = testTracker.getVIN();
        assertEquals(testVIN, returnedVIN);
    }
}






