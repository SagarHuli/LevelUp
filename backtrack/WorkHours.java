package backtrack;

import java.util.ArrayList;
import java.util.List;

public class WorkHours {
    public static void main(String[] args) {
        String s = "352##9#";
        int n = 25;
        List<String> res = new ArrayList<>();
        getHours(s,n, s.length()-1, 0, res, new StringBuilder());
        System.out.println(res);
    }

    private static void getHours(String s, int n, int idx, int curr, List<String> list,StringBuilder sb) {
        if(curr > n) return;
        if(idx < 0) {
            if(curr == n) {
                StringBuilder str = new StringBuilder(sb);
                list.add(str.reverse().toString());
            }
        }
        else {
            if(s.charAt(idx) == '#') {
                for(int i = 0; i<=9; i++) {
                    getHours(s, n, idx-1, curr + i, list, sb.append(i));
                    sb.replace(sb.length()-1, sb.length(), "");
                }
            } else {
                getHours(s, n, idx-1, curr + s.charAt(idx)-'0', list, sb.append(s.charAt(idx)));
                sb.replace(sb.length()-1, sb.length(), "");
            }
        }

    }


    // optimised
    public class Main {
        public static void main(String[] args) {
            String s = "352##9#";
            int n = 25;
            List<String> res = new ArrayList<>();

            // Pre-calculate fixed digit sum and hash count for pruning
            int fixedSum = 0;
            int totalHashes = 0;
            for (char c : s.toCharArray()) {
                if (c == '#') totalHashes++;
                else fixedSum += (c - '0');
            }

            // We need the '#' symbols to sum up to exactly this target
            int targetForHashes = n - fixedSum;

            generate(s, 0, targetForHashes, totalHashes, res, new StringBuilder());
            System.out.println(res);
        }

        private static void generate(String s, int idx, int targetRemaining, int hashesLeft, List<String> list, StringBuilder sb) {
            // 1. PRUNING: Is the target even reachable with the remaining '#'?
            if (targetRemaining < 0 || targetRemaining > (hashesLeft * 9)) {
                return;
            }

            // 2. BASE CASE: End of string reached
            if (idx == s.length()) {
                if (targetRemaining == 0) {
                    list.add(sb.toString());
                }
                return;
            }

            char c = s.charAt(idx);
            if (c == '#') {
                for (int i = 0; i <= 9; i++) {
                    sb.append(i);
                    generate(s, idx + 1, targetRemaining - i, hashesLeft - 1, list, sb);
                    sb.setLength(sb.length() - 1); // Fast backtrack
                }
            } else {
                sb.append(c);
                generate(s, idx + 1, targetRemaining, hashesLeft, list, sb);
                sb.setLength(sb.length() - 1); // Fast backtrack
            }
        }
    }


    // optimised without uising stringbuilder
    public class StringSumSolver {

        public static void main(String[] args) {
            String s = "352##9#";
            int n = 25;

            List<String> results = findCombinations(s, n);

            System.out.println("Total combinations: " + results.size());
            for (String combo : results) {
                System.out.println(combo);
            }
        }

        public static List<String> findCombinations(String s, int n) {
            List<String> results = new ArrayList<>();
            int currentSum = 0;
            List<Integer> hashIndices = new ArrayList<>();
            char[] chars = s.toCharArray();

            // 1. Identify '#' positions and calculate the sum of existing digits
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '#') {
                    hashIndices.add(i);
                } else {
                    currentSum += Character.getNumericValue(chars[i]);
                }
            }

            int targetNeeded = n - currentSum;

            // 2. Start the recursive backtracking
            backtrack(chars, hashIndices, 0, targetNeeded, results);
            return results;
        }

        private static void backtrack(char[] chars, List<Integer> hashIndices, int index, int remaining, List<String> results) {
            // Base Case: All '#' slots filled
            if (index == hashIndices.size()) {
                if (remaining == 0) {
                    results.add(new String(chars));
                }
                return;
            }

            // Optimization: Prune the search if remaining sum is impossible
            int slotsLeft = hashIndices.size() - index;
            if (remaining < 0 || remaining > slotsLeft * 9) {
                return;
            }

            // Try digits 0-9 for the current '#' position
            int currentHashPos = hashIndices.get(index);
            for (int d = 0; d <= 9; d++) {
                chars[currentHashPos] = (char) (d + '0');
                backtrack(chars, hashIndices, index + 1, remaining - d, results);
            }
        }
    }
}

