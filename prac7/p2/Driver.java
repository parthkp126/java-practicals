public class Driver {
    public static void main(String[] args)
            throws ReflectiveOperationException {
        SampleTests tests = new SampleTests();
        int count = MiniTestRunner.runTests(tests);

        System.out.println("Tests run: " + count);
    }
}