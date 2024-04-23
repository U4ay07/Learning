package GeeksForGeeks.Java.Variables;

public class Instance {
    // Declared Instance Variable
    public String geek;
    public int i;
    public Integer I;
    public Instance()
    {
        // Default Constructor
        // initializing Instance Variable
        this.geek = "Uday N";
    }
    
    // Main Method
    public static void main(String[] args)
    {
        // Object Creation
        Instance name = new Instance();
        
        // Displaying O/P
        System.out.println("Geek name is: " + name.geek);
        System.out.println("Default value for int is "
                                   + name.i);
        
        // toString() called internally
        System.out.println("Default value for Integer is "
                                   + name.I);
    }
}
