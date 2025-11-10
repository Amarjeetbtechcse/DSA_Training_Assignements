import java.util.*;

public class Implementation {

    // 1. Word Break (LeetCode 139)
    static class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            return helper(s, new HashSet<>(wordDict), 0);
        }
        private boolean helper(String s, Set<String> dict, int start) {
            if (start == s.length()) return true;
            for (int end = start + 1; end <= s.length(); end++) {
                if (dict.contains(s.substring(start, end)) && helper(s, dict, end))
                    return true;
            }
            return false;
        }
    }

    // 2. Word Break II (LeetCode 140)
    static class Solution2 {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            backtrack(s, new HashSet<>(wordDict), 0, new ArrayList<>(), res);
            return res;
        }
        private void backtrack(String s, Set<String> dict, int start, List<String> path, List<String> res) {
            if (start == s.length()) {
                res.add(String.join(" ", path));
                return;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                String word = s.substring(start, end);
                if (dict.contains(word)) {
                    path.add(word);
                    backtrack(s, dict, end, path, res);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    // 3. N-Queens II (LeetCode 52)
    static class Solution3 {
        int count = 0;
        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            solve(board, 0, n);
            return count;
        }
        private void solve(char[][] board, int row, int n) {
            if (row == n) {
                count++;
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isSafe(board, row, col, n)) {
                    board[row][col] = 'Q';
                    solve(board, row + 1, n);
                    board[row][col] = '.';
                }
            }
        }
        private boolean isSafe(char[][] board, int row, int col, int n) {
            for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) if (board[i][j] == 'Q') return false;
            return true;
        }
    }

    // 4. Sudoku Solver (LeetCode 37)
    static class Solution4 {
        public void solveSudoku(char[][] board) {
            solve(board);
        }
        private boolean solve(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isSafe(board, i, j, c)) {
                                board[i][j] = c;
                                if (solve(board)) return true;
                                board[i][j] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }
        private boolean isSafe(char[][] board, int r, int c, char ch) {
            for (int i = 0; i < 9; i++) {
                if (board[r][i] == ch || board[i][c] == ch) return false;
                int br = 3 * (r / 3) + i / 3;
                int bc = 3 * (c / 3) + i % 3;
                if (board[br][bc] == ch) return false;
            }
            return true;
        }
    }

    // 5. Merge Sort (Recursion + Backtracking)
    static class Solution5 {
        public void mergeSort(int[] arr, int l, int r) {
            if (l >= r) return;
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
        private void merge(int[] arr, int l, int mid, int r) {
            int[] temp = new int[r - l + 1];
            int i = l, j = mid + 1, k = 0;
            while (i <= mid && j <= r) temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            while (i <= mid) temp[k++] = arr[i++];
            while (j <= r) temp[k++] = arr[j++];
            for (i = 0; i < temp.length; i++) arr[l + i] = temp[i];
        }
    }

    // 6. Quick Sort (Recursion + Backtracking)
    static class Solution6 {
        public void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int p = partition(arr, low, high);
                quickSort(arr, low, p - 1);
                quickSort(arr, p + 1, high);
            }
        }
        private int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
                }
            }
            int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
            return i + 1;
        }
    }

    // Optional main method for quick testing
    public static void main(String[] args) {
        System.out.println("All recursive + backtracking solutions implemented.");
    }
}
