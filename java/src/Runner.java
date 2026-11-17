import solutions.Solution;

import java.util.Scanner;

public class Runner {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which year? (2015, 2016, ...)");
        String year = sc.nextLine();

        System.out.println("Which day? (1a, 1b, ...)");
        String day = sc.nextLine();

        String className = "solutions.season" + year + ".Day" + day;
        try {
            Class<?> clazz = Class.forName(className);
            Solution solution = (Solution) clazz.getDeclaredConstructor().newInstance();
            System.out.println("Paste task input ...");
            String result = solution.solve(sc);
            System.out.println("Solution:");
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Could not load solution: " + e.getMessage());
        }
    }
}
