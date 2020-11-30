class ArraySorting {
    /**
     * @param array unordered sequence of strings
     * @return ordered array of strings
     */
    public static String[] sortArray(String[] array) {
        // write your code here
        java.util.Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        String[] arraySorted = sortArray(array);

        for (String s : arraySorted) {
            System.out.print(s + " ");
        }
    }
}