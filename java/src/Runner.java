import solutions.Solution;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which year?");
        String year = sc.nextLine();

        System.out.println("Which day?");
        String day = sc.nextLine();

        String className = "solutions.season" + year + ".Day" + day;
        try {
            Class<?> clazz = Class.forName(className);
            Solution solution = (Solution) clazz.getDeclaredConstructor().newInstance();
            String result = solution.solve(sc);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Could not load solution: " + e.getMessage());
        }
    }
}