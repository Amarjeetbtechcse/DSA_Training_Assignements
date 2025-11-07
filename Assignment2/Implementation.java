// Print N-bit Binary Numbers having more 1s than 0s
import java.util.*;

public class BinaryNumbers {
    static void generate(int n, int ones, int zeros, String curr) {
        if (n == 0) {
            System.out.println(curr);
            return;
        }
        generate(n - 1, ones + 1, zeros, curr + "1");
        if (ones > zeros)
            generate(n - 1, ones, zeros + 1, curr + "0");
    }

    public static void main(String[] args) {
        int n = 3;
        generate(n, 0, 0, "");
    }
}









// Delete Middle Element of a Stack using Backtracking
import java.util.*;

public class DeleteMiddleBacktracking {
    static void removeMiddle(Stack<Integer> st, int curr, int mid) {
        if (st.isEmpty()) return;

        int top = st.pop();

        if (curr != mid) removeMiddle(st, curr + 1, mid);

        if (curr != mid) st.push(top); // Backtrack: restore elements except middle one
    }

    public static void deleteMiddle(Stack<Integer> st) {
        int size = st.size();
        int mid = size / 2 + 1;
        removeMiddle(st, 1, mid);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i <= 5; i++) st.push(i);
        deleteMiddle(st);
        System.out.println(st);
    }
}












// Letter Combinations of a Phone Number (LeetCode – 17)
import java.util.*;

public class LetterCombinations {
    static void backtrack(String digits, int index, String curr, String[] map, List<String> res) {
        if (index == digits.length()) {
            res.add(curr);
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray())
            backtrack(digits, index + 1, curr + ch, map, res);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, "", map, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}











// Combinations (LeetCode – 77)
import java.util.*;

public class Combinations {
    static void helper(int n, int k, int start, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            helper(n, k, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}








// Letter Tile Possibilities (LeetCode – 1079)
import java.util.*;

public class LetterTile {
    static int count = 0;

    static void backtrack(char[] tiles, boolean[] used, String curr) {
        for (int i = 0; i < tiles.length; i++) {
            if (used[i]) continue;
            if (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            count++;
            backtrack(tiles, used, curr + tiles[i]);
            used[i] = false;
        }
    }

    public static int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        backtrack(arr, used, "");
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }
}







