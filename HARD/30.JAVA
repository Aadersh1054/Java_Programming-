import java.util.*;

public class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, result, 0);
        return result;
    }

    private boolean backtrack(String num, List<Integer> result, int index) {
        if (index == num.length() && result.size() >= 3) {
            return true;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) {
                break; // Avoid leading zeros in numbers
            }

            long current = Long.parseLong(num.substring(index, i + 1));
            if (current > Integer.MAX_VALUE) {
                break; // Number exceeds 32-bit signed integer limit
            }

            int size = result.size();
            if (size >= 2 && current > result.get(size - 1) + result.get(size - 2)) {
                break; // Current number is greater than sum of last two numbers
            }

            if (size < 2 || current == result.get(size - 1) + result.get(size - 2)) {
                result.add((int) current);
                if (backtrack(num, result, i + 1)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitIntoFibonacci("1101111"));  // Output: [11, 0, 11, 11]
        System.out.println(solution.splitIntoFibonacci("112358130"));  // Output: []
        System.out.println(solution.splitIntoFibonacci("0123"));  // Output: []
    }
}
