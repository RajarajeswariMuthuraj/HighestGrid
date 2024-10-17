package com.grid.highest;

import java.util.*;

class Result {

    public static int findLargestSquareSize(List<List<Integer>> samples) {
        int n = samples.size();
        if (n == 0) return 0;

        // Create a DP table to store the size of the largest square ending at each point
        int[][] dp = new int[n][n];
        int maxSquareSize = 0;

        // Iterate through the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (samples.get(i).get(j) == 1) {
                    // For the first row or first column, the largest square is itself (1x1)
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Transition: min of top, left, and top-left + 1
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    // Update the maximum square size found
                    maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
                }
            }
        }

        return maxSquareSize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<List<Integer>> samples = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            samples.add(row);
        }
        
        int result = findLargestSquareSize(samples);
        System.out.println(result);
        
        scanner.close();
    }
}
