import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // ✅ No arguments provided check
        if (args.length == 0) {
            System.out.println("Error: No arguments provided!");
            System.out.println("Usage: java EmployeeManager <option>");
            return; // Program exits early
        }

        // 👇 আগের কোডের মতো বাকি অংশ থাকবে
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                for (String emp : e) {
                    System.out.println(emp);
                }
                r.close();
            } catch (Exception e) {
                System.out.println("Error: Unable to read file.");
            }
            System.out.println("Data Loaded.");
        }

        // (বাকি কোড অপরিবর্তিত থাকবে)
    }
}
