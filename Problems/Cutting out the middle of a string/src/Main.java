import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String userStr = scanner.nextLine();
        StringBuilder sb = new StringBuilder(userStr);

        if (userStr.length() % 2 == 0) {
            sb.replace(userStr.length() / 2 - 1, userStr.length() / 2 + 1, "");
        } else {
            sb.replace(userStr.length() / 2, userStr.length() / 2 + 1, "");
        }
        System.out.println(sb);
    }
}