# Java CI Demo (GitHub Actions)

## Plattform
GitHub Actions

## Aufbau der Pipeline
1. Bei jedem Push oder Pull Request startet GitHub automatisch den Workflow.
2. Schritte:
   - Checkout des Codes
   - Java 21 installieren
   - Kompilieren (`javac -d bin src/*.java`)
   - Tests ausführen (`java --class-path bin CalculatorTest`)
3. Wenn ein Test fehlschlägt → Exit-Code 1 → Workflow wird rot (failed).

## Lokal testen
```bash
mkdir -p bin
javac -d bin src/*.java
java --class-path bin CalculatorTest
