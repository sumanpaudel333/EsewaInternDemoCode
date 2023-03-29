package Week2;

@FunctionalInterface
interface DemoAnonymous {
    void meth1();

    //void meth2();
}

public class AnonymousDemo {
    public static void main(String[] args) {

        //Anonymous Class
        /*DemoAnonymous obj = new DemoAnonymous() {
            @Override
            public void meth1() {
                System.out.println("This is method 1 of AnonymousClass");
            }

            @Override
            public void meth2() {
                System.out.println("This is method 2 of AnonymousClass");
            }
        };
        obj.meth1();
        obj.meth2();*/

        //lambda Expression
        DemoAnonymous obj1 = () -> {
            System.out.println("I am method 1 from lambda Expression");
        };
        obj1.meth1();
    }
}
