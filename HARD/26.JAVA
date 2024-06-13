import java.util.*;

class WordFilter {
    private Map<String, Integer> wordIndices;

    public WordFilter(String[] words) {
        wordIndices = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                for (int k = 0; k <= word.length(); k++) {
                    String key = word.substring(0, j) + "#" + word.substring(k);
                    wordIndices.put(key, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String key = pref + "#" + suff;
        return wordIndices.getOrDefault(key, -1);
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "pineapple"};
        WordFilter wf = new WordFilter(words);
        System.out.println(wf.f("app", "e"));  // Output: 0 (apple)
        System.out.println(wf.f("ban", ""));   // Output: 1 (banana)
        System.out.println(wf.f("", "ple"));   // Output: 0 (apple)
        System.out.println(wf.f("pi", "e"));   // Output: 3 (pineapple)
        System.out.println(wf.f("kiwi", ""));  // Output: -1 (not found)
    }
}
