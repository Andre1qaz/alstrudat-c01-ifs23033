package del.alstrudat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Util {
    private static Scanner scanner = new Scanner(System.in);

    // Get the shared Scanner instance
    public static Scanner getScanner() {
        return scanner;
    }

    // Set custom input for testing
    public static void setInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(inputStream);
    }

    // Close the Scanner
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
