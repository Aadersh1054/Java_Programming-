public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 1};
        int[] result = threeEqualParts(arr);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public static int[] threeEqualParts(int[] arr) {
        int countOnes = 0;
        for (int num : arr) {
            countOnes += num;
        }

        if (countOnes % 3 != 0) {
            return new int[]{-1, -1};
        }

        if (countOnes == 0) {
            return new int[]{0, arr.length - 1};
        }

        int onesInEachPart = countOnes / 3;
        int part1End = findEndIndex(arr, 0, onesInEachPart);
        int part2Start = findStartIndex(arr, part1End + 1);
        int part2End = findEndIndex(arr, part2Start, onesInEachPart);
        int part3Start = findStartIndex(arr, part2End + 1);

        while (part3Start < arr.length && arr[part3Start] == 0) {
            part3Start++;
        }

        if (part3Start == arr.length) {
            return new int[]{part1End, part2End + 1};
        }

        int part1 = binaryToInt(arr, 0, part1End);
        int part2 = binaryToInt(arr, part2Start, part2End);
        int part3 = binaryToInt(arr, part3Start, arr.length - 1);

        if (part1 == part2 && part2 == part3) {
            return new int[]{part1End, part2End + 1};
        }

        return new int[]{-1, -1};
    }

    private static int findEndIndex(int[] arr, int start, int count) {
        int end = start;
        while (count > 0) {
            if (arr[end] == 1) {
                count--;
            }
            end++;
        }
        return end - 1;
    }

    private static int findStartIndex(int[] arr, int start) {
        while (start < arr.length && arr[start] == 0) {
            start++;
        }
        return start;
    }

    private static int binaryToInt(int[] arr, int start, int end) {
        int result = 0;
        for (int i = start; i <= end; i++) {
            result = result * 2 + arr[i];
        }
        return result;
    }
}