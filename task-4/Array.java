import java.util.*;

public class Array {
    public static int removeDuplicates(int[] a, int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }

        a[j++] = a[n - 1];

        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in an array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Original array: ");
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(a));

        int newLength = removeDuplicates(a, n);

        System.out.print("Array with duplicates removed: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
