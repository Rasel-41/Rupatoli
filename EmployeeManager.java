import java.io.*;
import java.util.*;

public class EmployeeManager {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
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
            countEmployees();
        } else if (command.startsWith("u")) {
            updateEmployee(command.substring(1));
        } else if (command.startsWith("d")) {
            deleteEmployee(command.substring(1));
        } else {
            System.out.println("Error: Invalid command.");
        }
    }

    private static List<String> readEmployeeFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String employeeData = reader.readLine();
            if (employeeData != null) {
                return new ArrayList<>(Arrays.asList(employeeData.split(",")));
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read employee data.");
        }
        return new ArrayList<>();
    }

    private static void writeEmployeeFile(List<String> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(String.join(",", employees));
        } catch (IOException e) {
            System.out.println("Error: Unable to write employee data.");
        }
    }

    private static void loadEmployees() {
        System.out.println("Loading employee data...");
        List<String> employees = readEmployeeFile();
        for (String employee : employees) {
            System.out.println(employee.trim());
        }
        System.out.println("Data Loaded.");
    }

    private static void showRandomEmployee() {
        System.out.println("Selecting a random employee...");
        List<String> employees = readEmployeeFile();
        if (!employees.isEmpty()) {
            Random random = new Random();
            System.out.println("Random Employee: " + employees.get(random.nextInt(employees.size())).trim());
        } else {
            System.out.println("No employees found.");
        }
        System.out.println("Data Loaded.");
    }

    private static void addEmployee(String newEmployee) {
        System.out.println("Adding new employee: " + newEmployee);
        List<String> employees = readEmployeeFile();
        employees.add(newEmployee);
        writeEmployeeFile(employees);
        System.out.println("Data Loaded.");
    }

    private static void searchEmployee(String employeeName) {
        System.out.println("Searching for employee: " + employeeName);
        List<String> employees = readEmployeeFile();
        if (employees.contains(employeeName)) {
            System.out.println("Employee found: " + employeeName);
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("Data Loaded.");
    }

    private static void countEmployees() {
        System.out.println("Counting employees...");
        List<String> employees = readEmployeeFile();
        System.out.println("Total employees: " + employees.size());
        System.out.println("Data Loaded.");
    }

    private static void updateEmployee(String employeeToUpdate) {
        System.out.println("Updating employee: " + employeeToUpdate);
        List<String> employees = readEmployeeFile();
        boolean updated = false;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).trim().equalsIgnoreCase(employeeToUpdate)) {
                employees.set(i, "Updated");
                updated = true;
                break;
            }
        }

        if (updated) {
            writeEmployeeFile(employees);
            System.out.println("Employee updated: " + employeeToUpdate);
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("Data Updated.");
    }

    private static void deleteEmployee(String employeeToDelete) {
        System.out.println("Deleting employee: " + employeeToDelete);
        List<String> employees = readEmployeeFile();

        if (employees.removeIf(employee -> employee.trim().equalsIgnoreCase(employeeToDelete))) {
            writeEmployeeFile(employees);
            System.out.println("Employee deleted: " + employeeToDelete);
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("Data Deleted.");
    }
}
