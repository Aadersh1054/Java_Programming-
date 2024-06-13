import java.util.*;

public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += arr1[i--];
            if (j >= 0) carry += arr2[j--];
            result.add(0, carry & 1);
            carry = -(carry >> 1); // Divide by -2 (right shift)
        }

        // Remove leading zeros
        while (result.size() > 1 && result.get(0) == 0) {
            result.remove(0);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {1, 0, 1};
        int[] result = solution.addNegabinary(arr1, arr2);
        System.out.println(Arrays.toString(result));  // Output: [1, 0, 0, 0, 0]
    }
}
