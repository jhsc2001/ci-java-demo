/**
 * Die Klasse {@code Calculator} stellt grundlegende mathematische Operationen bereit.
 *
 * <p>Diese Klasse dient als einfaches Beispiel für eine CI-Pipeline-Übung.
 * Sie enthält Methoden zum Addieren, Subtrahieren, Multiplizieren und Dividieren
 * zweier Ganzzahlen.
 *
 * <p>Jede Methode ist statisch, sodass kein Objekt der Klasse erzeugt werden muss.
 *
 * @author  jansommer, dwall
 * @version 04.11.2025
 */
public class Calculator {

    /**
     * Addiert zwei ganze Zahlen.
     *
     * @param a erster Summand
     * @param b zweiter Summand
     * @return die Summe {@code a + b}
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtrahiert eine Zahl von einer anderen.
     *
     * @param a Minuend (die Zahl, von der subtrahiert wird)
     * @param b Subtrahend (die Zahl, die abgezogen wird)
     * @return das Ergebnis {@code a - b}
     */
    public static int sub(int a, int b) {
        return a - b;
    }

    /**
     * Multipliziert zwei ganze Zahlen.
     *
     * @param a erster Faktor
     * @param b zweiter Faktor
     * @return das Produkt {@code a * b}
     */
    public static int mul(int a, int b) {
        return a * b;
    }

    /**
     * Dividiert eine ganze Zahl durch eine andere.
     *
     * <p>Falls der Divisor {@code 0} ist, wird eine
     * {@link IllegalArgumentException} ausgelöst.
     *
     * @param a Dividend (die zu teilende Zahl)
     * @param b Divisor (die Zahl, durch die geteilt wird)
     * @return das Ergebnis {@code a / b}
     * @throws IllegalArgumentException wenn {@code b == 0}
     */
    public static int div(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division durch 0 ist nicht erlaubt.");
        }
        return a / b;
    }
}
