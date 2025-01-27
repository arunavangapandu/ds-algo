import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static boolean wordBreak(String input, Set<String> wordDict ){

        if(input == null || input.isEmpty()) {
            return true;
        }

        if(wordDict == null || wordDict.isEmpty()) {
            return true;
        }
        //create a DP array to store whether a substring can be segmented
        boolean[] dp = new boolean[input.length()+1];
        dp[0] = true; // An empty string can always be segmented

        // Loop through the string and fill the dp array
        for(int i = 1; i <= input.length(); i++) {
        // check all possible word breaks at this position
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(input.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[input.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
     //   List<String> wordDict = Arrays.asList("leet", "code");
        HashSet<String> wordDict = new HashSet<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));  // Output: true
    }
}
