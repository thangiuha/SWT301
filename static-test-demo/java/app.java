package java; // Assuming your file is in a 'java' subdirectory relative to your project root for package declaration

import java.util.ArrayList;
import java.util.List;
import java.util.Random; // Unused import, SonarQube might flag this

public class App {

    private String message = "Hello from App!"; // Unused private field

    public App() {
        // Constructor
    }

    public void printWelcomeMessage(String name) {
        // Potential NullPointerException if name is null and not checked
        System.out.println("Welcome, " + name.toUpperCase() + "!");
    }

    public int addNumbers(int a, int b) {
        int result = a + b;
        // System.out.println("The sum is: " + result); // Commented out code
        return result;
    }

    public void processList() {
        List<String> items = new ArrayList<String>(); // Raw type, could use diamond operator
        items.add("Item 1");
        items.add("Item 2");
        // items.add(null); // Adding null might be problematic depending on usage

        for (int i = 0; i < items.size(); i++) { // Traditional for loop, SonarQube might suggest enhanced for loop
            if (items.get(i).equals("Item 1")) { // String literal comparison
                System.out.println("Found Item 1");
            }
        }

        // Example of a potential "cognitive complexity" issue if logic gets more complex
        int x = 10;
        int y = 20;
        if (x > 5) {
            if (y > 15) {
                if (x + y > 30) { // This nesting can be flagged
                    System.out.println("Complex condition met.");
                }
            }
        }
    }

    // Method that is not used anywhere in this simple example
    private void unusedMethod() {
        System.out.println("This method is not used.");
    }

    public static void main(String[] args) {
        App myApp = new App();
        myApp.printWelcomeMessage("Student");
        // myApp.printWelcomeMessage(null); // Uncomment to test NullPointerException scenario

        int sum = myApp.addNumbers(5, 7);
        System.out.println("Sum calculated by App: " + sum);

        myApp.processList();

        // Introduce a variable that is assigned but never used
        String unusedVariable = "test";

        // Introduce a hardcoded password (SonarQube should flag this as a security hotspot)
        String dbPassword = "password123";
        System.out.println("Connecting with password: " + dbPassword);

        // Example of redundant cast
        Object obj = "SomeString";
        String str = (String) obj; // This cast is redundant if obj is already known to be String
        System.out.println(str.length());

        // Division by zero potential
        int numerator = 10;
        int denominator = 0; // Set to 0 to see potential issue, SonarLint might not catch this at compile time without execution context
        // but SonarQube server analysis might based on patterns.
        // if (denominator != 0) {
        //     System.out.println("Result of division: " + (numerator / denominator));
        // }
    }
}