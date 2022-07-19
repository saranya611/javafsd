import java.util.Scanner;

public class typecast {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the character: ");
        char a = sc.next().charAt(0);
        System.out.println("char value: " + a);
        // implicit typecast
        System.out.println("implicit typecast");
        int b = a;
        System.out.println("int value of char: " + b);
        float b1 = a;
        System.out.println("float value of char: " + b1);
        double b2 = a;
        System.out.println("double value of char: " + b2);
        long b3 = a;
        System.out.println("long value of char: " + b3);

        // explicit typecast
        System.out.println("explicit typecast");
        int a1 = (int) b1;
        System.out.println("int value of float: " + a1);
        float a2 = (float) b2;
        System.out.println("float value of double: " + a2);

    }

}
