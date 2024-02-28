import java.util.*;

public class Integer {
    public static int findMissingNumber(int[] arr) {
        int totalSum = 100 * (100 + 1) / 2;
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        return totalSum - arrSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        int missingNumber = 42;

        for (int i = 0, j = 1; i < 100; i++, j++) {
            if (j == missingNumber) {
                j++;
            }
            arr[i] = j;
        }

        System.out.println(Arrays.toString(arr));

        int missingNum = findMissingNumber(arr); // Corrected variable name
        System.out.println("The missing number is: " + missingNum); // Corrected variable name
    }
}
