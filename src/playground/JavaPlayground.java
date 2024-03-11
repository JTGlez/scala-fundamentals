package playground;

public class JavaPlayground {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
        System.out.println(Person.N_EYES); // Class level functionality: it doesn't depend of a certain instantiation of the class
    }
}

class Person {

    public static final int N_EYES = 2; // Universal constant in the class

} 