package GeeksForGeeks.Java.Operators;

public class Ternary {
    public static void main(String[] args)
    {
        int a = 20, b = 10, c = 30, result;
        
        // result holds max of three
        // numbers
        // condition ? if true : if false
        result = ((a > b) ? (a > c) ? a : c : (b > c) ? b : c);
        System.out.println("Max of three numbers = " + result);
    }
}
