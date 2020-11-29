import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        String[] gcString = scan.nextLine().toLowerCase().split("");
        int gcQuantity = 0;
        for (int i = 0; i < gcString.length; i++) {
            if (gcString[i].equals("g") || gcString[i].equals("c")) {
                gcQuantity++;
            }
        }

        double result = (double) gcQuantity/gcString.length  * 100;
        System.out.println(result);
    }
}