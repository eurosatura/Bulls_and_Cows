import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double celsiusTemp = scanner.nextDouble();
        System.out.println(celsiusTemp * 1.8 + 32);
    }
}