class BinarySearch {
    /**
     * @param nums ordered sequence of integers
     * @param key  an element for searching
     * @return index of key or a negative value
     */
    public static int callBinarySearch(int[] nums, int key) {
        // write your code here
        return java.util.Arrays.binarySearch(nums, key);
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String arrayStr = scanner.nextLine();
        int digit = scanner.nextInt();
        String[] arrayArr = arrayStr.split(" ");
        int[] arrayInt = new int[arrayArr.length];
        for (int i = 0; i < arrayArr.length; i++) {
            arrayInt[i] = Integer.parseInt(arrayArr[i]);
        }
        System.out.println(callBinarySearch(arrayInt, digit));
    }
}