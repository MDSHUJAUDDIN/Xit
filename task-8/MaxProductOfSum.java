import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxProductOfSum {
    public static int maxProduct(int n) {
        int maxProd = 0;


        List<List<Integer>> combinations = generateCombinations(n, new ArrayList<>(), n, 1);


        for (List<Integer> combo : combinations) {
            int product = 1;
            for (int num : combo) {
                product *= num;
            }
            maxProd = Math.max(maxProd, product);
        }

        return maxProd;
    }

    private static List<List<Integer>> generateCombinations(int target, List<Integer> current, int remaining, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return result;
        }

        if (start > remaining) {
            return result;
        }

        for (int i = start; i <= remaining; i++) {
            current.add(i);
            result.addAll(generateCombinations(target, new ArrayList<>(current), remaining - i, i));
            current.remove(current.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();

        System.out.println("Maximum product for n = " + n1 + ": " + maxProduct(n1));
    }
}
