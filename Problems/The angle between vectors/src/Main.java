import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double length1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double length2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

        double cos = (x1 * x2 + y1 * y2) / (length1 * length2);

        System.out.println((int) Math.toDegrees(Math.acos(cos)));
    }
}