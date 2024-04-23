package GeeksForGeeks.Java.Operators;

public class Unary {
    public static void main(String[] args)
    {
        // Interger declared
        int a = 10;
        int b = 10;
        
        // Using unary operators
        System.out.println("Postincrement : " + (a++));
        System.out.println("Preincrement : " + (++a));
        
        System.out.println("Postdecrement : " + (b--));
        System.out.println("Predecrement : " + (--b));
    }
}
