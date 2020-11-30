import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int seedFrom = scanner.nextInt();
        int seedTo = scanner.nextInt();
        int numberInSequence = scanner.nextInt();
        int maxValue = scanner.nextInt();

        int[] result;
        result = getMaxAmongSeeds(seedFrom, seedTo, numberInSequence, maxValue);
        System.out.println(result[1]);
        System.out.println(result[0]);

    }

    public static int[] generateRandomArray(int seed, int numberInSequence, int maxValue) {
        int[] randomArray = new int[numberInSequence];
        Random random = new Random(seed);

        for (int i = 0; i < numberInSequence; i++) {
            randomArray[i] = random.nextInt(maxValue);
        }
        return randomArray;
    }

    public static int getMaxRandom(int numberInSequence, int maxValue, int seed) {
        int[] randomArray = generateRandomArray(seed, numberInSequence, maxValue);
        int max = randomArray[0];

        for (int i = 0; i < numberInSequence; i++) {
            if (randomArray[i] >  max) {
                max = randomArray[i];
            }
        }

        return max;
    }

    public static int[] getMaxAmongSeeds(int seedFrom, int seedTo, int numberInSequence, int maxValue) {
        int[] result = new int[2];
        result[0] = maxValue;
        for (int i = seedFrom; i <= seedTo; i++) {
            int tempRandom = getMaxRandom(numberInSequence, maxValue, i);
            if (tempRandom <  result[0]) {
                result[0] = tempRandom;
                result[1] = i;
            }
        }

        return result;
    }
}