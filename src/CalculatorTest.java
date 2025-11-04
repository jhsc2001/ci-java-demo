/**
 * Die Klasse {@code CalculatorTest} dient zum Überprüfen der Funktionalität
 * der Methoden der Klasse {@link Calculator}.
 *
 * <p>Da kein Testframework wie JUnit verwendet wird, werden die Tests manuell
 * über einfache Vergleichsoperationen durchgeführt. Die Ergebnisse werden auf
 * der Konsole ausgegeben. Bei einem fehlgeschlagenen Test beendet sich das
 * Programm mit {@code System.exit(1)}, damit die CI-Pipeline den Fehler erkennt.
 *
 * <p>Diese Datei wird automatisch im Rahmen der Continuous Integration (CI)
 * ausgeführt, um sicherzustellen, dass alle Berechnungen korrekt funktionieren.
 *
 * @author  jansommer, dwall
 * @version 04.11.2025
 */
public class CalculatorTest {

    /** Anzahl der ausgeführten Tests. */
    private static int testsRun = 0;

    /** Anzahl der fehlgeschlagenen Tests. */
    private static int testsFailed = 0;

    /**
     * Vergleicht zwei Ganzzahlen auf Gleichheit.
     *
     * @param testName Beschreibung des Tests (z. B. "add(2, 3)")
     * @param expected erwartetes Ergebnis
     * @param actual   tatsächlich berechnetes Ergebnis
     */
    private static void assertEquals(String testName, int expected, int actual) {
        testsRun++;
        if (expected != actual) {
            testsFailed++;
            System.out.println("[FEHLER] " + testName + " → erwartet: " + expected + ", erhalten: " + actual);
        } else {
            System.out.println("[OK]      " + testName);
        }
    }

    /**
     * Startet alle definierten Tests für den {@link Calculator}.
     *
     * <p>Hier werden verschiedene Rechenoperationen überprüft,
     * inklusive des Ausnahmefalls bei Division durch Null.
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        System.out.println("Starte Testläufe für Calculator...\n");

        // --- Addition ---
        assertEquals("add(2, 3)", 5, Calculator.add(2, 3));
        assertEquals("add(-4, 7)", 3, Calculator.add(-4, 7));

        // --- Subtraktion ---
        assertEquals("sub(10, 4)", 6, Calculator.sub(10, 4));
        assertEquals("sub(0, 5)", -5, Calculator.sub(0, 5));

        // --- Multiplikation ---
        assertEquals("mul(3, 7)", 21, Calculator.mul(3, 7));
        assertEquals("mul(-2, 4)", -8, Calculator.mul(-2, 4));

        // --- Division ---
        assertEquals("div(20, 5)", 4, Calculator.div(20, 5));

        // --- Division durch 0 ---
        try {
            Calculator.div(1, 0);
            System.out.println("[FEHLER] div(1, 0) – erwartete Ausnahme nicht ausgelöst!");
            testsFailed++;
        } catch (IllegalArgumentException e) {
            System.out.println("[OK]      div(1, 0) löst korrekt IllegalArgumentException aus");
        }

        // --- Zusammenfassung ---
        System.out.println("\nTests ausgeführt: " + testsRun + ", fehlgeschlagen: " + testsFailed);

        // Falls Fehler vorhanden sind, wird Exit-Code 1 zurückgegeben
        if (testsFailed > 0) {
            System.out.println("Mindestens ein Test ist fehlgeschlagen – Build FEHLGESCHLAGEN!");
            System.exit(1);
        } else {
            System.out.println("Alle Tests erfolgreich – Build ERFOLGREICH!");
        }
    }
}
