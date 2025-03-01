import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // Ensure at least one argument is passed
        if (args.length < 1) {
            System.out.println("Error: No argument provided.");
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

    private static void loadEmployees() {
        System.out.println("Loading data...");
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String[] employees = reader.readLine().split(",");
            for (String emp : employees) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        System.out.println("Data Loaded.");
    }

    private static void showRandomEmployee() {
        System.out.println("Loading data...");
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String[] employees = reader.readLine().split(",");
            Random rand = new Random();
            System.out.println(employees[rand.nextInt(employees.length)]);
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        System.out.println("Data Loaded.");
    }

    private static void addEmployee(String name) {
        System.out.println("Loading data...");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", true))) {
            writer.write(", " + name);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
        System.out.println("Data Loaded.");
    }

    private static void searchEmployee(String name) {
        System.out.println("Loading data...");
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String[] employees = reader.readLine().split(",");
            boolean found = Arrays.asList(employees).contains(name);
            System.out.println(found ? "Employee found!" : "Employee not found.");
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
        System.out.println("Data Loaded.");
    }

    private static void countWords() {
        System.out.println("Loading data...");
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String content = reader.readLine();
            int wordCount = content.split(",").length;
            System.out.println(wordCount + " employee(s) found.");
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
        System.out.println("Data Loaded.");
    }

    private static void updateEmployee(String name) {
        System.out.println("Loading data...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String[] employees = reader.readLine().split(",");
            reader.close();

            for (int i = 0; i < employees.length; i++) {
                if (employees[i].equals(name)) {
                    employees[i] = "Updated";
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
            writer.write(String.join(",", employees));
            writer.close();

        } catch (IOException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
        System.out.println("Data Updated.");
    }

    private static void deleteEmployee(String name) {
        System.out.println("Loading data...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            List<String> employees = new ArrayList<>(Arrays.asList(reader.readLine().split(",")));
            reader.close();

            if (employees.remove(name)) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
                writer.write(String.join(",", employees));
                writer.close();
                System.out.println("Employee deleted.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
        System.out.println("Data Deleted.");
    }
}
