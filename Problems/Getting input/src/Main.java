class InputClass {
    public static String getString() {
        // write your code here
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("The input string: " + getString());
    }
}