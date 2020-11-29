import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        String busNumber = scan.nextLine();
        String[] busNumberStr = busNumber.split("");

        int[] busNumberInt = new int[busNumberStr.length];

        for (int i = 0; i < busNumberStr.length; i++) {
            busNumberInt[i] = Integer.parseInt(busNumberStr[i]);
        }
        int leftSum = busNumberInt[0] + busNumberInt[1] + busNumberInt[2];
        int rightSum = busNumberInt[3] + busNumberInt[4] + busNumberInt[5];
        if (leftSum == rightSum) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}