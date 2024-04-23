package GeeksForGeeks.Java.Variables;

public class Static {
    public static String geek = "Uday N";
    
    public static void main(String[] args)
    {
        
        // geek variable can be accessed without object
        // creation Displaying O/P GFG.geek --> using the
        // static variable
        System.out.println("Geek Name is : " + Static.geek);
        
        // static int c=0;
        // above line,when uncommented,
        // will throw an error as static variables cannot be
        // declared locally.
    }
}

/*
class GFG
{
    // Static variable
    static int a;
    
    // Instance variable
    int b;
}
 */