public class CalculatorTest {
    private static int testsRun = 0, testsFailed = 0;

    private static void assertEquals(String name, int expected, int actual) {
        testsRun++;
        if (expected != actual) {
            testsFailed++;
            System.out.println("[FAIL] " + name + " expected " + expected + " got " + actual);
        } else {
            System.out.println("[OK]   " + name);
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();

        // positive Tests
        assertEquals("add(2,3)", 6, c.add(2,3));
        assertEquals("sub(10,4)", 6, c.sub(10,4));
        assertEquals("mul(3,7)", 21, c.mul(3,7));
        assertEquals("div(20,5)", 4, c.div(20,5));

        // Fehlerfall
        try {
            c.div(1,0);
            testsFailed++;
            System.out.println("[FAIL] div(1,0) expected exception");
        } catch (IllegalArgumentException e) {
            System.out.println("[OK]   div(1,0) throws exception");
        }

        System.out.println("\nTests run: " + testsRun + ", failed: " + testsFailed);
        if (testsFailed > 0) System.exit(1);
    }
}
