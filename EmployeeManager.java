import java.io.*;
import java.util.*;

public class EmployeeManager {
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
        System.out.println("Loading employee data...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String employeeData = reader.readLine();
            String[] employeeList = employeeData.split(",");
            for (String employee : employeeList) {
                System.out.println(employee.trim());
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: Unable to load employee data.");
        }
        System.out.println("Data Loaded.");
    }

    private static void showRandomEmployee() {
        System.out.println("Selecting a random employee...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String employeeData = reader.readLine();
            String[] employeeList = employeeData.split(",");
            Random random = new Random();
            int randomIndex = random.nextInt(employeeList.length);
            System.out.println("Random Employee: " + employeeList[randomIndex].trim());
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: Unable to fetch random employee.");
        }
        System.out.println("Data Loaded.");
    }

    private static void addEmployee(String newEmployee) {
        System.out.println("Adding new employee: " + newEmployee);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", true));
            writer.write(", " + newEmployee);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: Unable to add employee.");
        }
        System.out.println("Data Loaded.");
    }

    private static void searchEmployee(String employeeName) {
        System.out.println("Searching for employee: " + employeeName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String employeeData = reader.readLine();
            String[] employeeList = employeeData.split(",");
            boolean isFound = false;
            for (String employee : employeeList) {
                if (employee.trim().equalsIgnoreCase(employeeName)) {
                    System.out.println("Employee found: " + employeeName);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Employee not found.");
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: Unable to search for employee.");
        }
        System.out.println("Data Loaded.");
    }

    private static void countWords() {
        System.out.println("Counting words...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String employeeData = reader.readLine();
            String[] employeeList = employeeData.split(",");
            System.out.println("Total employees: " + employeeList.length);
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: Unable to count words.");
        }
        System.out.println("Data Loaded.");
    }

    private static void updateEmployee(String employeeToUpdate) {
        System.out.println("Updating employee: " + employeeToUpdate);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String employeeData = reader.readLine();
            String[] employeeList = employeeData.split(",");
            for (int i = 0; i < employeeList.length; i++) {
                if (employeeList[i].trim().equalsIgnoreCase(employeeToUpdate)) {
                    employeeList[i] = "Updated";
                    break;
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
            writer.write(String.join(",", employeeList));
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: Unable to update employee.");
        }
        System.out.println("Data Updated.");
    }

    private static void deleteEmployee(String employeeToD
