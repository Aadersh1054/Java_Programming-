import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        Set<Integer> next;

        for (int num : arr) {
            next = new HashSet<>();
            next.add(num);
            for (int prev : current) {
                next.add(prev | num);
            }
            result.addAll(next);
            current = next;
        }

        return result.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 2};
        System.out.println(solution.subarrayBitwiseORs(arr));  // Output: 3
    }
}
