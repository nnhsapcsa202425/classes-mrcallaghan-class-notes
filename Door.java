/**
 * A class to model a Door.  Ch. 3: Door (pair) activity.
 * 
 * @author mr callaghan
 * @version 18sep2024
 */
public class Door
{
    private boolean isLocked;
    private boolean isOpened;
    private String name;
    
    /**
     * Default constructor for class Door.  Sets the default state to closed and unlocked with a null name.
     */
    public Door()
    {
        // default state of a new door is unlocked and closed
        this.isLocked = false;
        this.isOpened = false;
        this.name = null;
    }
    
    /**
     * Constructor for class Door that provides a custom starting state.
     * 
     * @param locked starting lock state for the door
     * @param opened starting open state for the door
     * @param initialName starting name for the door
     */
    public Door(boolean locked, boolean opened, String initialName)
    {
        this.isLocked = locked;
        this.isOpened = opened;
        this.name = initialName;
    }
    
    /**
     * Locks the door.
     */
    public void lock()
    {
        this.isLocked = true;
    }
    
    /**
     * Unlocks the door.
     */
    public void unlock()
    {
        this.isLocked = false;
    }
    
    /**
     * Opens the door.
     */
    public void open()
    {
        this.isOpened = true;
    }
    
    /**
     * Closes the door.
     */
    public void close()
    {
        this.isOpened = false;
    }
    
    /**
     * Returns door's lock state.
     * 
     * @return the lock state of the door.
     */
    public boolean getLocked()
    {
        return this.isLocked;
    }

    /**
     * Returns door's open state.
     * 
     * @return the open state of the door.
     */
    public boolean getOpened()
    {
        return this.isOpened;
    }
    
    /**
     * Returns door's name.
     * 
     * @return the name of the door.
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Sets the door's name to a new name.
     * 
     * @param newName the new name of the door.
     */
    public void setName(String newName)
    {
        this.name = newName;
    }
    
    /**
     * toString method for a door.
     * 
     * @return string representation of a door's state.
     */
    public String toString()
    {
        String str = "The state of this door:\n";
        str += "name: " + this.getName() + "\n";
        str += "opened: " + this.getOpened() + "\n";
        str += "locked: " + this.getLocked() + "\n";
        return str;
        
    }

}