package Leetcode;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// 错误
public class Solution extends Relation {
    public int findCelebrity(int n) {
        for (i = 0; i < n; i++) {
            if (isCelebrity(i)) {
                return i;
            } else {
                return -1; // should be out of the loop to return -1
            }
        }

        isCelebrity(i) {
            for (j = 0; j < n; j++) {
                if (knows(i, j) = true || knows(j, i) = false) {
                    return false
                }
            }
            return true
        }
    }
}

//方法1：Brute Force
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i, n)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (knows(i, j) == true || knows(j, i) == false) {
                return false;
            }
        }
        return true;
    }
}

//方法2：擂台比武（i knows j意味着i不是，i 不knows j意味着j不是）
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // Compare and eliminate one that is not celebrity. Compare with the next number until reaching the last number.
        int candidate = 0;
        for (int j = 1; j < n; j++)
            if (knows(candidate, j)) {
                candidate = j; // We get a final candidate by linear comparison
            }

        // Check if the final candidate is the celebrity
        for (int k = 0; k < n; k++) {
            if (candidate == k) continue;
            if (knows(candidate, k) || !knows(k, candidate)) { // If it knows someone, or someone doesn't know it, it's not a celebrity
                return -1;
            }
        }
        return candidate;
    }
}