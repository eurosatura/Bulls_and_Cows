package bullscows;
import java.util.*;

public class Main {
    static int bulls;
    static int cows;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String input = scanner.nextLine();
        int length = 0;
        if ((!input.matches("\\d+"))) {
            System.out.println("Error: \"" + input + "\" isn't a valid number.");
            return;
        } else if (Integer.parseInt(input) == 0) {
            System.out.println("Error! bound must be positive");
            return;
        } else {
            length = Integer.parseInt(input);
        }

        System.out.println("Input the number of possible symbols in the code:");
        int symbols = 0;
        input = scanner.nextLine();
        if ((!input.matches("\\d+"))) {
            System.out.println("Error: \"" + input + "\" isn't a valid number.");
            return;
        } else if (Integer.parseInt(input) < length) {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + input + " unique symbols.");
            return;
        } else if (Integer.parseInt(input) > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        } else {
            symbols = Integer.parseInt(input);
        }

        generateStars(length, symbols);
        String secretCode = generateSecretCode(length, symbols);
        System.out.println("Okay, let's start a game!");
        play(scanner, secretCode);

    }
    static void play(Scanner scanner, String secretCode) {
        boolean output = false;
        int turn = 1;
        while (!output) {
            System.out.println("Turn " + turn + ":");
            String result = scanner.next();
            getGrade(result, secretCode);
            System.out.print("Grade: ");

            if (bulls == secretCode.length()) {
                System.out.println(bulls + " bulls.");
                System.out.println("Congratulations! You guessed the secret code.");
                output = true;
            } else {
                System.out.print(bulls + " bulls(s) and " + cows + " cow(s).\n");
            }

            turn++;
            bulls = 0;
            cows = 0;
        }
    }

    static void generateStars(int length, int symbols) {
        System.out.print("The secret is prepared: ");

        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }

        if (symbols <= 10) {
            System.out.println(" (0-" + Character.forDigit(symbols - 1,16) + ").");
        } else {
            System.out.println(" (0-9, a-" + Character.forDigit(symbols -1 , 36) + ").");
        }
    }

    static void getGrade(String result, String secretCode) {

        String[] answerList = secretCode.split("");
        if (result.length() == secretCode.length()) {
            for (int i = 0; i < secretCode.length(); i++) {
                if(secretCode.charAt(i) == result.charAt(i)) {
                    bulls++;
                } else if (result.contains(answerList[i])) {
                    cows++;
                }
            }
        } else {
            System.out.println("You should guess a " + secretCode.length() + " digits number.");
        }
    }

    public static String generateSecretCode (int length, int symbols) {
        StringBuilder stringOfSymbols = new StringBuilder("0123456789");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        //length = 15;
        //symbols = 15;

        if (symbols > 10) {
            for (int i = 0; i < symbols - 10; i++) {
                stringOfSymbols.append(alphabet.charAt(i));
            }
        }

        StringBuilder secretCode = new StringBuilder();
        Random random = new Random();
        if (length > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + length
                    + " because there aren't enough unique digits");
        } else {
            char randomChar;
            do {
                randomChar = stringOfSymbols.charAt(random.nextInt(length));
                if (!secretCode.toString().contains(String.valueOf(randomChar))) {
                    secretCode.append(randomChar);
                }
            } while (secretCode.length() < length);

        }
        return secretCode.toString();
    }
}