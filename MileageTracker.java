/**
 * This class models a mileage tracker for a car.
 *
 * @author mrcallaghan
 * @version 10sep2024
 */
public class MileageTracker
{
    /*
     * 2. Define the instance variables (store the object's attributes):
     *      specify the visibility (e.g., private)
     *          public: accessible by any code in any class
     *          private: only accessible by mehtods in this class
     *      specify the type (e.g., int, double, String)
     *      specify the name (e.g., distanceDriven)
     *      
     *      Instance variables differ from local variables in the folowing ways:
     *          scoped to the entire class (accessible in all methods of the class;
     *                                      lifetime is the same of the object)
     *          automatically initialized to a default value (0, false, null)
     *          best pratice is not to immediately initialize instance vairables
     */
    private int distanceDriven;  // in units of miles
    private int fuelConsumed;    // in units of gallons
    private String vin;          // vehicle identification number


    /*
     * 3. Define the constructor(s):
     *      responsible for initializing newly created object
     *      invoked automatically via the new operator
     *      name of the constuctor must match the name of the class
     *      has no return type (not even void)
     *      multiple constructors may be defined by a class
     *      one constructor may call another constructor (with restrictions)
     */
    
    /**
     * Default constructor for the MileasgeTracker class.
     *      Initializes the object's miles driven and fuel consumed to 0
     *          and the vin to null
     */
    public MileageTracker()
    {
        /*
         * The "this" reserved word references the current object
         *      (like 'self' in Python)
         *      It's usage is encourage, but not always required.
         */
        this.distanceDriven = 0;
        this.fuelConsumed = 0;
        this.vin = null;
    }
    
    /**
     * Constructs a new MileageTracker object with the specified
     *  miles driven and fule consumed.  vin starts as null.
     *  
     *  @param initialDistanceDriven the number of miles already driven
     *  @param initialFuelConsumed the number of gallons of fuel already consumed
     */
    public MileageTracker(int initialDistanceDriven, int initialFuelConsumed)
    {
        this.distanceDriven = initialDistanceDriven;
        this.fuelConsumed = initialFuelConsumed;
        this.vin = null;
    }
    

    
    /*
     * 1. Define methods by specifying:
     *      the visibility (e.g., public, private)
     *      the return type (e.g., void, int)
     *      the method name (e.g., incrementDistanceDriven, getDistanceDriven, etc.)
     *      the parameters and thier types (e.g., miles of type int)
     *      
     */
    
    /**
     * Increments the number of miles that the car has driven.
     * 
     * @param miles the additional distance, in miles, this car has driven.
     */
    public void incrementDistanceDriven(int miles)
    {
        //this.distanceDriven = this.distanceDriven + miles;
        this.distanceDriven += miles;
    }
    
    /**
     * Returns the total number of miles driven.
     * 
     * @return the total number of miles driven.
     */
    public int getDistanceDriven()
    {
        return this.distanceDriven;
    }
    
    
    
    
    /**
     * Increment the number of gallons of fuel that this car has consumed
     * 
     * @param gallons    the additional fuel, in gallons, this car has consumed
     */
    public void incrementFuelConsumed(int gallons)
    {
        this.fuelConsumed += gallons;
    }
    
    /**
     * Returns the total number of gallons of fuel consumed
     * 
     * @return the total number of gallons of fuel consumed
     */
    public int getFuelConsumed()
    {
        return this.fuelConsumed;
    }
    
    
    /**
     * Returns the current mileage, in miles per gallon
     * 
     * @return the current mileage, in miles per gallon
     */
    public int getMileage()
    {
        int mileage = this.distanceDriven / this.fuelConsumed;
        return mileage;
        
    }
    
    /**
     * Returns the vehicle identification (VIN) of this car.
     * 
     * @return the vehicle identification (VIN) of this car
     */
    public String getVIN()
    {
        return this.vin;
        
    }
    
    /**
     * Sets the vehicle identification (VIN) of this car.
     * 
     * @param vin    the vehicle identification (VIN) of this car
     */
    public void setVIN(String newVIN)
    {
        /*
         * When the parameter is named vin, it "shadows" the instance variable vin.
         * 
         * Local and parameter variables "shadow" instance vairables of the same name.  In this
         *  code, the vin would refer to the parameter vin and not the instance variable.
         *  
         *  To refer explicitly to an instance variable, use "this".
         *  
         *  Better practice: avoid this issue by giving local, parameter, and instance variables
         *      unique name.
         */
        
        // bad
        //vin = vin;
        
        // good
        //this.vin = vin;
        
        // better
        this.vin = newVIN;
    }
    
    public String toString()
    {
        String str = "\nMileageTracker:" + "\nVIN: " + this.getVIN() +
            "\nDistance Driven: " + this.getDistanceDriven() + " miles" +
            "\nFuel Consumed: " + this.getFuelConsumed() + " gallons" + 
            "\nMileage: " + this.getMileage() + " mpg";
        
        return str;
    }
    
    
    
    public static void main()
    {
        MileageTracker tracker = new MileageTracker();
        tracker.incrementFuelConsumed(10);
        tracker.incrementDistanceDriven(200);
        MileageTracker tracker2 = new MileageTracker(100000, 5000);
        System.out.println(tracker);
        System.out.println(tracker2);
    }
    
}