import java.util.Scanner;
public class Main {

    public static boolean isVowel(char ch) {
        // write your code here
        char chLC = Character.toLowerCase(ch);
        return chLC == 'a' || chLC == 'e' || chLC == 'i' || chLC == 'o' || chLC == 'u';
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}