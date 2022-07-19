class AccessSpecifier {
    private String str;
    int a;

    // using this pointer
    public void set(String str, int a) {
        this.str = str;
        if (a < 0) {
            this.a = 5000;
        } else {
            this.a = a;
        }
    }

    // without using this pointer
    // by giving another name for the private variable
    public void get(String msg) {
        str = msg;
    }

    void func1() {
        System.out.println(str);
    }

    void func() {
        System.out.println(str);
        System.out.println(a);

    }

    protected void difference() {
        System.out.println("im protected method");
        int e = 5;
        int f = 4;
        System.out.println("the difference is " + (e - f));
    }

    void print() {
        System.out.println("this is default method");
    }

    public void sum() {
        int c = 5;
        int d = 4;
        System.out.println("this is public method");
        System.out.println("the sum is " + (c + d));
    }
}

public class AccessSpecifier1 {
    public static void main(String args[]) {
        AccessSpecifier p = new AccessSpecifier();
        p.difference();
        p.print();
        p.sum();
        p.set("welcome to private variable", 8000);
        p.func();
        p.get("saranya");
        p.func1();
    }

}
