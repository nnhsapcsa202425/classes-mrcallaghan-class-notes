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
     *      - specify the visibility (e.g., private)
     *              private: only accessible by methods in this class
     *              public: accessible by any code in any class
     *      - specify the type (e.g., int, double, String)
     *      - specify the name (e.g., distanceDriven)
     *      
     *      Instance varaiables differ from local variables in the following ways:
     *      - scoped to the entire class (accessible in all methods of the class;
     *              lifetime is the same as the object)
     *      - automatically initialized to a default value (0, 0.0, false, null)
     *      - best practice is not to immediately initialize instance variables when declaring.
     */
    private int distanceDriven;  // in units of miles
    private int fuelConsumed;    // in units of gallons
    private String vin;          // vehicle identification number






    
    /*
     * 3. Define the constructor(s):
     *      - responsible for initializing newly created objects
     *      - invoked automatically via the new operator
     *      - name of the constructor must match that of the class
     *      - has no return type (not even void)
     *      - multiple constructors may be defined
     *      - one costructor may call upon another constructor
     */
    
    /**
     * The default constructor for the MileageTracker class.
     *      Initializes the object's miles driven and fuel consumed to 0 and the vin to null.
     */
    public MileageTracker()
    {
        /*
         * The "this" reserved word references the current object on which the method was called.
         *      (like 'self' in Python)
         * Its usage is encouraged but not always required.
         */
        this.distanceDriven = 0;
        this.fuelConsumed = 0;
        this.vin = null;
    }
    
    /**
     * Constructs a new MileageTracker object with the specified distance driven and fuel
     *      consumed. vin is null.
     */
    public MileageTracker(int initialDistanceDriven, int initialFuelConsumed)
    {
        this.distanceDriven = initialDistanceDriven;
        this.fuelConsumed = initialFuelConsumed;
        this.vin = null;
    }
    
    
    
    
    
    /*
     * 1. Define methods by specifying:
     *      - the visibility (e.g., public, private)
     *      - the return type (e.g., void, int)
     *      - the method name (e.g., incrementDistanceDriven, getDistanceDriven)
     *      - the parameters and thier types (e.g., miles of type int)
     */
    
    /**
     * Increments the number of miles that the car has driven.
     * 
     * @param miles the additional distance, in miles, this car has driven
     */
    public void incrementDistanceDriven(int miles)
    {
        return;
    }
    
    /**
     * Returns the total number of miles driven.
     * 
     * @return the total number of miles driven.
     */
    public int getDistanceDriven()
    {
        return 0;
    }
    
    
    
    /**
     * Increment the number of gallons of fuel that this car has consumed
     * 
     * @param gallons    the additional fuel, in gallons, this car has consumed
     */
    public void incrementFuelConsumed(int gallons)
    {
        //this.fuelConsumed += gallons;
    }
    
    /**
     * Returns the total number of gallons of fuel consumed
     * 
     * @return the total number of gallons of fuel consumed
     */
    public int getFuelConsumed()
    {
        //return this.fuelConsumed;
        return 0;
    }
    
    
    /**
     * Returns the current mileage, in miles per gallon
     * 
     * @return the current mileage, in miles per gallon
     */
    public int getMileage()
    {
        //int mileage = this.fuelConsumed / this.distanceDriven;
        //return mileage;
        return 0;
    }
    
    /**
     * Returns the vehicle identification (VIN) of this car.
     * 
     * @return the vehicle identification (VIN) of this car
     */
    public String getVIN()
    {
        //return this.vin;
        return "";
    }
    
    /**
     * Sets the vehicle identification (VIN) of this car.
     * 
     * @param vin    the vehicle identification (VIN) of this car
     */
    public void setVIN(String vin)
    {
        //vin = vin;
    }
    
    // this is client code and could be called from any class in our repository
    public static void main()
    {
        MileageTracker car = new MileageTracker();
        MileageTracker car2 = new MileageTracker(100, 20);
        //MileageTracker car3 = new MileageTracker(100);
        System.out.println(car);
        System.out.println(car2);
    }
}






