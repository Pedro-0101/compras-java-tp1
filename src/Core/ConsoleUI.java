package Core;

import Core.Log.ILogger;
import java.util.Scanner;

public class ConsoleUI {
    private final ILogger logger;
    private final Scanner scanner;

    public ConsoleUI(ILogger logger) {
        this.logger = logger;
        this.scanner = new Scanner(System.in);
    }

    public void display(String message) {
        logger.log("DISPLAY: " + message);
    }

    public String readString(String prompt) {
        display(prompt);
        String input = scanner.nextLine();
        logger.log("INPUT: " + input);
        return input;
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readString(prompt));
            } catch (NumberFormatException e) {
                display("Por favor, insira um número inteiro válido.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readString(prompt));
            } catch (NumberFormatException e) {
                display("Por favor, insira um número decimal válido.");
            }
        }
    }

    public void header(String title) {
        display("\n==================================");
        display("   " + title.toUpperCase());
        display("==================================");
    }
}
