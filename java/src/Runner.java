import solutions.Solution;

void main() {
    Scanner sc = new Scanner(System.in);

    IO.println("Which year? (2015, 2016, ...)");
    String year = sc.nextLine();

    IO.println("Which day? (1a, 1b, ...)");
    String day = sc.nextLine();

    String className = "solutions.season" + year + ".Day" + day;
    try {
        Class<?> clazz = Class.forName(className);
        Solution solution = (Solution) clazz.getDeclaredConstructor().newInstance();
        IO.println("Paste task input ...");
        String result = solution.solve(sc);
        IO.println("Solution:");
        IO.println(result);
    } catch (Exception e) {
        System.err.println("Could not load solution: " + e.getMessage());
    }
}
