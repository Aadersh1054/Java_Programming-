class NumArray {
    private int[] nums;
    private int[] prefixSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        for (int i = index + 1; i < prefixSum.length; i++) {
            prefixSum[i] += diff;
        }
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));  // Output: 9
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));  // Output: 8
    }
}
