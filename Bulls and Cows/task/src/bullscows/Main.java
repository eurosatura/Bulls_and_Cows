package bullscows;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int codeLength = scan.nextInt();
        System.out.println(generateSecretCode(codeLength));
    }
    public static String generateSecretCode (int length) {
        if (length > 10) {
            return "Error";
        }
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
    public static void previous () {
        int[] secretCode = {1, 2, 3, 4};
        String secretCodeStr = "";
        for (int i = 0; i < secretCode.length; i++) {
            secretCodeStr+=secretCode[i];
        }
        int bulls = 0;
        int cows = 0;
        Scanner scan = new Scanner(System.in);
        String userAnswerStr = scan.nextLine();
        String[] userAnswerArr = userAnswerStr.split("");
        int[] userAnswerInt = new int[userAnswerArr.length];
        for (int i = 0; i < userAnswerArr.length; i++) {
            userAnswerInt[i] = Integer.parseInt(userAnswerArr[i]);
        }
        for (int i = 0; i < secretCode.length; i++) {
            if (secretCode[i] == userAnswerInt[i]) {
                bulls++;
            }
            for (int j = 0; j < userAnswerInt.length; j++) {
                if (secretCode[i] == userAnswerInt[j] && j != i) {
                    cows++;
                }
            }
        }
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
        System.out.println("Grade: " + grade + " The secret code is " + secretCodeStr + ".");
    }
}
