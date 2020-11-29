package bullscows;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Ask for the length of the secret code.
        System.out.println("Please, enter the secret code's length:");

        int codeLength = 11;
        while (codeLength > 10) {
            codeLength = scan.nextInt();
            if (codeLength > 10) {
                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            }
        }

        //and then generate the code.
        String secretCode = generateSecretCode(codeLength);

        System.out.println("Okay, let's start a game!");

        int turn = 0;
        boolean result = false;
        while (!result) {
            turn++;
            System.out.println("Turn " + turn + ":");
            result = play(secretCode);
        }
        System.out.println("Congratulations! You guessed the secret code.");


    }

    public static String generateSecretCode (int length) {

        StringBuilder code = new StringBuilder();
        while (code.length() < length) {
            StringBuilder pseudoRandomNumber = new StringBuilder(String.valueOf(System.nanoTime()));
            pseudoRandomNumber.reverse();

            for (int i = 0; i < pseudoRandomNumber.length(); i++) {
                if (code.length() == 0) {
                    if (pseudoRandomNumber.charAt(i) != '0') {
                        code.append(pseudoRandomNumber.charAt(i));
                        }
                    } else {
                    int digit = pseudoRandomNumber.charAt(i);
                    boolean checkEquality = false;
                    for (int j = 0; j < code.length(); j++) {
                        if (code.charAt(j) == digit) {
                            checkEquality = true;
                            break;
                        }
                    }
                    if (!checkEquality) {
                        code.append(pseudoRandomNumber.charAt(i));
                    }
                }


                // check code length inside for loop
                if (code.length() == length) {
                    break;
                }
            }
        }
        return code.toString();
    }

    // method with code from previous exercises
    public static boolean play (String secretCode) {

        int bulls = 0;
        int cows = 0;

        //Wait for the user input.
        Scanner scan = new Scanner(System.in);
        String userAnswerStr = scan.nextLine();

        // calculating bulls quantity
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == userAnswerStr.charAt(i)) {
                bulls++;
            }
            // and cows quantity
            for (int j = 0; j < userAnswerStr.length(); j++) {
                if (secretCode.charAt(i) == userAnswerStr.charAt(j) && j != i) {
                    cows++;
                }
            }
        }

        // grade the guessing attempt in bulls and cows.
        String grade = "";
        if (bulls > 0 && cows >0) {
            grade = bulls + " bull(s) and " + cows + " cow(s).";
        } else if (bulls == 0 && cows > 0) {
            grade = cows + " cow(s).";
        } else if (bulls == 0 && cows == 0) {
            grade = "None.";
        } else if (bulls > 0 && cows == 0) {
            grade = bulls + " bull(s).";
        }

        System.out.println("Grade: " + grade);
        if (bulls == secretCode.length()) {
            return true;
        } else {
            return false;
        }
    }
}
