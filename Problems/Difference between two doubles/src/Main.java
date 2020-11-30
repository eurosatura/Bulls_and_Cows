import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        // put your code here
        double val1 = scanner.nextDouble();
        double val2 = scanner.nextDouble();
        System.out.println(val2 - val1);
    }
}