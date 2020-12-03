//put imports you need here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String[] room1 = scanner.nextLine().split(" ");
        String[] room2 = scanner.nextLine().split(" ");
        String[] room3 = scanner.nextLine().split(" ");
        String[] room4 = scanner.nextLine().split(" ");

        printPerson(room4);
        printPerson(room3);
        printPerson(room2);
        printPerson(room1);
    }

    public static void printPerson(String[] room) {
        for (int i = room.length - 1; i >= 0; i--) {
            System.out.println(room[i]);
        }
    }
}