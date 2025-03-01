import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // ✅ Argument validation: Ensure at least one argument is provided
        if (args.length < 1) {
            System.out.println("Error: No argument provided. Please enter a valid command.");
            return;
        }

        String command = args[0];

        if (command.equals("l")) {
            loadEmployees();
        } else if (command.equals("s")) {
            showRandomEmployee();
        } else if (command.startsWith("+")) {
            addEmployee(command.substring(1));
        } else if (command.startsWith("?")) {
            searchEmployee(command.substring(1));
        } else if (command.equals("c")) {
            countWords();
        } else if (command.startsWith("u")) {
            updateEmployee(command.substring(1));
        } else if (command.startsWith("d")) {
            deleteEmployee(command.substring(1));
        } else {
            System.out.println("Error: Invalid command.");
        }
    }

    // (Rest of the methods remain the same)
}
