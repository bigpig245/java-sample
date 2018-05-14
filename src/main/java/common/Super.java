package common;

class Base {
    String a;
    Base() {
        System.out.print("Base");
    }

    Base(String text) {
        a = text;
        System.out.print(text);
    }
}

public class Super extends Base {
    Super(String text) {
    }

    public static void main(String[] args) {
        new Super("1"); /* Line 12 */
        new Base(); /* Line 13 */
    }
}
