package tasks;

/**
 * @author Alexey Tkachenko
 */
public class Test {

    class InnerTest {

        static void get () {
            System.out.println("get");
        }
    }

}

class MainTest {

    public static void main(String[] args) {
        Test test = new Test();
        Test.InnerTest innerTest = test.new InnerTest();

        Test.InnerTest.get();

    }
}
